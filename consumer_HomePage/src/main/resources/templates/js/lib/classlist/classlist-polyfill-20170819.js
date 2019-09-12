/**
 * 
 * Polyfill Element.classList
 * 
 *      add(String[, String])           添加指定的类值
 *      remove(String[, String])        删除指定的类值
 *      item(Number)                    按集合中的索引返回类值
 *      toggle(String[, force])         切换指定的类值
 *      contains(String)                检查元素的类属性中是否存在指定的类值
 * 
 * @兼容 PC: IE 8+
 * 
 * Created by jackie on 2018/11/13
 * 
 */
~ function () {

    "use strict";

    if (document.createElement("div").classList) return; // 浏览器支持原生classList

    // polyfill start

    /**
     * 
     * 移除字符串两边的空格
     * 
     */
    var trim = String.prototype.trim || function () {
        return this.replace(/^\s+|\s+$/g, "");
    };

    /**
     * 
     * 函数构造器
     * 
     * @param {HTMLNode} node 元素节点
     *
     * @依赖 trim
     * 
     */
    var ClassList = function (node) {

        var classStr = trim.call(node.getAttribute("class") || "");
        var classList = classStr && classStr.split(/\s+/);

        for (var i = 0, len = classList.length; i < len; i++) this.push(classList[i]);

        this._update = function () {
            node.setAttribute("class", this.join(" "));
        }
    };

    ClassList.prototype = [];

    /**
     * 
     * 添加一个或多个class, 逗号分隔
     * 
     * @param {String} (string[, string]) 样式类名称
     *
     * @说明 通过 arguments 获取实参
     * @依赖 contains
     * 
     */
    ClassList.prototype.add = function () {

        var classList = arguments;
        var className;

        for (var i = 0, len = classList.length; i < len; i++) {
            className = classList[i];
            !this.contains(className) && this.push(className);
        };

        this._update();
    };

    /**
     * 
     * 删除一个或多个class, 逗号分隔
     * 
     * @param {String} (string[, string]) 样式类名称
     *
     * @说明 通过 arguments 获取实参
     * @依赖 无
     * 
     */
    ClassList.prototype.remove = function () {

        var classList = arguments;
        var index;

        for (var i = 0, len = classList.length; i < len; i++) {
            index = this.indexOf(classList[i]);
            index >= 0 && this.splice(index, 1);
        };

        this._update();
    };

    /**
     * 
     * 按集合中的索引返回类值
     * 
     * @param {Number} index 索引值
     *
     * @依赖 无
     * 
     */
    ClassList.prototype.item = function (index) {
        return this[index] || null;
    };

    /**
     * 
     * 1、当只有一个参数时：切换 class value; 即如果类存在，则删除它并返回false，如果不存在，则添加它并返回true
     * 2、当存在第二个参数时：如果第二个参数的计算结果为true，则添加指定的类值，如果计算结果为false，则删除它
     * 
     * @param {String} className 类名称
     * @param {Boolean} force 限制条件
     *
     * @依赖 contains、add、remove
     * 
     */
    ClassList.prototype.toggle = function (className, force) {

        if (typeof className !== 'string') return;

        var result = this.contains(className);
        var method = result ? (force !== true && "remove") : (force !== false && "add");

        if (method) this[method](className);

        if (force === true || force === false) return force;
        else return !result;
    };

    /**
     * 
     * 检查元素的类属性中是否存在指定的类值
     * 
     * @param {String} className 类名称
     *
     * @依赖 无
     * 
     */
    ClassList.prototype.contains = function (className) {

        if (typeof className !== 'string') return;
        else return this.indexOf(className) !== -1;
    };

    /**
     * 
     * define classList
     * 
     */
    var target = Element.prototype;

    var defineProperty = Object.defineProperty;

    if (defineProperty) {
        var descriptor = {
            enumerable: false, // IE 8 doesn't support enumerable:true
            configurable: true,
            get: function () {
                return new ClassList(this);
            }
        };
        defineProperty(target, 'classList', descriptor);
    } else if (Object.prototype.__defineGetter__) { // IE6+
        target.__defineGetter__('classList', function () {
            return new ClassList(this);
        })
    }

    console.log('Polyfill classlist is completed.');

}()
$(function () {
    function a(a) {
        "true" == a ? ($(" #verifyCode").show(), $(".dalog #verifyCode").show()) : ($(" #verifyCode").hide(), $(".dalog #verifyCode").hide())
    }

    function b(a, b) {
        var d = $(".dialog input[name='verifyCode']"), e = $(".dialog .feedbackContent"), f = $(".dialog .contactInfo"),
            g = $.trim(f.val()),
            h = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return $.trim(e.val()) ? g ? /^[0-9]+$/.test(g) || h.test(g) ? "true" != a || $.trim(d.val()) ? !0 : ($(d).focus(), $(".dialog .warnning").text("验证码不能为空！"), !1) : ($(f).focus(), $(".dialog .warnning").text("联系方式格式不正确！"), !1) : ($(f).focus(), $(".dialog .warnning").text("请留下您的联系方式，手机号或者email！"), !1) : ($(e).focus(), $(".dialog .warnning").text(b == c ? "请留下您的反馈意见！" : "请留下您的问题！"), !1)
    }

    var c = 1, d = 2;
    $.extend({
        feeddialog: function (a) {
            a = {
                title: a.title || "提示",
                element: a.element,
                content: a.content,
                width: a.width || "",
                height: a.height || "",
                mask: a.mask || "true",
                type: a.type || c,
                onClose: a.onClose,
                callback: a.callback,
                productId: a.productId
            }, "true" == a.mask && ($("<div></div>").addClass("dialogMask").appendTo("body"), $(".dialogMask").css({
                width: $(window).width(),
                height: $(document).height(),
                zIndex: 98
            })), $("<div></div>").addClass("dialog").appendTo("body"), $("<span></span>").addClass("close").appendTo($(".dialog")), $("<div></div>").addClass("dialog-box").appendTo($(".dialog")), $("<div></div>").addClass("dialog-cont").appendTo($(".dialog-box"));
            var b = a.element.clone(!0, !0);
            $(".dialog-cont").append(b), a.type == d && ($(".dialog [data-title]").text("在线问答"), $(".dialog [data-content]").attr("placeholder", "请输入您的咨询内容，不超过100字").attr("maxlength", 100), $(".dialog #totalCount").text("您还可以输入100个字符")), b.show(), $(".close").click(function () {
                $(this).closest(".dialog").remove(), $(".dialogMask").remove(), a.onClose && "function" == typeof a.onClose && a.onClose()
            }), "" != a.width && $(".dialog").css({width: a.width}), "" != a.height && $(".dialog").css({height: a.height});
            {
                var e = $(".dialog").outerHeight(), f = $(".dialog").outerWidth();
                $(window).height()
            }
            $(".dialog").css({
                position: "fixed",
                left: "50%",
                "margin-left": -f / 2,
                top: "50%",
                marginTop: -e / 2,
                zIndex: 99
            }), a.callback && "function" == typeof a.callback && a.callback(a.type, a.productId)
        }
    }), $(".linkFeedback").on("click", function () {
        $.feeddialog({element: $("#feedBackDialog"), callback: e}), $(this).blur()
    }), $("[data-qa-popup]").click(function () {
        var a = $(this).attr("data-product-id");
        $.feeddialog({element: $("#feedBackDialog"), callback: e, type: d, productId: a})
    });
    var e = function (e) {
        var f = $("#showCode").val();
        if (a(f), "true" == f) {
            var g = new Date;
            $(".dialog #img_verifycode_feedback").attr("src", webRoot + "/verifyCode?" + g.getTime())
        }
        $(".dialog  #cancelBut").on("click", function () {
            $(".dialog .close").click()
        }), $(".dialog  #img_verifycode_feedback").click(function () {
            var a = new Date;
            $(".dialog #img_verifycode_feedback").attr("src", webRoot + "/verifyCode?" + a.getTime())
        }), $(".dialog  .feedbackContent").keyup(function () {
            var a = e == c ? 500 : 100, b = $(this).val(), d = b.length;
            return d >= a ? ($(".dialog #totalCount").text("您还可以输入0个字符"), $(this).text(b.substring(0, a)), !1) : void $(".dialog #totalCount").text("您还可以输入" + (a - d) + "个字符")
        }), $(".dialog  #save").on("click", function () {
            if (!$(this).data("clicked")) {
                if ($(".dialog .warnning").text(""), !b(f, e)) return !1;
                $(this).data("clicked", !0), $(this).text("提交中..."), $(this).removeClass("btn-normal-blue"), $(this).addClass("btn-grey");
                var a = $(".dialog input[name='verifyCode']").val(), g = $(".dialog .feedbackContent").val(),
                    h = $(".dialog .contactInfo").val(), i = encodeURIComponent(location.href), j = $(this),
                    k = {feedbackContent: $.trim(g), contactInfo: $.trim(h), verifyCode: $.trim(a), locationUrl: i},
                    l = webRoot + (e == c ? "/feedback/save" : "/qa/save");
                e == d && (k.productId = window.productId), $.ajax({
                    url: l,
                    data: k,
                    method: "post",
                    success: function (a) {
                        return a.data && $("#showCode").val(a.data.showCode), a.code > -1 ? void (a.data && a.data.ret > 0 ? ($(".dialog .close").click(), $.feeddialog(e == c ? {element: $("#feedbackErrorDialog")} : {element: $("#qaErrorDialog")})) : ($(j).removeClass("btn-grey"), $(j).addClass("btn-normal-blue"), $(j).removeData("clicked"), $(j).text("提交"), $(".dialog .warnning").text(e == c ? "反馈出错啦！" : "提问出错啦！"))) : ($(j).removeClass("btn-grey"), $(j).addClass("btn-normal-blue"), $(j).removeData("clicked"), $(j).text("提交"), void $(".dialog .warnning").text(a.msg))
                    }
                })
            }
        })
    }
});
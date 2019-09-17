/*
 * author : winson.wang
 * createDate: 2014-12
 * email : wangdaowei1985@aliyun.com
 * qq : 57138854
*/
$.fn.extend({
	location:function(opt){
		if(!opt) opt = {};
		opt = {
			oldValue : opt.oldValue || '拼音/汉字/三字码',
			tShow    : opt.tShow || false,//是否显示插件标题
			title    : opt.title || '可直接输入城市、拼音、英文',//插件标题
			format   : opt.format || '',
			iptValueClass   : opt.iptValueClass || '',
			data     : opt.data || defaultData
		}
		var group=[]
		for(var i=0;i<opt.data.length;i++){
			if (opt.data[i].pid=='-1') {
				var temp={}
				temp.id = opt.data[i].id;
				temp.name = opt.data[i].name;
				temp.url = opt.data[i].url;
				group.push(temp);
			}
		}

		var fuzzyIpt = $(this);
		
		//给数据加上分组groupid
		for(var i=0,len = opt.data.length;i<len;i++){
			if(opt.data[i]!='-1'){
				for(var j = 0; j < group.length; j++){
					if(group[j].id == opt.data[i].pid){
						opt.data[i].groupId = j;
					}
				}
			}
		}

		$(this).on('focus',function(e){
			$(this).attr('t_popup','0');
			fuzzy_chose($(this));
		})
		
		function fuzzy_chose(element){
			
			var reltop = element.offset().top;
			var relleft = element.offset().left;
			var relheight = element.outerHeight();

			$('#popup_pane').remove();
			$('.serch_box').append($('<div id="popup_pane" class="popup_pane" oncopy="return false;">').css({left: 20, top: 46}).show());

			//添加标题
			if(opt.tShow){
				$('#popup_pane').append($('<h3></h3>').html(opt.title));
			}

			//添加插件框体
			//$('#popup_pane').append('<div class="country">热门国家</div>');
			//$('#popup_pane').append($('<div></div>').attr('id','popup_pane_head').append($('<ul></ul>').addClass('popup_title')));
			$('#popup_pane').append('<div class="city">热门城市</div>');
			$('#popup_pane').append($('<ul></ul>').attr('id','popup_content'));

			//添加插件头部
			for(var i = 0; i < opt.data.length; i++){
					$('<li>'+'<span id="'+opt.data[i].id+'">'+opt.data[i].name+'</span>'+'</li>').on('click',function(e){fuzzyIpt.val($(this).text());$('#popup_pane').remove();fuzzyIpt.removeAttr('style');}).appendTo('#popup_content');
			}
		}

		// 点击文档的其它部分关闭插件
		$(document).click(function(e){
			var btn_flag = $(e.target).attr('t_popup');
			var div_flag = $(e.target).closest('.popup_pane').hasClass('popup_pane');
			if(!(btn_flag == '0' || div_flag)){
				$('.popup_pane').remove();
			}
			if(e.target != fuzzyIpt.get(0)) {
				if(fuzzyIpt.attr('id') == 'searchText' && fuzzyIpt.val() == '') {
					fuzzyIpt.val('目的地/酒店名称');
				}
			}
		});

		$(this).on('keyup',function(e){
			var code = e.keyCode;
			if($(this).val() == '' || !$(this).val()){
				$(this).attr('t_popup','0');
				fuzzy_chose($(this));
			}else{
				$('.popup_pane').remove();
				if(fuzzyIpt.attr('id') == 'searchText' && fuzzyIpt.val() != '') {
					fuzzyIpt.removeAttr('style');
				}
			}
		})


		//模糊输入部分
		/*
		var a_page = 1;//当前页
		var a_totalPage = 1;//总页数
		var count = 0;//
		var curTxt;//当前键盘操作后的值

		function fuzzy_init(){
			var len = defaultData.length;
			for(var i=0; i<len; i++){
				var t_id = Math.ceil((i+1)/10);
				$('#air_tips_info').append(
					$('<li t_id='+t_id+' t_value='+defaultData[i].url+' t_name='+defaultData[i].name+'><div class="f-left">'+defaultData[i].name+' '+defaultData[i].eName+'</div><div class="f-right">'+defaultData[i].cName+'</div></li>').on('mouseenter',function(){
						$(this).addClass('cur');
					}).on('mouseleave',function(event) {
						$(this).removeClass('cur');
					}).on('click', function(event) {
						fuzzyIpt.val($(this).attr('t_name')).attr('t_value',$(this).attr('t_value'));
						$('#air_down_tips').remove();
					})
				);
			}
			$('#air_b_pager').hide();
		}

		function fuzzy_create(element){
			$('#air_down_tips').remove();
			var tops = element.offset().top;
			var left = element.offset().left;
			var h = tops + element.outerHeight();
			var html = '<div id="air_down_tips" class="air_down_tips"><div class="a_top_title"><div id="a_error_info"></div>请输入/拼音/三字码，用↑↓← →选择</div><ul id="air_tips_info"></ul><div id="air_b_pager"></div></div>';
			$('body').append(html);
			$('#air_down_tips').css({left: left, top: h});

			if(element.val() == ''){
				fuzzy_init(); //输入框无数据时候初始化数据
			}else{
				reload_data(element.val().toUpperCase());//输入框有数据时候的匹配
			}
		}

		//输入框有数据时候的匹配
		function reload_data(str){
			var len = opt.data.length;
			var l = 0;//记录匹配到的数据条数
			for(var i=0;i<len;i++){
				var e_flag = opt.data[i].eName.toUpperCase().indexOf(str)>=0;
				var n_flag = opt.data[i].name.indexOf(str)>=0;
				var c_flag = opt.data[i].cName.toUpperCase().indexOf(str)>=0;
				if(e_flag || n_flag || c_flag){
					l = l + 1;
					var t_id = Math.ceil(l/10);
					$('#air_tips_info').append(
						$('<li t_id='+t_id+' t_value='+opt.data[i].url+' t_name='+opt.data[i].name+'><div class="f-left">'+opt.data[i].name+'</div><div class="f-right">'+opt.data[i].eName+'</div></li>').on('mouseenter',function(){
							$(this).addClass('cur');
						}).on('mouseleave',function(event) {
							$(this).removeClass('cur');
						}).on('click', function(event) {
							fuzzyIpt.val($(this).attr('t_name')).attr('t_value',$(this).attr('t_value'));
							$('#air_down_tips').remove();
						})
					);
				}
			}
			$('#air_tips_info li[t_id=1]').eq(0).addClass('cur');
			curTxt = $('#air_tips_info li[t_id=1]').eq(0).attr('t_name');
			curValue = $('#air_tips_info li[t_id=1]').eq(0).attr('t_value');

			a_totalPage = (l % 10 == 0) ? (l / 10) : Math.floor(l / 10) + 1;

			if(l > 10){
				$('#air_b_pager').text(a_page+'/'+a_totalPage);
				$('#air_b_pager').show();
				$('#a_error_info').hide();
			}else if (l > 0) {

				$('#air_b_pager,#a_error_info').hide();
			}else{
				$('#a_error_info').html('对不起，找不到：'+str).show();
				$('#air_b_pager').hide();
			}
		}

		$(this).on('keyup',function(e){
			var code = e.keyCode;
			if(code == 37){
				if(a_totalPage != 1){
					prev_();
				}
			}else if(code == 38){
				up_();
			}else if(code == 39){
				if(a_totalPage != 1){
					next_();
				}
			}else if(code == 40){
				down_();
			}else if(code == 13){
				fuzzyIpt.val(curTxt).attr('t_value',curValue);
				$('#air_down_tips').remove();
			}else{
					fuzzy_chose($(this));

			}
		})


		//上下左右翻页

		//前一页
		function prev_(){
			a_page = (a_page > 1) ? (a_page - 1) : a_totalPage;
			$('#air_tips_info li').removeClass('cur').hide();
			$('#air_tips_info li[t_id='+a_page+']').show().eq(0).addClass('cur');
			curTxt = $('#air_tips_info li[t_id='+a_page+']').eq(0).attr('t_name');
			curValue = $('#air_tips_info li[t_id='+a_page+']').eq(0).attr('t_value');
			$('#air_b_pager').text(a_page+'/'+a_totalPage);
			count=0;
		}
		//后一页
		function next_(){
			a_page = (a_page < a_totalPage) ? (a_page + 1) : 1;
			$('#air_tips_info li').removeClass('cur').hide();
			$('#air_tips_info li[t_id='+a_page+']').show().eq(0).addClass('cur');
			curTxt = $('#air_tips_info li[t_id='+a_page+']').eq(0).attr('t_name');
			curValue = $('#air_tips_info li[t_id='+a_page+']').eq(0).attr('t_value');
			$('#air_b_pager').text(a_page+'/'+a_totalPage);
			count=0;
		}
		function up_(){
			count--;
			$('#air_tips_info li').hide();
			$('#air_tips_info li[t_id='+a_page+']').show();
			if(count < 0){
				count = $('#air_tips_info li[t_id='+a_page+']').length-1;
			}
			$('#air_tips_info li[t_id='+a_page+']').removeClass('cur').eq(count).addClass('cur');
			curTxt = $('#air_tips_info li[t_id='+a_page+']').eq(count).attr('t_name');
			curValue = $('#air_tips_info li[t_id='+a_page+']').eq(count).attr('t_value');
		}
		function down_(){
			count++;
			var max_l = $('#air_tips_info li[t_id='+a_page+']').length-1;
			$('#air_tips_info li').hide();
			$('#air_tips_info li[t_id='+a_page+']').show();
			if(count > max_l){
				count = 0;
			}
			$('#air_tips_info li[t_id='+a_page+']').removeClass('cur').eq(count).addClass('cur');
			curTxt = $('#air_tips_info li[t_id='+a_page+']').eq(count).attr('t_name');
			curValue = $('#air_tips_info li[t_id='+a_page+']').eq(count).attr('t_value');
		}*/
		
		// 点击文档的其它部分关闭插件
		$(document).click(function(e){
			var btn_flag = $(e.target).attr('t_popup');
			var flag = $(e.target).closest('#air_down_tips').hasClass('air_down_tips');
			if(!(btn_flag == '0' || flag)){
				$('#air_down_tips').remove();
			}
		})
	}
})
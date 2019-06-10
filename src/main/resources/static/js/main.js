$(function() {
	
	//鼠标事件
	$(".expand").click(function() {
		
		if($(this).hasClass("rotate1")){//折叠
　　　　　　　　$(this).removeClass("rotate1").addClass("rotate");
　　　　　}else{//展开
　　　　　　$(this).removeClass("rotate").addClass("rotate1");
　　　　　}
$(this).parent().next().slideToggle();
	})
	
	$(".main_title").mouseover(function() {
		$(this).css("border","1px solid #c2d5f2");
	})
	$(".main_title").mouseout(function() {
		$(this).css("border","1px solid #e6e6e6");
	})
	$(".main_title").click(function() {
		$(".leftList div").removeClass("active");
		$(".leftList td").removeClass("active");
		$(this).addClass("active");
		
	})
	$(".sub_title ").click(function() {
		$(".leftList div").removeClass("active");
		$(".leftList td").removeClass("active");
		$(this).addClass("active");
	})
	$(".sub_title ").mouseover(function() {
		$(this).css("border","1px solid #c2d5f2");
	})
	$(".sub_title ").mouseout(function() {
		$(this).css("border","1px solid #e6e6e6");
	})
	$(".main_title.abstract").click(function() {
		 $("html, body").animate({
      scrollTop: $("#abstract_cn").offset().top-40 }, {duration: 500,easing: "swing"});
    return false;
	})
	$(".main_title.abstract_en").click(function() {
		 $("html, body").animate({
      scrollTop: $("#abstract_en").offset().top-40 }, {duration: 500,easing: "swing"});
    return false;
	})
	$(".main_title.1").click(function() {
		 $("html, body").animate({
      scrollTop: $("#1").offset().top-40 }, {duration: 500,easing: "swing"});
    return false;
	})
	$(".main_title.2").click(function() {
		 $("html, body").animate({
      scrollTop: $("#2").offset().top-40 }, {duration: 500,easing: "swing"});
    return false;
	})
	$(".main_title.3").click(function() {
		 $("html, body").animate({
      scrollTop: $("#3").offset().top-40 }, {duration: 500,easing: "swing"});
    return false;
	})
	$(".main_title.4").click(function() {
		 $("html, body").animate({
      scrollTop: $("#4").offset().top-40 }, {duration: 500,easing: "swing"});
    return false;
	})
	$(".main_title.5").click(function() {
		 $("html, body").animate({
      scrollTop: $("#5").offset().top-40 }, {duration: 500,easing: "swing"});
    return false;
	})
	$(".main_title.6").click(function() {
		 $("html, body").animate({
      scrollTop: $("#6").offset().top-40 }, {duration: 500,easing: "swing"});
    return false;
	})
	$(".main_title.7").click(function() {
		 $("html, body").animate({
      scrollTop: $("#7").offset().top-40 }, {duration: 500,easing: "swing"});
    return false;
	})
	$(".main_title.8").click(function() {
		 $("html, body").animate({
      scrollTop: $("#8").offset().top-40 }, {duration: 500,easing: "swing"});
    return false;
	})
	$(".main_title.9").click(function() {
		 $("html, body").animate({
      scrollTop: $("#9").offset().top-40 }, {duration: 500,easing: "swing"});
    return false;
	})
	$(".sub_title.1_1").click(function() {
		 $("html, body").animate({
      scrollTop: $("#1_1").offset().top-40 }, {duration: 500,easing: "swing"});
    return false;
	})
	$(".sub_title.1_2").click(function() {
		 $("html, body").animate({
      scrollTop: $("#1_2").offset().top-40 }, {duration: 500,easing: "swing"});
    return false;
	})
	$(".sub_title.1_3").click(function() {
		 $("html, body").animate({
      scrollTop: $("#1_3").offset().top-40 }, {duration: 500,easing: "swing"});
    return false;
	})
	$(".sub_title.2_1").click(function() {
		 $("html, body").animate({
      scrollTop: $("#2_1").offset().top-40 }, {duration: 500,easing: "swing"});
    return false;
	})
	$(".sub_title.2_2").click(function() {
		 $("html, body").animate({
      scrollTop: $("#2_2").offset().top-40 }, {duration: 500,easing: "swing"});
    return false;
	})
	$(".sub_title.4_1").click(function() {
		 $("html, body").animate({
      scrollTop: $("#4_1").offset().top-40 }, {duration: 500,easing: "swing"});
    return false;
	})
	$(".sub_title.4_2").click(function() {
		 $("html, body").animate({
      scrollTop: $("#4_2").offset().top-40 }, {duration: 500,easing: "swing"});
    return false;
	})
	$(".sub_title.4_3").click(function() {
		 $("html, body").animate({
      scrollTop: $("#4_3").offset().top-40 }, {duration: 500,easing: "swing"});
    return false;
	})
	$(".sub_title.5_1").click(function() {
		 $("html, body").animate({
      scrollTop: $("#5_1").offset().top-40 }, {duration: 500,easing: "swing"});
    return false;
	})
	$(".sub_title.5_2").click(function() {
		 $("html, body").animate({
      scrollTop: $("#5_2").offset().top-40 }, {duration: 500,easing: "swing"});
    return false;
	})
	 $("#save").click(function() {
		var word_name = $("#word_name").get(0).value;
		
  	layui.use(['layer', 'form'], function(){
  var layer = layui.layer
  ,form = layui.form;
//  	  layer.msg('Hello World');
  layer.confirm('是否确定已经完成编辑？', {
	  btn: ['确认保存', '继续编辑'] //可以无限个按钮
	  ,btn2: function(index, layero){
		  
	  }
	}, function(index, layero){
		$.ajax({
            type: "post",
            url: "/duplicate/"+word_name,
            
            success: function (data) {
            	if (data=='yes') {
            		$("form").submit();
				} else {
					layui.use(['layer', 'form'], function(){
						  var layer = layui.layer
						  ,form = layui.form;
						  layer.confirm('该文档已存在是否覆盖原文档？', {
							  btn: ['确认覆盖', '取消'] //可以无限个按钮
							  ,btn2: function(index, layero){
								  
							  }
							}, function(index, layero){
								$("form").submit();
								
							}, function(index){
							});
						  	  });
				}
            }
        })
//		$("form").submit();
	}, function(index){
	});
  	  });
  })
   $(".edit").click(function() {
	 	

	 	$(this).prev().prev().hide();
	 	$(this).prev().show();
	 	$(this).next().show();
	 })
	 $(".ok").click(function() {
	 	
	 	var a = "#"+$(this).parent().prop('className').substr(10,14);
	 	var Object_id =a.substr(0,4);
	 	$(Object_id).text($(this).prev().prev().val());
	 	$(this).prev().prev().prev().text($(this).prev().prev().val());
	 	$(this).prev().prev().prev().show();
	 	$(this).prev().prev().hide();
	 	$(this).hide();
	 })
   $(".okM").click(function() {
	 	
	 	var a = "#"+$(this).parent().prop('className').substr(11);
	 	
	 	var Object_id =a.substr(0,2);
	 	$(Object_id).text($(this).prev().prev().val());
	 	$(this).prev().prev().prev().text($(this).prev().prev().val());
	 	$(this).prev().prev().prev().show();
	 	$(this).prev().prev().hide();
	 	$(this).hide();
	 })
  var top = $('#nav').offset().top;
//开始监控滚动栏scroll
$(document).scroll(function() {
	//获取当前滚动栏scroll的高度并赋值
	var scrTop = $(window).scrollTop();
	//开始判断如果导航栏距离顶部的高度等于当前滚动栏的高度则开启悬浮
	if(scrTop >= top) {
		$('#nav').css({
			'position': 'fixed',
			'top': '0',
			'width': '100%'
		});
	} else { //否则清空悬浮
		$('#nav').css({
			'position': '',
			'top': ''
		});
	}
})
	
})
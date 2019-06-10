$(function() {
	
	
			$("#sendver").click(function() {
				var clock;
				var nums = 60;
				var tele = $("#phone").get(0).value;
				var flag = 'yes';
				
					
					$.ajax({
			            type: "post",
			            url: "/sendVerCode/"+ tele,
			            
//			          dataType:"json",
			            success: function (data) {
			              if(data!='no'){
						        console.log(flag);
						        btn = $("#sendver").get(0);
								btn.disabled = true; //将按钮置为不可点击
								btn.value = nums + '秒后重发';
								clock = setInterval(function() {
									nums--;
								if(nums > 0) {
									btn.value = nums + '秒后重发';
								} else {
									clearInterval(clock); //清除js定时器
									btn.disabled = false;
									btn.value = '重新发送';
									nums = 60; //重置时间
								}
								}, 1000); //一秒执行一次
								 $("#phone_Area").hide();
						        }
			              else{
			            	  $("#phone_Area").show();
			              }
			            }
			        })
			       

			     })
			
	
})
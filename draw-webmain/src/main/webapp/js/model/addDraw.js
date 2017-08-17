function AddDrawModel(addDrawModelCallback){
	var payPlug;
	var flowPlug = new FlowPlug({
		begin:function(){

		},
		
		initAddDrawModel:function(){
			var outThis = this;
			hideProgress();

			wx.ready(function(){
				shareInit();
			});
			
			var callback = new Object();
			callback.success = function(){
				$("input[name=isImg]").val(1);
			}
			toBigerImg("/api/common/resource/upload","#addCommodityIndex","file",callback);
			
			this.setNext("setPayType");
			this.nextData({
				type:0
			});
			this.next();
			
			this.setNext("initEventListener");
			this.next();
		},
		
		initEventListener:function(){
			var outThis = this;
			$("input").keyup(function(){
				var elThis = $(this);
				outThis.setNext("initCheck");
				outThis.nextData({
					input:elThis
				});
				outThis.next();
			});
			
			$("textarea").keyup(function(){
				var elThis = $(this);
				outThis.setNext("initCheck");
				outThis.nextData({
					input:elThis
				});
				outThis.next();
			});
			
			
			$(".form_buttom").click(function(){
				outThis.setNext("openPayView");
				outThis.next();
			});
			
			
			$(".option_item_select").click(function(){
				openPayUser();
			});
			
			
			$("#mallClose").click(function(){
				var modelLoad = getModelLoad();
				
				modelLoad.closeModel();
			});
			
			
		},
		initCheck:function(){
			var input = this.stepData("input");
			if(!input.val()){
				input.parent().children(".option_item_label").css("color","red");
				showErrorToast("文本不能为空");
			}else{
				input.parent().children(".option_item_label").css("color","black");
				hideErrorToast("文本不能为空");
			}
		},
		
		payAmount:function(){
			var amount = this.stepData("amount");
			$("input[name=amount]").val(amount);
			var amountBalance = $("input[name=amountBalance]").val();
			amountBalance = parseFloat(amountBalance);
			
			amount = parseFloat(amount);
			
			var payType = $("input[name=payType]").val();
			
			payType = parseInt(payType);
			if(amountBalance<amount&&payType==0){
				showErrorToast("您的金额不足"+amount+"元，请用微信支付");
				
				return;
			}
			
			
			this.setNext("submit");
			this.next();
		},
		
		openPayView:function(){
			
			var outThis = this;
			var num = $("input[name=num]").val();
			numFloat = parseFloat(num);
			numInt = parseInt(num);
			
			if(!numInt){
				$("#num_label").css("color","red");
				showErrorToast("红包个数输入不合法");
				return;
			}
			
			if(numFloat>numInt){
				$("#num_label").css("color","red");
				showErrorToast("红包个数不能有小数点");
				return;
			}
			
			if(numInt==0){
				$("#num_label").css("color","red");
				showErrorToast("红包个数不能是0");
				return;
			}
			
			if(numInt>200){
				$("#num_label").css("color","red");
				showErrorToast("红包个数不能大于200");
				return;
			}
			
			if(numInt<=10){
				$("#takeOutList1").css("display","block");
				$("#takeOutList2").css("display","none");
				$("#takeOutList3").css("display","none");
			}else if(numInt<=100){
				$("#takeOutList1").css("display","none");
				$("#takeOutList2").css("display","block");
				$("#takeOutList3").css("display","none");
			}else{
				$("#takeOutList1").css("display","none");
				$("#takeOutList2").css("display","none");
				$("#takeOutList3").css("display","block");
			}
			
			
			
			
			var question = $("textarea[name=question]").val();
			
			if(!question){
				$("#question_label").css("color","red");
				showErrorToast("输入的问题不能为空");
				return;
			}
			
			if(question.length>50){
				$("#question_label").css("color","red");
				showErrorToast("输入的问题不能超过50个字节");
				return;
			}else{
				$("#question_label").css("color","black");
				hideErrorToast("输入的问题不能超过50个字节");
			}
			
			var answer = $("input[name=answer]").val();
			
			if(!answer){
				$("#answer_label").css("color","red");
				showErrorToast("输入的答案不能为空");
				return;
			}
			
			
			if(answer.length>7){
				$("#answer_label").css("color","red");
				showErrorToast("输入的问题不能超过7个字节");
				return;
			}
			/*layer.open({
				type:1,
				title:"请选择支付金额",
				shadeClose:true,
				shade:[0.1,'#000'],
				area:['300px',"300px"],
				content:$("#pay_view")
			});*/
			
			payPlug = new AlertPlug($("#pay_view").html());
			
			
			$(".take_out_item").click(function(){
				var amount = $(this).attr("amount");
				
				outThis.setNext("payAmount");
				
				outThis.nextData({
					amount:amount
				});
				
				outThis.next();
			});
		},
		
		submit:function(){
			showLoading();
			var amount = $("input[name=amount]").val();

			var question = $("textarea[name=question]").val();
			
			var answer = $("input[name=answer]").val();

			var isRoom = $("input[name=isRoom]").val();

			var room = $("input[name=roomId]").val();

			var payType = $("input[name=payType]").val();

			var imgUrl = $("#var_file").val();

			var isImg = $("input[name=isImg]").val();
			
			var subjectId = $("input[name=subjectId]").val();
			
			var num = $("input[name=num]").val();

			var url = "/api/draw/red_pack/add";
			var params = new Object();
			
			params.place_num = num;
			
			params.draw_room_id = room;

			params.isRoom = 0;
			
			params.amount = amount;
			
			params.question = question;
			
			params.answer = answer;
			
			params.payType = payType;
			
			params.imgUrl = imgUrl;
			
			params.isImg = isImg;
			
			params.subjectId = subjectId;
			
			params.type=0;
			

			
			var callback = new Object();

			callback.success = function(obj){

				hideLoading();
				var outObject = obj;
				if(obj.success){
					
					
					if(obj.data.payType==0){
						if(addDrawModelCallback&&addDrawModelCallback.success){
							addDrawModelCallback.success(obj.data);
						}
						
					}else if(obj.data.payType==1){
						var id = obj.data.id;
						
						var url = "/api/pay/wx/choose_wx_pay_config";
						var callback = new Object();
						callback.success = function(obj){
							
							var payCallback = new Object();
							payCallback.success = function(){
								if(addDrawModelCallback&&addDrawModelCallback.success){
									addDrawModelCallback.success(obj);
								}
							}
							
							payCallback.failure = function(){
								showToast("现在网络繁忙，请稍后再试");
							}
							
							payCallback.cancel = function(){
								var type = parseInt(type);
								if(type==0){
									skipToRoomInfo($("#room").val());
								}else{
									skipToRedpackList(0);
								}
							}
							if(obj.success){
								
								
								wxPay(obj.data.timestamp,obj.data.nonceStr,obj.data.pack,obj.data.signType,obj.data.paySign,payCallback);
							}else{
								
							}
							
						}
						
						callback.failure = function(obj2){
							showToast("现在网络繁忙，请稍后再试");
							hideLoading();
						}
						var params = new Object();
						params.cost=amount;
						params.body="发布问答红包";
						params.detail = "问答红包";
						
						params.type=0;
						
						params.red_packet_id = obj.data.id;
						request(url,callback,params);
					}
					
				
				}else{
					alert(obj.errorMsg);
					hideLoading();
				}
			}
			
			callback.failure = function(){
				showToast("现在网络繁忙，请稍后再试");
				hideLoading();
			}
			
			request(url,callback,params);
		},
		
		
		setPayType:function(){
			var type = this.stepData("type");
			
			$("input[name=payType]").val(type);
			var wxPayTypeEm = $(".select_list_item[type=0] em").eq(0);
			var amountPayTypeEm = $(".select_list_item[type=1] em").eq(0);
			
			if(type==1){
				wxPayTypeEm.attr("class","fa fa-square-o");
				wxPayTypeEm.css("color","black");
				amountPayTypeEm.attr("class","fa fa-check-square");
				amountPayTypeEm.css("color","red");
			}else{
				amountPayTypeEm.attr("class","fa fa-square-o");
				amountPayTypeEm.css("color","black");
				wxPayTypeEm.attr("class","fa fa-check-square");
				wxPayTypeEm.css("color","red");
			}	
		}
	});
	
	this.payAmount = function(amount){
		flowPlug.flowPlug.setNext("payAmount");
		flowPlug.flowPlug.nextData({
			amount:amount
		});
		flowPlug.flowPlug.next();
	}
	
	this.close = function(){
		
	}
	
	this.init = function(){
		
		var modelLoad = getModelLoad();
		
		var url = "/view/draw/luck_draw/add2?isDisplayRoom=1&isDisplayType=0&subjectId=1&root_id=0";
		modelLoad.loadUrl(url,{
			success:function(){
				flowPlug.flowPlug.setNext("initAddDrawModel");
				flowPlug.flowPlug.next();
			}
		});
	}

}

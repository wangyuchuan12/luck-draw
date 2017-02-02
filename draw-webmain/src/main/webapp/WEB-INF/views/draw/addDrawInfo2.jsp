<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="resourceLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
<tiles:putAttribute name="body">
<script src="/js/jquery.ui.widget.js"></script>
<script src="/js/jquery.iframe-transport.js"></script>
<script src="/js/jquery.fileupload.js"></script>
	
	
	<!-- 红包类型0房间问答红包 1个人问答红包 -->
	<input type="hidden" name="type" value="${redPackType}"/>
	<input type="hidden" name="isDisplayRoom" value="${isDisplayRoom}"/>
	
	
	<input type="hidden" name="isDisplayType" value="${isDisplayType}"/>
	
	<!-- 账号余额 -->
	<input type="hidden" name="amountBalance" value="${amountBalance}"/>
	
	<!-- 0余额支付，1是微信支付 -->
	<input type="hidden" name="payType" value="0"/>
	
	<input type="hidden" name="isImg" value="0"/>
	
	<input type="hidden" name="amount" />
	
	<input type="hidden" name="roomId" value="${roomId}"/>
	
		<div class="addDrawInfo2">
        	<div class="option_items">

					<div class="option_item"> 
				        <div id="addCommodityIndex"></div>
			        </div>
					<div class="option_item">
						<div class="option_item_label" id="question_label">问题：</div>
						<input name="question" placeholder="不能超过50个字节"/> 

					</div>
					
					<div class="option_item">
						<div class="option_item_label" id="answer_label">答案：</div>
						<input name="answer" placeholder="不能超过7个字节"/> 
					</div>
					
					
					<div class="option_item_select" id="payUserTypeDisplay">
						<!--  <span class="fa fa-address-card" id="option_item_select_icon" style="color: green;"></span>-->
						<span class="option_item_select_content">个人</span>
					</div>
					
					
					
					<div class="form_buttom">生成红包</div>
		
			</div>
			
			<div  id="pay_view"  style="display: none;" >
			
				<div class="add_draw_pay_view">
					<div class="take_out_list">
						<div class="take_out_item" onclick="payAmount(0.1);">
							<div class="take_out_item_money">0.1<span>元</span></div>
						</div>
						
						
						<div class="take_out_item" onclick="payAmount(0.5);">
							<div class="take_out_item_money">0.5<span>元</span></div>
						</div>
						
						<div class="take_out_item" onclick="payAmount(1);">
							<div class="take_out_item_money">1<span>元</span></div>
						</div>
						
						<div class="take_out_item" onclick="payAmount(5);">
							<div class="take_out_item_money">5<span>元</span></div>
						</div>
						
						<div class="take_out_item" onclick="payAmount(10);">
							<div class="take_out_item_money">10<span>元</span></div>
						</div>
						
						<div class="take_out_item" onclick="payAmount(20);">
							<div class="take_out_item_money">20<span>元</span></div>
						</div>
					</div>
					
					
					<div>
						<div class="select_list_item" type=0 onclick="setPayType(0)">
						
							<em class="fa fa-check-square"  style="color: red;"></em>
		         			<em class="fa fa-address-card" style="color: green;"></em>
		         			<span class="select_list_item_name">余额支付（剩余：${amountBalance}元）</span>
		         			
		         			
	         			</div>
	         			
	         			<div class="select_list_item" id="amountPayType" type=1 onclick="setPayType(1)">
	         			
	         				<em class="fa fa-square-o"></em>
		         			<em class="fa fa-weixin" style="color: green;"></em>
		         			<span class="select_list_item_name">微信支付</span>
	         			</div>
         			
         			</div>
				</div>
				
			</div>
       
         	<div class="select_list" id="payUser" style="display: none;">
         		<div class="select_list_item" type="1">
         			<em class="fa fa-address-card" style="color: green;"></em>
         			<span class="select_list_item_name">个人</span>
         		</div>
         		
         		<c:forEach items="${rooms}" var="room">
         			<div class="select_list_item" type="0" id="${room.id}">
	         			<img src="${room.imgUrl}">
	         			<span class="select_list_item_name">房间：${room.name}</span>
         			</div>
         		</c:forEach>
         	</div>
         	
         </div>

<script>

	setPayType(0);
	function setPayType(type){
		
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
	
	
	function payAmount(amount){
		$("input[name=amount]").val(amount);
		
		submit();
	}
	
	
	
	//初始化设置为个人
	
	var type = $("input[name=type]").val();
	
	var roomId = $("input[name=roomId]").val();
	if(type=="1"||!roomId){
		setPayUser($("#payUser .select_list_item[type=1]"));
	}else if(type=="0"){
		setPayUser($("#payUser .select_list_item[id="+roomId+"]"));
	}
	
	function setPayUser(item){

		
		var type=item.attr("type");
		
		var payUserTypeDisplay = $("#payUserTypeDisplay");
		
		payUserTypeDisplay.empty();
		
		$("input[name=type]").val(type);
		if(type=="0"){
			var id = item.attr("id");
			
			var imgSrc = item.children("img").attr("src");
			$("input[name=roomId]").val(id);
			
			var img = "<img src='"+imgSrc+"' />"
			
			payUserTypeDisplay.append(img);
			
			var roomName = item.children(".select_list_item_name").text();
			
			payUserTypeDisplay.append("<span class='option_item_select_content'>"+roomName+"</span>");
			
			
		}else if(type=="1"){
			payUserTypeDisplay.append("<span class='fa fa-address-card' id='option_item_select_icon' style='color: green;'></span>");
			
			payUserTypeDisplay.append("<span class='option_item_select_content'>个人</span>");
		}
		
		
	}
	
	function clickAmount(amount){
		$("input[name=amount]").val(amount);
	}

	function openPayUser(){
		var payUser = layer.open({
			type:1,
			title:"请选择支付对象",
			shadeClose:true,
			shade:[0.1,'#000'],
			area:['250px',"300px"],
			content:$("#payUser")
		});
		
		$("#payUser .select_list_item").click(function(){
			setPayUser($(this));
			
			layer.close(payUser);
			
		});
		
	}
	
	function openPayView(){
		
		var question = $("input[name=question]").val();
		
		if(!question){
			$("#question_label").css("color","red");
			showErrorToast("输入的问题不能为空");
			return;
		}
		
		if(question.length>50){
			$("#question_label").css("color","red");
			showErrorToast("输入的问题不能超过50个字节");
			return;
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
		layer.open({
			type:1,
			title:"请选择支付金额",
			shadeClose:true,
			shade:[0.1,'#000'],
			area:['300px',"300px"],
			content:$("#pay_view")
		});
		
		
	
	}
	
	
	
	function inputCheck(input){
		if(!input.val()){
			input.parent().children(".option_item_label").css("color","red");
			showErrorToast("文本不能为空");
		}else{
			input.parent().children(".option_item_label").css("color","black");
			hideErrorToast("文本不能为空");
		}
		
	}
	
	

	$(document).ready(function(){
		
	
		$("input").keyup(function(){
			inputCheck($(this));
		});
		
		
		$(".form_buttom").click(function(){
			openPayView();
		});
		
		
		$(".option_item_select").click(function(){
			openPayUser();
		});
		
		
		
		wx.ready(function(){
			shareInit();
		});
		
		var callback = new Object();
		callback.success = function(){
			$("input[name=isImg]").val(1);
		}
		toBigImg("/api/common/resource/upload","#addCommodityIndex","file",callback)
	});
	
	
	function submit(){
		
		showLoading();
		var amount = $("input[name=amount]").val();

		var question = $("input[name=question]").val();
		
		var answer = $("input[name=answer]").val();

		var type = $("input[name=type]").val();

		var room = $("input[name=roomId]").val();

		var payType = $("input[name=payType]").val();

		var imgUrl = $("#var_file").val();

		var isImg = $("input[name=isImg]").val();

		var url = "/api/draw/red_pack/add";
		var params = new Object();
		
		params.draw_room_id = room;

		params.type = type;
		
		params.amount = amount;
		
		params.question = question;
		
		params.answer = answer;
		
		params.payType = payType;
		
		params.imgUrl = imgUrl;
		
		params.isImg = isImg;
		
		var callback = new Object();
		callback.success = function(obj){

			var outObject = obj;
			
			if(obj.success){
				
				if(obj.data.payType==0){
					var params = new Object();
					params.id = obj.data.id;
					skipToUrl("/view/draw/luck_draw/info",params);
				}else if(obj.data.payType==1){
					var id = obj.data.id;
					
					var url = "/api/pay/wx/choose_wx_pay_config";
					var callback = new Object();
					callback.success = function(obj){
						hideLoading();
						var payCallback = new Object();
						payCallback.success = function(){
							var params = new Object();
							params.id = outObject.data.id;
							skipToUrl("/view/draw/luck_draw/info",params);
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
						}
						
					}
					
					callback.failure = function(obj){
						showToast("现在网络繁忙，请稍后再试");
						hideLoading();
					}
					var params = new Object();
					params.cost=amount;
					params.body="发布问答红包";
					params.detail = "问答红包";
					
					
					params.outTradeNo  = obj.data.outTradeNo;
					request(url,callback,params);
				}
				
			
			}
		}
		
		callback.failure = function(){
			showToast("现在网络繁忙，请稍后再试");
			hideLoading();
		}
		
		request(url,callback,params);
		
	}

</script>
			
			
</tiles:putAttribute>
</tiles:insertDefinition>

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
	
	
	

	<input type="hidden" name="isDisplayRoom" value="${isDisplayRoom}"/>
	
	
	<input type="hidden" name="isDisplayType" value="${isDisplayType}"/>
	
	<!-- 账号余额 -->
	<input type="hidden" name="amountBalance" value="${amountBalance}"/>
	
	<!-- 0余额支付，1是微信支付 -->
	<input type="hidden" name="payType" value="0"/>
	
	<input type="hidden" name="isImg" value="0"/>
	
	<input type="hidden" name="amount" />
	
	<input type="hidden" name="roomId" value="${roomId}"/>
	
	<!-- 红包类型1房间问答红包 0个人问答红包 -->
	<input type="hidden" name="isRoom" value="${isRoom}"/>
	
	<input type="hidden" name="subjectId" value="${subjectId}"/>
	
		<div class="addDrawInfo2">
        	<div class="option_items">

					<div class="option_item" style="padding-left: 10px;"> 
				        <div id="addCommodityIndex"></div>
			        </div>
			        
			        <div class="option_item">
						<div class="option_item_label" id="num_label">红包个数：</div>
						<input name="num" placeholder="填写个数" type="number"/> 
					</div>
					<div class="option_item_area">
						<div class="option_item_label" id="question_label">问题：</div>
						<textarea name="question" placeholder="不能超过50个字节"></textarea> 

					</div>
					
					<div class="option_item" style="position: relative;top:-4px;">
						<div class="option_item_label" id="answer_label">答案：</div>
						<input name="answer" placeholder="不能超过7个字节"/> 
					</div>
					
					
					<div class="option_item_select" id="payUserTypeDisplay" style="position: relative;top:-4px;">
						<!--  <span class="fa fa-address-card" id="option_item_select_icon" style="color: green;"></span>-->
						<span class="option_item_select_content">个人</span>
					</div>
					
					
					
					<div class="form_buttom">生成红包</div>
		
			</div>
			
			<div  id="pay_view"  style="display: none;" >
			
				<div class="add_draw_pay_view">
					<div class="take_out_list" id="takeOutList1">
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
					
					
					<div class="take_out_list" id="takeOutList2">
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
						
						<div class="take_out_item" onclick="payAmount(50);">
							<div class="take_out_item_money">50<span>元</span></div>
						</div>
						
						<div class="take_out_item" onclick="payAmount(100);">
							<div class="take_out_item_money">100<span>元</span></div>
						</div>
					</div>
					
					
					<div class="take_out_list" id="takeOutList3">
						<div class="take_out_item" onclick="payAmount(1);">
							<div class="take_out_item_money">2<span>元</span></div>
						</div>
						
						
						<div class="take_out_item" onclick="payAmount(5);">
							<div class="take_out_item_money">10<span>元</span></div>
						</div>
						
						<div class="take_out_item" onclick="payAmount(10);">
							<div class="take_out_item_money">20<span>元</span></div>
						</div>
						
						<div class="take_out_item" onclick="payAmount(20);">
							<div class="take_out_item_money">40<span>元</span></div>
						</div>
						
						<div class="take_out_item" onclick="payAmount(50);">
							<div class="take_out_item_money">100<span>元</span></div>
						</div>
						
						<div class="take_out_item" onclick="payAmount(100);">
							<div class="take_out_item_money">200<span>元</span></div>
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
         		<div class="select_list_item" isRoom="0">
         			<em class="fa fa-address-card" style="color: green;"></em>
         			<span class="select_list_item_name">个人</span>
         		</div>
         		
         		<c:forEach items="${rooms}" var="room">
         			<div class="select_list_item" isRoom="1" id="${room.id}">
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
		var amountBalance = $("input[name=amountBalance]").val();
		amountBalance = parseFloat(amountBalance);
		
		amount = parseFloat(amount);
		
		var payType = $("input[name=payType]").val();
		
		payType = parseInt(payType);
		if(amountBalance<amount&&payType==0){
			showErrorToast("您的金额不足"+amount+"元，请用微信支付");
			
			return;
		}
		
		submit();
	}
	
	
	
	//初始化设置为个人
	
	var isRoom = $("input[name=isRoom]").val();
	
	
	var roomId = $("input[name=roomId]").val();
	if(isRoom!="1"||!roomId){
		setPayUser($("#payUser .select_list_item[isRoom=0]"));
	}else if(isRoom=="1"){
		setPayUser($("#payUser .select_list_item[id="+roomId+"]"));
	}
	
	function setPayUser(item){

		
		var isRoom=item.attr("isRoom");
		
		var payUserTypeDisplay = $("#payUserTypeDisplay");
		
		payUserTypeDisplay.empty();
		
		$("input[name=isRoom]").val(isRoom);
		if(isRoom=="1"){
			var id = item.attr("id");
			
			var imgSrc = item.children("img").attr("src");
			$("input[name=roomId]").val(id);
			
			var img = "<img src='"+imgSrc+"' />"
			
			payUserTypeDisplay.append(img);
			
			var roomName = item.children(".select_list_item_name").text();
			
			payUserTypeDisplay.append("<span class='option_item_select_content'>"+roomName+"</span>");
			
			
		}else if(isRoom=="0"){
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
		
		$("textarea").keyup(function(){
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
		toBigerImg("/api/common/resource/upload","#addCommodityIndex","file",callback);
	});
	
	
	function submit(){
		
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

		params.isRoom = isRoom;
		
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

			var outObject = obj;
			if(obj.success){
				
				
				if(obj.data.payType==0){
					var params = new Object();
					params.id = obj.data.id;
					skipToProblemRedPacketInfo(params.id,1);
				}else if(obj.data.payType==1){
					var id = obj.data.id;
					
					var url = "/api/pay/wx/choose_wx_pay_config";
					var callback = new Object();
					callback.success = function(obj){
						hideLoading();
						var payCallback = new Object();
						payCallback.success = function(){
							var params = new Object();
							skipToProblemRedPacketInfo(params.id,1);
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
							alert(JSON.stringify(obj));
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

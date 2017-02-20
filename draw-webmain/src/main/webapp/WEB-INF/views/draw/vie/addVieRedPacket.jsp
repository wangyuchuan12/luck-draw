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
	<input type="hidden" name="isRoom" value="${isRoom}"/>
	<input type="hidden" name="isDisplayRoom" value="${isDisplayRoom}"/>
	
	
	<input type="hidden" name="isDisplayType" value="${isDisplayType}"/>
	
	<!-- 账号余额 -->
	<input type="hidden" name="amountBalance" value="${amountBalance}"/>
	
	<!-- 0余额支付，1是微信支付 -->
	<input type="hidden" name="payType" value="0"/>
	
	<input type="hidden" name="isImg" value="0"/>
	
	<input type="hidden" name="amount" />
	
	<input type="hidden" name="roomId" value="${roomId}"/>
	
	<input type="hidden" name="subjectId" value="${subjectId}"/>
	
	<input type="hidden" name="isEntryFee" value="0"/>
	<div class="addVieRedPacket">
		<div class="option_items">
				<div class="option_item" style="padding-left: 10px;"> 
			        <div id="addCommodityIndex"></div>
		        </div>
		        
		        <div class="option_item">
					<div class="option_item_label" id="theme_label">主题：</div>
					<input name="theme" placeholder="不能超过7个字节"/> 
				</div>
				
				<div class="option_item_area">
					<div class="option_item_label" id="instruction_label">说明：</div>
					<textarea name="instruction" placeholder="不能超过50个字节"></textarea> 

				</div>
				
				
				
				
				<div class="option_item_select" id="payUserTypeDisplay">
					<!--  <span class="fa fa-address-card" id="option_item_select_icon" style="color: green;"></span>-->
					<span class="option_item_select_content">个人</span>
				</div>

				<div class="form_buttom">生成红包</div>
		
			</div>
	</div>
	
	
	
	
	<div  id="pay_view" style="display: none;">
			
				<div class="add_draw_pay_view">
					<div class="take_out_list">
						<div class="take_out_item" onclick="payAmount(0.01);">
							<div class="take_out_item_money">0.01<span>元</span></div>
						</div>
						
						
						<div class="take_out_item" onclick="payAmount(10);">
							<div class="take_out_item_money">10<span>元</span></div>
						</div>
						
						<div class="take_out_item" onclick="payAmount(20);">
							<div class="take_out_item_money">20<span>元</span></div>
						</div>
						
						<div class="take_out_item" onclick="payAmount(40);">
							<div class="take_out_item_money">40<span>元</span></div>
						</div>
						
						<div class="take_out_item" onclick="payAmount(10);">
							<div class="take_out_item_money">100<span>元</span></div>
						</div>
						
						<div class="take_out_item" onclick="payAmount(200);">
							<div class="take_out_item_money">200<span>元</span></div>
						</div>
					</div>
					
					<div class="add_draw_pay_view_amount">
					
						<div class="add_draw_pay_view_amount_check">
							<span class="fa fa-square-o"></span>
						</div>
						
						<div class="add_draw_pay_view_amount_label">参赛费</div>
						
						<input type="number" name="entryFee" maxlength="2">
						
						<div class="add_draw_pay_view_amount_sign">元</div>
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
         		<div class="select_list_item" isRoom=0>
         			<em class="fa fa-address-card" style="color: green;"></em>
         			<span class="select_list_item_name">个人</span>
         		</div>
         		
         		<c:forEach items="${rooms}" var="room">
         			<div class="select_list_item" isRoom=1 id="${room.id}">
	         			<img src="${room.imgUrl}">
	         			<span class="select_list_item_name">房间：${room.name}</span>
         			</div>
         		</c:forEach>
     </div>
			
			
			
			
	<script type="text/javascript">
	
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
		
		var isEntryFee = $("input[name=isEntryFee]").val();
		
		if(isEntryFee==1){
			var entryFee = $("input[name=entryFee]").val();
			if(!/^\d+(\.\d{0,2})?$/.test(entryFee)){
				showErrorToast("参赛费不能超过两位小数");
			}
			
			if(amount/10<entryFee){
				showErrorToast("参赛费不能大于总金额的1/10");
			}
		}
		
		submit();
	}
	
	
	
	//初始化设置为个人
	
	var isRoom = $("input[name=isRoom]").val();
	
	var roomId = $("input[name=roomId]").val();

	if(isRoom!="1"||!roomId){
		setPayUser($("#payUser").children(".select_list_item[isRoom=0]"));
	}else if(isRoom=="1"&&roomId){
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
	
	
	function submit(){
		
		showLoading();
		var amount = $("input[name=amount]").val();

		var theme = $("input[name=theme]").val();
		
		var instruction = $("textarea[name=instruction]").val();

		var type = $("input[name=isRoom]").val();

		var room = $("input[name=roomId]").val();

		var payType = $("input[name=payType]").val();

		var imgUrl = $("#var_file").val();

		var isImg = $("input[name=isImg]").val();
		
		var subjectId = $("input[name=subjectId]").val();
		
		var isRoom = $("input[name=isRoom]").val();

		var url = "/api/draw/red_pack/add";
		var params = new Object();
		
		params.draw_room_id = room;

		params.isRoom = isRoom;
		
		//表示竞答红包类型
		params.type=1;
		
		params.amount = amount;
		
		params.theme = theme;
		
		params.instruction = instruction;
		
		params.payType = payType;
		
		params.imgUrl = imgUrl;
		
		params.isImg = isImg;
		
		params.subjectId = subjectId;
		
		params.isEntryFee = $("input[name=isEntryFee]").val();
		params.entryFee = $("input[name=entryFee]").val();
		
		
		var callback = new Object();
		callback.success = function(obj){
			if(!obj.success){
				alert(obj.errorMsg);
				showToast("现在网络繁忙，请稍后再试");
				hideLoading();
				return;
			}
			var outObject = obj;
			
			if(obj.success){
				var redPacketId = obj.data.id;
				if(obj.data.payType==0){
					skipToVieSetProblem(0,redPacketId);
				}else if(obj.data.payType==1){
					var url = "/api/pay/wx/choose_wx_pay_config";
					var callback = new Object();
					callback.success = function(obj){
						
						var redPacketId = obj.data.id;
						hideLoading();
						var payCallback = new Object();
						payCallback.success = function(){
							skipToVieSetProblem(0,redPacketId);
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
							alert(obj.msg);
						}
						
					}
					
					callback.failure = function(obj){
						
						showToast("现在网络繁忙，请稍后再试");
						hideLoading();
					}
					var params = new Object();
					params.cost=amount;
					params.body="发布竞答答红包";
					params.detail = "竞答答红包";
					params.type=1;
					alert("redPacketId:"+redPacketId);
					params.red_packet_id = redPacketId;
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
	
	function openPayView(){
		
		var theme = $("input[name=theme]").val();
		
		if(!theme){
			$("#theme_label").css("color","red");
			showErrorToast("输入的主题不能为空");
			return;
		}
		
		if(theme.length>7){
			$("#theme_label").css("color","red");
			showErrorToast("输入的主题超过7个字节");
			return;
		}else{
			$("#theme_label").css("color","black");
			hideErrorToast();
		}
		
		var instruction = $("textarea[name=instruction]").val();
		
		if(!instruction){
			$("#instruction_label").css("color","red");
			showErrorToast("输入的简介不能为空");
			return;
		}else{
			$("#instruction_label").css("color","black");
			hideErrorToast();
		}
		
		
		if(instruction.length>50){
			$("#instruction_label").css("color","red");
			showErrorToast("输入的问题不能超过50个字节");
			return;
		}
		layer.open({
			type:1,
			title:"请选择支付金额",
			shadeClose:true,
			shade:[0.1,'#000'],
			area:['300px',"350px"],
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
			var callback = new Object();
			callback.success = function(){
				$("input[name=isImg]").val(1);
			}
			toBigerImg("/api/common/resource/upload","#addCommodityIndex","file",callback);
			
			
			$(".option_item_select").click(function(){
				openPayUser();
			});
			
			
			$(".form_buttom").click(function(){
				openPayView();
			});
			
			$(".add_draw_pay_view_amount_check").click(function(){
				var isEntryFee = $("input[name=isEntryFee]").val();
				if(isEntryFee==0){
					$(this).children("span").attr("class","fa fa-check-square");
					$(this).children("span").css("color","red");
					$("input[name=isEntryFee]").val(1);
					$("input[name=entryFee]").val(0.01);
				}else{
					$(this).children("span").attr("class","fa fa-square-o");
					$(this).children("span").css("color","");
					$("input[name=isEntryFee]").val(0);
					$("input[name=entryFee]").val(0);
				}
				
			});
		});
	</script>
			
</tiles:putAttribute>
</tiles:insertDefinition>

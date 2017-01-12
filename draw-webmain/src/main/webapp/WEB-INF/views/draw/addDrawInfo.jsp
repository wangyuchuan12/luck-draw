<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="formLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
<tiles:putAttribute name="body">
	
	<input type="text" name="redPackType" value="${redPackType}"/>
	<input type="text" name="isDisplayRoom" value="${isDisplayRoom}"/>
	<input type="text" name="isDisplayType" value="${isDisplayType}"/>
	<input type="text" name="amountBalance" value="${amountBalance}"/>
	
	<div data-role="page">  
  
    <div data-role="header">  
        <h1>发起红包</h1>  
    </div>  
    
    
      
    <div data-role="content">  
          
        <form action="javascript:return false;" method="post" id="addDrawInfoForm">
        
        
        <div data-role="fieldcontain">  
            <label for="amount">金额:</label>  
            <input type="number" name="amount" id="amount"></input>
            <label for="amount" class="error"></label>
        </div> 
        
        <div data-role="fieldcontain">  
            <label for="question">问题:</label>  
            <input type="text" name="question" id="question"></input>
            <label for="question" class="error"></label>
        </div> 
        
        <div data-role="fieldcontain">  
            <label for="answer">答案（不超出7个字）:</label>  
            <input type="text" name="answer" id="answer"></input>
            <label for="answer" class="error"></label>
        </div>      
  
       <div data-role="fieldcontain"
	       	<c:if test="${isDisplayType!=1}">
	         	style="display:none"
	        </c:if>>
            <fieldset data-role="controlgroup">
			  <legend>红包类型:</legend>
			  <input type="radio" name="type" id="radio-choice-1" value="1"
			   <c:if test="${redPackType==1}">
			  	checked="checked"
			  </c:if>/>
			  <label for="radio-choice-1">个人</label>
			 
			  <input type="radio" name="type" id="radio-choice-2" value="0" 
				  <c:if test="${redPackType==0}">
				  	checked="checked"
				  </c:if>/>
			  <label for="radio-choice-2">房间</label>
			</fieldset>
        </div>
        
         <div id="roomDiv" data-role="fieldcontain" <c:if test="${isDisplayRoom!=1}">
	         	style="display:none"
	        </c:if>>
        	<fieldset data-role="fieldcontain">
			    <label for="day">选择房间</label>
			    
			    <select name="room" id="room">
			    	<option value="0">请选择房间</option>
			      <c:forEach items="${rooms}" var="room">
			      	<option  <c:if test="${room.id==roomId}">selected="selected"</c:if> value="${room.id}">${room.name}</option>
			      </c:forEach>
			    </select>
			    <label for="room" class="error"></label>
		  	</fieldset>
		  </div>
        
        
        <div data-role="fieldcontain">  
            <fieldset data-role="controlgroup">
			  <legend>支付:</legend>
			  <input type="radio" name="payType" id="radio-choice-3" value="0" checked="checked" />
			  <label for="radio-choice-3"><em class="fa fa-address-card" style="color: RGBA(29,159,117,1);"></em> 账户余额 <font color="red" style="font-size: 10px;">剩余${amountBalance}元</font></label>
			 
			  <input type="radio" name="payType" id="radio-choice-4" value="1" />
			  <label for="radio-choice-4"><em class="fa fa-weixin" style="color: green;"></em> 微信</label>
			  
			  
			</fieldset>
        </div>
  
        <div data-role="fieldcontain">  
            <input type="submit" name="submit" value="提交"  />  
        </div>      
          
        </form>  
  
    </div>  
  
</div> 

<script>


	$(document).ready(function(){
		initRoomDisplay();
		$("input[name=type]").click(function(){
			initRoomDisplay();
		});
	});
	
	$("input[name='submit']").click(function(){
		
		verifyInit();
	});
	
	
	function initRoomDisplay(){
		var isDisplayRoom = $("input[name=isDisplayRoom]").val();
		if(isDisplayRoom==1){
			var checked = $("input[name=type]:checked").val();
			if(checked==1){
				$("#roomDiv").css("display","none");
			}else if(checked==0){
				$("#roomDiv").css("display","block");
			}
		}else{
			$("#roomDiv").css("display","none");
		}
		
	}
	
	function submit(){
		
		showLoading();
		
		var amount = $("input[name=amount]").val();
		var question = $("input[name=question]").val();
		
		var answer = $("input[name=answer]").val();
		
		var type = $("input[name=type]").val();
		
		var room = $("select[name=room]").val();
		
		var payType = $("input[name=payType]:checked").val();
		
		var url = "/api/draw/red_pack/add";
		var params = new Object();
		
		params.draw_room_id = "9fc5e451-f762-4df7-91d0-ac39b888a82f";
		params.type = type;
		
		params.amount = amount;
		
		params.question = question;
		
		params.answer = answer;
		
		params.payType = payType;
		
		
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
	
	jQuery.validator.addMethod("notEqual", function(value,element,arg) {
		if(value==arg){
			return false;
		}else{
			return true;
		}
	}, "");
	
	

	jQuery.validator.addMethod("roomSelect", function(value,element,arg) {
		if(value==0){
			return false;
		}else{
			return true;
		}
	}, "");
	
	
	jQuery.validator.addMethod("payCheck", function(value,element,arg) {
		var amountBalance = $("input[name=amountBalance]").val();
		var amount = $("input[name=amount]").val();
		var payType = $("input[name=payType]:checked").val();
		amountBalance = parseFloat(amountBalance);
		amount = parseFloat(amount);
		if(payType==0&&amount>amountBalance){
			return false;
		}else{
			return true;
		}
	}, "");
	function verifyInit(){
		$("#addDrawInfoForm").validate({
			submitHandler:function(form){
				submit();
			},
			rules: {
				amount:{
					required: true,
					range:[0,200],
					notEqual:0
				},
				question: {
					required: true,
					minlength: 1,
					maxlength:15
				},
				answer: {
					required: true,
					minlength: 1,
					maxlength:7
				},
				room:{
					roomSelect:true
				},
				payType:{
					payCheck:true
				}
			},
			messages: {
				amount: {
					required: "请输入金额",
					range:"金额大小在0到200元之间",
					notEqual:"输入的金额不能等于0"
				},
				question: {
					required: "请输入问题",
					minlength: "最小长度不能小于3个字节",
					maxlength: "最大长度不能超过7个字节"
				},
				answer: {
					required: "请输入问题答案",
					minlength: "最小长度不能小于一个字",
					maxlength: "最大长度不能超过7个字节"
				},
				room:{
					roomSelect:"请选择一个房间"
				},
				payType:{
					payCheck:"余额不足，请用微信支付"
				}
				
				
			}
		});
	}

</script>
			
			
</tiles:putAttribute>
</tiles:insertDefinition>

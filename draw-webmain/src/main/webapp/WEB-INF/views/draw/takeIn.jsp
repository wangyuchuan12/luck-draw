<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="resourceLayout">
<tiles:putAttribute name="title">充值现金</tiles:putAttribute>
<tiles:putAttribute name="body">
			<input name="amountBalance" value="${user.amountBalance}" type="hidden"></input>
			
			<input name="canTakeOutCount" value="${user.canTakeOutCount}" type="hidden"></input>
			<div class="luck_info_head">
				<div class="luck_info_head_background"></div>
				<div class="luck_info_head_title">充值现金</div>
				<div class="luck_info_head_img">
					<img src="${user.headimgurl}"></img>
				</div>
				<div class="luck_info_head_name">${user.nickname}</div>

			</div>
			
			<div class="take_out_balance">余额${user.amountBalance}元</div>
			
			
			<div class="take_out_list">
				<div class="take_out_item" onclick="takeIn(5);">
					<div class="take_out_item_money">5<span>元</span></div>
				</div>
				
				<div class="take_out_item" onclick="takeIn(10);">
					<div class="take_out_item_money">10<span>元</span></div>
				</div>
				
				<div class="take_out_item" onclick="takeIn(20);">
					<div class="take_out_item_money">20<span>元</span></div>
				</div>
				
				<div class="take_out_item" onclick="takeIn(50);">
					<div class="take_out_item_money">50<span>元</span></div>
				</div>
				
				<div class="take_out_item" onclick="takeIn(100);">
					<div class="take_out_item_money">100<span>元</span></div>
				</div>
				
				<div class="take_out_item" onclick="takeIn(200);">
					<div class="take_out_item_money">200<span>元</span></div>
				</div>
			</div>
			
			
			<div class="amount_details">
			
				<!--  <div class="amount_details_header">申请记录</div>-->
				
			</div>
			
			
			<script type="text/javascript">
				function takeIn(amount){
	
					amount = parseFloat(amount);
					
					layer.confirm("是否确定充值现金",function(){
						layer.closeAll();
						showLoading();
						var url = "/api/draw/personal_center/take_in_amount";
						var params = new Object();
						params.amount = amount;
						var callback = new Object();
						callback.success = function(takeInObject){
							if(takeInObject.success){
								var id = takeInObject.data.id;
								
								var url = "/api/pay/wx/choose_wx_pay_config";
								var callback = new Object();
								callback.success = function(obj){
									
									var payCallback = new Object();
									payCallback.success = function(){
										
										skipToUrl("/view/draw/personal_center/takeIn");
									}
									
									payCallback.failure = function(){
										showToast("现在网络繁忙，请稍后再试");
									}
									
									payCallback.cancel = function(){

									}
									if(obj.success){
										hideLoading();
										wxPay(obj.data.timestamp,obj.data.nonceStr,obj.data.pack,obj.data.signType,obj.data.paySign,payCallback);
									}
									
								}
								
								callback.failure = function(obj){
									showToast("现在网络繁忙，请稍后再试");
									hideLoading();
								}
								var params = new Object();
								params.cost=amount;
								params.body="现金充值";
								params.detail = "充值";
								params.outTradeNo  = takeInObject.data.tradeOutNo;
								request(url,callback,params);
							}else{
								showToast("网络繁忙，请稍后再试",5000);
							}
							
						}
						
						request(url,callback,params);
					});
					
				}
				
				
				function reloadDetail(){
					var url = "/api/draw/personal_center/apply_forms";
					var callback = new Object();
					callback.success = function(obj){
						if(obj.success){
							var array = obj.data;
							$(".amount_details").empty();
							for(var i=0;i<obj.data.length;i++){
								var item = obj.data[i];
								
								var type ;
								if(item.type==0){
									type = "提现";
								}
								
								if(item.type==1){
									type = "充值";
								}
								
								
								var applyTime = item.applyTime;
								
								var amount = item.realHandleAmount;
								
								var status;
								if(item.status==0){
									status = "申请成功<span>将在48个小时内到账</span>";	
								}else if(item.status==1){
									status = "申请中<span>已到账</span>";
								}else if(item.status==2){
									status = "申请成功<span>将在48个小时内到账</span>";
								}
								
								
								 var el =  "<div class='amount_detail_item'>";
								 
								 el = el + "<div class='amount_detail_item_span1'>"
								 el = el + "<div class='amount_detail_item_span1_type'>"+type+"</div>";
									
								 el = el + "<div class='amount_detail_item_span1_time'>"+applyTime+"</div>";
								 el = el + "</div>";
								
								 el = el + "<div class='amount_detail_item_span2'>";
								 el = el + "<div class='amount_detail_item_span2_money'>"+amount+"</div>";
								 el = el + "<div class='amount_detail_item_span2_status'>"+status+"</div>";
								 el = el + "</div>";
								 el = el + "</div>";
								 
								 $(".amount_details").append(el);
							}
							
							
						}
					}
					request(url,callback);
				}
				
				$(document).ready(function(){
					reloadDetail();
				});
			
				
			</script>
			
</tiles:putAttribute>
</tiles:insertDefinition>

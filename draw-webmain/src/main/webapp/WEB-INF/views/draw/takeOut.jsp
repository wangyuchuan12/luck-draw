<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="frameLayout">
<tiles:putAttribute name="title">提取现金</tiles:putAttribute>
<tiles:putAttribute name="body">
			<input name="amountBalance" value="${user.amountBalance}" type="hidden"></input>
			
			<input name="canTakeOutCount" value="${user.canTakeOutCount}" type="hidden"></input>
			<div class="luck_info_head">
				<div class="luck_info_head_background"></div>
				<div class="luck_info_head_title">提取现金</div>
				<div class="luck_info_head_img">
					<img src="${user.headimgurl}"></img>
				</div>
				<div class="luck_info_head_name">${user.nickname}</div>

			</div>
			
			<div class="take_out_balance">余额<span>${user.amountBalance}</span>元</div>
			
			<div class="take_out_out">本月剩余可提现<span>${user.canTakeOutCount}</span>次</div>
			
			<div class="take_out_list">
				<div class="take_out_item" onclick="takeOut(5);">
					<div class="take_out_item_money">5<span>元</span></div>
				</div>
				
				<div class="take_out_item" onclick="takeOut(10);">
					<div class="take_out_item_money">10<span>元</span></div>
				</div>
				
				<div class="take_out_item" onclick="takeOut(20);">
					<div class="take_out_item_money">20<span>元</span></div>
				</div>
				
				<div class="take_out_item" onclick="takeOut(50);">
					<div class="take_out_item_money">50<span>元</span></div>
				</div>
				
				<div class="take_out_item" onclick="takeOut(100);">
					<div class="take_out_item_money">100<span>元</span></div>
				</div>
				
				<div class="take_out_item" onclick="takeOut(200);">
					<div class="take_out_item_money">200<span>元</span></div>
				</div>
			</div>
			
			
			<div class="amount_details">
			
				<!--  <div class="amount_details_header">申请记录</div>-->
				
			</div>
			
			
			<script type="text/javascript">
				function takeOut(amount){
					var amountBalance = $("input[name=amountBalance]").val();
					amountBalance = parseFloat(amountBalance);
					amount = parseFloat(amount);
					
					if(amountBalance<amount){
						showToast("账号余额已小于"+amount+"元，不可提现",5000);
						return;
					}
					
					var canTakeOutCount = $("input[name=canTakeOutCount]").val();
					canTakeOutCount = parseFloat(canTakeOutCount);
					if(canTakeOutCount<1){
						showToast("本月可提现次数已用完",5000);
						return;
					}
					layer.confirm("是否确定申请提现，将收取1%的手续费",function(){
						layer.closeAll();
						showLoading();
						var url = "/api/draw/personal_center/take_out_amount";
						var params = new Object();
						params.amount = amount;
						var callback = new Object();
						callback.success = function(obj){
							hideLoading();
							
							if(obj.success){
								amountBalance = amountBalance - amount;
								amountBalance = parseFloat(amountBalance);
								amountBalance = amountBalance.toFixed(2);
								$("input[name=amountBalance]").val(amountBalance);
								$(".take_out_balance span").text(amountBalance);
								var canTakeOutCount = $("input[name=canTakeOutCount]").val();
								canTakeOutCount = parseInt(canTakeOutCount);
								canTakeOutCount = canTakeOutCount-1;
								$("input[name=canTakeOutCount]").val(canTakeOutCount);
								$(".take_out_out span").text(canTakeOutCount);
								reloadDetail();
								showToast("申请成功",5000);
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

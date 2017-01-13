<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="resourceLayout">
<tiles:putAttribute name="title">提取现金</tiles:putAttribute>
<tiles:putAttribute name="body">

			<div class="luck_info_head">
				<div class="luck_info_head_background"></div>
				<div class="luck_info_head_title">提取现金</div>
				<div class="luck_info_head_img">
					<img src="http://wx.qlogo.cn/mmopen/Q3auHgzwzM6iaCq2JwzfpkLPLREt1m1UcUoy17zzkNwgeAWqs6nHY1svj2NfMethmUqVpicG80yYdWn524E6fyBtpJB1CYhEB83yicLicJbUZ5U/0"></img>
				</div>
				<div class="luck_info_head_name">川川</div>

			</div>
			
			<div class="take_out_balance">余额50元</div>
			
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
			
			
			
			<script type="text/javascript">
				function takeOut(amount){
					showLoading();
					var url = "/api/draw/personal_center/take_out_amount";
					var params = new Object();
					params.amount = amount;
					var callback = new Object();
					callback.success = function(obj){
						var url = "/api/pay/wx/choose_wx_pay_config";
						var callback = new Object();
						callback.success = function(obj){
							hideLoading();
							var payCallback = new Object();
							payCallback.success = function(){
								alert("支付成功");
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
						
						var params = new Object();
						params.cost=amount;
						params.body="发布问答红包";
						params.detail = "问答红包";
						params.outTradeNo  = obj.data.tradeOutNo;
						request(url,callback,params);
					}
					
					request(url,callback,params);
				}
			
				
			</script>
			
</tiles:putAttribute>
</tiles:insertDefinition>

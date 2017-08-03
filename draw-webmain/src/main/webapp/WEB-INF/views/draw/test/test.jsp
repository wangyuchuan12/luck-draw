<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="formLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
<tiles:putAttribute name="body">



<script type="text/javascript">
	$(document).ready(function(){
		var url = "/api/pay/wx/choose_good_wx_pay_config";
		
		var callback = new Object();
		callback.success = function(resp){
			
			alert(JSON.stringify(resp));
			if(resp.success){
				var data = resp.data;
				
				var payCallback = new Object();
				payCallback.success = function(){
					alert("success");
				}
				onBridgeReady(data.appId,data.timestamp,data.nonceStr,data.pack,data.signType,data.paySign,payCallback);
			}
		}
		
		callback.failure = function(){
			
		}
		
		var params = new Object();
		params.goodId = 1;
		params.costType=1;
		params.type=2;
		request(url,callback,params);
		alert("success");
	});
</script>

</tiles:putAttribute>
</tiles:insertDefinition>
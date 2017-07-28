<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="plugLayout">
	<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
	<tiles:putAttribute name="body">
		
		<div class="rankRewardPlug">
			<div class="battleInfoBanner">
				 奖励
			</div>
			<ul>
			</ul>
		</div>		
	</tiles:putAttribute>
</tiles:insertDefinition>


<script type="text/javascript">
	function init(battleId){
		var rewardPlug = new FlowPlug({
			begin:function(){
				var outThis = this;
				this.setNext("requestData",function(array){
					if(array&&array.length>0){
						for(var i = 0;i<array.length;i++){
							var object = array[i];
							var content = "第"+object.rank+"名:";
							if(object.rewardBean&&object.rewardBean>0){
								content = content+"<div class='personalAttrDataHeader personalAttrDataHeaderBean'></div>*"+object.rewardBean+"<br/>";
							}
							
							if(object.rewardLove&&object.rewardLove>0){
								content = content+"<div class='personalAttrDataHeader personalAttrDataHeaderLove'></div>*"+object.rewardLove+"<br/>";
							}
							
							if(object.rewardMoney&&object.rewardMoney>0){
								content = content+"<div class='personalAttrDataHeader personalAttrDataHeaderMoney'></div>*"+object.rewardMoney+"<br/>";
							}
							
							if(object.rewardMasonry&&object.rewardMasonry>0){
								content = content+"<div class='personalAttrDataHeader personalAttrDataHeaderMasonry'></div>*"+object.rewardMasonry+"<br/>";
							}
						//	content = content.substring(0,content.lastIndexOf(","));
							
							outThis.setNext("addItem");
							outThis.nextData({
								content:content
							});
							outThis.next();
						}
					}
				});
				this.next();
			},
			addItem:function(){
				var content = this.stepData("content");
				$(".rankRewardPlug>ul").append("<li>"+content+"</li>");
				
				toLeftCenter(".rankRewardPlug>ul>li");
			},
			requestData:function(){
				var outThis = this;
				var url = "/api/main/battleRewards";
				var params = new Object();
				params.battleId = battleId;
				
				var callback = new Object();
				callback.success = function(resp){
					if(resp.success){
						outThis.success(resp.data);
					}
				}
				request(url,callback,params);
			}
		});
	}
</script>
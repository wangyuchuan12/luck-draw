<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>


<tiles:insertDefinition name="resourceLayout">
	<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
	<tiles:putAttribute name="body">
		<div class="battleInfo">
			<div class="battleInfoContent">
				<ul>
					<li>
						<div class="battleInfoContentTitle">排名</div>
						<div class="battleInfoContentInput">
							<span class="battleInfoContentInputRankIcon"></span>
							<span class="battleInfoContentInputText">22名</span>
						</div>
					</li>
					
					<li>
						<div class="battleInfoContentTitle">积分</div>
						<div class="battleInfoContentInput">
							<span class="battleInfoContentInputSportsIcon"></span>
							<span class="battleInfoContentInputText">520分</span>
						</div>
					</li>
					
					<li>
						<div class="battleInfoContentTitle">剩余爱心</div>
						<div class="battleInfoContentInput">
							<div class="personalAttrDataHeaderBig personalAttrDataHeaderLoveBig"></div>
							<div class="personalAttrDataHeaderBig personalAttrDataHeaderLoveBig"></div>
							<div class="personalAttrDataHeaderBig personalAttrDataHeaderLoveHollowBig"></div>
						</div>
					</li>
				</ul>
			</div>
			
			
			<div class="mainViewButtons" style="margin-top: 50px;">
				<div class="mainViewDekornButton" style="display: inline-block;" id="dekornButton">挑战</div>
			</div>
		</div>
		<script type="text/javascript">
			$(document).ready(function(){
				
				var progressCallback = new Object();
				progressCallback.complete = function(){
					var left = $("#modelPhy").offset().left;
					var top = $("#modelPhy").offset().top;
					showMsg("确定",left-70,top-60);
				}
				
				
				progress(100,10,progressCallback);
				
				$("#dekornButton").click(function(){
					window.parent.startDekorn();
				});
				
				
			});
			
			
		</script>
	</tiles:putAttribute>
</tiles:insertDefinition>

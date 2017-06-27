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
						<div class="battleInfoContentTitle" id="round"></div>
						<div class="battleInfoContentInput">
							<span class="battleInfoContentInputSportsIcon"></span>
							<span class="battleInfoContentInputText" id="thisScore"></span>
						</div>
					</li>
					
					<li>
						<div class="battleInfoContentTitle">总得分</div>
						<div class="battleInfoContentInput">
							<span class="battleInfoContentInputSportsIcon"></span>
							<span class="battleInfoContentInputText" id="allScore"></span>
						</div>
					</li>
					
					<li>
						<div class="battleInfoContentTitle">智慧豆</div>
						<div class="battleInfoContentInput">
							<span class="battleInfoContentInputBeanIcon"></span>
							<span class="battleInfoContentInputText" id="beanNum"></span>
						</div>
					</li>
				
					<li>
						<div class="battleInfoContentTitle">排名</div>
						<div class="battleInfoContentInput">
							<span class="battleInfoContentInputRankIcon"></span>
							<span class="battleInfoContentInputText" id="rank"></span>
						</div>
					</li>
					
					
					
					<li>
						<div class="battleInfoContentTitle">剩余爱心</div>
						<div class="battleInfoContentInput" id="loves">
							
						</div>
					</li>
				</ul>
			</div>
			
			
			<div class="mainViewButtons" style="margin-top:0px;">
				<div class="mainViewDekornButton" style="display: inline-block;" id="dekornButton">查看答题</div>
				<div class="mainViewDekornButton" style="display: inline-block;" id="dekornButton">挑战</div>
			</div>
		</div>
		<script type="text/javascript">
		
			var mainCallback;
			function init(cb){
				mainCallback = cb;
				var battlePlug = new FlowPlug({
					begin:function(){
						mainCallback.setBattleFlowPlug(this);
					},
					initData:function(){
						var outThis = this;
						this.flowData({
							round:outThis.stepData("round"),
							thisScore:outThis.stepData("thisScore"),
							allScore:outThis.stepData("allScore"),
							beanNum:outThis.stepData("beanNum"),
							loveCount:outThis.stepData("loveCount"),
							loveLimit:outThis.stepData("loveLimit"),
							rank:outThis.stepData("rank")
						});
						this.success();
						
					},
					
					setBattleId:function(){
						var outThis = this;
						this.flowData({
							battleId:outThis.stepData("battleId")
						});
					},
					
					showView:function(){
						var round = this.flowData("round");
						var thisScore = this.flowData("thisScore");
						var allScore = this.flowData("allScore");
						var beanNum = this.flowData("beanNum");
						var loveCount = this.flowData("loveCount");
						var loveLimit = this.flowData("loveLimit");
						var rank = this.flowData("rank");
						
						$("#round").text("第"+round+"轮");
						$("#thisScore").text(thisScore+"分");
						$("#allScore").text(allScore+"分");
						$("#beanNum").text("+"+beanNum+"颗");
						$("#rank").text(rank+"名");
						
						$("#loves").empty();
						for(var i = 0;i<loveCount;i++){
							var loveDiv = $("<div></div>");
							loveDiv.attr("class","personalAttrDataHeaderBig personalAttrDataHeaderLoveBig");
							$("#loves").append(loveDiv);
						}
						for(var i = 0;i<loveLimit-loveCount;i++){
							var loveHollowDiv = $("<div></div>");
							loveHollowDiv.attr("class","personalAttrDataHeaderBig personalAttrDataHeaderLoveHollowBig");
							$("#loves").append(loveHollowDiv);
						}
						
					}
				});
				
				
				$("#dekornButton").click(function(){
					var battleId = battlePlug.flowPlug.flowData("battleId");
					var round = battlePlug.flowPlug.flowData("round");
					window.parent.startDekorn(battleId);
				});
			}
			$(document).ready(function(){
				
				var progressCallback = new Object();
				progressCallback.complete = function(){
				}
				progress(100,10,progressCallback);
				
			});
			
			
		</script>
	</tiles:putAttribute>
</tiles:insertDefinition>

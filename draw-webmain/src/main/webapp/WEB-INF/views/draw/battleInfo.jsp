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
			<div class="passFlag">
				<img src="http://on3s1z2us.bkt.clouddn.com/pass.png">
			</div>
			<div class="battleInfoTitle">第<span id="battleInfoBannerRound">五</span>关</div>
			<div class="battleInfoBanner">
				目标：20分
			</div>
			
			<div class="red_packet_comment_star_img" id="accordStar"></div>
		
			
			 
			<div class="battleInfoContent">
				<ul>
				<!--  
					
					
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
				-->
				
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
				<div class="mainViewDekornButton" style="display: inline-block;" id="lastButton">上一关</div>
				<div class="mainViewDekornButton" style="display: inline-block;" id="showResult">查看答题</div>
				<div class="mainViewDekornButton" style="display: inline-block;" id="dekornButton">挑战</div>
				<div class="mainViewDekornButton" style="display: inline-block;" id="nextButton">下一关</div>
			</div>
			
			<div class="battleInfoReward">
				<div class="battleInfoRewardContent">
					<ul>
						<li>
							<div class="battleInfoRewardContentScore">5分</div>
							<div class="battleInfoRewardContentImg" style="background: url('http://7xugu1.com1.z0.glb.clouddn.com/lifeLoveSolid.png');background-size:100% 100%;background-color:RGBA(44,147,232,1);">454</div>
							<div style="width:100%;text-align: center;">第1题</div>
						</li>
						
						<li>
							<div class="battleInfoRewardContentScore">3分</div>
							<div class="battleInfoRewardContentImg gray" style="background: url('/imgs/plug/bean.png');background-size:100% 100%;background-color:RGBA(231,93,247,1);">454</div>
							<div style="width:100%;text-align: center;">第2题</div>
						</li>
						
						<li>
							<div class="battleInfoRewardContentScore">3分</div>
							<div class="battleInfoRewardContentImg gray" style="background: url('/imgs/plug/bean.png');background-size:100% 100%;background-color:RGBA(231,93,247,1);">454</div>
							<div style="width:100%;text-align: center;">第2题</div>
						</li>



					</ul>
				</div>
			</div>
		</div>
		<script type="text/javascript">
		
			var mainCallback;
			
			function initStar(){
				$.fn.raty.defaults.path="/raty/img";
				$("#accordStar").raty({
					score:$("input[name=accordStar]").val(),
					size:50,
					click:function(num){
						//$("input[name=accordStar]").val(num);
					}
				});
			}
			function init(cb){
				mainCallback = cb;
				var battlePlug = new FlowPlug({
					begin:function(){
						mainCallback.setBattleFlowPlug(this);
						initStar();
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
							rank:outThis.stepData("rank"),
							maxStage:outThis.stepData("maxStage"),
							stageStatus:outThis.stepData("stageStatus")
						});
						this.success();
						
					},
					
					setBattleId:function(){
						var outThis = this;
						this.flowData({
							battleId:outThis.stepData("battleId")
						});
					},
					
					passAnimate:function(){
						$(".passFlag").css("width","800px");
						$(".passFlag").css("height","800px");
						$(".passFlag").animate({
							width:"500px",
							height:"500px"
						},2000,function(){
							$(".passFlag").animate({
								width:"100px",
								height:"100px"
							},500);
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
						var maxStage = this.flowData("maxStage");
						var stageStatus = this.flowData("stageStatus");
						
						$("#round").text("第"+round+"关");
						$("#thisScore").text(thisScore+"分");
						$("#allScore").text(allScore+"分");
						$("#beanNum").text("+"+beanNum+"颗");
						$("#rank").text(rank+"名");
						$("#battleInfoBannerRound").text(round);
						
						$("#loves").empty();
						
						if(stageStatus==1||stageStatus==0){
							$("#dekornButton").removeClass("gray");
							$("#dekornButton").bind("click");
							$("#dekornButton").click(function(){
								var battleId = battlePlug.flowPlug.flowData("battleId");
								var round = battlePlug.flowPlug.flowData("round");
								var stageStatus = battlePlug.flowPlug.flowData("stageStatus");
								if(stageStatus==2){
									//window.parent.startDekorn(battleId,parseInt(round)+1);
								}else{
									window.parent.startDekorn(battleId,parseInt(round));
								}
								
							});
						}else {
						//	$("#dekornButton").text("下一题");
							console.log("maxStage:"+maxStage);
							if(round>=maxStage){
								
							}else{
								$("#dekornButton").removeClass("gray");
							}
							
							$("#dekornButton").unbind("click");
							$("#dekornButton").addClass("gray");
							
						}
						
						if(round>=maxStage||stageStatus!=2){
							$("#nextButton").addClass("gray");
							$("#nextButton").unbind("click");
						}else{
							$("#nextButton").removeClass("gray");
							$("#nextButton").bind("click");
							
							$("#nextButton").click(function(){
								var battleId = battlePlug.flowPlug.flowData("battleId");
								var round = battlePlug.flowPlug.flowData("round");
								window.parent.startBattle(parseInt(round)+1);
							});
						}
						for(var i = 0;i<loveCount;i++){
							var loveDiv = $("<div></div>");
							loveDiv.attr("class","personalAttrDataHeader personalAttrDataHeaderLove");
							$("#loves").append(loveDiv);
						}
						for(var i = 0;i<loveLimit-loveCount;i++){
							var loveHollowDiv = $("<div></div>");
							loveHollowDiv.attr("class","personalAttrDataHeader personalAttrDataHeaderLoveHollow");
							$("#loves").append(loveHollowDiv);
						}
						
					}
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

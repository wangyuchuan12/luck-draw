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
			<div class="passFlag" style="display: none;">
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
				
					<li id="battleInfoRound">
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
					
					
					
					<li id="battleInfoLove">
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
			function init(cb){
				mainCallback = cb;
				var battlePlug = new FlowPlug({
					begin:function(){
						var outThis = this;
						mainCallback.setBattleFlowPlug(this);
						
						$("#dekornButton").click(function(){
							var dekornEnable = outThis.flowData("dekornEnable");
							
							if(dekornEnable==1){
								var battleId = battlePlug.flowPlug.flowData("battleId");
								var round = battlePlug.flowPlug.flowData("round");
								var stageStatus = battlePlug.flowPlug.flowData("stageStatus");
								if(stageStatus==2){
									//window.parent.startDekorn(battleId,parseInt(round)+1);
								}else{
									window.parent.startDekorn(battleId,parseInt(round));
								}
							}
						});
						
						$("#nextButton").click(function(){
							var nextEnable = outThis.flowData("nextEnable");
							if(nextEnable==1){
								var battleId = battlePlug.flowPlug.flowData("battleId");
								var round = battlePlug.flowPlug.flowData("round");
								window.parent.startBattle(parseInt(round)+1);
							}
							
						});
					},
					
					initStar:function(){
						var score = this.stepData("score");
						$.fn.raty.defaults.path="/raty/img";
						$("#accordStar").raty({
							score:score,
							size:50,
							readOnly:true,
							number:4,
							click:function(num){
								//$("input[name=accordStar]").val(num);
							}
						});
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
							stageStatus:outThis.stepData("stageStatus"),
							status:outThis.stepData("status"),
							passScore:outThis.stepData("passScore"),
							passScore2:outThis.stepData("passScore2"),
							passScore3:outThis.stepData("passScore3"),
							passScore4:outThis.stepData("passScore4")
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
						$(".passFlag").css("display","block");
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
						
						var isPassAnimate = this.stepData("isPassAnimate");
						$(".passFlag").css("display","none");
						
						if(isPassAnimate){
							this.setNext("passAnimate");
							this.next();
						}
						var outThis = this;
						var round = this.flowData("round");
						var thisScore = this.flowData("thisScore");
						var allScore = this.flowData("allScore");
						var beanNum = this.flowData("beanNum");
						var loveCount = this.flowData("loveCount");
						var loveLimit = this.flowData("loveLimit");
						var rank = this.flowData("rank");
						var maxStage = this.flowData("maxStage");
						var stageStatus = this.flowData("stageStatus");
						var status = this.flowData("status");
						var passScore = this.flowData("passScore");
						var passScore2 = this.flowData("passScore2");
						var passScore3 = this.flowData("passScore3");
						var passScore4 = this.flowData("passScore4");
						
						if(thisScore>=passScore&&thisScore<passScore2){
							this.setNext("initStar");
							this.nextData({
								score:1
							});
							this.next();
						}else if(thisScore>=passScore2&&thisScore<passScore3){
							this.setNext("initStar");
							this.nextData({
								score:2
							});
							this.next();
						}else if(thisScore>=passScore3&&thisScore<passScore4){
							this.setNext("initStar");
							this.nextData({
								score:3
							});
							this.next();
						}else if(thisScore>=passScore4){
							this.setNext("initStar");
							this.nextData({
								score:4
							});
							this.next();
						}else{
							this.setNext("initStar");
							this.nextData({
								score:0
							});
							this.next();
						}
						
						$("#round").text("第"+round+"关");
						$("#thisScore").text(thisScore+"分");
						$("#allScore").text(allScore+"分");
						$("#beanNum").text("+"+beanNum+"颗");
						$("#rank").text(rank+"名");
						$("#battleInfoBannerRound").text(round);
						if(status==0){
							$("#battleInfoLove").css("display","none");
						}else{
							$("#battleInfoLove").css("display","block");
						}
						
						if(stageStatus==2){
							$("#battleInfoRound").css("display","block");
						}else{
							$("#battleInfoRound").css("display","none");
						}
						
						$("#loves").empty();
	
						
						if(stageStatus==1||stageStatus==0){
							$("#dekornButton").removeClass("gray");
							outThis.flowData({
								dekornEnable:1
							});
							
						}else {
							if(round>=maxStage){
								
							}else{
								$("#dekornButton").removeClass("gray");
							}
							
							$("#dekornButton").addClass("gray");
							
							outThis.flowData({
								dekornEnable:0
							});
							
						}
						
						if(round>=maxStage||stageStatus!=2){
							$("#nextButton").addClass("gray");
							outThis.flowData({
								nextEnable:0
							});
						}else{
							$("#nextButton").removeClass("gray");
							outThis.flowData({
								nextEnable:1
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

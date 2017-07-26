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
			<div id="passFlag" class="passFlag" style="display: none;">
				<img src="http://on3s1z2us.bkt.clouddn.com/pass.png">
			</div>
			
			<div id="unpassFlag" class="passFlag" style="display: none;">
				<img src="http://on3s1z2us.bkt.clouddn.com/unpass.png">
			</div>
			<div class="battleInfoTitle">第<span id="battleInfoBannerRound">五</span>关</div>
			<div class="battleInfoBanner">
				目标：<span id="battleInfoBannerScore">0</span>分
			</div>
			
			<img src="" class="battleInfoDetailImg" id="battleInfoDetailImg">
			<div class="battleInfoDetailName" id="battleInfoDetailName"></div>
			
			
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
				<div class="mainViewDekornButton" style="display: inline-block;" id="reDekornButton">重新挑战</div>
				<div class="mainViewDekornButton" style="display: inline-block;" id="nextButton">下一关</div>
			</div>
			
			<!--  
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
			-->
		</div>
		<script type="text/javascript">
		
			var resultPlug
			var mainCallback;
			
			function closeResult(){
				if(resultPlug){
					resultPlug.close();
				}
			}
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
						
						$("#reDekornButton").click(function(){
							
							
							if(outThis.flowData("reDekornEnable")==1){
								var battleId = battlePlug.flowPlug.flowData("battleId");
								var round = battlePlug.flowPlug.flowData("round");
								var stageStatus = battlePlug.flowPlug.flowData("stageStatus");
								if(stageStatus==2){
									window.parent.reStartDekorn(battleId,parseInt(round));
								}else{
									//window.parent.startDekorn(battleId,parseInt(round));
								}
							}else{
								new AlertPlug("您已经阅读答案，不能重新挑战");
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
						
						$("#lastButton").click(function(){
							var lastEnable = outThis.flowData("lastEnable");
							lastEnable= 1;
							if(lastEnable==1){
								var battleId = battlePlug.flowPlug.flowData("battleId");
								var round = battlePlug.flowPlug.flowData("round");
								window.parent.startBattle(parseInt(round)-1);
							}
							
						});
						
						$("#showResult").click(function(){
						
							var waitPlug = new WaitPlug();
							var round = window.parent.applyReadResultHandle(outThis.flowData("round"),{
								success:function(){
									outThis.setNext("showResult");
									outThis.next();
									waitPlug.close();
								}
							});
							
						});
						
						this.setNext("popHandle");
						this.next();
					},
					showResult:function(){
						var url = "/view/question/questionresult?paperId="+this.flowData("paperId")+"&keyId="+this.flowData("memberId");
						
						resultPlug = new LayerPlug(url,1,1,"",function(){
							
						});
						
						resultPlug.show();
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
							isPass:outThis.stepData("isPass"),
							name:outThis.stepData("name"),
							imgUrl:outThis.stepData("imgUrl"),
							paperId:outThis.stepData("paperId"),
							memberId:outThis.stepData("memberId"),
							isReadResult:outThis.stepData("isReadResult"),
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
					
					//回退键监听
					popHandle:function(){
						var outThis = this;
						$(function(){  
						    pushHistory();  
						    window.addEventListener("popstate", function(e) {
						    	var popFlag = outThis.flowData("popFlag");
						    	window.parent.battlePop();
						        pushHistory();
						        if(popFlag==1){
						        	outThis.flowData({
						        		popFlag:0
						        	});
						        }
							}, false);    
						});
						
						function pushHistory() {  
					        var state = {  
					             title: "title",  
					             url: "#"  
					        };  
					        window.history.pushState(state, "title", "#");  
						}
						
						
					},
					
					passAnimate:function(){
						
						var passFlag = null;
						var isPass = this.flowData("isPass");
						if(isPass == 1){
							passFlag = $("#passFlag");
							passFlag.css("display","block");
						}else if(isPass==0){
							passFlag = $("#unpassFlag");
							passFlag.css("display","block");
						}
						
						
						passFlag.css("width","800px");
						passFlag.css("height","800px");
						passFlag.css("display","block");
						passFlag.animate({
							width:"500px",
							height:"500px"
						},2000,function(){
							passFlag.animate({
								width:"100px",
								height:"100px"
							},500);
						});
					},
									
					showView:function(){
						
						this.flowData({popFlag:1});
						var isPassAnimate = this.stepData("isPassAnimate");
						
						
						if(isPassAnimate==1){
							this.setNext("passAnimate");
							this.next();
						}
						var isPass = this.flowData("isPass");
						
						var passFlag = $("#passFlag");

						if(isPass==1){
							$("#passFlag").css("display","block");
							$("#unpassFlag").css("display","none");
						}else if(isPass==0){
							$("#unpassFlag").css("display","block");
							$("#passFlag").css("display","none");
						}else{
							$("#unpassFlag").css("display","none");
							$("#passFlag").css("display","none");
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
						var name = this.flowData("name");
						var imgUrl = this.flowData("imgUrl");
						var isReadResult = this.flowData("isReadResult");
						if(imgUrl){
							$("#battleInfoDetailImg").attr("src",imgUrl);
						}
						
						if(name){
							$("#battleInfoDetailName").text(name);
						}
						
						var passScore = this.flowData("passScore");
						var passScore2 = this.flowData("passScore2");
						var passScore3 = this.flowData("passScore3");
						var passScore4 = this.flowData("passScore4");
						
						$("#battleInfoBannerScore").text(passScore);
							
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
	
						console.log("isReadResult:"+isReadResult);
						if(isReadResult==1){
							$("#reDekornButton").addClass("gray");
							outThis.flowData({
								reDekornEnable:0
							});
						}else{
							$("#reDekornButton").removeClass("gray");
							outThis.flowData({
								reDekornEnable:1
							});
						}
						
						if(stageStatus==1||stageStatus==0){
							$("#dekornButton").removeClass("gray");
							outThis.flowData({
								dekornEnable:1
							});
							
							$("#dekornButton").css("display","inline-block");
							
							$("#reDekornButton").css("display","none");
							
						}else {
							if(round>=maxStage){
								
							}else{
								$("#dekornButton").removeClass("gray");
							}
							
							$("#dekornButton").css("display","none");
							
							$("#dekornButton").addClass("gray");
							
							outThis.flowData({
								dekornEnable:0
							});
							
							$("#reDekornButton").css("display","inline-block");
							
						}
						
						if(round>=maxStage||stageStatus!=2||isPass!=1){
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
						
						if(round<=1){
							$("#lastButton").addClass("gray");
							outThis.flowData({
								lastEnable:0
							});
						}else{
							$("#lastButton").removeClass("gray");
							outThis.flowData({
								lastEnable:1
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
					/*attrPlug.flowPlug.setNext("showView");
					attrPlug.flowPlug.next();
					
					attrPlug.flowPlug.setNext("hideBean");
					attrPlug.flowPlug.next();
					
					attrPlug.flowPlug.setNext("hideMoney");
					attrPlug.flowPlug.next();
					
					attrPlug.flowPlug.setNext("hideMasonry");
					attrPlug.flowPlug.next();*/
				}
				progress(100,10,progressCallback);
				
			});
			
			
		</script>
	</tiles:putAttribute>
</tiles:insertDefinition>

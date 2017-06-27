<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>


<tiles:insertDefinition name="resourceLayout">
	<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
	<tiles:putAttribute name="body">
	
		<div class="mainView">
			<div class="mainViewDekorn">
				<ul>
					<li>
						<div class='mainViewCover'>
							<img src='http://oqcfht5ij.bkt.clouddn.com/baby.jpg'/>
						</div>
					
						<div class="mainViewButtons">
							<div class="mainViewDekornButton" style="display: inline-block;" id="mainViewDekornButton">挑战</div>
						</div>
						
						
						<!--  
						<div class="mainViewDekornInfo">
							<div class="mainViewDekornImg">
								<img src="http://ooe8ianrr.bkt.clouddn.com/znm123.png">
							</div>
							<div class="mainViewDekornInfoDetail">
								<div><span>名称：</span><span>小鸟飞飞</span></div>
								<div><span>类型：</span><span>游戏</span><span style="padding-left: 20px;">擂台分数：</span><span>300分</span></div>
								<div><span>积分：</span><span>300分 </span><span style="padding-left:20px;">级别：</span><span>3段</span></div>
								<div><span>挑战数：</span><span>5</span><span style="padding-left: 20px;">胜：</span><span>2</span> <span>负：</span><span>5</span></div>								
								<div><span>被挑战：</span><span>5</span><span style="padding-left: 20px;">胜：</span><span>2</span> <span>负：</span><span>5</span></div>
																
							</div>
						</div>
						-->
					
						<div class="redPacketBar">
							<ul>
								
								<li style="background:url('http://oq4mi1sbl.bkt.clouddn.com/redPacketBackground.gif');background-size:100% 100%;">
									<div class="redPacketImg">
										<div class="redPacketHeadImg">
											<img src="/imgs/happy.jpg">
										</div>
										<div class="redPacketBarType">竞答红包</div>
									</div>
								</li>
								
								<li style="background:url('http://oq4mi1sbl.bkt.clouddn.com/redPacketBackground.gif');background-size:100% 100%;">
									<div class="arenaImg">
										<div class="redPacketHeadImg">
											<img src="/imgs/happy.jpg">
										</div>
										<div class="redPacketBarType">挑战</div>
									</div>
								</li>
								
								<li style="background:url('http://oq4mi1sbl.bkt.clouddn.com/redPacketBackground.gif');background-size:100% 100%;">
									<div class="addImg">
						
						
									</div>
								</li>
								
								<li style="background:url('http://oq4mi1sbl.bkt.clouddn.com/redPacketBackground.gif');background-size:100% 100%;"></li>
								
								<li style="background:url('http://oq4mi1sbl.bkt.clouddn.com/redPacketBackground.gif');background-size:100% 100%;"></li>
								
								<li style="background:url('http://oq4mi1sbl.bkt.clouddn.com/redPacketBackground.gif');background-size:100% 100%;"></li>
								
								<li style="background:url('http://oq4mi1sbl.bkt.clouddn.com/redPacketBackground.gif');background-size:100% 100%;"></li>
								
								<li style="background:url('http://oq4mi1sbl.bkt.clouddn.com/redPacketBackground.gif');background-size:100% 100%;"></li>
								
								<li style="background:url('http://oq4mi1sbl.bkt.clouddn.com/redPacketBackground.gif');background-size:100% 100%;"></li>
								
								<li style="background:url('http://oq4mi1sbl.bkt.clouddn.com/redPacketBackground.gif');background-size:100% 100%;"></li>
											
							</ul>
						</div>
					</li>
				</ul>
			</div>
			
			
			
			<div class="mainViewFooterButtons">
				<ul>
					<li class="">
					
						<div class="mainViewFooterButton">
							<div class="mainViewFooterButtonIcon_topic"></div>
						</div>
						<div class="mainViewFooterButtonTitle">出题</div>
					</li>
					
					<li>
						<div class="mainViewFooterButton">
							<div class="mainViewFooterButtonIcon_rank"></div>
						</div>
						<div class="mainViewFooterButtonTitle">排行</div>
					
					</li>
					
					<li>
						<div class="mainViewFooterButton">
							<div class="mainViewFooterButtonIcon_news"></div>
						</div>
						<div class="mainViewFooterButtonTitle">消息</div>
					</li>
					
					<li>
						<div class="mainViewFooterButton">
							<div class="mainViewFooterButtonIcon_back"></div>
						</div>
						<div class="mainViewFooterButtonTitle">返回</div>
					</li>
				</ul>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
<style type="text/css">
<!--
.progress-label3{
	position: absolute;
	left:40%;
	font-weight: bold;
	color:RGBA(77,209,255,1);
	height: 20px;
	font-size: 5px;
}
	     	
#progressbarLove_tool .ui-corner-left{
	background: RGBA(225,0,34,1);
	height: 20px;
	border-radius:10px;
	font-size: 5px;
}
-->
</style>


<script type="text/javascript">

	var progressPlug;
	
	var paperPlug;
	
	var battlePlug;
	
	var progressFlowPlug;
	
	var battleFlowPlug;
	
	var mainViewPlug;
	
	var mainViewFlowPlug;

	
	function hideProgressPlug(){
		progressPlug.hide();
	}
	
	function stageEnd(){
		mainViewFlowPlug.setNext("stageEnd");
		mainViewFlowPlug.next();
	}
	
	
	function submitScore(score){
		
		mainViewFlowPlug.setNext("submitScore");
		
		mainViewFlowPlug.next();
	
	}
	
	var index=0;
	
	//由详情页面回调
	function startDekorn(battleId){
		
		mainViewPlug.flowPlug.setNext("startDekorn");
		mainViewPlug.flowPlug.nextData({
			battleId:battleId
		});
		mainViewPlug.flowPlug.next();
		
		
	}
	
	function init(){
		mainViewPlug = new FlowPlug({
			
			//初始化
			begin:function(){
				
				mainViewFlowPlug = this;
				
				modelPlug.showView();
				
				attrPlug.showView();
				
				var outThis = this;
				
				this.setNext("createProgressPlug");
				this.next();
				
				this.setNext("initEventListener");
				this.next();
				
				this.setNext("initBattleInfo");
				this.next();
				
				this.flowData({
					
				});
					
			},
			
			submitScore:function(){
				progressPlug.show();

				paperPlug.close();
				var battleId = this.flowData("currentBattleId");
				
				var stage = mainViewFlowPlug.flowData("round_"+battleId);
				if(!stage||stage==0){
					stage = 1;
				}
				
				progressFlowPlug.setNext("startStage");
				progressFlowPlug.nextData({
					stage:stage
				});
				
				progressFlowPlug.next();
			},
			
			createProgressPlug:function(){
				var url = "/view/dekorn/progressScore";
				progressPlug = new LayerPlug(url,1,1);
				progressPlug.hide();
			},
			
			showProgressPlug:function(){
				progressPlug.show();
				
				this.setNext("initProgressPlug");
				this.next();
			},
			
			initProgressPlug:function(){
				
				var flag = this.flowData("initProgressPlugFlag");
				if(!flag){
					var callback = new Object();
					callback.setProgressFlowPlug = function(plug){
						progressFlowPlug = plug
					}
					progressPlug.call("init",callback);
					
					this.flowData({
						initProgressPlugFlag:true
					});
				}
				
			},
			
			showBattle:function(){
				var outThis = this;
				
				var interval = setInterval(function(){
					var battleReady = outThis.flowData("battleReady");
					if(battleReady==1){
						battlePlug.show();
						battleFlowPlug.setNext("showView");
						battleFlowPlug.next();
						clearInterval(interval);
						outThis.success();
					}
				},100);
			},
			
			//开始挑战
			startDekorn:function(){
				
				var outThis = this;
				
				var battleId = this.flowData("currentBattleId");
				
				var stage = this.flowData("round_"+battleId);
				
				if(!stage||stage==0){
					stage = 1;
				}
				
				this.setNext("showProgressPlug");
				this.next();
				
				progressFlowPlug.setNext("setBattleId");
				progressFlowPlug.nextData({
					battleId:battleId
				});
				progressFlowPlug.next();
				
				
				progressFlowPlug.setNext("initStageIndex");
				
				progressFlowPlug.nextData({
					stageIndexs:stage
				});
				progressFlowPlug.next();

				
				battlePlug.hide();
				
				
				progressFlowPlug.setNext("initData",function(){
					
				});
				
				progressFlowPlug.nextData({
					allScore:outThis.flowData("allScore_"+battleId),
					round:outThis.flowData("round_"+battleId),
					thisScore:outThis.flowData("thisScore_"+battleId),
					rank:outThis.flowData("rank_"+battleId),
					loveLimit:outThis.flowData("loveLimit_"+battleId),
					loveCount:outThis.flowData("loveCount_"+battleId),
				});
				
				
				
				progressFlowPlug.next();
				
				progressFlowPlug.setNext("showData");
				progressFlowPlug.next();
				
				var callback = new Object();

				callback.call = function(){

					progressPlug.hide();
					mainViewFlowPlug.setNext("startPaper");
					mainViewFlowPlug.next();
				}
				
				progressFlowPlug.setNext("toStage");
				progressFlowPlug.nextData({
					stage:stage,
					callback:callback
				});
				progressFlowPlug.next();
			},
			
			//开始答题
			startPaper:function(){
				var url = "/view/question/paperInfo?id=1";
				paperPlug = new LayerPlug(url,1,1,"");
				
				paperPlug.show();
			},
			
			//请求用户信息
			requestBattleMemberInfo:function(){
				var battleId = this.flowData("currentBattleId");
				var outThis = this;
				var url = "/api/main/battleMemberInfo";
				var callback = new Object();
				callback.success = function(resp){
					if(resp.success){
						var data = resp.data;
						outThis.success(data);
					}else{
						outThis.failure();
					}
				}
				var params = new Object();
				params.battleId = battleId;
				request(url,callback,params);
			},
			
			stageEnd:function(){
				var outThis = this;
				var battleId = this.flowData("currentBattleId");
			/*	var stageIndex = this.flowData("round_"+battleId);
				stageIndex++;
				//设置变量
				this.setNext("setParam");
				this.nextData({
					name:"round_"+battleId,
					value:stageIndex
				});
				this.next();*/
				
				
				this.setNext("startBattle");
				this.nextData({
					battleId:battleId
				});
				this.next();
			},
			
			initBattleMemberInfo:function(){
				var outThis = this;
				var battleId = this.flowData("currentBattleId");
				this.setNext("requestBattleMemberInfo",function(data){
					var object = new Object();
					object["round_"+battleId] = data.currentStageIndex;
					object["thisScore_"+battleId] = data.currentStageScore;
					object["allScore_"+battleId] = data.allScore;
					object["beanNum_"+battleId] = data.rewardBeanNum;
					object["loveCount_"+battleId] = data.loveLife;
					object["loveLimit_"+battleId] = data.loveLifeLimit;
					object["rank_"+battleId] = data.rank;
					object["status_"+battleId] = data.status;
					object["currentStageIndex_"+battleId] = data.currentStageIndex;
					object["index_"+battleId] = data.index;
					outThis.flowData(object);
					outThis.success();
				});
				
				this.nextData({
					battleId:battleId
				});
				this.next();
				
				battleFlowPlug.setNext("setBattleId");
				battleFlowPlug.nextData({
					battleId:battleId
				})
				battleFlowPlug.next();
			},
			
			getBattleMemberStages:function(){
				var outThis = this;
				var battleId = this.flowData("currentBattleId");
				if(!this.flowData("stageInitFlag")){
					outThis.setNext("requestBattleMemberStages",function(){
						outThis.success(outThis.flowData("stageInfos"));
					});
					outThis.nextData({
						battleId:battleId
					});
					outThis.next();
				}else{
					outThis.success(outThis.flowData("stageInfos"));
				}
				
			},
			
			requestBattleMemberStages:function(){
				var outThis = this;
				var battleId = this.flowData("currentBattleId");
				var url = "/api/main/battleMemberStages";
				
				var params = new Object();
				params.battleId = battleId;
				var callback = new Object();
				callback.success = function(resp){
					if(resp.success){
						var battleMemberStages = resp.data;
						for(var i = 0;i<battleMemberStages.length;i++){
							outThis.flowData({
								"stageInfos":battleMemberStages
							});
						}
						outThis.success();
					}
				}
				request(url,callback,params);
			},
			
			startBattle:function(){
				progressPlug.hide();
				var outThis = this;
				var battleId = this.flowData("currentBattleId");
				var waitPlug = new WaitPlug();
				outThis.setNext("initBattleMemberInfo",function(data){
					outThis.setNext("setBattleData");
					outThis.nextData({
						battleId:battleId
					});
					outThis.next();
					
					if(outThis.flowData("status_"+battleId)==1){
						outThis.setNext("showBattle",function(){
							waitPlug.close();
						});
						outThis.next();
					}else{
						outThis.setNext("battleTakepart",function(data){
							waitPlug.close();
							var attrFlowPlug = attrPlug.flowPlug;
							attrFlowPlug.setNext("subLoveAction",function(){
								outThis.setNext("showBattle",function(){});
								outThis.next();
								waitPlug.close();
							});
							
							attrFlowPlug.nextData({
								num:data.loveLifeConsume
							});
							attrFlowPlug.next();
							
							
							attrFlowPlug.setNext("subBeanAction",function(){
								outThis.setNext("showBattle",function(){});
								outThis.next();
								waitPlug.close();
							});
							
							attrFlowPlug.nextData({
								num:data.beanConsume
							});
							attrFlowPlug.next();
							
						});
						outThis.nextData({
							battleId:battleId
						});
						outThis.next();
					}
					
				});
				outThis.nextData({
					battleId:battleId
				});
				outThis.next();
			},
			
			//用用户互动的监听器
			initEventListener:function(){
				var outThis = this;
				var battleId = 1;
				
				 this.flowData({
					 currentBattleId:battleId
				 })
					
				$("#mainViewDekornButton").click(function(){
					outThis.setNext("startBattle");
					outThis.nextData({
						battleId:battleId
					});
					outThis.next();
				});
			},
			
			initBattleInfo:function(){
				var outThis = this;
				var battleId = this.flowData("currentBattleId");
				this.setNext("initBattle",function(){
					
					outThis.setNext("setBattleData");
					outThis.next();
					
					this.setNext("getBattleMemberStages",function(data){
						outThis.setNext("initProgressPlug");
						outThis.next();
						
						progressFlowPlug.setNext("initStages");
						progressFlowPlug.nextData({
							array:data
						});
						progressFlowPlug.next();
					});
					this.nextData({
						battleId:battleId
					});
					this.next();
				
				});
				
				this.next();
			},
			
			//参与比赛
			battleTakepart:function(){
				var outThis = this;
				var battleId = this.flowData("currentBattleId");
				var url = "/api/main/battleTakepart";
				var callback = new Object();
				callback.success = function(resp){
					if(resp.success){
						outThis.success(resp.data);
					}else{
						outThis.failure();
					}
					
				}
				var params = new Object();
				params.battleId = battleId;
				params.stageIndexes="1,2,3,4,5,6,7,8,9,10,11,12,13,14,15";
				request(url,callback,params);
			},
			
			setBattleId:function(){
				var battleId = this.stepData("battleId");
				 this.flowData({
					 currentBattleId:battleId
				 })
			},
			
			nextStage:function(){
				var battleId = this.stepData("battleId");
				
				this.setNext("getBattleMemberStages",function(data){
					for(var i=0;i<data.length;i++){
						
					}
				});
				this.next();
			},
			
			//初始化比赛界面
			initBattle:function(){
				var outThis = this;
				battlePlug = new LayerPlug("/view/dekorn/battleInfo",1,1,"",function(){
					var callback = new Object();
					callback.setBattleFlowPlug = function(plug){
						battleFlowPlug = plug;

						outThis.success();
						
						//这个属性是为了告诉系统改插件已经准备好了
						outThis.flowData({battleReady:1});
					}
					
					battlePlug.call("init",callback);
				});
				battlePlug.hide();
			},
			
			//初始化比赛数据
			setBattleData:function(){
				var battleId = this.flowData("currentBattleId");
				var round = this.flowData("round_"+battleId);
				var thisScore = this.flowData("thisScore_"+battleId);
				var allScore = this.flowData("allScore_"+battleId);
				var beanNum = this.flowData("beanNum_"+battleId);
				var loveCount = this.flowData("loveCount_"+battleId);
				var loveLimit = this.flowData("loveLimit_"+battleId);
				var rank = this.flowData("rank_"+battleId);
				battleFlowPlug.setNext("initData");
				
				battleFlowPlug.nextData({
					round:round,
					thisScore:thisScore,
					allScore:allScore,
					beanNum:beanNum,
					loveCount:loveCount,
					loveLimit:loveLimit,
					rank:rank
				});
				
				battleFlowPlug.next();
			}
		});
	}
	
	$(document).ready(function(){

		var progressCallback = new Object();
		progressCallback.complete = function(){
			init();
		}
		
		progress(100,10,progressCallback);
		
		$(".mainView").height($(document).height());
	});


</script>


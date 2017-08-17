function BattleMainPlug(){

	var progressPlug;
	
	var paperPlug;
	
	var battlePlug;
	
	var progressFlowPlug;
	
	var battleFlowPlug;
	
	var mainViewPlug;
	
	var mainViewFlowPlug;
	
	function closeContainer(){
		$("#iframeContair").empty();
		$("#iframeContair").css("display","none");
	}

	function startBattle(stage){
		
		var battleId = mainViewFlowPlug.flowData("currentBattleId");
		
		var url = "/api/main/setCurrentStage";
		var callback = new Object();
		callback.success = function(resp){
			if(resp.success){
				mainViewFlowPlug.setNext("startBattle");
				mainViewFlowPlug.nextData({
					battleId:battleId
				});
				mainViewFlowPlug.next();
			}
		}
		var params = new Object();
		params.stage = stage;
		params.battleId = battleId;
		request(url,callback,params);
		
	}
	
	function applyReadResultHandle(stage,callback){
		mainViewFlowPlug.setNext("applyReadResultHandle",function(){
			
			console.log("........callback");
			callback.success();
		});
		mainViewFlowPlug.nextData({
			stage:stage
		});
		mainViewFlowPlug.next();
	}
	
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
	
	function battlePop(){
		battlePlug.hide();
		battleFlowPlug.flowData({
			popFlag:0
		});
	}
	
	var index=0;
	
	//由详情页面回调
	function startDekorn(battleId,stage){
		
		var object = new Object();
		object["round_"+battleId] = stage;
		mainViewPlug.flowPlug.flowData(object);
		mainViewPlug.flowPlug.setNext("startDekorn");
		mainViewPlug.flowPlug.nextData({
			battleId:battleId
		});
		mainViewPlug.flowPlug.next();
		
	}
	
	function reStartDekorn(battleId,stage){
		var object = new Object();
		object["round_"+battleId] = stage;
		mainViewPlug.flowPlug.flowData(object);
		mainViewPlug.flowPlug.setNext("startDekorn");
		mainViewPlug.flowPlug.nextData({
			battleId:battleId,
			startDekornFlag:1
		});
		mainViewPlug.flowPlug.next();
		
	}
	
	function init(){
		mainViewPlug = new FlowPlug({
			
			//初始化
			begin:function(){
				
				mainViewFlowPlug = this;
				
				modelPlug2.showView();
				
				attrPlug2.showView();
				
				var outThis = this;
				
				this.setNext("createProgressPlug");
				this.next();
				
				this.setNext("initEventListener");
				this.next();
				
				this.setNext("initBattleInfo");
				this.next();
				
				var battleId = $("input[name=battleId]").val();
				
				this.flowData({
					currentBattleId:battleId,
					indexCount:120
				});
				this.setNext("battleInfo");
				this.next();
				
				
			
			},
			
			
			initRankRewardPlug:function(){
				var battleId = this.flowData("currentBattleId");
				var rewardPlug = new LayerPlug("/view/plug/rankRewardPlug",0.9,0.5,"",
						function(){
							rewardPlug.call("init",battleId);
						},
						[{
							text:"确定",
							click:function(){
								rewardPlug.close();
							}
						}]);
				
			},
			initTime:function(){
				var callback = new Object();
				callback.end = function(){
					$("#battleEnd").css("display","block");
				}
				var handTime = this.stepData("beginDate");
				
				console.log("handTime:"+handTime);
				
				var timeLong = this.stepData("timeLong");
				
				handTime = handTime.replace(/-/g,"/");
				initGroupInvalidDate(new Date(handTime),timeLong,".luck_info_situation_time",callback);
			},
			
			//初始化整个地图的样式
			initAllIndexStyle:function(){
				var outThis = this;
				var url = "/api/main/battleIndexes";
				var params = new Object();
				var battleId = this.flowData("currentBattleId");
				params.battleId = battleId;
				var callback  = new Object();
				callback.success = function(resp){
					if(resp.success){
						var data = resp.data;
						for(var i = 0;i<data.length;i++){
							var object = data[i];
							progressFlowPlug.setNext("showIndexStyleHandle");
							progressFlowPlug.nextData({
								iconUrl:object.iconUrl,
								index:object.index,
								isGuide:object.isGuide
							});
							progressFlowPlug.next();
						}
					}
				}
				callback.failure = function(){
					
				}
				
				request(url,callback,params);
			},
			
			addMember:function(){
				var rank = this.stepData("rank");
				var score = this.stepData("score");
				var imgUrl = this.stepData("imgUrl");
				var indexCount = this.flowData("indexCount");
				var index = this.stepData("index");
				var type = this.stepData("type");
				var id = this.stepData("id");
				

			
			
				var elStr="<li style='text-align: center;'>"+
				"<div class='mainViewMembersPkMember flipx' id='m_"+id+"' style='background-size:100% 100%'>"+
					"<div class='mainViewMemberPkImg' id='d_"+id+"'></div>"+
				"</div>"+

				"<ul>"+
					"<li style='width:100%'>"+
					"<div style='display: inline-block;width:20px;height: 15px;background: RGBA(61,212,11,1);color:white;width:35%;vertical-align: top;border-radius:5px;'>进程</div>"+
					"<div id='p_"+id+"' style='width:50%;height:15px;margin:0 auto;position:relative;border-radius:20px;display:inline-block;top: 0px;vertical-align: top;background-color:RGBA(139,76,32,1)'>"+
						"<div class='mainViewMemberProgressLabel' id='l_"+id+"' style='color:RGBA(255,237,109,1);padding-top: 0px;font-size: 10px;'>0</div>"+
					"</div>"+
					"</li>"+
				"</ul>"+
				"<div class='mainViewMembersPkMemberRank'  style='background:RGBA(139,76,32,0.5);color:white' id='i_"+id+"'>第"+rank+"名 "+score+"分</div>"+
				"</li>";
				var el = $(elStr);
				
				
				$(".mainViewMembers>ul").append(el);
				var mainViewMembersPkMemberEl = $("#m_"+id);
				var width = $(document).width();
				mainViewMembersPkMemberEl.width(width/5-10);
				mainViewMembersPkMemberEl.css("margin-left","2px");
				mainViewMembersPkMemberEl.height(mainViewMembersPkMemberEl.width());
				
				if(type==1){
					var inImg = "http://on3s1z2us.bkt.clouddn.com/fc49d5d420a2e378e6d3f9ca23d7cd54.png";
					
					mainViewMembersPkMemberEl.css("background","url('"+inImg+"')");
					
					
					
					
				}else{
					var mainViewMembersPkMemberRankEl = $("#i_"+id);
					var suffix = "....";

					mainViewMembersPkMemberRankEl.text("等待中"+suffix);
				
					mainViewMembersPkMemberRankEl.css("padding-left","0px");
					
					var i = 0;
					/*setInterval(function(){
						i++;
						if(i%5==0){
							suffix = "";
						}else if(i%5==1){
							suffix = ".";
						}else if(i%5==2){
							suffix = "..";
						}else if(i%5==3){
							suffix = "...";
						}else if(i%5==4){
							suffix = "....";
						}
						mainViewMembersPkMemberRankEl.text("等待中"+suffix);
						
						mainViewMembersPkMemberRankEl.css("text-align","left");
						
						mainViewMembersPkMemberRankEl.css("padding-left","20px");
						
					},5000);*/
					
				}
				
				
				var mainViewMemberPkImgEl = $("#d_"+id);
				mainViewMembersPkMemberEl.css("background-size","100% 100%");
				mainViewMemberPkImgEl.css("background","url('"+imgUrl+"')");
				mainViewMemberPkImgEl.css("background-size","100% 100%");
				mainViewMemberPkImgEl.css("top","60%");
				mainViewMemberPkImgEl.css("left","-15%");
				mainViewMemberPkImgEl.css("width","30%");
				mainViewMemberPkImgEl.css("height","30%");
				var progress = new ProgressPlug("#p_"+id,"#l_"+id,{type:2,isShowProgress:1,count:indexCount,decimal:2});

				progress.setValue(index);
				
				progress.showValue();
				
				progress.setValueBg("red");
				
			},
			
			initMembers:function(){
				var members = this.stepData("members");
				var rankInfo = this.stepData("rankInfo");
				var memberMin = rankInfo.memberMin;
				var memberMax = rankInfo.memberMax;
				for(var i = 0;i<members.length;i++){
					var member = members[i];
					this.setNext("addMember");
					this.nextData({
						rank:1,
						score:member.score,
						imgUrl:member.memberImg,
						index:member.index,
						id:member.memberId,
						type:1
						
					});
					this.next();
				}
				
				for(var i = 0;i<memberMax-members.length;i++){
					this.setNext("addMember");
					this.nextData({
						rank:1,
						score:100,
						imgUrl:"",
						index:0,
						id:"free_"+i,
						type:0
						
					});
					this.next();
				}
			},
			
			showFooterButtons:function(){
				var readyButton = $("#mainViewReadyButton");
				var startButton = $("#mainViewStartButton");
				var thisRankMember = this.flowData("thisRankMember");
				if(thisRankMember){
					startButton.css("display","inline-block");
					readyButton.css("display","none");
				}else{
					startButton.css("display","none");
					readyButton.css("display","inline-block");
				}
			},
			
			showButton:function(){
				var status = this.stepData("status");
				
				
				if(status==1){
					
				}else{
					//$("#mainViewStartButton").css("display","none");
					//$("#startButton").css("display","none");
				}
			},
			
			battleInfo:function(){
				var outThis = this;
				var url = "/api/main/battleInfo";
				var callback = new Object();
				callback.success = function(resp){
					if(resp.success){
						var data = resp.data;

						var name = data.name;
						var imgUrl = data.imgUrl;
						var instruction = data.instruction;
						var rankMembers = data.rankMembers;
						var thisMember = data.thisMember;
						
						var indexCount = data.stageIndexCount;
						
						var beginDate = data.beginDate;
						
						var timeLong = data.timeLong;
						
						var status = data.status;
						
						outThis.flowData({
							currentBattleId:data.id,
							beanConsume:data.beanConsume,
							loveConsume:data.loveConsume
						});
						
						if(status==0||status==1){
							outThis.setNext("initRankRewardPlug");
							outThis.next();
						}
						
						outThis.setNext("initTime");
						outThis.nextData({
							beginDate:beginDate,
							timeLong:timeLong
						});
						
						outThis.next();
						
						outThis.flowData({
							indexCount:indexCount
						});
						
						outThis.flowData({
							thisRankMember:thisMember
						});
						if(rankMembers){
							outThis.setNext("initMembers");
							outThis.nextData({
								members:rankMembers,
								rankInfo:data.battleRank
							});
							outThis.next();
						}
						
						$("#battleInfoName").text(name);
						$("#battleInfoImg").attr("src",imgUrl);
						$("#battleInfoInstruction").text(instruction);
						waitProgress.addProgress(40,10);
						
						outThis.setNext("showFooterButtons");
						outThis.next();
						
						outThis.setNext("showButton");
						outThis.nextData({
							status:status
						});
						outThis.next();
					
					}
				}
				
				var params = new Object();
				params.battleId = this.flowData("currentBattleId");
				request(url,callback,params);
			},
			
			submitScore:function(){
				this.setNext("submitResult",function(){
					progressPlug.show();

					progressFlowPlug.setNext("pullAttrData");
					progressFlowPlug.next();
					
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
				});
				this.next();
			},
			
			createProgressPlug:function(){
				var outThis = this;
				var url = "/view/dekorn/progressScore";
				progressPlug = new ProgressScoreLayer({
					success:function(){
						var flag = outThis.flowData("initProgressPlugFlag");
						if(!flag){
							var callback = new Object();
							callback.setProgressFlowPlug = function(plug){
								progressFlowPlug = plug;
							}
							progressPlug.init(callback);
							
							outThis.flowData({
								initProgressPlugFlag:1
							});
							
							
							outThis.setNext("initAllIndexStyle");
							outThis.next();
						}
					}
				});
				
			},
			
			showProgressPlug:function(){
				progressPlug.show();
			},
			
			showBattle:function(){
				var outThis = this;
				var isPassAnimate = this.stepData("isPassAnimate");
				var interval = setInterval(function(){
					var battleReady = outThis.flowData("battleReady");
					if(battleReady==1){
						battlePlug.showView(isPassAnimate);
						clearInterval(interval);
						outThis.success();
					}
				},100);
			},
			
			stageTakepart:function(){
				var outThis = this;
				var battleId = this.flowData("currentBattleId");
				var stage = this.stepData("stage");
				
				var url = "/api/main/stageTakepart";
				var callback = new Object();
				callback.success = function(resp){
					if(resp.success){
						outThis.success(resp.data);
					}else{
						outThis.success(resp.data);
					}
				}
				
				var params = new Object();
				params.stage = stage;
				params.battleId = battleId;
				
				request(url,callback,params);
			},
			
			applyReadResultHandle:function(){
				var stage = this.stepData("stage");
				var battleId = this.flowData("currentBattleId");
				
				var url = "/api/main/applyReadResultHandle";
				
				var outThis = this;
				var callback = new Object();
				
				callback.success = function(resp){
					console.log(JSON.stringify(resp));
					if(resp.success){
						var object = new Object();
						object["isReadResult_"+battleId] = 1;
						outThis.flowData(object);
						
						outThis.setNext("setBattleData");
						outThis.next();
						
						battleFlowPlug.setNext("showView");
						battleFlowPlug.next();
						outThis.success();
					}
					
					
				}
				
				var params = new Object();
				params.stage = stage;
				params.battleId = battleId;
				
				request(url,callback,params);
			},
			
			stageReTakepart:function(){
				var outThis = this;
				var battleId = this.flowData("currentBattleId");
				var stage = this.stepData("stage");
				var url = "/api/main/stageReTakepart";
				var callback = new Object();
				callback.success = function(resp){
					if(resp.success){
						outThis.success(resp.data);
					}else{
						outThis.success(resp.data);
					}
				}
				
				var params = new Object();
				params.stage = stage;
				params.battleId = battleId;
				
				request(url,callback,params);
			},
			
			dekornHandle:function(){
				var outThis = this;
				var battleId = this.flowData("currentBattleId");
				var stage = this.flowData("round_"+battleId);
				outThis.setNext("showProgressPlug");
				outThis.next();
				
				progressFlowPlug.setNext("setBattleId");
				progressFlowPlug.nextData({
					battleId:battleId
				});
				progressFlowPlug.next();
				
				
				progressFlowPlug.setNext("initStageIndex",function(){
					
				});
				

				progressFlowPlug.nextData({
					stageIndexs:stage
				});
				progressFlowPlug.next();

				
				battlePlug.hide();
				
				//过程只需要一次就搞定了
				var progressInitDataFlow  = outThis.flowData("progressInitDataFlow");
				if(!progressInitDataFlow){
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
					
					outThis.flowData({progressInitDataFlow:true});
					
					progressFlowPlug.setNext("showData");
					progressFlowPlug.next();
				}
				
				
				
				
				
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
			
			//开始挑战
			startDekorn:function(){
				
				var outThis = this;
				battlePlug.hide();
				
				//如果为1表示重新参加
				var startDekornFlag = this.stepData("startDekornFlag");
				
			
				var takepartMethodName = "stageTakepart";
				
				//重新挑战
				if(startDekornFlag==1){
					takepartMethodName = "stageReTakepart";
					var battleId = outThis.flowData("currentBattleId");
					
					console.log("battleID:"+battleId);
					var allScore = outThis.flowData("allScore_"+battleId);
					var thisScore = outThis.flowData("thisScore_"+battleId);
					allScore = allScore-thisScore;
					thisScore = 0;
					progressFlowPlug.setNext("initData",function(){
						
					});
					progressFlowPlug.nextData({
						allScore:allScore,
						round:outThis.flowData("round_"+battleId),
						thisScore:thisScore,
						rank:outThis.flowData("rank_"+battleId),
						loveLimit:outThis.flowData("loveLimit_"+battleId),
						loveCount:outThis.flowData("loveCount_"+battleId),
					});

					progressFlowPlug.next();
					
					progressFlowPlug.setNext("showData");
					progressFlowPlug.next();
					
					
				}
				var waitPlug = new WaitPlug();
				
				var outThis = this;
				
				var battleId = this.flowData("currentBattleId");

				var stage = this.flowData("round_"+battleId);
				
				var index = this.flowData("index_"+battleId);
				
				if(!startDekornFlag){
					progressFlowPlug.setNext("setThisIndex");
					progressFlowPlug.nextData({
						thisIndex:index
					});
					progressFlowPlug.next();
				}
				
				
				if(!stage||stage==0){
					stage = 1;
				}
				this.setNext(takepartMethodName,function(data){
					waitPlug.close();
					if(data!=null&&data.subWisdomNum!=null&&data.subWisdomNum>0){
						
						if(data.subWisdomNum&&data.subWisdomNum>0){
							
							attrPlug2.subBeanAction(data.subWisdomNum);
						}
						
						if(data.subMasonry&&data.subMasonry>0){
							
							attrPlug2.subMasonryAction(data.subMasonry);
							attrPlug2.subBeanAction(data.subWisdomNum);
						}
						
						
						setTimeout(function(){
							outThis.setNext("dekornHandle");
							outThis.next();
							
							progressFlowPlug.setNext("pullAttrData");
							progressFlowPlug.next();
						},1000);
						
					}else{
						outThis.setNext("dekornHandle");
						outThis.next();
					}
				});
				this.nextData({
					stage:stage
				});
				this.next();
				
				this.flowData({startDekornFlag:true});
	
			},
			
			//开始答题
			startPaper:function(){
				var battleId = this.flowData("currentBattleId");
				
				var paperId = this.flowData("paperId_"+battleId);
				var round = this.flowData("round_"+battleId);
				var memberId = this.flowData("memberId_"+battleId);
				
				var paperKey = memberId+"_"+round;
								
				var url = "/view/question/paperInfo?id="+paperId+"&keyId="+paperKey;
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
					battleId:battleId,
					isPassAnimate:1
				});
				this.next();
				
				/*battleFlowPlug.setNext("passAnimate");
				battleFlowPlug.next();*/
				
			},
			
			initBattleMemberInfo:function(){
				var outThis = this;
				var battleId = this.flowData("currentBattleId");
				this.setNext("requestBattleMemberInfo",function(data){
					var object = new Object();
					object["round_"+battleId] = data.currentStageIndex;
					object["thisScore_"+battleId] = data.thisScore;
					object["allScore_"+battleId] = data.allScore;
					object["beanNum_"+battleId] = data.rewardBeanNum;
					object["loveCount_"+battleId] = data.loveLife;
					object["loveLimit_"+battleId] = data.loveLifeLimit;
					object["rank_"+battleId] = data.rank;
					object["status_"+battleId] = data.status;
					object["currentStageIndex_"+battleId] = data.currentStageIndex;
					object["index_"+battleId] = data.index;
					object["stageStatus_"+battleId] = data.stageStatus;
					object["status"+battleId] = data.status;
					object["paperKey_"+battleId] = data.paperKey;
					object["paperId_"+battleId] = data.paperId;
					object["memberId_"+battleId] = data.memberId;
					object["stageIndexCount_"+battleId] = data.stageIndexCount;
					object["isPass_"+battleId] = data.isPass;
					object["imgUrl_"+battleId] = data.imgUrl;
					object["name_"+battleId] = data.name;
					object["passScore_"+battleId] = data.passScore;
					object["passScore2_"+battleId] = data.passScore2;
					object["passScore3_"+battleId] = data.passScore3;
					object["passScore4_"+battleId] = data.passScore4;
					object["isReadResult_"+battleId] = data.isReadResult;
					object["consumeBean_"+battleId] = data.consumeBean;
					outThis.flowData(object);
					outThis.success();
				});
				
				
				this.nextData({
					battleId:battleId
				});
				this.next();
				
				battlePlug.setBattleId(battleId);
			},
			
			getBattleStages:function(){
				var outThis = this;
				var battleId = this.flowData("currentBattleId");

				outThis.setNext("requestBattleStages",function(){
					outThis.success(outThis.flowData("stageInfos"));
				});
				outThis.nextData({
					battleId:battleId
				});
				outThis.next();
			},
			
			requestBattleStages:function(){
				var outThis = this;
				var battleId = this.flowData("currentBattleId");
				var url = "/api/main/battleStages";
				
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
				var isPassAnimate = this.stepData("isPassAnimate");
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
						outThis.nextData({
							isPassAnimate:isPassAnimate
						});
						outThis.next();
					}else{
						outThis.setNext("battleTakepart",function(data){
							waitPlug.close();
							attrPlug2.subLoveAction(data.loveLifeConsume);
							
							attrPlug2.subBeanAction(data.beanConsume);
							
							
							setTimeout(function(){
								outThis.setNext("showBattle",function(){});
								outThis.nextData({
									isPassAnimate:isPassAnimate
								});
								outThis.next();
								waitPlug.close();
								
								progressFlowPlug.setNext("pullAttrData");
								progressFlowPlug.next();
								
							},5000);
							
						},function(){
							waitPlug.close();
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
			
			submitResult:function(){
				var outThis = this;
				var url = "/api/main/submitResult";
				var callback = new Object();
				callback.success = function(resp){
					if(resp.success){
						outThis.success();
					}else{
						console.log(resp.errorMsg);
					}
				}
				var battleId = this.flowData("currentBattleId");
				var stage = this.flowData("round_"+battleId);
				var params = new Object();
				params.battleId = battleId;
				params.stage = stage;
				
				request(url,callback,params);
			},
			
			//用用户互动的监听器
			initEventListener:function(){
				var outThis = this;
				/*var battleId = 1;
				
				 this.flowData({
					 currentBattleId:battleId
				 })*/
				 
				$("#mainViewReadyButton").click(function(){
					outThis.setNext("battleReady");
					outThis.next();
				});
					
				$("#mainViewStartButton").click(function(){
					outThis.setNext("startBattle");
					/*outThis.nextData({
						battleId:battleId
					});*/
					outThis.next();
					$("#startButton").css("display","none");
				});
				
				$("#startButton").click(function(){
					outThis.setNext("startBattle");
					/*outThis.nextData({
						battleId:battleId
					});*/
					outThis.next();
					$("#startButton").css("display","none");
				});
				 
				 $("#mainViewQrcodeButton").click(function(e){
					 var qrcodeFlag = outThis.flowData("qrcodeFlag");
					 if(!qrcodeFlag){
						 showQrcode();
						 outThis.flowData({"qrcodeFlag":true});
					 }else{
						 hideQrcode();
						 outThis.flowData({"qrcodeFlag":false});
					 }
					 
					 return false;
				 });
				 
				 $("#mainViewStoreButton").click(function(){
					 outThis.setNext("openStore");
					 outThis.next();
				 });
				 
				 $("#redPacketButton").click(function(){
					 outThis.setNext("openRedPacket");
					 outThis.next();
				 });
			},
			
			openRedPacket:function(){
				var url = "/view/draw/main/mainRedPacketList";
				
				showLoading();
				
				$.get(url,function(r){
					$("#iframeContair").css("display","block");
					$("#iframeContair").append(r);
					initRedPacket();
					hideLoading();
				},"html");
			},
			
			openStore:function(){
				var url = "/view/draw/mall/mainView";
				
				showLoading();
				
				$.get(url,function(r){
					$("#iframeContair").css("display","block");
					$("#iframeContair").append(r);
					initStore();
					hideLoading();
				},"html");
			},
			
			initBattleInfo:function(){
				var outThis = this;
				var battleId = this.flowData("currentBattleId");
				this.setNext("initBattle",function(){
					
					outThis.setNext("setBattleData");
					outThis.next();
					waitProgress.addProgress(30,10);
					/*this.setNext("getBattleStages",function(data){
						var interval = setInterval(function(){
							if(outThis.flowData("progressReady")){
								
								outThis.setNext("initProgressPlug");
								outThis.next();
								
								progressFlowPlug.setNext("initStages");
								progressFlowPlug.nextData({
									array:data
								});
								progressFlowPlug.next();
								
								//这里设置最大的stage
								var object = new Object();
								object["maxStage_"+battleId] = data[data.length-1].stageIndex;
								outThis.flowData(object);
								addProgress(20,10);
								clearInterval(interval);
							}
						},10);
						
					});
					this.nextData({
						battleId:battleId
					});
					this.next();*/
				
				});
				
				this.next();
			},
			
			battleReady:function(){
				var waitPlug = new WaitPlug();
				var outThis = this;
				this.setNext("battleTakepart",function(data){
					var attrFlowPlug = attrPlug.flowPlug;
					
					attrPlug2.subLoveAction(data.loveLifeConsume);
					attrPlug2.subBeanAction(data.beanConsume);
					outThis.setNext("requestBattleRankMemberList",function(data){
						$(".mainViewMembers>ul").children().remove();
						
						var members = data.members;
						var rankInfo = data.rankInfo;
						var thisMember = data.thisMember;
						
						outThis.setNext("initMembers");
						outThis.nextData({
							members:members,
							rankInfo:rankInfo
						});
						outThis.next();
						waitPlug.close();
						
						
						outThis.flowData({
							thisRankMember:thisMember
						});
						outThis.setNext("showFooterButtons");
						outThis.next();
						
						$("#startButton").css("display","block");
		
					},function(){waitPlug.close();});
					outThis.next();
				},function(){
					waitPlug.close();
				});
				
				this.next();
			},
			
			requestBattleRankMemberList:function(){
				var outThis=this;
				var url = "/api/main/battleRankMemberList";
				var battleId = this.flowData("currentBattleId");
				var params = new Object();
				params.battleId = battleId;
				var callback = new Object();
				callback.success = function(resp){
					if(resp.success){
						var data = resp.data;
						outThis.success(data);
					}else{
						outThis.failure();
					}
				}
				callback.failure = function(){
					outThis.failure();
				}
				request(url,callback,params);
			},
			
			//参与比赛
			battleTakepart:function(){
				var loveConsume = this.flowData("loveConsume");
				var beanConsume = this.flowData("beanConsume");
				var loveCount = loveProgressPlug.getValue();
				var beanCount = beanProgressPlug.getValue();
				if(loveConsume>loveCount){
					new AlertPlug("爱心不足");
					this.fail();
					return null;
				}
				
				if(beanConsume>beanCount){
					new AlertPlug("智慧豆不足");
					this.fail();
					return null;
				}
				
				var outThis = this;
				var battleId = this.flowData("currentBattleId");
				var url = "/api/main/battleTakepart";
				var callback = new Object();
				callback.success = function(resp){
					if(resp.success){
						outThis.success(resp.data);
					}else{
						outThis.fail();
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
				battlePlug = new BattleInfoLayer({
					startDekorn:function(battleId,stage){
						startDekorn(battleId,stage);
					},
					reStartDekorn:function(battleId,stage){
						reStartDekorn(battleId,stage);
					}
				});
				
				battlePlug.init({
					success:function(plug){
						battleFlowPlug = plug;
						outThis.success();
						outThis.flowData({battleReady:1});
					}
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
				var maxStage = this.flowData("stageIndexCount_"+battleId);
				var stageStatus = this.flowData("stageStatus_"+battleId);
				var status = this.flowData("status_"+battleId);
				var isPass = this.flowData("isPass_"+battleId);
				var imgUrl = this.flowData("imgUrl_"+battleId);
				var name = this.flowData("name_"+battleId);
				var paperId = this.flowData("paperId_"+battleId);
				var memberId = this.flowData("memberId_"+battleId);
				var passScore = this.flowData("passScore_"+battleId);
				var passScore2 = this.flowData("passScore2_"+battleId);
				var passScore3 = this.flowData("passScore3_"+battleId);
				var passScore4 = this.flowData("passScore4_"+battleId);
				var isReadResult =  this.flowData("isReadResult_"+battleId);
				
				var consumeBean =  this.flowData("consumeBean_"+battleId);
				
				battlePlug.initData({
					round:round,
					thisScore:thisScore,
					allScore:allScore,
					beanNum:beanNum,
					loveCount:loveCount,
					loveLimit:loveLimit,
					rank:rank,
					maxStage:maxStage,
					stageStatus:stageStatus,
					status:status,
					isPass:isPass,
					imgUrl:imgUrl,
					name:name,
					paperId:paperId,
					memberId:memberId,
					isReadResult:isReadResult,
					consumeBean:consumeBean,
					passScore:passScore,
					passScore2:passScore2,
					passScore3:passScore3,
					passScore4:passScore4
				});
			}
		});
	}
	
	this.load = function(selector,callback){

		var url = "/view/plug/battleMainPlug";
		$.get(url,function(r){
			
			initPlug({
				success:function(){
					init();
				}
			});
			
			$(".mainView").height($(document).height());
			$(selector).css("display","block");
			$(selector).append(r);
			if(callback&&callback.success){
				callback.success();
			}
		},"html");
		
	}
}
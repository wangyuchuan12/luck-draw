
function ProgressScore(){

	var outThis = this;
	
	var progressPlug;
	
	function addScore(score){
		var thisScore = $("#thisScore");
		showIncreaseNumFromEl(score,$("#thisScoreDiv"),1,0,40,null,20);
	}
	
	function scrollToButtom(callback){
		var top = $("#toDom0").position().top;
		$("#progressScoreContainer").animate({
			scrollTop:top+$("#progressScoreContainer").scrollTop()-window.screen.availHeight/2
			
		},400,function(){
			if(callback){
				callback.call({});
			}
		});
	}
	
	function pointWrong(index,fun){
		staking($("#wrongPoint"),$("#toDom"+index),$(".progressScore"),-14,-10,fun);
	}
	
	function pointRight(index,fun){
		staking($("#rightPoint"),$("#toDom"+index),$(".progressScore"),-14,-16,fun);
	}
	
	var mainCallback;
	
	var nowIndex;
	
	function init(cb){
		
		initPlug({
			success:function(){
				attrPlug2.showView();
				var callback = new Object();
				callback.complete = function(){
					var toDoms = new Array();
					document.addEventListener("touchmove",function(e){
						e.preventDefault();
					},false);
				}
				waitProgress.progress(100,10,callback);
			
				$("#progressScoreContainer").height(window.screen.availHeight);
			}
		});
		
		
		mainCallback = cb;
		progressPlug = new FlowPlug({
			begin:function(){
				mainCallback.setProgressFlowPlug(this);
				mainCallback.setProgressScore()
				this.flowData({
					thisIndex:0
				});
				
				$("#toDom0").css("display","block");
				$("#toDom0").css("background","url('')");
				
				this.flowData({
					isInit:1
				});
				
			},
			
			setThisIndex:function(){
				var thisIndex = this.stepData("thisIndex");
				this.flowData({
					thisIndex:thisIndex
				});
			},
			
			initStages:function(){
				var array = this.stepData("array");
				var outThis = this;
				for(var i = 0;i<array.length;i++){
					var object = array[i];
					outThis.setNext("showIndexStyleHandle");
					outThis.nextData({
						index:object.index,
						iconUrl:object.iconUrl
					});
					outThis.next();
				}
			},
			
			setBattleId:function(){
				var battleId = this.stepData("battleId");
				this.flowData({
					battleId:battleId
				});
			},
			nextStage:function(){
				
			},
			toStage:function(){
				var outThis = this;
				var stage = this.stepData("stage");
				
				this.setNext("putToStageLast",function(index){
					outThis.flowData({
						thisIndex:index
					});
					var stageIndexsStr="";
					for(var i =1;i<=stage;i++){
						stageIndexsStr=stageIndexsStr+i+",";
					}
					
					if(stageIndexsStr){
						stageIndexsStr = stageIndexsStr.substring(0,stageIndexsStr.length-1);
					}
					
					if(stageIndexsStr){
						outThis.setNext("initStagesStyle");
						outThis.nextData({
							stageIndexs:stageIndexsStr
							
						})
						outThis.next();
					}
					
					
					var toStageCallback = outThis.stepData("callback");
					setTimeout(function(){
						outThis.setNext("getStageIndex",function(data){
							var guideIndex;
							for(var i = 0;i<data.length;i++){
								var indexObject = data[i];								
								if(indexObject.isGuide==1){
									guideIndex = indexObject;
								}
							}

							outThis.setNext("trendBetween");
							
							var callback = new Object();
							callback.call = function(index,next){
								next.next();
							}
							
							
							callback.end = function(){
								setTimeout(function(){
									var showAlert = new ShowAlert("第"+stage+"轮");
									setTimeout(function(){
										showAlert.close();
										if(toStageCallback){
											toStageCallback.call({});
											
										}
									},5000);
								},1000);
							}
							
							var thisIndex = outThis.flowData("thisIndex");
							
							outThis.nextData({
								beginIndex:thisIndex,
								endIndex:guideIndex.index,
								callback:callback
							});
							outThis.next();
							
						});
						
						
						outThis.nextData({
							stage:stage
						});
						outThis.next();
						
						
						outThis.setNext("showStageStyle");
						outThis.nextData({
							stage:stage
						});
						outThis.next();
					},10);
				});
				this.nextData({
					stage:stage-1
				});
				this.next();
				
			},
			startStage:function(){
				var outThis = this;
				var stage = this.stepData("stage");
			
				this.setNext("getStageIndex",function(data){
					var guideIndex;
					for(var i = 0;i<data.length;i++){
						var indexObject = data[i];
						
						if(indexObject.isGuide==1){
							guideIndex = indexObject;
						}
						
					}
					
					var endIndex = guideIndex.index+data.length-1;
					
					var callback = new Object();
					callback.call = function(index,next){
						var indexObject = outThis.flowData("index"+(index));

						if(indexObject.rewardBeanNum&&indexObject.rewardBeanNum>0){
							attrPlug.addBeanAnnim({
								num:indexObject.rewardBeanNum
							});
						}
						
						if(index==endIndex){
							setTimeout(function(){
								window.parent.stageEnd();
								
								var attrFlowPlug = attrPlug.flowPlug;
								attrFlowPlug.setNext("pushData");
								attrFlowPlug.next();
							},8000);
						}
						
						if(indexObject.isRight==1){
							pointRight(index,function(){
								setTimeout(function(){
									next.next();
								},1000);
								
								outThis.setNext("addScore");
								outThis.nextData({
									score:indexObject.score
								});
								outThis.next();
							});
						}else if(indexObject.isRight==0){
							pointWrong(index,function(){
								
								setTimeout(function(){
									next.next();
								},1000);
								
								var loveCount = outThis.flowData("loveCount");
								loveCount = loveCount-1;
								
								outThis.flowData({
									loveCount:loveCount
								});
								
								outThis.setNext("showLove");
								outThis.next();
								
							});
						}else{
							setTimeout(function(){
								next.next();
							},1000);
						}
						
						
					}
					
					outThis.setNext("trendBetween");
					
					outThis.nextData({
						beginIndex:guideIndex.index,
						endIndex:endIndex,
						callback:callback
					});
					outThis.next();
				});
				
				this.nextData({
					stage:stage,
					flag:true
				});
				this.next();
				
			},
			
			//多阶段显现
			initStagesStyle:function(){
				var stageIndexs = this.stepData("stageIndexs");
				var outThis = this;
				var isInit = this.flowData("isInit");
				this.setNext("initStageIndex",function(){
					var stages = stageIndexs.split(",");
					
					for(var i = 0;i<stages.length;i++){
						
						
						outThis.setNext("showStageStyle");
						outThis.nextData({
							stage:stages[i],
							isPrint:isInit
						});
						outThis.next();
					
					}
				});
				
				this.nextData({
					stageIndexs:stageIndexs
				});
				
				this.next();
				
				this.flowData({isInit:0});
			},
			
			putToStageLast:function(){
				
				var outThis = this;
				var stage = this.stepData("stage");
				if(stage&&stage>0){
					this.setNext("getStageIndex",function(indexs){
						var lastIndex = indexs[indexs.length-1];
						
						var left = $("#toDom"+lastIndex.index).css("left");
						var top = $("#toDom"+lastIndex.index).css("top");
						
						
						$("#fromDom").css("left",left);
						$("#fromDom").css("top",top);
						
						
						var top = $("#fromDom").position().top;
						
						$("#progressScoreContainer").animate({
							scrollTop:top+$("#progressScoreContainer").scrollTop()-window.screen.availHeight/2
						},function(){
							outThis.success(lastIndex.index);
						});
						
					});
					this.nextData({
						stage:stage
					});
					this.next();
					
					
				}else{
					var left = $("#toDom0").css("left");
					var top = $("#toDom0").css("top");
					$("#fromDom").css("left",left);
					$("#fromDom").css("top",top);
					
					var top = $("#fromDom").position().top;
					
					$("#progressScoreContainer").animate({
						scrollTop:top+$("#progressScoreContainer").scrollTop()-window.screen.availHeight/2
					},function(){
						outThis.success(0);
					});
				}
			},
			
			showStageStyle:function(){
				var outThis = this;
				var stage = this.stepData("stage");
				var isPrint = this.stepData("isPrint");
				this.setNext("getStageIndex",function(data){
					if(data){
						for(var i = 0;i<data.length;i++){
							var index = data[i].index;
							
							outThis.setNext("showIndexStyle");
							outThis.nextData({
								index:index
							});
							outThis.next();
							
							if(data[i]&&data[i].status==2){
								if(data[i].isRight==0&&isPrint){
									pointWrong(data[i].index,function(){});
								}else if(data[i].isRight==1&&isPrint){
									pointRight(data[i].index,function(){});
								}
							}
						}
					}
					
				});
				this.nextData({
					stage:stage
				});
				this.next();
			},
			
			showIndexStyle:function(){
				var index = this.stepData("index");
				
				var obj = this.flowData("index"+index);
				
				var iconUrl = obj.iconUrl;
				
				this.setNext("showIndexStyleHandle");
				this.nextData({
					iconUrl:iconUrl,
					index:index,
					isGuide:obj.isGuide
				});
				this.next();
				
			},
			
			showIndexStyleHandle:function(){
				var iconUrl = this.stepData("iconUrl");
				var index = this.stepData("index");
				var isGuide = this.stepData("isGuide");
				
				if(iconUrl){
					$("#toDom"+index).css("background","url('"+iconUrl+"')");
					$("#toDom"+index).css("background-size","100% 100%");
				}
				
				if(isGuide){
					$("#toDom"+index).css("width","30px");
					$("#toDom"+index).css("height","30px");
				
				}
				
				$("#toDom"+index).css("display","block");
			},
			
			addScore:function(){
				var outThis = this;
				var score = this.stepData("score");
				showIncreaseNumFromEl(score,$("#thisScoreDiv"),1,0,40,null,20);
				showIncreaseNumFromEl(score,$("#allScoreDiv"),1,0,40,null,20);
				
				var thisScore = this.flowData("thisScore");
				
				var allScore = this.flowData("allScore");
								
				function addScore(num){
					num--;
					if(num>=0){
						thisScore++;
						allScore++;
						outThis.flowData({
							thisScore:thisScore,
							allScore:allScore
						});
						
						$("#thisScore").text(thisScore);
						$("#allScore").text(allScore);
						setTimeout(function(){
							addScore(num);
						},50);
					}
				}
				
				setTimeout(function(){
					addScore(score);
				},2000);
			},
			
			//显示爱心
			showLove:function(){
				var loveCount = this.flowData("loveCount");
				if(loveCount == 0){
					$("#love1").attr("class","personalAttrDataHeaderBig personalAttrDataHeaderLoveHollowBig");
					$("#love2").attr("class","personalAttrDataHeaderBig personalAttrDataHeaderLoveHollowBig");
					$("#love3").attr("class","personalAttrDataHeaderBig personalAttrDataHeaderLoveHollowBig");
					$("#love4").attr("class","personalAttrDataHeaderBig personalAttrDataHeaderLoveHollowBig");
				}else if(loveCount == 1){
					$("#love1").attr("class","personalAttrDataHeaderBig personalAttrDataHeaderLoveBig");
					$("#love2").attr("class","personalAttrDataHeaderBig personalAttrDataHeaderLoveHollowBig");
					$("#love3").attr("class","personalAttrDataHeaderBig personalAttrDataHeaderLoveHollowBig");
					$("#love4").attr("class","personalAttrDataHeaderBig personalAttrDataHeaderLoveHollowBig");
				}else if(loveCount == 2){
					$("#love1").attr("class","personalAttrDataHeaderBig personalAttrDataHeaderLoveBig");
					$("#love2").attr("class","personalAttrDataHeaderBig personalAttrDataHeaderLoveBig");
					$("#love3").attr("class","personalAttrDataHeaderBig personalAttrDataHeaderLoveHollowBig");
					$("#love4").attr("class","personalAttrDataHeaderBig personalAttrDataHeaderLoveHollowBig");
				}else if(loveCount == 3){
					$("#love1").attr("class","personalAttrDataHeaderBig personalAttrDataHeaderLoveBig");
					$("#love2").attr("class","personalAttrDataHeaderBig personalAttrDataHeaderLoveBig");
					$("#love3").attr("class","personalAttrDataHeaderBig personalAttrDataHeaderLoveBig");
					$("#love4").attr("class","personalAttrDataHeaderBig personalAttrDataHeaderLoveHollowBig");
				}else if(loveCount == 4){
					$("#love1").attr("class","personalAttrDataHeaderBig personalAttrDataHeaderLoveBig");
					$("#love2").attr("class","personalAttrDataHeaderBig personalAttrDataHeaderLoveBig");
					$("#love3").attr("class","personalAttrDataHeaderBig personalAttrDataHeaderLoveBig");
					$("#love4").attr("class","personalAttrDataHeaderBig personalAttrDataHeaderLoveBig");
				}
				
				$("#love1").css("background-size","");
				$("#love2").css("background-size","");
				$("#love3").css("background-size","");
				$("#love4").css("background-size","");
				
				var array = [{w:50,h:50},{w:51,h:51},{w:52,h:52},
				             {w:53,h:53},{w:54,h:54},{w:55,h:55},
				             {w:56,h:56},{w:57,h:57},{w:58,h:58},
				         //  {w:59,h:59},{w:60,h:60},{w:61,h:61},
				         //  {w:60,h:60},{w:59,h:59},{w:58,h:58},
				             {w:57,h:57},{w:56,h:56},{w:55,h:55},
				             {w:54,h:54},{w:53,h:53},{w:52,h:52},
				             {w:51,h:51},{w:50,h:50}];
				
				this.setNext("loveAnimate");
				this.nextData({
					"selector":".personalAttrDataHeaderLoveBig",
					"array":array
				});
				this.next();
			},
			
			loveAnimate:function(){
				var selector = this.stepData("selector");
				var flag = this.flowData("flag"+selector);
				if(flag==1){
					return;
				}else{
					var flagObject = new Object();
					flagObject["flag"+selector] =1;
					this.flowData(flagObject);
					var outThis = this;
					
					var array = this.stepData("array");
					
					loveAnimate();
					function loveAnimate(){
						
						var index = 0;
						var interval = setInterval(function(){
							var backgroundSizeStr = array[index].w+"px "+array[index].h+"px";
							var el = $(selector);
							el.css("background-size",backgroundSizeStr);
							index++;
							if(index>=array.length){
								clearInterval(interval);
								loveAnimate();
							}
						},100);
					}
				}	
			},
			
			//初始化数据
			initData:function(){
				var outThis = this;
				this.flowData({
					allScore:outThis.stepData("allScore"),
					round:outThis.stepData("round"),
					thisScore:outThis.stepData("thisScore"),
					rank:outThis.stepData("rank"),
					loveLimit:outThis.stepData("loveLimit"),
					loveCount:outThis.stepData("loveCount")
				});
				this.success();
			},
			
			
			//显示数据
			showData:function(){
				var allScore = this.flowData("allScore");
				var thisScore = this.flowData("thisScore");
				var round = this.flowData("round");
				var rank = this.flowData("rank");
				$("#allScore").html(allScore);
				$("#thisScore").html(thisScore);
				$("#round").text(round);
				$("#rank").text(rank);
				
				//显示爱心数量
				this.setNext("showLove");
				this.next();
				
				//显示成功返回
				this.success();
				
				this.setNext("pullAttrData");
				this.next();
				
			},
			
			pullAttrData:function(){
				
				
			},
			
			pushAttrData:function(){
				
			},
			
			getStageIndex:function(){
				var outThis = this;
				var stage = this.stepData("stage");
				var key = "stage"+stage;
				var flag = this.stepData("flag");
				
				var indexs = this.flowData(key);
				if(!indexs||flag){
					
					outThis.setNext("initStageIndex",function(){
						indexs = this.flowData(key);
						outThis.success(indexs);
					});
					outThis.nextData({
						stageIndexs:stage,
						battleId:outThis.flowData("battleId")
					});
					outThis.next();
				}else{
					this.success(indexs);
				}
			},
			
			//请求阶段数据
			initStageIndex:function(){
				var stageIndexs = this.stepData("stageIndexs");
				var battleId = this.flowData("battleId");
				var outThis = this;
				var url = "/api/main/progressInfo";
				var callback = new Object();
				callback.success = function(resp){
					if(resp.success){
						var data = resp.data;
						for(var i in data){
							//把所有阶段放入缓存
							var key = "stage"+i;
							var battleIndex = new Object();
							battleIndex[key] = data[i].battleIndexs;
							outThis.flowData(battleIndex);
							
							//把所有步骤都放进缓存
							for(var k=0;k<data[i].battleIndexs.length;k++){
								var indexData = data[i].battleIndexs[k];
								var indexKey = "index"+indexData.index;
								var indexObject = new Object();
								indexObject[indexKey] = indexData;
								outThis.flowData(indexObject);
								
								/*outThis.setNext("showIndexStyle");
								outThis.nextData({
									index:indexData.index
								});
								outThis.next();*/
							}
						}
						/*outThis.setNext("startStageIndex");
						outThis.nextData({
							stageIndex:stageIndexs
						});
						outThis.next();*/
						outThis.success();
					}
				}
				var params = new Object();
				//数组，用逗号分割开来
				params.stageIndexs = stageIndexs;
				params.battleId = battleId;
				request(url,callback,params);
			},
			
			//运行
			trendBetween:function(){
				var outThis = this;
				var beginIndex = this.stepData("beginIndex");
				var endIndex = this.stepData("endIndex");
	
				var callback = this.stepData("callback");
				var toDoms = new Array();
				for(var i = beginIndex;i<=endIndex;i++){
					toDoms.push($("#toDom"+i));
				}
				
				moveAnimateTrajectory($("#fromDom"),toDoms,beginIndex,function(index,toDom,fromDom,next){
					
					var top = fromDom.position().top;
			
					$("#progressScoreContainer").animate({
						scrollTop:top+$("#progressScoreContainer").scrollTop()-window.screen.availHeight/2
					},400,function(){
						
						var indexObject = outThis.flowData("index"+(index+1));
						
						outThis.flowData({
							thisIndex:index
						});

						outThis.flowData({
							thisIndex:index
						});
						
						if(callback){
							callback.call(index,next);
							if(callback.end&&index+1>=toDoms.length){
							//	callback.end();
							}
						}
					});
					
				},-5,-5,0,function(){
					if(callback&&callback.end){
						callback.end();
						
						outThis.setNext("pushAttrData");
						outThis.next();
					}
				});
			}
		});
	}
	
	this.init = function(callback){
		init(callback);
	}
}


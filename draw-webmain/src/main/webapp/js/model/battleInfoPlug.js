function BattleInfoPlug(){

	var resultPlug
	var mainCallback;
	
	function closeResult(){
		if(resultPlug){
			resultPlug.close();
		}
	}
	this.init = function(cb){
		mainCallback = cb;
		var battlePlug = new FlowPlug({
			begin:function(){
				var outThis = this;
				mainCallback.setBattleFlowPlug(this);
				
				$("#dekornButton").click(function(){
					
					var loveCount = outThis.flowData("loveCount");
					if(!loveCount||loveCount<=0){
						new AlertPlug("请补充爱心");
						return;
					}
					var beanValue = attrPlug2.getBeanValue();
					var consumeBean = outThis.flowData("consumeBean");
					if(beanValue>=consumeBean){
						var dekornEnable = outThis.flowData("dekornEnable");
						
						if(dekornEnable==1){
							var battleId = battlePlug.flowPlug.flowData("battleId");
							var round = battlePlug.flowPlug.flowData("round");
							var stageStatus = battlePlug.flowPlug.flowData("stageStatus");
							if(stageStatus==2){
								//window.parent.startDekorn(battleId,parseInt(round)+1);
							}else if(stageStatus==1){
								mainCallback.reStartDekorn(battleId,parseInt(round));
							}else{
								mainCallback.startDekorn(battleId,parseInt(round));
							}
						}
					}else{
						new AlertPlug("智慧豆不足",["道具补充","购买"]);
					}
					
				});
				
				$("#reDekornButton").click(function(){
					var loveCount = outThis.flowData("loveCount");
					if(!loveCount||loveCount<=0){
						new AlertPlug("请补充爱心");
						return;
					}
					var beanValue = attrPlug2.getBeanValue();
					var consumeBean = outThis.flowData("consumeBean");
					if(beanValue>=consumeBean){
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
					}else{
						new AlertPlug("智慧豆数量不够");
					}
					
				});
				
				$("#nextButton").click(function(){
					var nextEnable = outThis.flowData("nextEnable");
					if(nextEnable==1){
						var battleId = battlePlug.flowPlug.flowData("battleId");
						var round = battlePlug.flowPlug.flowData("round");
						window.parent.startBattle(parseInt(round)+1);
					}else{
						new AlertPlug("请先确定都已经通过或者是最后一题");
					}
					
				});
				
				$("#lastButton").click(function(){
					var lastEnable = outThis.flowData("lastEnable");
					if(lastEnable==1){
						var battleId = battlePlug.flowPlug.flowData("battleId");
						var round = battlePlug.flowPlug.flowData("round");
						window.parent.startBattle(parseInt(round)-1);
					}else{
						new AlertPlug("现在是第1题");
					}
					
				});
				
				$("#showResult").click(function(){
				
					var showResultEnable = outThis.flowData("showResultEnable");
					if(showResultEnable==1){
						var waitPlug = new WaitPlug();
						var round = window.parent.applyReadResultHandle(outThis.flowData("round"),{
							success:function(){
								outThis.setNext("showResult");
								outThis.next();
								waitPlug.close();
							}
						});
					}else{
						new AlertPlug("您还未挑战，不能查阅答案");
					}
					
					
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
					consumeBean:outThis.stepData("consumeBean"),
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
			
			setHighLight:function(){
				var selector = this.stepData("selector");
				$("#lastButton").css("background-color","RGBA(92,101,110,1)");
				$("#showResult").css("background-color","RGBA(92,101,110,1)");
				$("#dekornButton").css("background-color","RGBA(92,101,110,1)");
				$("#reDekornButton").css("background-color","RGBA(92,101,110,1)");
				$("#nextButton").css("background-color","RGBA(92,101,110,1)");
				$(selector).css("background-color","RGBA(81,220,72,1)");
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
	
				if(isReadResult==1){
					outThis.flowData({
						reDekornEnable:0
					});
				}else{
					outThis.flowData({
						reDekornEnable:1
					});
				}
				
				
				//处在游离或者进行中状态
				if(stageStatus==1||stageStatus==0){
	
					outThis.setNext("setHighLight");
					outThis.nextData({
						selector:"#dekornButton"
					});
					outThis.next();
					
					outThis.flowData({
						dekornEnable:1
					});
					
					$("#dekornButton").css("display","inline-block");
					
					$("#reDekornButton").css("display","none");
					
					outThis.flowData({
						showResultEnable:0
					});
					
				}else {
					
					if(isPass){
						outThis.flowData({
							showResultEnable:1
						});
					}else{
						outThis.flowData({
							showResultEnable:0
						});
					}
					
					
					$("#dekornButton").css("display","none");
	
					outThis.flowData({
						dekornEnable:0
					});
					
					$("#reDekornButton").css("display","inline-block");
					
					if(isPass){
						if(round>=maxStage){
							$("#nextButton").css("background-color","RGBA(92,101,110,1)");
						}else{
	
							outThis.setNext("setHighLight");
							outThis.nextData({
								selector:"#nextButton"
							});
							outThis.next();
						}						
					}else{
						outThis.setNext("setHighLight");
						outThis.nextData({
							selector:"#reDekornButton"
						});
						outThis.next();
					}
					
				}
				
				if(round>=maxStage||stageStatus!=2||isPass!=1){
					outThis.flowData({
						nextEnable:0
					});
				}else{
					outThis.flowData({
						nextEnable:1
					});						
				}
				
				if(round<=1){
					outThis.flowData({
						lastEnable:0
					});
				}else{
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
	
	
	this.load = function(selector,callback){
		var url = "/view/plug/battleInfoPlug";
		$.get(url,function(r){
			
			initPlug({
				success:function(){
					var progressCallback = new Object();
					progressCallback.complete = function(){
						
						attrPlug2.initProgress();
		
					}
					waitProgress.progress(100,10,progressCallback);
				}
			});
			
			$(selector).css("display","block");
			$(selector).append(r);
			if(callback&&callback.success){
				callback.success();
			}
		},"html");
	}
}
			
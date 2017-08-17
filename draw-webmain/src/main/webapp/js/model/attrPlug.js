function AttrPlug(){
	var loveProgressPlug;
	var beanProgressPlug;
	var masonryProgressPlug;
	var moneyProgressPlug;
	var attrPlug = new FlowPlug({
	
					
					hideLove:function(){
						$("#personalAttrDataLove").css("display","none");
					},
					hideBean:function(){
						$("#personalAttrDataBean").css("display","none");
					},
					hideMoney:function(){
						$("#personalAttrDataMoney").css("display","none");
					},
					hideMasonry:function(){
						$("#personalAttrDataMasonry").css("display","none");
					},
					showView:function(){
						var outThis = this;
						this.setNext("initData",function(){
							outThis.setNext("initProgress");
							outThis.next();
							
							outThis.setNext("show");
							outThis.next();
							
							waitProgress.addProgress(10,100);
						});
						this.next();
					},
					//初始化
					begin:function(){
						this.setNext("hide");
						this.next();
					},
					//初始化属性栏
					initAttr:function(){
						this.setNext("addLoveAction");
						this.next();
						
						this.setNext("addBeanAction");
						this.next();
						
						this.setNext("addMasonryAction");
						this.next();
						
						this.setNext("addMoneyAction");
						this.next();
					},
					initData:function(){
						
						var outThis = this;
						var callback = new Object();
						callback.success = function(obj){
							if(obj.success){
								var data = obj.data;
								outThis.flowData({
									loveNum:data.loveLife,
									loveLimit:data.loveLifeLimit,
									
									beanNum:data.wisdomCount,
									
									beanLimit:data.wisdomLimit,
									
									masonryNum:data.masonry,
									
									moneyNum:data.amountBalance
								});
								
								outThis.success();
							}
							
						}
						
						var params = new Object();
						request("/api/account/info",callback,params);
						
					},
					
					initProgress:function(){
						var loveNum = this.flowData("loveNum");
						var loveLimit = this.flowData("loveLimit");
						var beanNum = this.flowData("beanNum");
						var beanLimit = this.flowData("beanLimit");
						var masonryNum = this.flowData("masonryNum");
						var moneyNum = this.flowData("moneyNum");
						loveProgressPlug = new ProgressPlug("#progressbarLove","#progressbarLove .progress-label2",{type:1,isShowProgress:0});
						loveProgressPlug.setCount(loveLimit);
						beanProgressPlug = new ProgressPlug("#progressbarBean","#progressbarBean .progress-label2",{type:1,isShowProgress:0});
						beanProgressPlug.setCount(beanLimit);
						masonryProgressPlug = new ProgressPlug("#progressbarMasonry","#progressbarMasonry .progress-label2",{type:1,decimal:0,isShowProgress:0,count:100});
						moneyProgressPlug = new ProgressPlug("#progressbarMoney","#progressbarMoney .progress-label2",{type:1,unit:"元",decimal:2,isShowProgress:0,count:100000000});
						
						loveProgressPlug.setValue(loveNum);
						beanProgressPlug.setValue(beanNum);
						masonryProgressPlug.setValue(masonryNum);
						moneyProgressPlug.setValue(moneyNum);
						
						/*
						this.setNext("addMasonryAction");
						this.nextData({
							num:masonryNum
						});
						this.next();
						
						
						this.setNext("addMoneyAction");
						this.nextData({
							num:moneyNum
						});
						this.next();
						
						this.setNext("addLoveAction");
						this.nextData({
							num:loveNum
						});
						this.next();
						
						
						this.setNext("addBeanAction");
						this.nextData({
							num:beanNum
						});
						this.next();
						*/
						
					},
					
					//隐藏
					hide:function(){
						$("#personalAttr").css("display","none");
					},
					
					//显示
					show:function(){
						$("#personalAttr").css("display","block");
					},
					
					//增加爱心动画
					addLoveAnnim:function(){
						var num = this.stepData("num");
						var unit = 10;
						var count = parseInt(num/unit);
						if(count<1){
							count = 0;
						}
						var outThis = this;
						var index = 0;
						$("#personalAttr").css("z-index","10000");
						var interval = setInterval(function(){
							
							index = index+1;
							if(index<=count){
								outThis.setNext("addObjAnnim",function(){
									/*outThis.setNext("addLoveAction");
									outThis.nextData({num:unit});
									outThis.next();*/
									
								});
								outThis.nextData({"objSelector":"#lifeLoveSolidAnnim","targetSelector":".personalAttrDataHeaderLove","array":[{num:unit}]});
								outThis.next();
								setTimeout(function(){
									loveProgressPlug.setValue(loveProgressPlug.getValue()+unit);
								},2500);
							}else{
								clearInterval(interval);
								console.log("haha");
								var loveNum = num-count*unit;
								if(loveNum>0){
									outThis.setNext("addObjAnnim",function(){
										/*outThis.setNext("addLoveAction");
										outThis.nextData({num:beanNum});
										outThis.next();*/
									});
									outThis.nextData({"objSelector":"#lifeLoveSolidAnnim","targetSelector":".personalAttrDataHeaderLove","array":[{num:loveNum}]});
									outThis.next();
									setTimeout(function(){
										loveProgressPlug.setValue(loveProgressPlug.getValue()+loveNum);
									},2500);
									
								}
								setTimeout(function(){
									$("#personalAttr").css("z-index","100");
								},3000);
								
								
							}
						},50);
						
						showIncreaseNum(num,"/imgs/plug/lifeLoveSolid.png",1,-100,0);
					},
					
					//增加智慧豆动画
					addBeanAnnim:function(){
						var num = this.stepData("num");
						var unit = 100;
						var count = parseInt(num/unit);
						if(count<1){
							count = 0;
						}
						var outThis = this;
						var index = 0;
						var interval = setInterval(function(){
							index = index+1;
							if(index<=count){
								outThis.setNext("addObjAnnim",function(){
									/*outThis.setNext("addBeanAction");
									outThis.nextData({num:unit});
									outThis.next();*/
								});
								outThis.nextData({"objSelector":"#beanAnnim","targetSelector":".personalAttrDataHeaderBean","array":[{num:unit}]});
								outThis.next();
								setTimeout(function(){
									beanProgressPlug.setValue(beanProgressPlug.getValue()+unit);
								},2500);
								
							}else{
								
								var beanNum = num-count*unit;
	
								if(beanNum>0){
									outThis.setNext("addObjAnnim",function(){
										/*outThis.setNext("addBeanAction");
										outThis.nextData({num:beanNum});
										outThis.next();*/
									});
									outThis.nextData({"objSelector":"#beanAnnim","targetSelector":".personalAttrDataHeaderBean","array":[{num:beanNum}]});
									outThis.next();
									setTimeout(function(){
										beanProgressPlug.setValue(beanProgressPlug.getValue()+beanNum);
									},2500);
								}
								
								setTimeout(function(){
									$("#personalAttr").css("z-index","100");
								},3000);
								clearInterval(interval);
							}
						},50);
						
						showIncreaseNum(num,"/imgs/plug/bean.png",1,60,0);
					},
					
					//增加隐蔽动画
					addCoinAnnim:function(){
						var num = this.stepData("num");
						var outThis = this;
						var index = 0;
						var interval = setInterval(function(){
							index++;
							if(index<=num){
								outThis.setNext("addObjAnnim",function(){
									outThis.setNext("addMoneyAction");
									outThis.nextData({num:0.01});
									outThis.next();
								});
								outThis.nextData({"objSelector":"#coinAnnim","targetSelector":".personalAttrDataHeaderMoney","array":[{num:"0.01元"}]});
								outThis.next();
							}else{
								setTimeout(function(){
									$("#personalAttr").css("z-index","100");
								},3000);
								clearInterval(interval);
							}
						},50);
					},
					
					addLoveAction:function(){
						var num = this.stepData("num");
						loveProgressPlug.addValueAction(num);
	
					},
					
					subLoveAction:function(){
						var outThis = this;
						var num = this.stepData("num");
						loveProgressPlug.subValueAction(num);
						showIncreaseNum(num,"/imgs/plug/lifeLoveSolid.png",0,-80);
						
						setTimeout(function(){
							outThis.success();
						},5000);
					},
					
					addBeanAction:function(){
						var num = this.stepData("num");
						beanProgressPlug.addValueAction(num);
						
					},
					
					subBeanAction:function(){
						var outThis = this;
						var num = this.stepData("num");
						beanProgressPlug.subValueAction(num);
						showIncreaseNum(num,"/imgs/plug/bean.png",0,50);
						$("#personalAttr").css("z-index","10000");
						setTimeout(function(){
							outThis.success();
							$("#personalAttr").css("z-index","100");
						},5000);
					},
					
					addMasonryAction:function(){
						var num = this.stepData("num");
						masonryProgressPlug.addValueAction(num);
					},
					
					subMasonryAction:function(){
					//	showIncreaseNum(num,"/imgs/plug/lifeLoveSolid.png",1,-80,0);
						var outThis = this;
						var num = this.stepData("num");
						masonryProgressPlug.subValueAction(num);
						
						showIncreaseNum(num,"http://on3s1z2us.bkt.clouddn.com/masonry3.png",2,-80,100);
						
						setTimeout(function(){
							outThis.success();
						},5000);
					},
					
					addMoneyAction:function(){
						var num = this.stepData("num");
						moneyProgressPlug.addValueAction(num);
					},
					
					subMoneyAction:function(){
						var outThis = this;
						var num = this.stepData("num");
						moneyProgressPlug.subValueAction(num);
						
						showIncreaseNum(num,"http://otsnwem87.bkt.clouddn.com/2a5d913a968687eec03d21c1bb88aa36.png",50,0);
						
						setTimeout(function(){
							outThis.success();
						},5000);
					},
					
					//增加动画
					addObjAnnim:function(){
						var objSelector = this.stepData("objSelector");
						var targetSelector = this.stepData("targetSelector");
						var array = this.stepData("array");
						var outThis = this;
						if(array){
							for(var i =0;i<array.length;i++){
								var obj = array[i];
								
								var randFromLeft = Math.random()*($(document).width()*0.6);
								
								var randFromTop = Math.random()*($(document).height()*0.1)+$(document).height()*0.5;
		
								var beanSolid = new ShowGood($(objSelector));
								beanSolid.hideSunshine();
								targetAnimate(beanSolid.dom,$(targetSelector),
										{time:2000,stopTime:100,msg:"× "+obj.num,offsetLeft:5,offsetTop:10,fromLeft:randFromLeft,fromTop:randFromTop},{time:400,preOffsetLeft:50,stopTime:10},
										function(){
											beanSolid.stop();
											outThis.success();
										});
							}
						}
						
					}
				});
	
	
	this.addLoveAnnim = function(num){
		attrPlug.addLoveAnnim({num:num});
	}
	
	this.addBeanAnnim = function(num){
		attrPlug.addBeanAnnim({num:num});
	}
	
	this.addCoinAnnim = function(num){
		attrPlug.addCoinAnnim({num:num});
	}
	
	this.subLoveAction = function(num){
		attrPlug.flowPlug.setNext("subLoveAction",function(){
			/*outThis.setNext("showBattle",function(){});
			outThis.nextData({
				isPassAnimate:isPassAnimate
			});
			outThis.next();
			waitPlug.close();*/
		});
		
		attrPlug.flowPlug.nextData({
			num:num
		});
		attrPlug.flowPlug.next();
	}
	
	this.subBeanAction = function(num){
		attrPlug.flowPlug.setNext("subBeanAction",function(){
			/*outThis.setNext("showBattle",function(){});
			outThis.nextData({
				isPassAnimate:isPassAnimate
			});
			outThis.next();
			waitPlug.close();*/
		});
		
		attrPlug.flowPlug.nextData({
			num:num
		});
		attrPlug.flowPlug.next();
	}
	
	this.showView = function(){
		attrPlug.showView();
	}
	
	this.getAttrData = function(){
		var love = loveProgressPlug.getValue();
		var bean = beanProgressPlug.getValue();
		var masonry = masonryProgressPlug.getValue();
		var money = moneyProgressPlug.getValue();
		
		var object = new Object();
		object.love = love;
		object.bean = bean;
		object.masonry = masonry;
		object.money = money;
		
		return object;
	}
	
	this.setAttrData = function(object){
		loveProgressPlug.setValue(object.love);
		beanProgressPlug.setValue(object.bean);
		masonryProgressPlug.setValue(object.masonry);
		moneyProgressPlug.setValue(object.money);
	}
	
	this.initProgress = function(){
		attrPlug.flowPlug.setNext("initProgress");
		attrPlug.flowPlug.next();
	}
	
	this.load = function(selector,callback){
		var url = "/view/plug/attrPlug";
		$.get(url,function(r){
			$(selector).css("display","block");
			$(selector).append(r);
			hideLoading();
			if(callback&&callback.success){
				callback.success();
			}
		},"html");
	}
	
	this.getBeanValue = function(){
		return beanProgressPlug.getValue();
	}
	
	this.getLoveValue = function(){
		return loveProgressPlug.getValue();
	}
	
	this.getMasonryValue = function(){
		return masonryProgressPlug.getValue();
	}
	
	this.getMoneyValue = function(){
		return moneyProgressPlug.getValue();
	}
	
	
}
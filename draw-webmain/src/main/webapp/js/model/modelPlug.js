function ModelPlug(){
	
	var loveWaterbublePlug;
	var beanWaterbublePlug;
	var physicalWaterbublePlug;
	var randomWaterbublePlug;
	var width = $(document).width();
	var modelPlug = new FlowPlug({
		initEventListener:function(){
			var outThis = this;
			$("#receiveLoveButton").click(function(){
				if(loveWaterbublePlug.getRatio()<1){
					new AlertPlug("冷却中，请稍后");
					return;
				}
				var url = "/api/main/receiveLove";
				var callback = new Object();
				var waitPlug = new WaitPlug();
				callback.success = function(resp){
					if(resp.success){
						
						var data = resp.data;
						addLoveAnnim(data.num);
						waitPlug.close();
						loveWaterbublePlug.dataInit();
						
						showRoating("#modelPhy",5000);
						showRoating("#modelPhy3",5000);
						
						outThis.setNext("setPhyData");
						outThis.nextData({
							data:data.phySchedule
						});
						outThis.next();
					}else{
						new AlertPlug(resp.errorMsg);
						waitPlug.close();
					}
				}
				request(url,callback,{});
				
			});
			
			$("#receiveBeanButton").click(function(){
				var url = "/api/main/receiveBean";
				var callback = new Object();
				
				if(beanWaterbublePlug.getRatio()<1){
					new AlertPlug("冷却中，请稍后");
					return;
				}
				var waitPlug = new WaitPlug();
				callback.success = function(resp){
					if(resp.success){
						var data = resp.data;
						addBeanAnnim(data.num);
						waitPlug.close();
						beanWaterbublePlug.dataInit();
						
						showRoating("#modelPhy2",5000);
						
						showRoating("#modelPhy3",5000);
						
						outThis.setNext("setPhyData");
						outThis.nextData({
							data:data.phySchedule
						});
						outThis.next();
					}else{
						new AlertPlug(resp.errorMsg);
						waitPlug.close();
					}
				}
				request(url,callback,{});
			});
			
			$("#receiveCoinButton").click(function(){
				var url = "/api/main/receiveRandom";
				var callback = new Object();
				
				if(randomWaterbublePlug.getRatio()<1){
					new AlertPlug("冷却中，请稍后");
					return;
				}
				var waitPlug = new WaitPlug();
				callback.success = function(resp){
					if(resp.success){
						var data = resp.data;
						addBeanAnnim(data.beanNum);
						addLoveAnnim(data.loveNum);
						waitPlug.close();
						randomWaterbublePlug.dataInit();
						showRoating("#modelPhy3",5000);
						
						showRoating("#modelPhy4",5000);
						
						outThis.setNext("setPhyData");
						outThis.nextData({
							data:data.phySchedule
						});
						outThis.next();
					}else{
						new AlertPlug(resp.errorMsg);
						waitPlug.close();
					}
				}
				request(url,callback,{});
			});
		},
		
		setPhyData:function(){
			physicalWaterbublePlug.dataInit();
			var data = this.stepData("data");
			physicalWaterbublePlug.setData(data)
		},
		
		loveRecovery:function(){
			
			var total = this.flowData("loveTotalPart");
			var data = this.flowData("lovePassPart");
			var interval = this.flowData("loveInterval");
			var unit = this.flowData("loveUnit");
			if(loveWaterbublePlug){
				loveWaterbublePlug.stop();
			}
			loveWaterbublePlug = new WaterbubblePlug("#modelPhy",{
				radius:width*0.08,
				waterColor:"RGBA(225,0,34,0.5)",
				textColor:"white",
				txt:"",
				data:data,
				animation:false,
				count:total,
				time:interval,
				precision:2,
				unit:unit
			});
								
			loveWaterbublePlug.growthWater(total,function(){
			},function(){
			});
		},
		
		beanRecovery:function(){
			
			var total = this.flowData("beanTotalPart");
			var data = this.flowData("beanPassPart");
			var interval = this.flowData("beanInterval");
			var beanUnit = this.flowData("beanUnit");
			beanWaterbublePlug = new WaterbubblePlug("#modelPhy2",{
				radius:width*0.08,
				waterColor:"RGBA(245,180,0,0.5)",
				textColor:"white",
				txt:"",
				data:data,
				animation:false,
				count:total,
				time:interval,
				precision:2,
				unit:beanUnit
			});
			
			beanWaterbublePlug.growthWater(total);
		},
		
		physicalRecovery:function(){
			var total = this.flowData("physicalTotalPart");
			var data = this.flowData("physicalPassPart");
			var interval = this.flowData("physicalInterval");
			var unit = this.flowData("physicalUnit");
			physicalWaterbublePlug = new WaterbubblePlug("#modelPhy3",{
				radius:width*0.08,
				waterColor:"RGBA(253,239,140,0.5)",
				textColor:"white",
				txt:"",
				data:data,
				animation:false,
				count:total,
				time:interval,
				precision:2,
				unit:unit
			});
			
			physicalWaterbublePlug.growthWater(total,
				function(num){
					$("#phyButton").text(num);
				},
				function(){
				}
			);
		},
		
		randomRecovery:function(){
			var total = this.flowData("randomTotalPart");
			var data = this.flowData("randomPassPart");
			var interval = this.flowData("randomInterval");
			var unit = this.flowData("randomUnit");
			randomWaterbublePlug = new WaterbubblePlug("#modelPhy4",{
				radius:width*0.08,
				waterColor:"RGBA(191,0,0,0.5)",
				textColor:"white",
				txt:"",
				data:data,
				animation:false,
				count:total,
				time:interval,
				precision:2,
				unit:unit
			});
			randomWaterbublePlug.growthWater(total);
		},
		
		
		//初始化数据
		initData:function(){
			var outThis = this;
			var callback = new Object();
			callback.success = function(obj){
				if(obj.success){
					var beanData = obj.data.bean;
					var loveData = obj.data.love;
					var phyData = obj.data.phy;
					var randomData = obj.data.random;
					outThis.flowData({
						loveTotalPart:loveData.upperLimit,
						lovePassPart:loveData.schedule,
						loveInterval:loveData.millisec,
						loveUnit:loveData.unit,
						
						
						beanTotalPart:beanData.upperLimit,
						beanPassPart:beanData.schedule,
						beanInterval:beanData.millisec,
						beanUnit:beanData.unit,
						
						physicalTotalPart:phyData.upperLimit,
						physicalPassPart:phyData.schedule,
						physicalInterval:phyData.millisec,
						physicalUnit:phyData.unit,
						
						randomTotalPart:randomData.upperLimit,
						randomPassPart:randomData.schedule,
						randomInterval:randomData.millisec,
						randomUnit:randomData.unit
						
						
					});
					
					outThis.success();
				}
			}
			var params = new Object();
			request("/api/main/propInfo",callback,params);
			/*this.flowData({
				
				
				beanTotalPart:5000,
				beanPassPart:4000,
				beanInterval:1000,
				
				physicalTotalPart:500,
				physicalPassPart:470,
				physicalInterval:20,
				
				randomTotalPart:500,
				randomPassPart:20,
				randomInterval:200
			});*/
			
		},
		
		hide:function(){
			$("#models").css("display","none");
		},
		
		show:function(){
			$("#models").css("display","block");
		},
		
		showView:function(){
			
			var outThis = this;
			this.setNext("initData",function(){
				outThis.setNext("loveRecovery");
				outThis.next();
				
				outThis.setNext("beanRecovery");
				outThis.next();
				
				outThis.setNext("physicalRecovery");
				outThis.next();
				
				outThis.setNext("randomRecovery");
				outThis.next();
				
				outThis.setNext("show");
				outThis.next();
				
				waitProgress.addProgress(10,100);
				
			});
			this.next();
			this.setNext("initEventListener");
			this.next();
		},

		begin:function(){
			this.setNext("hide");
			this.next();
		}
	});
	
	
	this.showView = function(){
		modelPlug.showView();
	}
	
	this.load = function(selector,callback){
		var url = "/view/plug/modelPlug";
		$.get(url,function(r){
			$(selector).css("display","block");
			$(selector).append(r);
			hideLoading();
			if(callback&&callback.success){
				callback.success();
			}
		},"html");
	}
}
<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en" style="width: 100%;height: 100%;">
<head>
	<meta name="viewport"
		content="width=device-width,user-scalable=no">
	 <meta name="format-detection" content="telephone=no">
	 <meta http-equiv="Pragma" content="no-cache">   
	 <meta http-equiv="Cache-Control" content="no-store">
	 <meta http-equiv="Expires" content="0">
	 <title>问答红包</title>
<tiles:insertAttribute name="resource"/>
<tiles:insertAttribute name="baseLayout"/>
</head>
<body>
    
    	<div style="">
    	<div class="personalAttr" id="personalAttr">
				<div class="personalAttrUserInfo">
					<div class="personalAttrUserInfoImg">
						<img src="/imgs/sadAlert.jpg">
						<div class="personalAttrUserInfoName" style="display: block;">
							<span>川川</span>
							<span> lv.7</span>
						</div>
					</div>
				</div>
				
				<div class="personalAttrData" id="personalAttrData">
					<ul>
						<li>
							
							<div class="personalAttrDataHeader personalAttrDataHeaderLove"></div>
							
							<div id="progressbarLove" style="width:50%;height:20px;border-radius:20px;display:inline-block;top: 0px;vertical-align: top;background-color:RGBA(139,76,32,1)">
								<div class="progress-label2" id="progressLabel2" style="height: 20px;border-radius:20px;color:RGBA(255,237,109,1)">0</div>
							</div>
							
							<div class="personalAttrDataHeader personalAttrDataHeaderPlus"></div>
							
						</li>

						<li>
							<div class="personalAttrDataHeader personalAttrDataHeaderBean"></div>
							
							<div id="progressbarBean" style="width:50%;height:20px;border-radius:20px;display:inline-block;top: 0px;vertical-align: top;background-color:RGBA(139,76,32,1)">
								<div class="progress-label2" id="progressLabel2" style="color:RGBA(255,237,109,1)">0</div>
							</div>
							
							<div class="personalAttrDataHeader personalAttrDataHeaderPlus"></div>
							
						</li>
						
						<li>
							<div class="personalAttrDataHeader personalAttrDataHeaderMasonry"></div>
							
							<div id="progressbarMasonry" style="width:50%;height:20px;border-radius:20px;display:inline-block;top: 0px;vertical-align: top;background-color:RGBA(139,76,32,1);">
								<div class="progress-label2" id="progressLabel2" style="color:RGBA(255,237,109,1)">0</div>
							</div>
							
							<div class="personalAttrDataHeader personalAttrDataHeaderPlus"></div>
							
						</li>
						
						<li>
							<div class="personalAttrDataHeader personalAttrDataHeaderMoney"></div>
							
							<div id="progressbarMoney" style="width:50%;height:20px;border-radius:20px;display:inline-block;top: 0px;vertical-align: top;background-color:RGBA(139,76,32,1)">
								<div class="progress-label2" id="progressLabel2" style="color:RGBA(255,237,109,1)">0</div>
							</div>
							
							<div class="mainViewDekornButton4" style="left:-2px;position: relative;">提现</div>
							
						</li>
						
					</ul>
				</div>
			
			</div>
			
			
			
			<div class="models" id="models">
				<ul>
					<li>
						<canvas style="background: url('http://7xugu1.com1.z0.glb.clouddn.com/lifeLoveSolid.png');background-size:100% 100%;" id="modelPhy"></canvas>
						<div  style="color: white;position: relative;top:-5px">爱心 </div>
						<!--  <div id="receiveLoveButton" style="background: RGBA(21,185,254,1);width:70px;height: 20px;margin: 0 auto;border-radius:20px;color: white;position: relative;top:-5px;">升级</div> -->
						
						<div id="receiveLoveButton" style="background: RGBA(61,212,11,1);width:70px;height: 20px;margin: 0 auto;border-radius:20px;color: white;position:relative;top:-5px;">领取</div>
						<!--  
						<div style="width: 100%;height:10px;position: relative;top:-60px;">
							<div id="progressbarLove_tool" style="width:50%;height:10px;border-radius:20px;display:inline-block;top: 0px;vertical-align: top;background-color:RGBA(139,76,32,1)">
								<div id="progress-label3" style="color: black;position: relative;font-size: 10px;text-align: center;top:-3px;">lv.10</div>
							</div>
						</div>
						-->
					
					</li>
					
					<li>
						<canvas id="modelPhy2" style="background: url('/imgs/plug/bean.png');background-size:95% 90%;background-position: 5px 0px;"></canvas>
						<div  style="color: white;position: relative;top:-5px">智慧豆</div>
						
						<div id="receiveBeanButton" style="background: RGBA(61,212,11,1);width:70px;height: 20px;margin: 0 auto;border-radius:20px;color: white;position:relative;top:-5px;">领取</div>
						
						<!--  
						<div style="width: 100%;height:10px;position: relative;top:-60px;">
							<div id="progressbarBean_tool" style="width:50%;height:10px;border-radius:20px;display:inline-block;top: 0px;vertical-align: top;background-color:RGBA(139,76,32,1)">
								<div id="progress-label3" style="color: black;position: relative;font-size: 10px;text-align: center;top:-3px;">lv.10</div>
							</div>
						</div>
						-->
					</li>
					
					
					<li>
						<canvas id="modelPhy3" style="background: url('http://on3s1z2us.bkt.clouddn.com/strength.png')no-repeat;background-size:95% 85%;"></canvas>
						<div  style="color: white;position: relative;top:-5px">体力</div>
						
						<div style="background: red;width:70px;height: 20px;margin: 0 auto;border-radius:20px;color: white;position: relative;top:-5px;" id="phyButton">2200000</div>
					
						<!--  
						<div style="width: 100%;height:10px;position: relative;top:-60px;">
							<div id="progressbarPhy_tool" style="width:50%;height:10px;border-radius:20px;display:inline-block;top: 0px;vertical-align: top;background-color:RGBA(139,76,32,1)">
								<div id="progress-label3" style="color: black;position: relative;font-size: 10px;text-align: center;top:-3px;">lv.10</div>
							</div>
						</div>
						
						-->
					</li>
					
					<li>
						<canvas id="modelPhy4" style="background: url('http://on3s1z2us.bkt.clouddn.com/dice3.png')no-repeat;background-size:100% 80%;background-position:0 5px;"></canvas>
						<div  style="color: white;position: relative;top:-5px;">随机</div>
						
						<div id="receiveCoinButton" style="background: RGBA(61,212,11,1);width:70px;height: 20px;margin: 0 auto;border-radius:20px;color: white;position:relative;top:-5px;">领取</div>
						
						<!--  
						<div style="width: 100%;height:10px;position: relative;top:-60px;">
							<div id="progressbarRandom_tool" style="width:50%;height:10px;border-radius:20px;display:inline-block;top: 0px;vertical-align: top;background-color:RGBA(139,76,32,1)">
								<div id="progress-label3" style="color: black;position: relative;font-size: 10px;text-align: center;top:-3px;">lv.10</div>
							</div>
						</div>
						-->
					</li>
					
				</ul>
			</div>
			
    
    
    	<div class="preload">
			<div class="preloadTheBrain"></div>
			<div id="progressbar" style="width:70%;margin: 0 auto;position: relative;margin-top: 50px;">
				<div class="progress-label" id="progressLabel">加载...</div>
			</div>
		</div>
		
		
		<div id="lifeLoveSolidAnnim" style="width:100px;height:100px;display: none;">
			<img src="http://7xugu1.com1.z0.glb.clouddn.com/lifeLoveSolid.png"/>
		</div>
		
		<div id="beanAnnim" style="width:100px;height:100px;display: none;">
			<img src="/imgs/plug/bean.png"/>
		</div>
		
		<div id="coinAnnim" style="width:100px;height:100px;display: none;">
			<img src="http://on3s1z2us.bkt.clouddn.com/coin.png"/>
		</div>
    	<tiles:insertAttribute name="body" />
    </div>
    
     <style type="text/css">
     	.ui-progressbar{
     		position:relative;
     	}
     	
     	.progress-label{
     		position: absolute;
     		left:50%;
     		top:4px;
     		font-weight: bold;
     		text-shadow: 1px 1px 0 #fff;
     	}
     
		body .plugclass{
			border-radius:50px;
		}
		
		body .plugclass .layui-layer-title{
			border-radius:50px;
		}
	</style>
	
	
		<style type="text/css">
	     	.progress-label2{
	     		position: absolute;
	     		text-align:center;
	     		width:100%;
	     		font-weight: bold;
	     		color:RGBA(77,209,255,1);
	     		height: 20px;
	     		font-size: 10px;
	     		top:1px;
	     	}
	     	
	     	#progressbarLove .ui-corner-left{
	     		background: RGBA(225,0,34,1);
	     		height: 20px;
	     		border-radius:20px;
	     	}
	     	
	     	#progressbarBean .ui-corner-left{
	     		background: RGBA(245,192,0,1);
	     		height: 20px;
	     		border-radius:20px;
	     	}
	     	
	     	#progressbarMasonry .ui-corner-left{
	     		background: RGBA(127,122,139,1);
	     		height: 20px;
	     		border-radius:20px;
	     		
	     		
	     	}
	     	
	     	#progressbarMoney .ui-corner-left{
	     		background: RGBA(168,134,51,1);
	     		height: 20px;
	     		border-radius:20px;
	     	}
	</style>
	
	
	<script type="text/javascript">
	
		var attrPlug;
		
		var modelPlug;
		
		
		var loveProgressPlug;
		var beanProgressPlug;
		var masonryProgressPlug;
		var moneyProgressPlug;
		var loveWaterbublePlug;
		var beanWaterbublePlug;
		var physicalWaterbublePlug;
		var randomWaterbublePlug;

		function addLoveAnnim(num){
			attrPlug.addLoveAnnim({num:num});
		}
		
		function addBeanAnnim(num){
			attrPlug.addBeanAnnim({num:num});
		}
		
		function addCoinAnnim(){
			attrPlug.addCoinAnnim({num:5});
		}
		
		function showAttr(){
			//loveAttrFunction.setNext("show");
			//loveAttrFunction.next();
		}
	
		$(document).ready(function(){
			
			var width = $(document).width();
			
			modelPlug = new FlowPlug({
				initEventListener:function(){
					var outThis = this;
					$("#receiveLoveButton").click(function(){
						var url = "/api/main/receiveLove";
						var callback = new Object();
						var waitPlug = new WaitPlug();
						callback.success = function(resp){
							if(resp.success){
								
								var data = resp.data;
								console.log("num:"+data.num);
								addLoveAnnim(data.num);
								waitPlug.close();
								loveWaterbublePlug.dataInit();
								
								showRoating("#modelPhy",5000);
							}
						}
						request(url,callback,{});
						
					});
					
					$("#receiveBeanButton").click(function(){
						var url = "/api/main/receiveBean";
						var callback = new Object();
						var waitPlug = new WaitPlug();
						callback.success = function(resp){
							if(resp.success){
								var data = resp.data;
								addBeanAnnim(data.num);
								waitPlug.close();
								beanWaterbublePlug.dataInit();
								
								showRoating("#modelPhy2",5000);
							}
						}
						request(url,callback,{});
					});
					
					$("#receiveCoinButton").click(function(){
						var url = "/api/main/receiveRandom";
						var callback = new Object();
						var waitPlug = new WaitPlug();
						callback.success = function(resp){
							if(resp.success){
								var data = resp.data;
								addBeanAnnim(data.beanNum);
								addLoveAnnim(data.loveNum);
								waitPlug.close();
								randomWaterbublePlug.dataInit();
								showRoating("#modelPhy3",5000);
							}
						}
						request(url,callback,{});
					});
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
					
					console.log("total:"+total);
					
					loveWaterbublePlug.growthWater(total,function(){
					//	console.log("progress");
					},function(){
						console.log("complete");
					});
				},
				
				beanRecovery:function(){
					
					var total = this.flowData("beanTotalPart");
					var data = this.flowData("beanPassPart");
					var interval = this.flowData("beanInterval");
					var beanUnit = this.flowData("beanUnit");
					console.log("beanUnit:"+beanUnit);
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
							console.log("success physical")
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
				
				begin:function(){
					var show = this.stepData("show");
					if(!show){
						this.setNext("hide");
						this.next();
					}else{
						this.setNext("show");
						this.next();
					}
					
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
					});
					this.next();
					
					
					
					this.setNext("initEventListener");
					this.next();
				}
			});
			attrPlug = new FlowPlug({

				//初始化
				begin:function(){
					var outThis = this;
					outThis.setNext("hide");
					outThis.next();
					this.setNext("initData",function(){
						outThis.setNext("initProgress");
						outThis.next();
					});
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
								
								masonryNum:30,
								
								moneyNum:0.5
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
					loveProgressPlug = new ProgressPlug("#progressbarLove","#progressbarLove .progress-label2",{type:2,isShowProgress:1});
					loveProgressPlug.setCount(loveLimit);
					beanProgressPlug = new ProgressPlug("#progressbarBean","#progressbarBean .progress-label2",{type:2,isShowProgress:1});
					beanProgressPlug.setCount(beanLimit);
					masonryProgressPlug = new ProgressPlug("#progressbarMasonry","#progressbarMasonry .progress-label2",{type:1,decimal:0,isShowProgress:0,count:100});
					moneyProgressPlug = new ProgressPlug("#progressbarMoney","#progressbarMoney .progress-label2",{type:1,unit:"元",decimal:2,isShowProgress:0,count:100000000});
					
					
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
					
					
				},
				
				//隐藏
				hide:function(){
					$("#personalAttr").css("display","none");
				},
				
				//显示
				show:function(){
					$("#personalAttr").css("display","");
				},
				
				//增加爱心动画
				addLoveAnnim:function(){
					var num = this.stepData("num");
					var outThis = this;
					var index = 0;
					var interval = setInterval(function(){
						index++;
						if(index<=num){
							outThis.setNext("addObjAnnim",function(){
								outThis.setNext("addLoveAction");
								outThis.nextData({num:1});
								outThis.next();
							});
							outThis.nextData({"objSelector":"#lifeLoveSolidAnnim","targetSelector":".personalAttrDataHeaderLove","array":[{num:"1"}]});
							outThis.next();
						}else{
							clearInterval(interval);
						}
					},50);
				},
				
				//增加智慧豆动画
				addBeanAnnim:function(){
					var num = this.stepData("num");
					var outThis = this;
					var index = 0;
					var interval = setInterval(function(){
						index++;
						if(index<=num){
							outThis.setNext("addObjAnnim",function(){
								outThis.setNext("addBeanAction");
								outThis.nextData({num:1});
								outThis.next();
							});
							outThis.nextData({"objSelector":"#beanAnnim","targetSelector":".personalAttrDataHeaderBean","array":[{num:1}]});
							outThis.next();
						}else{
							clearInterval(interval);
						}
					},50);
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
							clearInterval(interval);
						}
					},50);
				},
				
				addLoveAction:function(){
					var num = this.stepData("num");
					loveProgressPlug.addValueAction(num);
				},
				
				addBeanAction:function(){
					var num = this.stepData("num");
					beanProgressPlug.addValueAction(num);
				},
				
				addMasonryAction:function(){
					var num = this.stepData("num");
					masonryProgressPlug.addValueAction(num);
				},
				
				addMoneyAction:function(){
					var num = this.stepData("num");
					moneyProgressPlug.addValueAction(num);
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
		});
	
		
		
			
		var flag = false;
		function progress(value,time,callback,luck){
			
			progressbar = $("#progressbar");
			progressLabel = $("#progressLabel");
			
			if(!flag){
				progressbar.progressbar({
					value:false,
					change:function(){
						progressLabel.text(progressbar.progressbar("value")+"%");
					},
					complete:function(){
						$(".preload").css("display",'none');
					}
				});
				flag = true;
			}
			
			if(!luck&&!progressbar.luck){
				luck = uuid();
				progressbar.luck = luck;
			}
			if(progressbar.luck == luck){
				var val = progressbar.progressbar("value") || 0;
				if(val<value){
					if(val<101){
						progressbar.progressbar("value",val+1);
						setTimeout(function(){
							progress(value,time,callback,luck);
						},time);
						if(callback&&callback.progress){
							callback.progress(val+1);
						}
					}
				}else{
					progressbar.luck = null;
					if(callback&&callback.complete){
						callback.complete(value);
					}
				}
			}else{
				setTimeout(function(){
					progress(value,time,callback);
				},time);
			}
		}

	</script>
</body>
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
	

    <div class="container">
    
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
								<div class="progress-label2" id="progressLabel2" style="height: 20px;border-radius:20px;color:RGBA(255,237,109,1)">22元</div>
							</div>
							
							<div class="personalAttrDataHeader personalAttrDataHeaderPlus"></div>
							
						</li>
						
						
						
						<li>
							<div class="personalAttrDataHeader personalAttrDataHeaderBean"></div>
							
							<div id="progressbarBean" style="width:50%;height:20px;border-radius:20px;display:inline-block;top: 0px;vertical-align: top;background-color:RGBA(139,76,32,1)">
								<div class="progress-label2" id="progressLabel2" style="color:RGBA(255,237,109,1)">33</div>
							</div>
							
							<div class="personalAttrDataHeader personalAttrDataHeaderPlus"></div>
							
						</li>
						
						
						
						<li>
							<div class="personalAttrDataHeader personalAttrDataHeaderMasonry"></div>
							
							<div id="progressbarMasonry" style="width:50%;height:20px;border-radius:20px;display:inline-block;top: 0px;vertical-align: top;background-color:RGBA(139,76,32,1);">
								<div class="progress-label2" id="progressLabel2" style="color:RGBA(255,237,109,1)">20元</div>
							</div>
							
							<div class="personalAttrDataHeader personalAttrDataHeaderPlus"></div>
							
						</li>
						
						
						
						<li>
							<div class="personalAttrDataHeader personalAttrDataHeaderMoney"></div>
							
							<div id="progressbarMoney" style="width:50%;height:20px;border-radius:20px;display:inline-block;top: 0px;vertical-align: top;background-color:RGBA(139,76,32,1)">
								<div class="progress-label2" id="progressLabel2" style="color:RGBA(255,237,109,1)">20元</div>
							</div>
							
							<div class="mainViewDekornButton4" style="left:-2px;position: relative;">提现</div>
							
						</li>
						
						
						
						
					</ul>
				</div>
			
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
	     		left:40%;
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
		var loveAttrFunction;
		function addLoveAnnim(){
			attrPlug.addLoveAnnim({name:"wyc"});
		}
		
		function addBeanAnnim(){
			loveAttrFunction.setNext("addBeanAnnim");
			loveAttrFunction.next();
		}
		
		function addCoinAnnim(){
			loveAttrFunction.setNext("addCoinAnnim");
			loveAttrFunction.next();
		}
		function showAttr(){
			//loveAttrFunction.setNext("show");
			//loveAttrFunction.next();
		}
		function dekornAction(){
			
			attrPlug.dekornAction();
		}
	
		$(document).ready(function(){
			
			attrPlug = new FlowPlug({
				begin:function(){
					this.setNext("addLoveAnnim");
					this.next();
				},
				
				hide:function(){
					$("#personalAttr").css("display","none");
				},
				show:function(){
					$("#personalAttr").css("display","");
				},
				dekornAction:function(){
					/*targetAnimate($(".personalAttrDataHeaderLove"),$("#mainViewDekornButton"),
							{time:2000,stopTime:100,msg:"",isClone:1,offsetLeft:5,offsetTop:10,fromLeft:$(".personalAttrDataHeaderLove").offset().left,fromTop:$(".personalAttrDataHeaderLove").offset().top},{time:400,preOffsetLeft:50,stopTime:10},
							function(){
								
							});*/
							
					var layer = new LayerPlug("/view/dekorn/info?id=1&token=2&gameCode=znm123&isOpenSwitch=1",1,1,"");
				},
				addLoveAnnim:function(){
					var name = this.stepData("name");
					console.log("name:"+name);
					var outThis = this;
					var index = 0;
					var interval = setInterval(function(){
						index++;
						if(index<=10){
							outThis.setNext("addObjAnnim");
							outThis.nextData({"objSelector":"#lifeLoveSolidAnnim","targetSelector":".personalAttrDataHeaderLove","array":[{num:"1"}]});
							outThis.next();
						}else{
							clearInterval(interval);
						}
					},50);
				},
				addBeanAnnim:function(){
					this.setNext("addObjAnnim");
					this.nextData({"objSelector":"#beanAnnim","targetSelector":".personalAttrDataHeaderBean","array":[{num:1}]});
					this.next();
				},
				addCoinAnnim:function(){
					this.setNext("addObjAnnim");
					this.nextData({"objSelector":"#coinAnnim","targetSelector":".personalAttrDataHeaderMoney","array":[{num:"0.01元"}]});
					this.next();
				},
				addObjAnnim:function(){
					var objSelector = this.stepData("objSelector");
					var targetSelector = this.stepData("targetSelector");
					var array = this.stepData("array");
					
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
									});
						}
					}
					
				}
			});
		});
	
		function initAttr(){
	
			var loveProgressPlug = new ProgressPlug("#progressbarLove","#progressbarLove .progress-label2");
			
			loveProgressPlug.addValueAction(10);

			/*var beanProgressPlug = new ProgressPlug("#progressbarBean","#progressbarBean .progress-label2");
			beanProgressPlug.addValueAction(10);
			
			var beanProgressMasonry = new ProgressPlug("#progressbarMasonry","#progressbarMasonry .progress-label2");
			beanProgressMasonry.addValueAction(20);*/
			
		}
		
			
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
						initAttr();
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
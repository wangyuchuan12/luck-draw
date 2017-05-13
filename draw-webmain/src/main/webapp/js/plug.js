function ProgressPlug(selectorProgress,selectorLabel,params){
	var progressbar = $(selectorProgress);
	var progressLabel = $(selectorLabel);
	var growthSpeed = 100;
	
	this.value = 0;
	var outThis = this;
	
	if(params){
		if(params.growthSpeed){
			growthSpeed = params.growthSpeed;
		}
	}
	
	this.getValue = function(){
		return progressbar.progressbar("value");
	}
	
	this.setValue = function(value){
		progressbar.progressbar("value",value);
	}
	
	progressbar.progressbar({
		value:true,
		change:function(){
			progressLabel.text(outThis.getValue()+"%");
		},
		complete:function(){
		}
	});
	
	
	
	
	//0表示闲置， 1表示正在处理
	this.status = 0;
	this.addValue = 0;
	this.addValueAction = function(addValue){
		if(outThis.status==1){
			outThis.addValue = outThis.addValue+addValue;
			return;
		}else{
			
			console.log("....................................看看进来几次");
			outThis.addValue = addValue;
			outThis.status=1;
			
			var index = 0;
			var interval = setInterval(function(){
				index++;
				console.log("index:"+index+",addValue:"+outThis.addValue);
				if(index<=outThis.addValue){
					outThis.setValue(outThis.getValue()+1);
				}else{
					outThis.status=0;
					clearInterval(interval);
					outThis.addValue = 0;
				}
			},growthSpeed);
		}
		
	}
	
	
}

function ShowGood(dom){
	dom.css("display","none");
	dom = dom.clone();
	dom.css("display","");
	var width = dom.width();
	var height = dom.height();
	var backgroundDiv = $("<div style='width:100%;height:100%'></div>");
	backgroundDiv.css("background-size","100% 100%");
	backgroundDiv.css("position","relative");
	backgroundDiv.width(width);
	backgroundDiv.height(height);
	backgroundDiv.css("border-radius",width+10000);
	backgroundDiv.css("z-index","1");
	backgroundDiv.css("position","absolute");
	backgroundDiv.css("left","300");
	backgroundDiv.css("top","500");
	backgroundDiv.css("filter","alpha(opacity=45)");
	
	var imgDiv = $("<div style='width:100%;height:100%'></div>");
	imgDiv.css("background","url('http://onluguho9.bkt.clouddn.com/background-sunshine.png')");
	imgDiv.css("background-size","100% 100%");
	imgDiv.css("border-radius",100000);
	
	dom.css("width","100%");
	dom.css("height","100%");
	dom.css("position","relative");
	dom.css("top","-100%");
	$("body").append(backgroundDiv);
	backgroundDiv.append(imgDiv);
	
	backgroundDiv.append(dom);
	
	var index = 0;
	var interval = setInterval(function(){
		index++;
		imgDiv.css("-moz-transform","rotate("+index+"deg)");
		imgDiv.css("-webkit-transform","rotate("+index+"deg)");
		imgDiv.css("transform","rotate("+index+"deg)");
	},10);
	
	
	this.stop = function(){
		clearInterval(interval);
	}
	
	this.hideSunshine = function(){
		imgDiv.css("visibility","hidden");
	}
	
	this.dom = backgroundDiv;
	
}

function showRoating(selector,time){
	var dom = $(selector);
	var left = dom.offset().left;
	var top = dom.offset().top;
	var width = dom.width();
	var height = dom.height();
	var div = $("<div></div>");
	div.css("position","absolute");
	div.css("width",width);
	div.css("height",height);
	div.css("left",left);
	div.css("top",top);
	div.css("background","url('"+getRotating()+"')");
	div.css("background-size","100% 100%");
	var timeIndex = time/10;
	var index=0;
	var intervalIndex = 0;
	var interval = setInterval(function(){
		index=index+5;
		intervalIndex++;
		div.css("-moz-transform","rotate("+index+"deg)");
		div.css("-webkit-transform","rotate("+index+"deg)");
		div.css("transform","rotate("+index+"deg)");
		if(timeIndex<intervalIndex){
			clearInterval(interval);
			div.remove();
		}
		
	},10);
	$("body").append(div);
}

function targetAnimate(fromDom,toDom,params,preAnnimParam,fun){
	var fromLeft = $(window).width()/2;
	var fromTop = $(window).height()/2;
	
	var offsetLeft = 0;
	var offsetTop = 0;
	var time = 1000;
	var preTime = 200;
	
	var stopTime = 10;
	
	var preStopTime = 10;
	
	var msg;
	
	if(params){
		
		if(params.isClone){
			fromDom = fromDom.clone();
			
			$("body").append(fromDom);
		}
		
		if(params.fromLeft){
			fromLeft = params.fromLeft;
		}
		
		if(params.fromTop){
			fromTop = params.fromTop;
		}
		
		if(params.offsetTop){
			offsetTop = params.offsetTop;
		}
		
		if(params.offsetLeft){
			offsetLeft = params.offsetLeft;
		}
		
		if(params.stopTime){
			stopTime = params.stopTime;
		}
		
		if(params.time){
			time = params.time;
		}
		
		if(params.msg){
			msg = params.msg;
		}
		
		
	}
	
	if(msg){
		showMsg(msg,fromLeft-50,fromTop-50);
	}
	
	var toTop = toDom.offset().top;
	var toLeft = toDom.offset().left;
	
	fromDom.css("position","absolute");
	fromDom.css("left",fromLeft-fromDom.width()/2);
	fromDom.css("top",fromTop-fromDom.height()/2);
	
	fromDom.css("display","block");
	
	var width = toDom.width();
	var height = toDom.height();
	
	
	var preOffsetLeft = 0;
	var preOffsetTop = 0;
	var preOffWidth = 0;
	var preOffHeight = 0;
	if(preAnnimParam){
		if(preAnnimParam.preOffsetLeft){
			preOffsetLeft = preAnnimParam.preOffsetLeft;
		}
		
		if(preAnnimParam.preOffsetTop){
			preOffsetTop = preAnnimParam.preOffsetTop;
		}
		
		if(preAnnimParam.preOffWidth){
			preOffWidth = preAnnimParam.preOffWidth;
		}
		
		if(preAnnimParam.preOffHeight){
			preOffHeight = preAnnimParam.preOffHeight;
		}
		
		if(preAnnimParam.time){
			preTime = preAnnimParam.time;
		}
		
		if(preAnnimParam.stopTime){
			preStopTime = preAnnimParam.stopTime;
		}
		
		
		
		setTimeout(function(){
			fromDom.stop(true,true).animate({
				left:fromLeft-fromDom.width()/2+preOffsetLeft,
				top:fromTop-fromDom.height()/2+preOffsetTop,
				width:fromDom.width()+preOffWidth,
				height:fromDom.height()+preOffHeight
				
			},preTime,function(){
				thisAnimate();	
			});
		},preStopTime);
		
	}else{
		thisAnimate();
	}
	
	function thisAnimate(){
		
		setTimeout(function(){
			fromDom.stop(true,true).animate({
				top:toTop+offsetTop,
				left:toLeft+offsetLeft,
				width:width,
				height:height
			},time,function(){
				fromDom.css("display","none");
				if(fun){
					fun.call({});
				}
			});
		},stopTime);
		
	}
}

function showMsg(msg,fromLeft,fromTop){
	var fontSize = 30;
	var msgDiv = $("<div>"+msg+"</div>");
	msgDiv.css("color","RGBA(255,255,21,1)");
	msgDiv.css("font-size",fontSize+"px");
	msgDiv.css("font-weight","bolder");
	msgDiv.css("left",fromLeft);
	msgDiv.css("top",fromTop);
	msgDiv.css("width","200px");
	msgDiv.css("text-align","center");
	msgDiv.css("position","absolute");
	msgDiv.css("z-index",10000);
	$("body").append(msgDiv);
	var fontIndex = 0;
	msgDiv.stop(true,true).animate({
		top:msgDiv.offset().top-200,
		color:"rgba(255,255,21,0.1)"
	},{
		duration:5000,
		progress:function(anim,progress){
			
			msgDiv.css("font-size",fontSize-fontSize*progress);
		},
		complete:function(){
			msgDiv.remove();
		}
	});
	
	//msgDiv.remove();
}

function Guide(selector,offsetLeft,offsetTop){
	
	if(!offsetLeft){
		offsetLeft = 0;
	}
	if(!offsetTop){
		offsetTop = 0;
	}
	var left = $(selector).offset().left;
	var top =  $(selector).offset().top;
	var width = $(selector).width();
	
	var domTop = top+offsetTop;
	var domLeft = left+offsetLeft;
	var dom = $("<div></div>")
	dom.attr("style","background: url('http://on3s1z2us.bkt.clouddn.com/hand.png');" +
			"position: absolute;" +
			"-moz-transform:rotate(180deg);"+
			"-webkit-transform:rotate(180deg);"+
			"transform:rotate(180deg);"+
			"height: 50px;background-size:100% 100%;"+
			"text-align: center;padding-top: 10px;font-size: 15px;"+
			"top:"+(domTop)+"px;"+
			"left:"+(domLeft)+"px;"+
			"width:50px;");
	this.dom = dom;
	$("body").append(dom);
	var interval;
	this.annimate = function(){
		interval = setInterval(function(){
			dom.stop(true,true).animate({
				top:(domTop+5)+"px"
			},800);
			
			dom.stop(true,true).animate({
				top:(domTop-20)+"px"
			},800);
			
		},800);
	}
	
	this.stopAnnimate = function(){
		if(interval){
			clearInterval(interval);
		}
		dom.remove();
	}
	
	var outThis = this;
	this.close = function(){
		outThis.stopAnnimate();
	}
	
	dom.css("z-index","100000000000");
}

function WaitPlug(loadContent){
	var wait = layer.open({
		type:2,
		content:loadContent,
		shadeClose:false,
		shade:true
	});
	
	
	this.close = function(){
		layer.close(wait);
	}
}

function AlertPlug(content,btns){
	var alertPlug = layer.open({
		btn:btns,
		content:content
	});
	
	this.close = function(){
		layer.close(alertPlug);
	}
}

function FlowPlug(funs){
	var initFun;
	funs.init = function(){
		this.setNext("begin");
		this.next();
		initFun = this;
	}
	var flowJs = flowJS(funs);
	
	function FunCallback(){
		var outThis = this;
		this.call = function(params){
			
			var fun = outThis.name;
			console.log(".....fun:"+fun)
			initFun.setNext(fun);
			if(params){
				initFun.nextData(params);
			}
			initFun.next();
		}
	}
	
	var outThis = this;
	for(var fun in funs){
		var funCallback = new FunCallback();
		outThis[fun] = funCallback.call;
		funCallback.name = fun;
	}
}


function LayerPlug(url,w,h,loadContent){
	var borderRadius = 20;
	if(w==1){
		borderRadius = 0;
	}
	this. frameId = uuid();
	var outThis = this;
	this.height = $(document).height();
	this.height = this.height*h;
	this.width = $(document).width();
	this.width = this.width*w;
	this.url = url;
	this.loadContent = loadContent;
	
	var style;
	
	style='background-color:RGBA(0,0,0,0);border-radius:'+borderRadius+'px;border: none;';
	this.load = function(url,width,height,loadContent){
		plugLayer = layer.open({
			title:false,
			type:1,	
			content:"<iframe scrolling='no' noresize='noresize' id='"+outThis.frameId+"' src="+url+" style='border-radius:"+borderRadius+"px;border:0px solid white;width:"+0+"px;height:"+0+"px;'></iframe>",
			style:style,
		//	style: 'position:fixed; left:0; top:0; width:100%; height:100%; border: none; -webkit-animation-duration: .5s; animation-duration: .5s;'
			anim:"up",
			fadeIn:1000,
			shift:10,
			closeBtn:1,
			shadeClose:false,
			shade:true
		});
		var wait = layer.open({
			type:2,
			content:loadContent,
			shadeClose:true
		});
		
		$("#"+this.frameId).load(function(){
			layer.close(wait);
			var thisWidth = 0;
			var thisHeight = 0;
			$("#"+outThis.frameId).width(outThis.width);
			$("#"+outThis.frameId).height(outThis.height);
			
		});
	}
	this.reload = function(){
		this.load(outThis.url,outThis.width,outThis.height,outThis.loadContent);
	}
	this.load(this.url,this.width,this.height,this.loadContent);
	this.close = function(){
	
		layer.close(plugLayer);
	}
}
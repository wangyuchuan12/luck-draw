function showIncreaseNumFromEl(num,fromEl,type,offsetLeft,offsetTop,imgUrl,offsetWidth,offsetHeight){
	if(!type){
		type = 0;
	}
	if(!offsetLeft){
		offsetLeft = 0;
	}
	
	if(!offsetTop){
		offsetTop = 20;
	}
	
	if(!offsetWidth){
		offsetWidth = 0;
	}
	
	if(!offsetHeight){
		offsetHeight = 0;
	}
	var div = $("<div></div>");
	var top = fromEl.offset().top+offsetTop;
	var left = fromEl.offset().left+offsetLeft;
	
	div.css("top",top);
	div.css("left",left);
	
	div.css("position","fixed");

	div.css("height","50px");
	
	div.css("z-index",1000000000);
	var imgDiv = $("<img src='"+imgUrl+"'>");
	
	imgDiv.css("width","50px");
	imgDiv.css("height","50px");
	imgDiv.css("display","inline-block");
	var numDiv = $("<div></div>");
	
	if(type==1){
		numDiv.text("+"+num);
	}else{
		numDiv.text("-"+num);
	}
	
	numDiv.css("color","RGBA(255,223,68,1)");
	numDiv.css("display","inline-block");
	numDiv.css("padding-left","10px");
	numDiv.css("top","-5px");
	numDiv.css("position","relative");
	numDiv.css("font-size","20px");
	numDiv.css("font-weight","bolder");
	if(imgUrl){
		div.append(imgDiv);
	}
	div.append(numDiv);
	
	$("body").append(div);
	
	
	setTimeout(function(){
		var interval = setInterval(function(){
			offsetTop--;
			var top = fromEl.offset().top+offsetTop;
			div.css("top",top);
			if(offsetTop<=0){
				clearInterval(interval);
				div.remove();
				var lightDiv = $("<div></div>");
				lightDiv.css("background","url('http://on3s1z2us.bkt.clouddn.com/flashLight.png')");
				lightDiv.css("background-size","100% 100%");
				lightDiv.css("position","fixed");
				
				lightDiv.css("top",fromEl.offset().top)
				lightDiv.css("z-index",1000000000);
				
				lightDiv.height(fromEl.height()+offsetHeight);
				$("body").append(lightDiv);
				
				var lightWidth = 0;
				var lightInterval = setInterval(function(){
					lightWidth=lightWidth+5;
					lightDiv.width(lightWidth);
					lightDiv.css("left",fromEl.offset().left+fromEl.width()/2-lightDiv.width()/2);
					if(lightWidth>=fromEl.width()+offsetWidth){
						clearInterval(lightInterval);
						setTimeout(function(){
							lightDiv.remove();
						},500);
					}
				},1);
				
				
			}
		},1);
		
	},1000);
	
}

//增加新增数量
function showIncreaseNum(num,imgUrl,type,offsetLeft,offsetTop){

	if(!offsetLeft){
		offsetLeft = 0;
	}
	
	if(!offsetTop){
		offsetTop = 0;
	}
	var div = $("<div></div>");
	var top = $(window).height()/2+offsetTop;
	var left = $(window).width()/2+offsetLeft;
	
	div.css("top",top);
	div.css("left",left);
	
	div.css("position","fixed");
	
//	div.css("width","200px");
	div.css("height","50px");
	
	div.css("z-index",100000);
	var imgDiv = $("<img src='"+imgUrl+"'>");
	
	imgDiv.css("width","50px");
	imgDiv.css("height","50px");
	imgDiv.css("display","inline-block");
	var numDiv = $("<div></div>");

	if(type==1){
		numDiv.text("+"+num);
	}else{
		numDiv.text("-"+num);
	}
	
	numDiv.css("color","RGBA(255,223,68,1)");
	numDiv.css("display","inline-block");
	numDiv.css("padding-left","10px");
	numDiv.css("top","-5px");
	numDiv.css("position","relative");
	numDiv.css("font-size","50px");
	numDiv.css("font-weight","bolder");
	
	div.append(imgDiv);
	div.append(numDiv);
	
	$("body").append(div);
	
	div.css("left",div.offset().left-div.width()/2);
	var index = 0;
	var addNum =1;
	setTimeout(function(){
		var interval = setInterval(function(){
			top=top-addNum;
			addNum=addNum+0.5;
			div.css("top",top);
			index++;
			if(index==20){
				clearInterval(interval);
				setTimeout(function(){
					div.remove();
				},5000);
			}
		},10);
	},200);
}

//提示信息
function ShowAlert(msg){
	
	if(msg.css){
		msg.css("display","block");
	}
	var size = 5;
	var alertDiv = $("<div></div>");
	alertDiv.html(msg);
	alertDiv.css("color","black");
	alertDiv.css("font-size",size+"px");
	alertDiv.css("position","fixed");
	alertDiv.css("width","100%");
	alertDiv.css("text-align","center");
	alertDiv.css("margin","auto");
	alertDiv.css("top","50%");
	alertDiv.css("font-weight","bolder");
	
	alertDiv.css("z-index","10000");
	$("body").append(alertDiv);
	var interval;
	setTimeout(function(){
		interval = setInterval(function(){
			alertDiv.css("font-size",size+"px");
			size=size+0.5;
			if(size>=30){
				clearInterval(interval);
			}
		},1);
	},500);
	
	
	var flashLight = new FlashLight(alertDiv);
	
	this.close = function(){
		flashLight.close();
		clearInterval(interval);
		alertDiv.remove();
	}
}

function FlashLight(el){
	var size = 100;
	var alertDiv = $("<div></div>");
	alertDiv.css("background","url('http://on3s1z2us.bkt.clouddn.com/flashLight.png')");
	alertDiv.css("background-size","100% 100%");
	alertDiv.css("width",size+"px");
	alertDiv.css("height",size+"px");
	
	alertDiv.css("position","fixed");
	
	alertDiv.css("opacity","0.95");
	
	alertDiv.css("width",size+"px");
	alertDiv.css("height",size+"px");
	
	alertDiv.css("top",el.position().top+el.height()/2-alertDiv.height()/2);
	alertDiv.css("left",el.position().left+el.width()/2-alertDiv.width()/2);
	
	alertDiv.css("z-index","999");
	
	alertDiv.addClass("circular");
	$("body").append(alertDiv);
	
	var rotateInterval;
	var interval;
	var sunshineDiv;
	function rotate(){
		sunshineDiv = $("<div></div>");
		sunshineDiv.css("background","url('http://onluguho9.bkt.clouddn.com/sunshine.png')");
		sunshineDiv.css("background-size","100% 100%");
		sunshineDiv.width("300");
		sunshineDiv.height("300");
	//	sunshineDiv.css("opacity","0.8");
		sunshineDiv.css("top",el.position().top+el.height()/2-sunshineDiv.height()/2);
		sunshineDiv.css("left",el.position().left+el.width()/2-sunshineDiv.width()/2);
		sunshineDiv.css("position","fixed");
		sunshineDiv.css("border-radius",10000);
		sunshineDiv.css("margin","auto");
		sunshineDiv.css("z-index","60");
		alertDiv.append(sunshineDiv);
		var time = 0;
		rotateInterval = setInterval(function(){
			time=time-5;
			sunshineDiv.css("transform","rotate("+time+"deg)");
		},100);
		
		
	}
	setTimeout(function(){
		interval = setInterval(function(){
			alertDiv.css("width",size+"px");
			alertDiv.css("height",size+"px");
			
			alertDiv.css("top",el.position().top+el.height()/2-alertDiv.height()/2);
			alertDiv.css("left",el.position().left+el.width()/2-alertDiv.width()/2);
			size=size+10;
			
			if(size>=1500){
				clearInterval(interval);
				rotate();
			}
		},1);
	},500);
	
	this.close = function(){
		alertDiv.remove();
		sunshineDiv.remove();
		clearInterval(rotateInterval);
		clearInterval(interval);
	}
}

function WaterbubblePlug(selector,params){
	var outThis = this;
	this.data = params.data;
	this.unit = params.unit;
	this.params = params;
	this.count = params.count;
	this.precision = params.precision;
	this.unit = params.unit;
	this.time = params.time;
	
	this.num;
	this.funProgress;
	this.funCompile;
	
	this.stop = false;
	
	this.isComplete = 0;
	
	this.interval;
	
	if(!this.unit){
		this.unit = 0.01;
	}
	if(!this.data){
		this.data = 0;
	}
	if(!this.time){
		this.time = 1000;
	}
	
	this.getData = function(){
		return outThis.data.toFixed(0);
	}
	
	this.isComplete = function(){
		return outThis.isComplete;
	}
	
	this.setData = function(data){
		outThis.data = data;
		outThis.show();
	}
	
	this.getRatio = function(){
		return outThis.data/outThis.count;
	}
	
	this.show = function(){
		var params = outThis.params;
		params.data = outThis.data/outThis.count;
		params.txt = (outThis.data/outThis.count*100).toFixed(outThis.precision)+"%";
		if((outThis.data/outThis.count*100).toFixed(outThis.precision)>=100){
			params.txt = "完成";
			outThis.isComplete = 1;
		}
		var waterbuble = new Waterbubble(selector,params);
	}
	
	this.stop = function(){
		outThis.stop = true;
	}
	
	this.dataInit = function(){
		outThis.data = 0;
		outThis.show();
		clearInterval(this.interval);
		outThis.growthWater(outThis.num,outThis.funProgress,outThis.funCompile);
	}
	
	this.show();
	
	this.growthWater = function(num,funProgress,funCompile){
		this.num = num;
		this.funProgress = funProgress;
		this.funCompile = funCompile;
		var index = 0;
		this.interval = setInterval(function(){
			if(outThis.stop==true){
				clearInterval(outThis.interval);
			}
			if(outThis.data<=num){
				outThis.show();
				if(funProgress){
					funProgress.call({},outThis.data.toFixed(0));
				}
			}else{
				if(funCompile){
					funCompile.call({},outThis.data.toFixed(0));
				}
				clearInterval(outThis.interval);
			}
			outThis.data = outThis.data+outThis.unit;
			index+=outThis.unit;
			
		},outThis.time);
	}
}


function ProgressPlug(selectorProgress,selectorLabel,params){
	var progressbar = $(selectorProgress);
	var progressLabel = $(selectorLabel);
	var growthSpeed = 100;
	
	var isShowProgress = 0;
	
	var unit="";
	
	//0表示百分比，1表示具体值,2表示分数值,3不改变值
	var type = 0;
	
	this.value = 0;
	
	this.count = 100;
	
	var decimal = 0;

	var outThis = this;
	
	
	
	if(params){
		if(params.growthSpeed){
			growthSpeed = params.growthSpeed;
		}
		
		if(params.type){
			type = params.type;
		}
		
		if(params.isShowProgress){
			isShowProgress = params.isShowProgress;
		}
		
		if(params.unit){
			unit = params.unit;
		}
		
		if(params.count){
			outThis.count = params.count;
		}
		
		if(params.decimal){
			decimal = params.decimal;
		}
	}

	this.setValueBg= function(background){
		var progressbarValue = $(selectorProgress).find(".ui-progressbar-value");
		progressbarValue.css("background",background);
		
	}
	
	this.getProgressbar = function(){
		return outThis.progressbar;
	}
	
	this.isFull = function(){
		if(outThis.getValue<outThis.getCount){
			return false;
		}else {
			return true;
		}
	}
	
	
	this.getCount = function(){
		return outThis.count;
	}
	
	this.setCount = function(count){
		outThis.count = count;
	}
	
	this.getValue = function(){
		return outThis.value;
	}
	
	this.setValue = function(value){
		outThis.value = value;
		outThis.showValue();
	}
	
	this.showValue = function(){
		if(isShowProgress==1){
			progressbar.progressbar("value",(outThis.getValue()/outThis.getCount())*100);
		}
		
		if(type==0){
			progressLabel.text(((outThis.getValue()/outThis.getCount())*100).toFixed(decimal)+"%");
		}else if(type==1){

			if(outThis.getValue()){
				progressLabel.text(numTransform(outThis.getValue().toFixed(decimal))+unit);
			}
			
		}else if(type==2){

			var thisValue = numTransform(outThis.getValue());
			var thisCount = numTransform(outThis.getCount());
			progressLabel.text(thisValue+"/"+thisCount);
		}else if(type==3){
			
		}
		
		var progressbarValue = $(selectorProgress).find(".ui-progressbar-value");
		progressbarValue.css("border","0px solid");
	}
	
	progressbar.progressbar({
		value:true,
		change:function(){
			
			
		},
		complete:function(){
		}
	});
	
	
	
	
	//0表示闲置， 1表示正在处理
	this.status = 0;
	this.addValue = 0;
	this.addValueAction = function(addValue){
		
		var addNum;
		if(!decimal||decimal==0){
			addNum = 1;
		}else{
			addNum = 1/Math.pow(10,decimal);
		}
		
		var count = addValue/addNum;
		if(count&&count>0){
			for(var i = 0;i<count;i++){
				setTimeout(function(){
					outThis.setValue(addNum+outThis.getValue());
				},growthSpeed);
			}
		}
		
	}
	
	this.subValueAction = function(subValue){
		
		var value = outThis.getValue();
		if(!value){
			value = 0;
		}
		if(subValue&&subValue>0){
			
			value = value-subValue;
		}
		setTimeout(function(){
			outThis.setValue(value);
		},1500);
		
		
		showIncreaseNumFromEl(subValue,progressLabel,0,20,40,null,20);
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

function moveAnimateTrajectory(dom,toDoms,index,fun,offsetLeft,offsetTop,num,endFun){
	if(!index){
		index = 0;
	}
	if(!num){
		num = 0;
	}
	if(num<toDoms.length){
		moveAnimate(dom,toDoms[num],function(){
			if(fun){
				var next = new Object();
				next.next = function(){
					index++;
					num++;
					moveAnimateTrajectory(dom,toDoms,index,fun,offsetLeft,offsetTop,num,endFun);
				}
				fun.call({},index,toDoms[index],dom,next);
			}
			
		},offsetLeft,offsetTop);
	}else{
		if(endFun){
			endFun.call({});
		}
	}
}

function moveAnimate(dom,toDom,fun,offsetLeft,offsetTop){
	
	if(!offsetLeft){
		offsetLeft = 0;
	}
	
	if(!offsetTop){
		
		offsetTop = 0;
	}
	
	
	var toLeft = parseInt(toDom.css("left"));
	
	var toTop = parseInt(toDom.css("top"));
	
	var flag = false;

	dom.animate({
		top:[toTop+offsetLeft,"linear"],
		left:[toLeft+offsetTop,"linear"]
	},500,function(){
		fun.call();

		flag = true;
	});

	setTimeout(function(){
		if(!flag){
			fun.call();
		}
	},700);
	
	
	
	
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
	
	var zIndex = 1000;
	
	if(fromDom.css("zIndex")&&fromDom.css("zIndex")!="auto"){
//		zIndex=fromDom.css("zIndex");
	}

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
	
	fromDom.css("z-index",zIndex);
	
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

function showMsg(msg,fromLeft,fromTop,params){
	var fontSize = 30;
	if(params){
		if(params.fontSize){
			fontSize = params.fontSize;
		}
	}
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
	
	var btnArray;
	
	if(btns)
	{
		btnArray = new Array();
		for(var i = 0;i<btns.length;i++){
			var btn = btns[i];
			btnArray.push(btn.text);
		}
	}
	
	
	var alertPlug = layer.open({
		content:content,
		btn:btnArray,
		yes:function(){
			btns[0].click();
		},
		no:function(){
			btns[1].click();
		},
		btn2:function(){
			alert("btn2");
		},
		btn3:function(){
			alert("btn3");
		},
		btn4:function(){
			alert("btn4");
		}
	});
	
	this.close = function(){
		layer.close(alertPlug);
	}
}

function FlowPlug(funs){
	var initFun;
	var ouThis = this;
	funs.init = function(){
		ouThis.flowPlug = this;
		this.setNext("begin");
		this.next();
		initFun = this;
		
	}
	
	funs.setParam = function(){
		var name = this.stepData("name");
		var value = this.stepData("value");
		var object = new Object();
		object[name] = value;
		this.flowData(object);
	}
	var flowJs = flowJS(funs);
	
	function FunCallback(){
		var outThis = this;
		this.call = function(params){
			
			var fun = outThis.name;
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

var modelLoad = new ModelLoad();

function getModelLoad(){
	
	return modelLoad;
}

function ModelLoad(){
	
	var outThis = this;
	var modelObject;
	this.loadUrl = function(url,callback){
		showLoading();
		$("#iframeContair").empty();
		$.get(url,function(r){
			$("#iframeContair").css("display","block");
			$("#iframeContair").append(r);
			hideLoading();
			if(callback&&callback.success){
				callback.success();
			}
		},"html");
	}
	
	this.loadAddDrawModel = function(callback){
		var addDrawModel = new AddDrawModel({
			success:function(obj){
				outThis.closeModel();
				if(callback&&callback.success){
					callback.success(obj);
				}
			}
		});
		addDrawModel.init();
		
		modelObject = addDrawModel;
	}
	
	this.loadDrawInfo = function(id,callback){
		
		var drawInfo = new DrawInfoModel({
			answerResult:function(data){
				outThis.closeModel();
				if(callback&&callback.answerResult){
					callback.answerResult(data);
				}
			}
		});
		drawInfo.init(id);
		
		modelObject = drawInfo;
	}
	
	this.closeModel = function(){
		
		if(modelObject&&modelObject.close){
			modelObject.close();
		}
		
		$("#iframeContair").empty();
		
		$("#iframeContair").css("display","none");
	}

}

function LayerPlug(url,w,h,loadContent,fun,btns){
	var borderRadius = 20;
	if(w==1){
		borderRadius = 0;
	}
	this.frameId = uuid();
	var outThis = this;
	this.height = $(document).height();
	this.height = this.height*h;
	this.width = $(document).width();
	this.width = this.width*w;
	this.url = url;
	this.loadContent = loadContent;
	
	this.plugLayer;
	
	var style;
	
	var btnArray;
	
	if(btns)
	{
		btnArray = new Array();
		for(var i = 0;i<btns.length;i++){
			var btn = btns[i];
			btnArray.push(btn.text);
		}
	}
	
	style='background-color:RGBA(0,0,0,0);border-radius:'+borderRadius+'px;border: none;';
	this.load = function(url,width,height,loadContent){
		outThis.plugLayer = layer.open({
			title:false,
			type:1,	
			content:"<iframe scrolling='no' noresize='noresize' id='"+outThis.frameId+"' src="+url+" style='border-radius:"+borderRadius+"px;border:0px solid white;width:"+0+"px;height:"+0+"px;-webkit-animation-duration: .5s; animation-duration: .5s;'></iframe>",
			style:style,
		//	style: 'position:fixed; left:0; top:0; width:100%; height:100%; border: none; -webkit-animation-duration: .5s; animation-duration: .5s;'
		//	anim:"up",
			fadeIn:1000,
			shift:10,
			closeBtn:1,
			btn:btnArray,
			yes:function(){
				btns[0].click();
			},
			no:function(){
				btns[1].click();
			},
			btn2:function(){
				alert("btn2");
			},
			btn3:function(){
				alert("btn3");
			},
			btn4:function(){
				alert("btn4");
			},
			shadeClose:false,
			shade:true,
			success:function(){
				
			}
		});
		
		
	
		
		var waitPlug = new WaitPlug(loadContent);
		
		$("#"+this.frameId).load(function(){
			waitPlug.close();
			var thisWidth = 0;
			var thisHeight = 0;
			$("#"+outThis.frameId).width(outThis.width);
			$("#"+outThis.frameId).height(outThis.height);
			if(fun){
				
				fun.call({});
			}
			
		});
		
		
		
		outThis.hide = function(){
			if(waitPlug){
				waitPlug.close();
			}
			
			$("#layui-m-layer"+outThis.plugLayer).css("display","none");
			
			if($("#"+outThis.frameId)[0].contentWindow.hide){
				$("#"+outThis.frameId)[0].contentWindow.hide();
			}
		}
		
		outThis.show = function(){
			$("#layui-m-layer"+outThis.plugLayer).css("display","");
			
			if($("#"+outThis.frameId)[0].contentWindow.show){
				$("#"+outThis.frameId)[0].contentWindow.show();
			}
		}
	}
	
	this.call = function(fun,param1,param2,param3){
		var contentWindow = $("#"+outThis.frameId)[0].contentWindow;
		var func = eval("contentWindow."+fun);
		new func(param1,param2,param3);
		
	}
	
	this.reload = function(){
		this.load(outThis.url,outThis.width,outThis.height,outThis.loadContent);
	}
	this.load(this.url,this.width,this.height,this.loadContent);
	this.close = function(){

		try{
			$("#"+outThis.frameId)[0].contentWindow.z_close();
		}catch(e){
			
		}
		layer.close(outThis.plugLayer);
	}
}

function staking(div_o,toDiv,parentDiv,offsetLeft,offsetTop,fun){
	if(!parentDiv){
		parentDiv = $("body");
	}
	
	if(!offsetLeft){
		offsetLeft = 0;
	}
	
	if(!offsetTop){
		offsetTop = 0;
	}
	var div = div_o.clone();
	div.css("display","");
	div.css("width",100);
	div.css("height",100);
	div.css("top",window.screen.availHeight/2-div.height());
	div.css("left",window.screen.availWidth/2-div.width()/2);
	div.css("opaticy",div_o.css("opaticy"));
	div.animate({
		top:toDiv.position().top+offsetTop,
		left:toDiv.position().left+offsetLeft,
		width:50,
		height:50
	},1000,function(){
		parentDiv.append(div);
		div.css("left",parseInt(toDiv.css("left").substring(0,(toDiv.css("left").length-2)))+offsetLeft);
		div.css("top",parseInt(toDiv.css("top").substring(0,(toDiv.css("top").length-2)))+offsetTop);
		if(fun){
			fun.call({});
		}
	});
	
	$("body").append(div);
}

function MsgPlug(msg,time){
	if(!time){
		time = 2;
	}
	layer.open({
		content:msg,
		time:time,
		skin:'msg'
	});
}

function toLeftCenter(selector){
	var div = $(selector);
	var parent = div.parent();
	
	div.css("left",((parent.width()-div.width())/2)+"px");
}


function TabPanel(array){
	var outThis = this;
	var type;
	for(var i =0;i<array.length;i++){
		var obj = array[i];
		var tabSelector = obj.tab;
		var contentSelecotr = obj.content;
		$(tabSelector).attr("selector",tabSelector);
		$(tabSelector).attr("type",obj.type);
		$(tabSelector).click(function(){
			
			outThis.selectTab($(this).attr("selector"));
		});
	}
	
	this.getType = function(){
		return type;
	}
	
	
	this.selectTab = function(tab){
		type = $(tab).attr("type");
		for(var i =0;i<array.length;i++){
			var obj = array[i];
			var tabSelector = obj.tab;
			var contentSelecotr = obj.content;
			if(tabSelector==tab){
				$(contentSelecotr).css("display","block");
				$(tabSelector).css("color","white");
				$(tabSelector).css("background","black");
			}else{
				$(contentSelecotr).css("display","none");
				$(tabSelector).css("color","black");
				$(tabSelector).css("background","white");
			}
		}
	}
	
}

function InputItemFillTerms(selector){
	var outThis = this;
	var inputElStr = "<div class='inputItemFillTerms'>"+
	
							"<div class='inputItemFillTermsWorlds'>" +
								"<ul>"+
									"<li style='background: white;color:black;' id='fillWorldMinus'>" +
										"<span class='fa fa-minus'></span>"+
									"</li>"+
									"<li id='fillWorld1' status='1' class='fillWord' index='0'></li>"+
									"<li id='fillWorld2' status='0' class='fillWord' index='1'></li>"+
									"<li id='fillWorld3' status='0' class='fillWord' index='2'></li>"+
									"<li id='fillWorld4' status='0' class='fillWord' index='3'></li>"+
									"<li style='background: white;color:black;' id='fillWorldPlus'>"+
										"<span class='fa fa-plus'></span>"+
									"</li>"+
								"</ul>"+
							"</div>"+
	
							"<div class='inputItemFillTermsWorldsCheck'>"+
								"<ul>"+
									"<li id='fillWorldCheck1'></li>"+
									"<li id='fillWorldCheck2'></li>"+
									"<li id='fillWorldCheck3'></li>"+
									"<li id='fillWorldCheck4'></li>"+
									"<li id='fillWorldCheck5'></li>"+
									"<li id='fillWorldCheck6'></li>"+
								"</ul>"+
							"</div>"+
	
							"<div class='inputItemFillTermsWorldsCheck'>"+
								"<ul>"+
									"<li id='fillWorldCheck7'><input/></li>"+
									"<li id='fillWorldCheck8'><input/></li>"+
									"<li id='fillWorldCheck9'><input/></li>"+
									"<li id='fillWorldCheck10'><input/></li>"+
									"<li id='fillWorldCheck11'><input/></li>"+
									"<li id='fillWorldCheck12'><input/></li>"+
								"</ul>"+
							"</div>"+
	
							"<div class='inputItemFillTermsWorldsCheck'>"+
								"<ul>"+
									"<li id='fillWorldCheck13'><input value='2'/></li>"+
									"<li id='fillWorldCheck14'><input/></li>"+
									"<li id='fillWorldCheck15'><input/></li>"+
									"<li id='fillWorldCheck16'><input/></li>"+
									"<li id='fillWorldCheck17'><input/></li>"+
									"<li id='fillWorldCheck18'><input/></li>"+
								"</ul>"+
							"</div>"+
	
							"<div class='inputItemFillTermsWorldsCheck'>"+
								"<ul>"+
									"<li id='fillWorldCheck19'><input/></li>"+
									"<li id='fillWorldCheck20'><input/></li>"+
									"<li id='fillWorldCheck21'><input/></li>"+
									"<li id='fillWorldCheck22'><input/></li>"+
									"<li id='fillWorldCheck23'><input/></li>"+
									"<li id='fillWorldCheck24'><input/></li>"+
								"</ul>"+
							"</div>"+
						"</div>"
	var inputEl = $(inputElStr);		
	$(selector).append(inputEl);
	
	getValue = function(el){
		var status = el.attr("status");
		if(!status||status==0){
			return el.children("input").val().charAt(0);
		}else if(status==1){
			return el.text();
		}else if(status==2){
			return el.text();
		}
	}
	
	this.getAnswer = function(){
		var answer="";
		
		$(".fillWord").each(function(){
			answer=answer+$(this).text();
		});
		
		return answer;
	}
	
	this.setFills = function(value){
		for(var i = 1;i<=24;i++){
			var fillValue = value[i-1];
			var fillCheck = $("#fillWorldCheck"+i);
			var status = fillCheck.attr("status");
			if(!status||status==0){
				fillCheck.children("input").val(fillValue);
				outThis.editSuccess(fillCheck);
			}else{
				fillCheck.text(fillValue);
			}
			
		}
	}
	
	this.getFills = function(){
		var fillValue = "";
		for(var i = 1;i<=24;i++){
			var value = getValue($("#fillWorldCheck"+i));
			if(!value){
				return "";
			}
			fillValue = fillValue + value + ",";
		}
		if(fillValue==""){
			return fillValue;
		}else{
			return fillValue.substring(0,fillValue.length-1);
		}
	}
	
	
	this.editSuccess = function(el){
		var value = getValue(el);
		if(!value){
			return;
		}
		el.next().focus();
		
		el.css("background-color","white");
		el.css("color","black");
		
		el.text(value);
		
		el.children("input").unbind("change");
		el.children("input").unbind("blur");
		
		el.children("input").remove();
		el.css("padding-top","4px");
		el.attr("status","1");
	}
	
	this.addFillWord = function(){
		var length = $(".fillWord").length;
		if(length>=4){
			return;
		}
		$(".fillWord[index="+(length-1)+"]").after("<li id='fillWorld1' status='0' class='fillWord' index='"+length+"'></li>");
		
		$(".fillWord[index="+length+"]").click(function(){
			outThis.fillWordClick($(this));
		});
	}
	
	this.fillWordClick = function(el){
		if(el.attr("selectid")){
			el.text("");
			outThis.edit($("#"+el.attr("selectid"))); 
			outThis.nextPreEditFill(el);
			
			el.attr("selectid","");
		}
	}
	
	this.minusFillWord = function(){
		var length = $(".fillWord").length;
		if(length<=2){
			return;
		}
		if($(".fillWord[index="+(length-1)+"]").attr("status")==1){
			$(".fillWord[index="+(length-2)+"]").attr("status",1);
		}
		
		if($(".fillWord[index="+(length-1)+"]").attr("selectid")){
			outThis.edit($("#"+$(".fillWord[index="+(length-1)+"]").attr("selectid")));
		}
		$(".fillWord[index="+(length-1)+"]").remove();
	}
	
	$("#fillWorldPlus").click(function(){
		outThis.addFillWord();
	});
	
	$("#fillWorldMinus").click(function(){
		outThis.minusFillWord();
	});
	
	$(".fillWord").click(function(){
		outThis.fillWordClick($(this));
	});
	
	this.getPreEditFill = function(){
		var fillWorld = $("#inputItemFillTermsWorlds>ul");
		return $(".fillWord[status='1']");
	}
	
	this.edit = function(el){
		var value = el.text();
		el.text("");
		el.css("padding-top","0px");
		el.append("<input/>");
		el.children("input").val(value);
		el.attr("status","0");
		el.children("input").change(function(){
			outThis.editSuccess($(this).parent());
		});
		
		el.children("input").focus();
		el.children("input").blur(function(){
			if(getValue(el)){
				outThis.editSuccess(el);
			}
		});
		
		el.click(function(){
			var stauts = $(this).attr("status");
			if(stauts==1){
				outThis.select($(this));
			}else if(stauts==2){
				outThis.edit($(this));
				
				$(".inputItemFillTermsWorldsCheck>ul>li>input").focus();
			}
		});
		
	}
	
	this.nextPreEditFill = function(el){
		
		if(el){
			$(".fillWord").each(function(index){
				$(this).attr("status","0");
			});
			el.attr("status","1");
			return;
		}
		var selectIndex;
		var length = $(".fillWord").length;
		$(".fillWord").each(function(index){
			if($(this).attr("status")==1){
				selectIndex = index;
			}
		});
		
		var selectEl;
		if(selectIndex+1<length){
			$(".fillWord").each(function(index){
				if(index==selectIndex+1){
					$(this).attr("status","1");
					selectEl = $(this);
				}else{
					$(this).attr("status","0");
				}
			});
			return selectEl;
		}
	}
	
	this.select = function(el){
		if(!getValue(el)){
			return;
		}
		el.css("background","RGBA(241,241,242,1)");
		el.css("color","black");
		
		el.css("border","0px");
		
		el.attr("status","2");
		
		el.unbind("click");
		
		var preEditFill = outThis.getPreEditFill();
		
		if(preEditFill.attr("selectid")){
			outThis.editSuccess($("#"+preEditFill.attr("selectid")));
			
			
			$("#"+preEditFill.attr("selectid")).click(function(){
				var stauts = $(this).attr("status");
				if(stauts==1){
					outThis.select($(this));
				}else if(stauts==2){
					outThis.edit($(this));
					
					$(".inputItemFillTermsWorldsCheck>ul>li>input").focus();
				}
			});
			
		}
		
		preEditFill.text(getValue(el));
		
		preEditFill.attr("selectid",el.attr("id"));
		
		outThis.nextPreEditFill();
	}
	

	$(".inputItemFillTermsWorldsCheck>ul>li").each(function(){
		outThis.edit($(this));
	});
	
	
}


function InputItem(selector,callback){
	
	var outThis = this;
	
	var inputItemEl = $(selector);
	
	var inputEl = $(selector+" "+".inputItemInput>input");
	
	var inputItemIconEl = $(selector+" "+".inputItemIcon");
	
	var errorEl = $("<div class='inputItemErrorContent'>提示错误</div>");
	
	errorEl.css("display","none");
	
	inputItemEl.append(errorEl);
	var maxLength = 10;
	var minLength = 1;
	var isError = 0;
	inputEl.keyup(function(){
	//	outThis.isErrorCheck();
		if(callback&&callback.keyup){
			callback.keyup();
		}
	});
	
	
	this.setMaxLength = function(max){
		maxLength = max;
	}
	
	this.setMinLength = function(min){
		minLength = min;
	}
	
	this.isErrorCheck = function(){
		outThis.check();
		
		return isError;
	}
	
	this.check = function(){
		var value = outThis.getValue();
		if(value.length<minLength){
			outThis.error("最小长度为"+minLength);
			isError = 1;
		}else if(value.length>maxLength){
			outThis.error("最大长度为"+maxLength);
			isError = 1;
		}else{
			outThis.normal();
			isError = 0;
		}
	}
	
	this.error = function(error){

		inputEl.attr("style","background-color:RGBA(94,4,4,0.5);");
		
		inputItemIconEl.attr("style","background-color:RGBA(94,4,4,0.5);");
		
		inputItemEl.css("height","100px");
		
		errorEl.css("display","block");
		
		if(error){
			errorEl.text(error);
		}
	}
	
	this.normal = function(){
		inputEl.attr("style","");
		
		inputItemIconEl.attr("style","");
		
		inputItemEl.css("height","");
		
		errorEl.css("display","none");
		
		errorEl.text("错误提示");
	}
	
	this.getValue = function(){
		return inputEl.val();
	}
}

function InputSelect(selector,contentSelector,callback){
	var array;
	var outThis = this;
	var el = $(selector);
	
	var inputEl = $(selector+" "+".inputItemInput .inputItemInputSelect");
	
	var inputItemIconEl = $(selector+" "+".inputItemIcon");
	
	var value;

	var errorEl = $("<div class='inputItemErrorContent'>请选择一个选项</div>");
	
	errorEl.css("display","none");
	
	el.append(errorEl);
	
	
	
	el.click(function(){
		//outThis.openAlert();
		callback.openAlert();
	});
	
	this.setData = function(data){
		array = data;
	}
	
	
	this.requestDataByUrl = function(url,callback){
		var waitPlug = new WaitPlug();
		request(url,{
			success:function(data){
				waitPlug.close();
				var subjects = data.data;
				var array = new Array();
				for(var i = 0;i<subjects.length;i++){
					array.push({
						text:subjects[i].name,
						value:subjects[i].id,
						code:subjects[i].code
					});
				}
				
				outThis.setData(array);
				
				callback.success();
			},
			failure:function(){
				waitPlug.close();
				callback.failure();
			}
		},{});
	}
	
	this.openUrl = function(url){
		outThis.requestDataByUrl(url,{
			success:function(){
				outThis.openAlert();
			},
			failure:function(){
				
			}
		});
		
	}
	
	this.selectItemByUrl = function(url,value){
		outThis.requestDataByUrl(url,{
			success:function(){
				outThis.selectItem(value);
			},
			failure:function(){
				
			}
		});
	}
	
	this.selectItem = function(value){
		outThis.normal();
		if(callback&&callback.select){
			for(var i =0;i<array.length;i++){
				if(array[i].value==value){
					callback.select(array[i]);
					$(contentSelector).text(array[i].text);
					break;
				}
			}
			
		}
	}
	
	this.openAlert = function(){
		var selectItems = "";
		for(var i = 0;i<array.length;i++){
			selectItems = selectItems+"<div class='selectItem' value='"+array[i].value+"'>"+array[i].text+"</div>";
		}
		var selectListElStr = "<div class='selectList'>"+selectItems+"</div>";
		var alertPlug = new AlertPlug(selectListElStr);
		$(".selectItem").click(function(){
			alertPlug.close();
			outThis.selectItem($(this).attr("value"));
		});
	}
	
	this.getValue = function(){
		return value;
	}
	
	this.error = function(error){

		inputEl.attr("style","background-color:RGBA(94,4,4,0.5);");
		
		inputItemIconEl.attr("style","background-color:RGBA(94,4,4,0.5);");
		
		el.css("height","100px");
		
		errorEl.css("display","block");
		
		if(error){
			errorEl.text(error);
		}
	}
	
	
	this.normal = function(){
		inputEl.attr("style","");
		
		inputItemIconEl.attr("style","");
		
		el.css("height","");
		
		errorEl.css("display","none");
		
		errorEl.text("请选择一个选项");
	}
}
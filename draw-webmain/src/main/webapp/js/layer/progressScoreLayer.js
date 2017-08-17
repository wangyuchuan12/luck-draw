function ProgressScoreLayer(createCallback){
	var progressPlug;
	var progressFlowPlug;
	
	var progressPlug = new LayerPlug("/view/dekorn/progressScore",1,1,"",function(){
		createCallback.success();
	});
	this.init = function(initCallback){
		initCallback.setProgressScore = function(plug){
			progressScore = plug;
		}
		progressPlug.call("init",initCallback);
		
		progressPlug.hide();
	}
	
	this.initData = function(data){
		progressFlowPlug.setNext("initData",function(){
			
		});
		progressFlowPlug.nextData(data);

		progressFlowPlug.next();
	}
	
	
	this.showData = function(){
		progressFlowPlug.setNext("showData");
		progressFlowPlug.next();
	}
	
	this.setThisIndex = function(index){
		progressFlowPlug.setNext("setThisIndex");
		progressFlowPlug.nextData({
			thisIndex:index
		});
		progressFlowPlug.next();
	}
	
	this.showIndexStyleHandle = function(iconUrl,index,isGuide){
		progressFlowPlug.setNext("showIndexStyleHandle");
		progressFlowPlug.nextData({
			iconUrl:iconUrl,
			index:index,
			isGuide:isGuide
		});
		progressFlowPlug.next();
	}
	
	this.startStage = function(stage){
		progressFlowPlug.setNext("startStage");
		progressFlowPlug.nextData({
			stage:stage
		});
		
		progressFlowPlug.next();
	}
	
	this.setBattleId = function(battleId){
		progressFlowPlug.setNext("setBattleId");
		progressFlowPlug.nextData({
			battleId:battleId
		});
		progressFlowPlug.next();
	}
	
	this.initStageIndex = function(stage){
		progressFlowPlug.setNext("initStageIndex",function(){
			
		});
		

		progressFlowPlug.nextData({
			stageIndexs:stage
		});
		progressFlowPlug.next();
	}
	
	this.toStage = function(stage,callback){
		progressFlowPlug.setNext("toStage");
		progressFlowPlug.nextData({
			stage:stage,
			callback:callback
		});
		progressFlowPlug.next();
	}
	
	this.show = function(){
		progressPlug.show();
	}
	
	this.hide = function(){
		progressPlug.hide();
	}
}
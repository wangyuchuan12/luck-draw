function BattleInfoLayer(mainCallback){
	var outThis = this;
	var battlePlug = null;
	var battleFlowPlug = null;
	this.init = function(initCallback){
		battlePlug = new LayerPlug("/view/dekorn/battleInfo",1,1,"",function(){
			var callback = new Object();
			callback.setBattleFlowPlug = function(plug){
				battleFlowPlug = plug;
				initCallback.success();
			}
			
			callback.reStartDekorn = function(battleId,stage){
				mainCallback.reStartDekorn(battleId,stage);
			}
			
			callback.startDekorn = function(battleId,stage){
				mainCallback.startDekorn(battleId,stage);
			}
			
			battlePlug.call("load",callback);
		});
	}
	
	this.hide = function(){
		battlePlug.hide();
	}
	this.show = function(){
		battlePlug.show();
	}
	
	this.initData = function(data){
		battleFlowPlug.setNext("initData");
		battleFlowPlug.nextData(data);
		battleFlowPlug.next();
	}
	
	this.setBattleId = function(id){
		battleFlowPlug.setNext("setBattleId");
		battleFlowPlug.nextData({
			battleId:id
		});
		battleFlowPlug.next();
	}
	
	this.showView = function(isPassAnimate){
		outThis.show();
		battleFlowPlug.setNext("showView");
		battleFlowPlug.nextData({
			isPassAnimate:isPassAnimate
		});
		battleFlowPlug.next();
	}
}
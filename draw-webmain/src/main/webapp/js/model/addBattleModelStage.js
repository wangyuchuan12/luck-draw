function AddBattleModelStage(){
	var flowPlug = new FlowPlug({
		begin:function(){
			var callback = new Object();
			callback.success = function(data){
				imgUrl = data.url;
				isImg = 1;
			}
			toBigerImg("/api/common/resource/upload","#addCommodityIndex","file",callback);
		}
	});
}
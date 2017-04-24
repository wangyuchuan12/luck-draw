function LayerPlug(url,w,h,loadContent){
	this. frameId = uuid();
	var outThis = this;
	this.height = $(document).height();
	this.height = this.height*h;
	this.width = $(document).width();
	this.width = this.width*w;
	this.url = url;
	this.loadContent = loadContent;
	this.load = function(url,width,height,loadContent){
		plugLayer = layer.open({
			title:false,
			type:1,	
			content:"<iframe scrolling='no' noresize='noresize' id='"+outThis.frameId+"' src="+url+" style='border-radius:20px;border:0px solid white;width:"+0+"px;height:"+0+"px;'></iframe>",	
		///	skin:"plugclass",	
			style: 'background-color:RGBA(0,0,0,0);border-radius:20px;border: none;',
			anim:"up",
			fadeIn:1000,
			shift:10,
			closeBtn:1,
			shadeClose:false
		});
		var wait = layer.open({
			type:2,
			content:loadContent
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
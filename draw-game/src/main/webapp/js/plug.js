function LayerPlug(url,w,h){
	
	var frameId = uuid();
	
	var height = $("html").height();
	
	height = height*h;
	
	var width = $("html").width();
	
	width = width*w;
	var url = url;
	
	alert(width);
	alert(height);
	plugLayer = layer.open({
		title:false,
		type:1,
		
		content:"<iframe id='"+frameId+"' src="+url+" style='border-radius:20px;border:0px solid white;width:"+width+"px;height:"+(height-5)+"px;'s</iframe>",
		
	//	skin:"plugclass",
		
		style: 'background-color:RGBA(0,0,0,0);border-radius:20px;width:'+width+'px; height:'+height+'px; border: none;',
			
		anim:"up",
		fadeIn:1000,
		shift:10,
		closeBtn:1,
		shadeClose:false
	});
	
	var wait = layer.open({
		type:2,
		content:"加载中..."
	});
	
	$("#"+frameId).load(function(){
		layer.close(wait);
	});
}
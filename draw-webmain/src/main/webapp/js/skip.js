
//showModel有move，fadeIn 默认为move
//hideModel有move，fadeOut 默认为move
//html默认为空
//currentPage是否为当前页面，1表示为当前页面，0表示不是当前页面
//destroy有两种状态 destroy状态和cache状态
function ActionMapper(selector){
	var selectorDiv = $(selector);
	var entityArray = new Array();
	var outThis = this;
	var currentSeq = 0;
	this.paraseEntities = function paraseEntities(){
		selectorDiv.children("div").each(function(){
			var object = new Object();
			var showModel = $(this).attr("showModel");
			if(!showModel){
				showModel = "move";
			}
			var hideModel = $(this).attr("hideModel");
			if(!hideModel){
				hideModel = "move";
			}
			var url = $(this).attr("url");
			var html = $(this).html();
			var id = $(this).attr("id");
			var currentPage = $(this).attr("currentPage");
			var destroy = $(this).attr("destroy");
			if(!destroy){
				if(html){
					destroy = "cache";
				}else{
					destroy = "destroy";
				}
			}
			var animateTimeLong = $(this).attr("animateTimeLong");
			if(!animateTimeLong){
				animateTimeLong = "1000";
			}
			animateTimeLong = parseInt(animateTimeLong);
			object.showModel = showModel;
			object.hideModel = hideModel;
			object.url = url;
			object.html = html;
			object.destroy = destroy;
			object.id = id;
			object.destroy = destroy;
			object.el = $(this);
			object.currentPage=0;
			//此为序号，用户判断是向左move还是向右move
			object.seq = 0;
			object.currentPage = currentPage;
			object.animateTimeLong = animateTimeLong;
			entityArray.push(object);
		});
	}
	
	this.getCurrentPage = function getCurrentPage(){
		for(var i = 0;i<entityArray.length;i++){
			var object = entityArray[i];
			if(object.currentPage==1){
				return object;
			}
		}
	}
	
	this.fillEl = function fillEl(object,html){
		var el = object.el;
		el.css("width","100%");
		el.css("height","100%");
		el.css("display","block");
		el.css("position","absolute");
		el.css("left",selectorDiv.width());
		el.html(html);
	}
	
	this.getObjectById = function getObjectById(id){
		for(var i = 0;i<entityArray.length;i++){
			var object = entityArray[i];
			if(object.id == id){
				return object;
			}
		}
	}
	
	this.hideAnimate = function hideAnimate(object,direction){
		var selectorDivWidth = selectorDiv.width();
		var selectorDivHeight = selectorDiv.height();
		var el = object.el;
		var animateTimeLong = object.animateTimeLong;
		if(direction=="left"){
			el.animate({
				left:-selectorDivWidth
			},animateTimeLong,function(){
				el.empty();
				el.html("");
				el.css("display","none");
			});
		}else if(direction=="right"){
			el.animate({
				left:selectorDivWidth
			},animateTimeLong,function(){
				el.empty();
				el.html("");
				el.css("display","none");
			});
		}
	}
	
	this.showAnimate = function showAnimate(object,direction){
		var selectorDivWidth = selectorDiv.width();
		var selectorDivHeight = selectorDiv.height();
		var el = object.el;
		var animateTimeLong = object.animateTimeLong;
		if(direction=="left"){
			el.left = selectorDivWidth;	
		}else if(direction=="right"){
			el.left = -selectorDivWidth;
		}
		el.animate({
			left:0
		},animateTimeLong);
	}
	
	//显示页面
	this.show = function show(id){
		var object = outThis.getObjectById(id);
		var currentPage = outThis.getCurrentPage();
		var selectorDivWidth = selectorDiv.width();
		if(!object.currentSeq){
			object.currentSeq=currentSeq;
			currentSeq++;
		}
		if(object.currentPage==1){
			//表示激活的正是当前页面
			return;
		}else{
			
			object.currentPage=1;
			if(object.html){
				outThis.fillEl(object,html);
				if(currentPage){
					outThis.fillEl(object,data);
					if(currentPage){
						currentPage.currentPage=0;
						outThis.hideAnimate(currentPage,"left");
						outThis.showAnimate(object,"left");
					}else{
						object.el.css("left",0);
					}
				}
			}else{
				var url = object.url;
				$.ajax({
					url:url,
					success:function(data){
						outThis.fillEl(object,data);
						if(currentPage){
							currentPage.currentPage=0;
							outThis.hideAnimate(currentPage,"left");
							outThis.showAnimate(object,"left");
						}else{
							object.el.css("left",0);
						}
					}
				});
			}
		}
	}
}
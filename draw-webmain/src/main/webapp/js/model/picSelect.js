function PicSelectModel(params){
	var outThis = this;
	var arrayData = new Array();
	
	var type = 0;
	
	
	
	this.setType = function(t){
		type = t;
	}
	
	
	addItemView = function(id,img,name,isChecked){
		
		var itemStr;
		if(isChecked==0){
			var faIcon ="fa fa-square-o";
			itemStr = "<div class='picItem' id='"+id+"'>"+
						"<img src='"+img+"'>"+
						"<span>"+name+"</span>"+
						"<div class='"+faIcon+"'></div>"+
					  "</div>";
		}else if(isChecked==1){
			var faIcon = "fa fa-check-square-o";
			itemStr = "<div class='picItem' id='"+id+"'>"+
						"<img src='"+img+"'>"+
						"<span>"+name+"</span>"+
						"<div class='"+faIcon+"'></div>"+
					  "</div>";
		}else{
			itemStr = "<div class='picItem' id='"+id+"'>"+
						"<img src='"+img+"'>"+
						"<span>"+name+"</span>"
					  "</div>";
		}
		
		
		$(".picSelect").append(itemStr);
		
		$("#"+id).click(function(){
			var id = $(this).attr("id");
			var obj = outThis.getObject(id);
			if(obj.isChecked==1){
				obj.isChecked = 0;
				outThis.showView();
			}else if(obj.isChecked==0){
				if(type==0){
					var checks = outThis.getChecks();
					for(var i =0;i<checks.length;i++){
						var check = checks[i];
						if(check.isChecked==1){
							check.isChecked = 0;
						}
					}
				}
				
				obj.isChecked = 1;
				outThis.showView();
			}else if(obj.isChecked==2){
				if(params&&params.itemClick){
					params.itemClick(obj.id);
				}
			}
			
			
		});
	}
	
	this.getObject = function(id){
		for(var i = 0;i<arrayData.length;i++){
			if(arrayData[i].id==id){
				return arrayData[i];
			}
		}
	}
	
	this.getChecks = function(){
		var checks = new Array();
		
		for(var i = 0;i<arrayData.length;i++){
			if(arrayData[i].isChecked==1){
				checks.push(arrayData[i]);
			}
		}
		
		return checks;
	}
	
	this.showView = function(){
		$(".picSelect").empty();
		
		
		for(var i = 0;i<arrayData.length;i++){
			var data = arrayData[i];
			addItemView(data.id,data.imgUrl,data.name,data.isChecked);
		}
		
		$("#okButton").unbind("click");
		
		$("#okButton").click(function(){
			params.success(outThis.getChecks());
		});
		
		
		if(params.toolbar){
			if(params.toolbar.name1){
				$("#preButton").text(params.toolbar.name1);
			}
			if(params.toolbar.name2){
				$("#okButton").text(params.toolbar.name2);
			}
			
			if(params.toolbar.hidden){
				$(".toptool").css("display","none");
				$(".picSelect").css("padding-top","20px");
			}else{
				$(".toptool").css("display","block");
				$(".picSelect").css("padding-top","60px");
			}
		}else{
			$(".toptool").css("display","block");
		}
	}
	
	this.setData = function(data){
		arrayData = data;
	}
	
	this.load = function(selector,callback){
		showLoading();
		var url = "/view/plug/picSelect";
		$.get(url,function(r){
			$(selector).css("display","block");
			$(selector).append(r);
			hideLoading();
			if(callback&&callback.success){
				callback.success();
			}
		},"html");
	}
	
}
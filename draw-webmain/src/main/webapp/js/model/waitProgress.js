function WaitProgress(){

	var outThis = this;
	var flag = false;
	var progressValue = 0;
	
	this.hideProgress = function(){
		$(".preload").css("display","none");
	}
	this.addProgress = function(value,time,callback,luck){
		progressValue = progressValue+value;
		outThis.progress(progressValue,time,callback,luck)
	}
	
	this.getProgressValue = function(){
		return progressValue;
	}
	this.progress = function(value,time,callback,luck){
		thisValue = value;
		progressbar = $("#progressbar");
		progressLabel = $("#progressLabel");
		
		if(!flag){
			progressbar.progressbar({
				value:false,
				change:function(){
					progressLabel.text(progressbar.progressbar("value")+"%");
				},
				complete:function(){
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
						outThis.progress(value,time,callback,luck);
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
				outThis.progress(value,time,callback);
			},time);
		}
	}
	
	this.load = function(selector,callback){
		var url = "/view/plug/preload";
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
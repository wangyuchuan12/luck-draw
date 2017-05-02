<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en" style="width: 100%;height: 100%;">
<head>
	<meta name="viewport"
		content="width=device-width,user-scalable=no">
	 <meta name="format-detection" content="telephone=no">
	 <meta http-equiv="Pragma" content="no-cache">   
	 <meta http-equiv="Cache-Control" content="no-store">
	 <meta http-equiv="Expires" content="0">
	 <title>问答红包</title>
<tiles:insertAttribute name="resource"/>
<tiles:insertAttribute name="baseLayout"/>
</head>
<body>
	<div class="preload">
		<div class="preloadTheBrain"></div>
		<div id="progressbar" style="width:70%;margin: 0 auto;position: relative;margin-top: 50px;">
			<div class="progress-label" id="progressLabel">加载...</div>
		</div>
	</div>

    <div class="container">
    	<tiles:insertAttribute name="body" />
    </div>
    
     <style type="text/css">
     	.ui-progressbar{
     		position:relative;
     	}
     	
     	.progress-label{
     		position: absolute;
     		left:50%;
     		top:4px;
     		font-weight: bold;
     		text-shadow: 1px 1px 0 #fff;
     	}
     
		body .plugclass{
			border-radius:50px;
		}
		
		body .plugclass .layui-layer-title{
			border-radius:50px;
		}
	</style>
	
	<script type="text/javascript">
		var progressbar = $("#progressbar");
		var progressLabel = $("#progressLabel");
		progressbar.progressbar({
			value:false,
			change:function(){
				progressLabel.text(progressbar.progressbar("value")+"%");
			},
			complete:function(){
				$(".preload").css("display",'none');
			}
		});
			
			
		function progress(value,time,callback,luck){
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
							progress(value,time,callback,luck);
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
					progress(value,time,callback);
				},time);
			}
		}

	</script>
</body>
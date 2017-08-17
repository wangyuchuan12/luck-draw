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
    
    	<div style="width:100%;height:100%;overflow: scroll;">
    	
    		<div id="attr"></div>
			
			
			
			<div id="model"></div>
			
    
    

		
		
		<div class="qrcode" style="display: none;">
			<img src="/imgs/qrcode.jpg">
			<div style="color:red;text-align:center;font-size:15px;position: relative;top:-10px;">你还未关注该公众号，扫描二维码关注</div>
		</div>
		
    	<tiles:insertAttribute name="body" />
    </div>
    
     <div id="preload"></div>
	
	
		
	
	
	<script type="text/javascript">
		
		function showQrcode(){
			var screenWidth = $(document).width();
			var screenHeight = $(document).height();
			var div = $(".qrcode");
			div.css("display","");
			div.css("top",screenHeight/2-div.height());
			div.css("left",screenWidth/2-div.width()/2);
		}
		
		function hideQrcode(){
			var div = $(".qrcode");
			div.css("display","none");
		}
	
		
		var modelPlug2;
		var attrPlug2;
		var waitProgress;
		
		function initPlug(callback){
			
			
			waitProgress = new WaitProgress();
			
			waitProgress.load("#preload",{
				success:function(){
					waitProgress.addProgress(10,100);
					
					modelPlug2 = new ModelPlug();
					attrPlug2 = new AttrPlug();
					var flagAttr = false;
					var flagModel = false;
					attrPlug2.load("#attr",{
						success:function(){
							flagAttr = true;
						}
					});
					
					modelPlug2.load("#model",{
						success:function(){
							flagModel = true;
						}
					});
					
					var interval = setInterval(function(){
						if(flagAttr&&flagModel){
							clearInterval(interval);
							callback.success();
						}
					},1000);
					
					
				}
			});
			
			
			
		}
	
		

	</script>
</body>
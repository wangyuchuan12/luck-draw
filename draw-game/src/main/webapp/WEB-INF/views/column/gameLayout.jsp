<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
	 <meta name="format-detection" content="telephone=no">
	 <meta http-equiv="Pragma" content="no-cache">   
	 <meta http-equiv="Cache-Control" content="no-store">
	 <meta http-equiv="Expires" content="0">
	 <title>问答红包</title>
	 
	 <tiles:insertAttribute name="resource"/>
	 <tiles:insertAttribute name="basePlug"/>
	 <input type="hidden" name="status" value="${status}"/>
	 <input type="hidden" name="dekornId" value="${dekornId}"/>
	 <input type="hidden" name="passScore" value="${passScore}"/>
	 <input type="hidden" name="takepartId" value="${takepartId}"/>
</head>
<body>
    <div class="container">
    	<tiles:insertAttribute name="body" />
    </div>
    
    <script type="text/javascript">
    
    	var fLayout;
    
    
	    function submitScore(score){
	    	var status = getStatus();
	    	var passScore = getPassScore();
	    	score = parseInt(score);
	    	if(status==0){
	    		layer.open({
					title:false,
					type:2,
					area:["80%","70%"],
					shade:[0.1,'#000',true],
					skin:"plugclass",
					content:["/dekornHandle/invitationPlug?gameId=1&type=1&gameType=1&passScore="+score],
					fadeIn:1000,
					shift:10,
					closeBtn:0
				});
	    	}else if(status==1){
	    		var dekornId = getDekornId();
	    		var takepartId = getTakepartId();
	    		if(score>=passScore){
	    			layer.open({
	    				title:false,
	    				type:2,
	    				area:["80%","70%"],
	    				shade:[0.1,'#000',true],
	    				skin:"plugclass",
	    				content:["/view/dekornHandle/dekornSuccess?dekornId="+dekornId+"&score="+score+"&takepartId="+takepartId],
	    				fadeIn:1000,
	    				shift:10,
	    				closeBtn:0
	    			});
	    			
	    		}else{
	    			fLayout = layer.open({
	    				title:false,
	    				type:2,
	    				area:["80%","70%"],
	    				shade:[0.1,'#000',true],
	    				skin:"plugclass",
	    				content:["/view/dekornHandle/dekornFail?dekornId="+dekornId+"&score="+score+"&takepartId="+takepartId],
	    				fadeIn:1000,
	    				shift:10,
	    				closeBtn:0
	    			});
	    		}
	    		
	    	}
	    }
    	function getTakepartId(){
    		var takepartId = $("input[name=takepartId]").val();
    		return takepartId;
    	}
    	
    	function getGameCode(){
    		return "znm123";
    	}
    
    	function getStatus(){
    		var status = $("input[name=status]").val();
    		return parseInt(status);
    	}
    	
    	function getDekornId(){
    		var dekornId = $("input[name=dekornId]").val();
    		return dekornId;
    	}
    	
    	function getPassScore(){
    		var passScore = $("input[name=passScore]").val();
    		
    		return parseInt(passScore);
    	}
    	
    	function f_reTakepart(){
    		takepart();
    	}
    	
    	function f_back(){
    		var gameCode = getGameCode();
    		var id = getDekornId();
    		skipGameDekornInfo(id,gameCode);
    	}
    	
    	function s_button(){
    		layer.open({
				title:false,
				type:2,
				area:["80%","70%"],
				shade:[0.1,'#000',true],
				skin:"plugclass",
				content:["/view/dekornHandle/invitationPlug?gameId=1&type=1&gameCode=znm123&passScore=5"],
				fadeIn:1000,
				shift:10,
				closeBtn:0
			});
    	}
    	
    	
    	//邀请摆擂台插件点击拒绝按钮
    	function i_rejectButton(){
    		var url = "/api/dekorn/rejectPutUpRing";
    		
    		var callback = new Object();
    		
    		callback.success = function(resp){
    			alert(resp.success);
    		}
    		
    		callback.failure = function(resp){
    			alert("failure");
    		}
    		var params = new Object();
			params.dekornId = getDekornId();
			request(url,callback,params);
    		
    	}
    	
    	//邀请摆擂台插件点击接受按钮
    	function i_agreeButton(){
    		
    	}
    	
    	function takepart(){
			var id = getDekornId();
			var url = "/api/dekorn/takepart";
			var gameCode = getGameCode();
			var callback = new Object();
			callback.success = function(resp){
				if(resp.success){
					var takepartMemberId = resp.data.id;
					skipToGame(gameCode,id,1,7,takepartMemberId);
				}else{
					alert(resp.errorMsg);
				}
			}
			callback.failure = function(resp){
				alert(resp.errorMsg);
			}
			var params = new Object();
			params.id = id;
			request(url,callback,params);
		}
    	
    	function getWebpath(){
    		return "";
    	}
    </script>
</body>
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
    
    	function getTakepartId(){
    		var takepartId = $("input[name=takepartId]").val();
    		return takepartId;
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
    	
    	function getWebpath(){
    		return "";
    	}
    </script>
</body>
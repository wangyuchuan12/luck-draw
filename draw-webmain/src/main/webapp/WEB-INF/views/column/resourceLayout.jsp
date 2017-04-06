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
    <div class="container">
    	<tiles:insertAttribute name="body" />
    </div>
    
     <style type="text/css">
		body .plugclass{
			border-radius:50px;
		}
		
		body .plugclass .layui-layer-title{
			border-radius:50px;
		}
	</style>
</body>
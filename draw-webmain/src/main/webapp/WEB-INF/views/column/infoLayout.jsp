

<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en" style="width: 100%;height: 100%;">
<head>
	<meta name="viewport"
		content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
	 <meta name="format-detection" content="telephone=no">
	 <meta http-equiv="Pragma" content="no-cache">   
	 <meta http-equiv="Cache-Control" content="no-store">
	 <meta http-equiv="Expires" content="0">
	 <title>${title}</title>
<tiles:insertAttribute name="resource"/>
</head>
<body>
    <div class="container">
       <tiles:insertAttribute name="header" />
	   <tiles:insertAttribute name="body" />
	   <tiles:insertAttribute name="baseLayout" />
	   <div style="height:20px;"></div>
	</div>
</body>
</html>

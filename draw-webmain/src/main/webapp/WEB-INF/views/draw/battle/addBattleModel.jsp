<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
	<head>
		<link rel="stylesheet" href="/css/style1.0.css"/>
		<link rel="stylesheet" href="/css/core.css"/>
		<link rel="stylesheet" href="/font-awesome-4.7.0/css/font-awesome.min.css"/>
		
		<meta name="viewport"
		content="width=device-width,user-scalable=no">
		 <meta name="format-detection" content="telephone=no">
		 <meta http-equiv="Pragma" content="no-cache">   
		 <meta http-equiv="Cache-Control" content="no-store">
		 <meta http-equiv="Expires" content="0">
	</head>
	<body>
		<div class="addBattleModel">
			<div class="inputItems">
				<div class="inputItem">
					<div class="inputItemIcon">
						<span class="fa fa-address-card"></span>
					</div>
					<div class="inputItemInput">
						<input placeholder="名称">
					</div>
				</div>
				
				<div class="inputItem">
					<div class="inputItemIcon">
						<span class="fa fa-address-card"></span>
					</div>
					<div class="inputItemInput">
						<input placeholder="标题">
					</div>
				</div>
				<div class="inputItem">
					<div class="inputItemIcon">
						<span class="fa fa-address-card"></span>
					</div>
					<div class="inputItemInput">
						<input placeholder="消耗爱心">
					</div>
				</div>
				
				<div class="inputItem">
					<div class="inputItemIcon">
						<span class="fa fa-address-card"></span>
					</div>
					<div class="inputItemInput">
						<input placeholder="第一名奖励">
					</div>
				</div>
				
				<div class="inputItem">
					<div class="inputItemIcon">
						<span class="fa fa-address-card"></span>
					</div>
					<div class="inputItemInput">
						<input placeholder="第二名奖励">
					</div>
				</div>
				
				<div class="inputItem">
					<div class="inputItemIcon">
						<span class="fa fa-address-card"></span>
					</div>
					<div class="inputItemInput">
						<input placeholder="第三名奖励">
					</div>
				</div>
				
				<div class="inputItem">
					<div class="inputItemIcon">
						<span class="fa fa-address-card"></span>
					</div>
					<div class="inputItemInput">
						<input placeholder="第四名奖励">
					</div>
				</div>
				
			</div>
		</div>
	</body>
</html>
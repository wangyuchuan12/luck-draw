<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="preload">
		<div class="preloadTheBrain"></div>
		<div id="progressbar" style="width:70%;margin: 0 auto;position: relative;top:20%;border:0px solid red;">
			<div class="progress-label" id="progressLabel">加载...</div>
		</div>
</div>

<style type="text/css">
     	.ui-progressbar{
     		position:relative;
     		
     		background:red;
     		
     		border-radius:5px;
     	
     	}
     	
     	.ui-corner-left{
     		background:RGBA(140,105,9,1);
     		
     		
     		border:0px solid red;
     	}
     	
     	.progress-label{
     		position: absolute;
     		left:50%;
     		top:4px;
     		font-weight: bold;
     	}
     
		body .plugclass{
			border-radius:50px;
		}
		
		body .plugclass .layui-layer-title{
			border-radius:50px;
		}
	</style>
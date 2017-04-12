<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="plugLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
<tiles:putAttribute name="body">
		<div class="gameCompletePlug">
		
			<div class="gameCompletePlugLight">
				
			</div>
			
			<div class="gameCompletePlugHeaderImg">
					<img src="${drawUser.imgUrl}">
			</div>
			
			<div class="gameCompletePlugLifeLove">
				<ul>
					<c:forEach begin="1" end="${lifeLoveSolid}">
						<li class="lifeLoveSolid"></li>
					</c:forEach>
					<c:forEach begin="1" end="${lifeLoveHollow}">
						<li class="lifeLoveHollow"></li>
					</c:forEach>
					
				</ul>
			</div>
				
			<div class="gameCompletePlugBander">
				<span>${prompt}</span>
				<img src="http://7xugu1.com1.z0.glb.clouddn.com/banner.gif">
			</div>
			
			<div class="gameCompletePlugContent">
				<ul>
					<c:forEach items="${contentList}" var="content">
						<li>${content}</li>
					</c:forEach>
				</ul>
				
			</div>
			
			<div class="gameCompletePlugButton" id="confirmButton">确定</div>
		</div>
</tiles:putAttribute>
</tiles:insertDefinition>
<script type="text/javascript">
	$(document).ready(function(){
		var width = $(".gameCompletePlugHeaderImg>img").width();
		$(".gameCompletePlugHeaderImg>img").height(width);
		
		var width2 = $(".gameCompletePlugLight").width();

		$(".gameCompletePlugLight").height(width2);
		rotate();
		
		$("#confirmButton").click(function(){
			window.parent.s_button();
		});
	});
	
	
	function rotate(){
		
		var time=50;
		var index = setInterval(function(){
			time++;
			$(".gameCompletePlugLight").css("transform","rotate("+time+"deg)");
		},100);
	}
</script>

<style type="text/css">

	
	
</style>
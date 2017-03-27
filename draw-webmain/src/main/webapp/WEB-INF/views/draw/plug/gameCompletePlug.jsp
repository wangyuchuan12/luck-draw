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
					<img src="http://wx.qlogo.cn/mmopen/xPXrGtX7mxzVLiacuLGmhCugiccm8EcaPiaFYOaQ74EPBGFvkV0U7Mgy35raJRJfHfY3RF5XQwvscTDCzZuicTe5HA/0">
			</div>
			
			<div class="gameCompletePlugLifeLove">
				<ul>
					<li class="lifeLoveSolid"></li>
					<li class="lifeLoveSolid"></li>
					<li class="lifeLoveSolid"></li>
					<li class="lifeLoveHollow"></li>
				</ul>
			</div>
				
			<div class="gameCompletePlugBander">
				<span>挑战成功，您获得第5名</span>
				<img src="http://7xugu1.com1.z0.glb.clouddn.com/banner.png">
			</div>
			
			<div class="gameCompletePlugContent">
				<ul>
					<li>获取得分：50分</li>
					<li>最高分：100分</li>
					<li>击败80%</li>
				</ul>
				
				<ul>
					<li>返回</li>
					<li>继续挑战</li>
				</ul>
				
			</div>
		</div>
</tiles:putAttribute>
</tiles:insertDefinition>
<script type="text/javascript">
	$(document).ready(function(){
		var width = $(".gameCompletePlugHeaderImg>img").width();
		$(".gameCompletePlugHeaderImg>img").height(width);
		
		var width2 = $(".gameCompletePlugLight").width();

		$(".gameCompletePlugLight").height(width2);
		roate();
	});
	
	
	function roate(){
		
		var time=50;
		var index = setInterval(function(){
			time++;
			$(".gameCompletePlugLight").css("transform","rotate("+time+"deg)");
		},100);
	}
</script>

<style type="text/css">

	
	
</style>
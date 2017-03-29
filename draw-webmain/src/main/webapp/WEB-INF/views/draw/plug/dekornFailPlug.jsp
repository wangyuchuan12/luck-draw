<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="plugLayout">
	<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
	<tiles:putAttribute name="body">
		<div class="dekornFailPlug">
		
			<div class="dekornFailPlugThunder">
				
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
				
			<div class="gameCompletePlugBander" style="-webkit-filter: grayscale(100%);">
				<span>挑战失败</span>
				<img src="http://7xugu1.com1.z0.glb.clouddn.com/banner.gif">
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
			
			<script type="text/javascript">
				$(document).ready(function(){
					thund1();
				});
				
				function thund1(){
					
					var time=50;
					var index = 0;
					var flag = false;
					var index = setInterval(function(){
						time++;
						if(time>70){
							time=0;
							index++;
							flag = true;
							if(index%4==0){
								$(".dekornFailPlugThunder").css("background","url('http://7xugu1.com1.z0.glb.clouddn.com/thunder1.png')no-repeat");
							}else if(index%4==1){
								$(".dekornFailPlugThunder").css("background","url('http://7xugu1.com1.z0.glb.clouddn.com/thunder2.png')no-repeat");
								//$(".dekornFailPlugThunder").css("background-position","50px 2px");
							}else if(index%4==2){
								$(".dekornFailPlugThunder").css("background","url('http://7xugu1.com1.z0.glb.clouddn.com/thunder3.png')no-repeat");
								//$(".dekornFailPlugThunder").css("background-position","100px 5px");
							}else if(index%4==3){
								$(".dekornFailPlugThunder").css("background","url('http://7xugu1.com1.z0.glb.clouddn.com/thunder4.png')no-repeat");
								//$(".dekornFailPlugThunder").css("background-position","200px 10px");
							}
						}
						if(flag){
							var alpha = time/70;
							$(".dekornFailPlugThunder").css("background-color","rgba(247,251,254,"+alpha+")");
						}
					},100);
				}
			</script>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
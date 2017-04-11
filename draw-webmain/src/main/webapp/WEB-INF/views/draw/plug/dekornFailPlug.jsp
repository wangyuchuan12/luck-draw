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
				
			<div class="gameCompletePlugBander" style="-webkit-filter: grayscale(100%);">
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
			<div class="invitationPlugButtons">
				<ul>
					<li id="backButton">返回</li>
					<li id="reTakepart">再次挑战</li>
				</ul>
			</div>
			
			<script type="text/javascript">
				$(document).ready(function(){
					thund1();
					
					$("#reTakepart").click(function(){
						window.parent.f_reTakepart();
					});
					
					$("#backButton").click(function(){
						window.parent.f_back();
					});
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
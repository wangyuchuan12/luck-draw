<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="/css/style1.0.css"/>
<link rel="stylesheet" href="/css/core.css"/>

<link rel="stylesheet" href="/css/swiper.min.css"/>

<link rel="stylesheet" href="/css/jquery-ui.min.css"/>

<link rel="stylesheet" href="/font-awesome-4.7.0/css/font-awesome.min.css"/>

<link rel="stylesheet" href="/fakeLoader/css/fakeLoader.css">

<link rel="stylesheet" href="/barrager/dist/css/barrager.css"></link>

<link rel="stylesheet" href="/layer/mobile/need/layer.css"></link>

<script type="text/javascript" src="/js/jquery-2.1.4.min.js"></script>

<!--  <script src="/jquery-validation-1.14.0/lib/jquery.js"></script> -->

<script src="/toolbar/jquery.toolbar.js"></script>


<script type="text/javascript" src="/layer/mobile/layer.js"></script>

<script src="/fakeLoader/js/fakeLoader.min.js"></script>

<script src="/js/myscript1.0.js"></script>

<script src="/js/plug.js"></script>

<script src="/js/jquery-ui.min.js"></script>

<script src="/util/flowJS.js"></script>

<script src="/js/jquery.barrager.js"></script>


<script src="/js/swiper.min.js"></script>

<script src="/js/jquery.lazy.js"></script>

<script src="/js/jq_scroll.js"></script>

<script src="/js/skip.js"></script>

<script src="/js/jump.js"></script>

<script src="/js/jquery.event.swipe.js"></script>

<script src="/js/jquery.tabso_yeso.js"></script>

<script src="/raty/jquery.raty.js"></script>

<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>

<input name="rightOptionId"  type="hidden" value="${question.rightOptionId}"/>

<input name="id"  type="hidden" value="${question.id}"/>

		<div class="subjectContainer" id="subjectContainer">
			<div class="subjectHeader" id="subjectHeader">
				<!--  	<div class="subjectHeaderContent" id="subjectHeaderContent">射雕英雄传是什么时候拍的</div> -->
					
			  	<div class="subjectHeaderImg" id="subjectHeaderImg">
					<img src="${question.imgUrl}">
					
					<div class="subjectHeaderImgQuestion">${question.question}</div>
				</div>
				
			</div>
			
			<div class="subjectTool" id="subjectTool">4选1</div>
			
			<div class="subjectOption" id="subjectOption">
				<ul>
					<c:forEach items="${questionOptions}" var="option">
						<li id="${option.id}" onclick="checkOption('${option.id}')">${option.content}</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<script type="text/javascript">
		
		
			var flag = false;
			function checkOption(checkOptionId){

					if(!flag){
						var rightOptionId = $("input[name=rightOptionId]").val();
						var isRight = 0;
						if(rightOptionId==checkOptionId){
							$("#"+checkOptionId).css("background","green");
							isRight = 1;
						}else{
							$("#"+checkOptionId).css("background","red");
							$("#"+rightOptionId).css("background","green");
							isRight = 0;
						}
						
						var id = $("input[name=id]").val();
						window.parent.checkOption(id,checkOptionId,isRight);
						
						flag = true;
					}
					
			}
			
			$(document).ready(function(){
				
				var callback = new Object();
				callback.complete = function(){
				}
				
				
				
			});
		</script>


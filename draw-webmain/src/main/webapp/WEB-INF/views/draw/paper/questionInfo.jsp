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

<link rel="stylesheet" href="/ystep/css/ystep.css"></link>



<script type="text/javascript" src="/js/jquery-2.1.4.min.js"></script>

<script type="text/javascript" src="/ystep/js/ystep.js"></script>

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

<input name="timeLong"  type="hidden" value="20"/>

<input name="index"  type="hidden" value="${index}"/>

<input name="id"  type="hidden" value="${question.id}"/>

<input name="count" type="hidden" value="${count}"/>

		<div class="subjectContainer" id="subjectContainer">
			<div>
				<div class="subjectHeader" id="subjectHeader">
					<!--  	<div class="subjectHeaderContent" id="subjectHeaderContent">射雕英雄传是什么时候拍的</div> -->
						
				  	<div class="subjectHeaderImg" id="subjectHeaderImg">
						<img src="${question.imgUrl}">
						
						<div class="subjectHeaderImgQuestion">${question.question}</div>
						
						<div id="progressbar" style="width:90%;height:10px;margin:0 auto;position: relative;">
							<div class="progress-label" id="progressLabel">加载...</div>
						</div>
					</div>
					
				</div>
			
				<div class="subjectTool" id="subjectTool">
					<div class="ystep1"></div>
					
				</div>
			
				<div class="subjectOption" id="subjectOption">
					<ul>
						<c:forEach items="${questionOptions}" var="option">
							<li id="${option.id}" onclick="checkOption('${option.id}',0)">${option.content}</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		
		
		 <style type="text/css">
	     	.ui-progressbar{
	     		position:relative;
	     		
	     		top:5px;
	     	}
	     	
	     	.progress-label{
	     		position: absolute;
	     		left:47%;
	     		font-weight: bold;
	     		/*text-shadow: 1px 1px 0 #fff;*/
	     		height: 10px;
	     		font-size: 10px;
	     		top:-3px;
	     	}
	     	
	     	#progressbar .ui-corner-left{
	     		background: green;
	     		height: 15px;
	     	}
		</style>
		<script type="text/javascript">
		
		
			var flag = false;
			var interval;
			var overTimeLong = 0;
			function checkOption(checkOptionId,isTimeout){

					clearInterval(interval);
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
						window.parent.checkOption(id,checkOptionId,isRight,overTimeLong,isTimeout);
						
						flag = true;
					}
					
			}
			
			$(document).ready(function(){
				
				var steps = new Array();
				var count = $("input[name=count]").val();
				for(var i = 0;i<count;i++){
					var object = new Object();
					object.title = "第"+(i+1)+"题";
					object.content = "";
					steps.push(object);
				}
				$(".ystep1").loadStep({
					size:"large",
					color:"green",
					steps:steps
				});
				
				
				var index = $("input[name=index]").val();
				
				index = parseInt(index);
				
				index=index+1;
				
				$(".ystep1").setStep(index);
				
				
				$(".subjectTool").scrollLeft($(".ystep1 li").eq(index-1).position().left-$(".subjectTool").width()/1.7);
				
				var progressbar = $("#progressbar");
				var progressLabel = $("#progressLabel");
				
				var beginDate = new Date();
				
				var flag = 0;
				
				interval = setInterval(function(){
					progress();
				},10);
				
				progressbar.progressbar({
					value:false,
					change:function(){
						var timeLong = $("input[name=timeLong]").val();
						progressLabel.text(timeLong-parseInt(overTimeLong)+"s");
					},
					complete:function(){
						clearInterval(interval);
						if(flag == 0){
							checkOption(null,1);
						}
						flag = 1;
					}
				});
				
				function progress(){
					var nowDate = new Date();
					var timeDiff = nowDate.getTime()-beginDate.getTime();
					overTimeLong = timeDiff/1000;
					var timeLong = $("input[name=timeLong]").val();
					
					var percent = (overTimeLong/timeLong)*100;
					
					progressbar.progressbar("value",percent);
				}
				
				
				
				
				var callback = new Object();
				callback.complete = function(){
				}
			});
		</script>


<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="resourceLayout">
<tiles:putAttribute name="title">设置问题</tiles:putAttribute>
<tiles:putAttribute name="body">
	
	
	<div class="vie_problem_question_list">
		<ul>
			<c:forEach items="${problems}" var="item">
			
					<li>
							<input name="problemId" value="${item.id}" seq="${item.seq}" type="hidden"/>
							<div class="vie_problem">
								<div class="view_problem_title">第${item.seq}/${count}题</div>
							</div>
					
							<div class="vie_problem_question">
								<div class="vie_problem_question_textarea">
									<textarea rows="" cols="" placeholder="请输入内容" name="question" readonly="readonly">${item.question}</textarea>
								</div>
							</div>
							
							<div class="progress_bar" seq="${item.seq}">
								<div class="progress_bar_grap" seq="${item.seq}"></div>
								<div class="progress_bar_second">20s</div>
							</div>
							
							
							
							<div class="vie_problem_answer" id="vie_problem_answer">
							
							
								<ul >
								
									<c:forEach items="${item.vieRedPacketOptionVos}" var="option" varStatus="varStatus">
										<li onclick="submitAnswer(0,'${item.id}','${option.id}');">
											<c:if test="${varStatus.index==0}">
													<span>A</span>
												</c:if>
												
												<c:if test="${varStatus.index==1}">
													<span>B</span>
												</c:if>
												
												<c:if test="${varStatus.index==2}">
													<span>C</span>
												</c:if>
												
												<c:if test="${varStatus.index==3}">
													<span>D</span>
												</c:if>
												
												<c:if test="${varStatus.index==4}">
													<span>E</span>
												</c:if>
												
												<c:if test="${varStatus.index==5}">
													<span>F</span>
												</c:if>
												
												<c:if test="${varStatus.index==6}">
													<span>G</span>
												</c:if>
												
												<c:if test="${varStatus.index==7}">
													<span>H</span>
												</c:if>
												
												<c:if test="${varStatus.index==8}">
													<span>I</span>
												</c:if>
												
												<c:if test="${varStatus.index==9}">
													<span>J</span>
												</c:if>
												
												<c:if test="${varStatus.index==10}">
													<span>K</span>
												</c:if>
												
												<c:if test="${varStatus.index==11}">
													<span>L</span>
												</c:if>
												
												<c:if test="${varStatus.index==12}">
													<span>M</span>
												</c:if>
											<textarea rows="3" readonly="readonly">${option.content}</textarea>
										</li>
									</c:forEach>
								</ul>
							</div>
					</li>
			
			
			</c:forEach>
			
		</ul>
		
	
	</div>
	
	<input name="count" value="${count}" type="hidden">

	<input name="memberId" value="${memberId}" type="hidden">
	<input name="redPacketId" value="${redPacketId}" type="hidden">	
	
	<input name="currentSeq" value="${currentSeq}" type="hidden"/>
	<script type="text/javascript">
	
		var secondNum;
		var interval;
		var seq = 0;
		var interval;
		var count;
		var second=20;
		var timeLong;
		function nextWindow(second){
			var width = $(".vie_problem_question_list").width();
			var scrollLeft = $(".vie_problem_question_list").scrollLeft();
			
			$(".vie_problem_question_list").animate({
				scrollLeft:width+scrollLeft
			},500,function(){
				if(secondNum==0){
					
				}
				
			});
		}
		
		function submitAnswer(isTimeout,problemId,optionId){
			stop();
			showLoading();
			var memberId = $("input[name=memberId]").val();
			var params = new Object();
			params.option_id=optionId;
			params.problem_id=problemId;
			params.member_id = memberId;
			params.is_timeout=isTimeout;
			params.time_long=timeLong;
			var url = "/api/vie/draw/vie_red_pack/select_option";
			
			var callback = new Object();
			
			
			callback.success = function(resp){
				hideLoading();
				if(!resp.success){
					alert(resp.errorMsg);
					showToast("网络繁忙，请稍后再试😁");
				}else{
					var isLast = resp.data.isLast;
					if(isLast==1){
						var redPacketId = $("input[name=redPacketId]").val();
						skipToVieDrawInfo(redPacketId)
					}else{
						
						nextWindow(20);
						nextTab(20);
					}
				}
			}
			callback.failure = function(){
				showToast("网络繁忙，请稍后再试😁");
			}
			request(url,callback,params)
		}
		
		function stop(){
			
			
			$(".vie_problem_question_list").stop();
			$(".progress_bar_grap[seq="+seq+"]").stop(true);
			
			if(interval){
				clearInterval(interval);
			}
			
		}
		
		function nextTab(second){
			
			var beforeDate = new Date();
			var beforeTime = beforeDate.getTime();
			$(".progress_bar_grap").css("width","");
			$(".progress_bar_second").text(second+"s");
			timeLong=0;
			seq++;

			var time = second*1000;
			secondNum = second;
			interval = setInterval(function(){
				var currentDate = new Date();
				var currentTime = currentDate.getTime();
				
				var diffSecond = (currentTime-beforeTime)/1000;
			
				var secondNum = second-diffSecond;
				
				var secondNum = parseInt(secondNum);
				
				if(secondNum>=0){
					timeLong = parseInt(diffSecond);
					
					$(".progress_bar_second").text(secondNum+"s");
				}else{
					
				}
			},500);
			$(".progress_bar_grap[seq="+seq+"]").animate({
				"width":"0"
			},time,function(){
				clearInterval(interval);
				
				setTimeout(function(){
					var problemId = $("input[seq="+seq+"]").val();
					submitAnswer(1,problemId);
				},50);
				
			});
		}
		$(document).ready(function(){
			count = $("input[name=count]").val();
			nextTab(20);
			$("body").css("background-color","white");
			
			
		});
		
	</script>
			
</tiles:putAttribute>
</tiles:insertDefinition>

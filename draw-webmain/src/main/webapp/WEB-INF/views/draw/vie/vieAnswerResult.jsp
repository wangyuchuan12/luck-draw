<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="frameLayout">
<tiles:putAttribute name="title">答题结果</tiles:putAttribute>
<tiles:putAttribute name="body">
	
	<div class="vie_answer_result">
		<ul>
			<c:forEach items="${vieProblemAnswers}" var="vieProblemAnswer">
				<li>
				<div class="vie_answer_result_title">第${vieProblemAnswer.seq}题</div>
				<div class="vie_answer_result_question">问：${vieProblemAnswer.question}</div>
				<div class="vie_answer_result_select">
					选项：
					<div class="vie_answer_result_select_option">
					
						<c:forEach items="${vieProblemAnswer.vieRedPacketOptionVos}" var="option">
							A.${option.content} <c:if test="${option.isRight==1}">✅</c:if><br/>
						</c:forEach>
					</div>
				</div>
				
				<div class="vie_answer_result_my_answer">我的答案：${vieProblemAnswer.myOption.content} 
					<c:if test="${vieProblemAnswer.myOption.isRight==1}">✅</c:if>
					<c:if test="${vieProblemAnswer.myOption.isRight==0}">❌</c:if>
				</div>
				<div class="vie_answer_result_timelong">用时：${vieProblemAnswer.timelong}s</div>
			</li>
			</c:forEach>
			
			
			
		</ul>
	</div>
	
	

	<script type="text/javascript">
	
		
		
	</script>
			
</tiles:putAttribute>
</tiles:insertDefinition>

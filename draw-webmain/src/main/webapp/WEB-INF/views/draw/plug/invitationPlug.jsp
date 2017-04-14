<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="plugLayout">
	<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
	<tiles:putAttribute name="body">
	
		<input type="hidden" name="wisdomNum" value="${wisdomNum}"/>
		<input type="hidden" name="title" value="${title}"/>
		<input type="hidden" name="titl2" value="${title2}"/>
		
		<input type="hidden" name="id" value="${id}"/>
		
		<script type="text/javascript">
		
			 function initView(){
				 $("#title").text($("input[name=title]").val());
				 $("#title2").text($("input[name=title2]").val());
				 var wisdomNum = $("input[name=wisdomNum]").val();
				 
				 $("#wisdom").text("智慧豆："+wisdomNum+"颗");
				 
				 $("#wisdomContent").text("点击接受领取智慧豆");
			 }
			 $(document).ready(function(){
				 initView();
		     });
		</script>
		<div class="invitationPlug">
			<div class="invitationPlugHead" id="title">邀请你摆个擂台</div>
			<div class="invitationPlugHead2" id="title2">恭喜您，您的成绩非常优秀，点击接受，你就能够接受他人的挑战</div>
			<div class="invitationPlugContent">
				<ul>
					<li>
						<div class="invitationPlugContentImg invitationWisdon">
						</div>
						<div class="invitationPlugContentDetail">
							<div class="invitationPlugContentDetailTitle" id="wisdom">智慧豆：50颗</div>
							<div class="invitationPlugContentDetailInstruction" id="wisdomContent">挑战完成的时候就能获得50颗智慧豆啦</div>
						</div>
					</li>
				</ul>
			
			</div>
			
			
			<div class="invitationPlugButtons">
				<ul>
					<li id="rejectButton">拒绝</li>
					<li id="argeeButton">接受</li>
				</ul>
			</div>
		</div>
		
		<script type="text/javascript">
				$(document).ready(function(){
					var id = $("input[name=id]").val();
					$("#rejectButton").click(function(){
						window.parent.i_rejectButton(id);
					});
					
					$("#argeeButton").click(function(){
						window.parent.i_agreeButton(id);
					});
				});
		</script>
	</tiles:putAttribute>
</tiles:insertDefinition>
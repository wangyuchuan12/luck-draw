<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="resourceLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
<tiles:putAttribute name="body">

	<input type="hidden" name="redPackType" value="${redPackType}"/>
	<input type="hidden" name="isDisplayRoom" value="${isDisplayRoom}"/>
	<input type="hidden" name="isDisplayType" value="${isDisplayType}"/>
	<input type="hidden" name="roomId" value="${roomId}"/>
	<input type="hidden" name="isRoom" value="${isRoom}"/>
	<div class="subject_check_header">
		<div class="subject_check_header_title">请选择红包的科目类型</div>
	</div>
	
	<div class="subject_check_items">
		<ul>
			
			<c:forEach items="${subjects}" var="subject">
				<li style="border: 1px solid ${subject.color};color:${subject.color}" onclick="clickSubject('${subject.isLeaf}','${subject.id}')">${subject.name}</li>
			</c:forEach>
			
		</ul>
	</div>
	
	<!--  <div class="subject_check_button">选好了，下一步<span>→</span></div> -->
	
	<script type="text/javascript">
	
		function clickSubject(isLeaf,id){
			var redPackType = $("input[name=redPackType]").val();
			var isDisplayRoom = $("input[name=isDisplayRoom]").val();
			var isDisplayType = $("input[name=isDisplayType]").val();
			var isRoom = $("input[name=isRoom]").val();
			var roomId = $("input[name=roomId]").val();
			if(isLeaf=="0"){
				skipToSubject(id,redPackType,isDisplayRoom,isDisplayType,roomId,isRoom);
			
			}else if(isLeaf=="1"){
				if(redPackType=="0"){
					
					skipToAddRedPack(isRoom,isDisplayRoom,isDisplayType,id,roomId);
				}else if(redPackType=="1"){
					skipToAddVieDrawInfo(isRoom,isDisplayRoom,isDisplayType,id,roomId);
				}
				
			}
		}
		$(document).ready(function(){
			hideProgress();
		});
		
	</script>
</tiles:putAttribute>
</tiles:insertDefinition>

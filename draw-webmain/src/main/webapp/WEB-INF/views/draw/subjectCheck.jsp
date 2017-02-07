<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="resourceLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
<tiles:putAttribute name="body">

	<input name="redPackType" value="${redPackType}"/>
	<input name="isDisplayRoom" value="${isDisplayRoom}"/>
	<input name="isDisplayType" value="${isDisplayType}"/>
	<input name="roomId" value="${roomId}"/>
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
			var roomId = $("input[name=roomId]").val();
			if(isLeaf=="0"){
				skipToSubject(id,redPackType,isDisplayRoom,isDisplayType,roomId);
			
			}else if(isLeaf=="1"){
				if(redPackType=="0"||redPackType=="1"){
					
					skipToAddRedPack(redPackType,isDisplayRoom,isDisplayType,id,roomId);
				}else if(redPackType=="2"||redPackType=="3"){
					skipToAddVieDrawInfo(redPackType,isDisplayRoom,isDisplayType,id,roomId);
				}
				
			}
		}
		$(document).ready(function(){
			
			
		});
		
	</script>
</tiles:putAttribute>
</tiles:insertDefinition>

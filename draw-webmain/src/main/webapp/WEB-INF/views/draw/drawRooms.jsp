<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="frameLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
<tiles:putAttribute name="body">
	<div class="luck_rooms">
		<ul>
			<c:forEach items="${roomListVo.drawRoomInfos}" var="roomInfo">
			
				<li onclick="skipToRoomInfo('${roomInfo.id}')">
					<div class="luck_rooms_img">
						<img src="${roomInfo.imgUrl}"></img>
					</div>
					
					<div class="luck_rooms_footer">
					
						<div class="luck_rooms_footer_content">
						
							<div class="luck_rooms_footer_content_img">
								<img src="${roomInfo.createrHeadImg}">
							</div>
							<div class="luck_rooms_footer_content_detail">
								<div class="luck_rooms_footer_content_detail_title">${roomInfo.name}</div>
								<div class="luck_rooms_footer_content_detail_num">已参加${roomInfo.memberCount}人</div>
								<c:if test="${roomInfo.maxRedPacketAmount!=null}">
								<div class="luck_rooms_footer_content_detail_money">最大红包${roomInfo.maxRedPacketAmount}元</div>
								</c:if>
							</div>
						</div>
					</div>
				</li>
			</c:forEach>
		</ul>
	
	</div>
			
			
</tiles:putAttribute>
</tiles:insertDefinition>

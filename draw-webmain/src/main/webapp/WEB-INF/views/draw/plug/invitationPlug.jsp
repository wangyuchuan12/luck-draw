<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="plugLayout">
	<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
	<tiles:putAttribute name="body">
		<div class="invitationPlug">
			<div class="invitationPlugHead">邀请你摆个擂台</div>
			<div class="invitationPlugHead2">摆擂台之后，你就能够接受他人的挑战</div>
			<div class="invitationPlugContent">
				<ul>
					<li>
						<div class="invitationPlugContentImg invitationWisdon">
						</div>
						<div class="invitationPlugContentDetail">
							<div class="invitationPlugContentDetailTitle">智慧豆：50颗</div>
							<div class="invitationPlugContentDetailInstruction">挑战完成的时候就能获得50颗智慧豆啦</div>
						</div>
					</li>
				</ul>
			
			</div>
			
			
			<div class="invitationPlugButtons">
				<ul>
					<li>拒绝</li>
					<li>接受</li>
				</ul>
			</div>
			
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
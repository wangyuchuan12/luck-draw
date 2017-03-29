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
			<div class="invitationPlugHead">邀请函</div>
			<div class="invitationPlugScore">29分</div>
			<div class="invitationPlugContent">是否愿意接受他人挑战</div>
			<div class="invitationPlugReward">
				<div class="invitationPlugRewardType">
					<div class="invitationPlugRewardTypeTitle">立刻领取奖励</div>
					<ul>
						<li>
							<span>智慧豆：</span>
							<span>200</span>
						</li>
						
						<li>
							<span>经验值：</span>
							<span>200</span>
						</li>
						
						<li>
							<span>爱心：</span>
							<span>200</span>
						</li>
						
						<li>
							<span>金币：</span>
							<span>200</span>
						</li>
					</ul>
				</div>
				
				
				<div class="invitationPlugRewardType">
					<div class="invitationPlugRewardTypeTitle">他人挑战奖励</div>
					<ul>
						<li>
							<span>智慧豆：</span>
							<span>0</span>
						</li>
						
						<li>
							<span>经验值：</span>
							<span>0</span>
						</li>
						
						<li>
							<span>爱心：</span>
							<span>200</span>
						</li>
						
						<li>
							<span>金币：</span>
							<span>200</span>
						</li>
					</ul>
				</div>
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
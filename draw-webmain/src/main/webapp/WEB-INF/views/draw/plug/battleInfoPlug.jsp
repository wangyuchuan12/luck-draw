<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="battleInfo">
	<div id="passFlag" class="passFlag" style="display: none;">
		<img src="http://on3s1z2us.bkt.clouddn.com/pass.png">
	</div>
	
	<div id="unpassFlag" class="passFlag" style="display: none;">
		<img src="http://on3s1z2us.bkt.clouddn.com/unpass.png">
	</div>
	<div class="battleInfoTitle">第<span id="battleInfoBannerRound">五</span>关</div>
	<div class="battleInfoBanner">
		目标：<span id="battleInfoBannerScore">0</span>分
	</div>
	
	<img src="" class="battleInfoDetailImg" id="battleInfoDetailImg">
	<div class="battleInfoDetailName" id="battleInfoDetailName"></div>
	
	
	<div class="red_packet_comment_star_img" id="accordStar"></div>

	
	 
	<div class="battleInfoContent">
		<ul>
		<!--  
			
			
			<li>
				<div class="battleInfoContentTitle">总得分</div>
				<div class="battleInfoContentInput">
					<span class="battleInfoContentInputSportsIcon"></span>
					<span class="battleInfoContentInputText" id="allScore"></span>
				</div>
			</li>
			
			<li>
				<div class="battleInfoContentTitle">智慧豆</div>
				<div class="battleInfoContentInput">
					<span class="battleInfoContentInputBeanIcon"></span>
					<span class="battleInfoContentInputText" id="beanNum"></span>
				</div>
			</li>
		-->
		
			<li id="battleInfoRound">
				<div class="battleInfoContentTitle" id="round"></div>
				<div class="battleInfoContentInput">
					<span class="battleInfoContentInputSportsIcon"></span>
					<span class="battleInfoContentInputText" id="thisScore"></span>
				</div>
			</li>
		
			<li>
				<div class="battleInfoContentTitle">总得分</div>
				<div class="battleInfoContentInput">
					<span class="battleInfoContentInputSportsIcon"></span>
					<span class="battleInfoContentInputText" id="allScore"></span>
				</div>
			</li>
		
			<li>
				<div class="battleInfoContentTitle">排名</div>
				<div class="battleInfoContentInput">
					<span class="battleInfoContentInputRankIcon"></span>
					<span class="battleInfoContentInputText" id="rank"></span>
				</div>
			</li>
			
			
			
			<li id="battleInfoLove">
				<div class="battleInfoContentTitle">剩余爱心</div>
				<div class="battleInfoContentInput" id="loves">
				</div>
			</li>
		</ul>
	</div>
	
	
	<div class="mainViewButtons" style="margin-top:0px;">
		<div class="mainViewDekornButton" style="display: inline-block;" id="lastButton">上一关</div>
		<div class="mainViewDekornButton" style="display: inline-block;" id="showResult">查看答题</div>
		<div class="mainViewDekornButton" style="display: inline-block;" id="dekornButton">挑战</div>
		<div class="mainViewDekornButton" style="display: inline-block;" id="reDekornButton">重新挑战</div>
		<div class="mainViewDekornButton" style="display: inline-block;" id="nextButton">下一关</div>
	</div>
	
	<!--  
	<div class="battleInfoReward">
		<div class="battleInfoRewardContent">
			<ul>
				<li>
					<div class="battleInfoRewardContentScore">5分</div>
					<div class="battleInfoRewardContentImg" style="background: url('http://7xugu1.com1.z0.glb.clouddn.com/lifeLoveSolid.png');background-size:100% 100%;background-color:RGBA(44,147,232,1);">454</div>
					<div style="width:100%;text-align: center;">第1题</div>
				</li>
				
				<li>
					<div class="battleInfoRewardContentScore">3分</div>
					<div class="battleInfoRewardContentImg gray" style="background: url('/imgs/plug/bean.png');background-size:100% 100%;background-color:RGBA(231,93,247,1);">454</div>
					<div style="width:100%;text-align: center;">第2题</div>
				</li>
				
				<li>
					<div class="battleInfoRewardContentScore">3分</div>
					<div class="battleInfoRewardContentImg gray" style="background: url('/imgs/plug/bean.png');background-size:100% 100%;background-color:RGBA(231,93,247,1);">454</div>
					<div style="width:100%;text-align: center;">第2题</div>
				</li>
			</ul>
		</div>
	</div>
	-->
</div>
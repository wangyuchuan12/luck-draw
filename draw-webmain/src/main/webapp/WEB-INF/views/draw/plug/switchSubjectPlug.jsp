<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>

<tiles:insertDefinition name="plugLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
<tiles:putAttribute name="body">
		<input name ="handDrawUserImg" value="${handDrawUserImg}" type="hidden"/>
		<input name ="passScore" value="${passScore}" type="hidden"/>
		<input name ="handDrawUserImg" value="${handDrawUserImg}" type="hidden"/>
		<input name ="handDrawUserName" value="${handDrawUserName}" type="hidden"/>
		<input name ="acceptFightSuccessWisdomNum" value="${acceptFightSuccessWisdomNum}" type="hidden"/>
		<input name ="gameName" value="${gameName}" type="hidden"/>
		
		<input name="myNickname" value="${myNickname}" type="hidden"/>
		<input name="myImgUrl" value="${myImgUrl}" type="hidden"/>
		
		<input name="fightSuccessWisdomNum" value="${fightSuccessWisdomNum}" type="hidden"/>
			
		<div class="switchSubjectPlug">
		
			 <div class="switchSubjectPlugName">挑战项目：小鸟飞飞</div>
			 <div class="switchSubjectPlugTitle">挑战分数：100次</div>
			 
			 <div class="switchSubjectPlugPlayers" >
			 	<div class="switchSubjectPlugPlayer" style="left:5%;" id="handDrawUser">
			 		<img src="http://wx.qlogo.cn/mmopen/8t8etdDXwrDvPykbY7HSFbvwhgQSeEUugmwibCsicASzPnsIchkjmU4ibM8OnLnarrI54cuicSbIZBP7RlEdDvOpD2EghMkicStQT/0">
			 		<span id="handDrawUserName">川川无敌飞车手</span>
			 		<div class="switchSubjectPlugPlayerDialog" style="display: none;">你是谁呀，我叫王煜川，初中一班学生哈哈</div>
			 	</div>
			 	
			 	<div class="switchSubjectPlugPlayer" style="right: 5%;" id="myDrawUser">
			 		<img src="http://wx.qlogo.cn/mmopen/8t8etdDXwrDvPykbY7HSFbvwhgQSeEUugmwibCsicASzPnsIchkjmU4ibM8OnLnarrI54cuicSbIZBP7RlEdDvOpD2EghMkicStQT/0">
			 		<span id="myNickname">大卫</span>
			 	</div>
			 </div>
			 
			 <div class="switchSubjectPlugReward">
			 	<div class="switchSubjectPlugRewardContent">
			 		<div class="switchSubjectPlugRewardContentTitle">胜利奖励</div>
			 		<ul>
			 			<li>
			 			<!--  	<img src="/imgs/plug/bean.png"> -->
			 				<div class="personalAttrDataHeader personalAttrDataHeaderBean"></div><span id="fightSuccessWisdomNum">200</span>
			 			</li>
			
						
			 		</ul>
			 	</div>
			 </div>
			 
			 <div class="switchSubjectPlugBtns">
			 	<ul>
			 		<li id="backBtn">关闭</li>
			 		<li id="switchBtn">换一个</li>
			 		<li id="startBtn">开始挑战</li>
			 	</ul>
			 </div>
		</div>

</body>

<script type="text/javascript">
	function initView(){
		var passScore = $("input[name=passScore]").val();
		$(".switchSubjectPlugTitle").text("挑战分数："+passScore+"分");
		var handDrawUserImg = $("input[name=handDrawUserImg]").val();
		$("#handDrawUser>img").attr("src",handDrawUserImg);
		
		var handDrawUserName = $("input[name=handDrawUserName]").val();
		$("#handDrawUserName").text(handDrawUserName);
		
		var myImgUrl = $("input[name=myImgUrl]").val();
		$("#myDrawUser>img").attr("src",myImgUrl);
		
		var myNickname = $("input[name=myNickname]").val();
		$("#myNickname").text(myNickname);
		
		var gameName= $("input[name=gameName]").val();
		
		$(".switchSubjectPlugName").text(gameName);
		
		var fightSuccessWisdomNum = $("input[name=fightSuccessWisdomNum]").val();
		$("#fightSuccessWisdomNum").text(fightSuccessWisdomNum);
	}
	
	function addListener(){
		$("#startBtn").click(function(){
			window.parent.s_start();
		});
		
		$("#switchBtn").click(function(){
			window.parent.s_switch();
		});
		
		$("#backBtn").click(function(){
			window.parent.s_back();
		});
	}
	
	$(document).ready(function(){
		initView();
		addListener();
	});
</script>
<style>

	
</style>
</tiles:putAttribute>
</tiles:insertDefinition>
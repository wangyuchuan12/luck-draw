<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="resourceLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
<tiles:putAttribute name="body">
			<iframe src="" name="left" width="100%" height="100%"></iframe>
			
			<a href="/games/horsegame/index.html" target="left">打开</a>
			<input name = "gameUrl" value="${dekornInfo.gameUrl}" type="hidden"/>
			<input name = "id" value="${dekornInfo.id}" type="hidden"/>

			<div id="gameRedPacketContainer">
				<div id="game" showModel="layer" hideModel="move" destroy="destroy" animateTimeLong="1000" url="/games/znm123/index.html" style="background-color: black;"></div>
				
		
				<div id="gameCompltePlug" showModel="layer" hideModel="move" destroy="destroy" animateTimeLong="1000" url="/view/draw/personal_center/main" style="background-color: black;"></div>
			</div>
			
			<!--  <div class="gameRedPacketImgHeader">
				<img src="http://wx.qlogo.cn/mmopen/GAhcxvIicouFrv7HICbIPicibmBIwhetmJJibYAaVr0SFhIDIBl9ESo0G1mUJBt6ia1YOZZxEndx7X1NDZLmQC2ELCMcdqvbkevCz/0">
				<div class="gameRedPacketImgHeaderName">小鸟飞飞</div>
				<div class="gameRedPacketImgHeaderNickname">川川 · 2015-7-13 22 : 23 : 21创建</div>
				<div class="gameRedPacketImgHeaderScore">挑战分数：50分</div>
			</div>
			
			<div class="gameRedPacketTab">
				<ul>
					<li style="border-bottom: 1px solid RGBA(157,99,80,1);color:RGBA(157,99,80,1);">排行榜</li>
					<li>评论</li>
					<li>帮助</li>
				</ul>
			</div> 
			-->
			
			
			<div class="gameRedPacketFooter">开始挑战</div>
			
			<script type="text/javascript">
				var actionMapper;
				function gameOver(num){
					actionMapper.hideAnimateById("game");
					actionMapper.show("gameCompltePlug");
				}
				
				
				function submitScroll
				
				function takepart(){
					var id = $("input[name=id]").val();
					var url = "/api/dekorn/takepart";
					var callback = new Object();
					callback.success = function(resp){
						if(resp.success){
							alert("success");
							actionMapper.show("game");
						}else{
							alert(resp.errorMsg);
						}
					}
					callback.failure = function(){
						alert("failure");
					}
					var params = new Object();
					params.id = id;
					request(url,callback,params);
				}
				
				$(document).ready(function(){
					actionMapper = new ActionMapper("#gameRedPacketContainer");
					actionMapper.paraseEntities();
					
					$("#game").attr("url",$("input[name=gameUrl]").val());
					$("body").css("width","100%");
					$("body").css("background-color","white");
					
					$(".gameRedPacketFooter").click(function(){
						 takepart();
					});
				});
			</script>
			
</tiles:putAttribute>
</tiles:insertDefinition>



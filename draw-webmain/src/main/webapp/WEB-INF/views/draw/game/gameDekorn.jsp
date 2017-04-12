<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>

<tiles:insertDefinition name="resourceLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
<tiles:putAttribute name="body">
			
			<input name="id" value="${dekornInfo.id}" type="hidden"/>
			<input name="gameCode" value="${gameCode}" type="hidden"/>
			<input name="passScore" value="${passScore}" type="hidden"/>
			<div class="gameRedPacketImgHeader">
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
	
			
			
			<div class="gameRedPacketFooter" id="startButton">开始挑战</div>
			
			<script type="text/javascript">
				var actionMapper;
				function gameOver(num){
					actionMapper.hideAnimateById("game");
					actionMapper.show("gameCompltePlug");
				}
				
				function initView(){
					var takepartStatus = $("input[name=takepartStatus]").val();
					if(takepartStatus==0){
						actionMapper.show("switchSubjectPlug");
					}
				}
				
				
				function submitScore(score){
					
				}
				
				function takepart(){
					var id = $("input[name=id]").val();
					var url = "/api/dekorn/takepart";
					var gameCode = $("input[name=gameCode]").val();
					var callback = new Object();
					var passScore = $("input[name=passScore]").val();
					callback.success = function(resp){
						if(resp.success){
							var takepartMemberId = resp.data.id;
							skipToGame(gameCode,id,1,passScore,takepartMemberId);
						}else{
							alert(resp.errorMsg);
						}
					}
					callback.failure = function(resp){
						alert(resp.errorMsg);
					}
					var params = new Object();
					params.id = id;
					request(url,callback,params);
				}
				
				function s_start(){
					takepart();
				}
				
				function s_switch(){
					alert("switch");
				}
				
				var switchSubjectPlug;
				function s_back(){
					layer.close(switchSubjectPlug);
				}
				
				$(document).ready(function(){
					$("#startButton").click(function(){
						takepart();
					});
					var id = $("input[name=id]").val();
					switchSubjectPlug = layer.open({
						title:false,
	    				type:2,
	    				area:["80%","70%"],
	    				shade:[0.1,'#000',true],
	    				skin:"plugclass",
	    				content:["/view/dekornHandle/switchSubjectPlug?id="+id+"&modeView=large"],
	    				fadeIn:1000,
	    				shift:10,
	    				closeBtn:0
					});
				});
			</script>
			
</tiles:putAttribute>
</tiles:insertDefinition>



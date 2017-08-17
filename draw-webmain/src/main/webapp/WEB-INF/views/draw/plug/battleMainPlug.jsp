<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>

		<div class="mainView">
			<div class="mainViewDekorn">
				<ul>
					<li>
						<!--  <div class='mainViewCover'>
							<img src='http://oqcfht5ij.bkt.clouddn.com/baby.jpg'/>
						</div>
					
						<div class="mainViewButtons">
							<div class="mainViewDekornButton" style="display: inline-block;" id="mainViewDekornButton">挑战</div>
						</div>
						-->
						
						 
						<div class="mainViewDekornInfo">
							<div class="mainViewDekornImg">
								<img id="battleInfoImg" src="http://ooe8ianrr.bkt.clouddn.com/znm123.png">
							</div>
							<div class="mainViewDekornInfoDetail">
								<div style="font-size: 15px;"><span id="battleInfoName">小鸟飞飞</span></div>
								<div>
									<span>简介：</span>
									<span id="battleInfoInstruction">
										
									</span>
								</div>						
							</div>
						</div>
					
					
					<!--  
					<div class="mainViewMembersPk">
						<div class="mainViewMembersPkMember flipx">
							<img src="http://on3s1z2us.bkt.clouddn.com/6ad30a4b5ef267024789846e8d766e02.png"/>
							<div class="mainViewMemberPkImg"></div>
						</div>
						<div class="mainViewMembersPkIcon"><img src="/imgs/plug/vs.png"></div>
						<div class="mainViewMembersPkMember">
							<img src="http://on3s1z2us.bkt.clouddn.com/6ad30a4b5ef267024789846e8d766e02.png"/>
							<div class="mainViewMemberPkImg"></div>
						</div>
					</div>	
					-->
					
					<div class="mainViewMembers">
						<ul>
							<!-- 
							<li style="text-align: center;">
								<div class="mainViewMembersPkMember flipx">
									<div class="mainViewMemberPkImg"></div>
								</div>

								<div style="width:100%;">
									<div style="display: inline-block;width:20px;height: 15px;background: red;color:white;width:25%;vertical-align: top;border-radius:5px;">得分</div>
									<div id="mainViewMemberProgress" style="width:60%;height:15px;margin:0 auto;position:relative;border-radius:20px;display:inline-block;top: 0px;vertical-align:middle;background-color:RGBA(139,76,32,1)">
										<div class="mainViewMemberProgressLabel" id="progressLabel2" style="color:RGBA(255,237,109,1);padding-top: 0px;font-size: 10px;">0</div>
									</div>
								</div>
								
								<div style="width:100%;position: relative;padding-top:5px;">
									<div style="display: inline-block;width:20px;height: 15px;background: red;color:white;width:25%;vertical-align: top;border-radius:5px;">进度</div>
									<div id="mainViewMemberProgress2" style="width:60%;height:15px;margin:0 auto;position:relative;border-radius:20px;display:inline-block;top: 0px;vertical-align:middle;background-color:RGBA(139,76,32,1)">
										<div class="mainViewMemberProgressLabel" id="progressLabel2" style="color:RGBA(255,237,109,1);padding-top: 0px;font-size: 10px;">0</div>
									</div>
								</div>
							</li>
							 -->
							
						</ul>
					</div>
					
					<div class="luck_info_situation" style="padding-bottom: 100px;background-color: RGBA(0,0,0,0);border-top:0px solid;">
						<div class="luck_info_situation_time" style="color: RGBA(248,241,210,1);">剩余<b id="luck_info_hour">00</b><b id="luck_info_min">00</b><b id="luck_info_second">00</b> 结束</div>
						<div style="color: red;font-size: 20px;font-weight: bolder;text-align: center;display:none;" id="battleEnd">比赛已结束</div>
					</div>
					
					</li>
					
				</ul>
			</div>
			
			
			
			<div style="position: absolute;bottom: 100px;width:40%;height: 50px;background: url('http://onluguho9.bkt.clouddn.com/btn-red2.png');background-size:100% 100%;margin: 0 auto;text-align: center;font-size: 20px;color: white;padding-top: 10px;left:30%;" id="startButton">开始</div>
			 
			<div style="position: absolute;bottom: 100px;width:40%;height: 50px;background: url('http://onluguho9.bkt.clouddn.com/btn-green.png');background-size:100% 100%;margin: 0 auto;text-align: center;font-size: 20px;color: white;padding-top: 10px;left:30%;" id="mainViewStartButton">准备</div>
			 
			<div class="mainViewFooterButtons">
				<ul>
					<!--  
					<li class="">
					
						<div class="mainViewFooterButton">
							<div class="mainViewFooterButtonIcon_topic"></div>
						</div>
						<div class="mainViewFooterButtonTitle">出题</div>
					</li>
					
					<li>
						<div class="mainViewFooterButton">
							<div class="mainViewFooterButtonIcon_rank"></div>
						</div>
						<div class="mainViewFooterButtonTitle">排行</div>
					
					</li>
					
					<li>
						<div class="mainViewFooterButton">
							<div class="mainViewFooterButtonIcon_news"></div>
						</div>
						<div class="mainViewFooterButtonTitle">消息</div>
					</li>
					
					<li>
						<div class="mainViewFooterButton">
							<div class="mainViewFooterButtonIcon_back"></div>
						</div>
						<div class="mainViewFooterButtonTitle">返回</div>
					</li>
					-->
					
					<!--  
					<li id="redPacketButton">
						<div class="mainViewFooterButton">
							<div class="mainViewFooterButtonIcon_battle"></div>
						</div>
						<div class="mainViewFooterButtonTitle">更多</div>
					</li>
					-->
					
					<li id="homeButton">
						<div class="mainViewFooterButton">
							<div class="mainViewFooterButtonIcon_home"></div>
						</div>
						<div class="mainViewFooterButtonTitle">主页</div>
					</li>
					
					
					<li id="redPacketButton">
						<div class="mainViewFooterButton">
							<div class="mainViewFooterButtonIcon_redPacket"></div>
						</div>
						<div class="mainViewFooterButtonTitle">红包列表</div>
					</li>
					
					<li id="mainViewQrcodeButton">
						<div class="mainViewFooterButton">
							<div class="mainViewFooterButtonIcon_follow"></div>
						</div>
						<div class="mainViewFooterButtonTitle">关注</div>
					</li>
					
					
					<li id="mainViewStoreButton">
						<div class="mainViewFooterButton">
							<div class="mainViewFooterButtonIcon_store"></div>
						</div>
						<div class="mainViewFooterButtonTitle">商城</div>
					</li>
					
					<li style="display: none;">
						<div class="mainViewFooterButton">
							<div class="mainViewFooterButtonIcon_add"></div>
						</div>
						<div class="mainViewFooterButtonTitle">新建</div>
					</li>
					
					<li id="mainViewReadyButton">
						<div class="mainViewFooterButton">
							<div class="mainViewFooterButtonIcon_ready"></div>
						</div>
						<div class="mainViewFooterButtonTitle">准备</div>
					</li>
					
					<!--  
					<li id="mainViewStartButton">
						<div class="mainViewFooterButton">
							<div class="mainViewFooterButtonIcon_start"></div>
						</div>
						<div class="mainViewFooterButtonTitle">开始</div>
					</li>
					-->
				</ul>
			</div>
			
		</div>
<style type="text/css">
<!--
.progress-label3{
	position: absolute;
	left:40%;
	font-weight: bold;
	color:RGBA(77,209,255,1);
	height: 20px;
	font-size: 5px;
}
	     	
#progressbarLove_tool .ui-corner-left{
	background: RGBA(225,0,34,1);
	height: 20px;
	border-radius:10px;
	font-size: 5px;
}
-->
</style>


<script type="text/javascript">
	$(document).ready(function(){
		new BattleMainPlug();
	});
</script>

<style>
	.mainViewMemberProgressLabel{
 		position: absolute;
 		text-align:center;
 		width:100%;
 		font-weight: bold;
 		color:RGBA(77,209,255,1);
 		font-size: 5px;
 		top:0px;
	}
	
	.mainViewMemberProgressLabel .ui-corner-left{
   		background: RGBA(225,0,34,1);
   		height: 20px;
   		border-radius:20px;
	}
</style>


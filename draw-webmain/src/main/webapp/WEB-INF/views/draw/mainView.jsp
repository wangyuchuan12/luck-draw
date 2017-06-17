<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>


<tiles:insertDefinition name="resourceLayout">
	<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
	<tiles:putAttribute name="body">
	
		<div class="mainView">
			<div class="mainViewDekorn">
				<ul>
					<li>
						<div class='mainViewCover'>
							<img src='http://oqcfht5ij.bkt.clouddn.com/baby.jpg'/>
						</div>
					
						<div class="mainViewButtons">
							<div class="mainViewDekornButton" style="display: inline-block;" id="mainViewDekornButton">挑战</div>
						</div>
					
						<div class="redPacketBar">
							<ul>
								
								<li style="background:url('http://oq4mi1sbl.bkt.clouddn.com/redPacketBackground.gif');background-size:100% 100%;">
									<div class="redPacketImg">
										<div class="redPacketHeadImg">
											<img src="/imgs/happy.jpg">
										</div>
										<div class="redPacketBarType">竞答红包</div>
									</div>
								</li>
								
								<li style="background:url('http://oq4mi1sbl.bkt.clouddn.com/redPacketBackground.gif');background-size:100% 100%;">
									<div class="arenaImg">
										<div class="redPacketHeadImg">
											<img src="/imgs/happy.jpg">
										</div>
										<div class="redPacketBarType">挑战</div>
									</div>
								</li>
								
								<li style="background:url('http://oq4mi1sbl.bkt.clouddn.com/redPacketBackground.gif');background-size:100% 100%;">
									<div class="addImg">
						
						
									</div>
								</li>
								
								<li style="background:url('http://oq4mi1sbl.bkt.clouddn.com/redPacketBackground.gif');background-size:100% 100%;"></li>
								
								<li style="background:url('http://oq4mi1sbl.bkt.clouddn.com/redPacketBackground.gif');background-size:100% 100%;"></li>
								
								<li style="background:url('http://oq4mi1sbl.bkt.clouddn.com/redPacketBackground.gif');background-size:100% 100%;"></li>
								
								<li style="background:url('http://oq4mi1sbl.bkt.clouddn.com/redPacketBackground.gif');background-size:100% 100%;"></li>
								
								<li style="background:url('http://oq4mi1sbl.bkt.clouddn.com/redPacketBackground.gif');background-size:100% 100%;"></li>
								
								<li style="background:url('http://oq4mi1sbl.bkt.clouddn.com/redPacketBackground.gif');background-size:100% 100%;"></li>
								
								<li style="background:url('http://oq4mi1sbl.bkt.clouddn.com/redPacketBackground.gif');background-size:100% 100%;"></li>
											
							</ul>
						</div>
						<!--  <div class="mainViewDekornInfo">
							<div class="mainViewDekornImg">
								<img src="http://ooe8ianrr.bkt.clouddn.com/znm123.png">
							</div>
							<div class="mainViewDekornInfoDetail">
								<div><span>名称：</span><span>小鸟飞飞</span></div>
								<div><span>类型：</span><span>游戏</span><span style="padding-left: 20px;">擂台分数：</span><span>300分</span></div>
								<div><span>积分：</span><span>300分 </span><span style="padding-left:20px;">级别：</span><span>3段</span></div>
								<div><span>挑战数：</span><span>5</span><span style="padding-left: 20px;">胜：</span><span>2</span> <span>负：</span><span>5</span></div>								
								<div><span>被挑战：</span><span>5</span><span style="padding-left: 20px;">胜：</span><span>2</span> <span>负：</span><span>5</span></div>
																
							</div>
						</div>
						
						-->
						
					</li>
				</ul>
			</div>
			
			
			
			<div class="mainViewFooterButtons">
				<ul>
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
				</ul>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
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

	var progressPlug;
	
	var paperPlug;
	
	var battlePlug;
	
	var progressFlowPlug;
	
	initProgressPlug();
	function initProgressPlug(){
		var url = "/view/dekorn/progressScore";
		progressPlug = new LayerPlug(url,1,1);
		progressPlug.hide();
		
		
	}
	
	function initBattle(battleId){
		battlePlug = new LayerPlug("/view/dekorn/battleInfo?battleId="+battleId,1,1);
	}
	
	function showProgressPlug(){
		progressPlug.show();
		
		var callback = new Object();
		callback.setProgressFlowPlug = function(plug){
			progressFlowPlug = plug
		}
		progressPlug.call("init",callback);
	
	}
	
	function hideProgressPlug(){
		progressPlug.hide();
	}

	function initEventListener(){
		$("#mainViewDekornButton").click(function(){
			var waitPlug = new WaitPlug();
			var url = "/api/main/battleMemberInfo";
			var callback = new Object();
			callback.success = function(resp){
				if(resp.success){
					var data = resp.data;
					var battleId = 1;
					if(data.status==1){
						initBattle(battleId);
					}else{
						var url = "/api/main/battleTakepart";
						var callback = new Object();
						callback.success = function(){
							//skipToProgressScore();

							battlePlug.show();
						}
						var params = new Object();
						params.battleId = 1;
						request(url,callback,params);
					}
				}
			}
			var params = new Object();
			params.battleId = 1;
			request(url,callback,params);
			//skipToBattleInfo();
		});
	}
	
	
	var index = 1;
	function submitScore(score){
		paperPlug.close();
		paperPlug = skipToPapers("第"+index+"轮");
		index++;
	}
	
	function startDekorn(){
		battlePlug.hide();
		progressPlug.call("scrollToButtom",function(){

		});
		showProgressPlug();
	//	progressPlug.call("startPaper");
	//	index++;
		
	}
	
	$(document).ready(function(){
		
		
		
		var loveProgressPlug = new ProgressPlug("#progressbarLove_tool","#progress-label3",{type:3});
		
	//	loveProgressPlug.addValueAction(20);
		
		
		initEventListener();

		modelPlug.showView();
		
		attrPlug.showView();
		
		
		var progressCallback = new Object();
		progressCallback.complete = function(){
			
		//	var guide = new Guide("#modelPhy",10,-40);
			
		//	guide.annimate();
		
		//	showRoating("#modelPhy",5000);
		//	addLoveAnnim();
		
			showIncreaseNumFromEl(10,$("#progressbarBean"),1,20,40);

		
		}
		
		progress(100,10,progressCallback);
		
		$(".mainView").height($(document).height());
		
		
	//	progressbarMoney.progressbar("value",60);
		
		
	});


</script>


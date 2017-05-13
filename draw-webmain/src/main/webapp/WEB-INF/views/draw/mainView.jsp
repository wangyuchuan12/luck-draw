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
			
			
			<div class="models">
				<ul>
					<li>
						<canvas style="background: url('http://7xugu1.com1.z0.glb.clouddn.com/lifeLoveSolid.png');background-size:100% 100%;" id="modelPhy"></canvas>
						<div  style="color: white;position: relative;top:-5px">爱心 </div>
						
						
						<div id="receiveLoveButton" style="background: RGBA(21,185,254,1);width:70px;height: 20px;margin: 0 auto;border-radius:20px;color: white;position: relative;top:-5px;">升级</div>
					</li>
					
					<li>
						<canvas id="modelPhy2" style="background: url('/imgs/plug/bean.png');background-size:95% 90%;background-position: 5px 0px;"></canvas>
						<div  style="color: white;position: relative;top:-5px">智慧豆</div>
						
						<div id="receiveBeanButton" style="background: RGBA(61,212,11,1);width:70px;height: 20px;margin: 0 auto;border-radius:20px;color: white;position:relative;top:-5px;">领取</div>
					</li>
					
					
					<li>
						<canvas id="modelPhy3" style="background: url('http://on3s1z2us.bkt.clouddn.com/strength.png')no-repeat;background-size:95% 85%;"></canvas>
						<div  style="color: white;position: relative;top:-5px">体力</div>
						
						<div style="background: RGBA(21,185,254,0.1);width:70px;height: 20px;margin: 0 auto;border-radius:20px;color: white;position: relative;top:-5px;">2200000</div>
					</li>
					
					<li>
						<canvas id="modelPhy4" style="background: url('http://on3s1z2us.bkt.clouddn.com/dice3.png')no-repeat;background-size:100% 80%;background-position:0 5px;"></canvas>
						<div  style="color: white;position: relative;top:-5px;">随机</div>
						
						<div id="receiveCoinButton" style="background: RGBA(21,185,254,0.1);width:70px;height: 20px;margin: 0 auto;border-radius:20px;color: white;position: relative;top:-5px;">00:06:02</div>
					</li>
					
				</ul>
			</div>
			
			<div class="mainViewDekorn">
				<ul>
					<li>
						<div class="mainViewDekornInfo">
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
						<div class="mainViewButtons">
								<div class="mainViewDekornButton" style="display: inline-block;" id="mainViewDekornButton">挑战</div>
								<div class="mainViewDekornButton" style="display: inline-block;">刷新擂台</div>
								<div class="mainViewDekornButton" style="display: inline-block;">查看擂台</div>
								<div class="mainViewDekornButton" style="display: inline-block;">挑战记录</div>
						</div>
						
					</li>
				</ul>
			</div>
			
			
			
			
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>

<script type="text/javascript">


	function initEventListener(){
		$("#receiveLoveButton").click(function(){
			addLoveAnnim();
		});
		
		$("#receiveBeanButton").click(function(){
			addBeanAnnim();
		});
		
		$("#receiveCoinButton").click(function(){
			addCoinAnnim();
		});
		
		$("#mainViewDekornButton").click(function(){
			dekornAction();
		});
	}
	$(document).ready(function(){
		initEventListener();
		
		addLoveAnnim();
		
		var progressCallback = new Object();
		progressCallback.complete = function(){
			
		//	var guide = new Guide("#modelPhy",10,-40);
			
		//	guide.annimate();
			showRoating("#modelPhy",5000);
			
			showAttr();
		}
		progress(100,10,progressCallback);
		
		
		
		var width = $(document).width();
		
		var waterbuble = new Waterbubble("#modelPhy",{
			radius:width*0.08,
			waterColor:"RGBA(225,0,34,0.5)",
			textColor:"white",
			txt:"50.324%",
			data:0.3,
			animation:false
		});
		
		//waterbuble.care(1000);
		
		
		$("#modelPhy2").waterbubble({
			waterColor:"RGBA(245,192,0,0.5)",
			radius:width*0.08,
			textColor:"white",
			txt:"50%",
			animation:false
		});
		
		$("#modelPhy3").waterbubble({
			radius:width*0.08,
			animation:false,
			textColor:"white",
			txt:"50%",
			waterColor:"RGBA(244,239,4,0.5)"
		});
		
		$("#modelPhy4").waterbubble({
			radius:width*0.08,
			animation:false,
			textColor:"white",
			txt:"50%",
			waterColor:"RGBA(168,134,51,0.5)"
		});
	
		
		$(".mainView").height($(document).height());
		
		
		
		
		
		initAttr();
		
	//	progressbarMoney.progressbar("value",60);
		
		
	});


</script>


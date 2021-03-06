<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>


<tiles:insertDefinition name="resourceLayout">
	<tiles:putAttribute name="title">进度</tiles:putAttribute>
	<tiles:putAttribute name="body">
		<div class="progressScoreContainerHeader">
			<div class="progressScoreContainerHeaderScore">
				<div class="progressScoreContainerHeaderAllScore">
						<div class="progressScoreContainerHeaderAllScoreTag">总分</div>
						<div class="progressScoreContainerHeaderAllScoreContent" id="allScoreDiv"><span id="allScore"></span>分</div>
				</div>
				
				<div class="progressScoreContainerHeaderAllScore" style="margin-left: 10px;">
						<div class="progressScoreContainerHeaderAllScoreTag">第<span id="round"></span>轮</div>
						<div class="progressScoreContainerHeaderAllScoreContent" id="thisScoreDiv"><span id="thisScore"></span>分</div>
				</div>
			</div>
			
			<!--  
			<div class="progressScoreContainerHeaderAllScore" style="margin-top: 10px;">
				<div class="personalAttrDataHeader personalAttrDataHeaderBean" style="float: left;position: relative;top:4px;"></div>
				<div class="progressScoreContainerHeaderAllScoreContent" style="position: relative;left:-20px;top:1px;">330000</div>	
			</div>
			-->
			<div class="progressScoreContainerHeaderLoveLife">
				<ul>
					<li><div class="personalAttrDataHeaderBig personalAttrDataHeaderLoveBig" id="love1"></div></li>
					<li><div class="personalAttrDataHeaderBig personalAttrDataHeaderLoveBig" id="love2"></div></li>
					<li><div class="personalAttrDataHeaderBig personalAttrDataHeaderLoveBig" id="love3"></div></li>
					<li><div class="personalAttrDataHeaderBig personalAttrDataHeaderLoveHollowBig" id="love4"></div></li>
				</ul>
			</div>
			
			<div class="progressScoreContainerHeader2">
				<div class="progressScoreContainerHeaderRank">当前名次第<span id="rank"></span>名</div>	
			</div>
		</div>
		<div id = "progressScoreContainer" style="overflow: auto;position: relative;">
		<div class="progressScore">
			<div class="progressScoreBar">
				<!-- 
				<ul>
					<li class="flagImg" style="left:22%;top:1885px;">
						<img src='http://on3s1z2us.bkt.clouddn.com/target.png'/>
					</li>
					
					<li class="flagImg" style="left:75%;top:1800px;">
						<img src='http://on3s1z2us.bkt.clouddn.com/dice.png'/>
					</li> 
					
					<li class="flagImg" style="left:20%;top:1650px;"></li>
					
					<li class="flagImg" style="left:70%;top:1600px;"></li>
					
					<li class="flagImg" style="left:60%;top:1450px;"></li>
					
					<li class="flagImg" style="left:69%;top:1140px;"></li>

					<li class="flagImg" style="left:75%;top:890px;"></li>
					
					<li class="flagImg" style="left:75%;top:890px;"></li>
					
					
					
					<li class="flagImg" style="left:3%;top:810px;"></li>
					
					<li class="flagImg" style="left:70%;top:705px;"></li>
					
					<li class="flagImg" style="left:80%;top:550px;"></li>
					
					<li class="flagImg" style="left:30%;top:460px;"></li>
				
					<li class="flagImg" style="left:80%;top:380px;"></li>
					
					<li class="flagImg" style="left:40%;top:270px;"></li>
				</ul>
				 -->
			</div>
			
			<div class="trajectory">
				<ul>
					<li style="left:12.5%;top:1900px;" id="toDom0" ></li>
					
					<li style="left:21%;top:1870px;" id="toDom1"></li>
					
					<li style="left:30%;top:1865px;" id="toDom2"></li>
					
					<li style="left:38%;top:1865px;" id="toDom3"></li>
					
					<li style="left:46%;top:1867px;" id="toDom4"></li>
					
					<li style="left:53%;top:1874px;" id="toDom5"></li>
					
					<li style="left:60%;top:1879px;" id="toDom6"></li>
					
					<li style="left:68%;top:1880px;" id="toDom7"></li>
					
					<li style="left:75%;top:1875px;" id="toDom8"></li>
					
					<li style="left:83%;top:1860px;" id="toDom9"></li>
					
					<li style="left:88%;top:1834px;" id="toDom10"></li>
					
					
					<li style="left:89%;top:1805px;" id="toDom11"></li>
					
					<li style="left:84%;top:1787px;" id="toDom12"></li>
					
					<li style="left:77%;top:1780px;" id="toDom13"></li>
					
					<li style="left:69%;top:1780px;" id="toDom14"></li>
					
					<li style="left:60%;top:1775px;" id="toDom15"></li>
					
					<li style="left:50%;top:1775px;" id="toDom16"></li>
					
					<li style="left:40%;top:1770px;" id="toDom17"></li>
					
					<li style="left:33%;top:1760px;" id="toDom18"></li>
					
					<li style="left:25%;top:1730px;" id="toDom19"></li>
					
					<li style="left:26%;top:1695px;" id="toDom20"></li>
					
					<li style="left:35%;top:1663px;" id="toDom21"></li>
					
					<li style="left:43.5%;top:1655px;" id="toDom22"></li>
					
					<li style="left:54%;top:1670px;" id="toDom23"></li>
					
					<li style="left:67%;top:1670px;" id="toDom24"></li>
					
					<li style="left:79.5%;top:1670px;" id="toDom25"></li>
					
					<li style="left:82%;top:1620px;" id="toDom26"></li>
					
					<li style="left:80%;top:1590px;" id="toDom27"></li>
					
					<li style="left:70%;top:1578px;" id="toDom28"></li>
					
					<li style="left:60%;top:1573px;" id="toDom29"></li>
					
					<li style="left:53%;top:1567px;" id="toDom30"></li>
					
					<li style="left:45%;top:1570px;" id="toDom31"></li>
					
					<li style="left:35%;top:1560px;" id="toDom32"></li>
					
					<li style="left:28%;top:1555px;" id="toDom33"></li>
					
					<li style="left:22%;top:1530px;" id="toDom34"></li>
					
					<li style="left:27%;top:1500px;" id="toDom35"></li>
					
					<li style="left:36%;top:1500px;" id="toDom36"></li>
					
					<li style="left:45%;top:1500px;" id="toDom37"></li>
					
					<li style="left:53%;top:1510px;" id="toDom38"></li>
					
					<li style="left:61%;top:1510px;" id="toDom39"></li>
					
					<li style="left:70%;top:1490px;" id="toDom40"></li>
					
					<li style="left:70%;top:1460px;" id="toDom41"></li>
					
					<li style="left:70%;top:1430px;" id="toDom42"></li>
					
					<li style="left:70%;top:1400px;" id="toDom43"></li>
					
					<li style="left:70%;top:1370px;" id="toDom44"></li>
					
					<li style="left:70%;top:1340px;" id="toDom45"></li>
					
					<li style="left:70%;top:1310px;" id="toDom46"></li>
					
					<li style="left:70%;top:1280px;" id="toDom47"></li>
					
					<li style="left:70%;top:1250px;" id="toDom48">48</li>
					
					<li style="left:70%;top:1220px;" id="toDom49">49</li>
					
					<li style="left:73%;top:1160px;" id="toDom50">50</li>
					
					<li style="left:77%;top:1080px;" id="toDom51"></li>
					
					<li style="left:69%;top:1070px;" id="toDom52"></li>
					
					<li style="left:62%;top:1060px;" id="toDom53"></li>
					
					<li style="left:55%;top:1050px;" id="toDom54"></li>
					
					<li style="left:50%;top:1030px;" id="toDom55"></li>
					
					<li style="left:60%;top:1010px;" id="toDom56"></li>
					
					<li style="left:68%;top:993px;" id="toDom57"></li>
					
					<li style="left:77%;top:980px;" id="toDom58"></li>
					
					<li style="left:85%;top:950px;" id="toDom59"></li>
					
					<li style="left:87%;top:900px;" id="toDom60"></li>
					
					<li style="left:80%;top:870px;" id="toDom61"></li>
					
					<li style="left:70%;top:880px;" id="toDom62"></li>
					
					<li style="left:63%;top:885px;" id="toDom63"></li>
					
					<li style="left:54%;top:895px;" id="toDom64"></li>
					
					<li style="left:45%;top:911px;" id="toDom65"></li>
					
					<li style="left:35%;top:912px;" id="toDom66"></li>
					
					<li style="left:25%;top:905px;" id="toDom67"></li>
					
					<li style="left:17%;top:890px;" id="toDom68"></li>
					
					<li style="left:12%;top:865px;" id="toDom69"></li>
					
					<li style="left:12%;top:830px;" id="toDom70"></li>
					
					<li style="left:14%;top:800px;" id="toDom71"></li>
					
					<li style="left:18%;top:770px;" id="toDom72"></li>
					
					<li style="left:25%;top:760px;" id="toDom73"></li>
					
					<li style="left:33%;top:747px;" id="toDom74"></li>
					
					<li style="left:41%;top:743px;" id="toDom75"></li>
					
					<li style="left:50%;top:743px;" id="toDom76"></li>
					
					<li style="left:58%;top:744px;" id="toDom77"></li>
					
					<li style="left:66%;top:747px;" id="toDom78"></li>
					
					<li style="left:75%;top:747px;" id="toDom79"></li>
					
					<li style="left:75%;top:720px;" id="toDom80"></li>
					
					<li style="left:65%;top:710px;" id="toDom81"></li>
					
					<li style="left:55%;top:703px;" id="toDom82"></li>
					
					<li style="left:45%;top:694px;" id="toDom83"></li>
					
					<li style="left:38%;top:670px;" id="toDom84"></li>
					
					<li style="left:45%;top:647px;" id="toDom85"></li>
					
					<li style="left:55%;top:642px;" id="toDom86"></li>
					
					<li style="left:65%;top:638px;" id="toDom87"></li>
					
					<li style="left:75%;top:632px;" id="toDom88"></li>
					
					<li style="left:85%;top:615px;" id="toDom89"></li>
					
					<li style="left:92%;top:580px;" id="toDom90"></li>
					
					<li style="left:85%;top:540px;" id="toDom91"></li>
					
					<li style="left:77%;top:520px;" id="toDom92"></li>
					
					<li style="left:67%;top:513px;" id="toDom93"></li>
					
					<li style="left:57%;top:513px;" id="toDom94"></li>
					
					<li style="left:47%;top:519px;" id="toDom95"></li>
					
					
					<li style="left:37%;top:530px;" id="toDom96"></li>
					
					<li style="left:27%;top:539px;" id="toDom97"></li>
					
					<li style="left:18%;top:519px;" id="toDom98"></li>
					
					<li style="left:14%;top:495px;" id="toDom99"></li>
					
					<li style="left:20%;top:465px;" id="toDom100"></li>
					
					<li style="left:30%;top:452px;" id="toDom101"></li>
					
					<li style="left:40%;top:450px;" id="toDom102"></li>
					
					<li style="left:50%;top:450px;" id="toDom103"></li>
					
					<li style="left:60%;top:450px;" id="toDom104"></li>
					
					<li style="left:68%;top:450px;" id="toDom105"></li>
					
					<li style="left:77%;top:450px;" id="toDom106"></li>
					
					<li style="left:87%;top:438px;" id="toDom107"></li>
					
					<li style="left:91%;top:410px;" id="toDom108"></li>
					
					<li style="left:88%;top:380px;" id="toDom109"></li>
					
					<li style="left:80%;top:374px;" id="toDom110"></li>
					
					<li style="left:73%;top:364px;" id="toDom111"></li>
					
					<li style="left:67%;top:360px;" id="toDom112"></li>
					
					<li style="left:60%;top:360px;" id="toDom113"></li>
					
					<li style="left:53%;top:360px;" id="toDom114"></li>
					
					<li style="left:47%;top:358px;" id="toDom115"></li>
					
					<li style="left:40%;top:358px;" id="toDom116"></li>
					
					<li style="left:33%;top:352px;" id="toDom117"></li>
					
					<li style="left:25%;top:340px;" id="toDom118"></li>
					
					<li style="left:25%;top:310px;" id="toDom119"></li>
					
					<li style="left:32%;top:280px;" id="toDom120"></li>
					
				</ul>
			</div>
			
			<div class="fromDom" id="fromDom" style="background: url('http://on3s1z2us.bkt.clouddn.com/target.png');background-size:100% 100%;position: absolute;z-index: 100" ></div>
					
			<div class="fromDom" id="rightPoint" style="background: url('http://on3s1z2us.bkt.clouddn.com/judge.png');width:50px;height:50px;background-size:250% 250%;background-position:1px 0px;position:absolute;top:100px;left:150px;opacity:0.7" ></div>
			
			<div class="fromDom" id="wrongPoint" style="background: url('http://on3s1z2us.bkt.clouddn.com/judge.png');width:50px;height:50px;background-size:250% 250%;background-position:50px 0px;position:absolute;top:100px;left:150px;opacity:0.5" ></div>
			
		</div>

		</div>

		
		

	</tiles:putAttribute>
	
	
</tiles:insertDefinition>

<script type="text/javascript">
	function init(callback){
		var progressScore = new ProgressScore();
		callback.setProgressScore(progressScore);
		progressScore.init(callback);
	}
</script>


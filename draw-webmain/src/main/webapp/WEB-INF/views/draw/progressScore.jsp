<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>


<tiles:insertDefinition name="resourceLayout">
	<tiles:putAttribute name="title">进度</tiles:putAttribute>
	<tiles:putAttribute name="body">
		<div class="progressScore">
			<div class="progressScoreBar">
				<ul>
					<li class="flagImg" style="left:20%;top:1870px;">开始</li>
					
					<li class="flagImg" style="left:80%;top:1800px;">10分</li> 
					
					<li class="flagImg" style="left:20%;top:1650px;">20分</li>
					
					<li class="flagImg" style="left:50%;top:1580px;">30分</li>
					
					<li class="flagImg" style="left:60%;top:1450px;">40分</li>
					
					<li class="flagImg" style="left:69%;top:1140px;">50分</li>

					<li class="flagImg" style="left:75%;top:890px;">60分</li>
					
					<li class="flagImg" style="left:75%;top:890px;">70分</li>
					
					
					
					<li class="flagImg" style="left:3%;top:810px;">80分</li>
					
					<li class="flagImg" style="left:70%;top:705px;">90分</li>
					
					<li class="flagImg" style="left:80%;top:550px;">100分</li>
					
					<li class="flagImg" style="left:30%;top:460px;">110分</li>
				
					<li class="flagImg" style="left:80%;top:380px;">120分</li>
					
					<li class="flagImg" style="left:40%;top:270px;">130分</li>
				</ul>
			</div>
			
			<div class="trajectory">
				<ul>
					<li style="left:14%;top:1900px;" id="toDom" >1</li>
					
					<li style="left:21%;top:1870px;" id="toDom2">2</li>
					
					<li style="left:30%;top:1865px;" id="toDom3">3</li>
					
					<li style="left:38%;top:1865px;" id="toDom4">4</li>
					
					<li style="left:46%;top:1867px;" id="toDom5">5</li>
					
					<li style="left:53%;top:1874px;" id="toDom6">6</li>
					
					<li style="left:60%;top:1879px;" id="toDom7">7</li>
					
					<li style="left:68%;top:1880px;" id="toDom8">8</li>
					
					<li style="left:75%;top:1875px;" id="toDom9">9</li>
					
					<li style="left:83%;top:1860px;" id="toDom10">10</li>
					
					<li style="left:88%;top:1834px;" id="toDom11">11</li>
					
					
					<li style="left:89%;top:1805px;" id="toDom12">12</li>
					
					<li style="left:84%;top:1787px;" id="toDom13">13</li>
					
					<li style="left:77%;top:1780px;" id="toDom14">14</li>
					
					<li style="left:69%;top:1780px;" id="toDom15">15</li>
					
					<li style="left:60%;top:1775px;" id="toDom16">16</li>
					
					<li style="left:50%;top:1775px;" id="toDom17">17</li>
					
					<li style="left:40%;top:1770px;" id="toDom18">18</li>
					
					<li style="left:33%;top:1760px;" id="toDom19">19</li>
					
					<li style="left:25%;top:1730px;" id="toDom20">20</li>
					
					<li style="left:26%;top:1695px;" id="toDom21">21</li>
					
					<li style="left:35%;top:1663px;" id="toDom22">22</li>
					
					<li style="left:43.5%;top:1655px;" id="toDom23">23</li>
					
					<li style="left:54%;top:1670px;" id="toDom24">24</li>
					
					<li style="left:67%;top:1670px;" id="toDom25">25</li>
					
					<li style="left:79.5%;top:1670px;" id="toDom26">26</li>
					
					<li style="left:83%;top:1630px;" id="toDom27">27</li>
					
					<li style="left:80%;top:1590px;" id="toDom28">28</li>
					
					<li style="left:70%;top:1578px;" id="toDom29">29</li>
					
					<li style="left:60%;top:1573px;" id="toDom30">30</li>
					
					<li style="left:53%;top:1567px;" id="toDom31">31</li>
					
					<li style="left:45%;top:1570px;" id="toDom32">32</li>
					
					<li style="left:35%;top:1560px;" id="toDom33">33</li>
					
					<li style="left:28%;top:1555px;" id="toDom34">34</li>
					
					<li style="left:22%;top:1530px;" id="toDom35">35</li>
					
					<li style="left:27%;top:1500px;" id="toDom36">36</li>
					
					<li style="left:36%;top:1500px;" id="toDom37">37</li>
					
					<li style="left:45%;top:1500px;" id="toDom38">38</li>
					
					<li style="left:53%;top:1510px;" id="toDom39">39</li>
					
					<li style="left:61%;top:1510px;" id="toDom40">40</li>
					
					<li style="left:70%;top:1490px;" id="toDom41">41</li>
					
					<li style="left:70%;top:1460px;" id="toDom42">42</li>
					
					<li style="left:70%;top:1430px;" id="toDom43">43</li>
					
					<li style="left:70%;top:1400px;" id="toDom44">44</li>
					
					<li style="left:70%;top:1370px;" id="toDom45">45</li>
					
					<li style="left:70%;top:1340px;" id="toDom46">46</li>
					
					<li style="left:70%;top:1310px;" id="toDom47">47</li>
					
					<li style="left:70%;top:1280px;" id="toDom48">48</li>
					
					<li style="left:70%;top:1250px;" id="toDom49">49</li>
					
					<li style="left:70%;top:1220px;" id="toDom50">50</li>
					
					<li style="left:73%;top:1160px;" id="toDom51">51</li>
					
					<li style="left:77%;top:1080px;" id="toDom52">52</li>
					
					<li style="left:69%;top:1070px;" id="toDom53">53</li>
					
					<li style="left:62%;top:1060px;" id="toDom54">54</li>
					
					<li style="left:55%;top:1050px;" id="toDom55">55</li>
					
					<li style="left:50%;top:1030px;" id="toDom56">56</li>
					
					<li style="left:60%;top:1010px;" id="toDom57">57</li>
					
					<li style="left:68%;top:993px;" id="toDom58">58</li>
					
					<li style="left:77%;top:980px;" id="toDom59">59</li>
					
					<li style="left:85%;top:950px;" id="toDom60">60</li>
					
					<li style="background: red;width:20px; height: 20px;left:87%;top:900px;position: absolute;" id="toDom61"></li>
					
					<li style="background: red;width:20px; height: 20px;left:80%;top:870px;position: absolute;" id="toDom62"></li>
					
					<li style="background: red;width:20px; height: 20px;left:70%;top:880px;position: absolute;" id="toDom63"></li>
					
					<li style="background: red;width:20px; height: 20px;left:63%;top:885px;position: absolute;" id="toDom64"></li>
					
					<li style="background: red;width:20px; height: 20px;left:54%;top:895px;position: absolute;" id="toDom65"></li>
					
					<li style="background: red;width:20px; height: 20px;left:45%;top:911px;position: absolute;" id="toDom66"></li>
					
					<li style="background: red;width:20px; height: 20px;left:35%;top:912px;position: absolute;" id="toDom67"></li>
					
					<li style="background: red;width:20px; height: 20px;left:25%;top:905px;position: absolute;" id="toDom68"></li>
					
					<li style="background: red;width:20px; height: 20px;left:17%;top:890px;position: absolute;" id="toDom69"></li>
					
					<li style="background: red;width:20px; height: 20px;left:12%;top:865px;position: absolute;" id="toDom70"></li>
					
					<li style="background: red;width:20px; height: 20px;left:12%;top:830px;position: absolute;" id="toDom71"></li>
					
					<li style="background: red;width:20px; height: 20px;left:14%;top:800px;position: absolute;" id="toDom72"></li>
					
					<li style="background: red;width:20px; height: 20px;left:18%;top:770px;position: absolute;" id="toDom73"></li>
					
					<li style="background: red;width:20px; height: 20px;left:25%;top:760px;position: absolute;" id="toDom74"></li>
					
					<li style="background: red;width:20px; height: 20px;left:33%;top:747px;position: absolute;" id="toDom75"></li>
					
					<li style="background: red;width:20px; height: 20px;left:41%;top:743px;position: absolute;" id="toDom76"></li>
					
					<li style="background: red;width:20px; height: 20px;left:50%;top:743px;position: absolute;" id="toDom77"></li>
					
					<li style="background: red;width:20px; height: 20px;left:58%;top:744px;position: absolute;" id="toDom78"></li>
					
					<li style="background: red;width:20px; height: 20px;left:66%;top:747px;position: absolute;" id="toDom79"></li>
					
					<li style="background: red;width:20px; height: 20px;left:75%;top:747px;position: absolute;" id="toDom80"></li>
					
					<li style="background: red;width:20px; height: 20px;left:75%;top:720px;position: absolute;" id="toDom81"></li>
					
					<li style="background: red;width:20px; height: 20px;left:65%;top:710px;position: absolute;" id="toDom82"></li>
					
					<li style="background: red;width:20px; height: 20px;left:55%;top:703px;position: absolute;" id="toDom83"></li>
					
					<li style="background: red;width:20px; height: 20px;left:45%;top:694px;position: absolute;" id="toDom84"></li>
					
					<li style="background: red;width:20px; height: 20px;left:38%;top:670px;position: absolute;" id="toDom85"></li>
					
					<li style="background: red;width:20px; height: 20px;left:45%;top:647px;position: absolute;" id="toDom86"></li>
					
					<li style="background: red;width:20px; height: 20px;left:55%;top:642px;position: absolute;" id="toDom87"></li>
					
					<li style="background: red;width:20px; height: 20px;left:65%;top:638px;position: absolute;" id="toDom88"></li>
					
					<li style="background: red;width:20px; height: 20px;left:75%;top:632px;position: absolute;" id="toDom89"></li>
					
					<li style="background: red;width:20px; height: 20px;left:85%;top:615px;position: absolute;" id="toDom90"></li>
					
					<li style="background: red;width:20px; height: 20px;left:92%;top:580px;position: absolute;" id="toDom91"></li>
					
					<li style="background: red;width:20px; height: 20px;left:85%;top:540px;position: absolute;" id="toDom92"></li>
					
					<li style="background: red;width:20px; height: 20px;left:77%;top:520px;position: absolute;" id="toDom93"></li>
					
					<li style="background: red;width:20px; height: 20px;left:67%;top:513px;position: absolute;" id="toDom94"></li>
					
					<li style="background: red;width:20px; height: 20px;left:57%;top:513px;position: absolute;" id="toDom95"></li>
					
					<li style="background: red;width:20px; height: 20px;left:47%;top:519px;position: absolute;" id="toDom96"></li>
					
					
					<li style="background: red;width:20px; height: 20px;left:37%;top:530px;position: absolute;" id="toDom97"></li>
					
					<li style="background: red;width:20px; height: 20px;left:27%;top:539px;position: absolute;" id="toDom98"></li>
					
					<li style="background: red;width:20px; height: 20px;left:18%;top:519px;position: absolute;" id="toDom99"></li>
					
					<li style="background: red;width:20px; height: 20px;left:14%;top:495px;position: absolute;" id="toDom100"></li>
					
					<li style="background: red;width:20px; height: 20px;left:20%;top:465px;position: absolute;" id="toDom101"></li>
					
					<li style="background: red;width:20px; height: 20px;left:30%;top:452px;position: absolute;" id="toDom102"></li>
					
					<li style="background: red;width:20px; height: 20px;left:40%;top:450px;position: absolute;" id="toDom103"></li>
					
					<li style="background: red;width:20px; height: 20px;left:50%;top:450px;position: absolute;" id="toDom104"></li>
					
					<li style="background: red;width:20px; height: 20px;left:60%;top:450px;position: absolute;" id="toDom105"></li>
					
					<li style="background: red;width:20px; height: 20px;left:68%;top:450px;position: absolute;" id="toDom106"></li>
					
					<li style="background: red;width:20px; height: 20px;left:77%;top:450px;position: absolute;" id="toDom107"></li>
					
					<li style="background: red;width:20px; height: 20px;left:87%;top:438px;position: absolute;" id="toDom108"></li>
					
					<li style="background: red;width:20px; height: 20px;left:91%;top:410px;position: absolute;" id="toDom109"></li>
					
					<li style="background: red;width:20px; height: 20px;left:88%;top:380px;position: absolute;" id="toDom110"></li>
					
					<li style="background: red;width:20px; height: 20px;left:80%;top:374px;position: absolute;" id="toDom111"></li>
					
					<li style="background: red;width:20px; height: 20px;left:73%;top:364px;position: absolute;" id="toDom112"></li>
					
					<li style="background: red;width:20px; height: 20px;left:67%;top:360px;position: absolute;" id="toDom113"></li>
					
					<li style="background: red;width:20px; height: 20px;left:60%;top:360px;position: absolute;" id="toDom114"></li>
					
					<li style="background: red;width:20px; height: 20px;left:53%;top:360px;position: absolute;" id="toDom115"></li>
					
					<li style="background: red;width:20px; height: 20px;left:47%;top:358px;position: absolute;" id="toDom116"></li>
					
					<li style="background: red;width:20px; height: 20px;left:40%;top:358px;position: absolute;" id="toDom117"></li>
					
					<li style="background: red;width:20px; height: 20px;left:33%;top:352px;position: absolute;" id="toDom118"></li>
					
					<li style="background: red;width:20px; height: 20px;left:25%;top:340px;position: absolute;" id="toDom119"></li>
					
					<li style="background: red;width:20px; height: 20px;left:25%;top:310px;position: absolute;" id="toDom120"></li>
					
					<li style="background: red;width:20px; height: 20px;left:32%;top:280px;position: absolute;" id="toDom121"></li>
					
					
					
					
				</ul>
			</div>
		</div>

	<div style="background: black;width:40px; height: 40px;left:15%;top:1900px;position: absolute;" id="fromDom"></div>
		

	</tiles:putAttribute>
	
	
</tiles:insertDefinition>

<script type="text/javascript">
	$(document).ready(function(){
		
		var callback = new Object();
		callback.complete = function(){
			
			var toDoms = new Array();
			
			toDoms.push($("#toDom"));
			for(var i=0;i<110;i++){
				toDoms.push($("#toDom"+(i+2)));
			}
			moveAnimateTrajectory($("#fromDom"),toDoms,0);
		}
		progress(100,10,callback);
		
		$(".progressScore").height($(window).height());
		
		
	});


</script>


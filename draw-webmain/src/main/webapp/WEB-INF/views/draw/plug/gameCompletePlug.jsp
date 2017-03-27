<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="resourceLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
<tiles:putAttribute name="body">
		<div class="gameCompletePlug">
		
			<div class="gameCompletePlugLight">
				
			</div>
			
			<div class="gameCompletePlugHeaderImg">
					<img src="http://wx.qlogo.cn/mmopen/ajNVdqHZLLArTkHWwSHdc883hiaYBibjyLXiaiblmTEVcJzGICx0U3MXbYJsVnvzr4hjtaO2dt8w25vBAJibWbky8wA/0">
			</div>
			
			<div class="gameCompletePlugLifeLove">
				<ul>
					<li class="lifeLoveSolid"></li>
					<li class="lifeLoveSolid"></li>
					<li class="lifeLoveSolid"></li>
					<li class="lifeLoveHollow"></li>
				</ul>
			</div>
				
			<div class="gameCompletePlugBander">
				<span>挑战成功，您获得第5名</span>
				<img src="/imgs/plug/banner.png">
			</div>
			
			<div class="gameCompletePlugContent">
				<ul>
					<li>获取得分：50分</li>
					<li>最高分：100分</li>
					<li>击败80%</li>
				</ul>
				
				<ul>
					<li>返回</li>
					<li>继续挑战</li>
				</ul>
				
			</div>
		</div>
</tiles:putAttribute>
</tiles:insertDefinition>
<script type="text/javascript">
	$(document).ready(function(){
		var width = $(".gameCompletePlugHeaderImg>img").width();
		$(".gameCompletePlugHeaderImg>img").height(width);
		
		var width2 = $(".gameCompletePlugLight").width();

		$(".gameCompletePlugLight").height(width2);
		roate();
	});
	
	
	function roate(){
		
		var time=50;
		var index = setInterval(function(){
			time++;
			$(".gameCompletePlugLight").css("transform","rotate("+time+"deg)");
		},100);
	}
</script>

<style type="text/css">

	.gameCompletePlugLifeLove{
		width: 100%;
		height: 100px;
		
		z-index: 10000;
		
		position: absolute;
		
		top: 25%;

	    
	    text-align: center;
		
	}
	
	.gameCompletePlugLifeLove>ul>li{
		display: inline-block;
		width:100px;
		
		height: 100px;
	}
	
	.gameCompletePlugLifeLove>ul>li.lifeLoveSolid{
		background: url("/imgs/plug/lifeLoveSolid.png");
		
		background-size:100px 100px;
		
		
		
		background-position:-10px 0px;
	
	}
	
	.gameCompletePlugLifeLove>ul>li.lifeLoveHollow{
	
		background: url("/imgs/plug/lifeLoveHollow.png") no-repeat;
		
		background-size:70px 60px;
		
		background-position:0px 20px;
		
		width:100px;
		
		height: 100px;å
	}
	
	.gameCompletePlug{
		background: url("/imgs/plug/gameCompletePlug.jpg");
		background-size:100% 100%;
		width:100%;
		height: 100%;
		overflow: hidden;
		text-overflow:ellipsis;
		
		/*filter: progid:DXImageTransform.Microsoft.BasicImage(grayscale=1); */
    	
	}
	
	.gameCompletePlugLight{
		background: url("/imgs/plug/light.png");
		background-size:100% 100%;
		width:150%;
		left:-20%;
		top:-200px;
		overflow: hidden;
		background-position: 0 20%;
		position: fixed;
		border-radius:1000px;
		opacity:2;
		-webkit-filter: grayscale(100%);
		
	}

	.gameCompletePlugHeaderImg{
		margin: 0 auto;
		text-align:center;;
		position: absolute;
		top: 20%;
		z-index:1000;
		left: 50%;
	    -webkit-transform: translate(-50%, -50%);
	    transform: translate(-50%, -50%);
		
	}
	.gameCompletePlugHeaderImg>img{
		width:30%;
		border-radius:100px;
	}
	
	.gameCompletePlugBander{
		width:99%;
		z-index: 1000;
		position: absolute;
		text-align: center;
		top:30%;
		-webkit-filter: grayscale(100%); 
	}
	.gameCompletePlugBander>span{
		position: absolute;
		color: RGBA(255,239,110,1);
		font-size: 40px;

		left: 50%;
	    -webkit-transform: translate(-50%, -50%);
	    transform: translate(-50%, -50%);
		top:44%;
		
		font-weight: 900;
		
		
	}
	.gameCompletePlugBander>img{
		width:85%;
	}
	
	.gameCompletePlugContent{
		width:70%;
		left: 50%;
		top:55%;
		
		padding-top:40px;
		
		padding-bottom:40px;
		
	    -webkit-transform: translate(-50%, -50%);
	    
	   	z-index: 1000;
		position: relative;
	    background-color: RGBA(108,99,104,0.5);
	    text-align: center;
	    
	    border-radius:20px;
	}
	
	.gameCompletePlugContent>ul:FIRST-CHILD>li{
		list-style: none;
		color: white;
		
		font-size: 40px;
	}
	
	.gameCompletePlugContent>ul:nth-child(2){
		text-align: center;
		
		padding-top: 30px;
	}
	.gameCompletePlugContent>ul:nth-child(2)>li{
		list-style: none;
		display: inline-block;
		
		width:45%;
		
		height: 70px;
		
		
		border-radius:20px;
		padding-top: 10px;
		
		color: white;
		
		font-size: 40px;
		
		font-weight: bolder;
	}
	
	.gameCompletePlugContent>ul:nth-child(2)>li:nth-child(1){
		background-color: RGBA(0,189,238,1);
	}
	
	.gameCompletePlugContent>ul:nth-child(2)>li:nth-child(2){
		background-color: RGBA(231,189,3,1);
	}
	
</style>
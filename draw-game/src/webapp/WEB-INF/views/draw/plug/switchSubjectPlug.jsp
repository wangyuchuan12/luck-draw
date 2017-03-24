<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>

		<div class="switchSubjectPlug">
			 <div class="switchSubjectPlugTitle">挑战分数：100次</div>
			 <div class="switchSubjectPlugName">挑战项目：小鸟飞飞</div>
			 
			 <div class="switchSubjectPlugPlayers">
			 	<div class="switchSubjectPlugPlayer" style="left:5%;">
			 		<img src="http://wx.qlogo.cn/mmopen/8t8etdDXwrDvPykbY7HSFbvwhgQSeEUugmwibCsicASzPnsIchkjmU4ibM8OnLnarrI54cuicSbIZBP7RlEdDvOpD2EghMkicStQT/0">
			 		<span>川川无敌飞车手</span>
			 		<div class="switchSubjectPlugPlayerDialog">你是谁呀，我叫王煜川，初中一班学生哈哈</div>
			 	</div>
			 	
			 	<div class="switchSubjectPlugPlayer" style="right: 5%;">
			 		<img src="http://wx.qlogo.cn/mmopen/8t8etdDXwrDvPykbY7HSFbvwhgQSeEUugmwibCsicASzPnsIchkjmU4ibM8OnLnarrI54cuicSbIZBP7RlEdDvOpD2EghMkicStQT/0">
			 		<span>大卫</span>
			 	</div>
			 </div>
			 
			 <div class="switchSubjectPlugReward">
			 	<div class="switchSubjectPlugRewardContent">
			 		<div class="switchSubjectPlugRewardContentTitle">胜利奖励</div>
			 		<ul>
			 			<li>
			 				<img src="/imgs/plug/bean.png">
			 				<span>200</span>
			 			</li>
			 			
			 			<li>
			 			</li>
			 		</ul>
			 	</div>
			 </div>
			 
			 <div class="switchSubjectPlugBtns">
			 	<ul>
			 		<li>返回</li>
			 		<li>换一个</li>
			 		<li>开始挑战</li>
			 	</ul>
			 </div>
		</div>


<style>

	.switchSubjectPlug{
		background: url("http://7xlw44.com1.z0.glb.clouddn.com/background-limit.png") no-repeat;
		width:100%;
		height: 100%;
		background-size:100% 70%;

	}
	
	.switchSubjectPlugTitle{
		background: url("/imgs/plug/leafTitle.png") no-repeat;
		background-position:-40 -250px;
		background-size:100% 700px;
		width: 100%;
		height: 200px;
		text-align: center;
		font-size: 50px;
		padding-top:70px;
		color: black;
	}
	
	.switchSubjectPlugPlayers{
		background: url("/imgs/plug/vs.png") no-repeat;
		
		background-size:400px 400px;
		background-position:50% 0px;
		width:100%;

		height: 400px;

	}
	
	.switchSubjectPlugPlayer{
		text-align: center;
		display: inline-block;
		position: absolute;
		top:300px;
		
		
	}
	
	.switchSubjectPlugPlayer>img{
		width:150px;
		height: 150px;
		
		border-radius:20px;
	}
	
	.switchSubjectPlugPlayer>span{
		display: block;
		
		padding-top: 20px;
		
		font-size: 40px;
		overflow:hidden;text-overflow:ellipsis; -o-text-overflow:ellipsis;white-space:nowrap;
		width:300px;
		display: block;
		
		
	}
	
	.switchSubjectPlugRewardContent{
		text-align: center;
		position: absolute;
		
		top:900px;
		display: block;
		
		left: 50%;
	    -webkit-transform: translate(-50%, -50%);
	    transform: translate(-50%, -50%);
	    
	    background-color: RGBA(216,178,131,0.99);
	    width:90%;
	    
	    height: 200px;
	    
	    text-align: center;
	    
	    border-radius:20px;
	}
	
	.switchSubjectPlugRewardContent>ul{
		background: RGBA(83,61,49,1);
		
		width:90%;
		
		height: 55%;

		left:25px;

	    position: relative;

	  	border-radius:20px;
	}
	
	.switchSubjectPlugRewardContent>ul>li{
		list-style: none;
		display: inline-block;
		
	}
	
	.switchSubjectPlugRewardContent>ul>li>img{
		width: 100px;
		height: 100px;
	}
	
	.switchSubjectPlugRewardContent>ul>li>span{
		color: RGBA(255,233,110,1);
		font-size: 40px;
		top:-30px;
		display: inline-block;
		position: relative;
		font-weight: bolder;
	}
	
	.switchSubjectPlugRewardContentTitle{
		color: RGBA(252,234,182,1);
		font-size: 40px;
		
		padding-top: 5px;
		
		font-weight: bolder;
	}
	
	.switchSubjectPlugBtns{
		position: absolute;
		top:1000px;
	}
	
	.switchSubjectPlugBtns{
		width:98%;
		margin: 0 auto;
		
		padding-left: 10px;
	}
	.switchSubjectPlugBtns>ul>li{
		display: inline-block;
		list-style: none;
		
		font-size: 40px;
		
		font-weight: bolder;
		
		padding-top: 40px;
	}
	.switchSubjectPlugBtns>ul>li:FIRST-CHILD{
		
		
		background:url("/imgs/btn/btn-yellow.png") no-repeat;
		
		background-size:100% 100%;
		
		width:45%;
		height: 150px;
		
		text-align: center;
		
		color: black;
		
	}
	
	
	
	.switchSubjectPlugBtns>ul>li:nth-child(2){
		background:url("/imgs/btn/btn-violet.png") no-repeat;
		background-size:100% 100%;
		width:45%;
		height: 140px;
		
		text-align: center;
		
		color: white;
	}
	
	.switchSubjectPlugBtns>ul>li:nth-child(3){
		background:url("/imgs/btn/btn-blue.png") no-repeat;
		background-size:90% 100%;
		width:99.5%;
		height: 140px;
		
		text-align: center;
		
		color: white;
		
		margin: 0 auto;
		padding-top: 90px;
		
		margin-top: 20px;
	}
	
	.switchSubjectPlugName{
		text-align: center;
		
		color: RGBA(63,125,226,1);
		
		font-size: 40px;
		
		font-weight: bolder;
		
		position: absolute;
		
		top:230px;
		
		left: 50%;
	    -webkit-transform: translate(-50%, -50%);
	    transform: translate(-50%, -50%);
	}
	
	.switchSubjectPlugPlayerDialog{
		background: url("http://on3s1z2us.bkt.clouddn.com/fbddbbdea50d29299298d86740aa4068.png") no-repeat;
		
		width:400px;
		
		height: 200px;
		
			
		background-size:90% 100%;
		
		position: absolute;
		
		top:-200px;
		
		font-size: 30px;
		
		padding-top: 50px;
		
		right: -57px;

	}
</style>
<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="gameLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
<tiles:putAttribute name="body">
<head><meta name="x-key" content="97e624915fc159eb48ad8cdd17dd5d12">
    <meta charset="utf-8">
    <meta name="viewport" content="user-scalable=no">
	<div id='wx_pic' style='margin:0 auto;display:none;'>
<img src='/games/znm123/znm123.jpg' />
</div>
    <title>找你妹-空中传媒</title><meta name="x-author" content="HW1100">
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="screen-orientation" content="portrait" />
    <meta name="x5-fullscreen" content="true" />
    <meta name="360-fullscreen" content="true" />
	<link rel="shortcut icon" href="/games/znm123/icon.png">
	<link rel="icon" href="/games/znm123/icon.png">
	<link type="text/css" href="/games/znm123/common.css" rel="stylesheet" />
	<script type="text/javascript" src="/games/znm123/zepto.min.js"></script>
	<script type="text/javascript" src="/js/jquery-2.1.4.min.js"></script> 
	<script type="text/javascript" src="/layer/layer.js"></script>
	<script src="/games/znm123/common.js"></script>

    <style>
        body {
            text-align: center;
            background: #000000;
            padding: 0;
            border: 0;
            margin: 0;
            height: 100%;
        }

        html {
            -ms-touch-action: none; /* Direct all pointer events to JavaScript code. */
        }

        div, canvas {
            display: block;
            margin: 0 auto;
            padding: 0;
            border: 0;
        }
    </style>
</head>

	

    <div style="width: 500px; height: 700px; background: black; position: relative;" id="gameDiv">
        <canvas id="gameCanvas" width="500" height="700" style="background-color: #000000"></canvas>
    </div>
	<input id="bt-game-id" type="hidden" value="29-znm">

    <script>var document_class = "ZhaoNiMei";</script>
    <script src="/games/znm123/launcher/egret_require.js"></script>
    <script src="/games/znm123/launcher/egret_loader.js"></script>
    <script src="/games/znm123/launcher/game-min.js"></script>
    <script>
	   function preLoadImg(url){
		   var img1 = new Image();
		   img1.src = url;
		   img1.onload = function(){
			   
			   
		   }
	   }
	   preLoadImg();
    
        setTimeout(function () {
        	preLoadImg("http://7xugu1.com1.z0.glb.clouddn.com/gameCompletePlug.jpg");
        	preLoadImg("http://7xugu1.com1.z0.glb.clouddn.com/light.png");
        	preLoadImg("http://7xugu1.com1.z0.glb.clouddn.com/banner.gif");
        	preLoadImg("http://7xugu1.com1.z0.glb.clouddn.com/lifeLoveSolid.png");
        	preLoadImg("http://7xugu1.com1.z0.glb.clouddn.com/lifeLoveHollow.png");
        	egret_h5.startGame();
        }, 500);
        function submitScore(score){
        	var status = getStatus();
        	if(status==0){
        		layer.open({
    				title:false,
    				type:2,
    				area:["80%","70%"],
    				shade:[0.1,'#000',true],
    				skin:"plugclass",
    				content:["/dekornHandle/invitationPlug?gameId=1&type=1&gameType=1&passScore="+score],
    				fadeIn:1000,
    				shift:10,
    				closeBtn:0
    			});
        	}else if(status==1){
        		var dekornId = getDekornId();
        		var takepartId = getTakepartId();
        		layer.open({
    				title:false,
    				type:2,
    				area:["80%","70%"],
    				shade:[0.1,'#000',true],
    				skin:"plugclass",
    				content:["/view/dekornHandle/dekornResult?dekornId="+dekornId+"&score="+score+"&takepartId="+takepartId],
    				fadeIn:1000,
    				shift:10,
    				closeBtn:0
    			});
        	}
        }
    </script>
    <script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
    <div class="" style="display:none;">

    </div>
</tiles:putAttribute>
</tiles:insertDefinition>

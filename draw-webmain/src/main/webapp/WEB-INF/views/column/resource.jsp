<link rel="stylesheet" href="/css/style1.0.css"/>
<link rel="stylesheet" href="/css/core.css"/>

<link rel="stylesheet" href="/css/swiper.min.css"/>

<link rel="stylesheet" href="/css/jquery-ui.min.css"/>

<link rel="stylesheet" href="/font-awesome-4.7.0/css/font-awesome.min.css"/>

<link rel="stylesheet" href="/fakeLoader/css/fakeLoader.css">

<link rel="stylesheet" href="/barrager/dist/css/barrager.css"></link>

<link rel="stylesheet" href="/layer/mobile/need/layer.css"></link>

<link rel="stylesheet" href="/ystep/css/ystep.css"></link>

<!-- <link rel="stylesheet" href="/css/bootstrap.min.css"></link>-->

<script type="text/javascript" src="/js/jquery-2.1.4.min.js"></script>

<script type="text/javascript" src="/ystep/js/ystep.js"></script>


<script type="text/javascript" src="/js/jquery.easing.1.3.js"></script>

<!--  <script src="/jquery-validation-1.14.0/lib/jquery.js"></script> -->

<script src="/toolbar/jquery.toolbar.js"></script>

<script type="text/javascript" src="/layer/mobile/layer.js"></script>

<script src="/fakeLoader/js/fakeLoader.min.js"></script>

<script src="/js/myscript1.0.js"></script>

<script src="/js/plug.js"></script>

<script src="/js/jquery-ui.min.js"></script>

<!--<script src="/js/bootstrap.min.js"></script>-->

<script src="/util/flowJS.js"></script>

<script src="/js/jquery.barrager.js"></script>


<script src="/js/swiper.min.js"></script>

<script src="/js/jquery.lazy.js"></script>

<script src="/js/jq_scroll.js"></script>

<script src="/js/skip.js"></script>

<script src="/js/jump.js"></script>

<script src="/js/jquery.event.swipe.js"></script>

<script src="/js/jquery.tabso_yeso.js"></script>

<script src="/js/waterbubble.js"></script>

<script src="/raty/jquery.raty.js"></script>

<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>

<script src="/js/model/addDraw.js"></script>

<script src="/js/model/drawInfo.js"></script>

<script src="/js/model/attrPlug.js"></script>

<script src="/js/model/modelPlug.js"></script>

<script src="/js/model/waitProgress.js"></script>

<script src="/js/model/battleMainPlug.js"></script>

<script src="/js/model/battleInfoPlug.js"></script>

<script src="/js/model/progressScore.js"></script>

<script src="/js/layer/battleInfoLayer.js"></script>

<script src="/js/layer/progressScoreLayer.js"></script>


<script type="text/javascript">


	var layerScript = "/layer/mobile/layer.js";

	var fakeLoaderScript = "/fakeLoader/js/fakeLoader.min.js";

	var myscriptScript = "/js/myscript1.0.js";

	var plugScript = "/js/plug.js";

//	var jqueryUiMinScript = "";

	var waterbubbleScript = "/js/waterbubble.js";

	var flowJSScript = "/util/flowJS.js";

	var barragerScript = "/js/jquery.barrager.js";


	var swiperScript = "/js/swiper.min.js";

	var lazyScript = "/js/jquery.lazy.js";

	var jqScrollScript = "/js/jq_scroll.js";

	var skipScript = "/js/skip.js";

	var jumpScript = "/js/jump.js";

	var jqueryEventSwipeScript = "/js/jquery.event.swipe.js";

	var jqueryTabsoYeso = "/js/jquery.tabso_yeso.js";

	var jqueryRaty = "/raty/jquery.raty.js";

	var jweixinScript = "http://res.wx.qq.com/open/js/jweixin-1.0.0.js";


	var array = new Array();
//	array.push(layerScript);
//	array.push(fakeLoaderScript);
//	array.push(myscriptScript);
//	array.push(plugScript);
//  array.push(jqueryUiMinScript);
//	array.push(flowJSScript);
//	array.push(barragerScript);
	array.push(waterbubbleScript);
//	array.push(swiperScript);
//	array.push(lazyScript);
//	array.push(jqScrollScript);
//	array.push(skipScript);
//	array.push(jumpScript);
//	array.push(jqueryEventSwipeScript);
//	array.push(jqueryTabsoYeso);
//	array.push(jqueryRaty); 
//	array.push(jweixinScript);

	var callbackArray = new Array();
	var flag = false;
	function loadScript(callback){
		callbackArray.push(callback);
		if(flag){
			return;
		}
		flag = true;
		var length = array.length;

		var index = 0;
		for(var i = 0;i<length;i++){
		
			jQuery.getScript(array[i],function(data){
				
				index++;
				if(callbackArray&&callbackArray.length>0){
					if(index==length){

						for(var k=0;k<callbackArray.length;k++){
							var callback = callbackArray[k];
							$(document).ready(function(){
								callback.call();
							});
						}
						
					}
				}
			});
		}
		
	}
	//黄色小旋风，提示旋转
	function getRotating(){
		var rotating = "http://onluguho9.bkt.clouddn.com/rotating.png";
		return rotating;
	}
	
	function getLifeLoveSolid(){
		var lifeLoveSolid = "http://7xugu1.com1.z0.glb.clouddn.com/lifeLoveSolid.png";
		return lifeLoveSolid;
	}
</script>








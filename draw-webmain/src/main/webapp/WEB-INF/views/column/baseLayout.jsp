<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<div class="loading">
		<img src="/imgs/loading.gif">
</div>

<div class="center"><div class="toast" style="display: none;">余额不足，请稍后再试</div></div>

<input name="signature" value="${signature}" type="hidden"/>
<input name="noncestr" value="${noncestr}" type="hidden"/>
<input name="appId" value="${appId}" type="hidden"/>
<input name="datetime" value="${datetime}" type="hidden"/>

<input name="webPath" value="${contextPath}" type="hidden"/>
    	


<style type="text/css">

	.center{
		position: fixed;
	    left: 50%;
	    top: 50%;
	    -webkit-transform: translate(-50%, -50%);
	    transform: translate(-50%, -50%);
	    z-index: 1000000;
		
	}
	.toast{
		background-color: black;
		color: white;
		
		text-align: center;
		
		
		padding-left:15px;
		padding-right:15px;
		
		padding-top:5px;
		padding-bottom:5px;
		
		border-radius:5px;
		
		display: block;
		
	}

	.loading{
		position: fixed;
		z-index: 11111;
		width:100%;
		height: 10000px;
		text-align: center;
		top:-100px;
		background-color: RGBA(0,0,0,0.1);
		padding-top:300px;
		
		
	}
	.loading img{
		width:50px;
	}

</style>


<input name="shareTitle" value="${shareTitle}"/>
<input name="shareInstruction" value="${shareInstruction}"/>
<input name="shareUrl" value="${shareUrl}"/>
<input name="shareImg" value="${shareImg}"/>
<input name="shareType" value="${shareType}"/>
<input name="shareDataUrl" value="${shareDataUrl}"/>



<script type="text/javascript">
	/*获取分享信息*/
	
	function getShareTile(){
		return $("input[name=shareTitle]").val();
	}
	
	function getShareInstruction(){
		return $("input[name=shareInstruction]").val();
	}
	
	function getShareUrl(){
		return $("input[name=shareUrl]").val();
	}
	
	function getShareImg(){
		return $("input[name=shareImg]").val();
	}
	
	function getShareType(){
		return $("input[name=shareType]").val();
	}
	
	function getShareDataUrl(){
		return $("input[name=shareDataUrl]").val();
	}


	function showToast(msg,timeLong){
		if(!timeLong){
			timeLong = 1500;
		}
		$(".toast").text(msg);
		$(".toast").css("display","block");
		var interval = window.setInterval(function(){
			$(".toast").css("display","none");
			window.clearInterval(interval);
		},timeLong);
	}
	
	
	function getSignature(){
		return $("input[name=signature]").val();
	}
	
	function getNoncestr(){
		return $("input[name=noncestr]").val();
	}
	
	function getAppId(){
		return $("input[name=appId]").val();
	}
	
	function getDatetime(){
		return $("input[name=datetime]").val();
	}


	function showLoading(flag){
		$(".loading").css("display","block");
		
		if(flag){
			$(document).ready(function(){
				$(".loading").click(function(){
					hideLoading();
				});
			});
		}
	}
	
	function getWebpath(){
		var webPath = $("input[name='webPath']").val();
		return webPath;
	}
	
	function hideLoading(){
		$(".loading").css("display","none");
	}
	
	$(document).ready(function(){
		hideLoading();
		$(".pay_check_detail").animate({
			bottom:0
		},300);
	});
	
	$(document).ready(function(){
		wxConfig(getAppId(),getSignature(),getNoncestr(),getDatetime());
		wx.ready(function(){
			var title = getShareTile();
			var instruction = getShareInstruction();
			var shareUrl = getShareUrl();
			shareUrl = getWebpath()+shareUrl;
			var shareImg = getShareImg();
			var shareType = getShareType();
			wxOnMenuShareAppMessage(title,instruction,shareUrl,shareImg,shareType);
			wx.hideMenuItems({
			    menuList: ["menuItem:copyUrl","menuItem:exposeArticle","menuItem:setFont","menuItem:readMode","menuItem:originPage","menuItem:share:email","menuItem:openWithQQBrowser","menuItem:openWithSafari"] // 要隐藏的菜单项，只能隐藏“传播类”和“保护类”按钮，所有menu项见附录3
			});
			wx.showMenuItems({
	            menuList: [
	                "menuItem:profile",// 添加查看公众号
	                "menuItem:addContact"
	            ]
	        	});
		});
		
		
		$("img.lazy").lazyload({
	        effect: "fadeIn",
	        threshold : 200
		});
		$("img.lazy:eq(0)").attr('src',$("img.lazy:eq(0)").attr('data-original'));
	});
	
	
</script>
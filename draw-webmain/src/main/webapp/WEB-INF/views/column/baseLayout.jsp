<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<div class="loading">
		<img src="/imgs/loading.gif">
</div>

<div class="errorToast"  style="display: none;">发生了错误</div>


<div class="linkGuid"  style="display: none;" onclick="javascript:hideLinkGuid();">
	<div class="linkGuid_img">
		<img src="/imgs/arrow.png"></img>
		<div class="linkGuid_img_content">分享至朋友圈或发送给好友<br/>咻的一下就来人了</div>
	</div>
	<div class="linkGuid_content">
		分享的曙光
	</div>
</div>

	<div class="redPacketTypes">
		<ul>
			<li onclick="skipToSubject(0,0,1,0,0);">
				<div class="redPacketTypesIcon"><span class="fa fa-question-circle-o"></span></div>
				<div class="redPacketTypesFont">问答红包</div>
			</li>
			<li onclick="skipToSubject(0,1,1,0,0);">
				<div class="redPacketTypesImg">
					<img alt="" src="/imgs/competition.jpg">
				</div>
				<div class="redPacketTypesFont">竞答红包</div>
			</li>
		</ul>
	</div>


<div class="toast" style="display: none;">余额不足，请稍后再试</div>

<input name="signature" value="${signature}" type="hidden"/>
<input name="noncestr" value="${noncestr}" type="hidden"/>
<input name="appId" value="${appId}" type="hidden"/>
<input name="datetime" value="${datetime}" type="hidden"/>

<input name="webPath" value="${contextPath}" type="hidden"/>
    	


<style type="text/css">
	.toast{
		background-color: black;
		color: white;
		
		text-align: center;
		
		position: fixed;
		padding-left:15px;
		padding-right:15px;
		
		padding-top:5px;
		padding-bottom:5px;
		
		border-radius:5px;
		
		display: block;
		
		z-index: 10000000000000;
		left: 50%;
	    top: 50%;
	    -webkit-transform: translate(-50%, -50%);
	    transform: translate(-50%, -50%);
	}

	.loading{
		position: fixed;
		z-index: 10000000000000;
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
	
	.errorToast{
		background-color: RGBA(250,0,0,0.1);
		
		text-align: center;
		
		padding-top: 15px;
		
		padding-bottom: 15px;
		
		color: RGBA(214,143,72,1);
	}

</style>


<input name="shareTitle" value="${shareTitle}" type="hidden"/>
<input name="shareInstruction" value="${shareInstruction}" type="hidden"/>
<input name="shareUrl" value="${shareUrl}" type="hidden"/>
<input name="shareImg" value="${shareImg}" type="hidden"/>
<input name="shareType" value="${shareType}" type="hidden"/>
<input name="shareDataUrl" value="${shareDataUrl}" type="hidden"/>



<script type="text/javascript">
	function showLinkGuid(content,imgContent){
		$(".linkGuid").css("display","block");
		
		if(content){
			$(".linkGuid_content").text(content);
		}
		
		if(imgContent){
			$(".linkGuid_img_content").text(imgContent);
		}
		
	}
	
	function hideLinkGuid(){
		$(".linkGuid").css("display","none");
	}
	
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
	
	function showErrorToast(msg){
		$(".errorToast").css("display","block");
		
		if(msg){
			$(".errorToast").text(msg);
		}
		
	}
	
	function hideErrorToast(){
		$(".errorToast").css("display","none");
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
	
	function showRedPacketTypes(){
		$(".redPacketTypes").animate({
			bottom:0
		},1000,function(){
			$(".container").click(function(){
				hideRedPacketTypes();
			});
		});
		

		
	}
	
	function hideRedPacketTypes(){
		$(".redPacketTypes").animate({
			bottom:-200
		},2000);
		
		$(".container").unbind("click");
	}
	
	$(document).ready(function(){
		hideLoading();
		
		$(".pay_check_detail").animate({
			bottom:0
		},300);
	});
	
	function shareInit(callback){
		var title = getShareTile();
		var instruction = getShareInstruction();
		var shareUrl = getShareUrl();
		shareUrl = getWebpath()+shareUrl;
		var shareImg = getShareImg();
		var shareType = getShareType();
		wxOnMenuShareAppMessage(title,instruction,shareUrl,shareImg,shareType,null,callback);
		wx.hideMenuItems({
		    menuList: ["menuItem:copyUrl","menuItem:exposeArticle","menuItem:setFont","menuItem:readMode","menuItem:originPage","menuItem:share:email","menuItem:openWithQQBrowser","menuItem:openWithSafari"] // 要隐藏的菜单项，只能隐藏“传播类”和“保护类”按钮，所有menu项见附录3
		});
		wx.showMenuItems({
            menuList: [
                "menuItem:profile",// 添加查看公众号
                "menuItem:addContact"
            ]
        });
	}
	
	$(document).ready(function(){
		wxConfig(getAppId(),getSignature(),getNoncestr(),getDatetime());
		
		
		
		$("img.lazy").lazyload({
	        effect: "fadeIn",
	        threshold : 200
		});
		
		try{
			$("img.lazy:eq(0)").attr('src',$("img.lazy:eq(0)").attr('data-original'));
			$("img.lazy:eq(1)").attr('src',$("img.lazy:eq(1)").attr('data-original'));
			$("img.lazy:eq(2)").attr('src',$("img.lazy:eq(2)").attr('data-original'));
			$("img.lazy:eq(3)").attr('src',$("img.lazy:eq(3)").attr('data-original'));
			$("img.lazy:eq(4)").attr('src',$("img.lazy:eq(4)").attr('data-original'));
		}catch(e){
			
		}
		
	});
	
	
</script>
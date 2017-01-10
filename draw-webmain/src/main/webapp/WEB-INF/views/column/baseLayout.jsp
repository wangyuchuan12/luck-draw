<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<div class="loading">
		<img src="/imgs/loading.gif">
</div>

<input name="signature" value="${signature}" type="hidden"/>
<input name="noncestr" value="${noncestr}" type="hidden"/>
<input name="appId" value="${appId}" type="hidden"/>
<input name="datetime" value="${datetime}" type="hidden"/>

<input name="webPath" value="${contextPath}" type="hidden"/>
    	


<style type="text/css">
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

<script type="text/javascript">
	
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
	});
	
	
</script>
<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<div class="loading">
		<img src="/imgs/loading.gif">
</div>

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
	
	function hideLoading(){
		$(".loading").css("display","none");
	}
	
	$(document).ready(function(){
		hideLoading();
	});
	
	
</script>
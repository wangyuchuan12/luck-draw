<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="frameLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
<tiles:putAttribute name="body">
	<div class="personal_center_header">
		<div class="personal_center_header_title">个人中心</div>
		<div class="personal_center_header_img">
			<img src="${userInfo.headimgurl}"/>
		</div>
		<div class="personal_center_header_name">${userInfo.nickname}</div>
		
		
		<div class="personal_center_header_money">

			<div class="personal_center_header_money_type">总余额</div>
			
			<div class="personal_center_header_money_number">${drawUser.amountBalance}元</div>
		</div>
	</div>
	
	<div class="personal_center_content">
		<div class="personal_center_content_list">

			<div class="personal_center_content_item" id="takeOut">
				<i class="fa fa-life-ring i" style="background-color: red;"></i>
				<span class="span">提现</span>
				
				<span class="span2">微信提现</span>
				
				<span class="span_gt">&gt;</span>
			</div>
			
			
			<div class="personal_center_content_item" id="takeIn">
				<i class="fa fa-life-ring i" style="background-color: green;"></i>
				<span class="span">充值</span>
				
				<span class="span2">微信充值</span>
				
				<span class="span_gt">&gt;</span>
			</div>
		</div>
	
	</div>
			
	<script type="text/javascript">
		$("#takeOut").click(function(){
			skipToUrl("/view/draw/personal_center/takeOut");
		});
		
		$("#takeIn").click(function(){
			skipToUrl("/view/draw/personal_center/takeIn");
		});
		
		$(document).ready(function(){
			selectMain("main_personal_center");
		});
	
	</script>
</tiles:putAttribute>
</tiles:insertDefinition>

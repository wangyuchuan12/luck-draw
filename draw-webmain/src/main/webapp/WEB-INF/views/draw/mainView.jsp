<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="frameLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
<tiles:putAttribute name="body">
	<div class="swiper-container swiper-container-horizontal">
        <div class="swiper-wrapper" style="transition: 0ms; -webkit-transition: 0ms; -webkit-transform: translate3d(0px, 0px, 0px);">
             <c:forEach items="${mainImgs}" var="mainImg">
             	<div class="swiper-slide swiper-slide-active" style="width: 98%;margin-left: 0px;margin-right: 0px;">
					<a href="${mainImg.href}"><img data-original="${mainImg.imgUrl}" src="/imgs/loading.gif" style="height:170px;width:100%;margin: 0px auto;" class="lazy"></a>
            	</div>
             
             </c:forEach>
        </div>
		<div class="swiper-pagination swiper-pagination-clickable"><span class="swiper-pagination-bullet swiper-pagination-bullet-active"></span><span class="swiper-pagination-bullet"></span><span class="swiper-pagination-bullet"></span><span class="swiper-pagination-bullet"></span></div>
	</div>
	
	<div class="main_room">
		<div class="main_room_head">热门房间</div>
		
		<div class="main_room_list">
			<ul>
				<c:forEach items="${mainRooms}" var="mainRoom">
					<li onclick="skipToRoomInfo('${mainRoom.id}')">
						<img src="${mainRoom.imgUrl}">
						<span>${mainRoom.name}</span>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	
	<div class="main_red_pack">
		<div class="main_room_head">热门红包</div>
		
		<div class="main_packet_list">
			<ul>
			
				<c:forEach items="${mainRedPackets}" var="mainRedPacket">
						<li  onclick="skipToRedPackInfo('${mainRedPacket.id}')">
						
							<div class="main_packet_list_img">
								<img data-original="${mainRedPacket.imgUrl}" src="/imgs/redpack.jpg" class="lazy">
							</div>
							
							
							
							<div class="main_packet_list_question overflow1">${mainRedPacket.question}</div>
							
							<div class="main_Packet_list_content" >
								<img data-original="${mainRedPacket.userImgUrl}" src="/imgs/user.jpg" class="lazy">
								<div class="main_Packet_list_content_detail">
									<div class="main_packet_list_nickname overflow1">${mainRedPacket.nickname}</div>
									<div class="main_packet_list_amount">金额<span>${mainRedPacket.amount}</span>元</div>
									<div class="main_packet_list_num">已参与<span>${mainRedPacket.takePartCount}</span>人</div>
								</div>
							</div>
						</li>
				</c:forEach>
				
			</ul>
		</div>
	</div>
	
	
	
			
	<script type="text/javascript">
		var swiper = new Swiper('.swiper-container', {
	        pagination: '.swiper-pagination',
	        paginationClickable: true,
	        speed:1000,
	        spaceBetween:1,
	        centeredSlides: true,
	        autoplay: 5000,
	        autoplayDisableOnInteraction: false
	    });
		$(document).ready(function(){
			selectMain("main_home");
		});
		
	</script>
</tiles:putAttribute>
</tiles:insertDefinition>

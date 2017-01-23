<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="infoLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
<tiles:putAttribute name="body">


<div class="ondisplay">

	  
	  <section title=".roundedOne">
	    <!-- .roundedOne -->
	    <div class="roundedOne" id="remindDiv">
	      <input type="checkbox" id="roundedOne" name="remind" />
	      <label></label>
	    </div>
	    
	    
	    
	  </section>
	  
	  <div class="roundOneLabel">红包提醒</div>
	  
	 
	</div>
	<div class="luck_room_headImg">
		<img src="${drawRoomInfo.imgUrl}">
	</div>
	
	

	<div class="luck_room_members">

		<div class="luck_room_members_title">全部成员</div>
		<div class="luck_room_member_list">
			<ul>
				<c:forEach items="${drawRoomInfo.drawRoomMembers}" var="member">
					<li>
						<img src="${member.imgUrl}"/>
						<span>${member.name}</span>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div class="luck_room_packages">
		<div class="luck_room_members_title">红包列表</div>
		
		<div class="luck_room_package_list">
			<ul>
				<c:forEach items="${packets.redPacketVos}" var="packet">
					<li onclick="skipToRedPackInfo('${packet.id}')">
						<div class="luck_room_package_item_info">
							<div class="luck_room_package_item_info1">
								<img src="${packet.userImgUrl}">
								
								<div class="luck_room_package_item_info2">
									<img  src="/imgs/redpack.jpg">
									<div class="luck_room_package_item_info2_block">
										<div class="luck_room_package_item_info2_name"><b>${packet.nickname}发起</b></div>
										<div class="luck_room_package_item_info2_title">${packet.question}</div>
	
									</div>
									<div class="luck_room_package_item_info2_money">金额：${packet.amount}元</div>
								</div>
							</div>
						
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	
	<input name="bakRoomId" value="${drawRoomInfo.id}" type="hidden"/>
	
	<input name="bakIsInRoom" value="${drawRoomInfo.isInRoom}" type="hidden"/>
	
	<input name="bakVerifyType" value="${drawRoomInfo.verifyType}" type="hidden"/>
	
	<input name="bakVerifyQuestion" value="${drawRoomInfo.verifyQuestion}" type="hidden"/>
	
	<input name="subscribe" value="${userInfo.subscribe}" type="text"/>
	
	<input name="remind" value="${drawRoomInfo.remind}" type="text"/>
	
	<script type="text/javascript">
		$(document).ready(function(){
			setRoomId($("input[name=bakRoomId]").val());
			setIsInRoom($("input[name=bakIsInRoom]").val());
			
			setVerifyType($("input[name=bakVerifyType]").val());
			
			setVerifyQuestion($("input[name=bakVerifyQuestion]").val());
			
			
			var isInRoom = getIsInRoom();
			isInRoom = parseInt(isInRoom);
			if(isInRoom!=1){
				joinRoom();
			}
			$("#remindDiv").click(function(){
				var subscribe = $("input[name=subscribe]").val();
				
				subscribe = parseInt(subscribe);
				
				if(subscribe==0){
					layer.open({
						content:"/view/draw/personal_center/qrcode"
					});
				}
			});
		});
		
		function initRemind(){
			var remind = $("input[name=remind]").val();
			remind = parseInt(remind);
			
			if(remind==1){
				$(".roundedOne").addClass("roundedOneCheckStyle");
			}else{
				$(".roundedOne").removeClass("roundedOneCheckStyle");
			}
		}
	
		
		function drawRoomMemberAddListener(img,name){
			
			var content = "<li>"+
						  "<img src='"+img+"'/>"+
						  "<span>"+name+"</span></li>";
			$(".luck_room_member_list ul").append(content);
		}
	</script>
			
</tiles:putAttribute>
</tiles:insertDefinition>

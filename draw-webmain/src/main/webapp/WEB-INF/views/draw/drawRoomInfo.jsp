<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="infoLayout">
<tiles:putAttribute name="title">${title}</tiles:putAttribute>
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
									<div class="luck_room_package_item_info2_money">
										金额：
										<c:if test="${packet.isAmountDisplay==1}">${packet.amount}</c:if>
										<c:if test="${packet.isAmountDisplay!=1}">****</c:if>
										元
										<c:if test="${packet.isReceive==1}">
											<span style="color:red">已领取</span>
										</c:if>
										
										<c:if test="${packet.isReceive!=1}">
											<c:if test="${packet.isTimeout==1}">
												<span style="color:red">已超时</span>
											</c:if>
											
											<c:if test="${packet.isPay!=1}">
												<span style="color:red">未支付</span>
											</c:if>
										</c:if>
										
									</div>
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
	
	<input name="subscribe" value="${userInfo.subscribe}" type="hidden"/>
	
	<input name="isRemind" value="${drawRoomInfo.remind}" type="hidden"/>
	
	<input name="memberId" value="${drawRoomInfo.currentMemberId}" type="hidden"/>
	
	<input name="maxNum" value="${drawRoomInfo.maxNum}" type="hidden"/>
	
	<input name="memberCount" value="${drawRoomInfo.memberCount}" type="hidden"/>
	
	<div id="qrcode" style="display: none;">
		<img src="/imgs/qrcode.jpg">
		
		<div style="color:red;text-align:center;font-size:15px;position: relative;top:-10px;">你还未关注该公众号，扫描二维码关注</div>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function(){
			
			wx.ready(function(){
				shareInit();
			});
			
			setRoomId($("input[name=bakRoomId]").val());
			setIsInRoom($("input[name=bakIsInRoom]").val());
			
			setVerifyType($("input[name=bakVerifyType]").val());
			
			setVerifyQuestion($("input[name=bakVerifyQuestion]").val());
			setRoomMaxNum($("input[name=maxNum]").val())
			
			setRoomMemberCount($("input[name=memberCount]").val())
			
			var isInRoom = getIsInRoom();
			isInRoom = parseInt(isInRoom);
			if(isInRoom!=1){
				joinRoom();
			}
			initRemind();
			$("#remindDiv").click(function(){
				var subscribe = $("input[name=subscribe]").val();
				
				subscribe = parseInt(subscribe);
				
				var remind = $("input[name=isRemind]").val();
				
				remind = parseInt(remind);
				
				var bakRoomId = $("input[name=bakRoomId]").val();
				
				var memberId = $("input[name=memberId]").val();
				
				if(subscribe!=1&&remind!=1){
					layer.open({
						type:1,
						
						content:$("#qrcode")
					});
				}else if(subscribe==1){

					if(remind==0){
						remind=1;
					}else if(remind==1){
						remind=0;
					}
					var callback = new Object();
					$("input[name=isRemind]").val(remind);
					
					initRemind();
					callback.success = function(obj){
						if(obj.success){
							var remind = obj.data.remind;
						}else{
							if(remind==0){
								remind=1;
							}else if(remind==1){
								remind=0;
							}
							
							$("input[name=isRemind]").val(remind);
							
							initRemind();
						}
					}
					
					callback.failure = function(){
						if(remind==0){
							remind=1;
						}else if(remind==1){
							remind=0;
						}
						
						$("input[name=isRemind]").val(remind);
						
						initRemind();
					}
					
					var params = new Object();
					params.remind = remind;
					params.room_id = bakRoomId;
					params.rember_id = memberId;
					var url = "/api/draw/draw_room/set_remind";
					request(url,callback,params);
				}
			});
		});
		
		function initRemind(){
			var remind = $("input[name=isRemind]").val();
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

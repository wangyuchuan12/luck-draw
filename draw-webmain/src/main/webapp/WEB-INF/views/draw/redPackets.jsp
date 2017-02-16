<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="frameLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
<tiles:putAttribute name="body">

	<input type="hidden" name="type" value="${type}"></input>
	<div class="red_packet_list_head">
		<ul>
			<li id="red_packet_list_all" onclick="skipToRedpackList(0)">全部</li>
			<li id="red_packet_list_hand" onclick="skipToRedpackList(1)">我发起的</li>
			<li id="red_packet_list_takepart" onclick="skipToRedpackList(2)">我参与的</li>
		</ul>
	</div>
	
	<div class="red_packet_list_content">
		<ul>
		
			<c:forEach items="${drawList.redPacketVos}" var="item">
				<li onclick="skipToRedPackInfo('${item.id}','${item.type}');">
					<div class="red_packet_list_content_img">
					
						<c:if test="${item.imgUrl==null}">
							<img src="${item.userImgUrl}">
						</c:if>
						
						<c:if test="${item.imgUrl!=null}">
							<img src="${item.imgUrl}">
						</c:if>
						
					</div>
					
					<div class="red_packet_list_content_detail">
						<div class="red_packet_list_content_detail_question overflow1">
							<c:if test="${item.type==0}">
								${item.question}
							</c:if>
							<c:if test="${item.type==1}">
								${item.theme}
							</c:if>
						</div>
						<div class="red_packet_list_content_detail_type">
							<c:if test="${item.type==0}">
								问答红包
							</c:if>
							
							<c:if test="${item.type==1}">
								竞答红包
							</c:if>
						</div>
						<div class="red_packet_list_content_detail_time">${item.handTime}</div>

						<div class="red_packet_list_content_detail_receive">状态：
							<c:if test="${item.isReceive==1}"><span style="color: red">已领取</span></c:if>
							<c:if test="${item.isReceive==0}">
								<c:if test="${item.isPay==0}"><span style="color: red">未支付</span></c:if>
								<c:if test="${item.isPay==1}">
									<c:if test="${item.isTimeout==1}">
										<span style="color: red">已超时</span>
									</c:if>
									
									<c:if test="${item.isTimeout!=1}">
										<span style="color: red">进行中</span>
									</c:if>
								</c:if>
							</c:if>
						</div>
					</div>
					
					<div class="red_packet_list_content_amount">
						<c:if test="${item.isAmountDisplay==1}">
							${item.amount}
						</c:if>
						
						<c:if test="${item.isAmountDisplay!=1}">
							****
						</c:if>
					
					元</div>
				</li>
			</c:forEach>
			
		</ul>
	</div>
	<script type="text/javascript">
		$(document).ready(function(){
			
			wx.ready(function(){
				shareInit();
			});
			
			var type = $("input[name=type]").val();
			type = parseInt(type);
			
			if(type==0){
				$("#red_packet_list_all").css("border-bottom","1px solid red");
				$("#red_packet_list_all").css("color","red");
			}else if(type==1){
				$("#red_packet_list_hand").css("border-bottom","1px solid red");
				$("#red_packet_list_hand").css("color","red");
			}else if(type==2){
				$("#red_packet_list_takepart").css("border-bottom","1px solid red");
				$("#red_packet_list_takepart").css("color","red");
			}
			
			selectMain("main_redpack");
		});
		
	</script>
</tiles:putAttribute>
</tiles:insertDefinition>

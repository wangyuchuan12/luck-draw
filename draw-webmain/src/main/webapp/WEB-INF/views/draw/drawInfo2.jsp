<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
			
<div class="drawInfo">		
			
			<div id="drawInfoBack" style="background:RGBA(216,78,67,0.9);color:white;padding-left:10px;font-size: 25px;position: absolute;width:100%;z-index:100000">
				<span class="fa fa-angle-left"></span>
				
				<span style="float: right;top:5px;position: relative;right: 10px;background-color:RGBA(216,78,67,1);font-size: 10px;display: inline-block;padding-left:10px;padding-right: 10px;padding-top: 5px;padding-bottom: 5px;border-radius:7px;">分享</span>
			</div>
			<input name="accordStar" value="${coment.accordStar}" type="hidden"/>
		
			<input name="usefulStar" value="${coment.usefulStar}" type="hidden"/>
		
			<input name="interestingStar" value="${coment.interestingStar}" type="hidden"/>
			
			
			<input name="handTime" value="${result.data.handTime}" type="hidden"/>
			<input name="timeLong" value="${result.data.timeLong}" type="hidden"/>
			<input name="redPacketId" value="${result.data.id}" type="hidden"/>
			<input name="packetRoomId" value="${result.data.drawRoomId}" type="hidden"/>
			<input name="roomMemberId" value="${result.data.myRoomMemberId}" type="hidden"/>
			
			<input name="wordNum" value="${fn:length(result.data.answer)}" type="hidden"/>
			
			<input name="count" value="${result.data.count}" type="hidden"/>
			
			<input name="allowWrongCount" value="${result.data.allowWrongCount}" type="hidden"/>
			
			<input name="isReceive" value="${result.data.isReceive}" type="hidden"/>
			
			<input name="isTimeOut" value="${result.data.isTimeout}" type="hidden"/>
			
			<input name="isPay" value="${result.data.isPay}" type="hidden"/>
			
			<input name="isInRoom" value="${result.data.isInRoom}" type="hidden"/>
			
			<input name="type" value="${result.data.type}" type="hidden"/>
			
			<input name="isCreater" value="${result.data.isCreater}" type="hidden"/>
			
			<input name="isAmountDisplay" value="${result.data.isAmountDisplay}" type="hidden"/>
			
			<input name="amount" value="${result.data.amount}" type="hidden"/>
			
			<input name="shareNumShowAnswer" value="${result.data.shareNumShowAnswer}" type="hidden"/>
			
			<input name="shareCount" value="${result.data.shareCount}" type="hidden"/>
			
			<input name="isSetOption" value="${result.data.isSetOption}" type="hidden"/>
			
			<input name="isRoom" value="${result.data.isRoom}" type="hidden"/>
			
			<input name="getWisdom" value="${result.data.getWisdomCount}" type="hidden"/>
			
			<input name="firstVisit" value="${firstVisit}" type="hidden"/>
			
			<div class="luck_info_head">
				<div class="luck_info_head_background"></div>
				<div class="luck_info_head_title">问答红包</div>
				<div class="luck_info_head_img">
					<img src="${result.data.userImgUrl}"></img>
				</div>
				<div class="luck_info_head_name">${result.data.nickname}的红包</div>
			</div>
			
			
			
		 	<c:if test="${result.data.isImg==1}">
				<div class="luck_info_question_img">
					<img src="${result.data.imgUrl}"></img>
				</div>
			
			</c:if>
			
			
			<div class="luck_info_qusition">
				<div class="luck_info_qusition_title">
					<span>问：</span>
					<span>${result.data.question}</span>
					<c:if test="${result.data.isSetOption!=1}">
						<span> （${fn:length(result.data.answer)}个字）</span>
					</c:if>
				</div>
				<c:if test="${result.data.isTimeout==1}">
					<div class="luck_info_question_answer">答案:${result.data.answer}</div>
				</c:if>
			</div>
			
			<div class="luck_info_answer">
				<textarea id="luck_info_answer_input" placeholder="请输入问题的答案以领取红包"></textarea>
				<div class="luck_info_answer_button">提交答案</div>
			</div>
			
			<div class="luck_info_options">
				
				<div class="luck_info_options_list">
				
					
					<c:forEach items="${result.data.redPacketOptions}" var="redPacketOption">
						<div class="luck_info_option_item" onclick="checkOption('${redPacketOption.answer}')">${redPacketOption.answer}</div>
					
					</c:forEach>
				</div>
			</div>
			
			<div style="padding-left: 10px;background-color: white;">
				已领取${result.data.receiveNum}/${result.data.placesNum}个，共${result.data.receiveAmount}/${result.data.amount}元
				<c:if test="${result.data.amount<result.data.receiveAmount}">
					<c:if test="${result.data.isTimeout==1}">
					,红包已超时
					</c:if>
				</c:if>
				
				<c:if test="${result.data.receiveNum>=result.data.placesNum}">
					,红包已经领取完
				</c:if>
			
			</div>
			
			<div class="luck_info_situation">
					<div class="luck_info_situation_time">剩余<b id="luck_info_hour">00</b><b id="luck_info_min">00</b><b id="luck_info_second">00</b> 结束</div>
			</div>
			
			<div class="luck_info_question_prompt" style="display: none;">
				<div class="luck_info_question_prompt_name">提示：</div>
				<div class="luck_info_question_prompt_items">
						<!--  <div class="luck_info_question_prompt_item">耶路撒冷</div>
						<div class="luck_info_question_prompt_item">犹太全地</div>
						<div class="luck_info_question_prompt_item">大卫城</div>
						<div class="luck_info_question_prompt_item">耶路撒冷</div>
						<div class="luck_info_question_prompt_item">犹太全地</div>
						<div class="luck_info_question_prompt_item">大卫城</div>
						<div class="luck_info_question_prompt_item">耶路撒冷</div>
						<div class="luck_info_question_prompt_item">犹太全地</div>
						<div class="luck_info_question_prompt_item">大卫城</div>
						<div class="luck_info_question_prompt_add">新增提示</div>-->
				</div>
			</div>
			
			
			
			
			<c:if test="${result.data.redPacketTakepartMemberVos!=null&&result.data.redPacketTakepartMemberVos.size>0}">
			<div class="luck_info_records">
				<div class="luck_info_record_list">
				
					<c:forEach items="${result.data.redPacketTakepartMemberVos}" var="takepart">
						<div class="luck_info_record_item">
							<div class="luck_info_record_item_img">
								<img src="${takepart.headImg}"></img>
							</div>
							<div class="luck_info_record_item_nickname">${takepart.nickname}</div>
							<div class="luck_info_record_item_time">${takepart.takepartDateTime}</div>
							<div class="luck_info_record_item_content">回答：${takepart.answer}</div>
							<div class="luck_info_record_item_result">
								<c:if test="${takepart.isSuccess==0}">
									<em class="fa fa-close" style="color: red;"></em>
								</c:if>
								
								<c:if test="${takepart.isSuccess==1}">
									<em class="fa fa-check" style="color: green;"></em>
								</c:if>
								
							</div>
						</div>
					</c:forEach>
					
				</div>
			</div>
			</c:if>
			
			
			<div class="help" style="margin-top: 1px;display: none;">
				<ul>
					<li>
						<span class="fa fa-check-circle"></span>
						<span>超时退款</span>
					</li>
					
					<li>
						<span class="fa fa-check-circle"></span>
						<span>获奖金额按分值和加入顺序为优先级随机分配</span>
					</li>
					
					<c:if test="${redPacketInfo.entryFee!=null&&redPacketInfo.entryFee>0}">
						<li>
							<span class="fa fa-check-circle"></span>
							<span>参赛费：${redPacketInfo.entryFee}元，归发起人所有</span>
						</li>
					</c:if>
					
					
					<li>
						<span class="fa fa-check-circle"></span>
						<span>发起人可获取智慧豆数量=好评数*2</span>
					</li>
					
					<li>
						<span class="fa fa-check-circle"></span>
						<span>只有参赛人员才可以好评</span>
					</li>
				</ul>
		
			</div>
			
			<c:if test="${fn:length(takePartMembers.datas)>0}">
				<div class="view_luck_members_rank" style="display: none;">总参与 ${takePartCount}人</div>
			</c:if>
			
			<c:forEach items="${takePartMembers.datas}" var="takePartMember" varStatus="varStatus">
				<input name="rankImg" rank="${takePartMember.rank}" value="${takePartMember.headImg}" type="hidden"/>
				
				<div class="view_luck_member">
					<div class="view_luck_member_rank">
						${takePartMember.rank}	
					</div>
					
					<div class="view_luck_member_img">
						<img src="${takePartMember.headImg}">
					</div>
					
					
					
					<div class="view_luck_member_name2">
						<div class="view_luck_member_name2_nickname">${takePartMember.nickname}</div>
						<div class="view_luck_member_name2_prompt">
							<span>
								<c:if test="${takePartMember.isSuccess==1}">
									回答正确，领取${takePartMember.getAmount}元
								</c:if>
								
								<c:if test="${takePartMember.isSuccess==0}">
									<font color="red">回答错误</font>
								</c:if>
							</span>
						</div>
					</div>
					
					
					
					<div class="view_luck_member_result">
						<div style="color: black;font-size: 15px;">${takePartMember.answer}</div>
						
					</div>
					
					<div class="view_luck_member_takepart_time">${takePartMember.takepartDateTime}</div>
				</div>
			</c:forEach>
			
			<script type="text/javascript">
			
				var isEnd = false;
				function initDrawInfo(callback){
					
					
					
					
				}
			</script>


<div class="foot_button" style="display: none;">
			<ul>
			
				<c:if test="${result.data.isRoom==0}">
					<li style="width: 32%;" id="goodCommentButton">
						<span class="fa fa-thumbs-o-up"></span>
						<span>好评</span>
					</li>
					
					<li style="width: 32%;" id="badCommentButton">
						<span class="fa fa-thumbs-o-down"></span>
						<span>差评</span>
					</li>
					
					<li style="width: 32%;" onclick="showRedPacketTypes();">
						<span>
							<img src="/imgs/sendRedPacket.jpg"></img>
						</span>
						<span>我也发一个</span>
					</li>
				
				</c:if>
				
				<c:if test="${result.data.isRoom==1}">
				
					<li style="width: 23%;" id=goodCommentButton>
						<span class="fa fa-thumbs-o-up"></span>
						<span>好评</span>
					</li>
					
					<li style="width: 23%;" id="badCommentButton">
						<span class="fa fa-thumbs-o-down"></span>
						<span>差评</span>
					</li>
					<li style="width: 23%;" onclick="skipToRoomInfo('${redPacketInfo.drawRoomId}');">
						<span class="fa fa-users"></span>
						<span>进入房间</span>
					</li>
					
					<li style="width: 23%;" onclick="showRedPacketTypes();">
						<span>
							<img src="/imgs/sendRedPacket.jpg"></img>
						</span>
						<span>我也发一个</span>
					</li>
				</c:if>
			
				
				
			</ul>
		</div>
		
		
		
		<div class="red_packet_comment" id="red_packet_comment">
	<div class="red_packet_comment_header">
		<div class="red_packet_comment_header_buttom_left" id="comentButtonLeft">取消</div>
		<div class="red_packet_comment_header_buttom_right" id="comentButtonRight">确定</div>
	</div>
	<div class="red_packet_comment_star">
		<ul>
			<li>
				<div class="red_packet_comment_star_name">答案符合度</div>
				<div class="red_packet_comment_star_img" id="accordStar"></div>
			</li>
			
			<li>
				<div class="red_packet_comment_star_name">实用性</div>
				<div class="red_packet_comment_star_img" id="usefulStar"></div>
			</li>
			
			<li>
				<div class="red_packet_comment_star_name">有趣</div>
				<div class="red_packet_comment_star_img" id="interestingStar"></div>
			</li>
		</ul>
	</div>
	
	<div class="red_packet_comment_cotent">
		<div class="red_packet_comment_title">写评语</div>
		<textarea class="red_packet_comment_cotent_input" placeholder="请填写评语" name="redPacketComment">${coment.content}</textarea>
	</div>
</div>


<div class="red_packet_takepart" id="red_packet_takepart" style="display: none;">
	<div class="red_packet_takepart_amount">需要智慧豆：5颗，支付：${redPacketInfo.entryFee}元</div>
		<div>
			<div class="select_list_item" type=0 onclick="setPayType(0)">
		
				<em class="fa fa-check-square"  style="color: red;"></em>
       			<em class="fa fa-address-card" style="color: green;"></em>
       			<span class="select_list_item_name">余额支付（剩余：${account.amountBalance}元）</span>
      			</div>
      			
      			<div class="select_list_item" id="amountPayType" type=1 onclick="setPayType(1)">
      			
      				<em class="fa fa-square-o"></em>
       			<em class="fa fa-weixin" style="color: green;"></em>
        			<span class="select_list_item_name">微信支付</span>
       			</div>
      			
      		</div>
      		
     <div class="red_packet_takepart_button">确定</div>
</div>

</div>
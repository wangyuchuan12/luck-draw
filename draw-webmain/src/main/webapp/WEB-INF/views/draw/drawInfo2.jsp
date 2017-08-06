<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="resourceLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
<tiles:putAttribute name="body">


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
						<span> ${fn:length(result.data.answer)}个字</span>
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
			
			<div style="padding-left: 10px;">
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
			
			<div class="luck_info_question_prompt">
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
			
			
			<div class="help" style="margin-top: 1px;">
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
				<div class="view_luck_members_rank">总参与 ${takePartCount}人</div>
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
				$(document).ready(function(){
					$(".luck_info_answer_button").click(function(){
						submitAnswer();
					});
					
					
					function submitAnswer(){
						var roomId = $("input[name=packetRoomId]").val();

						var roomMemberId = $("input[name=roomMemberId]").val();
						
						var answer = $("#luck_info_answer_input").val();
						
						var answerLength = answer.length;
						
						var wordNum = $("input[name=wordNum]").val();
						
						wordNum = parseInt(wordNum);
						
						
						var count = $("input[name=count]").val();
						count = parseInt(count);
						
						var allowWrongCount = $("input[name=allowWrongCount]").val();
						allowWrongCount = parseInt(allowWrongCount);
						
						var isReceive = $("input[name=isReceive]").val();
						isReceive = parseInt(isReceive);
						
						
						var isPay = $("input[name=isPay]").val();
						
						isPay = parseInt(isPay);
						
						var isInRoom = $("input[name=isInRoom]").val();
						
						isInRoom = parseInt(isInRoom);
						
						var type = $("input[name=type]").val();
						
						type = parseInt(type);
						
						
						var isSetOption = $("input[name=isSetOption]").val();
						isSetOption = parseInt(isSetOption);
						
						if(type==0&&isInRoom==0){
							showToast("本红包属于房间专属红包，你尚未加入本房间，请先点击‘进入房间’按钮加入房间",5000);
							return;
						}
						
						if(isPay!=1){
							showToast("该红包尚未付款");
							return;
						}
						
						if(isReceive==1){
							showToast("该红包已经被领取");
							return;
						}
						if(!answer){
							showToast("答案不能为空");
							return;
						}
						
						if(answerLength!=wordNum&&isSetOption!=1){
							showToast("请输入"+wordNum+"个字");
							return;
						}
						
						if(isEnd){
							showToast("时间已结束");
							return;
						}
						
						
						var redPacketId = $("input[name=redPacketId]").val();
						var params = new Object();
						params.id = redPacketId;
						params.room_id = roomId;
						params.room_member_id = roomMemberId;
						params.answer = answer;
						var callback = new Object();
						showLoading();
						callback.success = function(obj){
							hideLoading();
							if(obj.success){
								alert(obj.msg);
								if(obj.data.isRight==1){
									
								}else{
									
									var count = $("input[name=count]").val();
									count = parseInt(count);
									count = count+1;
									
									$("input[name=count]").val(count);
									showToast("回答错误");
									
									$("#luck_info_answer_input").val("");
									
								}
							}else{
								alert(obj.errorMsg);
							}
						}
						
						callback.failure = function(obj){
							hideLoading();
							showToast("现在用户访问量过大，请稍后再试");
						}
						
						request("/api/draw/red_pack/answer",callback,params);
					}
				});
			</script>
			
</tiles:putAttribute>
</tiles:insertDefinition>


<div class="foot_button">
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


<div class="red_packet_takepart" id="red_packet_takepart">
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


<script type="text/javascript">
			$(document).ready(function(){
				hideProgress();
				
				initStar(); 
				
				$("#goodCommentButton").click(function(){
					
					var isCreater = $("input[name=isCreater]").val();
					
					if(isCreater==1){
						showToast("您是创建者，无法进行评论");
						return;
					}
					if($("input[name=status]").val()==1){
						showToast("已评论");
						return;
					}
					
					if($("input[name=isAnswer]").val()==0){
						showToast("你还未参加，不能评论");
						return;
					}
					$(".red_packet_comment").css("display","block");
					$("input[name=type]").val(0);
					$("#red_packet_comment").animate({
						top:0
					},1000,function(){
					});
					
					
					comment();
				});
				
				$("#badCommentButton").click(function(){
					
					var isCreater = $("input[name=isCreater]").val();
					if(isCreater==1){
						showToast("您是创建者，无法进行评论");
						return;
					}
					
					if($("input[name=status]").val()==1){
						showToast("已评论");
						return;
					}
					
					if($("input[name=isAnswer]").val()==0){
						showToast("你还未参加，不能评论");
						return;
					}
					
					$(".red_packet_comment").css("display","block");
					$("input[name=type]").val(1);
					$("#red_packet_comment").animate({
						top:0
					},1000,function(){
					});
					
					
					comment();
				});
				
				
				
				$(".red_packet_takepart_button").click(function(){
					payFee();
				});
				
				$("#comentButtonLeft").click(function(){
					$("#red_packet_comment").animate({
						top:800
					},1000,function(){
						$(".red_packet_comment").css("display","none");
					});
					
				});
				
				$("#comentButtonRight").click(function(){
					var accortStar = $("input[name=accordStar]").val();
					var usefulStar = $("input[name=usefulStar]").val();
					var interestingStar = $("input[name=interestingStar]").val();
					
					var redPacketComment = $("textarea[name=redPacketComment]").val();
					
					if(accortStar==0){
						showToast("请为符合度打分");
						return;
					}
					
					if(usefulStar==0){
						showToast("请为实用性打分");
						return;
					}
					
					if(interestingStar==0){
						showToast("请为有趣打分");
						return;
					}
					
					if(!redPacketComment){
						showToast("请填写评语");
						return;
					}
					
					var type = $("input[name=type]").val();
					
					var redPacketId = $("input[name=redPacketId]").val();
					
					var params = new Object();
					params.red_packet_id = redPacketId;
					params.useful_star = usefulStar;
					params.accord_star = accortStar;
					params.interesting_star = interestingStar;
					params.content = redPacketComment;
					params.type = type;
					
					var url = "/api/draw/red_pack/coment";
					
					var callback = new Object();
					
					callback.success = function(resp){
						
						alert(resp.errorMsg);
						if(resp.success){
							
							showToast("评论成功",3000);
							$("#red_packet_comment").animate({
								top:800
							},1000,function(){
								$(".red_packet_comment").css("display","none");
							});
							
							$("input[name=status]").val(1);
							if(type==0){
								$("input[name=goodNum]").val($("input[name=goodNum]").val()*1+1);
								
								
							}else if(type==1){
								$("input[name=badNum]").val($("input[name=badNum]").val()*1+1);
								
								var getWisdom = $("input[name=getWisdom]").val();
								getWisdom = parseInt(getWisdom);
								getWisdom = getWisdom+2;
								
								$("#getWisdomItemText").text(getWisdom+"颗");
							}
							comment();
							
						}else{
							showToast("网络繁忙，请稍后再试😊");
						}
					}
					request(url,callback,params)
				});
			
				$("#red_packet_takepart").css("bottom","-200px");
				$("body").css("padding-bottom","50px");
				
				$("body").css("background-color","white");
				$("#receiveButton").click(function(){
					var status=1;
					var problemId = $("input[name=firstProblemId]").val();
					var redPacketId = $("input[name=redPacketId]").val();
					skipToVieAnswerProblem(status,redPacketId,problemId,"");
				});
				document.addEventListener("touchstart",function(){
					
				},false);
				
				
				
				
				
				var callback = new Object();
				callback.end = function(){
					$("input[name=isTimeOut]").val(1);
					initView();
				}
				var handTime = $("input[name=handTime]").val();
				
				var timeLong = $("input[name=timeLong]").val();
				
				handTime = handTime.replace(/-/g,"/");
				initGroupInvalidDate(new Date(handTime),timeLong,".luck_info_situation_time",callback);
			});
			
			function initStar(){
				
				$.fn.raty.defaults.path="/raty/img";
				
				$("#publicCommend").raty({
					score:2,
					imgWidth:"10px",
					imgHeight:"10px",
					readOnly:true
				});
				
				$("#accordStar").raty({
					score:$("input[name=accordStar]").val(),
					size:50,
					click:function(num){
						$("input[name=accordStar]").val(num);
					}
				});
				
				$("#usefulStar").raty({
					score:$("input[name=usefulStar]").val(),
					size:50,
					
					click:function(num){
						$("input[name=usefulStar]").val(num);
					}
				});
				
				$("#interestingStar").raty({
					score:$("input[name=interestingStar]").val(),
					size:50,
					click:function(num){
						$("input[name=interestingStar]").val(num);
					}
				});
				
			}
		</script>




<script type="text/javascript">


function initDialog(){
	
	var firstVisit = $("input[name=firstVisit]").val();
	
	var isCreater = $("input[name=isCreater]").val();
	
	var getWisdom = $("input[name=getWisdom]").val();
	
	var isTimeOut = $("input[name=isTimeOut]").val();
	
	var rank = $("input[name=rank]").val();
	
	var takepartStatus = $("input[name=takepartStatus]").val();
	
	var memberRank1 = $("input[name=rankImg][rank=1]").val();
	
	var memberRank2 = $("input[name=rankImg][rank=2]").val();
	
	var memberRank3 = $("input[name=rankImg][rank=3]").val();
	
	var receiveAmount = $("input[name=receiveAmount]").val();
	
	rank = parseInt(rank);
	if(isTimeOut==0){
		if(isCreater==1&&firstVisit==1){
			showHappyAlert("恭喜您，创建红包成功，赠送您10颗智慧豆","确定",function(){
				showLinkGuid("好友好评一次，您能获得2颗智慧豆",null);
			});
		}else if(isCreater==1&&firstVisit!=1){
			if(getWisdom!=0){
				showSmartAlert("恭喜您，您的选手已经为您积累了"+getWisdom+"颗智慧豆","确定",function(){
					showLinkGuid("好友好评一次，您能获得2颗智慧豆",null);
				});
			}else{
				showLinkGuid("好友好评一次，您能获得2颗智慧豆",null);
			}
		}else if(isCreater==0&&firstVisit==1&&takepartStatus==1){
			showRankAlert("恭喜您，获得第"+rank+"名，"+receiveAmount+"元已收入钱包",memberRank1,memberRank2,memberRank3,1000);
		}
	}else{
		
		if(isCreater==1){
			showSmartAlert("红包已经超时，你获取了"+getWisdom+"颗智慧豆");
		}else{
			showSmartAlert("该红包已经超时，您获得"+rank+"名","确定");
		}
		
	}
	
	
}

function averageStarCount(){
	var accordStar1Num = $("input[name=accordStar1Num]").val();
	var accordStar2Num = $("input[name=accordStar2Num]").val();
	var accordStar3Num = $("input[name=accordStar3Num]").val();
	var accordStar4Num = $("input[name=accordStar4Num]").val();
	var accordStar5Num = $("input[name=accordStar5Num]").val();
	
	var usefulStar1Num = $("input[name=usefulStar1Num]").val();
	var usefulStar2Num = $("input[name=usefulStar2Num]").val();
	var usefulStar3Num = $("input[name=usefulStar3Num]").val();
	var usefulStar4Num = $("input[name=usefulStar4Num]").val();
	var usefulStar5Num = $("input[name=usefulStar5Num]").val();
	
	var interestingStar1Num = $("input[name=interestingStar1Num]").val();
	var interestingStar2Num = $("input[name=interestingStar2Num]").val();
	var interestingStar3Num = $("input[name=interestingStar3Num]").val();
	var interestingStar4Num = $("input[name=interestingStar4Num]").val();
	var interestingStar5Num = $("input[name=interestingStar5Num]").val();
	
	var starAll = accordStar1Num*1+accordStar2Num*2+accordStar3Num*3+accordStar4Num*4+accordStar5Num*5;
	starAll = starAll+usefulStar1Num*1+usefulStar2Num*2+usefulStar3Num*3+usefulStar4Num*4+usefulStar5Num*5;
	starAll  = starAll+interestingStar1Num*1+interestingStar2Num*2+interestingStar3Num*3+interestingStar4Num*4+interestingStar5Num*5;

	var numAll = accordStar1Num*1+accordStar2Num*1+accordStar3Num*1+accordStar4Num*1+accordStar5Num*1;

	numAll = numAll+usefulStar1Num*1+usefulStar2Num*1+usefulStar3Num*1+usefulStar4Num*1+usefulStar5Num*1;

	numAll  = numAll+interestingStar1Num*1+interestingStar2Num*1+interestingStar3Num*1+interestingStar4Num*1+interestingStar5Num*1;

	if(numAll==0){
		return 0;
	}else{
		return starAll/numAll;
	}
}

function comment(){
	var averageStar = averageStarCount();
	if(averageStar!=0){
		$("#publicCommend").raty({
			score:averageStar,
			imgWidth:"10px",
			imgHeight:"10px",
			readOnly:true
		});
	}else{
		$("#publicCommendItem").css("display","none");
	}
	
	var goodNum = $("input[name=goodNum]").val();
	var badNum = $("input[name=badNum]").val();
	
	if(goodNum==null||goodNum==0){
		$("#goodCommentButton span:nth-child(2)").text("好评");
	}else{
		$("#goodCommentButton span:nth-child(2)").text("好评"+goodNum);
	}
	
	if(badNum==null||badNum==0){
		$("#badCommentButton span:nth-child(2)").text("差评");
	}else{
		$("#badCommentButton span:nth-child(2)").text("差评"+badNum);
	}
}
$(document).ready(function(){
	
	//initDialog();
	comment();
	
});
</script>

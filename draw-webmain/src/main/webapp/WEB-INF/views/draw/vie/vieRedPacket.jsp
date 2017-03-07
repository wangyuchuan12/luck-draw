<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="resourceLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
<tiles:putAttribute name="body">

		<input name="firstProblemId" value="${firtProblem.id}" type="hidden"/>
		
		<input name="redPacketId" value="${redPacketInfo.id}" type="hidden"/>
		
		
		<input name="isTimeOut" value="${redPacketInfo.isTimeout}" type="hidden"/>
		<input name="handTime" value="${redPacketInfo.handTime}" type="hidden"/>
		<input name="timeLong" value="${redPacketInfo.timeLong}" type="hidden"/>
		
		<input name="amountBalance" value="${account.amountBalance}" type="hidden"/>
		
		<input name="entryFee" value="${redPacketInfo.entryFee}" type="hidden"/>
		
		<input name="payType" type="hidden"/>
		
		<input name="isRoom" value="${redPacketInfo.isRoom}" type="hidden"/>
		
		<input name="isEntryFee" value="${redPacketInfo.isEntryFee}" type="hidden"/>
		
		
		<input name="accordStar" value="${coment.accordStar}" type="hidden"/>
		
		<input name="usefulStar" value="${coment.usefulStar}" type="hidden"/>
		
		<input name="interestingStar" value="${coment.interestingStar}" type="hidden"/>
		
		<input name="type" value="${coment.type}" type="hidden"/>
		
		<input name="isAnswer" value="${redPacketInfo.isAnswer}" type="hidden"/>
		
		<input name="wisdomCount" value="${redPacketInfo.wisdomCount}" type="hidden"/>
		
		<input name="haveWisdomCount" value="${account.wisdomCount}" type="hidden"/>
		
		<input name="isWisdom" value="${redPacketInfo.isWisdom}" type="hidden"/>
		
		<input name="getWisdom" value="${redPacketInfo.getWisdomCount}" type="hidden"/>
		
		<c:if test="${coment!=null}">
			<input name="status" value="1" type="hidden"/>
		</c:if>
		
		<c:if test="${coment==null}">
			<input name="status" value="0" type="hidden"/>
		</c:if>
		
		<div class="luck_info_head">
			<div class="luck_info_head_background"></div>
			<div class="luck_info_head_title">竞答红包</div>
			<div class="luck_info_head_img">
				<img src="${redPacketInfo.userImgUrl}"></img>
			</div>
			<div class="luck_info_head_name">${redPacketInfo.nickname}的红包</div>
			<c:if test="${thisMember!=null}">
				<div class="luck_info_head_money"><span>
					<fmt:formatNumber type="number" maxFractionDigits="1" value="${thisMember.rightCount/(thisMember.rightCount+thisMember.wrongCount)*100}"></fmt:formatNumber>
					分</span><span>领取：${thisMember.getAmount}元</span></div>
					<div class="luck_info_head_evaluate">
						<c:if test="${takePartCount<5}">
							答对${thisMember.rightCount}题，用时${thisMember.timeLong}秒
						</c:if>
						<c:if test="${takePartCount>=5}">
							答对${thisMember.rightCount}题，用时${thisMember.timeLong}秒
							<c:if test="${(takePartCount-thisMember.rank+1)/takePartCount*100>40}">
								击败了
								<fmt:formatNumber type="number" value="${(takePartCount-thisMember.rank+1)/takePartCount*100}" maxFractionDigits="0"></fmt:formatNumber>
								%的选手
							</c:if>
							
						</c:if>
				 </div>
			</c:if>
			
		</div>
		
		<div class="vie_luck_info">
			<c:if test="${redPacketInfo.isImg==1}">
				<div class="vie_luck_info_img"><img alt="" data-original="${redPacketInfo.imgUrl}" src="/imgs/loading.jpg" class="lazy"></div>
			</c:if>
			
			<c:if test="${redPacketInfo.isImg==0}">
				<div class="vie_luck_info_img"><img alt="" src="/imgs/redpack.jpg"></div>
			</c:if>
			
			
			<div class="vie_luck_info_detail">
				<div class="vie_luck_info_detail_item">
					<img src="${drawUser.imgUrl}">
					
					<div class=vie_luck_info_detail_item_user>
						<span class="vie_luck_info_detail_item_user_name">${drawUser.nickname}</span>
						
						<c:if test="${redPacketInfo.isCreater==0}">
							<c:if test="${thisMember.takepartDateTime!=null}">
							<span class="vie_luck_info_detail_item_time">参赛时间：${thisMember.takepartDateTime}</span>
							</c:if>
							
							<c:if test="${thisMember.takepartDateTime==null}">
								<span style="color:red;display: block;padding-left: 5px;">未参加</span>
							</c:if>
						</c:if>
						
						<c:if test="${redPacketInfo.isCreater==1}">
							<span style="color:red;display:block;padding-left: 5px;">创建人</span>
						</c:if>
						
						
						<span class="vie_luck_info_detail_item_status" style="display:none;">未参赛</span>
					</div>
				</div>
				<div class="vie_luck_info_detail_item">
					<div class="vie_luck_info_detail_item_label">名称:</div>
					<div class="vie_luck_info_detail_item_text">${redPacketInfo.theme}</div>
				</div>
				
				<div class="vie_luck_info_detail_item">
					<div class="vie_luck_info_detail_item_label">已参加:</div>
					<div class="vie_luck_info_detail_item_text">${redPacketInfo.takePartCount}人</div>
				</div>
				
				<c:if test="${bestTakepartMember!=null}">
					<div class="vie_luck_info_detail_item">
						<div class="vie_luck_info_detail_item_label">最高分:</div>
						<div class="vie_luck_info_detail_item_text">${bestTakepartMember.rightCount}/${bestTakepartMember.rightCount+bestTakepartMember.wrongCount}题  ${bestTakepartMember.timeLong}秒</div>
					</div>
				</c:if>
				
				<div class="vie_luck_info_detail_item">
					<div class="vie_luck_info_detail_item_label">累积智慧豆:</div>
					<div class="vie_luck_info_detail_item_text" id="getWisdomItemText">${redPacketInfo.getWisdomCount}颗</div>
				</div>
				
				<div class="vie_luck_info_detail_item" id="publicCommendItem">
					<div class="vie_luck_info_detail_item_label">综合评分:</div>
					<div class="vie_luck_info_detail_item_text">
						<div id="publicCommend"></div>
					</div>
				</div>
				
			</div>
		
		</div>
		
		
		<c:if test="${redPacketInfo.isAnswer==1}">
			<div class="vieShowAnswerButton" onclick="skipVieAnswerResult('${redPacketInfo.id}')">查看答题结果</div>
		</c:if>
		
		<c:if test="${redPacketInfo.isPay==1&&
			redPacketInfo.isTimeout==0&&
			redPacketInfo.isCreater==0&&
			redPacketInfo.isAnswer==0&&
			redPacketInfo.receiveNum<redPacketInfo.placesNum}">
			<div class="vieShowAnswerButton" id="vieTakepartButton">
				<c:if test="${redPacketInfo.isWisdom==1}">
					参加（所需智慧豆：${redPacketInfo.wisdomCount}颗）
				</c:if>
				
				<c:if test="${redPacketInfo.isWisdom==0}">
					参加
				</c:if>
			</div>
		</c:if>
		<c:if test="${redPacketInfo.instruction!=null}">
			<div class="vieTakepartButtonInstruction">
				详情：${redPacketInfo.instruction}
			</div>
		</c:if>
		
		
		<div class="luck_info_situation">
			<div class="luck_info_situation_time">剩余<b id="luck_info_hour">00</b><b id="luck_info_min">00</b><b id="luck_info_second">00</b> 结束</div>
		</div>
		
		<div style="padding-left: 10px;">
			已领取${redPacketInfo.receiveNum}/${redPacketInfo.placesNum}个，共${redPacketInfo.receiveAmount}/${redPacketInfo.amount}元
			<c:if test="${redPacketInfo.amount<redPacketInfo.receiveAmount}">
				<c:if test="${redPacketInfo.isTimeout==1}">
				,红包已超时
				</c:if>
			</c:if>
			
			<c:if test="${redPacketInfo.receiveNum>=redPacketInfo.placesNum}">
				,红包已经领取完
			</c:if>
			
		</div>
		
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
		
		<div class="view_luck_members">
			<c:if test="${redPacketInfo.isAnswer==1}">
				<div class="view_luck_member" id="thisMember">
					<div class="view_luck_member_rank">
						<c:if test="${thisMember.rank!=null}">
							${thisMember.rank}
						</c:if>
						
						<c:if test="${thisMember.rank==null&&fn:length(takePartMembers.datas)>1}">
							${fn:length(takePartMembers.datas)}+
						</c:if>
					</div>
					
					<div class="view_luck_member_img">
						<img src="${thisMember.headImg}">
					</div>
		
					<div class="view_luck_member_name">${thisMember.nickname}</div>
					
					<div class="view_luck_member_result">
						<div class="view_luck_member_result_correct">${thisMember.rightCount}题/${thisMember.timeLong}秒</div>
					</div>
					
					<div class="view_luck_member_takepart_time">${thisMember.takepartDateTime}</div>
				</div>
			</c:if>
			
			
			<c:if test="${fn:length(takePartMembers.datas)>0}">
				<div class="view_luck_members_rank">排行榜，总参与 ${takePartCount}人</div>
			</c:if>
			<c:forEach items="${takePartMembers.datas}" var="takePartMember" varStatus="varStatus">
				
				
				<div class="view_luck_member">
					<div class="view_luck_member_rank">
						${takePartMember.rank}	
					</div>
					
					<div class="view_luck_member_img">
						<img src="${takePartMember.headImg}">
					</div>
					
					
					
					<div class="view_luck_member_name2">
									<div class="view_luck_member_name2_nickname">${takePartMember.nickname}</div>
									
									<div class="view_luck_member_name2_prompt">第${varStatus.index+1}名 <span>领取${takePartMember.getAmount}元</span></div>
					</div>
					
					
					
					<div class="view_luck_member_result">
						<div class="view_luck_member_result_correct">${takePartMember.rightCount}题/${takePartMember.timeLong}秒</div>
						
					</div>
					
					<div class="view_luck_member_takepart_time">${takePartMember.takepartDateTime}</div>
				</div>
			</c:forEach>
		</div>
		
		
		
		<div class="foot_button">
			<ul>
			
				<c:if test="${redPacketInfo.isRoom==0}">
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
				
				<c:if test="${redPacketInfo.isRoom==1}">
				
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
		
		<div class="moreRedPackets" onclick="skipToHome();">
			<img src="/imgs/moreRedPacket.png">
		</div>
		
		
		
		
		<script type="text/javascript">
			function setPayType(type){
				
				$("input[name=payType]").val(type);
				var wxPayTypeEm = $(".select_list_item[type=0] em").eq(0);
				var amountPayTypeEm = $(".select_list_item[type=1] em").eq(0);
				
				if(type==1){
					wxPayTypeEm.attr("class","fa fa-square-o");
					wxPayTypeEm.css("color","black");
					amountPayTypeEm.attr("class","fa fa-check-square");
					amountPayTypeEm.css("color","red");
				}else{
					amountPayTypeEm.attr("class","fa fa-square-o");
					amountPayTypeEm.css("color","black");
					wxPayTypeEm.attr("class","fa fa-check-square");
					wxPayTypeEm.css("color","red");
				}	
			}
			
			function payFee(){
				var amountBalance = $("input[name=amountBalance]").val();
				amountBalance = parseFloat(amountBalance);
				var payType = $("input[name=payType]").val();
				var entryFee = $("input[name=entryFee]").val();
				entryFee = parseFloat(entryFee);
				
				var redPacketId = $("input[name=redPacketId]").val();
				if(payType==0){
					if(entryFee>amountBalance){
						showToast("余额不足");
						return;
					}
					
					var url = "/api/vie/draw/vie_red_pack/balance_pay_takepart";
					var params = new Object();
					params.red_packet_id = $("input[name=redPacketId]").val();
					var callback = new Object();
					callback.success = function(balanceResult){
						if(balanceResult.success){
							skipToVieAnswerProblem(redPacketId,balanceResult.data.id);
						}else{
							showToast("发生错误了，请查看你现在所参与的状态😁");
						}
					}
					request(url,callback,params);
					
				}else{
					var url = "/api/vie/draw/vie_red_pack/takepart";
					var params = new Object();
					params.red_packet_id = redPacketId;
					
					var callback = new Object();
					callback.success = function(takepartData){
						if(takepartData.success){
							var configUrl = "/api/pay/wx/choose_wx_pay_config";
							var configCallback = new Object();
							configCallback.success = function(configData){
								var payCallback = new Object();
								payCallback.success = function(){
									skipToVieAnswerProblem(redPacketId,takepartData.data.id);
								}
								wxPay(configData.data.timestamp,configData.data.nonceStr,configData.data.pack,configData.data.signType,configData.data.paySign,payCallback);
							}
							var configParams = new Object();
							configParams.body="支付参赛费";
							configParams.detail = "竞答红包";
							configParams.type=2;
							configParams.member_id=takepartData.data.id;
							request(configUrl,configCallback,configParams);
						}
					}
					
					request(url,callback,params);
				}
			}
		
			
		
			function initView(){
				
			}
			
			function submitTakepart(){
				var isEntryFee = $("input[name=isEntryFee]").val();
				if(isEntryFee==1){
					$("#red_packet_takepart").animate({
						bottom:"5px"
					},1000,function(){
						$("#vieTakepartButton").unbind("click");
						$(".container").click(function(){
							$("#red_packet_takepart").animate({
								bottom:"-200px"
							},1000,function(){
								addVieTakepartButtonListener();
							});
							$(".container").unbind("click");
						});
					});
				}else{
					//无参赛费参与
					var redPacketId = $("input[name=redPacketId]").val();
					var params = new Object();
					params.red_packet_id = redPacketId;
					var callback = new Object();
					callback.success = function(takepartResp){
						if(takepartResp.success){
							skipToVieAnswerProblem(redPacketId,takepartResp.data.id);
						}else{
							alert(takepartResp.errorMsg);
							showToast("网络繁忙，请稍后再试😊");
						}
						
					}
					var url = "/api/vie/draw/vie_red_pack/takepart";
					request(url,callback,params);
				}
			}
			
			function addVieTakepartButtonListener(){
				$("#vieTakepartButton").click(function(){
					
					
					var haveWisdomCount = $("input[name=haveWisdomCount]").val();
					haveWisdomCount = parseInt(haveWisdomCount);
					var wisdomCount = $("input[name=wisdomCount]").val();
					wisdomCount = parseInt(wisdomCount);
					var isWisdom = $("input[name=isWisdom]").val();

					if(isWisdom==1&&haveWisdomCount<wisdomCount){
						showSmartAlert("您的智慧豆已不足"+wisdomCount+"颗，请充值","确定",function(){
							
						});
						return;
					}else if(isWisdom==0){
						submitTakepart();
					}else{
						showSmartConfirm("参加需要消耗"+wisdomCount+"颗智慧豆，是否继续","否","是",function(){
						},function(){
							submitTakepart();
						});	
					}
				});
			}
			
			
			
			$(document).ready(function(){
				setPayType(0);
				addVieTakepartButtonListener();
				
				
				initStar(); 
				
				$("#goodCommentButton").click(function(){
					
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
		
</tiles:putAttribute>
</tiles:insertDefinition>

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
	
	comment();
});
</script>
<input name="accordStar1Num" value="${redPacketToComment.accordStar1Num}" type="hidden"/>
<input name="accordStar2Num" value="${redPacketToComment.accordStar2Num}" type="hidden"/>
<input name="accordStar3Num" value="${redPacketToComment.accordStar3Num}" type="hidden"/>
<input name="accordStar4Num" value="${redPacketToComment.accordStar4Num}" type="hidden"/>
<input name="accordStar5Num" value="${redPacketToComment.accordStar5Num}" type="hidden"/>
<input name="usefulStar1Num" value="${redPacketToComment.usefulStar1Num}" type="hidden"/>
<input name="usefulStar2Num" value="${redPacketToComment.usefulStar2Num}" type="hidden"/>
<input name="usefulStar3Num" value="${redPacketToComment.usefulStar3Num}" type="hidden"/>
<input name="usefulStar4Num" value="${redPacketToComment.usefulStar4Num}" type="hidden"/>
<input name="usefulStar5Num" value="${redPacketToComment.usefulStar5Num}" type="hidden"/>
<input name="interestingStar1Num" value="${redPacketToComment.interestingStar1Num}" type="hidden"/>
<input name="interestingStar2Num" value="${redPacketToComment.interestingStar2Num}" type="hidden"/>
<input name="interestingStar3Num" value="${redPacketToComment.interestingStar3Num}" type="hidden"/>
<input name="interestingStar4Num" value="${redPacketToComment.interestingStar4Num}" type="hidden"/>
<input name="interestingStar5Num" value="${redPacketToComment.interestingStar5Num}" type="hidden"/>

<input name="goodNum" value="${redPacketToComment.goodCommentNum}" type="hidden"/>
<input name="badNum" value="${redPacketToComment.badCommentNum}" type="hidden"/>

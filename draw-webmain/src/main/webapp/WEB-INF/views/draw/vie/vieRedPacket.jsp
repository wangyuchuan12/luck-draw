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
			
			
			<div class="luck_info_head">
				<div class="luck_info_head_background"></div>
				<div class="luck_info_head_title">竞答红包</div>
				<div class="luck_info_head_img">
					<img src="${redPacketInfo.userImgUrl}"></img>
				</div>
				<div class="luck_info_head_name">${redPacketInfo.nickname}的红包</div>

				<div class="luck_info_head_money"><span>${redPacketInfo.amount}</span>元
				</div>
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
						<div class="vie_luck_info_detail_item_label">名称：</div>
						<div class="vie_luck_info_detail_item_text">${redPacketInfo.theme}少时诵诗书所所多付所多付所多付所多付</div>
					</div>
					
					<div class="vie_luck_info_detail_item">
						<div class="vie_luck_info_detail_item_label">已参加：</div>
						<div class="vie_luck_info_detail_item_text">${redPacketInfo.takePartCount}人</div>
					</div>
					
					<c:if test="${bestTakepartMember!=null}">
						<div class="vie_luck_info_detail_item">
							<div class="vie_luck_info_detail_item_label">最高分：</div>
							<div class="vie_luck_info_detail_item_text">${bestTakepartMember.rightCount}/${bestTakepartMember.rightCount+bestTakepartMember.wrongCount}题  ${bestTakepartMember.timeLong}秒</div>
						</div>
					</c:if>
					
					<div class="vie_luck_info_detail_item">
						<div class="vie_luck_info_detail_item_label">消耗智慧豆：</div>
						<div class="vie_luck_info_detail_item_text">5颗</div>
					</div>
					
				</div>
			
			</div>
			
			
			
			<div class="luck_info_alert" style="display: none;">该活动已结束</div>
			
			<c:if test="${redPacketInfo.isAnswer==1}">
				<div class="vieShowAnswerButton" onclick="skipVieAnswerResult('${redPacketInfo.id}')">查看答题结果</div>
			</c:if>
			
			<c:if test="${redPacketInfo.isPay==1&&redPacketInfo.isTimeout==0&&redPacketInfo.isCreater==0&&redPacketInfo.isAnswer==0}">
				<div class="vieShowAnswerButton" id="vieTakepartButton">参加（智慧豆：5颗，报名费：${redPacketInfo.entryFee}元）</div>
			</c:if>
			<c:if test="${redPacketInfo.instruction!=null}">
				<div class="vieTakepartButtonInstruction">
					详情：${redPacketInfo.instruction}
				</div>
			</c:if>
			
			
			<div class="luck_info_situation">
				<div class="luck_info_situation_time">剩余<b id="luck_info_hour">00</b><b id="luck_info_min">00</b><b id="luck_info_second">00</b> 结束</div>
			</div>
			
			<div class="help" style="margin-top: 1px;">
					<ul>
						<li>
							<span class="fa fa-check-circle"></span>
							<span>超时退款</span>
						</li>
						
						<li>
							<span class="fa fa-check-circle"></span>
							<span>第一名：4元</span>
						</li>
						
						<li>
							<span class="fa fa-check-circle"></span>
							<span>第二名：2元</span>
						</li>
						
						<li>
							<span class="fa fa-check-circle"></span>
							<span>第三名：1元</span>
						</li>
						
						<li>
							<span class="fa fa-check-circle"></span>
							<span>参赛费：${redPacketInfo.entryFee}元，归发起人所有</span>
						</li>
						
						<li>
							<span class="fa fa-check-circle"></span>
							<span>发起人可获取：好评数*2粒智慧豆</span>
						</li>
						
						<li>
							<span class="fa fa-check-circle"></span>
							<span>只有参赛人员才可以好评</span>
						</li>
					</ul>
			
				</div>
			
			<div class="view_luck_members">
				<c:if test="${redPacketInfo.isAnswer==1}">
					<div class="view_luck_member">
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
			
						<div class="view_luck_member_name2">
							 <div class="view_luck_member_name2_nickname">${thisMember.nickname}</div>
							
							<div class="view_luck_member_name2_prompt">第3名 <span>可获得30元</span></div>
							
							<!--  <div class="view_luck_member_name2_prompt_absolute">可获得30元</div>-->
						</div>
						
						<div class="view_luck_member_result">
							<div class="view_luck_member_result_correct">${thisMember.rightCount}题/${thisMember.timeLong}秒</div>
						</div>
					</div>
				</c:if>
				
				
				<c:if test="${fn:length(takePartMembers.datas)>0}">
					<div class="view_luck_members_rank">排行榜</div>
				</c:if>
				<c:forEach items="${takePartMembers.datas}" var="takePartMember">
					<div class="view_luck_member">
						<div class="view_luck_member_rank">${takePartMember.rank}</div>
						
						<div class="view_luck_member_img">
							<img src="${takePartMember.headImg}">
						</div>
						
						<div class="view_luck_member_name">${takePartMember.nickname}</div>
						
						<div class="view_luck_member_result">
							<div class="view_luck_member_result_correct">${takePartMember.rightCount}题/${takePartMember.timeLong}秒</div>
						</div>
					</div>
				</c:forEach>
			</div>
			
			
			
			<div class="foot_button">
				<ul>
				
					<c:if test="${redPacketInfo.isRoom==0}">
						<li style="width: 48%;">
							<span class="fa fa-thumbs-o-up"></span>
							<span>点评</span>
						</li>
						
						<li style="width: 48%;" onclick="showRedPacketTypes();">
							<span>
								<img src="/imgs/sendRedPacket.jpg"></img>
							</span>
							<span>我也发一个</span>
						</li>
					
					</c:if>
					
					<c:if test="${redPacketInfo.isRoom==1}">
					
						<li style="width: 32%;">
							<span class="fa fa-thumbs-o-up"></span>
							<span>点评</span>
						</li>
						<li style="width: 32%;" onclick="skipToRoomInfo('${redPacketInfo.drawRoomId}');">
							<span class="fa fa-users"></span>
							<span>进入房间</span>
						</li>
						
						<li style="width: 32%;" onclick="showRedPacketTypes();">
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
				
				function addVieTakepartButtonListener(){
					$("#vieTakepartButton").click(function(){
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
								skipToVieAnswerProblem(redPacketId,takepartResp.data.id);
							}
							var url = "/api/vie/draw/vie_red_pack/takepart";
							request(url,callback,params);
						}
						
						
					});
				}
				$(document).ready(function(){
					setPayType(0);
					addVieTakepartButtonListener();
					
					
					
					
					$(".red_packet_takepart_button").click(function(){
						payFee();
					});
					
					
				
					$("#red_packet_takepart").css("bottom","-200px");
					$("body").css("padding-bottom","50px");
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
			</script>
			
</tiles:putAttribute>
</tiles:insertDefinition>


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



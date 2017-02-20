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
						<div class="vie_luck_info_detail_item_text">${redPacketInfo.theme}</div>
					</div>
					
					<div class="vie_luck_info_detail_item">
						<div class="vie_luck_info_detail_item_label">已参加：</div>
						<div class="vie_luck_info_detail_item_text">${redPacketInfo.takePartCount}人</div>
					</div>
					
					<div class="vie_luck_info_detail_item">
						<div class="vie_luck_info_detail_item_label">最高分：</div>
						<div class="vie_luck_info_detail_item_text">15/30题  22秒</div>
					</div>
					
					<div class="vie_luck_info_detail_item">
						<div class="vie_luck_info_detail_item_label">难度：</div>
						<div class="vie_luck_info_detail_item_text">4颗星</div>
					</div>
					
					<div class="vie_luck_info_detail_item">
						<div class="vie_luck_info_detail_item_label">平均正确率：</div>
						<div class="vie_luck_info_detail_item_text">70%</div>
					</div>
					
					<div class="vie_luck_info_detail_item">
						<div class="vie_luck_info_detail_item_label">参赛费：</div>
						<div class="vie_luck_info_detail_item_text">${redPacketInfo.entryFee}元</div>
					</div>
				</div>
			
			</div>
			
			
			
			<div class="luck_info_alert" style="display: none;">该活动已结束</div>
			
			<c:if test="${redPacketInfo.isAnswer==1}">
				<div class="vieShowAnswerButton" onclick="skipVieAnswerResult('${redPacketInfo.id}')">查看答题结果</div>
			</c:if>
			<c:if test="${redPacketInfo.instruction!=null}">
				<div class="vieTakepartButtonInstruction">
					详情：${redPacketInfo.instruction}
				</div>
			</c:if>
			
			
			<div class="luck_info_situation">
					<div class="luck_info_situation_time">剩余<b id="luck_info_hour">00</b><b id="luck_info_min">00</b><b id="luck_info_second">00</b> 结束</div>
			</div>
			
			<div class="view_luck_members">
				<c:if test="${redPacketInfo.isAnswer==1}">
					<div class="view_luck_member">
						<div class="view_luck_member_rank">
							<c:if test="${thisMember.rank!=null}">
								${thisMember.rank}
							</c:if>
							
							<c:if test="${thisMember.rank==null}">
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
				
				<div class="help">
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
							<span>参赛费：0.1元，归发起人所有</span>
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
				
				<div class="view_luck_members_rank">排行榜</div>
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
					<li style="width: 23%;">
						<span class="fa fa-home"></span>
						<span>主页</span>
					</li>
					<li style="width: 23%;">
						<span class="fa fa-thumbs-o-up"></span>
						<span>好评</span>
					</li>
					<li style="width: 23%;">
						<span class="fa fa-users"></span>
						<span>进入房间</span>
					</li>
					
					
					<c:if test="${redPacketInfo.isPay==1&&redPacketInfo.isTimeout==0&&redPacketInfo.isCreater==0&&redPacketInfo.isAnswer==0}">
						<li style="width: 23%;" id="vieTakepartButton">
							<span class="fa fa-space-shuttle"></span>
							<span>参加</span>
						</li>
					</c:if>
					
				</ul>
			</div>
			
			
			
			
			<script type="text/javascript">
			
				function initView(){
					
				}
				$(document).ready(function(){
				
					$("body").css("padding-bottom","50px");
					$("#receiveButton").click(function(){
						var status=1;
						var problemId = $("input[name=firstProblemId]").val();
						var redPacketId = $("input[name=redPacketId]").val();
						skipToVieAnswerProblem(status,redPacketId,problemId,"");
					});
					document.addEventListener("touchstart",function(){
						
					},false);
					
					$("#vieTakepartButton").click(function(){
						var url = "/api/vie/draw/vie_red_pack/takepart";
						var params = new Object();
						var redPacketId = $("input[name=redPacketId]").val();
						
						params.red_packet_id = redPacketId;
						var callback = new Object();
						callback.success = function(resp){
							if(resp.success){
								skipToVieAnswerProblem(redPacketId,resp.data.id);
							}else{
								showToast("网络繁忙，请稍后再试，😁");
							}
							
						}
						
						callback.failure = function(){
							showToast("网络繁忙，请稍后再试，😁");
						}
						request(url,callback,params);
						
					});
					
					
					
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

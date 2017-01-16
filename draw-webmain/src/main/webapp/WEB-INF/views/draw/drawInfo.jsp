<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="resourceLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
<tiles:putAttribute name="body">

			<input name="handTime" value="${result.data.handTime}" type="hidden"/>
			<input name="timeLong" value="${result.data.timeLong}" type="hidden"/>
			<input name="redPacketId" value="${result.data.id}" type="hidden"/>
			<input name="packetRoomId" value="${result.data.drawRoomId}" type="hidden"/>
			<input name="roomMemberId" value="${result.data.handRoomMemberId}" type="hidden"/>
			
			<input name="wordNum" value="${fn:length(result.data.answer)}" type="hidden"/>
			
			<input name="count" value="${result.data.count}" type="hidden"/>
			
			<input name="allowWrongCount" value="${result.data.allowWrongCount}" type="hidden"/>
			
			<input name="isReceive" value="${result.data.isReceive}" type="hidden"/>
			
			<input name="isTimeOut" value="${result.data.isTimeout}" type="hidden"/>
			
			<input name="isPay" value="${result.data.isPay}" type="hidden"/>
			
			<input name="isInRoom" value="${result.data.isInRoom}" type="hidden"/>
			
			<input name="type" value="${result.data.type}" type="hidden"/>
			<div class="luck_info_head">
				<div class="luck_info_head_background"></div>
				<div class="luck_info_head_title">问答红包</div>
				<div class="luck_info_head_img">
					<img src="${result.data.userImgUrl}"></img>
				</div>
				<div class="luck_info_head_name">${result.data.nickname}的红包</div>

				<div class="luck_info_head_money"><span>${result.data.amount}</span>元</div>
			</div>
			
			<div class="luck_info_qusition">
				<div class="luck_info_qusition_title">问：${result.data.question}<span> ${fn:length(result.data.answer)}个字</span></div>
				
				
			</div>
			
			<div class="luck_info_answer">
				<input id="luck_info_answer_input"/>
				<div class="luck_info_answer_button">提交答案</div>
			</div>
			
			<div class="luck_info_alert" style="display:none">已经到时间了</div>
			
			<div class="luck_info_href">
				<div class="luck_info_item" onclick="skipToPersonalCenter();">
					<i class="fa fa-user luck_info_item_i" style="color: RGBA(251,222,2,1);"></i>
					<div class="luck_info_item_content">查看我的钱包</div>
				</div>
				
				<div class="luck_info_item" onclick="skipToAddRedPack(1,1,1);">
					<i class="fa fa-paper-plane luck_info_item_i" style="color: RGBA(243,151,37,1);"></i>
					<div class="luck_info_item_content">我也发个红包</div>
				</div>
				
				<div class="luck_info_item" onclick="skipToRoomInfo('${result.data.drawRoomId}');">
					<i class="fa fa-users luck_info_item_i" style="color: RGBA(126,213,61,1);"></i>
					<div class="luck_info_item_content">进入房间</div>
				</div>
				
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
			
			<div class="luck_info_records">
				<div class="luck_info_records_name">记录</div>
				<div class="luck_info_record_list">
					<div class="luck_info_record_item">
						<div class="luck_info_record_item_img">
							<img src="http://wx.qlogo.cn/mmopen/Q3auHgzwzM6iaCq2JwzfpkLPLREt1m1UcUoy17zzkNwgeAWqs6nHY1svj2NfMethmUqVpicG80yYdWn524E6fyBtpJB1CYhEB83yicLicJbUZ5U/0"></img>
						</div>
						<div class="luck_info_record_item_nickname">川川</div>
						<div class="luck_info_record_item_time">2016-11-12 17:32:24</div>
						<div class="luck_info_record_item_content">回答：鸡翅膀</div>
						<div class="luck_info_record_item_result">
							<em class="fa fa-check" style="color: green;"></em>
						</div>
					</div>
					
					
					
					<div class="luck_info_record_item">
						<div class="luck_info_record_item_img">
							<img src="http://wx.qlogo.cn/mmopen/Q3auHgzwzM6iaCq2JwzfpkLPLREt1m1UcUoy17zzkNwgeAWqs6nHY1svj2NfMethmUqVpicG80yYdWn524E6fyBtpJB1CYhEB83yicLicJbUZ5U/0"></img>
						</div>
						<div class="luck_info_record_item_nickname">川川</div>
						<div class="luck_info_record_item_time">2016-11-12 17:32:24</div>
						<div class="luck_info_record_item_content">回答：鸡翅膀</div>
						<div class="luck_info_record_item_result">
							<em class="fa fa-times"></em>
						</div>
					</div>
				</div>
			</div>
			
			<script type="text/javascript">
				var isEnd = false;
				initView();
				function initView(prompt){
					var count = $("input[name=count]").val();
					count = parseInt(count);
					
					var allowWrongCount = $("input[name=allowWrongCount]").val();
					allowWrongCount = parseInt(allowWrongCount);
					
					var isReceive = $("input[name=isReceive]").val();
					isReceive = parseInt(isReceive);
					
					
					var isPay = $("input[name=isPay]").val();
					
					isPay = parseInt(isPay);
					
					var isTimeOut = $("input[name=isTimeOut]").val();
					
					isTimeOut = parseInt(isTimeOut);
					
					var isInRoom = $("input[name=isInRoom]").val();
					
					isInRoom = parseInt(isInRoom);
					
					var type = $("input[name=type]").val();
					
					type = parseInt(type);
					
					alert(type);
					
					alert(isInRoom);
					if(prompt){
						$(".luck_info_alert").text(prompt);
						$(".luck_info_alert").css("display","block");
					}
					if(isReceive==1){
						$(".luck_info_alert").text("该红包已经被领取");
						$(".luck_info_answer").css("display","none");
						$(".luck_info_situation").css("display","none");
						$(".luck_info_alert").css("display","block");
						
						return;
					}else if(isPay==0){
						$(".luck_info_alert").text("该红包还未收到付款，再等半分钟");
						$(".luck_info_answer").css("display","none");
						$(".luck_info_situation").css("display","none");
						$(".luck_info_alert").css("display","block");
						return;
					}else if(isTimeOut==1){
						$(".luck_info_alert").text("该红包已超时");
						$(".luck_info_answer").css("display","none");
						$(".luck_info_alert").css("display","block");
						
						return;
					}else if(type==0&&isInRoom!=1){
						$(".luck_info_alert").text("该红包为房间专属红包，你不在该房间中，无法领取，请点击进入该房间");
						$(".luck_info_answer").css("display","none");
						$(".luck_info_alert").css("display","block");
					}else if(allowWrongCount<=count){
						$(".luck_info_alert").text("你答题次数已经超过"+count+"次，不能再答题了");
						$(".luck_info_answer").css("display","none");
						$(".luck_info_situation").css("display","none");
						$(".luck_info_alert").css("display","block");
						
						if(prompt){
							$(".luck_info_alert").text(prompt+",你回答次数已经超过"+count+"次，不能再答题了");
						}
						return;
					}
				}
				
				function appendPrompt(id,prompt){
					$(".luck_info_question_prompt_items").append("<div id='"+id+"' class='luck_info_question_prompt_item'>"+prompt+" <em class='fa fa-close'></em></div>");
				}
				
				function initAddPrompts(){
					$(".luck_info_question_prompt_items").append("<div class='luck_info_question_prompt_add'>新增提示</div>");
					
					
					$(".luck_info_question_prompt_add").click(function(){
						
						layer.prompt({
							title:"请输入提示"
						},function(value){
							layer.closeAll();
							var callback = new Object();
							callback.success = function(){
								initPrompts();
							}
							var url = "/api/draw/red_pack/add_prompt";
							var params = new Object();
							params.red_packet_id = $("input[name=redPacketId]").val();
							params.prompt = value;
							request(url,callback,params);
							
						});
					});
				}
				
				
				
				function initDelPrompts(){
					$(".luck_info_question_prompt_items").append("<div class='luck_info_question_prompt_del'>删除提示</div>");
					
					
					$(".luck_info_question_prompt_del em").click(function(){
						alert();
					});
				}
				
				
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
					
					if(answerLength!=wordNum){
						showToast("请输入"+wordNum+"个字");
						return;
					}
					
					if(isEnd){
						showToast("时间已结束");
						return;
					}
					
					if(count>=allowWrongCount){
						showToast("你的次数已经用完");
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
							if(obj.data.isRight==1){
								$(".luck_info_alert").css("display","block");
								$(".luck_info_alert").html("回答正确，金额已存入账户");
								$(".luck_info_answer").css("display","none");
								$(".luck_info_href").text("点击返回房间");
								$(".luck_info_href").css("display","block");
							}else{
								
								var count = $("input[name=count]").val();
								count = parseInt(count);
								count = count+1;
								
								$("input[name=count]").val(count);
								initView("回答错误");
								
								
							}
						}
					}
					
					callback.failure = function(obj){
						hideLoading();
						showToast("现在用户访问量过大，请稍后再试");
					}
					
					request("/api/draw/red_pack/answer",callback,params);
				}
				
				function initPrompts(){
					var callback = new Object();
					callback.success = function(obj){
						var promptArray = obj.data.redPacketPrompts;
						if(promptArray){
							$(".luck_info_question_prompt_items").empty();
							
							for(var i=0;i<promptArray.length;i++){
								appendPrompt(promptArray[i].id,promptArray[i].prompt);
							}
						}
						initAddPrompts();
					//	initDelPrompts();
						
						$(".luck_info_question_prompt_item em").click(function(){
							
							var thisPrompt = $(this).parent();
							layer.confirm("是否确定删除提示",function(){
								var id  = thisPrompt.attr("id");
								
								var url = "/api/draw/red_pack/del_prompt";
								
								var params = new Object();
								params.id = id;
								
								var callback = new Object();
								
								callback.success = function(obj){
									layer.closeAll();
									if(obj.success){
										thisPrompt.remove();
									}
								}
								
								callback.failure = function(obj){
									layer.closeAll();
								}
								request(url,callback,params);
							});
						});
					}
					
					var url = "/api/draw/red_pack/prompts";
					var params = new Object();
					params.red_packet_id = $("input[name=redPacketId]").val();
					request(url,callback,params);
				}
				
				$(document).ready(function(){
					
					
					$(".luck_info_answer_button").click(function(){
						submitAnswer();
					});
					initPrompts();
					setIsDisplayType(1);
					setIsDisplayRoom(1);
					var callback = new Object();
					callback.end = function(){
						$("input[name=isTimeOut]").val(1);
						initView();
						
					}
					var handTime = $("input[name=handTime]").val();
					
					var timeLong = $("input[name=timeLong]").val();
					initGroupInvalidDate(new Date(handTime),timeLong,".luck_info_situation_time",callback);
					
				});
			</script>
			
</tiles:putAttribute>
</tiles:insertDefinition>

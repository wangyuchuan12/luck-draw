<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="infoLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
<tiles:putAttribute name="body">

			<input name="handTime" value="${result.data.handTime}" type="hidden"/>
			<input name="timeLong" value="${result.data.timeLong}" type="hidden"/>
			<input name="redPacketId" value="${result.data.id}" type="hidden"/>
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
				<div class="luck_info_qusition_title">问：${result.data.question}实施大法师打发第三方水电费水电费是水电费所属胜多负少发送到<span> ${fn:length(result.data.answer)}个字</span></div>
				
				
			</div>
			
			<div class="luck_info_answer">
				<input />
				<div class="luck_info_answer_button">提交答案</div>
			</div>
			
			<div class="luck_info_alert" style="display:none">已经到时间了</div>
			
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
					
					initPrompts();
					setIsDisplayType(1);
					setIsDisplayRoom(1);
					var callback = new Object();
					callback.end = function(){
						$(".luck_info_alert").css("display","block");
					}
					var handTime = $("input[name=handTime]").val();
					
					var timeLong = $("input[name=timeLong]").val();
					initGroupInvalidDate(new Date(handTime),timeLong,".luck_info_situation_time",callback);
					
				});
			</script>
			
</tiles:putAttribute>
</tiles:insertDefinition>

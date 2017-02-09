<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="resourceLayout">
<tiles:putAttribute name="title">设置问题</tiles:putAttribute>
<tiles:putAttribute name="body">
	
	
	<input name="previousOption" value="${redPacketProblem.previousProblemId}"/>
	<input name="nextOption" value="${redPacketProblem.nextProblemId}"/>
	
	<input name="isFirst" value="${redPacketProblem.isFirst}"/>
	
	<input name="isLast" value="${redPacketProblem.isLast}"/>
	
	<input name="count" value="${redPacketProblem.count}"/>
	
	<!-- 0游离状态，1存储状态，即已经保存到数据库中了 -->
	<input name="status" value="${redPacketProblem.status}"/> 
	
	<input name="seq" value="${redPacketProblem.seq}"/> 
	
	<input name="redPacketId" value="${redPacketProblem.redPacketId}"/> 
	
	<input name="id" value="${redPacketProblem.id}"/> 
	<div class="vie_problem">
		<div class="view_problem_title">第${redPacketProblem.seq}/${redPacketProblem.count}题</div>
		
	</div>
	
	<div class="vie_problem_question">
		<div class="vie_problem_question_textarea">
			<textarea rows="" cols="" placeholder="请输入内容" name="question">${redPacketProblem.question}</textarea>
		</div>
	</div>
	
	<div class="vie_problem_answer" id="vie_problem_answer">
		<ul>
		
			<c:if test="${redPacketProblem.status==0}">
				<li isRight="0">
					<span>A</span>
					
					
					
					<textarea rows="3" placeholder="请输入选项"></textarea>
					
					<em class="fa fa-times"></em>
					
					<div class="vie_problem_answer_check">
						<em>正确答案:</em><span class="fa fa-square-o"></span>
					</div>
				</li>
			
				<li isRight="0">
					<span>B</span>
					
					<textarea rows="3"  placeholder="请输入选项"></textarea>
					
					<em class="fa fa-times"></em>
					
					<div class="vie_problem_answer_check">
						<em>正确答案:</em><span class="fa fa-square-o"></span>
					</div>
					
					
				</li>
			
			</c:if>
			
			<c:if test="${redPacketProblem.status==1}">
				<c:forEach items="${redPacketProblem.vieRedPacketOptionVos}" var="item" varStatus="varStatus">
					<li isRight="${item.isRight}">
					
						<c:if test="${varStatus.index==0}">
							<span>A</span>
						</c:if>
						
						<c:if test="${varStatus.index==1}">
							<span>B</span>
						</c:if>
						
						<c:if test="${varStatus.index==2}">
							<span>C</span>
						</c:if>
						
						<c:if test="${varStatus.index==3}">
							<span>D</span>
						</c:if>
						
						<c:if test="${varStatus.index==4}">
							<span>E</span>
						</c:if>
						
						<c:if test="${varStatus.index==5}">
							<span>F</span>
						</c:if>
						
						<c:if test="${varStatus.index==6}">
							<span>G</span>
						</c:if>
						
						<c:if test="${varStatus.index==7}">
							<span>H</span>
						</c:if>
						
						<c:if test="${varStatus.index==8}">
							<span>I</span>
						</c:if>
						
						<c:if test="${varStatus.index==9}">
							<span>J</span>
						</c:if>
						
						<c:if test="${varStatus.index==10}">
							<span>K</span>
						</c:if>
						
						<c:if test="${varStatus.index==11}">
							<span>L</span>
						</c:if>
						
						<c:if test="${varStatus.index==12}">
							<span>M</span>
						</c:if>
						
						
						<textarea rows="3" placeholder="请输入选项">${item.content}</textarea>
						
						<em class="fa fa-times"></em>
						
						<div class="vie_problem_answer_check">
							<em>正确答案:</em><span class="fa fa-square-o"></span>
						</div>
					</li>
				</c:forEach>
			
			</c:if>
			
			
				
		</ul>
		
		
		
	</div>
	
	<div class="vie_problem_answer_button">
			<ul>
			
				
				
				<li id="delButton">
					<span class="fa fa-minus"></span>
					<div class="vie_problem_answer_button_text">删除该题</div>
				</li>
				
				<li>
					<span class="fa fa-plus"></span>
					<div class="vie_problem_answer_button_text">添加选项</div>
				</li>
				
				<li onclick="save()">
					<span class="fa fa-save"></span>
					<div class="vie_problem_answer_button_text">保存</div>
				</li>
				
				<li id="previnceButton">
					<span class="fa fa-hand-o-left"></span>
					<div class="vie_problem_answer_button_text">上一题</div>
				</li>
				
				<li id="nextButton">
					<span class="fa fa-hand-o-right"></span>
					<div class="vie_problem_answer_button_text">下一题</div>
				</li>
			</ul>
					
		</div>
			
			
	<script type="text/javascript">
		
		
		function initView(){
			var redPacketId = $("input[name=redPacketId]").val();
			var status = $("input[name=status]").val();
			var id = $("input[name=id]").val();
			
			var nextOption = $("input[name=nextOption]").val();
			if(status=="0"){
				$("#delButton").css("background","#cccccc");
				$("#nextButton").css("background","#cccccc");
			}else{
				$("#nextButton").click(function(){
					if(nextOption){
						skipToVieSetProblem(1,redPacketId,nextOption,id);
					}else{
						skipToVieSetProblem(0,redPacketId,nextOption,id);
					}
					
				});
			}
			
			var isFirst = $("input[name=isFirst]").val();
			if(isFirst==1){
				$("#previnceButton").css("background","#cccccc");
			}else{
				$("#previnceButton").click(function(){
					var previousOption = $("input[name=previousOption]").val();
					
					skipToVieSetProblem(1,redPacketId,previousOption,id);
				});
			}
			
		}
		
		$("#vie_problem_answer").children("ul").children("li").each(function(){
			initOption($(this));
		});
		$(document).ready(function(){
			initView();
			$(".vie_problem_answer_check").click(function(){
				$("#vie_problem_answer").children("ul").children("li").attr("isRight","0");
				
				$("#vie_problem_answer").children("ul").children("li").each(function(){
					 initOption($(this));
				});
				
				$(this).parent().attr("isRight","1");
				initOption($(this).parent());
			});
		});
		
		function initOption(option){
			var isRight = option.attr("isRight");
			
			if(isRight=="0"){
				var span = option.children(".vie_problem_answer_check").children("span");
				span.attr("class","fa fa-square-o")
				
				span.attr("style","");
				//option.children(".vie_problem_answer_check span").attr("class","color:red;")
			}else{
				var span = option.children(".vie_problem_answer_check").children("span");
				span.attr("class","fa fa-check-square-o");
				span.attr("style","color:red");
			}
		}
		
		
		
		function save(){
			var status = $("input[name=status]").val();
			status = parseInt(status);
			
			var isFirst = $("input[name=isFirst]").val();
			
			var question = $("textarea[name=question]").val();
			
			var redPacketId = $("input[name=redPacketId]").val();
			
			var id = $("input[name=id]").val();
			
			var previousOption = $("input[name=previousOption]").val();

			if(status==0){
				//游离状态
				var params = new Object();
				params.type = 0;
				params.is_first = isFirst;
				params.question = question;
				params.red_packet_id = redPacketId;
				params.previous_problem_id = previousOption;
				
				var vie_problem_answer
				var optionMap = new Object();
				var addList = new Array();
				optionMap.add = addList;
				$("#vie_problem_answer textarea").each(function(index){
					var addMap = new Object();
					addMap.isRight = $(this).parent().attr("isRight");
					addMap.seq = index;
					addMap.content = $(this).val();
					addList.push(addMap);
				});
				
				var jsonOption = JSON.stringify(optionMap);
				params.options = jsonOption;
				var url = "/api/vie/draw/vie_red_pack/hand_problem";
				
				var callback = new Object();
				callback.success = function(resp){
					
					var problemId = resp.data.id;
					if(!resp.success){
						alert(resp.errorMsg);
					}else{
						skipToVieSetProblem(0,redPacketId,null,problemId)
					}
					
				}
				request(url,callback,params);
			}else if(status==1){
				//数据库管理状态
			}
		}
	</script>
			
</tiles:putAttribute>
</tiles:insertDefinition>

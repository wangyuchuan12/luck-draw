<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="resourceLayout">
<tiles:putAttribute name="title">设置问题</tiles:putAttribute>
<tiles:putAttribute name="body">
	
	
	<input name="previousOption" value="${redPacketProblem.previousProblemId}" type="hidden"/>
	<input name="nextOption" value="${redPacketProblem.nextProblemId}" type="hidden"/>
	
	<input name="isFirst" value="${redPacketProblem.isFirst}" type="hidden"/>
	
	<input name="isLast" value="${redPacketProblem.isLast}" type="hidden"/>
	
	<input name="count" value="${redPacketProblem.count}" type="hidden"/>
	
	<!-- 0游离状态，1存储状态，即已经保存到数据库中了 -->
	<input name="status" value="${redPacketProblem.status}" type="hidden"/> 
	
	<input name="seq" value="${redPacketProblem.seq}" type="hidden"/> 
	
	<input name="redPacketId" value="${redPacketProblem.redPacketId}" type="hidden"/> 
	
	<input name="id" value="${redPacketProblem.id}" type="hidden"/> 
	
	<input name="count" value="${redPacketProblem.count}" type="hidden"/>
	<div class="vie_problem">
		<div class="view_problem_title">第${redPacketProblem.seq}/${redPacketProblem.count}题</div>
		<div class="view_problem_submit" id = "view_problem_submit">提交</div>
		
	</div>
	
	<div class="vie_problem_question">
		<div class="vie_problem_question_textarea">
			<textarea rows="" cols="" placeholder="请输入内容" name="question">${redPacketProblem.question}</textarea>
		</div>
	</div>
	
	<div class="vie_problem_answer" id="vie_problem_answer">
		<ul>
		
			<c:if test="${redPacketProblem.status==0}">
				<li isRight="0" status="0" isDel="0">
					<span>A</span>
					
					
					
					<textarea rows="3" placeholder="请输入选项"></textarea>
					
					<em class="fa fa-times"></em>
					
					<div class="vie_problem_answer_check">
						<em>正确答案:</em><span class="fa fa-square-o"></span>
					</div>
				</li>
			
				<li isRight="0" status="0" isDel="0">
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
					<li isRight="${item.isRight}" status="1" isDel="0" id="${item.id}">
					
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
					<div class="vie_problem_answer_button_text">刷新</div>
				</li>
				
				<li id="addOptionButton">
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
		
		var addArray = new Array();
		var updateArray = new Array();
		var delArray = new Array();
		initVieProblemAnswer();
		initData();
		function initVieProblemAnswer(){
			var length = $("#vie_problem_answer").children("ul").children("li[isDel=0]").length;
			
			if(length<=2){
				$(".vie_problem_answer>ul>li>em").css("display","none");
			}else{
				$(".vie_problem_answer>ul>li>em").css("display","");
			}
			var index = 0;
			$("#vie_problem_answer").children("ul").children("li[isDel=0]").each(function(value){
				var symbol;
				if(index==0){
					symbol="A";
				}
				if(index==1){
					symbol="B";
				}
				if(index==2){
					symbol="C";
				}
				if(index==3){
					symbol="D";
				}
				if(index==4){
					symbol="E";
				}
				if(index==5){
					symbol="F";
				}
				if(index==6){
					symbol="G";
				}
				if(index==7){
					symbol="H";
				}
				if(index==8){
					symbol="I";
				}
				if(index==9){
					symbol="J";
				}
				if(index==10){
					symbol="K";
				}
				if(index==11){
					symbol="L";
				}
				if(index==12){
					symbol="M";
				}
				$(this).children("span").html(symbol);
				index++;
			});
			
			$(".vie_problem_answer_check").click(function(){
				$("#vie_problem_answer").children("ul").children("li").attr("isRight","0");
				
				$("#vie_problem_answer").children("ul").children("li").each(function(){
					 initOption($(this));
				});
				
				$(this).parent().attr("isRight","1");
				initOption($(this).parent());
			});
			
			$(".vie_problem_answer>ul>li>em").click(function(){
				$(this).parent().css("display","none");
				$(this).parent().attr("isDel","1");
				initVieProblemAnswer();
			});
		}	
	
		function initData(){
			updateArray = new Array();
			delArray = new Array();
			addArray = new Array();
			var index = 0;
			$("#vie_problem_answer").children("ul").children("li").each(function(){
				var status = $(this).attr("status");
				var isDel = $(this).attr("isDel");
				
				$(this).attr("seq",index);
				if(status==1&&isDel==0){
					updateArray.push($(this));
				}else if(status==1&&isDel==1){
					delArray.push($(this));
				}else if(status==0&&isDel==0){
					addArray.push($(this));
				}
				index++;
			});
		}
	
		function initView(){
			var redPacketId = $("input[name=redPacketId]").val();
			var status = $("input[name=status]").val();
			var id = $("input[name=id]").val();
			
			var nextOption = $("input[name=nextOption]").val();
			if(status=="0"){
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
		
			hideProgress();
			
			$("#delButton").click(function(){
				location.reload();
			});

			$("#view_problem_submit").click(function(){
				
				var count = $("input[name=count]").val();
				count = parseInt(count);
				if(count<5){
					showToast("题目数量不能少于4");
					return;
				}
				var url = "/api/vie/draw/vie_red_pack/submit_problem";
				var params = new Object();
				
				var redPacketId = $("input[name=redPacketId]").val();
				params.red_packet_id = redPacketId;
				
				var callback = new Object();
				callback.success = function(resp){
					if(resp.success){
						skipToVieDrawInfo(redPacketId,1);
					}else{
						alert(resp.errorMsg);
					}
				}
				request(url,callback,params);
			});
			
			initView();
			$("#addOptionButton").click(function(){
				var size = $("#vie_problem_answer").children("ul").children("li").length;
				if(size<=12){
					var liDiv = "<li isRight='0' status='0' isDel='0'><span>A</span>"+
					"<textarea rows='3' placeholder='请输入选项'></textarea>"+
					"<em class='fa fa-times'></em>"+
					"<div class='vie_problem_answer_check'>"+
					"<em>正确答案:</em><span class='fa fa-square-o'></span>"+
					"</div></li>";
					var liEl = $(liDiv);
					$("#vie_problem_answer>ul").append(liEl);
					initVieProblemAnswer();
				}else{
					showToast("选项已经超过12个，不能再添加了",5000);
				}
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
			
			initData();
			var optionMap = new Object();
			var addList = new Array();
			var delList = new Array();
			var updateList = new Array();
			optionMap.add = addList;
			optionMap.update = updateList;
			optionMap.del = delList;
			var flag = false;
			for(var i = 0 ;i<addArray.length;i++){
				
				if(addArray[i].attr("isRight")==1){
					flag = true;
				}
				var addMap = new Object();
				addMap.isRight = addArray[i].attr("isRight");
				addMap.seq = addArray[i].attr("seq");
				addMap.content = addArray[i].children("textarea").val();
				
				if(!addMap.content){
					showToast("选项内容不能为空");
					return;
				}
				addList.push(addMap);
			}
			
			for(var i = 0;i<updateArray.length;i++){
				
			
				if(!updateArray[i].attr("isRight")==1){
					flag = true;
				}
				var updateMap = new Object();
				updateMap.id = updateArray[i].attr("id");
				
				updateMap.isRight = updateArray[i].attr("isRight");
				
				updateMap.seq = updateArray[i].attr("seq");
				updateMap.content = updateArray[i].children("textarea").val();
				
				if(!updateMap.content){
					showToast("选项内容不能为空");
					return;
				}
				
				updateList.push(updateMap);
			}
			
			var question = $("textarea[name=question]").val();
			if(!question){
				showToast("输入的问题内容不能为空");
				return;
			}
			
			if(!flag){
				showToast("请选择一个正确答案");
				return;
			}
			
			
			
			for(var i = 0;i<delArray.length;i++){

				delList.push(delArray[i].attr("id"));
			}
			
			var status = $("input[name=status]").val();
			
			status = parseInt(status);
			
			var isFirst = $("input[name=isFirst]").val();
			
			
			
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
				
				
				var jsonOption = JSON.stringify(optionMap);
				params.options = jsonOption;
				var url = "/api/vie/draw/vie_red_pack/hand_problem";
				
				var callback = new Object();
				callback.success = function(resp){
					if(!resp.success){
						showToast("网络繁忙，请稍后再试",5000);
					}else{
						var problemId = resp.data.id;
						skipToVieSetProblem(0,redPacketId,null,problemId)
					}
					
				}
				request(url,callback,params);
			}else if(status==1){
				//数据库管理状态
				
				var params = new Object();
				params.type = 1;
				params.is_first = isFirst;
				params.question = question;
				params.red_packet_id = redPacketId;
				params.previous_problem_id = previousOption;
				params.problem_id = id;
				var jsonOption = JSON.stringify(optionMap);
				params.options = jsonOption;
				var url = "/api/vie/draw/vie_red_pack/hand_problem";
				
				
				var callback = new Object();
				callback.success = function(resp){
					
					
					if(!resp.success){
						showToast("网络繁忙，请稍后再试",5000);
					}else{
						showToast("保存成功",5000);
					}
					
				}
				request(url,callback,params);
			}
		}
	</script>
			
</tiles:putAttribute>
</tiles:insertDefinition>

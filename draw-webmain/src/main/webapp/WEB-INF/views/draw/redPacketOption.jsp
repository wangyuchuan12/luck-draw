<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="resourceLayout">
<tiles:putAttribute name="title">问答红包选项卡</tiles:putAttribute>
<tiles:putAttribute name="body">
	
	<div class="option_items_headers">
		<div class="option_items_header" id="addButton">
			<em class="fa fa-plus-square-o" style="color: red"></em>
			<span>新增</span>
		</div>
		
		<div class="option_items_header" id="saveButton">
			<em class="fa fa-save" style="color: green;"></em>
			<span>保存</span>
		</div>
	</div>

	<div class="option_items">
		
		<c:forEach items="${options}" var="option">
			<div class="option_item" status=0 isDel=0 id="${option.id}">
				<div class="option_item_label">答案：</div>
				<input value="${option.answer}"/> 
				<em class="fa fa-close"></em>
			</div>
		</c:forEach>
		
	</div>
	
	<input name="repacketId" value="${id}" type="hidden"/>
	<input name="answer" value="${answer}" type="hidden"/>
	
	<script type="text/javascript">
	
	
		function save(){
			
			var answer = $("input[name=answer]").val();
			var updateArray = new Array();
			var deleteArray = new Array();
			var addArray = new Array();
			var seq = 0;
			
			var flag = false;
			
			
			var flag2 = false;
			
			$(".option_item").each(function(){
			
				seq = seq+1;
				var status = $(this).attr("status");
				
				
				
				if(!$(this).children("input").val()){
					$(this).children(".option_item_label").css("color","red");
					showErrorToast("文本不能为空");
					flag = true;
					return;
					
				}

				/*if($(this).children("input").val().length!=answer.length){
					$(this).children(".option_item_label").css("color","red");
					showErrorToast("文本字数不匹配,答案必须是"+answer.length+"个字");
					
					$(this).children("input").css("color","black");
					flag = true;
					return;
				}*/
				
				if($(this).children("input").val()==answer){
					flag2 = true;
				}
				
				if(status==0){
					var isDel = $(this).attr("isDel");
					if(isDel==1){
						deleteArray.push($(this).attr("id"));
					}else if(isDel==0){
						var obj = new Object();
						obj.id = $(this).attr("id");
						
						obj.answer = $(this).children("input").val();
						
						obj.seq = seq;
						updateArray.push(obj);
					}
				}else if(status==1){
					
					if($(this).children("input").val()){
						var addObject = new Object();
						
						addObject.id = $(this).attr("id");
						
						addObject.seq = seq;
						
						addObject.answer = $(this).children("input").val();
						
						addArray.push(addObject);
					}
					
				}
				
				
			});
			
			if(flag){
				hideLoading();
				return;
			}
			
			if(!flag2){
				hideLoading();
				showErrorToast("必须要有一个正确答案");
				return;
			}
			
			var responseObject = new Object();
			
			responseObject.id = $("input[name=repacketId]").val();
			
			responseObject.add = addArray;
			responseObject.del = deleteArray;
			responseObject.update = updateArray;
			
			var callback = new Object();
			
			callback.success = function(resp){
				var repacketId = $("input[name=repacketId]").val();
				skipToRedPackInfo(repacketId);
			}
			
			var params = new Object();
			
			params.data = JSON.stringify(responseObject);
			request("/api/draw/red_pack/hand_red_packet_option",callback,params);
			
		}
		function guid() {
		    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
		        var r = Math.random()*16|0, v = c == 'x' ? r : (r&0x3|0x8);
		        return v.toString(16);
		    });
		}
		
		
		function addInput(value){
			
			if($(".option_item").size()>=50){
				showErrorToast("选项不能超过50个");
				hideLoading();
				return;
			}
			
			var array = new Array();
			
			var token = guid();
			
			var itemDiv = $("<div class='option_item' status=1 token='"+token+"'><div class='option_item_label'>答案：</div><input /><em class='fa fa-close'></em></div>");
			$(".option_items").append(itemDiv);
			$(".option_item>em").click(function(){
				delInput($(this).parent());
			});
			
			$("input").keyup(function(){
				inputCheck($(this));
			});
			
			var input = itemDiv.children("input");
			input.attr("placeholder","请输入答案");
			
		}
		
		function delInput(inputDiv){
			if(inputDiv.attr("status")==1){
				inputDiv.remove();
			}else if(inputDiv.attr("status")==0){
				inputDiv.attr("isDel",1);
				inputDiv.css("display","none");
			}
			
		}
		
		function inputCheck(input){
			var answer = $("input[name=answer]").val();
			if(!input.val()){
				input.parent().children(".option_item_label").css("color","red");
				showErrorToast("文本不能为空");
			}else{
				input.parent().children(".option_item_label").css("color","black");
				hideErrorToast("文本不能为空");
			}
			
			
			if(input.val().length!=answer.length){
				/*
					input.parent().children(".option_item_label").css("color","red");
				*/
			}else{
				input.parent().children(".option_item_label").css("color","black");
				input.css("color","black");
			}
			
			input.attr("placeholder","请输入答案");
		}
		
		$(document).ready(function(){
			
			
			$("input").keyup(function(){
				inputCheck($(this));
			});
			$("#addButton").click(function(){
				addInput();
			});
			
			$("#saveButton").click(function(){
				
				showLoading();
				save();
			});
			$(".option_item>em").click(function(){
				delInput($(this).parent());
			});
			
		});
	
	</script>
			
			
</tiles:putAttribute>


</tiles:insertDefinition>



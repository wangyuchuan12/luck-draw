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
				<input value="${option.answer}"/> 
				<em class="fa fa-close"></em>
			</div>
		</c:forEach>
		
	</div>
	
	<input name="repacketId" value="${id}" type="hidden"/>
	<input name="answer" value="${answer}" type="hidden"/>
	
	<script type="text/javascript">
	
	
		function save(){
			var updateArray = new Array();
			var deleteArray = new Array();
			var addArray = new Array();
			var seq = 0;
			$(".option_item").each(function(){
				seq = seq+1;
				var status = $(this).attr("status");
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
			
			var array = new Array();
			
			var token = guid();
		
			var itemDiv = $("<div value='"+value+"' class='option_item' status=1 token='"+token+"'><input/><em class='fa fa-close'></em></div>");
			$(".option_items").append(itemDiv);
			$(".option_item>em").click(function(){
				delInput($(this).parent());
			});
			
		}
		
		function delInput(inputDiv){
			if(inputDiv.attr("status")==1){
				inputDiv.remove();
			}else if(inputDiv.attr("status")==0){
				inputDiv.attr("isDel",1);
				inputDiv.css("display","none");
			}
			
		}
		$(document).ready(function(){
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
			
			var flag = false;
			$(".option_item").each(function(){
				if($(this).children("input").val()==$("input[name=answer]").val()){
					flag = true;
				}
			});
			
			if(!flag){
				addInput($("input[name=answer]").val());
			}
		});
	
	</script>
			
			
</tiles:putAttribute>


</tiles:insertDefinition>



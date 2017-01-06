<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="formLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
<tiles:putAttribute name="body">

	<style type="text/css">

			
	
	</style>
	<div data-role="page">  
  
    <div data-role="header">  
        <h1>新增房间</h1>  
    </div>  
    
    
      
    <div data-role="content">  
          
        <form action="javascript:return false;" method="post" class="validate" id="addDrawRoomForm">  
        
        
        <div data-role="fieldcontain">  
            <label for="img">上传图片:</label>  
            <input type="hidden" name="img" id="img" value=""  />
            <div class="form_head_img">
            	<img src="http://wx.qlogo.cn/mmopen/xPXrGtX7mxzVLiacuLGmhCugiccm8EcaPiaFYOaQ74EPBGFvkV0U7Mgy35raJRJfHfY3RF5XQwvscTDCzZuicTe5HA/0">
        	</div>
        	
        	<div class="addImgItem">
		    		<em class="fa fa-plus"></em>
		    		<img src/>
		    </div>
        </div>
              
        <div data-role="fieldcontain inputError">  
            <label for="name">房间名称:</label>  
            <input type="text" name="name" id="name" value=""  /> 
            <label for="name" class="error"></label>
        </div>      
  
        <div data-role="fieldcontain">
		    <label for="isVerify">是否验证:</label>
		    <select name="isVerify" data-role="slider" id = "isVerify">
		      <option value="0">否</option>
		      <option value="1">是</option>
		     
		    </select>
		     <label for="isVerify" class="error"></label>
	  	</div>
	  	
	  	
	  	<div data-role="fieldcontain" id="verifyTypeDiv">
		    <label for="verifyType">验证方式:</label>
		    <select name="verifyType" data-role="slider" id = "verifyType">
		      <option value="0">密码</option>
		      <option value="1">问题</option>
		      
		    </select>
		    
		    <label for="verifyType" class="error"></label>
	  	</div>
        
        <div data-role="fieldcontain" id = "passwordDiv">  
            <label for="password">密码:</label>  
            <input type="password" name="password" id="password" value=""  />  
            <label for="password" class="error"></label>
        </div>      
        
         <div data-role="fieldcontain" id="confirmPasswordDiv">  
            <label for="confirmPassword">确认密码:</label>  
            <input type="password" name="confirmPassword" id="confirmPassword" value=""  />  
            <label for="confirmPassword" class="error"></label>
        </div>  
        
        
        <div data-role="fieldcontain" id ="verifyQuestionDiv">
		    <label for="verifyQuestion">请输入问题:</label>
		    <input type="text" name="verifyQuestion" id="verifyQuestion" value=""  />  
		    <label for="verifyQuestion" class="error"></label>
	  	</div>
	  	
	  	<div data-role="fieldcontain" id = "verifyAnswerDiv">
		    <label for="verifyAnswer">问题答案:</label>
		    <input type="text" name="verifyAnswer" id="verifyAnswer" value=""  /> 
		    <label for="verifyAnswer" class="error"></label>
	  	</div>
  
        <div data-role="fieldcontain">  
            <input id="submit" type="submit" name="submit" value="提交"  />  
        </div>      
          
        </form>  
  
    </div>  
  
</div> 

<script type="text/javascript">
	
	
	
	
	function submit(){
		
		
		$("#addDrawRoomForm").validate({
			submitHandler:function(form){
				showLoading();
				var name = $("#name").val();
				var password = $("#password").val();
				var verifyAnswer = $("#verifyAnswer").val();
				var verifyQuestion = $("#verifyQuestion").val();
				var isVerify = $("#isVerify").val();
				var verifyType = $("verifyType").val();
				var params = new Object();
				params.token = "aeff346a-e9fe-4729-b59b-9b87141cb80e";
				params.name = name;
				params.password = password;
				params.verifyAnswer = verifyAnswer;
				params.verifyQuestion = verifyQuestion;
				params.isVerify = isVerify;
				$.ajax({
					url:'/api/do_add_draw_room',
					data:params,
					success:function(obj){
						alert(obj.success);
						alert(obj.msg);
						alert(obj.errorMsg);
						
					},
					failure:function(obj){
						alert("failure");
					}
				});
			},
			rules: {
				name: {
					required: true,
					minlength: 2,
					maxlength:7
				},
				password: {
					required: true,
					minlength: 3,
					maxlength:7
				},
				confirmPassword: {
					required: true,
					minlength: 5,
					maxlength:7,
					equalTo: "#password"
				},
				email: {
					required: true,
					email: true
				},
				topic: {
					required: "#newsletter:checked",
					minlength: 2
				},
				agree: "required"
			},
			messages: {
				name: {
					required: "请输入房间名",
					minlength: "最小长度不能小于2个字节",
					maxlength:"最大长度不能超过7个字节"
				},
				password: {
					required: "请输入密码",
					minlength: "最小长度不能小于3个字节",
					maxlength: "最大长度不能超过7个字节"
				},
				confirmPassword: {
					required: "请输入确认密码",
					equalTo: "确认密码需要和密码值相同"
				}
			}
		});
		
		
	}

	
	
	
	verifyChange();
	
	function verifyChange(){
		var isVerify = $("#isVerify").val();
		var verifyType = $("#verifyType").val();
		verifyHandle(isVerify,verifyType);
	}
	function verifyHandle(isVerify,verifyType){
		if(isVerify=="0"){
			$("#verifyTypeDiv").css("display","none");
			$("#passwordDiv").css("display","none");
			$("#confirmPasswordDiv").css("display","none");
			$("#verifyQuestionDiv").css("display","none");
			$("#verifyAnswerDiv").css("display","none");
		}else{
			
			$("#verifyTypeDiv").css("display","block");
			$("#password").val("");
			$("#confirmPassword").val("");
			$("#verifyQuestion").val("");
			$("#verifyAnswer").val("");
			if(verifyType=="0"){
				$("#passwordDiv").css("display","block");
				$("#confirmPasswordDiv").css("display","block");
				$("#verifyQuestionDiv").css("display","none");
				$("#verifyAnswerDiv").css("display","none");
				
			}else{
				$("#passwordDiv").css("display","none");
				$("#confirmPasswordDiv").css("display","none");
				$("#verifyQuestionDiv").css("display","block");
				$("#verifyAnswerDiv").css("display","block");
			}
			
		}
	}
	
	$("#verifyType").change(function(value){
		verifyChange();
		
	});
	
	$("#isVerify").change(function(value){
		verifyChange();
		
	});
	
	
	$("#submit").click(function(){
			
		submit();
		
		
		
	});
	
	
</script>
			
			
</tiles:putAttribute>
</tiles:insertDefinition>

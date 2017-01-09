<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="formLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
<tiles:putAttribute name="body">
 
<script src="/js/jquery.ui.widget.js"></script>
<script src="/js/jquery.iframe-transport.js"></script>
<script src="/js/jquery.fileupload.js"></script>
	<style type="text/css">

			
	
	</style>
	<div data-role="page">  
  
    <div data-role="header">  
        <h1>新增房间</h1>  
    </div>  
    
    
      
    <div data-role="content">  
          
        <form action="javascript:return false;" method="post" class="validate" id="addDrawRoomForm">  
        
        
        <div data-role="fieldcontain"> 
	        <label for="file">上传图片:</label>   
	        <div id="addCommodityIndex"></div>
        </div>
              
        <div data-role="fieldcontain">  
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

<style type="text/css">



</style>

<script type="text/javascript">

var callback = new Object();
callback.success = function(){
}

toImg("/api/common/resource/upload","#addCommodityIndex","file",callback)






	$(document).ready(function(){
		hideLoading();
	});
	
	function submit(){
		
		
		var fileupload = $("input[type='file']").fileupload({
			url:"/api/common/resource/upload",
			dataType: 'json',
			add: function (e, data) {
				alert(data);
				var numItems = $('.files .images_zone').length;
				if(numItems>=10){
					alert('提交照片不能超过3张');
					return false;
				}
				$('.up_progress .progress-bar').css('width','0px');
				$('.up_progress').show();
				$('.up_progress .progress-bar').html('Uploading...');
				data.submit();
			},
			done: function (e, data) {
				$('.up_progress').hide();
				$('.upl').remove();
				var d = data.result;
				if(d.status==0){
					alert("上传失败");
				}else{
					var imgshow = '<div class="images_zone"><input type="hidden" name="imgs[]" value="'+d.msg+'" /><span><img src="'+d.msg+'"  /></span><a href="javascript:;">删除</a></div>';
					jQuery('.files').append(imgshow);
				}
			},
			progressall: function (e, data) {
				console.log(data);
				var progress = parseInt(data.loaded / data.total * 100, 10);
				$('.up_progress .progress-bar').css('width',progress + '%');
			}
		});
		
		
		
		
		verifyInit();
	
	}

	
	
	
	
	verifyChange();
	
	function verifyInit(){
		
		
		
		jQuery.validator.addMethod("checkPicSize", function(value,element) {
			return true;
		}, "请先上传图片");
		
		$("#addDrawRoomForm").validate({
			submitHandler:function(form){
				showLoading();
				var name = $("#name").val();
				var password = $("#password").val();
				var verifyAnswer = $("#verifyAnswer").val();
				var verifyQuestion = $("#verifyQuestion").val();
				var isVerify = $("#isVerify").val();
				var verifyType = $("#verifyType").val();
				var imgUrl = $("#var_file").val();
				var params = new Object();
				params.token = "aeff346a-e9fe-4729-b59b-9b87141cb80e";
				params.name = name;
				params.password = password;
				params.verifyAnswer = verifyAnswer;
				params.verifyQuestion = verifyQuestion;
				params.isVerify = isVerify;
				params.verifyType = verifyType;
				params.imgUrl = imgUrl;
				var callback = new Object();
				callback.success = function(resp){
					if(resp.success){
						skipToUrl("/view/draw/draw_room/info?id="+resp.data.id,null,false);
					}else{
						hideLoading();
						layer.alert("现在使用高峰期，稍后再试");
					}
					
				}
				callback.failure = function(){
					hideLoading();
					layer.alert("现在使用高峰期，稍后再试");
				}
				
				
				request("/api/draw/draw_room/add",callback,params);
			},
			rules: {
				name: {
					checkPicSize:true,
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
					minlength: 3,
					maxlength:7,
					equalTo: "#password"
				},
				var_file:{
					required: true
				}
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
					equalTo: "确认密码需要和密码值相同",
					minlength: "最小长度不能小于3个字节",
					maxlength: "最大长度不能超过7个字节"
				},
				var_file:{
					required: "未选中一张图片"
				}
				
			}
		});
	}
	
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

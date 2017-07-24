<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en" style="width: 100%;height: 100%;">
<head>
	<meta name="viewport"
		content="width=device-width,user-scalable=no">
	 <meta name="format-detection" content="telephone=no">
	 <meta http-equiv="Pragma" content="no-cache">   
	 <meta http-equiv="Cache-Control" content="no-store">
	 <meta http-equiv="Expires" content="0">
	 <title>问答红包</title>
<tiles:insertAttribute name="resource"/>
<tiles:insertAttribute name="baseLayout"/>
<tiles:insertAttribute name="body" />
<script type="text/javascript">
	var paperFlowPlug;
	var paperPlug;
	function init(){
		paperPlug = new FlowPlug({
			begin:function(){
				paperFlowPlug = this;
				this.flowData({
					currentIndex:0
				});
			},
			
			initPaper:function(){
				var outThis = this;
				var paperId = this.stepData("paperId");
				var keyId = this.stepData("keyId");
				
				this.flowData({currentPaper:paperId});
				this.setNext("requestPaper",function(data){
					var paper = data.paper;
					var questions = data.questions;
					for(var i = 0;i<questions.length;i++){
						var question = questions[i];
						outThis.setNext("addQuestion");
						
						outThis.nextData({
							paperId:paperId,
							index:question.index,
							question:question
						});
						
						
						outThis.next();
					}
					outThis.success();
				});
				this.nextData({
					paperId:paperId,
					keyId:keyId
				});
				this.next();
			},
			requestPaper:function(){
				var outThis = this;
				var paperId = this.stepData("paperId");
				var keyId = this.stepData("keyId");
				var url = "/api/draw/question/answerPaper";
				
				var callback = new Object();
				callback.success = function(resp){
					if(resp.success){
						outThis.success(resp.data);
					}
				}
				var params = new Object();
				params.paperId = paperId;
				params.keyId = keyId;
				request(url,callback,params);
			},
			requestAnswerPaper:function(){
				var outThis = this;
				var paperId = this.stepData("paperId");
				var memberId = this.stepData("keyId");
			},
			requestQuestion:function(){
				
			},
			addQuestion:function(){
				var paperId = this.stepData("paperId");
				var index = this.stepData("index");
				
				var question = this.stepData("question");
				var index = question.index;
				
				var object = new Object();
				object["paperId_"+paperId+"_index_"+index] = question;
				this.flowData(object);
			},
			
			getQuestion:function(){
				var paperId = this.stepData("paperId");
				var index = this.stepData("index");
				var question = this.flowData("paperId_"+paperId+"_index_"+index);
				
				this.success(question);
			},
			lastQuestion:function(){
				var outThis = this;
				var currentIndex = this.flowData("currentIndex");
				var currentPaper = this.flowData("currentPaper");
				if(!currentIndex){
					currentIndex = 0;
				}
				currentIndex--;
				
				if(currentIndex<=0){
					outThis.fail();
					return;
				}

				this.setNext("getQuestion",function(question){
					
					if(question){
						outThis.success(question);
						outThis.flowData({
							currentIndex:currentIndex,
							currentPaper:currentPaper
						});
					}else{
						outThis.fail();
					}
				});
				this.nextData({
					paperId:currentPaper,
					index:currentIndex
				});
				this.next();
			},
			nextQuestion:function(){
				var outThis = this;
				var currentIndex = this.flowData("currentIndex");
				var currentPaper = this.flowData("currentPaper");
				if(!currentIndex){
					currentIndex = 0;
				}
				currentIndex++;

				this.setNext("getQuestion",function(question){
					
					if(question){
						outThis.success(question);
						outThis.flowData({
							currentIndex:currentIndex,
							currentPaper:currentPaper
						});
					}else{
						outThis.fail();
					}
				});
				
				this.nextData({
					paperId:currentPaper,
					index:currentIndex
				});
				this.next();
			}
		});
	}
</script>
</head>
<body>
    
</body>
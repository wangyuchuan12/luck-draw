<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>

<tiles:insertDefinition name="paperLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
<tiles:putAttribute name="body">


<input name="paperId"  type="hidden" value="${paperId}"/>
<input name="questionId"  type="hidden" value="${question.id}"/>

<input name="questionCount" type="hidden" value="${paper.questionCount}"/>

<input name="keyId" type="hidden" value="${keyId}"/>

<input name="type" type='hidden' value="${type}"/>



			
			<div style="width:100%;height:100%;background-color:white;"></div>
			<script type="text/javascript">
				var initFun;
				var layerPlug;
				var questionInfoFlowPlug;
				function z_close(){
					//layerPlug.close();
				}
				
				function checkOption(questionId,optionId,isRight,overTimeLong,isTimeout){
					var content;
					if(isRight){
						new MsgPlug("回答正确",2);
					}else{
						new MsgPlug("回答错误",2);
					}
					setTimeout(function(){
						initFun.setNext("submitSubjectAction");
						initFun.nextData({
							questionId:questionId,
							optionId:optionId,
							isRight:isRight,
							overTimeLong:overTimeLong,
							isTimeout:isTimeout
						});
						initFun.next();
					},10);
				}
				
			
				$(document).ready(function(){
					
					
					var flowJs = flowJS({
						init:function(){
							
							init();
							var outThis = this;

							initFun = this;
							
							this.setNext("setData");
							
							this.next();
							
							var paperId = $("input[name=paperId]").val();
							
							paperFlowPlug.setNext("initPaper",function(){
								var interval = setInterval(function(){
									if(outThis.flowData("questionPLugReady")==1){
										outThis.setNext("nextSubjectAction");
										outThis.next();
										clearInterval(interval);
									}
								},10);
								
								setTimeout(function(){
									outThis.setNext("initLayPlug");
									outThis.next();
								},10);
							});
							paperFlowPlug.nextData({
								paperId:paperId
							});
							paperFlowPlug.next();
							
							
						},
						
						setData:function(){
							var questionId = $("input[name=questionId]").val();
							var questionCount = $("input[name=questionCount]").val();
							var keyId = $("input[name=keyId]").val();
							var type = $("input[name=type]").val();
							if(!type){
								type = 0;
							}
							this.flowData({
								questionId:questionId,
								questionCount:questionCount,
								answerCount:0,
								keyId:keyId,
								type:type
							});
						},
									
						nextSubjectAction:function(){
							this.setNext("nextQuestionData",function(question){
								questionInfoFlowPlug.setNext("setData");
								var options = new Array();
								
								for(var i = 0;i<question.options.length;i++){
									options.push({
										id:question.options[i].id,
										content:question.options[i].content
									});
								}
								
								questionInfoFlowPlug.nextData({
									count:5,
									timeLong:20,
									index:question.index,
									imgUrl:question.imgUrl,
									options:options,
									question:question.question,
									id:question.id,
									rightOptionId:question.rightOptionId
								});
								
								questionInfoFlowPlug.next();
								
								questionInfoFlowPlug.setNext("clearData");
								questionInfoFlowPlug.next();
								
								questionInfoFlowPlug.setNext("showView");
								questionInfoFlowPlug.next();
								
								layerPlug.show();
							});
							
							this.next();
						},
						
						initLayPlug:function(){
							var outThis = this;
							layerPlug = new LayerPlug("/view/question/info",1,1,"",function(){
								var callback = new Object();
								callback.setQuestionInfoCallback = function(plug){
									questionInfoFlowPlug = plug;
									outThis.success();
									//这个属性是为了告诉系统改插件已经准备好了
									outThis.flowData({questionPLugReady:1});
									
									
									/*questionInfoFlowPlug.setNext("showView");
									questionInfoFlowPlug.next();*/
									
								}
								layerPlug.call("init",callback);
							});
							
							layerPlug.show();
							
							layerPlug.hide();
						},
						
						nextQuestionData:function(){
							var outThis = this;
							paperFlowPlug.setNext("nextQuestion",function(question){
								
								outThis.success(question);
								
							},function(){
								outThis.fail();
							});
							
							paperFlowPlug.next();
							
							
						},
						
						submitSubjectAction:function(){
							var questionId = this.stepData("questionId");
							var optionId = this.stepData("optionId");
							var isRight = this.stepData("isRight");
							var overTimeLong = this.stepData("overTimeLong");
							var isTimeout = this.stepData("isTimeout");
							this.nextData({
								questionId:questionId,
								optionId:optionId,
								isRight:isRight,
								overTimeLong:overTimeLong,
								isTimeout:isTimeout
							});
							
							var outThis = this;
							this.setNext("answerQuestion",function(data){
								var answerCount = outThis.flowData("answerCount");
								var questionCount = outThis.flowData("questionCount");
								answerCount++;
								
								outThis.flowData({
									answerCount:answerCount
								});
								if(answerCount<questionCount){
									outThis.setNext("nextSubjectAction");
									outThis.next();
								}else{
									window.parent.submitScore(data.score);
								}
							});
							this.next();
						},
						
						answerQuestion:function(){
							var url = "/api/draw/question/answerQuestion";
							var params = new Object();
							var questionId = this.stepData("questionId");
							var optionId = this.stepData("optionId");
							var isRight = this.stepData("isRight");
							var overTimeLong = this.stepData("overTimeLong");
							var isTimeout = this.stepData("isTimeout");
							
							var paperId = $("input[name=paperId]").val();
							var keyId = this.flowData("keyId");
							
							var type = this.flowData("type");
							
							params.paperId = paperId;
							params.questionId = questionId;
							params.isTimeout = isTimeout;
							params.timelong = overTimeLong;
							params.optionId = optionId;
							params.paperId = paperId;
							params.keyId = keyId;
							params.type = type;
						
							var outThis = this;
							request(url,{
								success:function(resp){
									if(resp.success){
										outThis.flowData({
											score:resp.data.score
										});
										outThis.success(resp.data);
									}else{
										outThis.fail();
									}
								},
								failure:function(){
									outThis.fail();
								}
							},params);
						}
					});
				});
			</script>
</tiles:putAttribute>
</tiles:insertDefinition>


<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>

<tiles:insertDefinition name="resourceLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
<tiles:putAttribute name="body">


<input name="paperId"  type="hidden" value="${paperId}"/>
<input name="questionId"  type="hidden" value="${question.id}"/>

<input name="questionCount" type="hidden" value="${paper.questionCount}"/>

<input name="keyId" type="hidden" value="${keyId}"/>



			
			<div style="width:100%;height:100%;background-color:white;"></div>
			<script type="text/javascript">
				var initFun;
			
				function checkOption(questionId,optionId,isRight,overTimeLong,isTimeout){
					var content;
					if(isRight){
						var wait = new WaitPlug("回答正确");
					}else{
						var wait = new WaitPlug("回答错误");
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
					var layerPlug;
					
					var flowJs = flowJS({
						init:function(){
							var outThis = this;
							var progressCallback = new Object();
							var keyId = $("input[name=keyId]").val();
							progressCallback.complete = function(){
								var questionId = $("input[name=questionId]").val();
								var questionCount = $("input[name=questionCount]").val();
								outThis.flowData({
									questionId:questionId,
									questionCount:questionCount,
									answerCount:0,
									keyId:keyId
								});
								outThis.setNext("openLayerPlug");
								outThis.next();
							};
							progress(100,10,progressCallback);
							initFun = this;
						},
						
						nextSubjectRequest:function(){
							var paperId = $("input[name=paperId]").val();
							var url = "/api/draw/question/randomQuestion?id="+paperId;
							var outThis = this;
							var callback = new Object();
							callback.success = function(resp){
								if(resp.success){
									if(resp.data){
										outThis.success(resp.data.id);
									}else{
										var score = outThis.flowData("score");
										
										window.parent.submitScore(score);
									}
									
								}else{
									outThis.fail();
								}
							}
							
							callback.failure = function(resp){
								outThis.fail();
							}
							
							request(url,callback);
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
							
							params.paperId = paperId;
							params.questionId = questionId;
							params.isTimeout = isTimeout;
							params.timelong = overTimeLong;
							params.optionId = optionId;
							params.paperId = paperId;
							params.keyId = keyId;
						
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
						},
						
						nextSubjectAction:function(){
							var outThis = this;
							var answerCount = this.flowData("answerCount");
							this.setNext("nextSubjectRequest",function(questionId){
								outThis.setNext("openLayerPlug");
								outThis.flowData({
									questionId:questionId,
									content:"第"+(answerCount+1)+"题"
								});
								outThis.next();
							});
							
							this.next();
						},
						
						openLayerPlug:function(){
							if(layerPlug){
								layerPlug.close();
							}
							var id = this.flowData("questionId");
							var content = this.flowData("content");
							layerPlug = new LayerPlug("/view/question/info?id="+id,1,1,content);
						
						}
					});
				});
			</script>
</tiles:putAttribute>
</tiles:insertDefinition>


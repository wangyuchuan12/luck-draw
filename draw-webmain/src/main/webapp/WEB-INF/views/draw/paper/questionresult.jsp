<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>

<tiles:insertDefinition name="paperLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
<tiles:putAttribute name="body">
<input type="hidden" name="paperId" value="${paperId}"/>
<input type="hidden" name="keyId" value="${keyId}"/>
	<div class="subjectContainer" id="subjectContainer">
			<div>
				<div class="questionresultTool" style="position: relative;">
					<div class="questionresultToolLast" id="lastButton">上一题</div>
					<div class="questionresultToolClose" id="closeButton">关闭</div>
					<div class="questionresultToolNext" id="nextButton">下一题</div>
				</div>
				<div class="subjectHeader" id="subjectHeader">
					<!--  	<div class="subjectHeaderContent" id="subjectHeaderContent">射雕英雄传是什么时候拍的</div> -->
						
				  	<div class="subjectHeaderImg" id="subjectHeaderImg" style="padding-bottom: 0px;margin-top: 50px;">
						<img src="">
						<div class="subjectHeaderImgQuestion" id="questionContent"></div>
					</div>
					
				</div>
				
				<div class="subjectOption" id="subjectOption">
					<ul>
						
					</ul>
				</div>
			
				<div class="questionResultTitle" id="questionResultTitle">答案解析</div>
				
				<div class="questionResultContent" id="questionResultContent"></div>
			</div>
		</div>


	<script type="text/javascript">
			$(document).ready(function(){
				var questionResultPlug = new FlowPlug({
					begin:function(){
						var outThis = this;
						init();	
						
						this.setNext("initPaper");
						this.next();
						
						setTimeout(function(){
							$(".questionresultTool").css("position","fixed");
						},1000);
						
					},
					
					initPaper:function(){
						var outThis = this;
						var paperId = $("input[name=paperId]").val();
						var keyId = $("input[name=keyId]").val();
						paperFlowPlug.setNext("initPaper",function(){
							outThis.setNext("initEventListener");
							outThis.next();
							
							outThis.setNext("nextQuestion");
							outThis.next();
						});
						paperFlowPlug.nextData({
							paperId:paperId,
							keyId:keyId
						});
						paperFlowPlug.next();
					},
					
					initEventListener:function(){
						var outThis = this;
						$("#lastButton").click(function(){
							outThis.setNext("lastQuestion");
							outThis.next();
						});
						$("#closeButton").click(function(){
							outThis.setNext("close");
							outThis.next();
						});
						$("#nextButton").click(function(){
							outThis.setNext("nextQuestion");
							outThis.next();
						});
						
						$("#closeButton").click(function(){
							window.parent.closeResult();
						});
					},
					lastQuestion:function(){
						var outThis = this;
						paperFlowPlug.setNext("lastQuestion",function(data){
							outThis.setNext("openQuestion");
							outThis.nextData({
								imgUrl:data.imgUrl,
								isImg:data.isImg,
								question:data.question,
								options:data.options,
								rightOptionId:data.rightOptionId,
								checkOptionId:data.checkOptionId
							});
							outThis.next();
							
						},function(){
							console.log("lastQuestionFailure");
						});
						paperFlowPlug.next();
					},
					nextQuestion:function(){
						var outThis = this;
						paperFlowPlug.setNext("nextQuestion",function(data){
							
							console.log("data:"+JSON.stringify(data));
							outThis.setNext("openQuestion");
							outThis.nextData({
								imgUrl:data.imgUrl,
								isImg:data.isImg,
								question:data.question,
								options:data.options,
								rightOptionId:data.rightOptionId,
								checkOptionId:data.checkOptionId,
								instruction:data.instruction
							});
							outThis.next();
							
						},function(){
							console.log("nextQuestionFailre");
						});
						paperFlowPlug.next();
					},
					close:function(){
						
					},
					openQuestion:function(){
						var imgUrl = this.stepData("imgUrl");
						var isImg = this.stepData("isimg");
						var question = this.stepData("question");
						var options = this.stepData("options");
						var rightOptionId = this.stepData("rightOptionId");
						var checkOptionId = this.stepData("checkOptionId");
						var instruction = this.stepData("instruction");
						$("#subjectHeaderImg img").attr("src",imgUrl);
						$("#questionContent").text(question);
						$("#questionResultContent").text(instruction);
						$("#subjectOption>ul>li").remove();
						
						
						for(var i = 0;i<options.length;i++){
							var liDiv = $("<li>"+options[i].content+"</li>");
							$("#subjectOption>ul").append(liDiv);
							
							if(options[i].id==checkOptionId){
								liDiv.css("background-color","red");
							}
							if(options[i].id==rightOptionId){
								liDiv.css("background-color","green");
							}
						}
						
						if(instruction){
							$("#questionResultTitle").css("display","block");
							$("#questionResultContent").css("display","block");
						}else{
							$("#questionResultTitle").css("display","none");
							$("#questionResultContent").css("display","none");
						}
						
					}
				});
			});
	</script>
</tiles:putAttribute>
</tiles:insertDefinition>
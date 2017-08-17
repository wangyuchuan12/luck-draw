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


<!--可无视-->
<link rel="stylesheet" type="text/css" href="/lbt/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="/lbt/css/default.css">
<!--主要样式-->
<link rel="stylesheet" type="text/css" href="/lbt/css/styles.css">

<tiles:insertAttribute name="resource"/>
<tiles:insertAttribute name="baseLayout"/>
<tiles:insertAttribute name="body" />
<script type="text/javascript" src='/lbt/js/stopExecutionOnTimeout.js?t=1'></script>
<script type="text/javascript" src='/lbt/js/velocity.min.js'></script>
<script type="text/javascript" src='/lbt/js/main.js'></script>

<div class="scene">
	<!-- page start -->
	<div class="page page-1 active">
		<div class="page--rotater"></div>
		<div class="page--content">
			<h1>Page 1</h1>
		</div>
	</div>
	<!-- page end -->
	<!-- page start -->
	<div class="page page-2">
		<div class="page--rotater"></div>
		<div class="page--content">
			<h1>Page 2</h1>
		</div>
	</div>
	<!-- page end -->
	<!-- page start -->
	<div class="page page-3">
		<div class="page--rotater"></div>
		<div class="page--content">
			<h1>Page 3</h1>
		</div>
	</div>
	<!-- page end -->
	<!-- page start -->
	<div class="page page-4">
		<div class="page--rotater"></div>
		<div class="page--content">
			<h1>Page 4</h1>
		</div>
	</div>
	<!-- page end -->
	<!-- page start -->
	<div class="page page-5">
		<div class="page--rotater"></div>
		<div class="page--content">
			<h1>Page 5</h1>
		</div>
	</div>
	<!-- page end -->
	<div class="rt-point">
		<span class="page-number page-number-1 active">1</span>
		<span class="page-number page-number-2">2</span>
		<span class="page-number page-number-3">3</span>
		<span class="page-number page-number-4">4</span>
		<span class="page-number page-number-5">5</span>
	</div>
	<!-- footer start -->
	<div class="footer">
		<div class="nav">
			<ul>
				<li class="nav--btn nav--btn-1 active" data-page="1"></li>
				<li class="nav--btn nav--btn-2" data-page="2"></li>
				<li class="nav--btn nav--btn-3" data-page="3"></li>
				<li class="nav--btn nav--btn-4" data-page="4"></li>
				<li class="nav--btn nav--btn-5" data-page="5"></li>
			</ul>
		</div>
	</div>
	<!-- footer end -->
</div>



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
<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>

<tiles:insertDefinition name="resourceLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
	<tiles:putAttribute name="body">
		<div class="subjectContainer" id="subjectContainer">
			<div class="subjectHeader" id="subjectHeader">
				<!--  	<div class="subjectHeaderContent" id="subjectHeaderContent">射雕英雄传是什么时候拍的</div> -->
					
			  	<div class="subjectHeaderImg" id="subjectHeaderImg">
					<img src="http://on3s1z2us.bkt.clouddn.com/theBrain.gif">
					
					<div class="subjectHeaderImgQuestion">这张图表示什么</div>
				</div>
				
				
			
			</div>
			
			<div class="subjectTool" id="subjectTool">4选1</div>
			
			<div class="subjectOption" id="subjectOption">
				<ul>
					<li>2014年</li>
					<li>2013年</li>
					<li>2012年</li>
					<li>2011年</li>
					<li>2010年</li>
				</ul>
			</div>
		</div>
		<script type="text/javascript">
			$(document).ready(function(){
				
				var callback = new Object();
				callback.complete = function(){
					invitationPlug = new LayerPlug("/view/dekornHandle/invitationPlug?token=2&gameId=1&type=1&gameCode=znm123&passScore="+33,0.8,0.7,"回答正确，第1题");
				}
				
				
				progress(100,10,callback);
				var width = $(document).width();
				var height = $(document).height();
				$("#subjectContainer").css("width",width);
				$("#subjectContainer").css("height",height);
				
				var headerHeight = $("#subjectHeader").height();
				
				var subjectHeaderContentHeight = $("#subjectHeaderContent").height();
				
				subjectHeaderContentLineHeight = (headerHeight-subjectHeaderContentHeight/2)/2;

				$("#subjectHeaderContent").css("padding-top",subjectHeaderContentLineHeight);
				
				
				

			});
		</script>
	</tiles:putAttribute>
</tiles:insertDefinition>



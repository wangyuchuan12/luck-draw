<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>

<tiles:insertDefinition name="resourceLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
<tiles:putAttribute name="body">
<script src="/js/jquery.ui.widget.js"></script>
<script src="/js/jquery.iframe-transport.js"></script>
<script src="/js/jquery.fileupload.js"></script>
	<body>
		<div class="addBattleModel">
			<div class="option_item" style="padding-left: 10px;"> 
				<div id="addCommodityIndex"></div>
			</div>
		
			<div class="inputItems">
				<div class="inputItem" id="questionItem">
					<div class="inputItemIcon">
						<span class="fa fa-question-circle-o"></span>
					</div>
					<div class="inputItemInput">
						<input placeholder="问题" name="answer">
					</div>
					
					
				</div>
				
				
				<div class="inputItem" id="questionTheme" >
					<div class="inputItemIcon">
						<span class="fa fa-file-o"></span>
					</div>
					<div class="inputItemInput">
						<div class="inputItemInputSelect"><span id="content">题目类别</span><span class="fa fa-angle-right"></span></div>
					</div>
				</div>
				
				<div id="editModel">
					
				</div>
				
			</div>
		</div>
		
		<div class="gameRedPacketFooter" id="saveButton">保存</div>
	</body>
</html>

<script type="text/javascript">
$(document).ready(function(){
	var eidtQuestionModel = new EditQuestionModel();
	
	eidtQuestionModel.load("#editModel",{
		success:function(){
			new AddQuestionBank(eidtQuestionModel);
		}
	});
	
});
</script>
</tiles:putAttribute>
</tiles:insertDefinition>
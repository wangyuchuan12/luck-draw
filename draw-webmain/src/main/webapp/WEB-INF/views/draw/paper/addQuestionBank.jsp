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
						<input placeholder="问题">
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
				
				<div class="inputTab">
					<ul>
						<li id="inputTabChoice">选择题</li>
						<li id="inputTabFillBlank">填空</li>
						<li id="inputTabFillTerms">填词</li>
					</ul>
				</div>
				
				
				<div id="inputItemChoice">
					<div class="inputItem">
						<div class="inputItemIcon">
							<span class="fa fa-check"></span>
						</div>
						<div class="inputItemInput">
							<input placeholder="答案1（正确答案）">
						</div>
					</div>
					
					<div class="inputItem">
						<div class="inputItemIcon">
							<span class="fa fa-times"></span>
						</div>
						<div class="inputItemInput">
							<input placeholder="答案2（错误答案）">
						</div>
					</div>
					
					<div class="inputItem">
						<div class="inputItemIcon">
							<span class="fa fa-times"></span>
						</div>
						<div class="inputItemInput">
							<input placeholder="答案3（错误答案）">
						</div>
					</div>
					
					<div class="inputItem">
						<div class="inputItemIcon">
							<span class="fa fa-times"></span>
						</div>
						<div class="inputItemInput">
							<input placeholder="答案4（错误答案）">
						</div>
					</div>
				</div>
				
				<div id="inputItemFillBlank">
					<div class="inputItem">
						<div class="inputItemIcon">
							<span class="fa fa-pencil-square-o"></span>
						</div>
						<div class="inputItemInput">
							<input placeholder="答案(不超过5个字)">
						</div>
					</div>
				</div>
				
				<div id="inputItemFillTerms">
				</div>
				
			</div>
		</div>
		
		<div class="gameRedPacketFooter" id="saveButton">保存</div>
	</body>
</html>

<script type="text/javascript">
$(document).ready(function(){
	var callback = new Object();
	callback.success = function(){
		
	}
	toBigerImg("/api/common/resource/upload","#addCommodityIndex","file",callback);
	
	var inputSelect = new InputSelect("#questionTheme",
				"#content",
				[{text:"1",value:"1value"},{text:"2"},{text:"3"},{text:"4"},{text:"5"},{text:"6"},{text:"7"},{text:"8"}],
				{select:function(value){
					
				}});
	
	var inputItem = new InputItem("#questionItem",{
		keyup:function(){
			
		}
	});
	
	var tabPanel = new TabPanel([{
									tab:"#inputTabChoice",
									content:"#inputItemChoice"
								},{
									tab:"#inputTabFillBlank",
									content:"#inputItemFillBlank"
								},{
									tab:"#inputTabFillTerms",
									content:"#inputItemFillTerms"
								}]);
	
	tabPanel.checkTab("#inputTabFillBlank");
	
	var inputItemFillTerms = new InputItemFillTerms("#inputItemFillTerms");
});
</script>
</tiles:putAttribute>
</tiles:insertDefinition>
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
		<div class="addBattleModel">
			<div class="option_item" style="padding-left: 10px;"> 
				<div id="addCommodityIndex"></div>
			</div>
		
			<div class="inputItems">
				<div class="inputItem" id="nameInputItem">
					<div class="inputItemIcon">
						<span class="fa fa-address-card"></span>
					</div>
					<div class="inputItemInput">
						<input placeholder="名称">
					</div>
				</div>
				
				<div class="inputItem" id="codeInputItem">
					<div class="inputItemIcon">
						<span class="fa fa-address-card"></span>
					</div>
					<div class="inputItemInput">
						<input placeholder="编号">
					</div>
				</div>
				
				<div class="inputItem" id="titleInputItem">
					<div class="inputItemIcon">
						<span class="fa fa-address-card"></span>
					</div>
					<div class="inputItemInput">
						<input placeholder="标题">
					</div>
				</div>
				
				<div class="inputItem" id="instructionInputItem">
					<div class="inputItemIcon">
						<span class="fa fa-address-card"></span>
					</div>
					<div class="inputItemInput">
						<input placeholder="说明">
					</div>
				</div>
				
				
			</div>
		</div>
		
		<div class="gameRedPacketFooter" id="saveButton">保存</div>
	</body>
	
	<script type="text/javascript">
	$(document).ready(function(){
		new AddBattleModel();
	});
	</script>
</tiles:putAttribute>
</tiles:insertDefinition>
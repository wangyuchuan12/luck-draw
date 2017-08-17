<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>


<tiles:insertDefinition name="resourceLayout">
	<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
	<tiles:putAttribute name="body">
		<input type="hidden" name="battleId" value="${battleId}"/>
		<div id="battleMainInfo" style="width:100%;height:100%;"></div>
	</tiles:putAttribute>
</tiles:insertDefinition>

<script type="text/javascript">
	var battleMainPlug = new BattleMainPlug();
	battleMainPlug.load("#battleMainInfo",{
		success:function(){
			
		}
	});
</script>



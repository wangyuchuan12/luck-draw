<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>

<tiles:insertDefinition name="resourceLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
<tiles:putAttribute name="body">
	<script type="text/javascript">
	
		
		$(document).ready(function(){
			var paperId = 1;
			var url = "/view/question/paperInfo?id="+paperId+"&token=2";
			
			var layerPlug = new LayerPlug(url,1,1);
			
			progress(100,10);
			
		});
	</script>
</tiles:putAttribute>
</tiles:insertDefinition>


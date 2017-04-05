<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="plugLayout">
	<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
	<tiles:putAttribute name="body">
		<div class="confirmPlug">
		
			<div class="confirmPlugContent">请问你需要我的帮助吗</div>
			<div class="confirmPlugButtons">
				<ul>
					<li id="quxiao">取消</li>
					<li>确定</li>
				</ul>
			</div>
		</div>
		
		<script type="text/javascript">
			$("#quxiao").click(function(){

			});
		</script>
	</tiles:putAttribute>
</tiles:insertDefinition>
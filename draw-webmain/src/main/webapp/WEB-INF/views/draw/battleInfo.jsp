<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>


<tiles:insertDefinition name="resourceLayout">
	<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
	<tiles:putAttribute name="body">
		<div id="battleInfo" style="width: 100%;height: 100%"></div>
	</tiles:putAttribute>
</tiles:insertDefinition>

<script type="text/javascript">

	function load(callback){
		var battleInfoPlug = new BattleInfoPlug();
		battleInfoPlug.load("#battleInfo",{
			success:function(){
				initPlug({
					success:function(){
						battleInfoPlug.init(callback);
						attrPlug2.showView();
					}
				});
				
			}
		});
	}
</script>

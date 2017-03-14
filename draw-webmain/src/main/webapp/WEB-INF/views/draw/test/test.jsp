<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="formLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
<tiles:putAttribute name="body">

<html>
	<script src="/jquery-validation-1.14.0/lib/jquery.js"></script>
	<script type="text/javascript" src="/layer/layer.js"></script>
	<div id="container">
		<div id="1" showModel="move" hideModel="move" destroy="destroy" animateTimeLong="500" url="/view/draw/main/home?token=1"></div>
		<div id="2" showModel="move" hideModel="move" destroy="destroy" animateTimeLong="500" url="/view/draw/personal_center/main?token=1"></div>
		<div id="3" showModel="move" hideModel="move" destroy="destroy" animateTimeLong="500" url="/view/draw/main/home?token=1"></div>
	</div>
</html>



<script type="text/javascript">
	 var actionMapper = new ActionMapper("#container");
	 actionMapper.paraseEntities();
	 actionMapper.show("1");
	 var page=1;
	 $("#container").click(function(){
		 actionMapper.show(page++);
		 
	 });
</script>

</tiles:putAttribute>
</tiles:insertDefinition>
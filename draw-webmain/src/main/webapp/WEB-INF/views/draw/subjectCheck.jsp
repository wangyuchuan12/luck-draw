<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="resourceLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
<tiles:putAttribute name="body">
	<div class="subject_check_header">
		<div class="subject_check_header_title">请选择红包的科目类型</div>
	</div>
	
	<div class="subject_check_items">
		<ul>
			<li style="border: 1px solid red;color:red">互联网</li>
			<li style="border: 1px solid blue;color:blue">电影</li>
			<li style="border: 1px solid yellow;color:yellow">健身</li>
			<li style="border: 1px solid yellow;color:yellow">职场</li>
			
			<li style="border: 1px solid yellow;color:yellow">旅行</li>
			
			<li style="border: 1px solid yellow;color:yellow">心理学</li>
			
			<li style="border: 1px solid yellow;color:yellow">音乐</li>
			
			<li style="border: 1px solid yellow;color:yellow">美食</li>
			
			<li style="border: 1px solid yellow;color:yellow">摄影</li>
			
			<li style="border: 1px solid yellow;color:yellow">金融</li>
			
			<li style="border: 1px solid yellow;color:yellow">阅读</li>
			
			<li style="border: 1px solid yellow;color:yellow">设计</li>
			
			<li style="border: 1px solid yellow;color:yellow">法律</li>
			
			<li style="border: 1px solid yellow;color:yellow">科技</li>
			
			<li style="border: 1px solid yellow;color:yellow">自然科学</li>
			
			<li style="border: 1px solid yellow;color:yellow">汽车</li>
			
			<li style="border: 1px solid yellow;color:yellow">健康</li>
			
			<li style="border: 1px solid yellow;color:yellow">体育</li>
			
			<li style="border: 1px solid yellow;color:yellow">动漫</li>
			
		</ul>
	</div>
	
	<div class="subject_check_button">选好了，下一步<span>→</span></div>
	
	<script type="text/javascript">
		$(document).ready(function(){
			
			
		});
		
	</script>
</tiles:putAttribute>
</tiles:insertDefinition>

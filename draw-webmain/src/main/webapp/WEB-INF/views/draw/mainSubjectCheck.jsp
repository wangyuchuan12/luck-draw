<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>


<tiles:insertDefinition name="resourceLayout">
	<tiles:putAttribute name="title">问答红包2</tiles:putAttribute>
	<tiles:putAttribute name="body">
		<div class="mainSubjectCheck">
		
			<div class="mainSubjectCheckContent">
				<ul>
					<!--  <li>
						<img src="/imgs/rank.jpg">
						<div class="mainSubjectCheckName">国文</div>
					</li>
					
					
					<li>
						<img src="/imgs/rank.jpg">
						<div class="mainSubjectCheckName">国文</div>
					</li> -->

				</ul>
			</div>
		</div>
	<script type="text/javascript">
		$(document).ready(function(){
			
			progress(100,10);
			
			var mainSubjectCheckPlug = new FlowPlug({
				
				begin:function(){
					
					
					var url = "/api/main/paperSubject?patternId=1";
					
					var callback = new Object();
					callback.success = function(resp){
						if(resp.success){
							var data = resp.data;
							for(var i = 0;i<data.length;i++){
								var liEl = $("<li><img src='"+data[i].imgUrl+"'><div class='mainSubjectCheckName'>"+data[i].name+"</div></li>");
								$(".mainSubjectCheckContent>ul").append(liEl);
							}
						}
					}
					var params = new Object();
					
					request(url,callback,params);
					
				}
				
			});
			
		});
	</script>
		
	</tiles:putAttribute>
</tiles:insertDefinition>

<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>

<input name="rightOptionId"  type="hidden" value="${question.rightOptionId}"/>
<tiles:insertDefinition name="resourceLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
<tiles:putAttribute name="body">
			
			<div style="width:100%;height:100%;background-color:white;"></div>
			<script type="text/javascript">
				
			
				function checkOption(questionId,optinId,isRight){
					var content;
					if(isRight){
						content = "第2题";
						var wait = new WaitPlug("回答正确");
					}else{
						content = "第2题";
						var wait = new WaitPlug("回答错误");
					}
					setTimeout(function(){
						openLayerPlug(2,content);
					},2000);
				}
				
				function openLayerPlug(id,content){
					var layerPlug = new LayerPlug("/view/question/info?id="+id,1,1,content);
				}
			
				$(document).ready(function(){
					
					progress(100,10);
					var flowJs = flowJS({
						init:function(){
							openLayerPlug(1);
						}
					});
				});
			</script>
	</tiles:putAttribute>
</tiles:insertDefinition>



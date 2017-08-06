<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>


<tiles:insertDefinition name="resourceLayout">
	<tiles:putAttribute name="title">问答红包2</tiles:putAttribute>
	<tiles:putAttribute name="body">
		<div class="mainThemeCheck">
		
			<div class="mainThemeCheckContent">
				<ul>
					
				</ul>
			</div>
		</div>
	<script type="text/javascript">
		$(document).ready(function(){
			
			function addEntity(imgUrl,name,title,userImgs,length){
				
				var userImgsStr="";
				
				var num = 0;
				if(userImgs){
					num = userImgs.length;
				}
				
				
				if(length){
					num = length;
				}
				
				
				if(userImgs&&userImgs.length){
					for(var i = 0;i<userImgs.length;i++){
						userImgsStr = userImgsStr+"<li><img src='"+userImgs[i]+"'></li>";
					}
				}
				var liStr =  "<li>"+
				 "<div class='mainThemeCheckItem'>"+
				 "<img src='"+imgUrl+"'>"+
				 "<div class='mainThemeCheckItemContent'>"+
				 "<div class='mainThemeCheckItemContentName'>"+name+"</div>"+
				 "<div class='mainThemeCheckItemContentDetail'>"+title+"</div>"+
				 "</div>"+
				 "<div class='mainThemeCheckButton'>挑战</div>"+
				 "</div>"+
				 "<div class='mainThemeCheckMember'>"+
				 "<div class='mainThemeCheckMemberUser'>"+
				 "<ul>"+
				 userImgsStr+
				 "</ul>"+
				 "</div>"+
				 "<span>"+num+"名用户参与该挑战</span>"+
				 "</div>"+
				 "</li>";
				 
				 var entryEl = $(liStr);
				 
				 $(".mainThemeCheckContent>ul").append(entryEl);
			}
			var progressCallback = new Object();
			progressCallback.complete = function(){
			//	attrPlug.show();
			//	modelPlug.show();
			
				
				
				
			}
			progress(100,10,progressCallback);
			
			var url = "/api/main/battleList";
			var callback = new Object();
			callback.success = function(resp){
				if(resp.success){
					var array = resp.data;
					
					
					for(var i = 0;i<array.length;i++){
						var entry = array[i];
						var imgArray = null; 
						if(entry.userImgs){
							imgArray = entry.userImgs.split(",");
						}
						
						addEntity(entry.imgUrl,entry.name,entry.title,imgArray);
					}
					
				}
			}
			request(url,callback,{});
			
			$(".mainThemeCheck").height($(document).height());
		});
	</script>
		
	</tiles:putAttribute>
</tiles:insertDefinition>

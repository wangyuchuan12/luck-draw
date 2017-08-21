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

	<div class="inputItems">
		<div class="inputItem" id="questionTheme" >
			<div class="inputItemIcon">
				<span class="fa fa-file-o"></span>
			</div>
			<div class="inputItemInput">
				<div class="inputItemInputSelect"><span id="content">题目类别</span><span class="fa fa-angle-right"></span></div>
			</div>
		</div>
	</div>
	
	
	<div id="questionList"></div>
	
	<script type="text/javascript">
		$(document).ready(function(){
			var picSelect = new PicSelectModel({
				success:function(){
					alert("success");
				},
				itemClick:function(id){
					alert(id);
				},
				toolbar:{name1:"name1",name2:"name2",hidden:true}
			});
			
			
			questionThemeInputSelect = new InputSelect("#questionTheme",
					"#content",
					{
						select:function(obj){
							var code = obj.code;
							loadData(code);
						},
						openAlert:function(){
							questionThemeInputSelect.openUrl("/api/manager/subjects");	
						}
					});
			
			function loadData(themeCode){
				var waidtPlug = new WaitPlug();
				var url = "/api/manager/questionBanksByThemeCode?themeCode="+themeCode;
				request(url,{
					failure:function(){
						waidtPlug.close();
					},
					success:function(resp){
						waidtPlug.close();
						if(resp.success){
							
							var showArray = new Array();
							var array = resp.data;
							
							for(var i =0;i<array.length;i++){
								var data = new Object();
								data.id = array[i].id;
								data.imgUrl = array[i].imgUrl;
								data.name = array[i].question;
								data.isChecked = 2;
								
								showArray.push(data);
							}
							picSelect.setData(showArray);
							picSelect.showView();
						}
					}
				},{});
			}
			
			picSelect.load("#questionList",{
				success:function(){
					questionThemeInputSelect.selectItemByUrl("/api/manager/subjects","1");
				}
			});
		});
	</script>
</tiles:putAttribute>
</tiles:insertDefinition>
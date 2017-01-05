<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="formLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
<tiles:putAttribute name="body">
	
	
	<div data-role="page">  
  
    <div data-role="header">  
        <h1>新增房间</h1>  
    </div>  
    
    
      
    <div data-role="content">  
          
        <form action="javascript:return false;" method="post">  
        
        
        <div data-role="fieldcontain">  
            <label for="name">上传图片:</label>  
            <input type="hidden" name="name" id="name" value=""  />
            <div class="form_head_img">
            	<img src="http://wx.qlogo.cn/mmopen/xPXrGtX7mxzVLiacuLGmhCugiccm8EcaPiaFYOaQ74EPBGFvkV0U7Mgy35raJRJfHfY3RF5XQwvscTDCzZuicTe5HA/0">
        	</div>
        	
        	<div class="addImgItem">
		    		<em class="fa fa-plus"></em>
		    		<img src/>
		    </div>
        </div>
              
        <div data-role="fieldcontain">  
            <label for="name">房间名称:</label>  
            <input type="text" name="name" id="name" value=""  />  
        </div>      
  
        <div data-role="fieldcontain">
		    <label for="switch">是否验证:</label>
		    <select name="switch" data-role="slider">
		      <option value="1">否</option>
		      <option value="0">是</option>
		      
		    </select>
	  	</div>
	  	
	  	
	  	<div data-role="fieldcontain">
		    <label for="switch">验证方式:</label>
		    <select name="switch" data-role="slider">
		      <option value="1">密码</option>
		      <option value="0">问题</option>
		      
		    </select>
	  	</div>
        
        <div data-role="fieldcontain">  
            <label for="email">密码:</label>  
            <input type="password" name="email" id="email" value=""  />  
        </div>      
        
         <div data-role="fieldcontain">  
            <label for="email">密码:</label>  
            <input type="password" name="email" id="email" value=""  />  
        </div>  
        
        
        <div data-role="fieldcontain">
		    <label for="switch">请输入问题:</label>
		    <input type="text" name="email" id="email" value=""  />  
	  	</div>
	  	
	  	<div data-role="fieldcontain">
		    <label for="switch">问题答案:</label>
		    <input type="text" name="email" id="email" value=""  />  
	  	</div>
  
        <div data-role="fieldcontain">  
            <input type="submit" name="submit" value="提交"  />  
        </div>      
          
        </form>  
  
    </div>  
  
</div>  
			
			
</tiles:putAttribute>
</tiles:insertDefinition>

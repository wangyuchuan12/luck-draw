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
        <h1>发起红包</h1>  
    </div>  
    
    
      
    <div data-role="content">  
          
        <form action="javascript:return false;" method="post">
              
        <div data-role="fieldcontain">  
            <label for="name">问题:</label>  
            <textarea type="text" name="name" id="name"></textarea>  
        </div> 
        
        <div data-role="fieldcontain">  
            <label for="name">答案（不超出7个字）:</label>  
            <textarea type="text" name="name" id="name"></textarea>  
        </div>      
  
       <div data-role="fieldcontain">  
            <fieldset data-role="controlgroup">
			  <legend>红包类型:</legend>
			  <input type="radio" name="radio-choice" id="radio-choice-1" value="0" checked="checked" />
			  <label for="radio-choice-1">个人</label>
			 
			  <input type="radio" name="radio-choice" id="radio-choice-2" value="1" />
			  <label for="radio-choice-2">房间</label>
			</fieldset>
        </div>
        
         <div data-role="fieldcontain">  
        	<fieldset data-role="fieldcontain">
			    <label for="day">选择房间</label>
			    <select name="room" id="room">
			      <option value="mon">房间1</option>
			      <option value="tue">房间2</option>
			      <option value="wed">房间3</option>
			    </select>
		  	</fieldset>
		  </div>
        
        
        <div data-role="fieldcontain">  
            <fieldset data-role="controlgroup">
			  <legend>支付:</legend>
			  <input type="radio" name="radio-choice2" id="radio-choice-3" value="0" checked="checked" />
			  <label for="radio-choice-3">余额 <font color="red" style="font-size: 10px;">剩余50元</font></label>
			 
			  <input type="radio" name="radio-choice2" id="radio-choice-4" value="1" />
			  <label for="radio-choice-4">账户</label>
			</fieldset>
        </div>
  
        <div data-role="fieldcontain">  
            <input type="submit" name="submit" value="提交"  />  
        </div>      
          
        </form>  
  
    </div>  
  
</div>  
			
			
</tiles:putAttribute>
</tiles:insertDefinition>

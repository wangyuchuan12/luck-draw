<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="inputTab">
	<ul>
		<li id="inputTabChoice">选择题</li>
		<li id="inputTabFillBlank">填空</li>
		<li id="inputTabFillTerms">填词</li>
	</ul>
</div>
				
				
<div id="inputItemChoice">
	<div class="inputItem" id="rightOption">
		<div class="inputItemIcon">
			<span class="fa fa-check"></span>
		</div>
		<div class="inputItemInput">
			<input placeholder="答案1（正确答案）" name="rightOption">
		</div>
	</div>
	
	<div class="inputItem" id="wrongOption1">
		<div class="inputItemIcon">
			<span class="fa fa-times"></span>
		</div>
		<div class="inputItemInput">
			<input placeholder="答案2（错误答案）" name="wrongOption1">
		</div>
	</div>
	
	<div class="inputItem" id="wrongOption2">
		<div class="inputItemIcon">
			<span class="fa fa-times"></span>
		</div>
		<div class="inputItemInput">
			<input placeholder="答案3（错误答案）" name="wrongOption2">
		</div>
	</div>
	
	<div class="inputItem" id="wrongOption3">
		<div class="inputItemIcon">
			<span class="fa fa-times"></span>
		</div>
		<div class="inputItemInput">
			<input placeholder="答案4（错误答案）" name="wrongOption3">
		</div>
	</div>
</div>

<div id="inputItemFillBlank">
	<div class="inputItem" id="blankItem">
		<div class="inputItemIcon">
			<span class="fa fa-pencil-square-o"></span>
		</div>
		<div class="inputItemInput">
			<input placeholder="答案(不超过5个字)" name="answer2">
		</div>
	</div>
</div>

<div id="inputItemFillTerms">
</div>
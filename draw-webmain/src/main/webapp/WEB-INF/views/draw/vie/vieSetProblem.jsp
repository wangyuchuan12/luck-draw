<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="resourceLayout">
<tiles:putAttribute name="title">设置问题</tiles:putAttribute>
<tiles:putAttribute name="body">
	
	<div class="vie_problem">
		<div class="view_problem_title">第2/5题</div>
		
	</div>
	
	<div class="vie_problem_question">
		<div class="vie_problem_question_textarea">
			<textarea rows="" cols="" placeholder="请输入内容"></textarea>
		</div>
	</div>
	
	<div class="vie_problem_answer">
		<ul>
			<li>
				<span>A</span>
				<textarea rows="3" placeholder="请输入选项"></textarea>
				
				<em class="fa fa-times"></em>
				
				<div class="vie_problem_answer_check">
					<span class="fa fa-check"></span>
				</div>
			</li>
			
			<li>
				<span>B</span>
				<textarea rows="3"  placeholder="请输入选项"></textarea>
				
				<em class="fa fa-times"></em>
				
				<div class="vie_problem_answer_check">
					<span class="fa fa-check"></span>
				</div>
			</li>
			
				
		</ul>
		
		
		
	</div>
	
	<div class="vie_problem_answer_button">
			<ul>
			
				
				
				<li style="background: #cccccc">
					<span class="fa fa-minus"></span>
					<div class="vie_problem_answer_button_text">删除该题</div>
				</li>
				
				<li>
					<span class="fa fa-plus"></span>
					<div class="vie_problem_answer_button_text">添加选项</div>
				</li>
				
				<li>
					<span class="fa fa-reply"></span>
					<div class="vie_problem_answer_button_text">返回红包</div>
				</li>
				
				<li>
					<span class="fa fa-save"></span>
					<div class="vie_problem_answer_button_text">保存</div>
				</li>
				
				<li>
					<span class="fa fa-hand-o-left"></span>
					<div class="vie_problem_answer_button_text">上一题</div>
				</li>
				
				<li>
					<span class="fa fa-hand-o-right"></span>
					<div class="vie_problem_answer_button_text">下一题</div>
				</li>
			</ul>
					
		</div>
			
			
	<script type="text/javascript">
		
	</script>
			
</tiles:putAttribute>
</tiles:insertDefinition>

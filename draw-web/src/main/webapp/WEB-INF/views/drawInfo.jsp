<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
	<head>
		<meta name="viewport"
		content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
		 <meta name="format-detection" content="telephone=no">
		 <meta http-equiv="Pragma" content="no-cache">   
		 <meta http-equiv="Cache-Control" content="no-store">
		 <meta http-equiv="Expires" content="0">
		<link rel="stylesheet" href="/css/style.css"/>
		<link rel="stylesheet" href="/css/core.css"/>
		<link rel="stylesheet" href="/font-awesome-4.7.0/css/font-awesome.min.css"/>
	</head>
<body>
    <div class="container">
			<div class="luck_info_head">
				<div class="luck_info_head_background"></div>
				<div class="luck_info_head_title">问答红包</div>
				<div class="luck_info_head_img">
					<img src="http://wx.qlogo.cn/mmopen/Q3auHgzwzM6iaCq2JwzfpkLPLREt1m1UcUoy17zzkNwgeAWqs6nHY1svj2NfMethmUqVpicG80yYdWn524E6fyBtpJB1CYhEB83yicLicJbUZ5U/0"></img>
				</div>
				<div class="luck_info_head_name">大王的红包</div>

				<div class="luck_info_head_money"><span>1.51</span>元</div>
			</div>
			
			<div class="luck_info_qusition">
				<div class="luck_info_qusition_title">耶稣的出生年日</div>
				<div>
					<div class="luck_info_qusition_img">
						<img src="http://pic.qiantucdn.com/58pic/12/05/65/66658PICFmX.jpg"></img>
					</div>
					
					<div class="luck_info_qusition_content">耶稣是哪一年出生的？,？</div>
				</div>
				
				
			</div>
			
			<div class="luck_info_answer">
				<input />
				<div class="luck_info_answer_button">提交答案</div>
				<div class="luck_info_answer_num">4个字</div>
			</div>
			
			<div class="luck_info_alert">已经到时间了</div>
			
			<div class="luck_info_situation">
					<div class="luck_info_situation_time">剩余<b id="luck_info_hour">00</b><b id="luck_info_min">00</b><b id="luck_info_second">00</b>结束</div>
			</div>
			
			<div class="luck_info_question_prompt">
				<div class="luck_info_question_prompt_name">提示：</div>
				<div >
						<div class="luck_info_question_prompt_item">耶路撒冷</div>
						<div class="luck_info_question_prompt_item">犹太全地</div>
						<div class="luck_info_question_prompt_item">大卫城</div>
						<div class="luck_info_question_prompt_item">耶路撒冷</div>
						<div class="luck_info_question_prompt_item">犹太全地</div>
						<div class="luck_info_question_prompt_item">大卫城</div>
						<div class="luck_info_question_prompt_item">耶路撒冷</div>
						<div class="luck_info_question_prompt_item">犹太全地</div>
						<div class="luck_info_question_prompt_item">大卫城</div>
				</div>
			</div>
			
			<div class="luck_info_records">
				<div class="luck_info_records_name">记录</div>
				<div class="luck_info_record_list">
					<div class="luck_info_record_item">
						<div class="luck_info_record_item_img">
							<img src="http://wx.qlogo.cn/mmopen/Q3auHgzwzM6iaCq2JwzfpkLPLREt1m1UcUoy17zzkNwgeAWqs6nHY1svj2NfMethmUqVpicG80yYdWn524E6fyBtpJB1CYhEB83yicLicJbUZ5U/0"></img>
						</div>
						<div class="luck_info_record_item_nickname">川川</div>
						<div class="luck_info_record_item_time">2016-11-12 17:32:24</div>
						<div class="luck_info_record_item_content">回答：鸡翅膀</div>
						<div class="luck_info_record_item_result">
							<em class="fa fa-check" style="color: green;"></em>
						</div>
					</div>
					
					
					
					<div class="luck_info_record_item">
						<div class="luck_info_record_item_img">
							<img src="http://wx.qlogo.cn/mmopen/Q3auHgzwzM6iaCq2JwzfpkLPLREt1m1UcUoy17zzkNwgeAWqs6nHY1svj2NfMethmUqVpicG80yYdWn524E6fyBtpJB1CYhEB83yicLicJbUZ5U/0"></img>
						</div>
						<div class="luck_info_record_item_nickname">川川</div>
						<div class="luck_info_record_item_time">2016-11-12 17:32:24</div>
						<div class="luck_info_record_item_content">回答：鸡翅膀</div>
						<div class="luck_info_record_item_result">
							<em class="fa fa-times"></em>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="resourceLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
<tiles:putAttribute name="body">

			
			<div class="luck_info_head">
				<div class="luck_info_head_background"></div>
				<div class="luck_info_head_title">竞答红包</div>
				<div class="luck_info_head_img">
					<img src="/imgs/redpack.jpg"></img>
				</div>
				<div class="luck_info_head_name">川川的红包</div>

				<div class="luck_info_head_money"><span>40</span>元
				</div>
			</div>
			
			<div class="vie_luck_info">
				<div class="vie_luck_info_img"><img alt="" src="/imgs/redpack.jpg"></div>
				
				<div class="vie_luck_info_detail">
					<div class="vie_luck_info_detail_item">
						<div class="vie_luck_info_detail_item_label">名称：</div>
						<div class="vie_luck_info_detail_item_text">红包大战</div>
					</div>
					
					<div class="vie_luck_info_detail_item">
						<div class="vie_luck_info_detail_item_label">已参加：</div>
						<div class="vie_luck_info_detail_item_text">20人</div>
					</div>
					
					<div class="vie_luck_info_detail_item">
						<div class="vie_luck_info_detail_item_label">最高分：</div>
						<div class="vie_luck_info_detail_item_text">15/30题  22秒</div>
					</div>
					
					<div class="vie_luck_info_detail_item">
						<div class="vie_luck_info_detail_item_label">难度：</div>
						<div class="vie_luck_info_detail_item_text">4颗星</div>
					</div>
					
					<div class="vie_luck_info_detail_item">
						<div class="vie_luck_info_detail_item_label">平均正确率：</div>
						<div class="vie_luck_info_detail_item_text">70%</div>
					</div>
					
					<div class="vie_luck_info_detail_item">
						<div class="vie_luck_info_detail_item_label">参赛费：</div>
						<div class="vie_luck_info_detail_item_text">0.5元</div>
					</div>
				</div>
			
			</div>
			
			<div class="luck_info_situation">
					<div class="luck_info_situation_time">剩余<b id="luck_info_hour">00</b><b id="luck_info_min">00</b><b id="luck_info_second">00</b> 结束</div>
			</div>
			
			<div class="view_luck_members">
				<div class="view_luck_member">
					<div class="view_luck_member_rank">110000</div>
					
					<div class="view_luck_member_img">
						<img src="/imgs/redpack.jpg">
					</div>
					
					<div class="view_luck_member_name2">
						<!--  <div class="view_luck_member_name2_nickname">牛牛妈妈</div>
						
						<div class="view_luck_member_name2_prompt">第3名 <span>可获得30元</span></div>
						-->
						<div class="view_luck_member_name2_prompt_absolute">可获得30元</div>
					</div>
					
					<div class="view_luck_member_result">
						<div class="view_luck_member_result_correct">15题/12秒</div>
					</div>
				
				</div>
				
				
				<div class="view_luck_member">
					<div class="view_luck_member_rank">1</div>
					
					<div class="view_luck_member_img">
						<img src="/imgs/redpack.jpg">
					</div>
					
					<div class="view_luck_member_name">牛牛妈妈</div>
					
					<div class="view_luck_member_result">
						<div class="view_luck_member_result_correct">15题/12秒</div>
					</div>
				
				</div>
				
				<div class="view_luck_member">
					<div class="view_luck_member_rank">1</div>
					
					<div class="view_luck_member_img">
						<img src="/imgs/redpack.jpg">
					</div>
					
					<div class="view_luck_member_name">牛牛妈妈</div>
					
					<div class="view_luck_member_result">
						<div class="view_luck_member_result_correct">15题/12秒</div>
					</div>
				
				</div>
				
				<div class="view_luck_member">
					<div class="view_luck_member_rank">1</div>
					
					<div class="view_luck_member_img">
						<img src="/imgs/redpack.jpg">
					</div>
					
					<div class="view_luck_member_name">牛牛妈妈</div>
					
					<div class="view_luck_member_result">
						<div class="view_luck_member_result_correct">15题/12秒</div>
					</div>
				
				</div>
				
				<div class="view_luck_member">
					<div class="view_luck_member_rank">1</div>
					
					<div class="view_luck_member_img">
						<img src="/imgs/redpack.jpg">
					</div>
					
					<div class="view_luck_member_name">牛牛妈妈</div>
					
					<div class="view_luck_member_result">
						<div class="view_luck_member_result_correct">15题/12秒</div>
					</div>
				
				</div>
				
				<div class="view_luck_member">
					<div class="view_luck_member_rank">1</div>
					
					<div class="view_luck_member_img">
						<img src="/imgs/redpack.jpg">
					</div>
					
					<div class="view_luck_member_name">牛牛妈妈</div>
					
					<div class="view_luck_member_result">
						<div class="view_luck_member_result_correct">15题/12秒</div>
					</div>
				
				</div>
				
				<div class="view_luck_member">
					<div class="view_luck_member_rank">1</div>
					
					<div class="view_luck_member_img">
						<img src="/imgs/redpack.jpg">
					</div>
					
					<div class="view_luck_member_name">牛牛妈妈</div>
					
					<div class="view_luck_member_result">
						<div class="view_luck_member_result_correct">15题/12秒</div>
					</div>
				
				</div>
			
			</div>
			
			
			<script type="text/javascript">
				
			</script>
			
</tiles:putAttribute>
</tiles:insertDefinition>

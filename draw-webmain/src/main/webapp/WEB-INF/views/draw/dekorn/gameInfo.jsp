<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>

<tiles:insertDefinition name="resourceLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
<tiles:putAttribute name="body">
	<div class="gameInfo">
		<div class="gameInfoTitle">
			<div class="gameInfoTitleImg">
				<img src="http://img06.tooopen.com/images/20170325/tooopen_sy_203225356543.jpg">
			</div>
			
			<div class="gameInfoTitleContent">
				<div class="gameInfoTitleContentName">找你妹</div>
				
				<div class="vie_luck_info_detail_item" id="publicCommendItem">
					
					<div class="vie_luck_info_detail_item_text">
						<div id="publicCommend"></div>
					</div>
					
					<div class="vie_luck_info_detail_item_label">9.5分</div>
				</div>
				
				<div class="gameInfoTitleContentPub">人气：2000</div>
			</div>
			
		</div>
		
		
		
		<div class="gameInfoContent">
			<div class="gameInfoContentTitle" style="border-bottom:1px dashed RGBA(204,204,204,1);">
				<span>简介</span>
			</div>
			
			<div class="gameInfoContentDetail">
				游戏简介：在所有的物品中找到需要的物品，看看你能找到多少，游戏有限定时间，考验你眼力的时候到了，还等什么，一起来挑战吧。<br/>
				游戏目标：在规定时间内找到所有物品
			</div>
		</div>
		
		<div class="gameInfoContent">
			<div class="gameInfoContentTitle" style="border-bottom:1px dashed RGBA(204,204,204,1);">
				<span>擂主</span>
				<span>大爷，来挑战我吧</span>
			</div>
			
			<div class="gameInfoContentPlayer">
				<ul>
					<li>
					
						<div class="gameInfoContentPlayerTitle">
							<div class="gameInfoContentPlayerImg">
								<img src="http://img06.tooopen.com/images/20170325/tooopen_sy_203225356543.jpg">
							</div>
							<div class="gameInfoContentPlayerRank">第一名 15胜/20</div>
							
							<div class="gameInfoContentPlayerNickname">川川</div>
						</div>
						
						
						<div class="gameInfoContentPlayerContent">
							<div class="gameInfoContentPlayerContentReward">智慧豆：30颗</div>
							
							<div class="gameInfoContentPlayerContentScore">得分：30分</div>
							
							<div class="gameInfoContentPlayerContentButton">挑战</div>
						</div>
					</li>
					
					<li>
					
						<div class="gameInfoContentPlayerTitle">
							<div class="gameInfoContentPlayerImg">
								<img src="http://img06.tooopen.com/images/20170325/tooopen_sy_203225356543.jpg">
							</div>
							<div class="gameInfoContentPlayerRank">第一名 15胜/20</div>
							
							<div class="gameInfoContentPlayerNickname">川川</div>
						</div>
						
						
						<div class="gameInfoContentPlayerContent">
							<div class="gameInfoContentPlayerContentReward">智慧豆：30颗</div>
							
							<div class="gameInfoContentPlayerContentScore">挑战分：30分</div>
							
							<div class="gameInfoContentPlayerContentButton">挑战</div>
						</div>
					</li>
					
					<li>
					
						<div class="gameInfoContentPlayerTitle">
							<div class="gameInfoContentPlayerImg">
								<img src="http://img06.tooopen.com/images/20170325/tooopen_sy_203225356543.jpg">
							</div>
							<div class="gameInfoContentPlayerRank">第一名 15胜/20</div>
							
							<div class="gameInfoContentPlayerNickname">川川</div>
						</div>
						
						
						<div class="gameInfoContentPlayerContent">
							<div class="gameInfoContentPlayerContentReward">智慧豆：30颗</div>
							
							<div class="gameInfoContentPlayerContentScore">得分：30分</div>
							
							<div class="gameInfoContentPlayerContentButton">挑战</div>
						</div>
					</li>
					
					<li>
					
						<div class="gameInfoContentPlayerTitle">
							<div class="gameInfoContentPlayerImg">
								<img src="http://img06.tooopen.com/images/20170325/tooopen_sy_203225356543.jpg">
							</div>
							<div class="gameInfoContentPlayerRank">第一名 15胜/20</div>
							
							<div class="gameInfoContentPlayerNickname">川川</div>
						</div>
						
						
						<div class="gameInfoContentPlayerContent">
							<div class="gameInfoContentPlayerContentReward">智慧豆：30颗</div>
							
							<div class="gameInfoContentPlayerContentScore">得分：30分</div>
							
							<div class="gameInfoContentPlayerContentButton">挑战</div>
						</div>
					</li>
					
					<li>
					
						<div class="gameInfoContentPlayerTitle">
							<div class="gameInfoContentPlayerImg">
								<img src="http://img06.tooopen.com/images/20170325/tooopen_sy_203225356543.jpg">
							</div>
							<div class="gameInfoContentPlayerRank">第一名 15胜/20</div>
							
							<div class="gameInfoContentPlayerNickname">川川</div>
						</div>
						
						
						<div class="gameInfoContentPlayerContent">
							<div class="gameInfoContentPlayerContentReward">智慧豆：30颗</div>
							
							<div class="gameInfoContentPlayerContentScore">得分：30分</div>
							
							<div class="gameInfoContentPlayerContentButton">挑战</div>
						</div>
					</li>
					
					<li>
					
						<div class="gameInfoContentPlayerTitle">
							<div class="gameInfoContentPlayerImg">
								<img src="http://img06.tooopen.com/images/20170325/tooopen_sy_203225356543.jpg">
							</div>
							<div class="gameInfoContentPlayerRank">第一名 15胜/20</div>
							
							<div class="gameInfoContentPlayerNickname">川川</div>
						</div>
						
						
						<div class="gameInfoContentPlayerContent">
							<div class="gameInfoContentPlayerContentReward">智慧豆：30颗</div>
							
							<div class="gameInfoContentPlayerContentScore">得分：30分</div>
							
							<div class="gameInfoContentPlayerContentButton">挑战</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function(){
			
			$.fn.raty.defaults.path="/raty/img";
			$("#publicCommend").raty({
				score:3,
				imgWidth:"15px",
				imgHeight:"15px",
				readOnly:true
			});
			
		});
	
	</script>
</tiles:putAttribute>
</tiles:insertDefinition>
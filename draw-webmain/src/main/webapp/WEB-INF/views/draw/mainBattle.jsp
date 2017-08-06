<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>


<tiles:insertDefinition name="resourceLayout">
	<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
	<tiles:putAttribute name="body">
		<div class="mainBattle">
			<div class="mainBattleList">
				<ul>
					<li>
						<div class="mainBattleImg">
							<img src="http://oqcfht5ij.bkt.clouddn.com/baby.jpg">
						</div>
						
						<div class="mainBattleName">
							<div class="mainBattleNameDetail">经典大师挑战赛</div>
							
							<div class="mainBattleNameMember">参赛人数：1842 | 奖励：30豆</div>
						</div>
						
						<div class="mainBattleBtn">参加</div>
					</li>
				</ul>
			</div>
		</div>
		
		<script type="text/javascript">
			$(document).ready(function(){
				hideProgress();
			});
		</script>
		
	</tiles:putAttribute>
</tiles:insertDefinition>

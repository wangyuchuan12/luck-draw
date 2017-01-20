<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
	<div class="luck_info_footer">
			<div class="luck_info_footer_item" onclick="skipToHome();" id="main_home">
					<em class="fa fa-home"></em>
					<span>首页</span>	
			</div>
			
			<div class="luck_info_footer_item" onclick="skipToRooms();" id="main_room">
					<em class="fa fa-users"></em>
					<span>我的房间</span>	
			</div>
			
			<div class="luck_info_footer_item_center" onclick="skipToAddRedPack(0,1,1);" id="main_add_pack">
					<em class="fa fa-paper-plane-o"></em>
					<span>发起红包</span>	
			</div>
			
			<div class="luck_info_footer_item" id="main_redpack">
					<em class="fa fa-envelope"></em>
					<span>我的红包</span>	
			</div>
			
			<div class="luck_info_footer_item" onclick="skipToPersonalCenter();" id="main_personal_center">
					<em class="fa fa-user"></em>
					<span>个人中心</span>	
			</div>	
	</div>
	
	<script type="text/javascript">
		function selectMain(id){
			$(".luck_info_footer_item").css("color","black");
			$("#"+id).css("color","red");
		}
	
	</script>
	
<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="infoLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
<tiles:putAttribute name="body">
	<div class="luck_room_members">
		<div class="luck_room_members_title">全部成员</div>
		<div class="luck_room_member_list">
			<ul>
				<li>
					<img src="http://wx.qlogo.cn/mmopen/Q3auHgzwzM6iaCq2JwzfpkLPLREt1m1UcUoy17zzkNwgeAWqs6nHY1svj2NfMethmUqVpicG80yYdWn524E6fyBtpJB1CYhEB83yicLicJbUZ5U/0"/>
					<span>川川</span>
				</li>
				
				<li>
					<img src="http://wx.qlogo.cn/mmopen/Q3auHgzwzM6iaCq2JwzfpkLPLREt1m1UcUoy17zzkNwgeAWqs6nHY1svj2NfMethmUqVpicG80yYdWn524E6fyBtpJB1CYhEB83yicLicJbUZ5U/0"/>
					<span>川川</span>
				</li>
			</ul>
		</div>
	</div>
	<div class="luck_room_packages">
		<div class="luck_room_members_title">红包列表</div>
		
		<div class="luck_room_package_list">
			<ul>
				<li>
					<img src="http://p3.so.qhmsg.com/t01c6bb4964b5e05fc8.jpg">
					
					<div class="luck_room_package_item_info">
						<div class="luck_room_package_item_info1">
							<img src="http://wx.qlogo.cn/mmopen/Q3auHgzwzM6iaCq2JwzfpkLPLREt1m1UcUoy17zzkNwgeAWqs6nHY1svj2NfMethmUqVpicG80yYdWn524E6fyBtpJB1CYhEB83yicLicJbUZ5U/0">
							<div class="luck_room_package_item_info1_name"><b>川川发起</b><span>2014-12-13 07:23:22</span></div>
							<div class="luck_room_package_item_info1_title">耶稣诞生的年日</div>
							
							<div class="luck_room_package_item_info1_money">金额：200元<span>进行中</span></div>
							
						</div>
					
					</div>
					
					
				</li>
				
				
				<li>
					<img src="http://p3.so.qhmsg.com/t01c6bb4964b5e05fc8.jpg">
					
					<div class="luck_room_package_item_info">
						<div class="luck_room_package_item_info1">
							<img src="http://wx.qlogo.cn/mmopen/Q3auHgzwzM6iaCq2JwzfpkLPLREt1m1UcUoy17zzkNwgeAWqs6nHY1svj2NfMethmUqVpicG80yYdWn524E6fyBtpJB1CYhEB83yicLicJbUZ5U/0">
							<div class="luck_room_package_item_info1_name"><b>川川发起</b><span>2014-12-13 07:23:22</span></div>
							<div class="luck_room_package_item_info1_title">耶稣诞生的年日</div>
							
							<div class="luck_room_package_item_info1_money">金额：200元</div>
							
						</div>
					
					</div>
				</li>
			</ul>
		</div>
	</div>
			
</tiles:putAttribute>
</tiles:insertDefinition>

<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertDefinition name="resourceLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
<tiles:putAttribute name="body">
	<div class="addVieRedPacket">
		<div class="option_items">
				<div class="option_item" style="padding-left: 10px;"> 
			        <div id="addCommodityIndex"></div>
		        </div>
		        
		        <div class="option_item">
					<div class="option_item_label" id="answer_label">主题：</div>
					<input name="answer" placeholder="不能超过7个字节"/> 
				</div>
				
				<div class="option_item_area">
					<div class="option_item_label" id="question_label">说明：</div>
					<textarea name="question" placeholder="不能超过50个字节"></textarea> 

				</div>
				
				
				
				
				<div class="option_item_select" id="payUserTypeDisplay">
					<!--  <span class="fa fa-address-card" id="option_item_select_icon" style="color: green;"></span>-->
					<span class="option_item_select_content">个人</span>
				</div>

				<div class="form_buttom">生成红包</div>
		
			</div>
	</div>
	
	
	
	
	<div  id="pay_view">
			
				<div class="add_draw_pay_view">
					<div class="take_out_list">
						<div class="take_out_item" onclick="payAmount(5);">
							<div class="take_out_item_money">5<span>元</span></div>
						</div>
						
						
						<div class="take_out_item" onclick="payAmount(10);">
							<div class="take_out_item_money">10<span>元</span></div>
						</div>
						
						<div class="take_out_item" onclick="payAmount(20);">
							<div class="take_out_item_money">20<span>元</span></div>
						</div>
						
						<div class="take_out_item" onclick="payAmount(40);">
							<div class="take_out_item_money">40<span>元</span></div>
						</div>
						
						<div class="take_out_item" onclick="payAmount(10);">
							<div class="take_out_item_money">100<span>元</span></div>
						</div>
						
						<div class="take_out_item" onclick="payAmount(200);">
							<div class="take_out_item_money">200<span>元</span></div>
						</div>
					</div>
					
					<div class="add_draw_pay_view_amount">
					
						<div class="add_draw_pay_view_amount_check">
							<span class="fa fa-square-o"></span>
						</div>
						
						<div class="add_draw_pay_view_amount_label">参赛费</div>
						
						<input type="number">
						
						<div class="add_draw_pay_view_amount_sign">元</div>
					</div>
					
					
					<div>
						<div class="select_list_item" type=0 onclick="setPayType(0)">
						
							<em class="fa fa-check-square"  style="color: red;"></em>
		         			<em class="fa fa-address-card" style="color: green;"></em>
		         			<span class="select_list_item_name">余额支付（剩余：${amountBalance}元）</span>
		         			
		         			
	         			</div>
	         			
	         			<div class="select_list_item" id="amountPayType" type=1 onclick="setPayType(1)">
	         			
	         				<em class="fa fa-square-o"></em>
		         			<em class="fa fa-weixin" style="color: green;"></em>
		         			<span class="select_list_item_name">微信支付</span>
	         			</div>
         			
         			</div>
				</div>
				
			</div>
	
	
	<div class="select_list" id="payUser" style="display: none;">
         		<div class="select_list_item" type="1">
         			<em class="fa fa-address-card" style="color: green;"></em>
         			<span class="select_list_item_name">个人</span>
         		</div>
         		
         		<c:forEach items="${rooms}" var="room">
         			<div class="select_list_item" type="0" id="${room.id}">
	         			<img src="${room.imgUrl}">
	         			<span class="select_list_item_name">房间：${room.name}</span>
         			</div>
         		</c:forEach>
     </div>
			
			
			
			
	<script type="text/javascript">
		$(document).ready(function(){
			var callback = new Object();
			callback.success = function(){
				$("input[name=isImg]").val(1);
			}
			toBigerImg("/api/common/resource/upload","#addCommodityIndex","file",callback);
		});
	</script>
			
</tiles:putAttribute>
</tiles:insertDefinition>

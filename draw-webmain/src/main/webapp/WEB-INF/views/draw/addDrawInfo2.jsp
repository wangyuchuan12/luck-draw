<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>

<script src="/js/jquery.ui.widget.js"></script>
<script src="/js/jquery.iframe-transport.js"></script>
<script src="/js/jquery.fileupload.js"></script>
	
<input type="hidden" name="isDisplayRoom" value="${isDisplayRoom}"/>
	
<input type="hidden" name="isDisplayType" value="${isDisplayType}"/>
	
	<!-- 账号余额 -->
<input type="hidden" name="amountBalance" value="${amountBalance}"/>
	
	<!-- 0余额支付，1是微信支付 -->
<input type="hidden" name="payType" value="0"/>
	
<input type="hidden" name="isImg" value="0"/>
	
<input type="hidden" name="amount" />
	
<input type="hidden" name="roomId" value="${roomId}"/>
	
	<!-- 红包类型1房间问答红包 0个人问答红包 -->
<input type="hidden" name="isRoom" value="${isRoom}"/>
	
<input type="hidden" name="subjectId" value="${subjectId}"/>
	
		<div class="mallClose" id="mallClose">关闭</div>
		
		<div class="addDrawInfo2">
        	<div class="option_items">

					<div class="option_item" style="padding-left: 10px;"> 
				        <div id="addCommodityIndex"></div>
			        </div>
			        
			        <div class="option_item">
						<div class="option_item_label" id="num_label">红包个数：</div>
						<input name="num" placeholder="填写个数" type="number"/> 
					</div>
					<div class="option_item_area">
						<div class="option_item_label" id="question_label">问题：</div>
						<textarea name="question" placeholder="不能超过50个字节"></textarea> 

					</div>
					
					<div class="option_item" style="position: relative;top:-4px;">
						<div class="option_item_label" id="answer_label">答案：</div>
						<input name="answer" placeholder="不能超过7个字节"/> 
					</div>
					
					
					<div class="option_item_select" id="payUserTypeDisplay" style="position: relative;top:-4px;display: none;">
						<!--  <span class="fa fa-address-card" id="option_item_select_icon" style="color: green;"></span>-->
						<span class="option_item_select_content">个人</span>
					</div>
					
					
					
					<div class="form_buttom">生成红包</div>
		
			</div>
			
			<div  id="pay_view" style="display: none;">
			
				<div class="add_draw_pay_view">
					<div class="take_out_list" id="takeOutList1">
						<div class="take_out_item" id="take_out_item" amount="0.1">
							<div class="take_out_item_money">0.1<span>元</span></div>
						</div>
						
						
						<div class="take_out_item"  amount="0.5">
							<div class="take_out_item_money">0.5<span>元</span></div>
						</div>
						
						<div class="take_out_item"  amount="1">
							<div class="take_out_item_money">1<span>元</span></div>
						</div>
						
						<div class="take_out_item"  amount="5">
							<div class="take_out_item_money">5<span>元</span></div>
						</div>
						
						<div class="take_out_item" amount="10">
							<div class="take_out_item_money">10<span>元</span></div>
						</div>
						
						<div class="take_out_item"  amount="20">
							<div class="take_out_item_money">20<span>元</span></div>
						</div>
					</div>
					
					
					<div class="take_out_list" id="takeOutList2">
						<div class="take_out_item"  amount = 1>
							<div class="take_out_item_money">1<span>元</span></div>
						</div>
						
						
						<div class="take_out_item"  amount=5>
							<div class="take_out_item_money">5<span>元</span></div>
						</div>
						
						<div class="take_out_item"  amount=10>
							<div class="take_out_item_money">10<span>元</span></div>
						</div>
						
						<div class="take_out_item"  amount=20>
							<div class="take_out_item_money">20<span>元</span></div>
						</div>
						
						<div class="take_out_item"  amount=50>
							<div class="take_out_item_money">50<span>元</span></div>
						</div>
						
						<div class="take_out_item" amount=100>
							<div class="take_out_item_money">100<span>元</span></div>
						</div>
					</div>
					
					
					<div class="take_out_list" id="takeOutList3">
						<div class="take_out_item" amount=1>
							<div class="take_out_item_money">2<span>元</span></div>
						</div>
						
						
						<div class="take_out_item" amount=5>
							<div class="take_out_item_money">10<span>元</span></div>
						</div>
						
						<div class="take_out_item"  amount=10>
							<div class="take_out_item_money">20<span>元</span></div>
						</div>
						
						<div class="take_out_item"  amount=20>
							<div class="take_out_item_money">40<span>元</span></div>
						</div>
						
						<div class="take_out_item" amount=50>
							<div class="take_out_item_money">100<span>元</span></div>
						</div>
						
						<div class="take_out_item"  amount=100>
							<div class="take_out_item_money">200<span>元</span></div>
						</div>
					</div>
					
					
					
					<div style="position: relative;top:-20px;">
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
         		<div class="select_list_item" isRoom="0">
         			<em class="fa fa-address-card" style="color: green;"></em>
         			<span class="select_list_item_name">个人</span>
         		</div>
         		
         		<c:forEach items="${rooms}" var="room">
         			<div class="select_list_item" isRoom="1" id="${room.id}">
	         			<img src="${room.imgUrl}">
	         			<span class="select_list_item_name">房间：${room.name}</span>
         			</div>
         		</c:forEach>
         	</div>
         	
         </div>

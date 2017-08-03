<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>


<tiles:insertDefinition name="resourceLayout">
	<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
	<tiles:putAttribute name="body">
		<div class="mallContainer">
			<div class="mallTitle">
				<ul>
					<li style="color: RGBA(226,181,120,1);" id="allTab">综合</li>
					<li style="color: RGBA(226,181,120,1);" id="loveTab">爱心</li>
					<li style="color: RGBA(226,181,120,1);" id="beanTab">智慧豆</li>
					<li style="color: RGBA(226,181,120,1);" id="masonryTab">砖石</li>
				</ul>
			</div>
			
			<div class="mallGoodList">
				<ul>
				</ul>
			</div>
		</div>
		
		<script type="text/javascript">
		
			function init(){
				var flowPlug = new FlowPlug({
					begin:function(){
						/*this.setNext("addLoveGood");
						
						this.next();
						
						this.setNext("addMasonryGood");
						this.next();
						
						this.setNext("addBeanGood");
						this.next();*/
						
						this.setNext("showAll");
						this.next();
						
						this.setNext("initEventListener");
						this.next();
					},
					
					initEventListener:function(){
						var outThis  = this;
						$("#allTab").click(function(){
							outThis.setNext("showAll");
							outThis.next();
						});
						
						$("#loveTab").click(function(){
							outThis.setNext("showLove");
							outThis.next();
						});
						
						$("#beanTab").click(function(){
							outThis.setNext("showBean");
							outThis.next();
						});
						
						$("#masonryTab").click(function(){
							outThis.setNext("showMasonry");
							outThis.next();
						});
					},
					
					showAll:function(){
						this.setNext("showClazz");
						this.nextData({
							clazz:0
						})
						this.next();
						
						$("#allTab").css("background","RGBA(212,153,45,0.1)");
						$("#loveTab").css("background","");
						$("#beanTab").css("background","");
						$("#masonryTab").css("background","");
					},
					
					showLove:function(){
						this.setNext("showClazz");
						this.nextData({
							clazz:1
						})
						this.next();
						
						$("#allTab").css("background","");
						$("#loveTab").css("background","RGBA(212,153,45,0.1)");
						$("#beanTab").css("background","");
						$("#masonryTab").css("background","");
					},
					
					showBean:function(){
						this.setNext("showClazz");
						this.nextData({
							clazz:2
						})
						this.next();
						
						$("#allTab").css("background","");
						$("#loveTab").css("background","");
						$("#beanTab").css("background","RGBA(212,153,45,0.1)");
						$("#masonryTab").css("background","");
					},
					
					showMasonry:function(){
						this.setNext("showClazz");
						this.nextData({
							clazz:3
						})
						this.next();
						
						$("#allTab").css("background","");
						$("#loveTab").css("background","");
						$("#beanTab").css("background","");
						$("#masonryTab").css("background","RGBA(212,153,45,0.1)");
					},
					
					showClazz:function(){
						
						$(".mallGoodList>ul>li").remove();
						var outThis = this;
						var clazz = this.stepData("clazz");
						this.setNext("requestData",function(goods){
							for(var i = 0;i<goods.length;i++){
								
								var good = goods[i];
			
								if(good.type==0){
									outThis.setNext("addLoveGood");
									outThis.nextData({
										name:good.spec,
										amount:good.amount,
										imgUrl:good.imgUrl,
										payType:good.payType,
										id:good.goodId
									});
									outThis.next();
								}else if(good.type==1){
									outThis.setNext("addBeanGood");
									outThis.nextData({
										name:good.spec,
										amount:good.amount,
										imgUrl:good.imgUrl,
										payType:good.payType,
										id:good.goodId
									});
									outThis.next();
								}else if(good.type==2){
									outThis.setNext("addMasonryGood");
									outThis.nextData({
										name:good.spec,
										amount:good.amount,
										imgUrl:good.imgUrl,
										payType:good.payType,
										id:good.goodId
									});
									outThis.next();
								}
								
							}
							
						});
						
						this.nextData({
							clazz:clazz
						});
						
						this.next();
					},
					
					requestData:function(){
						showLoading();
						var clazz = this.stepData("clazz");
						var outThis = this;
						
						var url = "/api/mall/good_list";
						
						var params = new Object();
						params.clazz = clazz;
						
						var callback = new Object();
						
						callback.success = function(resp){
							hideLoading();
							if(resp.success){
								var goods = resp.data;
								
								outThis.success(goods);
							}
						}
						
						callback.failure = function(){
							hideLoading();
						}
						
						request(url,callback,params);
					},
					addLoveGood:function(){
						this.setNext("addGood");
						var amount = this.stepData("amount");
						var name = this.stepData("name");
						var imgUrl = this.stepData("imgUrl");
						var id = this.stepData("id");
						if(!imgUrl){
							imgUrl = "http://7xugu1.com1.z0.glb.clouddn.com/lifeLoveSolid.png";
						}
						var payType = this.stepData("payType");
						this.nextData({
							imgUrl:imgUrl,
							name:name,
							payType:payType,
							amount:amount,
							amountStyle:"padding-top:5px;",
							id:id
						});
						this.next();
					},
					addBeanGood:function(){
						this.setNext("addGood");
						var amount = this.stepData("amount");
						var name = this.stepData("name");
						var imgUrl = this.stepData("imgUrl");
						var id = this.stepData("id");
						if(!imgUrl){
							imgUrl = "/imgs/plug/bean.png";
						}
						var payType = this.stepData("payType");
						this.nextData({
							imgUrl:imgUrl,
							name:name,
							payType:payType,
							amount:amount,
							id:id
							
						});
						this.next();
					},
					addMasonryGood:function(){
						this.setNext("addGood");
						var amount = this.stepData("amount");
						var name = this.stepData("name");
						var imgUrl = this.stepData("imgUrl");
						var payType = this.stepData("payType");
						var id = this.stepData("id");
						if(!imgUrl){
							imgUrl = "http://otsnwem87.bkt.clouddn.com/e33bf825f5d9b459be556b4e16b9e011.png";
						}
						this.nextData({
							imgUrl:imgUrl,
							name:name,
							payType:payType,
							amount:amount,
							id:id
						});
						this.next();
					},
					addGood:function(){
						var img = this.stepData("imgUrl");
						var name = this.stepData("name");
						var amountStyle = this.stepData("amountStyle");
						
						var payType = this.stepData("payType");
						
						var amount = this.stepData("amount");
						
						var id = this.stepData("id");
						
						var text = "";
						
						amountStyle = "";
						if(payType==0){
							text = "<div class='personalAttrDataHeader personalAttrDataHeaderMasonry'></div>"+amount+"砖";
							amountStyle = "padding-top:5px;";
							
						}else if(payType==1){
							text = "<div class='personalAttrDataHeader personalAttrDataHeaderMoney'></div>"+amount+"元";
							
						}
						
						var goodEl = $("<li>"+
										"<div class='mallGoodImg'>"+
											"<img src='"+img+"'>"+
										"</div>"+
										"<div class='mallGoodNum'>"+name+"</div>"+
										"<div class='mallGoodAmount' style='"+amountStyle+"'>"+text+"</div>"+
									 "</li>");
						$(".mallGoodList>ul").append(goodEl);
			
						goodEl.click(function(){
							showLoading();
							wxPayGood(id,2,2,{
								success:function(){
									hideLoading();
								},
								failure:function(){
									hideLoading();
								}
							})
						});
					}
				});
			}
			$(document).ready(function(){
				hideProgress();
				init();
			});
		</script>
	</tiles:putAttribute>
</tiles:insertDefinition>

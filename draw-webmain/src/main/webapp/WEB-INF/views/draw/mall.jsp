<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>


		<div class="mallContainer">
		
			<div class="mallClose" id="mallClose">关闭</div>
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
		
			function initStore(){
				
				hideProgress();
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
						
						$("#mallClose").click(function(){
							closeContainer();
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
										id:good.goodId
									});
									outThis.next();
								}else if(good.type==1){
									outThis.setNext("addBeanGood");
									outThis.nextData({
										name:good.spec,
										amount:good.amount,
										imgUrl:good.imgUrl,
										id:good.goodId
									});
									outThis.next();
								}else if(good.type==2){
									outThis.setNext("addMasonryGood");
									outThis.nextData({
										name:good.spec,
										amount:good.amount,
										imgUrl:good.imgUrl,
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
						this.nextData({
							imgUrl:imgUrl,
							name:name,
							amount:amount,
							amountStyle:"padding-top:5px;",
							id:id,
							costType:3
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
						this.nextData({
							imgUrl:imgUrl,
							name:name,
							amount:amount,
							id:id,
							costType:3
							
						});
						this.next();
					},
					addMasonryGood:function(){
						this.setNext("addGood");
						var amount = this.stepData("amount");
						var name = this.stepData("name");
						var imgUrl = this.stepData("imgUrl");
						var id = this.stepData("id");
						if(!imgUrl){
							imgUrl = "http://otsnwem87.bkt.clouddn.com/e33bf825f5d9b459be556b4e16b9e011.png";
						}
						this.nextData({
							imgUrl:imgUrl,
							name:name,
							amount:amount,
							id:id,
							costType:1
						});
						this.next();
					},
					addGood:function(){
						
						var outThis = this;
						var img = this.stepData("imgUrl");
						var name = this.stepData("name");
						var amountStyle = this.stepData("amountStyle");
						
						var amount = this.stepData("amount");
						
						var id = this.stepData("id");
						
						var costType = this.stepData("costType");
						
						var text = "";
						
						amountStyle = "";
						if(costType==3){
							text = "<div class='personalAttrDataHeader personalAttrDataHeaderMasonry'></div>"+amount+"砖";
							amountStyle = "padding-top:5px;";
							
						}else if(costType==1){
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
							if(costType==1){
								showLoading();
								wxPayGood(id,2,2,{
									success:function(order){
										hideLoading();
										var addLoveLifeNum = order.loveNum;
										var addWisdomNum = order.beanNum;
										var addMasonryNum = order.masonryNum;
										if(addLoveLifeNum){
											attrPlug.flowPlug.setNext("addLoveAnnim");
											attrPlug.flowPlug.nextData({
												num:addLoveLifeNum
											});
											attrPlug.flowPlug.next();
										}
										
										if(addWisdomNum){
											attrPlug.flowPlug.setNext("addBeanAnnim");
											attrPlug.flowPlug.nextData({
												num:addWisdomNum
											});
											attrPlug.flowPlug.next();
										}
										
										if(addMasonryNum){
											attrPlug.flowPlug.setNext("addMasonryAnnim");
											attrPlug.flowPlug.nextData({
												num:addMasonryNum
											});
											attrPlug.flowPlug.next();
										}
									},
									failure:function(){
										hideLoading();
									}
								},true);
							}else if(costType==3){
								
								var configAlert = new AlertPlug("是否确定支付",
										[
										 {
											 text:"是",
											 click:function(){
												 configAlert.close();
												 showLoading();
												 masonryPayGood(id,{
														success:function(data){
															alert(JSON.stringify(data));
															hideLoading();
															var alertPlug = new AlertPlug("购买成功",[{text:"确定",click:function(){
																alertPlug.close();
																
																var subMasonry = data.subMasonry;
																var addLoveLifeNum = data.addLoveLifeNum;
																var addWisdomNum = data.addWisdomNum;
																var addAmount  = data.addAmount;
																
																attrPlug.flowPlug.setNext("subMasonryAction");
																attrPlug.flowPlug.nextData({
																	num:subMasonry
																});
																attrPlug.flowPlug.next();
																
																if(addLoveLifeNum){
																	attrPlug.flowPlug.setNext("addLoveAnnim");
																	attrPlug.flowPlug.nextData({
																		num:addLoveLifeNum
																	});
																	attrPlug.flowPlug.next();
																}
																
																if(addWisdomNum){
																	attrPlug.flowPlug.setNext("addBeanAnnim");
																	attrPlug.flowPlug.nextData({
																		num:addWisdomNum
																	});
																	attrPlug.flowPlug.next();
																}
																
																if(addAmount){
																	attrPlug.flowPlug.setNext("addAmountAnnim");
																	attrPlug.flowPlug.nextData({
																		num:addAmount
																	});
																	attrPlug.flowPlug.next();
																}
																
																
															}}]);
														},
														failure:function(resp){
															hideLoading();
															var data = resp.data;
															if(!data||data.errorCode==null){
																//没有错误码数据
																var alertPlug = new AlertPlug("购买失败1",[{text:"确定",click:function(){alertPlug.close();}}]);
															}else if(data.errorCode==1){
																//支付金额出错
																var alertPlug = new AlertPlug("购买失败2",[{text:"确定",click:function(){alertPlug.close();}}]);
															}else if(data.errorCode==0){
																//余额不足
																var alertPlug = new AlertPlug("砖石不足",[{text:"充值",click:function(){
																	alertPlug.close();
																	outThis.setNext("showMasonry");
																	outThis.next();
																}},{text:"取消",click:function(){
																	alertPlug.close();
																}}]);
															}
														}
													});
											 }
										 },
										 {
											 text:"否",
											 click:function(){
												 configAlert.close();
											 }
										 }
										]);
								
							}
						});
					}
				});
			}
			/*$(document).ready(function(){
				addProgress(90,10,{complete:function(){
					init();
					
					var attrFlowPlug = attrPlug.flowPlug;
					
					attrFlowPlug.setNext("initProgress");
					attrFlowPlug.next();
					
					attrFlowPlug.setNext("pullData");
					attrFlowPlug.next();
					
					attrFlowPlug.setNext("show");
					attrFlowPlug.next();
				}});
			});*/
		</script>

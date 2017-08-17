<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
		<div class="mainRedPacket">
		
			<div style="display: none;" id="redPacketInfo">
				<div>
					<img src="/imgs/plug/bean.png">
				</div>
				<div id="redPacketInfoWisdomCount"></div>
			</div>
			
			<div class="mainRedPacketLabel">
				<ul>
					<li id="mainRedpacketReceiveButton">收到</li>
					<li id="mainRedpacketMyselfButton">发送</li>
				</ul>
			</div>
			<div class="mallClose" id="mallClose">关闭</div>
			<div class="redPacketBar">
				<ul>
					
				</ul>
			</div>
			
			<div style="color: white;font-size: 20px;font-weight: bolder;display: none;text-align: center;padding-top: 100px;" id="redPacketNotice">没有红包</div>
		
			<div class="redPacketSearch" id="redPacketSearchButton">
				<div class="redPacketSearchImg">
					<img src="http://otsnwem87.bkt.clouddn.com/e600f3144e545de7c6d7cb72783829d1.png">
				</div>
				<div class="redPacketSearchName">打捞红包</div>
				
				<div class="redPacketSearchConsume">
					<div class="personalAttrDataHeader personalAttrDataHeaderBean"></div>*2
				</div>
			</div>
			<div class="mainRedPacketButtons">
				<div class="mainRedPacketButtonContent">发红包得智慧豆</div>
				
				<div class="mainRedPacketButtonName" id="mainRedPacketButton">我也要发</div>
			</div>
		</div>
		
		<script type="text/javascript">
			function initRedPacket(){
				
				var redPacketFlowPlug = new FlowPlug({
					begin:function(){
						
						this.setNext("showReceive");
						this.next();
						
						
						this.setNext("initEventListener");
						this.next();
						
						
					},
					
					initEventListener:function(){
						var outThis = this;
						$("#mainRedpacketMyselfButton").click(function(){
							outThis.setNext("showMyself");
							outThis.next();
						});
						
						$("#mainRedpacketReceiveButton").click(function(){
							outThis.setNext("showReceive");
							outThis.next();
						});
						
						$("#mallClose").click(function(){
							closeContainer();
						});
						
						$("#redPacketSearchButton").click(function(){
							
							var beanCount = beanProgressPlug.getValue();
							if(beanCount>=2){
								var url = "/api/main/searchRedpacket";
								var params = new Object();
								var waitPlug = new WaitPlug();
								request(url,{
									success:function(resp){
										waitPlug.close();
										if(resp.success){
											var data = resp.data;
											var costBean = data.costBean;
											
											attrPlug.flowPlug.setNext("subBeanAction");
											attrPlug.flowPlug.nextData({
												num:costBean
											});
											attrPlug.flowPlug.next();
										}
									},
									failure:function(){
										waitPlug.close();
										alert("failure");
									}
								},params);
							}else{
								new AlertPlug("智慧豆数量小于2颗");
							}
							
						});
						
						$("#mainRedPacketButton").click(function(){
							var modelLoad = getModelLoad();
							
							modelLoad.loadAddDrawModel({
								success:function(obj){
									modelLoad.loadDrawInfo(obj.id);
								}
							});
							
						});
					},
					
					searchPacket:function(){
						
					},
					
					showReceive:function(){
						
						$("#mainRedpacketMyselfButton").css("border-bottom","0px solid white");
						
						$("#mainRedpacketReceiveButton").css("border-bottom","2px solid white");
						
						this.setNext("showPackets");
						this.nextData({
							isMyself:0
						});
						this.next();
					},
					showMyself:function(){
						
						$("#mainRedpacketMyselfButton").css("border-bottom","2px solid white");
						
						$("#mainRedpacketReceiveButton").css("border-bottom","0px solid white");
						
						this.setNext("showPackets");
						this.nextData({
							isMyself:1
						});
						this.next();
					},
					
					showPackets:function(){
						$(".redPacketBar>ul").empty();
						var isMyself = this.stepData("isMyself");
						var outThis = this;
						this.setNext("requestPackets",function(array){
							console.log(array.length+",,");
							if(array&&array.length>0){
								for(var i = 0;i<array.length;i++){
									outThis.setNext("addPack");
									var obj = array[i];
									outThis.nextData({
										isTimeout:obj.isTimeout,
										isEnd:obj.isReceive,
										img:obj.handUserImgUrl,
										type:obj.type,
										id:obj.redPacketId,
										isTakepart:obj.isTakepart,
										wisdomCount:obj.wisdomCount,
										isMyself:isMyself
									});
									outThis.next();
								}
								$("#redPacketNotice").css("display","none");
							}else{
								$("#redPacketNotice").css("display","block");
							}
						});
						
						this.nextData({
							isMyself:isMyself
						});
						
						this.next();
					},
					
					requestPackets:function(){
						var isMyself = this.stepData("isMyself");
						var outThis = this;
						var url = "/api/main/redPacketList";
						request(url,{
							success:function(resp){
								console.log(JSON.stringify(resp.data));
								if(resp.success){
									outThis.success(resp.data);
								}else{
									outThis.failure(resp);
								}
							},
							failure:function(){
								outThis.failure();
							}
						},{isMyself:isMyself});
					},
					
					addPack:function(){
						
						var clazz = "";
						var content = "领取";
						var typeStr = "";
						var isTimeout = this.stepData("isTimeout");
						var isEnd = this.stepData("isEnd");
						var img = this.stepData("img");
						var type = this.stepData("type");
						var id = this.stepData("id");
						var isMyself = this.stepData("isMyself");
		
						var isTakepart = this.stepData("isTakepart");
						var wisdomCount = this.stepData("wisdomCount");
						if(isTimeout){
							clazz = "gray";
							content = "超时";
						}
						if(isEnd){
							clazz = "gray";
							content = "领完";
						}
						if(type==0){
							typeStr = "问答红包";
						}else if(type==1){
							typeStr = "竞答红包";
						}
						
						
						var liEl = "<li class='"+clazz+"'>"+
										"<div class='redPacketImg'>"+
											"<div class='redPacketHeadImg'>"+
												"<img src='"+img+"'>"+
											"</div>"+
											"<div class='redPacketBarType'>"+typeStr+"</div>"+
										
										"</div>"+
							
										"<div class='redPacketReceive'>"+content+"</div>"+
									"</li>";
									
						liDiv = $(liEl);
						
						$(".redPacketBar>ul").append(liDiv);
						
						liDiv.click(function(){
							
							var modelLoad = getModelLoad();
							if(isTakepart == 1||isMyself==1){

								var modelLoad = getModelLoad();
								modelLoad.loadDrawInfo(id);
							}else{
								
								$("#redPacketInfoWisdomCount").text("消耗"+wisdomCount+"智慧豆");
								var alertPlug = new AlertPlug($("#redPacketInfo").html(),
										[
										 {
											text:"确定",
											click:function(){
													alertPlug.close();
													var url = "/api/vie/draw/vie_red_pack/takepart";
													var params = new Object();
													params.red_packet_id = id;
													request(url,
															{
																success:function(resp){
																	if(resp.success){
																		attrPlug.flowPlug.setNext("subBeanAction");
																		attrPlug.flowPlug.nextData({
																			num:wisdomCount
																		});
																		attrPlug.flowPlug.next();
																		
																		setTimeout(function(){
																			var modelLoad = getModelLoad();
																			modelLoad.loadDrawInfo(id);
																		},2000);
																	}else{
																		new AlertPlug(resp.errorMsg);
																	}
																}
															},params)
										 		}
										 	},{
											text:"取消",
											click:function(){
													alertPlug.close();
											  	}
											}
										 ]);
							}
							
						});
						
						liDiv.attr("style","background:url('http://oq4mi1sbl.bkt.clouddn.com/redPacketBackground.gif');background-size:100% 100%;");
					}
				});
			}
		</script>

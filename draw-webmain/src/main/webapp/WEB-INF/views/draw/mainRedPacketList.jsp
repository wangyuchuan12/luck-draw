<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
		<div class="mainRedPacket">
			<div class="redPacketBar">
				<ul>
					
				</ul>
			</div>
			
			<div style="color: white;font-size: 20px;font-weight: bolder;display: none;text-align: center;padding-top: 100px;" id="redPacketNotice">没有红包</div>
		</div>
		
		<script type="text/javascript">
			function initRedPacket(){
				hideProgress();
				
				var redPacketFlowPlug = new FlowPlug({
					begin:function(){
						this.setNext("showPackets");
						this.next();
					},
					
					showPackets:function(){
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
										isTakepart:obj.isTakepart
									});
									outThis.next();
								}
								$("#redPacketNotice").css("display","none");
							}else{
								$("#redPacketNotice").css("display","block");
							}
						});
						
						this.next();
					},
					
					requestPackets:function(){
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
						},{});
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
						var isTakepart = this.stepData("isTakepart");
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
							
							if(isTakepart == 1){
								var url = "/view/draw/luck_draw/info?id="+id;
								var layerPlug = new LayerPlug(url,1,1,"",function(){
									
								});
								layerPlug.show();
							}else{
								alert("需要先参加");
							}
							
						});
						
						liDiv.attr("style","background:url('http://oq4mi1sbl.bkt.clouddn.com/redPacketBackground.gif');background-size:100% 100%;");
					}
				});
			}
		</script>

<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>

<tiles:insertDefinition name="resourceLayout">
<tiles:putAttribute name="title">问答红包</tiles:putAttribute>
<tiles:putAttribute name="body">
			
			<input name="id" type="hidden" value="${id}"/>
			<input name="gameCode" type="hidden" value="${gameCode}"/>
			<input name="isOpenSwitch"  type="hidden" value="${isOpenSwitch}"/>		
			<div class="gameRedPacketImgHeader_znm123">
				<img id="userImg" src="">
				<div class="gameRedPacketImgHeaderName" id="gameName"></div>
				<div class="gameRedPacketImgHeaderNickname" id="nickname"><span id="nickname"></span> · <span id="createAt"></span>创建</div>
				<div class="gameRedPacketImgHeaderScore">挑战分数：<span id="passScore"></span>分</div>
			</div>
			
			<div class="gameRedPacketTab">
				<ul>
					<li style="border-bottom: 1px solid RGBA(157,99,80,1);color:RGBA(157,99,80,1);">详情</li>
					<li>排行榜</li>
					<li>评论</li>
					<li>帮助</li>
				</ul>
			</div>
			
			<div class="gameRedPacketContent" style="display: none;" id="dekornInfo">
				<div class="gameRedPacketContentDetails">
					<div class="gameRedPacketContentDetailsAttr">
						<ul>
							<li>
								<span>游戏名称：</span>
								<span id="detailGameName"></span>
							</li>
							
							<li>
								<span>游戏评分：</span>
								
								<span id="detailGrade"></span>
								
							</li>
							
							<li>
								<span>挑战目标：</span>
								<span id="detailPassScore"></span>
							</li>
							
							<li>
								<span>胜利奖励：</span>
								<span>智慧豆*<span id="detailReward"></span></span>
							</li>
							
							<li>
								<span>游戏消耗：</span>
								<span>爱心*<span id="detailLoseLoveLife"></span></span>
							</li>
							
							<li>
								<span>挑战人数：</span>
								<span><span id="detailTakepartSuccessCount"></span>胜 ：<span id="detailTakepartFailCount"></span>败</span>
							</li>
						</ul>
					</div>
				</div>
				
				<div class="">
					<div class="gameRedPacketContentTitle">排行榜</div>
					<div id="rank" class="gameRedPacketContentRank">
						<ul>
						<!--  
							<li>
								<span class="gameRedPacketContentRankHeader">第一名</span>
								<div class="gameRedPacketContentRankImg"><img src="${dekornInfo.handDrawUserImg}"></div>
								<span class="gameRedPacketContentRankNickname">川川</span>
								<span class="gameRedPacketContentRankScore">20分</span>
							</li>
							
							<li>
								<span class="gameRedPacketContentRankHeader">第二名</span>
								<div class="gameRedPacketContentRankImg"><img src="${dekornInfo.handDrawUserImg}"></div>
								<span class="gameRedPacketContentRankNickname">川川</span>
								<span class="gameRedPacketContentRankScore">20分</span>
							</li>
							
							<li>
								<span class="gameRedPacketContentRankHeader">第三名</span>
								<div class="gameRedPacketContentRankImg"><img src="${dekornInfo.handDrawUserImg}"></div>
								<span class="gameRedPacketContentRankNickname">川川</span>
	
								<span class="gameRedPacketContentRankScore">20分</span>
							</li>
							
							<li>
								<span class="gameRedPacketContentRankHeader">第四名</span>
								<div class="gameRedPacketContentRankImg"><img src="${dekornInfo.handDrawUserImg}"></div>
								<span class="gameRedPacketContentRankNickname">川川</span>

								<span class="gameRedPacketContentRankScore">20分</span>
							</li>
							
							<li>
								<span class="gameRedPacketContentRankHeader">第五名</span>
								<div class="gameRedPacketContentRankImg"><img src="${dekornInfo.handDrawUserImg}"></div>
								<span class="gameRedPacketContentRankNickname">川川</span>
								<span class="gameRedPacketContentRankScore">20分</span>
							</li>
							
							-->
							
						</ul>
					</div>
				</div>
				
				<div class="">
					<div class="gameRedPacketContentTitle">简介</div>
					<div class="gameRedPacketContentDetail" id="contentDetail">

					</div>
				</div>
			
			</div>
			
			
			
			
			<div class="gameRedPacketContent" style="display: none;">
			
				
				<div class="">
				
					<div style="padding-left: 20px;">
						<span class="gameRedPacketContentRankHeader">第一名</span>
						<div class="gameRedPacketContentRankImg"><img src="http://on3s1z2us.bkt.clouddn.com/theBrain.gif"></div>
						<span class="gameRedPacketContentRankNickname">川川</span>
						<span class="gameRedPacketContentRankScore">20分</span>
					</div>
					<div class="gameRedPacketContentTitle">排行榜，总参与：200人</div>
					<div  class="dekornRank">
						<ul>
							<li>
								<span class="gameRedPacketContentRankHeader">第一名</span>
								<div class="gameRedPacketContentRankImg"><img src="http://on3s1z2us.bkt.clouddn.com/theBrain.gif"></div>
								<span class="gameRedPacketContentRankNickname">川川</span>
								<span class="gameRedPacketContentRankScore">20分</span>
							</li>
							
							<li>
								<span class="gameRedPacketContentRankHeader">第一名</span>
								<div class="gameRedPacketContentRankImg"><img src="http://on3s1z2us.bkt.clouddn.com/theBrain.gif"></div>
								<span class="gameRedPacketContentRankNickname">川川</span>
								<span class="gameRedPacketContentRankScore">20分</span>
							</li>
							
							<li>
								<span class="gameRedPacketContentRankHeader">第一名</span>
								<div class="gameRedPacketContentRankImg"><img src="http://on3s1z2us.bkt.clouddn.com/theBrain.gif"></div>
								<span class="gameRedPacketContentRankNickname">川川</span>
								<span class="gameRedPacketContentRankScore">20分</span>
							</li>
							
							<li>
								<span class="gameRedPacketContentRankHeader">第一名</span>
								<div class="gameRedPacketContentRankImg"><img src="http://on3s1z2us.bkt.clouddn.com/theBrain.gif"></div>
								<span class="gameRedPacketContentRankNickname">川川</span>
								<span class="gameRedPacketContentRankScore">20分</span>
							</li>
						</ul>
					</div>
				</div>
			</div>
			
			
			<div class="gameRedPacketContent" style="display: none;">
			
			</div>
	
			
			
			<div class="gameRedPacketFooter" id="startButton">开始挑战</div>
			
			<script type="text/javascript">
				
				
				var switchPlug;
				var initFunction;
				
				var flowJs;
				
				function s_start(){
					takepart();
				}
				
				function s_switch(){
					alert("switch");
				}
				
				function barragerItem(item){
					$('.container').barrager(item);
				}
				
				
				
				function s_back(){
					switchPlug.close();
				}
				var index = 0;
				function preLoadImg(url){
				    var img1 = new Image();
				    img1.src = url;
				    img1.onload = function(){
				    	index++;
				    	if(index==6){
				    		var id = $("input[name=id]").val();
							var isOpenSwitch = $("input[name=isOpenSwitch]").val();
							if(isOpenSwitch){
								switchSubjectPlug = layer.open({
									title:false,
				    				type:2,
				    				area:["80%","70%"],
				    				shade:[0.1,'#000',true],
				    				skin:"plugclass",
				    				content:["/view/dekornHandle/switchSubjectPlug?id="+id+"&modeView=large"],
				    				fadeIn:1000,
				    				shift:10,
				    				closeBtn:0
								});
								
								
								
							}
				    	}
				    }
				 }
				
				
				
				function takepart(){
					initFunction.setNext("takepart");
					initFunction.next();
				}
				
				function initGame(dekornId,passScore,status,gameCode,takepartId){
					
					flowJs = flowJS({
						init:function(){
							var url = "/games/skipToGame?code="+gameCode;
							var gamePlug = new LayerPlug(url,1,1);
							this.flowData({
								"dekornId":dekornId,
								"passScore":passScore,
								"status":status,
								"gameCode":gameCode,
								"takepartId":takepartId,
								"gamePlug":gamePlug
							});
						},
						
						submitScore:function(){
							var score = this.flowData("score");
							if(status==0){
								this.setNext("invitationPlug");
								this.next();
					    	}else if(status==1){
					    		if(score>=passScore){
					    			this.setNext("dekornSuccess");
					    			this.next();
					    		}else{
					    			this.setNext("dekornFail");
					    			this.next();
					    		}
					    	}
						},
						
						dekornSuccess:function(){
			    			var layerPlug = new LayerPlug("/view/dekornHandle/dekornSuccess?dekornId="+dekornId+"&score="+score+"&takepartId="+takepartId,1,1);
						},
						
						dekornFail:function(){
			    			var layerPlug = new LayerPlug("/view/dekornHandle/dekornFail?dekornId="+dekornId+"&score="+score+"&takepartId="+takepartId,1,1);
						},
						
						invitationPlug:function(){
							var layerPlug = new LayerPlug("/dekornHandle/invitationPlug?gameId=1&type=1&gameType=1&passScore="+score,1,1);
						}
					});
					
				}
				
				$(document).ready(function(){
					
			
					flowJs = flowJS({
						init:function(){
							initFunction = this;
							var outThis = this;
							var progressCallback = new Object();
							progressCallback.complete = function(){
								//outThis.setNext("barrager");
								//outThis.next();
								
								outThis.setNext("initSwitchSubjectPlug");
								outThis.next();
							}
							
							this.flowData({"progressCallback":progressCallback});
							
							var id = $("input[name=id]").val();
							var gameCode = $("input[name=gameCode]").val();
							
							var isOpenSwitch = $("input[name=isOpenSwitch]").val();

							this.flowData({"id":id,"gameCode":gameCode,"isOpenSwitch":isOpenSwitch});
					
							progress(30,100);
							
							this.setNext("infoAction");
							
							this.next();
							
							this.setNext("rankAction");
							this.next();
							
							
							
							this.setNext("addEventListener");
							this.next();
							

						},
						
						infoAction:function(){
							this.setNext("requestInfo",function(data){
								
								$("#dekornInfo").css("display","block");
								this.flowData(data);
								this.setNext("initView",function(){
									
								});
								
								this.next();
								
								this.setNext("initDetail",function(){
									
								});
								this.next();

							},function(data){
								alert("fail");
							});
							
							this.next();
							
							
							this.setNext("initContentDetailView");
							this.next();
						},
						
						
						initSwitchSubjectPlug:function(){
							var id = this.flowData("id");
							var isOpenSwitch = this.flowData("isOpenSwitch");
							
							var url = "/view/dekornHandle/switchSubjectPlug?id="+id+"&modeView=large";
							
							if(isOpenSwitch){
								switchPlug = new LayerPlug(url,0.8,0.67);

							}
						},
						
						//初始化事件
						addEventListener:function(){
							var outThis = this;
							$("#startButton").click(function(){
								alert("start");
								outThis.setNext("takepart");
								outThis.next();
							});
						},
						
						//挑战参加
						takepart:function(){
							this.setNext("takepartRequest",function(data){
								var takepartMemberId = data.id;
								var id = this.flowData("id");
								var gameCode = this.flowData("gameCode");
								var passScore = this.flowData("passScore");
																
								var params = new Object();

								initGame(id,passScore,1,gameCode,data.id)
							//	skipToGame(gameCode,id,1,passScore,takepartMemberId)
							},function(){
								alert("失败");
							});
							this.next();
						},
						
						//参加请求
						takepartRequest:function(){
							var url = "/api/dekorn/takepart";
							var id = this.flowData("id");
							var gameCode = this.flowData("gameCode");
							var passScore = this.flowData("passScore");
							var outThis = this;
							var callback = new Object();
							callback.success = function(resp){
								if(resp.success){
									/*var takepartMemberId = resp.data.id;
									skipToGame(gameCode,id,1,passScore,takepartMemberId);*/
									outThis.success(resp.data);
								}else{
									alert(resp.errorMsg);
									outThis.fail();
								}
							}
							callback.failure = function(resp){
								
								outThis.fail();
							}
							var params = new Object();
							params.id = id;
							request(url,callback,params);
						},
						
						//弹幕
						barrager:function(){
							var outThis = this;
							this.setNext("barragerRequest",function(){
								outThis.setNext("barragerAction");
								outThis.next();
							},function(){});
							this.next();
						},
						
						//请求弹幕数据
						barragerRequest(){
							var barragerCount = 4;
							
							var index = 0;
							
							var barragerArray = new Array();
							
							this.flowData({"barragerCount":barragerCount,"index":index,"barragerArray":barragerArray});
							
							var item1={
						               img:'${dekornInfo.handDrawUserImg}', //图片 
						               info:'弹幕文字信息1', //文字
						               href:"javascript:alert();",
						               speed:6, //延迟,单位秒,默认6 
						               color:'#fff', //颜色,默认白色 
						               old_ie_color:'#000000', //ie低版兼容色,不能与网页背景相同,默认黑色 
						     }
							
							var item2={
						               img:'${dekornInfo.handDrawUserImg}', //图片 
						               info:'弹幕文字信息2', //文字
						               href:"javascript:alert();",
						               speed:6, //延迟,单位秒,默认6 
						               color:'#fff', //颜色,默认白色 
						               old_ie_color:'#000000', //ie低版兼容色,不能与网页背景相同,默认黑色 
						     }
							
							var item3={
						               img:'${dekornInfo.handDrawUserImg}', //图片 
						               info:'弹幕文字信息3', //文字
						               href:"javascript:alert();",
						               speed:6, //延迟,单位秒,默认6 
						               color:'#fff', //颜色,默认白色 
						               old_ie_color:'#000000', //ie低版兼容色,不能与网页背景相同,默认黑色 
						     }
							
							var item4={
						               img:'${dekornInfo.handDrawUserImg}', //图片 
						               info:'弹幕文字信息4', //文字
						               href:"javascript:alert();",
						               speed:6, //延迟,单位秒,默认6 
						               color:'#fff', //颜色,默认白色 
						               old_ie_color:'#000000', //ie低版兼容色,不能与网页背景相同,默认黑色 
						     }
							
							barragerArray.push(item1);
							barragerArray.push(item2);
							barragerArray.push(item3);
							barragerArray.push(item4);
							
							this.success();
							
							
						},
						
						
						//执行弹幕操作
						barragerAction:function(){
							var outThis = this;
							setInterval(function(){
								 var index = outThis.flowData("index");
								 var barragerCount = outThis.flowData("barragerCount");
								 var barragerArray =  outThis.flowData("barragerArray");
								 var item;
								 if(index<barragerCount){
									 item = barragerArray[index];
								 }else{
									 index = 0;
									 item = barragerArray[index];
								 }
								 barragerItem(item);
								 index = index+1;
								 outThis.flowData({"index":index});
							},1000);
						},
						
						
						//初始化最上面的信息
						initView:function(){
							var passScore = this.flowData("passScore");
							var gameName = this.flowData("gameName");
							
							var handDrawUserName =this.flowData("handDrawUserName");
							
							var handDrawUserImg = this.flowData("handDrawUserImg");
							
							$("#userImg").attr("src",handDrawUserImg);
							
							$("#gameName").text(gameName);
							$("#passScore").text(passScore);
							
							$("#nickname").text(handDrawUserName);
							
							var progressCallback = this.flowData("progressCallback");
							progress(100,10,progressCallback);
						},
						
						//初始化详情信息
						initDetail:function(){
							$("#detailGameName").text(this.flowData("gameName"));
							$("#detailGrade").text()
				
							$("#detailPassScore").text(this.flowData("passScore"));
							$("#detailReward").text(this.flowData("fightSuccessWisdomNum"));
							$("#detailLoseLoveLife").text("1");
							
							$("#detailTakepartSuccessCount").text(this.flowData("takepartSuccessCount"));
							$("#detailTakepartFailCount").text(this.flowData("takepartFailCount"));
						},
						
						//初始化排名数据
						initRankData:function(){
							
							var outThis = this;
							
							var url = "/api/dekorn/takepartMembers";
							var params = new Object();
							params.dekornId = 1;
							
							var callback = new Object();
							
							callback.success = function(resp){
								
								console.log("success:"+resp.success);
								
								if(resp.success){
									var array = new Array();
									var members = resp.data;
									for(var i = 0;i<members.length;i++){
										var member = members[i];
										
										var record = new Object();
										record.rank = i+1;
										record.imgUrl = member.headImg;
										record.nickname=member.nickname;
										record.score = member.score;
										array.push(record);
									}
									
									
									console.log("arrayLength:"+array.length);
									outThis.flowData({"rankRecords":array});
									outThis.success();
									
								}
							}
							
							request(url,callback,params);						
							
						},
						
						//初始化游戏简介信息
						initContentDetailView:function(){
							$("#contentDetail").html("游戏简介：在所有的物品中找到需要的物品，看看你能找到多少，"+
									"游戏有限定时间，考验你眼力的时候到了，还等什么，"+
									"一起来挑战吧。<br/>游戏目标：在规定时间内找到所有物品");	
						},
						
						
						//初始化排名页面
						initRankView:function(){
							/*
							"<li>"+
							+"<span class='gameRedPacketContentRankHeader'>第一名</span>"+
							+"<div class='gameRedPacketContentRankImg'>"+
								+"<img src=''>"+
							+"</div>"+
							+"<span class='gameRedPacketContentRankNickname'>川川</span>"+
							+"<span class='gameRedPacketContentRankScore'>20分</span>"+
							+"</li>"
							*/
							
							var rankRecords = this.flowData("rankRecords");
							
							for(var i = 0;i<rankRecords.length;i++){
								
								var rankRecord = rankRecords[i];
								var rankLi = $("<li></li>");
								
								var rankHeaderSpan = $("<span class='gameRedPacketContentRankHeader'>第"+rankRecord.rank+"名</span>");
								
								
								var rankImgDiv = $("<div class='gameRedPacketContentRankImg'></div>");
								
								var rankImg = $("<img src='"+rankRecord.imgUrl+"'>");
								
								rankImgDiv.append(rankImg);
								
								var rankNicknameSpan = $("<span class='gameRedPacketContentRankNickname'>"+rankRecord.nickname+"</span>");
								
								var rankScoreSpan = $("<span class='gameRedPacketContentRankScore'>"+rankRecord.score+"分</span>");
								
								rankLi.append(rankHeaderSpan);
								
								rankLi.append(rankImgDiv);
								
								rankLi.append(rankNicknameSpan);
								
								rankLi.append(rankScoreSpan);
								$("#rank>ul").append(rankLi);
							}
							
							
						},
						
						//资源缓存预加载
						resourceCache:function(){

							progress(10,100);
							console.log("步骤1");
							preLoadImg("http://7xlw44.com1.z0.glb.clouddn.com/background-limit.png");
							preLoadImg("/imgs/plug/leafTitle.png");
							preLoadImg("/imgs/plug/vs.png");
							
							preLoadImg("/imgs/btn/btn-yellow.png");
							
							preLoadImg("/imgs/btn/btn-violet.png");
							
							preLoadImg("/imgs/btn/btn-blue.png");
							this.next();
						},
						
						//让排名滚动起来
						rankAction:function(){
							var outThis = this;
							this.setNext("initRankData",function(){
								outThis.setNext("initRankView");
								outThis.next();
								$("#rank").Scroll({line:1,speed:500,timer:3000});
								outThis.next();
							});
							
							this.next();
							
							progress(50,10);
						},
						
						//详情信息数据请求
						requestInfo:function(){
							var url = "/api/dekorn/info";
							
							var outThis = this;
							
							var id = this.flowData("id");
							
							var gameCode = this.flowData("gameCode");
							
							var params = new Object();
							params.id = id
							params.gameCode = gameCode;
							var callback = new Object();
							callback.success = function(resp){
								if(resp.success){
									outThis.success(resp.data);
								}else{
									outThis.fail();
								}
								
							}
							
							callback.failure = function(){
								this.fail();
							}
							
							request(url,callback,params);
						}
					});
				});
			</script>
			
</tiles:putAttribute>
</tiles:insertDefinition>



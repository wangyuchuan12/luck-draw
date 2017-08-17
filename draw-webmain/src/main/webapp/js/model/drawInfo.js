function DrawInfoModel(addDrawModelCallback){
				
	var drawInfoFlowPlug = new FlowPlug({
		begin:function(){
			
		},
		
		initDrawInfo:function(){
			this.setNext("initStar");
			this.next();
			
			hideProgress();
			
			this.setNext("initTime");
			this.next();
			
			this.setNext("initEventListener");
			this.next();
			
			this.setNext("goodComment");
			this.next();
			
			this.setNext("badComment");
			this.next();
			
			/*this.setNext("initDialog");
			this.next();*/
		},
		
		initDialog:function(){
			var firstVisit = $("input[name=firstVisit]").val();

			var isCreater = $("input[name=isCreater]").val();

			var getWisdom = $("input[name=getWisdom]").val();

			var isTimeOut = $("input[name=isTimeOut]").val();

			var rank = $("input[name=rank]").val();

			var takepartStatus = $("input[name=takepartStatus]").val();

			var memberRank1 = $("input[name=rankImg][rank=1]").val();

			var memberRank2 = $("input[name=rankImg][rank=2]").val();

			var memberRank3 = $("input[name=rankImg][rank=3]").val();

			var receiveAmount = $("input[name=receiveAmount]").val();

			rank = parseInt(rank);
			if(isTimeOut==0){
				if(isCreater==1&&firstVisit==1){
					showHappyAlert("恭喜您，创建红包成功，赠送您10颗智慧豆","确定",function(){
						showLinkGuid("好友好评一次，您能获得2颗智慧豆",null);
					});
				}else if(isCreater==1&&firstVisit!=1){
					if(getWisdom!=0){
						showSmartAlert("恭喜您，您的选手已经为您积累了"+getWisdom+"颗智慧豆","确定",function(){
							showLinkGuid("好友好评一次，您能获得2颗智慧豆",null);
						});
					}else{
						showLinkGuid("好友好评一次，您能获得2颗智慧豆",null);
					}
				}else if(isCreater==0&&firstVisit==1&&takepartStatus==1){
					showRankAlert("恭喜您，获得第"+rank+"名，"+receiveAmount+"元已收入钱包",memberRank1,memberRank2,memberRank3,1000);
				}
			}else{
				
				if(isCreater==1){
					showSmartAlert("红包已经超时，你获取了"+getWisdom+"颗智慧豆");
				}else{
					showSmartAlert("该红包已经超时，您获得"+rank+"名","确定");
				}		
			}
		},
		
		initTime:function(){
			var callback = new Object();
			callback.end = function(){
				$("input[name=isTimeOut]").val(1);
				initView();
			}
			var handTime = $("input[name=handTime]").val();

			var timeLong = $("input[name=timeLong]").val();

			handTime = handTime.replace(/-/g,"/");
			initGroupInvalidDate(new Date(handTime),timeLong,".luck_info_situation_time",callback);
		},
		
		initEventListener:function(){
			var outThis = this;
			
			$(".luck_info_answer_button").click(function(){
				outThis.setNext("submitAnswer");
				outThis.next();
			});
			
			$("#drawInfoBack").click(function(){
				var modelLoad = getModelLoad();
				
				modelLoad.closeModel();
			});
			
			
		},
		
		
		badComment:function(){
			$("#badCommentButton").click(function(){
				
				var isCreater = $("input[name=isCreater]").val();
				if(isCreater==1){
					showToast("您是创建者，无法进行评论");
					return;
				}
				
				if($("input[name=status]").val()==1){
					showToast("已评论");
					return;
				}
				
				if($("input[name=isAnswer]").val()==0){
					showToast("你还未参加，不能评论");
					return;
				}
				
				$(".red_packet_comment").css("display","block");
				$("input[name=type]").val(1);
				$("#red_packet_comment").animate({
					top:0
				},1000,function(){
				});
				
				
				comment();
			});
		},
		
		goodComment:function(){
			$("#goodCommentButton").click(function(){
				
				var isCreater = $("input[name=isCreater]").val();
				
				if(isCreater==1){
					showToast("您是创建者，无法进行评论");
					return;
				}
				if($("input[name=status]").val()==1){
					showToast("已评论");
					return;
				}
				
				if($("input[name=isAnswer]").val()==0){
					showToast("你还未参加，不能评论");
					return;
				}
				$(".red_packet_comment").css("display","block");
				$("input[name=type]").val(0);
				$("#red_packet_comment").animate({
					top:0
				},1000,function(){
				});
				comment();
			});
		},
		
		
		
		submitAnswer:function(){
			var roomId = $("input[name=packetRoomId]").val();

			var roomMemberId = $("input[name=roomMemberId]").val();
			
			var answer = $("#luck_info_answer_input").val();
			
			var answerLength = answer.length;
			
			var wordNum = $("input[name=wordNum]").val();
			
			wordNum = parseInt(wordNum);
			
			
			var count = $("input[name=count]").val();
			count = parseInt(count);
			
			var allowWrongCount = $("input[name=allowWrongCount]").val();
			allowWrongCount = parseInt(allowWrongCount);
			
			var isReceive = $("input[name=isReceive]").val();
			isReceive = parseInt(isReceive);
			
			
			var isPay = $("input[name=isPay]").val();
			
			isPay = parseInt(isPay);
			
			var isInRoom = $("input[name=isInRoom]").val();
			
			isInRoom = parseInt(isInRoom);
			
			var type = $("input[name=type]").val();
			
			type = parseInt(type);
			
			
			var isSetOption = $("input[name=isSetOption]").val();
			isSetOption = parseInt(isSetOption);
			
			if(type==0&&isInRoom==0){
				showToast("本红包属于房间专属红包，你尚未加入本房间，请先点击‘进入房间’按钮加入房间",5000);
				return;
			}
			
			if(isPay!=1){
				showToast("该红包尚未付款");
				return;
			}
			
			if(isReceive==1){
				showToast("该红包已经被领取");
				return;
			}
			if(!answer){
				showToast("答案不能为空");
				return;
			}
			
			if(answerLength!=wordNum&&isSetOption!=1){
				showToast("请输入"+wordNum+"个字");
				return;
			}
			
			if(isEnd){
				showToast("时间已结束");
				return;
			}
			
			
			var redPacketId = $("input[name=redPacketId]").val();
			var params = new Object();
			params.id = redPacketId;
			params.room_id = roomId;
			params.room_member_id = roomMemberId;
			params.answer = answer;
			var callback = new Object();
			showLoading();
			callback.success = function(obj){
				hideLoading();
				if(obj.success){
					addDrawModelCallback.answerResult(obj);
					
					/*if(obj.data.isRight==1){
						
					}else{
						
						var count = $("input[name=count]").val();
						count = parseInt(count);
						count = count+1;
						
						$("input[name=count]").val(count);
						showToast("回答错误");
						
						$("#luck_info_answer_input").val("");
						
					}*/
				}else{
					alert(obj.errorMsg);
				}
			}
			
			callback.failure = function(obj){
				hideLoading();
				showToast("现在用户访问量过大，请稍后再试");
			}
			
			request("/api/draw/red_pack/answer",callback,params);
		},
		
		initStar:function(){
			$.fn.raty.defaults.path="/raty/img";
			
			$("#publicCommend").raty({
				score:2,
				imgWidth:"10px",
				imgHeight:"10px",
				readOnly:true
			});
			
			$("#accordStar").raty({
				score:$("input[name=accordStar]").val(),
				size:50,
				click:function(num){
					$("input[name=accordStar]").val(num);
				}
			});
			
			$("#usefulStar").raty({
				score:$("input[name=usefulStar]").val(),
				size:50,
				
				click:function(num){
					$("input[name=usefulStar]").val(num);
				}
			});
			
			$("#interestingStar").raty({
				score:$("input[name=interestingStar]").val(),
				size:50,
				click:function(num){
					$("input[name=interestingStar]").val(num);
				}
			});
		}

	});
	
	this.close = function(){
		
	}
	
	this.init = function(id){
		
		var modelLoad = getModelLoad();
		
		var url = "/view/draw/luck_draw/info?id="+id;
		modelLoad.loadUrl(url,{
			success:function(){
				drawInfoFlowPlug.flowPlug.setNext("initDrawInfo");
				drawInfoFlowPlug.flowPlug.next();
			}
		});
	}
}
			
/*		
			
			
			
			$(".red_packet_takepart_button").click(function(){
				payFee();
			});
			
			$("#comentButtonLeft").click(function(){
				$("#red_packet_comment").animate({
					top:800
				},1000,function(){
					$(".red_packet_comment").css("display","none");
				});
				
			});
			
			$("#comentButtonRight").click(function(){
				var accortStar = $("input[name=accordStar]").val();
				var usefulStar = $("input[name=usefulStar]").val();
				var interestingStar = $("input[name=interestingStar]").val();
				
				var redPacketComment = $("textarea[name=redPacketComment]").val();
				
				if(accortStar==0){
					showToast("请为符合度打分");
					return;
				}
				
				if(usefulStar==0){
					showToast("请为实用性打分");
					return;
				}
				
				if(interestingStar==0){
					showToast("请为有趣打分");
					return;
				}
				
				if(!redPacketComment){
					showToast("请填写评语");
					return;
				}
				
				var type = $("input[name=type]").val();
				
				var redPacketId = $("input[name=redPacketId]").val();
				
				var params = new Object();
				params.red_packet_id = redPacketId;
				params.useful_star = usefulStar;
				params.accord_star = accortStar;
				params.interesting_star = interestingStar;
				params.content = redPacketComment;
				params.type = type;
				
				var url = "/api/draw/red_pack/coment";
				
				var callback = new Object();
				
				callback.success = function(resp){
					
					alert(resp.errorMsg);
					if(resp.success){
						
						showToast("评论成功",3000);
						$("#red_packet_comment").animate({
							top:800
						},1000,function(){
							$(".red_packet_comment").css("display","none");
						});
						
						$("input[name=status]").val(1);
						if(type==0){
							$("input[name=goodNum]").val($("input[name=goodNum]").val()*1+1);
							
							
						}else if(type==1){
							$("input[name=badNum]").val($("input[name=badNum]").val()*1+1);
							
							var getWisdom = $("input[name=getWisdom]").val();
							getWisdom = parseInt(getWisdom);
							getWisdom = getWisdom+2;
							
							$("#getWisdomItemText").text(getWisdom+"颗");
						}
						comment();
						
					}else{
						showToast("网络繁忙，请稍后再试😊");
					}
				}
				request(url,callback,params)
			});
		
			$("#red_packet_takepart").css("bottom","-200px");
			$("body").css("padding-bottom","50px");
			
			$("body").css("background-color","white");
			$("#receiveButton").click(function(){
				var status=1;
				var problemId = $("input[name=firstProblemId]").val();
				var redPacketId = $("input[name=redPacketId]").val();
				skipToVieAnswerProblem(status,redPacketId,problemId,"");
			});
			document.addEventListener("touchstart",function(){
				
			},false);
function initDialog(){

}

function averageStarCount(){
	var accordStar1Num = $("input[name=accordStar1Num]").val();
var accordStar2Num = $("input[name=accordStar2Num]").val();
var accordStar3Num = $("input[name=accordStar3Num]").val();
var accordStar4Num = $("input[name=accordStar4Num]").val();
var accordStar5Num = $("input[name=accordStar5Num]").val();

var usefulStar1Num = $("input[name=usefulStar1Num]").val();
var usefulStar2Num = $("input[name=usefulStar2Num]").val();
var usefulStar3Num = $("input[name=usefulStar3Num]").val();
var usefulStar4Num = $("input[name=usefulStar4Num]").val();
var usefulStar5Num = $("input[name=usefulStar5Num]").val();

var interestingStar1Num = $("input[name=interestingStar1Num]").val();
var interestingStar2Num = $("input[name=interestingStar2Num]").val();
var interestingStar3Num = $("input[name=interestingStar3Num]").val();
var interestingStar4Num = $("input[name=interestingStar4Num]").val();
var interestingStar5Num = $("input[name=interestingStar5Num]").val();
	
	var starAll = accordStar1Num*1+accordStar2Num*2+accordStar3Num*3+accordStar4Num*4+accordStar5Num*5;
	starAll = starAll+usefulStar1Num*1+usefulStar2Num*2+usefulStar3Num*3+usefulStar4Num*4+usefulStar5Num*5;
	starAll  = starAll+interestingStar1Num*1+interestingStar2Num*2+interestingStar3Num*3+interestingStar4Num*4+interestingStar5Num*5;

	var numAll = accordStar1Num*1+accordStar2Num*1+accordStar3Num*1+accordStar4Num*1+accordStar5Num*1;

	numAll = numAll+usefulStar1Num*1+usefulStar2Num*1+usefulStar3Num*1+usefulStar4Num*1+usefulStar5Num*1;

	numAll  = numAll+interestingStar1Num*1+interestingStar2Num*1+interestingStar3Num*1+interestingStar4Num*1+interestingStar5Num*1;

	if(numAll==0){
		return 0;
	}else{
		return starAll/numAll;
	}
}

function comment(){
	var averageStar = averageStarCount();
	if(averageStar!=0){
		$("#publicCommend").raty({
		score:averageStar,
		imgWidth:"10px",
		imgHeight:"10px",
		readOnly:true
	});
}else{
	$("#publicCommendItem").css("display","none");
}

var goodNum = $("input[name=goodNum]").val();
var badNum = $("input[name=badNum]").val();

if(goodNum==null||goodNum==0){
	$("#goodCommentButton span:nth-child(2)").text("好评");
}else{
	$("#goodCommentButton span:nth-child(2)").text("好评"+goodNum);
}

if(badNum==null||badNum==0){
	$("#badCommentButton span:nth-child(2)").text("差评");
}else{
	$("#badCommentButton span:nth-child(2)").text("差评"+badNum);
	}
}

*/
$(document).ready(function(){
	
	
});

			

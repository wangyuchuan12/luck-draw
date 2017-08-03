function numTransform(num){
	if(!num){
		return 0;
	}else if(num<10000){
		return num;
	}else if(num>=1000&&num<10000){
		var count = num/1000;
		return count+"千";
	}else if(num>=10000){
		var count = num/10000;
		return count+"万";
	}
}

function uuid() {
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
        var r = Math.random()*16|0, v = c == 'x' ? r : (r&0x3|0x8);
        return v.toString(16);
    });
}

function submitGameResult(type,callback,score1,score2,score3){
	var params = new Object();
	params.score1 = score1;
	params.score2 = score2;
	params.score3 = score3;
	var url = "/api/dekorn/takepart";
	request(url,callback,params);
}


function skipToTakeout(){
	skipToUrl("/view/draw/personal_center/takeOut");
}

function skipToBattleInfo(battleId){
	return skipToUrl("/view/dekorn/battleInfo?battleId="+battleId);
}

function skipToProgressScore(){
	return skipToUrl("/view/dekorn/progressScore");
}

function doJoinRoom(type,question,roomId,callback){
	var url = "";
	if(type==0){
		layer.prompt({
			title:"请输入密码",
			formType:1
		},function(password){
			var url = "/api/draw/draw_room/join_room";
			var params = new Object();
			params.password = password;
			params.verify_type = type;
			params.room_id = roomId;
			request(url,callback,params);
			layer.closeAll();
		});
	}else if(type==1){
		layer.prompt({
			title:question
		},function(answer){
			var url = "/api/draw/draw_room/join_room";
			var params = new Object();
			params.verify_type = type;
			params.room_id = roomId;
			params.verify_answer = answer;
			request(url,callback,params);
			layer.closeAll();
		});
	}else{
		layer.confirm("是否确定加入该房间",function(){
			var url = "/api/draw/draw_room/join_room";
			var params = new Object();
			params.verify_type = type;
			params.room_id = roomId;
			request(url,callback,params);
			layer.closeAll();
		});
	}
	
}


function skipToRedPacketOption(id){
	var url = "/view/draw/luck_draw/red_packet_option";
	var params = new Object();
	params.id=id;
	skipToUrl(url,params);
}

function skipToRedpackList(type){
	var url = "/view/draw/luck_draw/list";
	
	var params = new Object();
	params.type=type;
	skipToUrl(url,params);
}

function skipToAddRoom(){
	var url = "/view/draw/draw_room/add";
	skipToUrl(url);
	
}

function skipToRooms(){
	var url = "/view/draw/draw_room/list";
	var params = new Object();
	skipToUrl(url,params);
}


function skipToRedPackInfo(id,type){
	type = parseInt(type);
	if(type==0){
		skipToProblemRedPacketInfo(id);
	}else if(type==1){
		skipToVieDrawInfo(id);
	}
}

function skipToProblemRedPacketInfo(id,firstVisit){
	var url = "/view/draw/luck_draw/info";
	var params = new Object();
	params.id = id;
	params.firstVisit = firstVisit;
	skipToUrl(url,params);
}

function skipToRoomInfo(id){
	var url = "/view/draw/draw_room/info";
	var params = new Object();
	params.id = id;
	skipToUrl(url,params);
}


function skipToHome(){
	var url = "/view/draw/main/home";
	
	skipToUrl(url);
}

function skipToPersonalCenter(){
	
	var url = "/view/draw/personal_center/main";
	
	skipToUrl(url);
}

function skipToPapers(content){
	var url = "/view/question/paperInfo?id=1";
	var papersPlug = new LayerPlug(url,1,1,content);
	
	return papersPlug;
}

function skipToRoomInfo(id){
	var params = new Object();
	params.id = id;
	
	var url = "/view/draw/draw_room/info";
	
	skipToUrl(url,params);
}


function skipToAddRedPack(isRoom,isDisplayRoom,isDisplayType,subjectId,roomId){
	var url = "/view/draw/luck_draw/add2";
	
	var params  = new Object();
	params.is_room = isRoom;
	
	params.isDisplayRoom = isDisplayRoom;
	
	params.isDisplayType = isDisplayType;
	
	params.subjectId = subjectId;
	params.room_id = roomId;
	skipToUrl(url,params);
}

function skipToDrawInfo(){
	var url = "/view/vie/draw/vie_draw/info";
	var params = new Object();
	skipToUrl(url,params);
}

function skipToVieAnswerProblem(redPacketId,memberId){
	var url = "/view/vie/draw/vie_draw/vie_answer_problem";
	var params = new Object();
	params.red_packet_id = redPacketId;
	params.member_id = memberId;
	skipToUrl(url,params);
}


function skipToVieSetProblem(status,redPacketId,problemId,previousProblemId){
	var url = "/view/vie/draw/vie_draw/vie_set_problem";
	var params = new Object();
	params.status=status;
	params.red_packet_id = redPacketId;
	params.problem_id = problemId;
	params.previous_problem_id = previousProblemId;
	skipToUrl(url,params);
}

function skipToVieDrawInfo(id,firstVisit){
	var url = "/view/vie/draw/vie_draw/info"
	var params = new Object();	
	params.id = id;
	params.firstVisit = firstVisit;
	skipToUrl(url,params);
}


function skipToGame(code,dekornId,status,passScore,takepartId){
	var url = "/games/skipToGame";
	var params = new Object();
	params.code = code;
	params.status = status;
	params.passScore = passScore;
	params.dekornId = dekornId;
	params.takepartId = takepartId;
	skipToUrl(url,params);
}


function skipGameDekornInfo(id,gameCode){
	var params = new Object();
	params.id = id;
	params.gameCode = gameCode;
	var url = "/view/game/game_dekorn/info";
	
	skipToUrl(url,params);
}


function skipToAddVieDrawInfo(redPackType,isDisplayRoom,isDisplayType,subjectId,roomId){
	var url = "/view/vie/draw/vie_draw/add";
	
	var params = new Object();
	params.redPackType = redPackType;
	params.isDisplayRoom = isDisplayRoom;
	params.isDisplayType = isDisplayType;
	params.subjectId = subjectId;
	params.room_id=roomId;
	skipToUrl(url,params);
}

function skipToSubject(parentId,redPacketType,isDisplayRoom,isDisplayType,roomId,isRoom){
	
	var url = "/view/draw/luck_draw/subject_check";
	var params = new Object();
	
	params.parent_id =  parentId;
	
	params.redPackType = redPacketType;
	params.isDisplayRoom = isDisplayRoom;
	params.isDisplayType = isDisplayType;
	
	params.roomId = roomId;
	
	params.isRoom = isRoom;
	skipToUrl(url,params);
}


function skipVieAnswerResult(redPacketId){
	var params = new Object();
	
	params.id = redPacketId;
	
	var url = "/view/vie/draw/vie_draw/vie_answer_result";
	
	skipToUrl(url,params);
}

function skipToUrl(url,params){
	var temp = document.createElement("form");
	temp.action = url;
    temp.method = "GET";        
    temp.style.display = "none";        
    var opt = document.createElement("textarea");
    temp.appendChild(opt);              
    
    if(params){
	    for(var name in params){
	    	var node = document.createElement("textarea");
	    	node.value=params[name];
	    	node.name=name;
	    	temp.appendChild(node);
	    }
    }
    
    document.body.appendChild(temp);
    temp.submit();
	
}


function fileRequest(url,callback,elementId){

	url = getWebpath()+url;
	var formData = new FormData();

	var name = $("#"+elementId).attr("name");
	var file = $("#"+elementId)[0].files[0];
	formData.append(name,file);
	if(url.indexOf("?")>0){
		if(token){
			url=webPath+url+"&token="+token;
		}else{
			url=webPath+url;
		}
	}else{
		if(token){
			url=webPath+url+"?token="+token;
		}else{
			url=webPath+url;
		}
	}
	
	$.ajax({
		url:url,
		type:"POST",
		data:formData,
		processData:false,
		contentType:false,
		success:function(resp){
			if(callback){
			
				callback.success(resp);
					
				
			}
		},
		failure:function(resp){
			callback.failure(resp);
		}
	});
	
}


function requestData(url,callback,data){
	data = JSON.stringify(data);
	$.ajax({
		url:url,
		data:data,
		type:"post",
		dataType:"json",
		success:function(obj){
			alert(obj.errorMsg);
		}
	});
}


function request(url,callback,params){
	$.ajax({
		url:url,
		method:"POST",
		data:params,
		success:function(resp){
			if(callback){
				callback.success(resp);
			}
		},
		error:function(resp){
			callback.failure(resp);
		}
	});
}

function wxConfig(appId,signature,noncestr,t){
	wx.config({
	    debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
	    appId:appId, // 必填，公众号的唯一标识
	    timestamp:t, // 必填，生成签名的时间戳
	    nonceStr:noncestr, // 必填，生成签名的随机串
	    signature: signature,// 必填，签名，见附录1
	    jsApiList: [
	                'checkJsApi',
	                'onMenuShareTimeline',
	                'onMenuShareAppMessage',
	                'onMenuShareQQ',
	                'onMenuShareWeibo',
	                'hideMenuItems',
	                'showMenuItems',
	                'hideAllNonBaseMenuItem',
	                'showAllNonBaseMenuItem',
	                'translateVoice',
	                'startRecord',
	                'stopRecord',
	                'onRecordEnd',
	                'playVoice',
	                'pauseVoice',
	                'stopVoice',
	                'uploadVoice',
	                'downloadVoice',
	                'chooseImage',
	                'previewImage',
	                'uploadImage',
	                'downloadImage',
	                'getNetworkType',
	                'openLocation',
	                'getLocation',
	                'hideOptionMenu',
	                'showOptionMenu',
	                'closeWindow',
	                'scanQRCode',
	                'chooseWXPay',
	                'openProductSpecificView',
	                'addCard',
	                'chooseCard',
	                'openCard'
	              ]
	});
	
	document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
		WeixinJSBridge.call('hideToolbar');
	});
//	wx.ready(function(){
//		wx.showMenuItems({
//            menuList: [
//                'menuItem:profile', // 添加查看公众号
//                'menuItem:addContact'
//            ]
//        });
//		
//	});
}

function wxOnMenuShareAppMessage(title,desc,link,imgUrl,type,dataUrl,callback){

	var obj = new Object();
	obj.title = title;
	obj.desc = desc;
	obj.link = link;
	obj.imgUrl = imgUrl;
	obj.type = type;
	obj.dataUrl = dataUrl;
	obj.success = function(){
		if(callback&&callback.success){
			callback.success();
		}
	}
	obj.cancel = function(){
		if(callback&&callback.cancel){
			callback.cancel();
		}
	}
	wx.error(function(){
		//alert("error");
	});
	
	wx.onMenuShareAppMessage(obj);
	wx.onMenuShareTimeline(obj);
	
	
}


function onBridgeReady(timestamp,nonceStr,pack,signType,paySign,callback){
	   WeixinJSBridge.invoke(
	       'getBrandWCPayRequest', {
	           "appId":"wxb07bdf79ef8f00a9",     //公众号名称，由商户传入     
	           "timeStamp":timestamp,         //时间戳，自1970年以来的秒数     
	           "nonceStr":nonceStr, //随机串     
	           "package":pack,     
	           "signType":signType,         //微信签名方式：     
	           "paySign":paySign, //微信签名 
	           success: function (res) {
			    	callback.success();
			    	
			    },
			    
			    cancel:function(res){
			    	callback.cancel();
			    },
			    
			    fail:function(res){
			    	callback.failure();
			    }
	       },
	       function(res){
	    	   alert("res:"+res);
	    	   alert("res:"+JSON.stringify(res));
	           if(res.err_msg == "get_brand_wcpay_request:ok" ) {}     // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。 
	       }
	   ); 
}

function wxPay(timestamp,nonceStr,pack,signType,paySign,callback){
	wx.ready(function(){
		wx.chooseWXPay({
			appId:"wxb07bdf79ef8f00a9",
			timestamp:timestamp, // 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符
		    nonceStr: nonceStr, // 支付签名随机串，不长于 32 位
		    package: pack, // 统一支付接口返回的prepay_id参数值，提交格式如：prepay_id=***）
		    signType:signType, // 签名方式，默认为'SHA1'，使用新版支付需传入'MD5'
		    paySign: paySign, // 支付签名
		    success: function (res) {
		    	callback.success();
		    	
		    },
		    
		    cancel:function(res){
		    	callback.cancel();
		    },
		    
		    fail:function(res){
		    	callback.failure();
		    }
		});
		
	});
}





function toImg(url,element,name,callback){

	url = getWebpath()+url;
	$(element).append("<div class='fileImg'>"+
						"<input readonly='readonly' id='var_"+name+"' type='text' name='var_"+name+"'/>"+
						"<img src='/imgs/photo_icon.png'"+
						"style='width:100px;height:100px;z-index:10000'>"+
						"</div><input name='"+name+"' type='file' "+
						"style='display:none '"+
					
						"multiple>");
	
	$(element).append("<label for='var_"+name+"' class='error'></label>");
	
	$("input[name=var_"+name+"]").css("position","absolute");
	$("input[name=var_"+name+"]").css("color","red");
	$("input[name=var_"+name+"]").css("top","-1000px");
	$("input[name=var_"+name+"]").css("padding-top","100px");
	$(element).children(".fileImg").click(function(){
		var file =  $("input[name='"+name+"']");
		file.click();
		file.fileupload({
			url:url,
			dataType: 'json',
			add: function (e, data) {
				$(".fileImg img").attr("src","/imgs/loading.gif");
				var file = data.originalFiles[0];
				var acceptFileTypes = /(\.|\/)(gif|jpe?g|png)$/i;
				if(acceptFileTypes.test(file.name)){
					if(file.size>548576){
						layer.alert("亲，图片太大了，图片不能超过530KB");
						$(".fileImg img").attr("src","/imgs/photo_icon.png");
						return false;
					}else{
						data.submit();
					}
				}
				
			},
			done: function (e, resp) {
				
				if(resp.result&&resp.result.success){
					if(resp.result.data){
						var url = resp.result.data.url;
						$(".fileImg img").attr("src",url);
						if(callback){
							$("input[name=var_"+name+"]").val(url);
							callback.success(resp.result.data);
						}
					}
				}else{
					callback.failure(resp.result);
				}
				
			},
			progressall: function (e, data) {
			}
		});
	});
}




function toBigerImg(url,element,name,callback){

	url = getWebpath()+url;
	$(element).append("<div class='fileImg'>"+
						"<input readonly='readonly' id='var_"+name+"' type='text' name='var_"+name+"'/>"+
						"<img src='/imgs/photo_icon.png'"+
						"style='width:130px;height:130px;z-index:10000'>"+
						"</div><input name='"+name+"' type='file' "+
						"style='display:none '"+
					
						"multiple>");
	
	$(element).append("<label for='var_"+name+"' class='error'></label>");
	
	$("input[name=var_"+name+"]").css("position","absolute");
	$("input[name=var_"+name+"]").css("color","red");
	$("input[name=var_"+name+"]").css("top","-1000px");
	$("input[name=var_"+name+"]").css("padding-top","100px");
	$(element).children(".fileImg").click(function(){
		var file =  $("input[name='"+name+"']");
		file.click();
		file.fileupload({
			url:url,
			dataType: 'json',
			add: function (e, data) {
				$(".fileImg img").attr("src","/imgs/loading.gif");
				var file = data.originalFiles[0];
				var acceptFileTypes = /(\.|\/)(gif|jpe?g|png)$/i;
				if(acceptFileTypes.test(file.name)){
					if(file.size>548576){
						layer.alert("亲，图片太大了，图片不能超过530KB");
						$(".fileImg img").attr("src","/imgs/photo_icon.png");
						return false;
					}else{
						data.submit();
					}
				}
				
			},
			done: function (e, resp) {
				
				if(resp.result&&resp.result.success){
					if(resp.result.data){
						var url = resp.result.data.url;
						$(".fileImg img").attr("src",url);
						if(callback){
							$("input[name=var_"+name+"]").val(url);
							callback.success(resp.result.data);
						}
					}
				}else{
					callback.failure(resp.result);
				}
				
			},
			progressall: function (e, data) {
			}
		});
	});
}















function initGroupInvalidDate(startTime,timeLong,el,callback){
	var hourEl = $(el).children("b").eq(0);
	var minuteEl = $(el).children("b").eq(1);
	var secondEl = $(el).children("b").eq(2);
	var interval = window.setInterval(function(){
		var timestamp = startTime.valueOf()+parseFloat(timeLong)*3600000;
		var now = new Date();
		var nowTimestamp = now.valueOf();
		if(timestamp>nowTimestamp){
			var second = new Date(timestamp-nowTimestamp).getSeconds();
			var min = new Date(timestamp-nowTimestamp).getMinutes();
			
			var date = new Date(timestamp-nowTimestamp).getDate()-1;
			var hour = new Date(timestamp-nowTimestamp).getHours()-8+date*24;
			if(hour>=10){
				hourEl.html(hour+"");
			}else{
				hourEl.html("0"+hour+"");
			}
			
			if(min>=10){
				minuteEl.html(min+"");
			}else{
				minuteEl.html("0"+min+"");
			}
			
			if(second>=10){
				secondEl.html(second+"");
			}else{
				secondEl.html("0"+second+"");
			}
		}else{
			
			hourEl.html("00");
			minuteEl.html("00");
			secondEl.html("00");
			window.clearInterval(interval);
			callback.end();
		}
		
	}, 1000); 
}

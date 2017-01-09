
var token = "aeff346a-e9fe-4729-b59b-9b87141cb80e";
function skipToUrl(url,params,flag){
	var temp = document.createElement("form");
	if(!flag){
		temp.action = getWebpath()+url;
	}else{
		temp.action = url;
	}
    temp.method = "post";        
    temp.style.display = "none";        
    var opt = document.createElement("textarea");        
    opt.name = "token";
	opt.value = token;
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


function request(url,callback,params){
	url = getWebpath()+url;
	params.token = token;
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

function wxOnMenuShareAppMessage(title,desc,link,imgUrl,type,dataUrl){
	var obj = new Object();
	obj.title = title;
	obj.desc = desc;
	obj.link = link;
	obj.imgUrl = imgUrl;
	obj.type = type;
	obj.dataUrl = dataUrl;
	obj.success = function(){
		
	}
	obj.cancel = function(){
		
	}
	wx.onMenuShareAppMessage(obj);
	wx.onMenuShareTimeline(obj);
}


function wxPay(timestamp,nonceStr,pack,signType,paySign,callback){
	wx.ready(function(){
		alert();
		wx.chooseWXPay({
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

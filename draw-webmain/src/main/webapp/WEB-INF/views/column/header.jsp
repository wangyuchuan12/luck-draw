<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<input name="roomId" value="${roomId}" hidden="true"/>

<input name="isDisplayRoom" value="${isDisplayRoom}" hidden="true"/>

<input name="isDisplayType" value="${isDisplayType}" hidden="true"/>

<input name="isInRoom"  value="${isInRoom}" hidden="true"/>

<input name="verifyType"  value="${verifyType}" hidden="true"/>

<input name="verifyQuestion"  value="${VerifyQuestion}" hidden="true"/>

<!-- 0为房间 -->
<input name="view" value="${view}" hidden="true"/>
<script type="text/javascript">


function isInRoomFilterRequest(url,callback,params){
	var isInRoom = getIsInRoom();
	isInRoom = parseInt(isInRoom);
	if(isInRoom==0){
		showToast("你未加入本房间，不能进行任何操作，请先加入房间");
	}else{
		request(url,callback,params)
	}
}

function setVerifyType(verifyType){
	$("input[name=verifyType]").val(verifyType);
}

function getVerifyType(){
	return $("input[name=verifyType]").val();
}

function getVerifyQuestion(){
	return $("input[name=verifyQuestion]").val();
}

function setVerifyQuestion(question){
	$("input[name=verifyQuestion]").val(question);
}



function setIsInRoom(isInRoom){
	$("input[name=isInRoom]").val(isInRoom);
}


function getIsInRoom(){
	return $("input[name=isInRoom]").val();
}


function setRoomId(roomId){
	$("input[name=roomId]").val(roomId);
}


function setIsDisplayType(isDisplayType){
	$("input[name=isDisplayType]").val(isDisplayType);
}

function setIsDisplayRoom(isDisplayRoom){
	$("input[name=isDisplayRoom]").val(isDisplayRoom);
}


function getIsDisplayType(){
	return $("input[name=isDisplayType]").val();
}

function getIsDisplayRoom(){
	return $("input[name=isDisplayRoom]").val();
}
 
function getRoomId(){
	return $("input[name=roomId]").val();
}

function skipToRoom(){
	
	var url = "/view/draw/draw_room/info";
	var params = new Object();
	params.id = getRoomId();
	skipToUrl(url,params);
}

function skipToHandRedPack(){
	
	var isInRoom = getIsInRoom();
	isInRoom = parseInt(isInRoom);
	
	if(isInRoom==0){
		showToast("你未加入本房间，不能进行任何操作，请先加入房间",5000);
	}else{
		var url = "/view/draw/luck_draw/add";
		
		var redPackType =0;
		var isDisplayRoom =getIsDisplayRoom();
		var isDisplayType =  getIsDisplayType();
		
		var params = new Object();
		
		params.redPackType = redPackType;
		params.isDisplayRoom = isDisplayRoom;
		params.isDisplayType = isDisplayType;
		
		params.room_id = getRoomId();
		skipToUrl(url,params);
	}
	
	
	
}

function skipToAddRoom(){
	var url = "/view/draw/draw_room/add";
	skipToUrl(url);
	
}

function joinRoom(){
	var isInRoom = getIsInRoom();
	isInRoom = parseInt(isInRoom);
	var verifyType = getVerifyType();
	verifyType = parseInt(verifyType);
	var verifyQuestion = getVerifyQuestion();
	var roomId = getRoomId();
	if(isInRoom==1){
		showToast("你已经加入房间，无需重复加入");
	}else{
		var callback = new Object();
		callback.success = function(obj){
			if(obj.success){
				setIsInRoom(1);
				showToast("申请加入成功");
				if(drawRoomMemberAddListener){
					drawRoomMemberAddListener(obj.data.imgUrl,obj.data.name);
				}
			}else{
				showToast("对不起，你输入的密码不匹配");
			}
		}
		
		callback.failure = function(){
			showToast("网络发生异常");
		}
		doJoinRoom(verifyType,verifyQuestion,roomId,callback)
	}
}

</script>

<div class="luck_toole_header">
		<ul>
			<li>
				<em class="fa fa-life-ring" style="color:RGBA(0,128,220,1);"></em>
				<span>踢人</span>
			</li>
		
			<li>
				<em class="fa fa-pencil-square-o" style="color: RGBA(19,162,133,1);"></em>
				<span>更改口令</span>
			</li>
			
			<li onclick="skipToHandRedPack();">
				<em class="fa fa-paper-plane" style="color: RGBA(243,151,37,1);"></em>
				<span>发红包</span>
			</li>
		
			<li onclick="joinRoom();">
				<em class="fa fa-sign-in" style="color: RGBA(126,213,61,1);"></em>
				<span>加入房间</span>
			</li>
			
			<li>
				<em class="fa fa-sign-out" style="color: RGBA(251,222,2,1);"></em>
				<span>退出房间</span>
			</li>
			<li onclick="skipToAddRoom();">
				<em class="fa fa-plus" ></em>
				<span>创建房间</span>
			</li>
			
			<li>
				<em class="fa fa-bullhorn" style="color:green;"></em>
				<span>消息</span>
			</li>
			
			<li>
				<em class="fa fa-comment" style="color:RGBA(46,185,0,1);"></em>
				<span>聊天</span>
			</li>
			
			<li>
				<em class="fa fa-home" style="color:RGBA(126,213,61,1);"></em>
				<span>返回主页</span>
			</li>
			
			<li>
				<em class="fa fa-qq" style="color:RGBA(0,128,220,1);"></em>
				<span>我的好友</span>
			</li>
			
			
		</ul>
			
	</div>
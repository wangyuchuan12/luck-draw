package com.wyc.draw.vo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;
import com.wyc.common.util.MyDateSerializer;

@ParamEntityAnnotation
public class RedPacketVo {

	@IdAnnotation
    private String id;
	
	
	//红包所属房间参与用户id
	@ParamAnnotation
	private String handRoomMemberId;
	
	//本用户的房间成员id;
	@ParamAnnotation
	private String myRoomMemberId;
	
	//所属房间id
	@ParamAnnotation
	private String drawRoomId;
	
	//红包类型
	@ParamAnnotation
	private Integer type;
	
	//红包用户id
	@ParamAnnotation
	private String handDrawUserId;
	
	
	//红包接收人
	@ParamAnnotation
	private String receiveDrawUserId;
	
	//发送时间
//	@JsonSerialize(as=MyDateSerializer.class)
	@ParamAnnotation
	private DateTime handTime;
	
	//红包截止时长
	@ParamAnnotation
	private int timeLong;
	
	//红包金额
	@ParamAnnotation
	private BigDecimal amount;
	
	//问题
	@ParamAnnotation
	private String question;
	
	//答案
	@ParamAnnotation
	private String answer;
	
	
	//红包付款订单号
	@ParamAnnotation
	private String outTradeNo;

	//是否可领取
	@ParamAnnotation
	private Integer isReceiveAble;
	
	//红包是否已接受
	@ParamAnnotation
	private Integer isReceive;
	
	//红包是否已到时间
	@ParamAnnotation
	private Integer isTimeout;
	
	//允许错误次数
	@ParamAnnotation
	private Integer allowWrongCount;
	
	
	//是否已付款
	@ParamAnnotation
	private Integer isPay;
	
	//支付类型
	@ParamAnnotation
	private Integer payType;
	
	//提示信息
	@ParamAnnotation
	private String prompt;
	
	//是否退款
	@ParamAnnotation
	private Integer isRefund;
	
	@ParamAnnotation
	private String nickname;
	
	@ParamAnnotation
	private String userImgUrl;
	
	@ParamAnnotation
	private Integer count;
	
	@ParamAnnotation
	private Integer isInRoom;
	
	@ParamAnnotation
	private Integer isCreater;
	
	
	//是否有图片
	@ParamAnnotation
	private Integer isImg;
	
	
	//图片地址
	@ParamAnnotation
	private String imgUrl;
	
	@ParamAnnotation
	private Integer takePartCount;
	
	
	
	
	public Integer getTakePartCount() {
		return takePartCount;
	}




	public void setTakePartCount(Integer takePartCount) {
		this.takePartCount = takePartCount;
	}




	@ParamAnnotation
	private List<RedPacketTakepartMemberVo> redPacketTakepartMemberVos;



	public List<RedPacketTakepartMemberVo> getRedPacketTakepartMemberVos() {
		return redPacketTakepartMemberVos;
	}




	public void setRedPacketTakepartMemberVos(List<RedPacketTakepartMemberVo> redPacketTakepartMemberVos) {
		this.redPacketTakepartMemberVos = redPacketTakepartMemberVos;
	}




	public Integer getIsCreater() {
		return isCreater;
	}




	public void setIsCreater(Integer isCreater) {
		this.isCreater = isCreater;
	}




	public String getMyRoomMemberId() {
		return myRoomMemberId;
	}




	public void setMyRoomMemberId(String myRoomMemberId) {
		this.myRoomMemberId = myRoomMemberId;
	}




	public Integer getIsInRoom() {
		return isInRoom;
	}




	public void setIsInRoom(Integer isInRoom) {
		this.isInRoom = isInRoom;
	}




	public Integer getCount() {
		return count;
	}




	public void setCount(Integer count) {
		this.count = count;
	}




	public String getNickname() {
		return nickname;
	}




	public void setNickname(String nickname) {
		this.nickname = nickname;
	}




	public String getUserImgUrl() {
		return userImgUrl;
	}




	public void setUserImgUrl(String userImgUrl) {
		this.userImgUrl = userImgUrl;
	}




	public Integer getIsPay() {
		return isPay;
	}




	public void setIsPay(Integer isPay) {
		this.isPay = isPay;
	}




	public int getTimeLong() {
		return timeLong;
	}
	
	
	

	public String getOutTradeNo() {
		return outTradeNo;
	}




	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}




	public void setTimeLong(int timeLong) {
		this.timeLong = timeLong;
	}

	public Integer getIsTimeout() {
		return isTimeout;
	}

	public void setIsTimeout(Integer isTimeout) {
		this.isTimeout = isTimeout;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public String getHandDrawUserId() {
		return handDrawUserId;
	}

	public void setHandDrawUserId(String handDrawUserId) {
		this.handDrawUserId = handDrawUserId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public String getDrawRoomId() {
		return drawRoomId;
	}

	public void setDrawRoomId(String drawRoomId) {
		this.drawRoomId = drawRoomId;
	}

	

	public String getHandRoomMemberId() {
		return handRoomMemberId;
	}

	public void setHandRoomMemberId(String handRoomMemberId) {
		this.handRoomMemberId = handRoomMemberId;
	}

	

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public DateTime getHandTime() {
		return handTime;
	}

	public void setHandTime(DateTime handTime) {
		this.handTime = handTime;
	}

	

	public String getReceiveDrawUserId() {
		return receiveDrawUserId;
	}




	public void setReceiveDrawUserId(String receiveDrawUserId) {
		this.receiveDrawUserId = receiveDrawUserId;
	}




	public Integer getIsReceiveAble() {
		return isReceiveAble;
	}




	public void setIsReceiveAble(Integer isReceiveAble) {
		this.isReceiveAble = isReceiveAble;
	}




	public Integer getIsReceive() {
		return isReceive;
	}




	public void setIsReceive(Integer isReceive) {
		this.isReceive = isReceive;
	}




	public Integer getAllowWrongCount() {
		return allowWrongCount;
	}




	public void setAllowWrongCount(Integer allowWrongCount) {
		this.allowWrongCount = allowWrongCount;
	}




	public Integer getIsRefund() {
		return isRefund;
	}




	public void setIsRefund(Integer isRefund) {
		this.isRefund = isRefund;
	}




	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}




	public Integer getIsImg() {
		return isImg;
	}




	public void setIsImg(Integer isImg) {
		this.isImg = isImg;
	}




	public String getImgUrl() {
		return imgUrl;
	}




	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	
}

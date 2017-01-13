package com.wyc.draw.vo;

import java.math.BigDecimal;
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
	
	
	//红包所属房间id
	@ParamAnnotation
	private String drawRoomId;
	
	
	//提交用户
	@ParamAnnotation
	private String handDrawUserId;
	
	
	//红包房间成员id
	@ParamAnnotation
	private String handRoomMemberId;
	

	//红包类型
	@ParamAnnotation
	private Integer type;
	
	//提交时间
	@JsonSerialize(using=MyDateSerializer.class)
	@ParamAnnotation
	private DateTime handTime;

	//支付类型
	@ParamAnnotation
	private Integer payType;
	
	
	//用户头像
	@ParamAnnotation
	private String userImgUrl;
	
	//用户昵称
	@ParamAnnotation
	private String nickname;
	
	
	//问题
	@ParamAnnotation
	private String question;
	
	//红包金额
	@ParamAnnotation
	private BigDecimal amount;
	
	//提示信息
	@ParamAnnotation
	private String prompt;
	
	@ParamAnnotation
	private String answer;
	
	//是否已到时间
	@ParamAnnotation
	private Integer isTimeout;
	
	//时长
	@ParamAnnotation
	private int timeLong;
	
	
	@ParamAnnotation
	private String outTradeNo;
	
	
	
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

	public String getUserImgUrl() {
		return userImgUrl;
	}

	public void setUserImgUrl(String userImgUrl) {
		this.userImgUrl = userImgUrl;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	
	
}

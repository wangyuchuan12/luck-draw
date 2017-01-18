package com.wyc.draw.vo;

import java.math.BigDecimal;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;
import com.wyc.common.util.MyDateSerializer;

@ParamEntityAnnotation
public class DrawRoomMemberVo {
	
	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	private String adminId;
	
	@ParamAnnotation
	private Integer answerNum;
	
	@ParamAnnotation
	private String drawRoomId;
	
	@ParamAnnotation
	private BigDecimal getRedPakcetAmount;
	
	@ParamAnnotation
	private Integer getRedPacketNum;
	
	@ParamAnnotation
	private BigDecimal handRedPacketAmount;
	
	@ParamAnnotation
	private Integer handRedPacketNum;
	
	@ParamAnnotation
	private Integer isCreater;
	
	@ParamAnnotation
	private String name;
	
	@ParamAnnotation
	private String openid;
	
	@ParamAnnotation
	private Integer status;
	
	@ParamAnnotation
	private String userId;
	
	@ParamAnnotation
	private String imgUrl;
	
	@ParamAnnotation
	private Integer wrongAnswerNum;
	
	@JsonSerialize(using=MyDateSerializer.class)
	@ParamAnnotation
	private DateTime takepartTime;


	@ParamAnnotation
	private String drawUserId;
	
	
	
	
	public String getDrawUserId() {
		return drawUserId;
	}


	public void setDrawUserId(String drawUserId) {
		this.drawUserId = drawUserId;
	}


	public String getImgUrl() {
		return imgUrl;
	}


	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getAdminId() {
		return adminId;
	}


	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}


	public Integer getAnswerNum() {
		return answerNum;
	}


	public void setAnswerNum(Integer answerNum) {
		this.answerNum = answerNum;
	}


	public String getDrawRoomId() {
		return drawRoomId;
	}


	public void setDrawRoomId(String drawRoomId) {
		this.drawRoomId = drawRoomId;
	}


	public BigDecimal getGetRedPakcetAmount() {
		return getRedPakcetAmount;
	}


	public void setGetRedPakcetAmount(BigDecimal getRedPakcetAmount) {
		this.getRedPakcetAmount = getRedPakcetAmount;
	}


	public Integer getGetRedPacketNum() {
		return getRedPacketNum;
	}


	public void setGetRedPacketNum(Integer getRedPacketNum) {
		this.getRedPacketNum = getRedPacketNum;
	}


	public BigDecimal getHandRedPacketAmount() {
		return handRedPacketAmount;
	}


	public void setHandRedPacketAmount(BigDecimal handRedPacketAmount) {
		this.handRedPacketAmount = handRedPacketAmount;
	}


	public Integer getHandRedPacketNum() {
		return handRedPacketNum;
	}


	public void setHandRedPacketNum(Integer handRedPacketNum) {
		this.handRedPacketNum = handRedPacketNum;
	}


	public Integer getIsCreater() {
		return isCreater;
	}


	public void setIsCreater(Integer isCreater) {
		this.isCreater = isCreater;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getOpenid() {
		return openid;
	}


	public void setOpenid(String openid) {
		this.openid = openid;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public Integer getWrongAnswerNum() {
		return wrongAnswerNum;
	}


	public void setWrongAnswerNum(Integer wrongAnswerNum) {
		this.wrongAnswerNum = wrongAnswerNum;
	}


	public DateTime getTakepartTime() {
		return takepartTime;
	}


	public void setTakepartTime(DateTime takepartTime) {
		this.takepartTime = takepartTime;
	}
	
	
	
}

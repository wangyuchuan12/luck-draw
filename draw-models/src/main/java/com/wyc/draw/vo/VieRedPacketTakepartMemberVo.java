package com.wyc.draw.vo;

import java.math.BigDecimal;

import javax.persistence.Column;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;

@ParamEntityAnnotation
public class VieRedPacketTakepartMemberVo {
	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	private String opendid;
	
	//红包用户id
	@ParamAnnotation
	private String drawUserId;
	
	//别呢
	@ParamAnnotation
	private String nickname;
	
	//头像
	@ParamAnnotation
	private String headImg;
	
	//用户id
	@ParamAnnotation
	private String userId;
	
	//总用时
	@ParamAnnotation
	private Float timeLong;
	
	//正确答题数量
	@ParamAnnotation
	private Long rightCount;
	
	//错误答题数量
	@ParamAnnotation
	private Long wrongCount;

	//红包id
	@ParamAnnotation
	private String redPacketId;
	
	//是否是所有参与者当中的最高分
	@ParamAnnotation
	private int isBest;
	
	//是否已交参与费
	@ParamAnnotation
	private Integer isPay;
	
	//是否答题完成
	@ParamAnnotation
	private Integer isComplete;
	
	
	//当前正在答得题目
	@ParamAnnotation
	private String currentProblemId;
	
	
	//参赛状态
	@ParamAnnotation
	private Integer takepartStatus;
	
	@Column(name="get_amount")
	private BigDecimal getAmount;
	
	@ParamAnnotation
	private Long rank;

	@ParamAnnotation
	private String takepartDateTime;

	public String getId() {
		return id;
	}


	public BigDecimal getGetAmount() {
		return getAmount;
	}

	
	

	public String getTakepartDateTime() {
		return takepartDateTime;
	}


	public void setTakepartDateTime(String takepartDateTime) {
		this.takepartDateTime = takepartDateTime;
	}


	public void setGetAmount(BigDecimal getAmount) {
		this.getAmount = getAmount;
	}


	public void setId(String id) {
		this.id = id;
	}


	
	public Integer getTakepartStatus() {
		return takepartStatus;
	}


	public void setTakepartStatus(Integer takepartStatus) {
		this.takepartStatus = takepartStatus;
	}


	public String getOpendid() {
		return opendid;
	}


	public void setOpendid(String opendid) {
		this.opendid = opendid;
	}


	public String getDrawUserId() {
		return drawUserId;
	}


	public void setDrawUserId(String drawUserId) {
		this.drawUserId = drawUserId;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getHeadImg() {
		return headImg;
	}


	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public Float getTimeLong() {
		return timeLong;
	}


	public void setTimeLong(Float timeLong) {
		this.timeLong = timeLong;
	}


	public Long getRightCount() {
		return rightCount;
	}


	public void setRightCount(Long rightCount) {
		this.rightCount = rightCount;
	}


	public Long getWrongCount() {
		return wrongCount;
	}


	public void setWrongCount(Long wrongCount) {
		this.wrongCount = wrongCount;
	}


	public String getRedPacketId() {
		return redPacketId;
	}


	public void setRedPacketId(String redPacketId) {
		this.redPacketId = redPacketId;
	}


	public int getIsBest() {
		return isBest;
	}


	public void setIsBest(int isBest) {
		this.isBest = isBest;
	}


	public Integer getIsPay() {
		return isPay;
	}


	public void setIsPay(Integer isPay) {
		this.isPay = isPay;
	}


	public Integer getIsComplete() {
		return isComplete;
	}


	public void setIsComplete(Integer isComplete) {
		this.isComplete = isComplete;
	}


	public String getCurrentProblemId() {
		return currentProblemId;
	}


	public void setCurrentProblemId(String currentProblemId) {
		this.currentProblemId = currentProblemId;
	}


	public Long getRank() {
		return rank;
	}


	public void setRank(Long rank) {
		this.rank = rank;
	}
	
	
	
}

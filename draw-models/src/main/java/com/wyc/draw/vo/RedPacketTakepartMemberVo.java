package com.wyc.draw.vo;

import java.math.BigDecimal;
import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;

@ParamEntityAnnotation
public class RedPacketTakepartMemberVo {
	
	@IdAnnotation
    private String id;
	
	@ParamAnnotation
	private String adminId;
	
	//userid
	@ParamAnnotation
	private String userId;
	
	@ParamAnnotation
	private String openid;
	
	@ParamAnnotation
	private String drawUserId;
	
	//参加时间
	@ParamAnnotation
	private String takepartDateTime;
	
	//是否领取成功
	@ParamAnnotation
	private int isSuccess;
	
	//提交答案
	@ParamAnnotation
	private String answer;
	
	
	//参与类型
	@ParamAnnotation
	private int type;
	
	//房间参与者id 只有是房间红包的时候此字段不为空
	@ParamAnnotation
	private String roomMemberId;
	
	//获得金额
	@ParamAnnotation
	private BigDecimal getAmount;
	
	
	//红包id
	@ParamAnnotation
	private String redPacketId;

	
	@ParamAnnotation
	private String nickname;
	
	@ParamAnnotation
	private String headImg;

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
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


	public String getAdminId() {
		return adminId;
	}


	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getOpenid() {
		return openid;
	}


	public void setOpenid(String openid) {
		this.openid = openid;
	}


	public String getDrawUserId() {
		return drawUserId;
	}


	public void setDrawUserId(String drawUserId) {
		this.drawUserId = drawUserId;
	}


	


	public String getTakepartDateTime() {
		return takepartDateTime;
	}


	public void setTakepartDateTime(String takepartDateTime) {
		this.takepartDateTime = takepartDateTime;
	}


	public int getIsSuccess() {
		return isSuccess;
	}


	public void setIsSuccess(int isSuccess) {
		this.isSuccess = isSuccess;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public String getRoomMemberId() {
		return roomMemberId;
	}


	public void setRoomMemberId(String roomMemberId) {
		this.roomMemberId = roomMemberId;
	}


	public BigDecimal getGetAmount() {
		return getAmount;
	}


	public void setGetAmount(BigDecimal getAmount) {
		this.getAmount = getAmount;
	}


	public String getRedPacketId() {
		return redPacketId;
	}


	public void setRedPacketId(String redPacketId) {
		this.redPacketId = redPacketId;
	}
	
	
	
}

package com.wyc.draw.vo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;

@ParamEntityAnnotation
public class DrawRoomInfoVo {
	
	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	private String name;
	
	@ParamAnnotation
	private String imgUrl;
	
	@ParamAnnotation
	private String createName;
	
	@ParamAnnotation
	private Integer maxNum;
	
	@ParamAnnotation
	private Integer memberCount;
	
	@ParamAnnotation
	private DrawRoomMemberVo createMember;
	
	@ParamAnnotation
	private List<DrawRoomMemberVo> drawRoomMembers;
	
	@ParamAnnotation
	private List<RedPacketVo> redPacketVo;
	
	@ParamAnnotation
	private Integer isInRoom;

	@ParamAnnotation
	private Integer verifyType;
	
	@ParamAnnotation
	private String verifyQuestion;
	
	//创建者别呢
	@ParamAnnotation
	private String createrNickname;
	
	//创建者头像
	@ParamAnnotation
	private String createrHeadImg;
	
	//该房间最大红包金额
	@Column(name="max_red_packet_amount")
	private BigDecimal maxRedPacketAmount;
	
	public String getCreaterNickname() {
		return createrNickname;
	}

	public void setCreaterNickname(String createrNickname) {
		this.createrNickname = createrNickname;
	}
	
	

	public BigDecimal getMaxRedPacketAmount() {
		return maxRedPacketAmount;
	}

	public void setMaxRedPacketAmount(BigDecimal maxRedPacketAmount) {
		this.maxRedPacketAmount = maxRedPacketAmount;
	}

	public String getCreaterHeadImg() {
		return createrHeadImg;
	}

	public void setCreaterHeadImg(String createrHeadImg) {
		this.createrHeadImg = createrHeadImg;
	}

	public Integer getIsInRoom() {
		return isInRoom;
	}

	public void setIsInRoom(Integer isInRoom) {
		this.isInRoom = isInRoom;
	}
	
	public Integer getVerifyType() {
		return verifyType;
	}

	public void setVerifyType(Integer verifyType) {
		this.verifyType = verifyType;
	}

	public String getVerifyQuestion() {
		return verifyQuestion;
	}

	public void setVerifyQuestion(String verifyQuestion) {
		this.verifyQuestion = verifyQuestion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public Integer getMaxNum() {
		return maxNum;
	}

	public void setMaxNum(Integer maxNum) {
		this.maxNum = maxNum;
	}

	public Integer getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(Integer memberCount) {
		this.memberCount = memberCount;
	}

	public DrawRoomMemberVo getCreateMember() {
		return createMember;
	}

	public void setCreateMember(DrawRoomMemberVo createMember) {
		this.createMember = createMember;
	}

	public List<DrawRoomMemberVo> getDrawRoomMembers() {
		return drawRoomMembers;
	}

	public void setDrawRoomMembers(List<DrawRoomMemberVo> drawRoomMembers) {
		this.drawRoomMembers = drawRoomMembers;
	}

	public List<RedPacketVo> getRedPacketVo() {
		return redPacketVo;
	}

	public void setRedPacketVo(List<RedPacketVo> redPacketVo) {
		this.redPacketVo = redPacketVo;
	}
	
	
	
}

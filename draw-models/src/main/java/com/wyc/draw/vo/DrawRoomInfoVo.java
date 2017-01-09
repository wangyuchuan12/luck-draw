package com.wyc.draw.vo;

import java.util.List;

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

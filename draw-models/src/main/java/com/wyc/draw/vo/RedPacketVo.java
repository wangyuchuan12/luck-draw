package com.wyc.draw.vo;

import org.joda.time.DateTime;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;

@ParamEntityAnnotation
public class RedPacketVo {

	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	private String handOpenid;
	
	@ParamAnnotation
	private String drawRoomId;
	
	@ParamAnnotation
	private String handAdminId;
	
	@ParamAnnotation
	private String handDrawUserId;
	
	@ParamAnnotation
	private String handRoomMemberId;
	
	@ParamAnnotation
	private String handUserId;
	
	@ParamAnnotation
	private Integer type;
	
	@ParamAnnotation
	private DateTime handTime;

	
	
	
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

	public String getHandOpenid() {
		return handOpenid;
	}

	public void setHandOpenid(String handOpenid) {
		this.handOpenid = handOpenid;
	}

	public String getDrawRoomId() {
		return drawRoomId;
	}

	public void setDrawRoomId(String drawRoomId) {
		this.drawRoomId = drawRoomId;
	}

	public String getHandAdminId() {
		return handAdminId;
	}

	public void setHandAdminId(String handAdminId) {
		this.handAdminId = handAdminId;
	}

	public String getHandRoomMemberId() {
		return handRoomMemberId;
	}

	public void setHandRoomMemberId(String handRoomMemberId) {
		this.handRoomMemberId = handRoomMemberId;
	}

	public String getHandUserId() {
		return handUserId;
	}

	public void setHandUserId(String handUserId) {
		this.handUserId = handUserId;
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
	
	
}

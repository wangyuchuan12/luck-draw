package com.wyc.draw.vo;

import java.util.List;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;

@ParamEntityAnnotation
public class DrawRoomMemberListVo {
	
	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	private List<DrawRoomMemberVo> drawRoomMembers;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<DrawRoomMemberVo> getDrawRoomMembers() {
		return drawRoomMembers;
	}

	public void setDrawRoomMembers(List<DrawRoomMemberVo> drawRoomMembers) {
		this.drawRoomMembers = drawRoomMembers;
	}
	
	
	
}

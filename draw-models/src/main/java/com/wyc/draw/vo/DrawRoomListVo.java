package com.wyc.draw.vo;

import java.util.List;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;


@ParamEntityAnnotation
public class DrawRoomListVo {
	
	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	private List<DrawRoomInfoVo> drawRoomInfos;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<DrawRoomInfoVo> getDrawRoomInfos() {
		return drawRoomInfos;
	}

	public void setDrawRoomInfos(List<DrawRoomInfoVo> drawRoomInfos) {
		this.drawRoomInfos = drawRoomInfos;
	}
	
	
	
}

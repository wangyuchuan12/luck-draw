package com.wyc.draw.domain.param;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;

@ParamEntityAnnotation
public class VieDrawInfoParam {

	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	private String redPacketId;
	
	
	@ParamAnnotation
	private int takepartMemberPage;
	
	@ParamAnnotation
	private int takepartMemberSize;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRedPacketId() {
		return redPacketId;
	}

	public void setRedPacketId(String redPacketId) {
		this.redPacketId = redPacketId;
	}

	public int getTakepartMemberPage() {
		return takepartMemberPage;
	}

	public void setTakepartMemberPage(int takepartMemberPage) {
		this.takepartMemberPage = takepartMemberPage;
	}

	public int getTakepartMemberSize() {
		return takepartMemberSize;
	}

	public void setTakepartMemberSize(int takepartMemberSize) {
		this.takepartMemberSize = takepartMemberSize;
	}
	
	
}

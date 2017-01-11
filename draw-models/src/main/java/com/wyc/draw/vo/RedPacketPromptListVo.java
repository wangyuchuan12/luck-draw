package com.wyc.draw.vo;

import java.util.List;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;

@ParamEntityAnnotation
public class RedPacketPromptListVo {
	
	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	private List<RedPacketPromptVo> redPacketPrompts;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<RedPacketPromptVo> getRedPacketPrompts() {
		return redPacketPrompts;
	}

	public void setRedPacketPrompts(List<RedPacketPromptVo> redPacketPrompts) {
		this.redPacketPrompts = redPacketPrompts;
	}
	
	
	
}

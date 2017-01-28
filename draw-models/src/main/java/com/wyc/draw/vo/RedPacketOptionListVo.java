package com.wyc.draw.vo;

import java.util.List;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;
import com.wyc.draw.domain.RedPacketOption;

@ParamEntityAnnotation
public class RedPacketOptionListVo {

	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	private List<RedPacketOption> redPacketOptions;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<RedPacketOption> getRedPacketOptions() {
		return redPacketOptions;
	}

	public void setRedPacketOptions(List<RedPacketOption> redPacketOptions) {
		this.redPacketOptions = redPacketOptions;
	}

	
	
	
}

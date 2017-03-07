package com.wyc.draw.vo;

import java.util.List;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;
import com.wyc.draw.domain.RedPacketComent;


@ParamEntityAnnotation
public class RedPacketComentListVo {

	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	private List<RedPacketComent> coments;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<RedPacketComent> getComents() {
		return coments;
	}

	public void setComents(List<RedPacketComent> coments) {
		this.coments = coments;
	}
	
	
	
}

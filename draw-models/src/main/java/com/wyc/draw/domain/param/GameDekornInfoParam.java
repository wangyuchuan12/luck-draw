package com.wyc.draw.domain.param;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;

@ParamEntityAnnotation
public class GameDekornInfoParam {

	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	private String dekornId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDekornId() {
		return dekornId;
	}

	public void setDekornId(String dekornId) {
		this.dekornId = dekornId;
	}
}

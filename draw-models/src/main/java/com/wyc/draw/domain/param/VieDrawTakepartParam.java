package com.wyc.draw.domain.param;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;

@ParamEntityAnnotation
public class VieDrawTakepartParam {

	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	private String takepartId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTakepartId() {
		return takepartId;
	}

	public void setTakepartId(String takepartId) {
		this.takepartId = takepartId;
	}
	
	
	
}

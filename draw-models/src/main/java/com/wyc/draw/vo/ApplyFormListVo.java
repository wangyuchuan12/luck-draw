package com.wyc.draw.vo;

import java.util.List;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;
import com.wyc.common.domain.ApplyForm;


@ParamEntityAnnotation
public class ApplyFormListVo {
	
	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	private List<ApplyForm> applyForms;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<ApplyForm> getApplyForms() {
		return applyForms;
	}

	public void setApplyForms(List<ApplyForm> applyForms) {
		this.applyForms = applyForms;
	}
	
	
	
}

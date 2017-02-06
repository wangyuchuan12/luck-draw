package com.wyc.draw.vo;

import java.util.List;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;

@ParamEntityAnnotation
public class SubjectListVo {

	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	private List<SubjectVo> mainSubjectVos;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<SubjectVo> getMainSubjectVos() {
		return mainSubjectVos;
	}

	public void setMainSubjectVos(List<SubjectVo> mainSubjectVos) {
		this.mainSubjectVos = mainSubjectVos;
	}
	
	
}

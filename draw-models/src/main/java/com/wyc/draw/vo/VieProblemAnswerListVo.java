package com.wyc.draw.vo;

import java.util.List;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;

@ParamEntityAnnotation
public class VieProblemAnswerListVo {
	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	private List<VieProblemAnswerVo> vieProblemAnswerVos;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<VieProblemAnswerVo> getVieProblemAnswerVos() {
		return vieProblemAnswerVos;
	}

	public void setVieProblemAnswerVos(List<VieProblemAnswerVo> vieProblemAnswerVos) {
		this.vieProblemAnswerVos = vieProblemAnswerVos;
	}
	
	
	
}

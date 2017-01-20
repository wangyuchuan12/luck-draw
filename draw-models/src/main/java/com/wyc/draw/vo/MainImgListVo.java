package com.wyc.draw.vo;

import java.util.List;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;
import com.wyc.draw.domain.view.MainImg;

@ParamEntityAnnotation
public class MainImgListVo {

	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	private List<MainImg> mainImgs;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<MainImg> getMainImgs() {
		return mainImgs;
	}

	public void setMainImgs(List<MainImg> mainImgs) {
		this.mainImgs = mainImgs;
	}
	
	
}

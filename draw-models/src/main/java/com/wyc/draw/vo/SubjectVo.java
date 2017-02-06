package com.wyc.draw.vo;

import java.util.List;

import javax.persistence.Column;


import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;

@ParamEntityAnnotation
public class SubjectVo {
	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	private String name;
	
	@ParamAnnotation
	private Integer isMain;
	
	@ParamAnnotation
	private Integer isDisplay;
	
	@ParamAnnotation
	private String parentId;
	
	@ParamAnnotation
	private String color;
	
	//他的子节点
	@ParamAnnotation
	private List<SubjectVo> children;
	
	//是否是节点终端
	@ParamAnnotation
	private Integer isLeaf;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIsMain() {
		return isMain;
	}

	public void setIsMain(Integer isMain) {
		this.isMain = isMain;
	}

	public Integer getIsDisplay() {
		return isDisplay;
	}

	public void setIsDisplay(Integer isDisplay) {
		this.isDisplay = isDisplay;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public List<SubjectVo> getChildren() {
		return children;
	}

	public void setChildren(List<SubjectVo> children) {
		this.children = children;
	}

	public Integer getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(Integer isLeaf) {
		this.isLeaf = isLeaf;
	}
	
	
}

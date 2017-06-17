package com.wyc.draw.vo;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;

@ParamEntityAnnotation
public class BattleIndexVo {
	@IdAnnotation
	private String id;
	@ParamAnnotation
	private Integer index;
	@ParamAnnotation
	private Integer score;
	@ParamAnnotation
	private Integer rewardBeanNum;
	@ParamAnnotation
	private Integer isRight;
	@ParamAnnotation
	private Integer status;
	@ParamAnnotation
	private String iconUrl;
	@ParamAnnotation
	private Integer toHide;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getRewardBeanNum() {
		return rewardBeanNum;
	}
	public void setRewardBeanNum(Integer rewardBeanNum) {
		this.rewardBeanNum = rewardBeanNum;
	}
	public Integer getIsRight() {
		return isRight;
	}
	public void setIsRight(Integer isRight) {
		this.isRight = isRight;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getIconUrl() {
		return iconUrl;
	}
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}
	public Integer getToHide() {
		return toHide;
	}
	public void setToHide(Integer toHide) {
		this.toHide = toHide;
	}
}

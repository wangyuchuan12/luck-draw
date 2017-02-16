package com.wyc.draw.vo;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;

@ParamEntityAnnotation
public class OptionSelectVo {
	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	private String takepartMemberId;
	
	@ParamAnnotation
	private Integer isRight;
	
	@ParamAnnotation
	private Integer isFirst;
	
	@ParamAnnotation
	private Integer isLast;
	
	@ParamAnnotation
	private Integer seq;

	@ParamAnnotation
	private Integer isTimeout;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public Integer getIsTimeout() {
		return isTimeout;
	}

	public void setIsTimeout(Integer isTimeout) {
		this.isTimeout = isTimeout;
	}

	public String getTakepartMemberId() {
		return takepartMemberId;
	}

	public void setTakepartMemberId(String takepartMemberId) {
		this.takepartMemberId = takepartMemberId;
	}

	public Integer getIsRight() {
		return isRight;
	}

	public void setIsRight(Integer isRight) {
		this.isRight = isRight;
	}

	public Integer getIsFirst() {
		return isFirst;
	}

	public void setIsFirst(Integer isFirst) {
		this.isFirst = isFirst;
	}

	public Integer getIsLast() {
		return isLast;
	}

	public void setIsLast(Integer isLast) {
		this.isLast = isLast;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	
	
}

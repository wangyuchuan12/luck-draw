package com.wyc.draw.domain.param;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;

@ParamEntityAnnotation
public class VieSelectOptionParam {
	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	private String optionId;
	
	@ParamAnnotation
	private String problemId;
	
	@ParamAnnotation
	private String memberId;
	
	@ParamAnnotation
	private String isTimeout;
	
	@ParamAnnotation
	private String timeLong;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOptionId() {
		return optionId;
	}

	public void setOptionId(String optionId) {
		this.optionId = optionId;
	}

	public String getProblemId() {
		return problemId;
	}

	public void setProblemId(String problemId) {
		this.problemId = problemId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getIsTimeout() {
		return isTimeout;
	}

	public void setIsTimeout(String isTimeout) {
		this.isTimeout = isTimeout;
	}

	public String getTimeLong() {
		return timeLong;
	}

	public void setTimeLong(String timeLong) {
		this.timeLong = timeLong;
	}
	
	
}

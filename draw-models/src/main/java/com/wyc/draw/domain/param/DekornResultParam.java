package com.wyc.draw.domain.param;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;

@ParamEntityAnnotation
public class DekornResultParam {

	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	private String takepartMemberId;
	
	@ParamAnnotation
	private String dekornId;
	
	@ParamAnnotation
	private Long score;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public String getTakepartMemberId() {
		return takepartMemberId;
	}

	public void setTakepartMemberId(String takepartMemberId) {
		this.takepartMemberId = takepartMemberId;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public String getDekornId() {
		return dekornId;
	}

	public void setDekornId(String dekornId) {
		this.dekornId = dekornId;
	}
	
	
}

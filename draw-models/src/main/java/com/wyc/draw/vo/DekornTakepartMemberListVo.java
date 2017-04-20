package com.wyc.draw.vo;

import java.util.List;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;
import com.wyc.draw.domain.DekornTakepartMember;


@ParamEntityAnnotation
public class DekornTakepartMemberListVo {
	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	private List<DekornTakepartMember> dekornTakepartMembers;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<DekornTakepartMember> getDekornTakepartMembers() {
		return dekornTakepartMembers;
	}

	public void setDekornTakepartMembers(List<DekornTakepartMember> dekornTakepartMembers) {
		this.dekornTakepartMembers = dekornTakepartMembers;
	}
	
	
	
}

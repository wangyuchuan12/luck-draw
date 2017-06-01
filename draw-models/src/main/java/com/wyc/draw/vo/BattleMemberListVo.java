package com.wyc.draw.vo;

import java.util.List;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;
import com.wyc.draw.domain.BattleMember;

@ParamEntityAnnotation
public class BattleMemberListVo {
	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	private List<BattleMember> battleMembers;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<BattleMember> getBattleMembers() {
		return battleMembers;
	}

	public void setBattleMembers(List<BattleMember> battleMembers) {
		this.battleMembers = battleMembers;
	}
	
	
}

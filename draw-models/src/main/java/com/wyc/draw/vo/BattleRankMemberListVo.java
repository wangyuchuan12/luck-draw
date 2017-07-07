package com.wyc.draw.vo;

import java.util.List;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;
import com.wyc.draw.domain.BattleRankMember;

@ParamEntityAnnotation
public class BattleRankMemberListVo {
	
	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	private List<BattleRankMember> battleRankMembers;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<BattleRankMember> getBattleRankMembers() {
		return battleRankMembers;
	}

	public void setBattleRankMembers(List<BattleRankMember> battleRankMembers) {
		this.battleRankMembers = battleRankMembers;
	}
}

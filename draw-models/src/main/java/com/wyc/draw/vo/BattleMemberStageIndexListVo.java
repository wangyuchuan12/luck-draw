package com.wyc.draw.vo;

import java.util.List;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;
import com.wyc.draw.domain.BattleMemberIndex;

@ParamEntityAnnotation
public class BattleMemberStageIndexListVo {
	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	private List<BattleMemberIndex> battleMemberIndexs;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<BattleMemberIndex> getBattleMemberIndexs() {
		return battleMemberIndexs;
	}

	public void setBattleMemberIndexs(List<BattleMemberIndex> battleMemberIndexs) {
		this.battleMemberIndexs = battleMemberIndexs;
	}
}

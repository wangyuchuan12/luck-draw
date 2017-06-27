package com.wyc.draw.vo;

import java.util.List;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;
import com.wyc.draw.domain.BattleMemberStage;

@ParamEntityAnnotation
public class BattleMemberStageListVo {

	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	private List<BattleMemberStage> battleMemberStages;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<BattleMemberStage> getBattleMemberStages() {
		return battleMemberStages;
	}

	public void setBattleMemberStages(List<BattleMemberStage> battleMemberStages) {
		this.battleMemberStages = battleMemberStages;
	}
}

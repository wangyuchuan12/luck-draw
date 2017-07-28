package com.wyc.draw.vo;

import java.util.List;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;
import com.wyc.draw.domain.BattleReward;

@ParamEntityAnnotation
public class BattleRewardListVo {

	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	private List<BattleReward> battleRewardList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<BattleReward> getBattleRewardList() {
		return battleRewardList;
	}

	public void setBattleRewardList(List<BattleReward> battleRewardList) {
		this.battleRewardList = battleRewardList;
	}
}

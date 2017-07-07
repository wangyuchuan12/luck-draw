package com.wyc.draw.vo;

import java.util.List;
import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;
import com.wyc.draw.domain.BattleRank;

@ParamEntityAnnotation
public class BattleRankListVo {
	
	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	private List<BattleRank> battleRanks;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<BattleRank> getBattleRanks() {
		return battleRanks;
	}

	public void setBattleRanks(List<BattleRank> battleRanks) {
		this.battleRanks = battleRanks;
	}
}

package com.wyc.draw.vo;

import java.util.List;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;

@ParamEntityAnnotation
public class BattleProgressInfoVo {
	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	private Integer status;
	
	@ParamAnnotation
	private Integer score;
	
	@ParamAnnotation
	private Integer loveLife;
	
	@ParamAnnotation
	private Integer stageIndex;
	
	@ParamAnnotation
	private Integer loveLifeLimit;
	
	@ParamAnnotation
	private Integer stageIndexScore;
	
	@ParamAnnotation
	private Integer rank;
	
	@ParamAnnotation
	private List<BattleStageVo> battleStageVos;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getLoveLife() {
		return loveLife;
	}

	public void setLoveLife(Integer loveLife) {
		this.loveLife = loveLife;
	}

	public Integer getStageIndex() {
		return stageIndex;
	}

	public void setStageIndex(Integer stageIndex) {
		this.stageIndex = stageIndex;
	}

	public Integer getStageIndexScore() {
		return stageIndexScore;
	}

	public void setStageIndexScore(Integer stageIndexScore) {
		this.stageIndexScore = stageIndexScore;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Integer getLoveLifeLimit() {
		return loveLifeLimit;
	}

	public void setLoveLifeLimit(Integer loveLifeLimit) {
		this.loveLifeLimit = loveLifeLimit;
	}

	public List<BattleStageVo> getBattleStageVos() {
		return battleStageVos;
	}

	public void setBattleStageVos(List<BattleStageVo> battleStageVos) {
		this.battleStageVos = battleStageVos;
	}

}

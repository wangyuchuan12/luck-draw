package com.wyc.draw.vo;

import java.util.List;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;

@ParamEntityAnnotation
public class BattleStageVo {
	@IdAnnotation
	private String id;
	
	//该阶段总分
	@ParamAnnotation
	private Integer score;
	
	//我所得的分数
	@ParamAnnotation
	private Integer myScore;
	
	@ParamAnnotation
	private String battleId;
	
	@ParamAnnotation
	private String paperId;
	
	@ParamAnnotation
	private Integer stageIndex;
	
	@ParamAnnotation
	private String currentIndex;
	
	@ParamAnnotation
	private Integer status;
	
	@ParamAnnotation
	private List<BattleIndexVo> battleIndexVos;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getMyScore() {
		return myScore;
	}

	public void setMyScore(Integer myScore) {
		this.myScore = myScore;
	}

	public String getBattleId() {
		return battleId;
	}

	public void setBattleId(String battleId) {
		this.battleId = battleId;
	}

	public String getPaperId() {
		return paperId;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}

	public Integer getStageIndex() {
		return stageIndex;
	}

	public void setStageIndex(Integer stageIndex) {
		this.stageIndex = stageIndex;
	}

	public String getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(String currentIndex) {
		this.currentIndex = currentIndex;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<BattleIndexVo> getBattleIndexVos() {
		return battleIndexVos;
	}

	public void setBattleIndexVos(List<BattleIndexVo> battleIndexVos) {
		this.battleIndexVos = battleIndexVos;
	}
}

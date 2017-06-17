package com.wyc.draw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;

@ParamEntityAnnotation
@Entity
@Table(name="b_battle_stage_index_detail")
public class BattleStageIndexDetail {
	@Id
	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	@Column
	private Integer stageIndex;
	
	@ParamAnnotation
	@Column
	private Integer score;
	
	@ParamAnnotation
	@Column(name="reward_bean_num")
	private Integer rewardBeanNum;
	
	@ParamAnnotation
	@Column(name="icon_url")
	private String iconUrl;
	
	@ParamAnnotation
	@Column(name = "create_at")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonIgnore
    private DateTime createAt;
	
	@ParamAnnotation
    @Column(name = "update_at")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonIgnore
    private DateTime updateAt;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public Integer getStageIndex() {
		return stageIndex;
	}

	public void setStageIndex(Integer stageIndex) {
		this.stageIndex = stageIndex;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getRewardBeanNum() {
		return rewardBeanNum;
	}

	public void setRewardBeanNum(Integer rewardBeanNum) {
		this.rewardBeanNum = rewardBeanNum;
	}

	public DateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(DateTime createAt) {
		this.createAt = createAt;
	}

	public DateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(DateTime updateAt) {
		this.updateAt = updateAt;
	}
	
}

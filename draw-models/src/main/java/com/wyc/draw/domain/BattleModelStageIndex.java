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
@Table(name="b_battle_model_stage_index")
public class BattleModelStageIndex {
	@Id
	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	@Column(name="stage_index")
	private Integer stageindex;
	
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
	@Column(name="battle_model_id")
	private String battleModelId;
	
	@ParamAnnotation
	@Column(name="z_index")
	private Integer index;
	
	@ParamAnnotation
	@Column(name="is_del")
	private Integer isDel;
	
	@ParamAnnotation
	@Column(name="is_guide")
	private Integer isGuide;
	
	@ParamAnnotation
	@Column(name="question_id")
	private String questionId;
	
	@ParamAnnotation
	@Column(name="to_hide")
	private Integer toHide;
	
	@ParamAnnotation
	@Column(name="is_img")
	private Integer isImg;
	
	
	@ParamAnnotation
	@Column(name="img_url")
	private String imgUrl;
	
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

	public Integer getStageindex() {
		return stageindex;
	}

	public void setStageindex(Integer stageindex) {
		this.stageindex = stageindex;
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

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getBattleModelId() {
		return battleModelId;
	}

	public void setBattleModelId(String battleModelId) {
		this.battleModelId = battleModelId;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public Integer getIsGuide() {
		return isGuide;
	}

	public void setIsGuide(Integer isGuide) {
		this.isGuide = isGuide;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public Integer getToHide() {
		return toHide;
	}

	public void setToHide(Integer toHide) {
		this.toHide = toHide;
	}

	public Integer getIsImg() {
		return isImg;
	}

	public void setIsImg(Integer isImg) {
		this.isImg = isImg;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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

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


/**
 * 参赛成员
 * @author root
 *
 */
@ParamEntityAnnotation
@Entity
@Table(name="b_battle_member")
public class BattleMember {
	@Id
	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	@Column(name="battle_id")
	private String battleId;
	
	@ParamAnnotation
	@Column(name="head_img")
	private String headImg;
	
	@ParamAnnotation
	@Column
	private String nickname;
	
	@ParamAnnotation
	@Column(name="draw_user_id")
	private String drawUserId;
	
	@ParamAnnotation
	@Column
	private String imgs;
	
	//状态 0表示待开始 1表示进行中 2表示已完成 3表示异常结束
	@ParamAnnotation
	@Column
	private Integer status;
	
	//分数
	@ParamAnnotation
	@Column
	private Integer score;
	
	//阶段序号，表示第几阶段
	@ParamAnnotation
	@Column(name="current_stage_index")
	private Integer currentStageIndex;
	
	@ParamAnnotation
	@Column(name="current_stage_score")
	private Integer currentStageScore;
	
	//当前题目序号
	@ParamAnnotation
	@Column(name="current_index")
	private Integer currentIndex;
	
	//总阶段数量
	@ParamAnnotation
	@Column(name="stage_index_count")
	private Integer stageIndexCount;
	
	//总题目数量
	@ParamAnnotation
	@Column(name="index_count")
	private Integer indexCount;
	
	//剩余爱心数量
	@ParamAnnotation
	@Column(name="love_life")
	private Integer loveLife;
	
	
	//爱心总数
	@ParamAnnotation
	@Column(name="love_life_limit")
	private Integer loveLifeLimit;
	
	
	@ParamAnnotation
	@Column(name="reward_bean_num")
	private Integer rewardBeanNum;
	
	@ParamAnnotation
	@Column(name="takepart_time")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime takepartTime;
	
	
	@ParamAnnotation
	@Column(name="end_time")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime endTime;
	
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

	public String getBattleId() {
		return battleId;
	}

	public void setBattleId(String battleId) {
		this.battleId = battleId;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getDrawUserId() {
		return drawUserId;
	}

	public void setDrawUserId(String drawUserId) {
		this.drawUserId = drawUserId;
	}

	public Integer getRewardBeanNum() {
		return rewardBeanNum;
	}

	public void setRewardBeanNum(Integer rewardBeanNum) {
		this.rewardBeanNum = rewardBeanNum;
	}

	public Integer getLoveLife() {
		return loveLife;
	}

	public void setLoveLife(Integer loveLife) {
		this.loveLife = loveLife;
	}

	public String getImgs() {
		return imgs;
	}

	public void setImgs(String imgs) {
		this.imgs = imgs;
	}

	public DateTime getTakepartTime() {
		return takepartTime;
	}

	public void setTakepartTime(DateTime takepartTime) {
		this.takepartTime = takepartTime;
	}

	public DateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(DateTime endTime) {
		this.endTime = endTime;
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

	public Integer getCurrentStageIndex() {
		return currentStageIndex;
	}

	public void setCurrentStageIndex(Integer currentStageIndex) {
		this.currentStageIndex = currentStageIndex;
	}

	public Integer getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(Integer currentIndex) {
		this.currentIndex = currentIndex;
	}

	public Integer getStageIndexCount() {
		return stageIndexCount;
	}

	public void setStageIndexCount(Integer stageIndexCount) {
		this.stageIndexCount = stageIndexCount;
	}

	public Integer getIndexCount() {
		return indexCount;
	}

	public void setIndexCount(Integer indexCount) {
		this.indexCount = indexCount;
	}

	public Integer getLoveLifeLimit() {
		return loveLifeLimit;
	}

	public void setLoveLifeLimit(Integer loveLifeLimit) {
		this.loveLifeLimit = loveLifeLimit;
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

	public Integer getCurrentStageScore() {
		return currentStageScore;
	}

	public void setCurrentStageScore(Integer currentStageScore) {
		this.currentStageScore = currentStageScore;
	}
}

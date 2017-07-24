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
@Table(name="b_battle_member_stage")
public class BattleMemberStage {
	@Id
	@IdAnnotation
	private String id;
	
	//阶段序号 从0开始到13
	@ParamAnnotation
	@Column(name="stage_index")
	private Integer stageIndex;
	
	
	@ParamAnnotation
	@Column(name="battle_id")
	private String battleId;
	
	//当前题目序号
	@ParamAnnotation
	@Column(name="current_index")
	private Integer currentIndex;
	
	@ParamAnnotation
	@Column(name="reward_bean_num")
	private Integer rewardBeanNum;
	
	//状态 0表示未开始，1表示进行中 2表示已完成
	@ParamAnnotation
	@Column
	private Integer status;
	
	//分数
	@ParamAnnotation
	@Column
	private Integer score;
	
	//battleMemberId
	@ParamAnnotation
	@Column(name="member_id")
	private String memberId;
	
	//表示该阶段所在的序号
	@ParamAnnotation
	@Column(name="z_index")
	private Integer index;
	
	//该节点的图标
	@ParamAnnotation
	@Column(name="icon_url")
	private String iconUrl;
	
	//试卷id
	@ParamAnnotation
	@Column(name="paper_id")
	private String paperId;
	
	//消耗智慧豆数量
	@ParamAnnotation
	@Column(name="consume_bean")
	private Integer consumeBean;
	
	//开始时间
	@ParamAnnotation
	@Column(name="start_time")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime startTime;
	
	@ParamAnnotation
	@Column(name="is_win")
	private Integer isWin;
	
	//结束时间
	@ParamAnnotation
	@Column(name="end_time")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime endTime;
	
	//是否删除
	@ParamAnnotation
	@Column(name="is_del")
	private Integer isDel;
	
	@ParamAnnotation
	@Column(name="is_sync_index")
	private Integer isSyncIndex;
	
	@ParamAnnotation
	@Column(name="is_pass")
	private Integer isPass;
	
	
	//一颗星分数
	@ParamAnnotation
	@Column(name="pass_score")
	private Integer passScore;
	
	//阶段显示图片
	@ParamAnnotation
	@Column(name="img_url")
	private String imgUrl;
	
	//阶段名称
	@ParamAnnotation
	@Column
	private String name;
	
	//二颗星分数
	@ParamAnnotation
	@Column(name="pass_score2")
	private Integer passScore2;
	
	//三颗星分数
	@ParamAnnotation
	@Column(name="pass_score3")
	private Integer passScore3;
	
	//四颗星分数
	@ParamAnnotation
	@Column(name="pass_score4")
	private Integer passScore4;
	
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

	public Integer getIsSyncIndex() {
		return isSyncIndex;
	}

	public void setIsSyncIndex(Integer isSyncIndex) {
		this.isSyncIndex = isSyncIndex;
	}

	public Integer getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(Integer currentIndex) {
		this.currentIndex = currentIndex;
	}
	
	public String getBattleId() {
		return battleId;
	}

	public void setBattleId(String battleId) {
		this.battleId = battleId;
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

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public DateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(DateTime startTime) {
		this.startTime = startTime;
	}

	public DateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(DateTime endTime) {
		this.endTime = endTime;
	}
	
	public Integer getRewardBeanNum() {
		return rewardBeanNum;
	}

	public void setRewardBeanNum(Integer rewardBeanNum) {
		this.rewardBeanNum = rewardBeanNum;
	}

	public Integer getIsWin() {
		return isWin;
	}

	public void setIsWin(Integer isWin) {
		this.isWin = isWin;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}
	
	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getPaperId() {
		return paperId;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}

	public Integer getIsPass() {
		return isPass;
	}

	public void setIsPass(Integer isPass) {
		this.isPass = isPass;
	}

	public Integer getPassScore() {
		return passScore;
	}

	public void setPassScore(Integer passScore) {
		this.passScore = passScore;
	}

	public Integer getPassScore2() {
		return passScore2;
	}

	public void setPassScore2(Integer passScore2) {
		this.passScore2 = passScore2;
	}

	public Integer getPassScore3() {
		return passScore3;
	}

	public void setPassScore3(Integer passScore3) {
		this.passScore3 = passScore3;
	}

	public Integer getPassScore4() {
		return passScore4;
	}

	public void setPassScore4(Integer passScore4) {
		this.passScore4 = passScore4;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getConsumeBean() {
		return consumeBean;
	}

	public void setConsumeBean(Integer consumeBean) {
		this.consumeBean = consumeBean;
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

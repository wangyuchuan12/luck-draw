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
 * 比赛
 * @author root
 *
 */
@ParamEntityAnnotation
@Entity
@Table(name="b_battle")
public class Battle {
	@Id
	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	@Column(name="model_id")
	private String modelId;
	
	@ParamAnnotation
	@Column(name="paper_id")
	private String paperId;
	
	@ParamAnnotation
	@Column
	private Integer type;
	
	@ParamAnnotation
	@Column
	private String name;
	
	@ParamAnnotation
	@Column
	private String instruction;
	
	@ParamAnnotation
	@Column(name="img_url")
	private String imgUrl;
	
	@ParamAnnotation
	@Column
	private String title;
	
	@ParamAnnotation
	@Column(name="user_imgs")
	private String userImgs;
	
	//总参与人数
	@ParamAnnotation
	@Column(name="takepart_count")
	private Integer takepartCount;
	
	@ParamAnnotation
	@Column(name="subject_id")
	private String subjectId;
	
	//消耗爱心数量
	@ParamAnnotation
	@Column(name="love_life_consume")
	private Integer loveLifeConsume;
	
	//赋予爱心数量
	@ParamAnnotation
	@Column(name="love_life_give")
	private Integer loveLifeGive;
	
	//消耗豆子数量
	@ParamAnnotation
	@Column(name="bean_consume")
	private Integer beanConsume;
	

	@ParamAnnotation
	@Column
	private String code;
	
	//阶段数量
	@ParamAnnotation
	@Column(name="stage_count")
	private Integer stageCount;
	
	//节点数量
	@ParamAnnotation
	@Column(name="stage_index_count")
	private Integer stageIndexCount;
	
	//创建人，引用drawUserId
	@ParamAnnotation
	@Column(name="creater_draw_user_id")
	private String createrDrawUserId;
	
	//是否领取奖励
	@ParamAnnotation
	@Column(name="is_receive_reward")
	private Integer isReceiveReward;
	
	
	@ParamAnnotation
	@Column(name = "begin_date")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime beginDate;
	
	
	@ParamAnnotation
	@Column(name = "end_date")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime endDate;
	
	@ParamAnnotation
	@Column(name = "time_long")
	private Integer timeLong;
	
	
	//0游离状态 1正在进行中 2超时 3全部完成
	@ParamAnnotation
	@Column
	private Integer status;

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

	public Integer getStageCount() {
		return stageCount;
	}

	public void setStageCount(Integer stageCount) {
		this.stageCount = stageCount;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public String getPaperId() {
		return paperId;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public Integer getTakepartCount() {
		return takepartCount;
	}

	public void setTakepartCount(Integer takepartCount) {
		this.takepartCount = takepartCount;
	}

	
	
	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	
	
	public String getUserImgs() {
		return userImgs;
	}

	public void setUserImgs(String userImgs) {
		this.userImgs = userImgs;
	}
	
	public Integer getLoveLifeConsume() {
		return loveLifeConsume;
	}

	public void setLoveLifeConsume(Integer loveLifeConsume) {
		this.loveLifeConsume = loveLifeConsume;
	}

	public Integer getBeanConsume() {
		return beanConsume;
	}

	public void setBeanConsume(Integer beanConsume) {
		this.beanConsume = beanConsume;
	}
	
	

	public Integer getLoveLifeGive() {
		return loveLifeGive;
	}

	public void setLoveLifeGive(Integer loveLifeGive) {
		this.loveLifeGive = loveLifeGive;
	}
	
	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public String getCreaterDrawUserId() {
		return createrDrawUserId;
	}

	public void setCreaterDrawUserId(String createrDrawUserId) {
		this.createrDrawUserId = createrDrawUserId;
	}

	public Integer getStageIndexCount() {
		return stageIndexCount;
	}

	public void setStageIndexCount(Integer stageIndexCount) {
		this.stageIndexCount = stageIndexCount;
	}

	public DateTime getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(DateTime beginDate) {
		this.beginDate = beginDate;
	}

	public DateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}

	public Integer getTimeLong() {
		return timeLong;
	}

	public void setTimeLong(Integer timeLong) {
		this.timeLong = timeLong;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsReceiveReward() {
		return isReceiveReward;
	}

	public void setIsReceiveReward(Integer isReceiveReward) {
		this.isReceiveReward = isReceiveReward;
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

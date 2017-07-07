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
@Table(name="b_battle_model")
public class BattleModel {
	@Id
	@IdAnnotation
	private String id;
	
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
	
	//是否启用
	@ParamAnnotation
	@Column(name="is_enable")
	private Integer isEnable;
	
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

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
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

	public String getUserImgs() {
		return userImgs;
	}

	public void setUserImgs(String userImgs) {
		this.userImgs = userImgs;
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

	public Integer getLoveLifeConsume() {
		return loveLifeConsume;
	}

	public void setLoveLifeConsume(Integer loveLifeConsume) {
		this.loveLifeConsume = loveLifeConsume;
	}

	public Integer getLoveLifeGive() {
		return loveLifeGive;
	}

	public void setLoveLifeGive(Integer loveLifeGive) {
		this.loveLifeGive = loveLifeGive;
	}

	public Integer getBeanConsume() {
		return beanConsume;
	}

	public void setBeanConsume(Integer beanConsume) {
		this.beanConsume = beanConsume;
	}

	public Integer getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
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
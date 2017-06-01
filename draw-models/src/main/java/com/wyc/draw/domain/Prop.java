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

@Entity
@Table(name="m_prop")
@ParamEntityAnnotation
public class Prop {
	@Id
	@IdAnnotation
	private String id;
	
	@Column(name="draw_user_id")
	@ParamAnnotation
	private String drawUserId;
	
	@Column
	@ParamAnnotation
	private String openid;
	
	@Column(name="love_status")
	@ParamAnnotation
	private Integer loveStatus;
	
	@Column(name="bean_status")
	@ParamAnnotation
	private Integer beanStatus;
	
	@Column(name="phy_status")
	@ParamAnnotation
	private Integer phyStatus;
	
	@Column(name="random_status")
	@ParamAnnotation
	private Integer randomStatus;
	
	@Column(name="generate_love_count")
	@ParamAnnotation
	private Long generateLoveCount;
	
	@Column(name="generate_bean_count")
	@ParamAnnotation
	private Long generateBeanCount;
	
	@Column(name="generate_phy_count")
	@ParamAnnotation
	private Long generatePhyCount;
	
	@Column(name="generate_random_count")
	@ParamAnnotation
	private Long generateRandomCount;
	
	@Column(name = "create_at")
	@ParamAnnotation
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonIgnore
    private DateTime createAt;
	
    @Column(name = "update_at")
    @ParamAnnotation
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonIgnore
    private DateTime updateAt;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDrawUserId() {
		return drawUserId;
	}

	public void setDrawUserId(String drawUserId) {
		this.drawUserId = drawUserId;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public Integer getLoveStatus() {
		return loveStatus;
	}

	public void setLoveStatus(Integer loveStatus) {
		this.loveStatus = loveStatus;
	}

	

	public Integer getBeanStatus() {
		return beanStatus;
	}

	public void setBeanStatus(Integer beanStatus) {
		this.beanStatus = beanStatus;
	}

	public Integer getPhyStatus() {
		return phyStatus;
	}

	public void setPhyStatus(Integer phyStatus) {
		this.phyStatus = phyStatus;
	}

	public Integer getRandomStatus() {
		return randomStatus;
	}

	public void setRandomStatus(Integer randomStatus) {
		this.randomStatus = randomStatus;
	}

	public Long getGenerateLoveCount() {
		return generateLoveCount;
	}

	public void setGenerateLoveCount(Long generateLoveCount) {
		this.generateLoveCount = generateLoveCount;
	}

	public Long getGenerateBeanCount() {
		return generateBeanCount;
	}

	public void setGenerateBeanCount(Long generateBeanCount) {
		this.generateBeanCount = generateBeanCount;
	}

	public Long getGeneratePhyCount() {
		return generatePhyCount;
	}

	public void setGeneratePhyCount(Long generatePhyCount) {
		this.generatePhyCount = generatePhyCount;
	}

	public Long getGenerateRandomCount() {
		return generateRandomCount;
	}

	public void setGenerateRandomCount(Long generateRandomCount) {
		this.generateRandomCount = generateRandomCount;
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

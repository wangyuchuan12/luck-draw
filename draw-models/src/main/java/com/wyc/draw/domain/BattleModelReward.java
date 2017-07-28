package com.wyc.draw.domain;

import java.math.BigDecimal;

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
@Table(name="b_battle_model_reward")
public class BattleModelReward {
	@Id
	@IdAnnotation
	private String id;
	
	
	//第几名 0表示没有名次
	@ParamAnnotation
	@Column
	private Integer rank;
	
	//奖励智慧豆
	@ParamAnnotation
	@Column(name="reward_bean")
	private Integer rewardBean;
	
	//奖励爱心
	@ParamAnnotation
	@Column(name="reward_love")
	private Integer rewardLove;
	
	//奖励爱心
	@ParamAnnotation
	@Column(name="reward_money")
	private BigDecimal rewardMoney;
	
	//奖励砖石
	@ParamAnnotation
	@Column(name="reward_masonry")
	private BigDecimal rewardMasonry;
	
	@ParamAnnotation
	@Column(name="model_id")
	private String modelId;
	
	//状态 0表示未分配 1表示已分配未领取 2表示已领取
	@ParamAnnotation
	@Column
	private Integer status;
	
	//领取人
	@ParamAnnotation
	@Column(name="receive_member_id")
	private String receiveMemberId;
	
	//领取人别呢
	@ParamAnnotation
	@Column
	private String receiveNickname;
	
	//领取人头像
	@ParamAnnotation
	@Column(name="receive_head_img")
	private String receiveHeadImg;
	
	//领取时间
	@ParamAnnotation
	@Column(name="receive_datetime")
	private DateTime receiveDatetime;
	
	@ParamAnnotation
	@Column(name="is_del")
	private Integer isDel;
	
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

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Integer getRewardBean() {
		return rewardBean;
	}

	public void setRewardBean(Integer rewardBean) {
		this.rewardBean = rewardBean;
	}

	public Integer getRewardLove() {
		return rewardLove;
	}

	public void setRewardLove(Integer rewardLove) {
		this.rewardLove = rewardLove;
	}

	public BigDecimal getRewardMoney() {
		return rewardMoney;
	}

	public void setRewardMoney(BigDecimal rewardMoney) {
		this.rewardMoney = rewardMoney;
	}

	public BigDecimal getRewardMasonry() {
		return rewardMasonry;
	}

	public void setRewardMasonry(BigDecimal rewardMasonry) {
		this.rewardMasonry = rewardMasonry;
	}

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getReceiveMemberId() {
		return receiveMemberId;
	}

	public void setReceiveMemberId(String receiveMemberId) {
		this.receiveMemberId = receiveMemberId;
	}

	public String getReceiveNickname() {
		return receiveNickname;
	}

	public void setReceiveNickname(String receiveNickname) {
		this.receiveNickname = receiveNickname;
	}

	public String getReceiveHeadImg() {
		return receiveHeadImg;
	}

	public void setReceiveHeadImg(String receiveHeadImg) {
		this.receiveHeadImg = receiveHeadImg;
	}

	public DateTime getReceiveDatetime() {
		return receiveDatetime;
	}

	public void setReceiveDatetime(DateTime receiveDatetime) {
		this.receiveDatetime = receiveDatetime;
	}

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
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

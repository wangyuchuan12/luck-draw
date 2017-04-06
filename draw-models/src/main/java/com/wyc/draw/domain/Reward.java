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
@Table(name="v_reward")
public class Reward {
	@Id
	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	@Column(name="add_wisdom_num")
	private Long addWisdomNum;
	
	@ParamAnnotation
	@Column(name="sub_wisdom_num")
	private Long subWisdomNum;
	
	@ParamAnnotation
	@Column(name="add_integral_num")
	private Long addIntegralNum;
	
	@ParamAnnotation
	@Column(name="add_love_life_num")
	private Long addLoveLifeNum;
	
	@ParamAnnotation
	@Column(name="sub_love_life_num")
	private Long subLoveLifeNum;
	
	@ParamAnnotation
	@Column(name="add_amount")
	private BigDecimal addAmount;
	
	@ParamAnnotation
	@Column(name="sub_amount")
	private BigDecimal subAmount;
	
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

	public Long getAddWisdomNum() {
		return addWisdomNum;
	}

	public void setAddWisdomNum(Long addWisdomNum) {
		this.addWisdomNum = addWisdomNum;
	}

	public Long getSubWisdomNum() {
		return subWisdomNum;
	}

	public void setSubWisdomNum(Long subWisdomNum) {
		this.subWisdomNum = subWisdomNum;
	}

	public Long getAddIntegralNum() {
		return addIntegralNum;
	}

	public void setAddIntegralNum(Long addIntegralNum) {
		this.addIntegralNum = addIntegralNum;
	}

	public Long getAddLoveLifeNum() {
		return addLoveLifeNum;
	}

	public void setAddLoveLifeNum(Long addLoveLifeNum) {
		this.addLoveLifeNum = addLoveLifeNum;
	}

	public Long getSubLoveLifeNum() {
		return subLoveLifeNum;
	}

	public void setSubLoveLifeNum(Long subLoveLifeNum) {
		this.subLoveLifeNum = subLoveLifeNum;
	}

	public BigDecimal getAddAmount() {
		return addAmount;
	}

	public void setAddAmount(BigDecimal addAmount) {
		this.addAmount = addAmount;
	}

	public BigDecimal getSubAmount() {
		return subAmount;
	}

	public void setSubAmount(BigDecimal subAmount) {
		this.subAmount = subAmount;
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

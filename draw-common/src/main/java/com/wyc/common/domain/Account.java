package com.wyc.common.domain;

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

@Entity
@Table(name="p_account")
@ParamEntityAnnotation
public class Account {
	@Id
	@IdAnnotation
    private String id;
	
	@ParamAnnotation
	@Column
	private BigDecimal amount;
	
	
	//智慧豆数量
	@ParamAnnotation
	@Column(name="wisdom_count")
	private Long wisdomCount;
	
	//经验
	@ParamAnnotation
	@Column(name="empirical_value")
	private BigDecimal empiricalValue;
	
	
	//本月可提现次数
	@ParamAnnotation
	@Column(name="can_take_out_count")
	private Integer canTakeOutCount;
	
	
	//账户余额
	@ParamAnnotation
	@Column(name="amount_balance")
	private BigDecimal amountBalance;
	
	
	@Column(name = "create_at")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonIgnore
    private DateTime createAt;
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
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public Long getWisdomCount() {
		return wisdomCount;
	}
	public void setWisdomCount(Long wisdomCount) {
		this.wisdomCount = wisdomCount;
	}
	public BigDecimal getEmpiricalValue() {
		return empiricalValue;
	}
	public void setEmpiricalValue(BigDecimal empiricalValue) {
		this.empiricalValue = empiricalValue;
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
	public Integer getCanTakeOutCount() {
		return canTakeOutCount;
	}
	public void setCanTakeOutCount(Integer canTakeOutCount) {
		this.canTakeOutCount = canTakeOutCount;
	}
	public BigDecimal getAmountBalance() {
		return amountBalance;
	}
	public void setAmountBalance(BigDecimal amountBalance) {
		this.amountBalance = amountBalance;
	}
	
	
}

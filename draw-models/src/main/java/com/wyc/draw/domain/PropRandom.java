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

@Entity
@Table(name="m_prop_random")
@ParamEntityAnnotation
public class PropRandom {
	@Id
	@IdAnnotation
	private String id;
	
	@Column(name="prop_id")
	@ParamAnnotation
	private String propId;
	
	@ParamAnnotation
	@Column(name="start_datetime")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime startDatetime;
	
	@ParamAnnotation
	@Column(name="unit_name")
	private String unitName;
	
	@ParamAnnotation
	@Column
	private Integer unit;
	
	@ParamAnnotation
	@Column(name="upper_limit")
	private Long upperLimit;
	
	@ParamAnnotation
	@Column
	private Long millisec;
	
	@ParamAnnotation
	@Column(name="love_range_min")
	private Long loveRangeMin;
	
	@ParamAnnotation
	@Column(name="love_range_max")
	private Long loveRangeMax;
	
	@ParamAnnotation
	@Column(name="bean_range_min")
	private Long beanRangeMin;
	
	@ParamAnnotation
	@Column(name="bean_range_max")
	private Long beanRangeMax;
	
	@ParamAnnotation
	@Column(name="money_range_min")
	private BigDecimal moneyRangeMin;
	
	@ParamAnnotation
	@Column(name="money_range_max")
	private BigDecimal moneyRangeMax;
	
	@ParamAnnotation
	@Column
	private Long schedule;

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

	public String getPropId() {
		return propId;
	}

	public void setPropId(String propId) {
		this.propId = propId;
	}

	public DateTime getStartDatetime() {
		return startDatetime;
	}

	public void setStartDatetime(DateTime startDatetime) {
		this.startDatetime = startDatetime;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public Integer getUnit() {
		return unit;
	}

	public void setUnit(Integer unit) {
		this.unit = unit;
	}

	public Long getUpperLimit() {
		return upperLimit;
	}

	public void setUpperLimit(Long upperLimit) {
		this.upperLimit = upperLimit;
	}

	public Long getMillisec() {
		return millisec;
	}

	public void setMillisec(Long millisec) {
		this.millisec = millisec;
	}

	
	public Long getLoveRangeMin() {
		return loveRangeMin;
	}

	public void setLoveRangeMin(Long loveRangeMin) {
		this.loveRangeMin = loveRangeMin;
	}

	public Long getLoveRangeMax() {
		return loveRangeMax;
	}

	public void setLoveRangeMax(Long loveRangeMax) {
		this.loveRangeMax = loveRangeMax;
	}

	public Long getBeanRangeMin() {
		return beanRangeMin;
	}

	public void setBeanRangeMin(Long beanRangeMin) {
		this.beanRangeMin = beanRangeMin;
	}

	public Long getBeanRangeMax() {
		return beanRangeMax;
	}

	public void setBeanRangeMax(Long beanRangeMax) {
		this.beanRangeMax = beanRangeMax;
	}

	public BigDecimal getMoneyRangeMin() {
		return moneyRangeMin;
	}

	public void setMoneyRangeMin(BigDecimal moneyRangeMin) {
		this.moneyRangeMin = moneyRangeMin;
	}

	public BigDecimal getMoneyRangeMax() {
		return moneyRangeMax;
	}

	public void setMoneyRangeMax(BigDecimal moneyRangeMax) {
		this.moneyRangeMax = moneyRangeMax;
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

	public Long getSchedule() {
		return schedule;
	}

	public void setSchedule(Long schedule) {
		this.schedule = schedule;
	}
	
	
}

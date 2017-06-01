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
@Table(name="m_prop_love")
@ParamEntityAnnotation
public class PropLove {
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
	@Column(name="range_min")
	private Long rangeMin;
	
	@ParamAnnotation
	@Column(name="range_max")
	private Long rangeMax;
	
	//进度
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

	public Long getRangeMin() {
		return rangeMin;
	}

	public void setRangeMin(Long rangeMin) {
		this.rangeMin = rangeMin;
	}

	public Long getRangeMax() {
		return rangeMax;
	}

	public void setRangeMax(Long rangeMax) {
		this.rangeMax = rangeMax;
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

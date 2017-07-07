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
@Table(name="b_battle_rank")
public class BattleRank {
	@Id
	@IdAnnotation
	private String id;
	
	@Column(name="battle_id")
	@ParamAnnotation
	private String battleId;
	
	@Column
	@ParamAnnotation
	private Integer status;
	
	@Column(name="member_max")
	@ParamAnnotation
	private Integer memberMax;
	
	@Column(name="member_min")
	@ParamAnnotation
	private Integer memberMin;

	@Column(name="member_takepart_num")
	@ParamAnnotation
	private Integer memberTakepartNum;
	
	@Column(name="begin_date")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@ParamAnnotation
	private DateTime beginDate;
	
	@Column(name="end_date")
	 @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@ParamAnnotation
	private DateTime endDate;
	
	@Column(name="creater_member_id")
	@ParamAnnotation
	private String createrMemberId;
	
	@Column(name="index_count")
	@ParamAnnotation
	private Integer indexCount;
	
	@Column(name="stage_count")
	@ParamAnnotation
	private Integer stageCount;
	
	
	@Column
	@ParamAnnotation
	private Integer type;
	
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getMemberMax() {
		return memberMax;
	}

	public void setMemberMax(Integer memberMax) {
		this.memberMax = memberMax;
	}

	public Integer getMemberMin() {
		return memberMin;
	}

	public void setMemberMin(Integer memberMin) {
		this.memberMin = memberMin;
	}

	public Integer getMemberTakepartNum() {
		return memberTakepartNum;
	}

	public void setMemberTakepartNum(Integer memberTakepartNum) {
		this.memberTakepartNum = memberTakepartNum;
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

	public String getCreaterMemberId() {
		return createrMemberId;
	}

	public void setCreaterMemberId(String createrMemberId) {
		this.createrMemberId = createrMemberId;
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

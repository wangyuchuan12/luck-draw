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

@Entity
@Table(name="v_dekorn_to_takepart_member")
public class DekornToTakepartMember {
	@Id
	@IdAnnotation
	private String id;
	
	//挑战id
	@Column(name="dekorn_id")
	private String dekornId;

	//当前参与
	@ParamAnnotation
	@Column(name="current_takepart_member_id")
	private String currentTakepartMemberId;
	
	//参与次数
	@Column(name="takepart_count")
	private Long takepartCount;
	
	//参与成功次数
	@Column(name="takepart_success_count")
	private Long takepartSuccessCount;
	
	//参与失败次数
	@Column(name="takepart_fail_count")
	private Long takepartFailCount;
	
	//最高纪录
	@Column(name="highest_score")
	private Long highestScore;
		
	//平均成绩
	@Column(name="average_score")
	private Long averageScore;
	
	//剩余爱心个数
	@Column(name="love_life_count")
	private Long loveLifeCount;
	
	//获取智慧豆个数
	@Column(name="obtain_wisdom_num")
	private Long obtainWisdomNum;
	
	//获取经验数量
	@Column(name="obtain_integral_num")
	private Long obtainIntegralNum;
	
	//当前参与状态 0表示未参与 1正在参与 2参与结束 3中途退出
	@Column(name="takepart_status")
	@ParamAnnotation
	private Integer takepartStatus;
	
	//访问次数
	@ParamAnnotation
	@Column(name="visit_count")
	private Integer visitCount;
	
	
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

	public String getDekornId() {
		return dekornId;
	}

	public void setDekornId(String dekornId) {
		this.dekornId = dekornId;
	}

	public String getCurrentTakepartMemberId() {
		return currentTakepartMemberId;
	}

	public void setCurrentTakepartMemberId(String currentTakepartMemberId) {
		this.currentTakepartMemberId = currentTakepartMemberId;
	}

	public Long getTakepartCount() {
		return takepartCount;
	}

	public void setTakepartCount(Long takepartCount) {
		this.takepartCount = takepartCount;
	}

	public Long getTakepartSuccessCount() {
		return takepartSuccessCount;
	}

	public void setTakepartSuccessCount(Long takepartSuccessCount) {
		this.takepartSuccessCount = takepartSuccessCount;
	}

	public Long getTakepartFailCount() {
		return takepartFailCount;
	}

	public void setTakepartFailCount(Long takepartFailCount) {
		this.takepartFailCount = takepartFailCount;
	}

	public Long getHighestScore() {
		return highestScore;
	}

	public void setHighestScore(Long highestScore) {
		this.highestScore = highestScore;
	}

	public Long getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(Long averageScore) {
		this.averageScore = averageScore;
	}

	public Long getLoveLifeCount() {
		return loveLifeCount;
	}

	public void setLoveLifeCount(Long loveLifeCount) {
		this.loveLifeCount = loveLifeCount;
	}

	public Long getObtainWisdomNum() {
		return obtainWisdomNum;
	}

	public void setObtainWisdomNum(Long obtainWisdomNum) {
		this.obtainWisdomNum = obtainWisdomNum;
	}

	public Long getObtainIntegralNum() {
		return obtainIntegralNum;
	}

	public void setObtainIntegralNum(Long obtainIntegralNum) {
		this.obtainIntegralNum = obtainIntegralNum;
	}

	public Integer getTakepartStatus() {
		return takepartStatus;
	}

	public void setTakepartStatus(Integer takepartStatus) {
		this.takepartStatus = takepartStatus;
	}

	public Integer getVisitCount() {
		return visitCount;
	}

	public void setVisitCount(Integer visitCount) {
		this.visitCount = visitCount;
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

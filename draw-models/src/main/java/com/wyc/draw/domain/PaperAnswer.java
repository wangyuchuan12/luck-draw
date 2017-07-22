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
@Table(name="q_paper_answer")
@ParamEntityAnnotation
public class PaperAnswer {
	@Id
	@IdAnnotation
	private String id;
	
	@Column(name="paper_id")
	@ParamAnnotation
	private String paperId;
	
	@Column(name="key_id")
	@ParamAnnotation
	private String keyId;
	
	@Column(name="time_long")
	@ParamAnnotation
	private Integer timeLong;
	
	@Column(name="right_count")
	@ParamAnnotation
	private Integer rightCount;
	
	@Column(name="wrong_count")
	@ParamAnnotation
	private Integer wrongCount;
	
	@Column(name="score")
	@ParamAnnotation
	private Integer score;
	
	@Column
	private Integer status;
	
	//答题类型 0表示竞答红包答题  1表示闯关答题
	@Column
	@ParamAnnotation
	private Integer type;
	
	@Column(name="draw_user_id")
	@ParamAnnotation
	private String drawUserId;
	
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

	public String getPaperId() {
		return paperId;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}

	public Integer getTimeLong() {
		return timeLong;
	}

	public void setTimeLong(Integer timeLong) {
		this.timeLong = timeLong;
	}

	public Integer getRightCount() {
		return rightCount;
	}

	public void setRightCount(Integer rightCount) {
		this.rightCount = rightCount;
	}

	public Integer getWrongCount() {
		return wrongCount;
	}

	public void setWrongCount(Integer wrongCount) {
		this.wrongCount = wrongCount;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
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

	public String getKeyId() {
		return keyId;
	}

	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getDrawUserId() {
		return drawUserId;
	}

	public void setDrawUserId(String drawUserId) {
		this.drawUserId = drawUserId;
	}
}

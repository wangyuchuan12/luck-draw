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
@Table(name="q_question_answer")
@ParamEntityAnnotation
public class QuestionAnswer {

	@Id
	@IdAnnotation
	private String id;
	
	@Column(name="question_id")
	@ParamAnnotation
	private String questionId;
	
	@Column(name="key_id")
	@ParamAnnotation
	private String keyId;
	
	@Column(name="check_option_id")
	@ParamAnnotation
	private String checkOptionId;
	
	@Column(name="time_long")
	@ParamAnnotation
	private Float timeLong;
	
	@Column(name="is_right")
	@ParamAnnotation
	private Integer isRight;
	
	@Column
	@ParamAnnotation
	private String answer;
	
	@Column(name="right_answer")
	@ParamAnnotation
	private String rightAnswer;
	
	@Column(name="paper_id")
	@ParamAnnotation
	private String paperId;
	
	
	@Column(name="is_timeout")
	@ParamAnnotation
	private Integer isTimeout;
	
	@Column(name="score")
	@ParamAnnotation
	private Integer score;
	
	
	//状态 0答题中 1已完成 2异常退出
	@Column
	@ParamAnnotation
	private Integer status;
	
	//答题类型 0表示竞答红包答题  1表示闯关答题
	@Column
	@ParamAnnotation
	private Integer type;
	
	@Column(name="draw_user_id")
	@ParamAnnotation
	private String drawUserId;
	
	@Column(name="is_del")
	@ParamAnnotation
	private Integer isDel;
	
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

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getCheckOptionId() {
		return checkOptionId;
	}

	public void setCheckOptionId(String checkOptionId) {
		this.checkOptionId = checkOptionId;
	}

	public Float getTimeLong() {
		return timeLong;
	}

	public void setTimeLong(Float timeLong) {
		this.timeLong = timeLong;
	}

	public Integer getIsRight() {
		return isRight;
	}

	public void setIsRight(Integer isRight) {
		this.isRight = isRight;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}

	public String getPaperId() {
		return paperId;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
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

	public Integer getIsTimeout() {
		return isTimeout;
	}

	public void setIsTimeout(Integer isTimeout) {
		this.isTimeout = isTimeout;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
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

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public String getDrawUserId() {
		return drawUserId;
	}

	public void setDrawUserId(String drawUserId) {
		this.drawUserId = drawUserId;
	}
}

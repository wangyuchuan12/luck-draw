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
@Table(name="q_question")
@ParamEntityAnnotation
public class Question {
	@Id
	@IdAnnotation
	private String id;
	
	
	//0表示选择题，1表示填字体
	@Column
	@ParamAnnotation
	private Integer type;
	
	//图片地址
	@Column
	@ParamAnnotation
	private String imgUrl;
	
	@Column
	@ParamAnnotation
	private String question;
	
	
	//正确答案，填字的时候使用
	@Column
	@ParamAnnotation
	private String answer;
	
	//是否有图片
	@Column(name="is_img")
	@ParamAnnotation
	private Integer isImg;
	
	//正确选项
	@Column(name="right_option_id")
	@ParamAnnotation
	private String rightOptionId;
	
	//填充字列表，用逗号分隔，只在成语中使用
	@Column(name="fill_words")
	@ParamAnnotation
	private String fillWords;
	
	//试卷id
	@Column(name="paper_id")
	private String paperId;
	
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Integer getIsImg() {
		return isImg;
	}

	public void setIsImg(Integer isImg) {
		this.isImg = isImg;
	}

	

	public String getRightOptionId() {
		return rightOptionId;
	}

	public void setRightOptionId(String rightOptionId) {
		this.rightOptionId = rightOptionId;
	}

	public String getFillWords() {
		return fillWords;
	}

	public void setFillWords(String fillWords) {
		this.fillWords = fillWords;
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

	public String getPaperId() {
		return paperId;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}
}

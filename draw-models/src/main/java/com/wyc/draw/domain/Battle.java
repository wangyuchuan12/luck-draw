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


/**
 * 比赛
 * @author root
 *
 */
@ParamEntityAnnotation
@Entity
@Table(name="b_battle")
public class Battle {
	@Id
	@IdAnnotation
	private String id;
	
	@Column(name="paper_id")
	private String paperId;
	
	@Column
	private Integer type;
	
	@Column
	private String name;
	
	@Column(name="img_url")
	private String imgUrl;
	
	@Column
	private String title;
	
	@Column
	private String userImgs;
	
	//总参与人数
	@Column(name="takepart_count")
	private Integer takepartCount;
	
	@Column(name="subject_id")
	private String subjectId;
	
	
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

	public String getPaperId() {
		return paperId;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public Integer getTakepartCount() {
		return takepartCount;
	}

	public void setTakepartCount(Integer takepartCount) {
		this.takepartCount = takepartCount;
	}

	
	
	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	
	
	public String getUserImgs() {
		return userImgs;
	}

	public void setUserImgs(String userImgs) {
		this.userImgs = userImgs;
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

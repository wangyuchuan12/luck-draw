package com.wyc.draw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;


//房间
@Entity(name="d_draw_room")
public class DrawRoom {
	@Id
    private String id;
	
	
	//房间名称
	@Column
	private String name;
	
	//上限人数
	@Column(name="max_num")
	private Integer maxNum;
	
	//创建者adminid
	@Column(name="creater_admin_id")
	private String createrAdminId;
	
	//创建者userid
	@Column(name="creater_user_id")
	private String createrUserId;
	
	//创建者openid
	@Column(name="creater_openid")
	private String createrOpenid;
	
	//房间创建时间
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name="create_datetime")
	private DateTime createDateTime;
	
	
	//房间密码
	@Column
	private String password;
	
	//验证问题
	@Column
	private String verifyQuestion;
	
	//验证答案
	@Column
	private String verifyAnswer;
	
	//验证类型
	@Column
	private int verifyType;
	
	//图片地址
	@Column
	private String imgUrl;
	
	//图片资源id
	@Column
	private String imgResourceId;
	
	//用户人数
	@Column
	private Integer memberCount;
	
	@Column(name = "create_at")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonIgnore
    private DateTime createAt;
    @Column(name = "update_at")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonIgnore
    private DateTime updateAt;
    
    
    
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getVerifyQuestion() {
		return verifyQuestion;
	}
	public void setVerifyQuestion(String verifyQuestion) {
		this.verifyQuestion = verifyQuestion;
	}
	public String getVerifyAnswer() {
		return verifyAnswer;
	}
	public void setVerifyAnswer(String verifyAnswer) {
		this.verifyAnswer = verifyAnswer;
	}
	public int getVerifyType() {
		return verifyType;
	}
	public void setVerifyType(int verifyType) {
		this.verifyType = verifyType;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getImgResourceId() {
		return imgResourceId;
	}
	public void setImgResourceId(String imgResourceId) {
		this.imgResourceId = imgResourceId;
	}
	public Integer getMemberCount() {
		return memberCount;
	}
	public void setMemberCount(Integer memberCount) {
		this.memberCount = memberCount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getMaxNum() {
		return maxNum;
	}
	public void setMaxNum(Integer maxNum) {
		this.maxNum = maxNum;
	}
	public String getCreaterAdminId() {
		return createrAdminId;
	}
	public void setCreaterAdminId(String createrAdminId) {
		this.createrAdminId = createrAdminId;
	}
	public String getCreaterUserId() {
		return createrUserId;
	}
	public void setCreaterUserId(String createrUserId) {
		this.createrUserId = createrUserId;
	}
	public String getCreaterOpenid() {
		return createrOpenid;
	}
	public void setCreaterOpenid(String createrOpenid) {
		this.createrOpenid = createrOpenid;
	}
	public DateTime getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(DateTime createDateTime) {
		this.createDateTime = createDateTime;
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

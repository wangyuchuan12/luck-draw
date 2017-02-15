package com.wyc.common.wx.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wyc.annotation.IdAnnotation;

@Entity
@Table(name="share")
public class Share {
	@Id
    @IdAnnotation
    private String id;
	
	//链接id
	@Column(name="href_id")
	private String hrefId;
	
	//url地址
	@Column
	private String url;
	
	//发起人openid
	@Column(name="sponsor_openid")
	private String sponsorOpenid;
	
	//发起时间
	@Column(name="hand_time")
	private DateTime handTime;
	
	//分享类型
	@Column
	private int type;
	
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
	public String getHrefId() {
		return hrefId;
	}
	public void setHrefId(String hrefId) {
		this.hrefId = hrefId;
	}
	public String getSponsorOpenid() {
		return sponsorOpenid;
	}
	public void setSponsorOpenid(String sponsorOpenid) {
		this.sponsorOpenid = sponsorOpenid;
	}
	public DateTime getHandTime() {
		return handTime;
	}
	public void setHandTime(DateTime handTime) {
		this.handTime = handTime;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}

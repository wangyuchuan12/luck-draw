package com.wyc.draw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wyc.annotation.ParamAnnotation;

@Entity(name="v_dekorn_takepart_member")
public class DekornTakepartMember {

	@Id
	private String id;
	
	//adminId
	@ParamAnnotation
	@Column(name="admin_id")
	private String adminId;
	
	//userid
	@ParamAnnotation
	@Column(name="user_id")
	private String userId;
	
	//openid
	@ParamAnnotation
	@Column(name="openid")
	private String openid;
	
	@ParamAnnotation
	@Column(name="draw_user_id")
	private String drawUserId;
	
	//参加时间
	@ParamAnnotation
	@Column(name="takepart_datetime")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime takepartDateTime;
	
	//是否领取成功
	@ParamAnnotation
	@Column(name="is_success")
	private int isSuccess;
	
	//使用爱心个数
	@ParamAnnotation
	@Column(name="use_love_life")
	private Long useLoveLife;
	
	//别呢
	@ParamAnnotation
	@Column
	private String nickname;
	
	//头像
	@ParamAnnotation
	@Column(name="head_img")
	private String headImg;
	
	//分数
	@Column
	private Long score;
	
	//所用时间
	@Column(name="time_long")
	private Long timeLong;
	
	//获取智慧豆个数
	@Column(name="obtain_wisdom_num")
	private Long obtainWisdomNum;
	
	//获取经验数量
	@Column(name="obtain_integral_num")
	private Long obtainIntegralNum;
	
	
	
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

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getDrawUserId() {
		return drawUserId;
	}

	public void setDrawUserId(String drawUserId) {
		this.drawUserId = drawUserId;
	}

	public DateTime getTakepartDateTime() {
		return takepartDateTime;
	}

	public void setTakepartDateTime(DateTime takepartDateTime) {
		this.takepartDateTime = takepartDateTime;
	}

	public int getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(int isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Long getUseLoveLife() {
		return useLoveLife;
	}

	public void setUseLoveLife(Long useLoveLife) {
		this.useLoveLife = useLoveLife;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public Long getTimeLong() {
		return timeLong;
	}

	public void setTimeLong(Long timeLong) {
		this.timeLong = timeLong;
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

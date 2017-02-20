package com.wyc.draw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;


//竞答红包参与
@Entity
@Table(name="d_vie_red_packet_takepart_member",
indexes={@Index(columnList="draw_user_id",name="draw_user_id_index")})
public class VieRedPacketTakepartMember {
	@Id
	private String id;
	
	//openid
	@Column
	private String opendid;
	
	//红包用户id
	@Column(name="draw_user_id")
	private String drawUserId;
	
	//别呢
	@Column
	private String nickname;
	
	//头像
	@Column(name="head_img")
	private String headImg;
	
	//用户id
	@Column(name="user_id")
	private String userId;
	
	//总用时
	@Column(name="time_long")
	private Float timeLong;
	
	//正确答题数量
	@Column(name="right_count")
	private Long rightCount;
	
	//错误答题数量
	@Column(name="wrong_count")
	private Long wrongCount;

	//红包id
	@Column(name="red_packet_id")
	private String redPacketId;
	
	//是否是所有参与者当中的最高分
	@Column(name="is_best")
	private int isBest;
	
	//是否已交参与费
	@Column(name="is_pay")
	private Integer isPay;
	
	//是否答题完成
	@Column(name="is_complete")
	private Integer isComplete;
	
	
	//当前正在答得题目
	@Column(name="current_problem_id")
	private String currentProblemId;
	
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
	public String getCurrentProblemId() {
		return currentProblemId;
	}
	public void setCurrentProblemId(String currentProblemId) {
		this.currentProblemId = currentProblemId;
	}
	public Integer getIsComplete() {
		return isComplete;
	}
	public void setIsComplete(Integer isComplete) {
		this.isComplete = isComplete;
	}
	public Integer getIsPay() {
		return isPay;
	}
	public void setIsPay(Integer isPay) {
		this.isPay = isPay;
	}
	public int getIsBest() {
		return isBest;
	}
	public void setIsBest(int isBest) {
		this.isBest = isBest;
	}
	public String getOpendid() {
		return opendid;
	}
	public void setOpendid(String opendid) {
		this.opendid = opendid;
	}
	public String getDrawUserId() {
		return drawUserId;
	}
	public void setDrawUserId(String drawUserId) {
		this.drawUserId = drawUserId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Float getTimeLong() {
		return timeLong;
	}
	public void setTimeLong(Float timeLong) {
		this.timeLong = timeLong;
	}
	public Long getRightCount() {
		return rightCount;
	}
	public void setRightCount(Long rightCount) {
		this.rightCount = rightCount;
	}
	public Long getWrongCount() {
		return wrongCount;
	}
	public void setWrongCount(Long wrongCount) {
		this.wrongCount = wrongCount;
	}
	public String getRedPacketId() {
		return redPacketId;
	}
	public void setRedPacketId(String redPacketId) {
		this.redPacketId = redPacketId;
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
	
	
}

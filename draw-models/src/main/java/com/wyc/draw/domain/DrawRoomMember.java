package com.wyc.draw.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

//房间参加人员
@Entity(name="d_draw_room_member")
public class DrawRoomMember {
	
	//被踢出
	public static final int KICK_OUT_TYPE = 0;
	
	//自己主动退出
	public static final int SELF_OUT_TYPE = 1;
	@Id
    private String id;
	
	@Column(name="admin_id")
	private String adminId;
	
	@Column
	private String openid;
	
	@Column(name="user_id")
	private String userId;
	
	//是否是创建者
	@Column
	private int isCreater;
	
	//房间中的名称
	@Column
	private String name;
	
	//红包房间
	@Column(name="draw_room_id")
	private String drawRoomId;
	
	//参加时间
	@Column(name="takepart_time")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime takepartTime;
	
	//发红包个数
	@Column(name="hand_red_packet_num")
	private Integer handRedPacketNum;
	
	//收红包个数
	@Column(name="get_red_packet_num")
	private Integer getRedPacketNum;
	
	//发红包总金额
	@Column(name="hand_red_packet_amount")
	private BigDecimal handRedPacketAmount;
	
	//收红包总金额
	@Column(name="get_red_packet_amount")
	private BigDecimal getRedPacketAmount;
	
	//回答问题次数
	@Column(name="answer_num")
	private Integer answerNum;
	
	//错误回答次数
	@Column(name="wrong_answer_num")
	private Integer wrongAnswerNum;

	//是否退出
	@Column
	private int isOut;
	
	//退出方式
	@Column
	private Integer outType;
	
	@Column(name="out_time")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime outTime;
	
	
	@Column(name = "create_at")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonIgnore
    private DateTime createAt;
    @Column(name = "update_at")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonIgnore
    private DateTime updateAt;
    
    
    

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

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getIsCreater() {
		return isCreater;
	}

	public void setIsCreater(int isCreater) {
		this.isCreater = isCreater;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDrawRoomId() {
		return drawRoomId;
	}

	public void setDrawRoomId(String drawRoomId) {
		this.drawRoomId = drawRoomId;
	}

	public DateTime getTakepartTime() {
		return takepartTime;
	}

	public void setTakepartTime(DateTime takepartTime) {
		this.takepartTime = takepartTime;
	}

	public Integer getHandRedPacketNum() {
		return handRedPacketNum;
	}

	public void setHandRedPacketNum(Integer handRedPacketNum) {
		this.handRedPacketNum = handRedPacketNum;
	}

	public Integer getGetRedPacketNum() {
		return getRedPacketNum;
	}

	public void setGetRedPacketNum(Integer getRedPacketNum) {
		this.getRedPacketNum = getRedPacketNum;
	}

	public BigDecimal getHandRedPacketAmount() {
		return handRedPacketAmount;
	}

	public void setHandRedPacketAmount(BigDecimal handRedPacketAmount) {
		this.handRedPacketAmount = handRedPacketAmount;
	}

	public BigDecimal getGetRedPacketAmount() {
		return getRedPacketAmount;
	}

	public void setGetRedPacketAmount(BigDecimal getRedPacketAmount) {
		this.getRedPacketAmount = getRedPacketAmount;
	}

	public Integer getAnswerNum() {
		return answerNum;
	}

	public void setAnswerNum(Integer answerNum) {
		this.answerNum = answerNum;
	}

	public Integer getWrongAnswerNum() {
		return wrongAnswerNum;
	}

	public void setWrongAnswerNum(Integer wrongAnswerNum) {
		this.wrongAnswerNum = wrongAnswerNum;
	}

	public int getIsOut() {
		return isOut;
	}

	public void setIsOut(int isOut) {
		this.isOut = isOut;
	}

	public Integer getOutType() {
		return outType;
	}

	public void setOutType(Integer outType) {
		this.outType = outType;
	}

	public DateTime getOutTime() {
		return outTime;
	}

	public void setOutTime(DateTime outTime) {
		this.outTime = outTime;
	}
	
	
	
}

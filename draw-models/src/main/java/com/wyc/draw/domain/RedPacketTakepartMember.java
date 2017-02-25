package com.wyc.draw.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;

//红包参与者
@ParamEntityAnnotation
@Entity(name="d_red_packet_takepart_member")
@Table(indexes={@Index(columnList="red_packet_id",name="red_packet_id_index")})
public class RedPacketTakepartMember {
	
	//房间问答红包
	public static final int ROOM_QUESTION_TYPE = 0;
	//个人问答红包
	public static final int PERSONAL_QUESTION_TYPE=1;
	
	@Id
	@IdAnnotation
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
	@Column
	private int isSuccess;
	
	//提交答案
	@ParamAnnotation
	@Column
	private String answer;

	//参与类型
	@ParamAnnotation
	@Column
	private int type;
	
	//房间参与者id 只有是房间红包的时候此字段不为空
	@ParamAnnotation
	@Column
	private String roomMemberId;
	
	//获得金额
	@ParamAnnotation
	@Column(name="get_amount")
	private BigDecimal getAmount;

	//红包id
	@ParamAnnotation
	@Column(name="red_packet_id")
	private String redPacketId;

	//别呢
	@ParamAnnotation
	@Column
	private String nickname;
	
	//头像
	@ParamAnnotation
	@Column(name="head_img")
	private String headImg;

	//总用时
	@ParamAnnotation
	@Column(name="time_long")
	private Float timeLong;
	
	//正确答题数量
	@ParamAnnotation
	@Column(name="right_count")
	private Long rightCount;
	
	//错误答题数量
	@ParamAnnotation
	@Column(name="wrong_count")
	private Long wrongCount;
	
	//是否是所有参与者当中的最高分
	@ParamAnnotation
	@Column(name="is_best")
	private int isBest;
	
	//是否已交参与费
	@ParamAnnotation
	@Column(name="is_pay")
	private Integer isPay;
	
	//是否上缴参赛费
	@ParamAnnotation
	@Column(name="is_give_entry_fee")
	private Integer isGiveEntryFee;
	
	//参赛费
	@ParamAnnotation
	@Column(name="entry_fee")
	private BigDecimal entryFee;
	
	//是否答题完成
	@ParamAnnotation
	@Column(name="is_complete")
	private Integer isComplete;

	//当前正在答得题目
	@ParamAnnotation
	@Column(name="current_problem_id")
	private String currentProblemId;
	
	//支付码
	@ParamAnnotation
	@Column(name="out_trade_no")
	private String outTradeNo;

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
	public BigDecimal getEntryFee() {
		return entryFee;
	}
	public void setEntryFee(BigDecimal entryFee) {
		this.entryFee = entryFee;
	}
	public Integer getIsGiveEntryFee() {
		return isGiveEntryFee;
	}
	public void setIsGiveEntryFee(Integer isGiveEntryFee) {
		this.isGiveEntryFee = isGiveEntryFee;
	}
	public String getRedPacketId() {
		return redPacketId;
	}
	public void setRedPacketId(String redPacketId) {
		this.redPacketId = redPacketId;
	}
	public String getDrawUserId() {
		return drawUserId;
	}
	public void setDrawUserId(String drawUserId) {
		this.drawUserId = drawUserId;
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
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getRoomMemberId() {
		return roomMemberId;
	}
	public void setRoomMemberId(String roomMemberId) {
		this.roomMemberId = roomMemberId;
	}
	public BigDecimal getGetAmount() {
		return getAmount;
	}
	public void setGetAmount(BigDecimal getAmount) {
		this.getAmount = getAmount;
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
	public int getIsBest() {
		return isBest;
	}
	public void setIsBest(int isBest) {
		this.isBest = isBest;
	}
	public Integer getIsPay() {
		return isPay;
	}
	public void setIsPay(Integer isPay) {
		this.isPay = isPay;
	}
	public Integer getIsComplete() {
		return isComplete;
	}
	public void setIsComplete(Integer isComplete) {
		this.isComplete = isComplete;
	}
	public String getCurrentProblemId() {
		return currentProblemId;
	}
	public void setCurrentProblemId(String currentProblemId) {
		this.currentProblemId = currentProblemId;
	}
	public String getOutTradeNo() {
		return outTradeNo;
	}
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	
	
}

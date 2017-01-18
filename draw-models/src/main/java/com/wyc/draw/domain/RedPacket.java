package com.wyc.draw.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;


//红包
@ParamEntityAnnotation
@Entity(name="d_red_packet")
public class RedPacket {
	
	@IdAnnotation
	@Id
    private String id;
	
	
	//红包所属房间参与用户id
	@ParamAnnotation
	@Column(name="hand_room_member_id")
	private String handRoomMemberId;
	
	//所属房间id
	@ParamAnnotation
	@Column(name="draw_room_id")
	private String drawRoomId;
	
	//红包类型
	@Column
	@ParamAnnotation
	private Integer type;
	
	//红包用户id
	@ParamAnnotation
	@Column(name="hand_draw_user_id")
	private String handDrawUserId;
	
	
	//红包接收人
	@ParamAnnotation
	@Column(name="receive_draw_user_id")
	private String receiveDrawUserId;
	
	//发送时间
	@ParamAnnotation
	@Column(name="hand_time")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime handTime;
	
	//红包截止时长
	@ParamAnnotation
	@Column(name="time_long")
	private int timeLong;
	
	//红包金额
	@ParamAnnotation
	@Column
	private BigDecimal amount;
	
	//问题
	@ParamAnnotation
	@Column
	private String question;
	
	//答案
	@ParamAnnotation
	@Column
	private String answer;
	
	
	//红包付款订单号
	@ParamAnnotation
	@Column(name="out_trade_no")
	private String outTradeNo;

	//是否可领取
	@ParamAnnotation
	@Column(name="is_receive_able")
	private Integer isReceiveAble;
	
	//红包是否已接受
	@ParamAnnotation
	@Column(name="is_receive")
	private Integer isReceive;
	
	//红包是否已到时间
	@ParamAnnotation
	@Column(name="is_timeout")
	private Integer isTimeout;
	
	//允许错误次数
	@ParamAnnotation
	@Column(name="allow_wrong_count")
	private Integer allowWrongCount;
	
	
	//是否已付款
	@ParamAnnotation
	@Column(name="is_pay")
	private Integer isPay;
	
	//支付类型
	@ParamAnnotation
	@Column(name="pay_type")
	private Integer payType;
	
	//提示信息
	@ParamAnnotation
	@Column
	private String prompt;
	
	//是否退款
	@ParamAnnotation
	@Column(name="is_refund")
	private Integer isRefund;
	
	@Column(name = "create_at")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonIgnore
    private DateTime createAt;
    @Column(name = "update_at")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonIgnore
    private DateTime updateAt;
	
	public Integer getIsTimeout() {
		return isTimeout;
	}
	public void setIsTimeout(Integer isTimeout) {
		this.isTimeout = isTimeout;
	}
	
	public Integer getIsRefund() {
		return isRefund;
	}
	public void setIsRefund(Integer isRefund) {
		this.isRefund = isRefund;
	}
	public Integer getAllowWrongCount() {
		return allowWrongCount;
	}
	public void setAllowWrongCount(Integer allowWrongCount) {
		this.allowWrongCount = allowWrongCount;
	}
 
	public String getOutTradeNo() {
		return outTradeNo;
	}
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	public String getPrompt() {
		return prompt;
	}
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	public Integer getIsReceiveAble() {
		return isReceiveAble;
	}
	public void setIsReceiveAble(Integer isReceiveAble) {
		this.isReceiveAble = isReceiveAble;
	}
	public Integer getIsReceive() {
		return isReceive;
	}
	public void setIsReceive(Integer isReceive) {
		this.isReceive = isReceive;
	}
	public Integer getIsPay() {
		return isPay;
	}
	public void setIsPay(Integer isPay) {
		this.isPay = isPay;
	}
	public Integer getPayType() {
		return payType;
	}
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	public String getReceiveDrawUserId() {
		return receiveDrawUserId;
	}
	public void setReceiveDrawUserId(String receiveDrawUserId) {
		this.receiveDrawUserId = receiveDrawUserId;
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
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getHandDrawUserId() {
		return handDrawUserId;
	}
	public void setHandDrawUserId(String handDrawUserId) {
		this.handDrawUserId = handDrawUserId;
	}
	public int getTimeLong() {
		return timeLong;
	}
	public void setTimeLong(int timeLong) {
		this.timeLong = timeLong;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getHandRoomMemberId() {
		return handRoomMemberId;
	}
	public void setHandRoomMemberId(String handRoomMemberId) {
		this.handRoomMemberId = handRoomMemberId;
	}
	public String getDrawRoomId() {
		return drawRoomId;
	}
	public void setDrawRoomId(String drawRoomId) {
		this.drawRoomId = drawRoomId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	public DateTime getHandTime() {
		return handTime;
	}
	public void setHandTime(DateTime handTime) {
		this.handTime = handTime;
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

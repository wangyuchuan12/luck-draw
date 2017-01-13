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


@ParamEntityAnnotation(type=ParamEntityAnnotation.SESSION_TYPE)
@Entity(name="d_draw_user")
public class DrawUser {

	@Id
	@IdAnnotation
	private String id;
	
	@Column
	@ParamAnnotation(type=ParamEntityAnnotation.SESSION_TYPE)
	private String openid;
	
	@Column(name="admin_id")
	@ParamAnnotation(type=ParamEntityAnnotation.SESSION_TYPE)
	private String adminId;
	
	@Column(name="user_id")
	@ParamAnnotation(type=ParamEntityAnnotation.SESSION_TYPE)
	private String userId;
	
	//账号余额
	@ParamAnnotation(type=ParamEntityAnnotation.SESSION_TYPE)
	@Column(name="admount_balance")
	private BigDecimal amountBalance;
	
	//发红包个数
	@ParamAnnotation(type=ParamEntityAnnotation.SESSION_TYPE)
	@Column(name="hand_red_packet_num")
	private Integer handRedPacketNum;
		
	//收红包个数
	@ParamAnnotation(type=ParamEntityAnnotation.SESSION_TYPE)
	@Column(name="get_red_packet_num")
	private Integer getRedPacketNum;
		
	//发红包总金额
	@ParamAnnotation(type=ParamEntityAnnotation.SESSION_TYPE)
	@Column(name="hand_red_packet_amount")
	private BigDecimal handRedPacketAmount;
		
	//收红包总金额
	@ParamAnnotation(type=ParamEntityAnnotation.SESSION_TYPE)
	@Column(name="get_red_packet_amount")
	private BigDecimal getRedPacketAmount;
		
	//回答问题次数
	@ParamAnnotation(type=ParamEntityAnnotation.SESSION_TYPE)
	@Column(name="answer_num")
	private Integer answerNum;
		
	//错误回答次数
	@ParamAnnotation(type=ParamEntityAnnotation.SESSION_TYPE)
	@Column(name="wrong_answer_num")
	private Integer wrongAnswerNum;
	
	
	//本月可提现次数
	@Column(name="can_take_out_count")
	@ParamAnnotation(type=ParamEntityAnnotation.SESSION_TYPE)
	private Integer canTakeOutCount;
	
	@Column(name = "create_at")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonIgnore
    private DateTime createAt;
    @Column(name = "update_at")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonIgnore
    private DateTime updateAt;
    
    
    

	public Integer getCanTakeOutCount() {
		return canTakeOutCount;
	}

	public void setCanTakeOutCount(Integer canTakeOutCount) {
		this.canTakeOutCount = canTakeOutCount;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
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

	public BigDecimal getAmountBalance() {
		return amountBalance;
	}

	public void setAmountBalance(BigDecimal amountBalance) {
		this.amountBalance = amountBalance;
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
	
	
	
	
}

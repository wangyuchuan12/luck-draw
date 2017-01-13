package com.wyc.common.domain;

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


//申请单
@Entity(name = "apply_form")
@ParamEntityAnnotation
public class ApplyForm {
	
	@Id
	@IdAnnotation
	private String id;
	
	//申请类型
	@Column
	@ParamAnnotation
	private Integer type;
	
	//申请信息
	@Column
	@ParamAnnotation
	private String msg;
	
	//申请金额
	@Column
	@ParamAnnotation
	private BigDecimal amount;
	
	//状态
	@Column
	@ParamAnnotation
	private int status;
	
	//申请时间
	@Column(name="apply_time")
	@ParamAnnotation
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime applyTime;
	
	//处理时间
	@ParamAnnotation
	@Column(name="handle_time")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime handleTime;
	
	//申请人的openid
	@ParamAnnotation
	@Column(nullable=true)
	private String openid;
	
	@ParamAnnotation
	@Column(name="trade_out_no")
	private String tradeOutNo;
	
	
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
	public String getTradeOutNo() {
		return tradeOutNo;
	}

	public void setTradeOutNo(String tradeOutNo) {
		this.tradeOutNo = tradeOutNo;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public DateTime getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(DateTime applyTime) {
		this.applyTime = applyTime;
	}

	public DateTime getHandleTime() {
		return handleTime;
	}

	public void setHandleTime(DateTime handleTime) {
		this.handleTime = handleTime;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
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

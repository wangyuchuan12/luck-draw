package com.wyc.draw.domain;

import java.math.BigDecimal;

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

@ParamEntityAnnotation
@Entity
@Table(name="d_red_packet_amount_distribution")
public class RedPacketAmountDistribution {
	
	@Id
	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	@Column(name="red_packet_id")
	private String redPacketId;
	
	@ParamAnnotation
	@Column(name="takepart_member_id")
	private String takepartMemberId;
	
	@Column(name="draw_user_id")
	private String drawUserId;
	
	@ParamAnnotation
	@Column
	private BigDecimal amount;
	
	@ParamAnnotation
	@Column
	private Integer seq;
	
	@ParamAnnotation
	@Column
	private Integer status;
	
	@ParamAnnotation
	@Column(name="receive_time")
	private DateTime receiveTime;
	
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
	public String getRedPacketId() {
		return redPacketId;
	}
	public void setRedPacketId(String redPacketId) {
		this.redPacketId = redPacketId;
	}
	public String getTakepartMemberId() {
		return takepartMemberId;
	}
	public void setTakepartMemberId(String takepartMemberId) {
		this.takepartMemberId = takepartMemberId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public DateTime getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(DateTime receiveTime) {
		this.receiveTime = receiveTime;
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
	public String getDrawUserId() {
		return drawUserId;
	}
	public void setDrawUserId(String drawUserId) {
		this.drawUserId = drawUserId;
	}
	
	
}

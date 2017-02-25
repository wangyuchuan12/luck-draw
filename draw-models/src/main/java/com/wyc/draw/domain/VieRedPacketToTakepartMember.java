package com.wyc.draw.domain;

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
@Table(name="d_vie_red_packet_to_takepart_member")
public class VieRedPacketToTakepartMember {
	@Id
	@IdAnnotation
	private String id;
	
	//红包id
	@ParamAnnotation
	@Column(name="red_packet_id")
	private String redPacketId;
	
	//用户id
	@ParamAnnotation
	@Column(name="draw_user_id")
	private String drawUserId;
	
	//当前参与
	@ParamAnnotation
	@Column(name="current_takepart_member_id")
	private String currentTakepartMemberId;
	
	//访问次数
	@ParamAnnotation
	@Column(name="visit_count")
	private Integer visitCount;
	
	//参与次数
	@ParamAnnotation
	@Column(name="takepart_count")
	private Integer takepartCount;
	
	//当前是否已经付款
	@ParamAnnotation
	@Column(name="is_pay")
	private Integer isPay;
	
	//是否已经回答
	@ParamAnnotation
	@Column(name="is_answer")
	private Integer isAnswer;
	
	//当前参与状态 0表示未参与 1正在参与 2参与结束 3中途退出
	@Column(name="takepart_status")
	@ParamAnnotation
	private Integer takepartStatus;
	
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

	public String getCurrentTakepartMemberId() {
		return currentTakepartMemberId;
	}

	public void setCurrentTakepartMemberId(String currentTakepartMemberId) {
		this.currentTakepartMemberId = currentTakepartMemberId;
	}

	public Integer getVisitCount() {
		return visitCount;
	}

	public void setVisitCount(Integer visitCount) {
		this.visitCount = visitCount;
	}

	public Integer getTakepartCount() {
		return takepartCount;
	}

	public void setTakepartCount(Integer takepartCount) {
		this.takepartCount = takepartCount;
	}

	public Integer getIsPay() {
		return isPay;
	}

	public void setIsPay(Integer isPay) {
		this.isPay = isPay;
	}

	public Integer getIsAnswer() {
		return isAnswer;
	}

	public void setIsAnswer(Integer isAnswer) {
		this.isAnswer = isAnswer;
	}

	public Integer getTakepartStatus() {
		return takepartStatus;
	}

	public void setTakepartStatus(Integer takepartStatus) {
		this.takepartStatus = takepartStatus;
	}
	
	
	
	
	
}

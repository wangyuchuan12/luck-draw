package com.wyc.draw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wyc.annotation.ParamAnnotation;
@Entity
@Table(name="d_problem_red_packet")
public class ProblemRedPacket {

	@Id
	private String id;
	
	@Column(name="red_packet_id")
	@ParamAnnotation
	private String redPacketId;
	//问题
	@ParamAnnotation
	@Column
	private String question;
	
	//答案
	@ParamAnnotation
	@Column
	private String answer;
	
	//红包是否已接受
	@ParamAnnotation
	@Column(name="is_receive")
	private Integer isReceive;
	
	//允许错误次数
	@ParamAnnotation
	@Column(name="allow_wrong_count")
	private Integer allowWrongCount;
	
	//金额是否显示
	@ParamAnnotation
	@Column(name="is_amount_display")
	private Integer isAmountDisplay;
	
	

	//分享几个人可看答案
	@ParamAnnotation
    @Column(name="share_num_show_answer")
	private Integer shareNumShowAnswer;
	
	
	//是否设置选项卡
	@ParamAnnotation
	@Column(name="is_set_option")
	private Integer isSetOption;
	
	
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
	public String getRedPacketId() {
		return redPacketId;
	}
	public void setRedPacketId(String redPacketId) {
		this.redPacketId = redPacketId;
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
	public Integer getIsReceive() {
		return isReceive;
	}
	public void setIsReceive(Integer isReceive) {
		this.isReceive = isReceive;
	}
	public Integer getAllowWrongCount() {
		return allowWrongCount;
	}
	public void setAllowWrongCount(Integer allowWrongCount) {
		this.allowWrongCount = allowWrongCount;
	}
	public Integer getIsAmountDisplay() {
		return isAmountDisplay;
	}
	public void setIsAmountDisplay(Integer isAmountDisplay) {
		this.isAmountDisplay = isAmountDisplay;
	}
	public Integer getShareNumShowAnswer() {
		return shareNumShowAnswer;
	}
	public void setShareNumShowAnswer(Integer shareNumShowAnswer) {
		this.shareNumShowAnswer = shareNumShowAnswer;
	}
	public Integer getIsSetOption() {
		return isSetOption;
	}
	public void setIsSetOption(Integer isSetOption) {
		this.isSetOption = isSetOption;
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

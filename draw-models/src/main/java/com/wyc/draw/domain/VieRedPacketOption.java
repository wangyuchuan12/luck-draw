package com.wyc.draw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;


//竞答红包的选项卡
@Entity
@Table(name="d_vie_red_packet_option")
public class VieRedPacketOption {
	@Id
	private String id;
	
	//是否删除
	@Column(name="is_del")
	private Integer isDel;
	
	
	//红包id
	@Column(name="red_packet_id")
	private String redPacketId;
	
	//问题id
	@Column(name="red_packet_problem_id")
	private String redPacketProblemId;

	//选项内容
	@Column
	private String content;
	
	//是否正确选项
	@Column(name="is_right")
	private Integer isRight;
	
	//序号
	@Column
	private Integer seq;
	
	@Column(name = "create_at")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonIgnore
    private DateTime createAt;
    @Column(name = "update_at")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonIgnore
    private DateTime updateAt;
    
    
    
    
    
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public Integer getIsRight() {
		return isRight;
	}
	public void setIsRight(Integer isRight) {
		this.isRight = isRight;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getIsDel() {
		return isDel;
	}
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
	public String getRedPacketId() {
		return redPacketId;
	}
	public void setRedPacketId(String redPacketId) {
		this.redPacketId = redPacketId;
	}
	public String getRedPacketProblemId() {
		return redPacketProblemId;
	}
	public void setRedPacketProblemId(String redPacketProblemId) {
		this.redPacketProblemId = redPacketProblemId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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

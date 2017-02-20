package com.wyc.draw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;


//竞答红包回答记录
@Entity
@Table(name="d_vie_red_packet_takepart_member_record"
		//,indexes={@Index(columnList="vie_red_packet_problem_id",name="vie_red_packet_problem_id_index"),
		//@Index(columnList="vie_red_packet_option_id",name="vie_red_packet_option_id_index")}
)
public class VieRedPacketTakepartMemberRecord {

	@Id
	private String id;
	
	//问题红包id
	@Column(name="vie_red_packet_problem_id")
	private String vieRedPacketProblemId;
	
	
	@Column(name="member_id")
	private String memberId;
	
	//所选的选项id
	@Column(name="vie_red_packet_option_id")
	private String vieRedPacketOptionId;
	
	//用时多少
	@Column(name="time_long")
	private Float timeLong;
	
	//是否正确
	@Column(name="is_right")
	private int isRight;
	
	@Column(name="is_timeout")
	private int isTimeout;
	
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
	
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getIsTimeout() {
		return isTimeout;
	}
	public void setIsTimeout(int isTimeout) {
		this.isTimeout = isTimeout;
	}
	public String getVieRedPacketProblemId() {
		return vieRedPacketProblemId;
	}
	public void setVieRedPacketProblemId(String vieRedPacketProblemId) {
		this.vieRedPacketProblemId = vieRedPacketProblemId;
	}
	public String getVieRedPacketOptionId() {
		return vieRedPacketOptionId;
	}
	public void setVieRedPacketOptionId(String vieRedPacketOptionId) {
		this.vieRedPacketOptionId = vieRedPacketOptionId;
	}
	public Float getTimeLong() {
		return timeLong;
	}
	public void setTimeLong(Float timeLong) {
		this.timeLong = timeLong;
	}
	public int getIsRight() {
		return isRight;
	}
	public void setIsRight(int isRight) {
		this.isRight = isRight;
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

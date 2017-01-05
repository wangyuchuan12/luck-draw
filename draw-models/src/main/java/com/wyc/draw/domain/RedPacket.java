package com.wyc.draw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;


//红包
@Entity(name="d_red_packet")
public class RedPacket {
	
	//房间问答红包
	public static final int ROOM_QUESTION_TYPE = 0;
	//个人问答红包
	public static final int PERSONAL_QUESTION_TYPE=1;
	@Id
    private String id;
	
	
	//红包所属房间参与用户id
	@Column(name="hand_room_member_id")
	private String handRoomMemberId;
	
	//所属房间id
	@Column(name="draw_room_id")
	private String drawRoomId;
	
	//红包类型
	@Column
	private Integer type;
	
	
	//创建者adminid
	@Column(name="hand_admin_id")
	private String handAdminId;
		
	//创建者userid
	@Column(name="hand_user_id")
	private String handUserId;
		
	//创建者openid
	@Column(name="hand_openid")
	private String createrOpenid;
	
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
	public String getHandAdminId() {
		return handAdminId;
	}
	public void setHandAdminId(String handAdminId) {
		this.handAdminId = handAdminId;
	}
	public String getHandUserId() {
		return handUserId;
	}
	public void setHandUserId(String handUserId) {
		this.handUserId = handUserId;
	}
	public String getCreaterOpenid() {
		return createrOpenid;
	}
	public void setCreaterOpenid(String createrOpenid) {
		this.createrOpenid = createrOpenid;
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

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

//红包参与者
@Entity(name="d_red_packet_takepart_member")
@Table(indexes={@Index(columnList="red_packet_id",name="red_packet_id_index")})
public class RedPacketTakepartMember {
	
	//房间问答红包
	public static final int ROOM_QUESTION_TYPE = 0;
	//个人问答红包
	public static final int PERSONAL_QUESTION_TYPE=1;
	
	@Id
    private String id;
	
	//adminId
	@Column(name="admin_id")
	private String adminId;
	
	//userid
	@Column(name="user_id")
	private String userId;
	
	//openid
	@Column(name="openid")
	private String openid;
	
	@Column(name="draw_user_id")
	private String drawUserId;
	
	//参加时间
	@Column(name="takepart_datetime")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime takepartDateTime;
	
	//是否领取成功
	@Column
	private int isSuccess;
	
	//提交答案
	@Column
	private String answer;
	
	
	//参与类型
	@Column
	private int type;
	
	//房间参与者id 只有是房间红包的时候此字段不为空
	@Column
	private String roomMemberId;
	
	//获得金额
	@Column(name="get_amount")
	private BigDecimal getAmount;
	
	
	//红包id
	@Column(name="red_packet_id")
	private String redPacketId;
	
	@Column(name="share_count")
	private Integer shareCount;
	
	@Column(name="is_share_complete")
	private Integer isShareComplete;
	
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
	
	
	
	public Integer getShareCount() {
		return shareCount;
	}
	public void setShareCount(Integer shareCount) {
		this.shareCount = shareCount;
	}
	public Integer getIsShareComplete() {
		return isShareComplete;
	}
	public void setIsShareComplete(Integer isShareComplete) {
		this.isShareComplete = isShareComplete;
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
}

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

@Entity
@Table(name="d_red_packet_owner")
@ParamEntityAnnotation
public class RedPacketOwner {
	@Id
	@IdAnnotation
    private String id;
	
	//红包类型
	@Column
	@ParamAnnotation
	private Integer type;
	
	//发起人头像
	@Column(name="user_img_url")
	@ParamAnnotation
	private String handUserImgUrl;
	
	//发起人昵称
	@Column(name="hand_nick_name")
	@ParamAnnotation
	private String handNickname;
	
	//红包是否已接受
	@ParamAnnotation
	@Column(name="is_receive")
	private Integer isReceive;
	
	//红包是否已到时间
	@ParamAnnotation
	@Column(name="is_timeout")
	private Integer isTimeout;
	
	@ParamAnnotation
	@Column(name="red_packet_id")
	private String redPacketId;
	
	
	@ParamAnnotation
	@Column(name="draw_user_id")
	private String drawUserId;
	
	@ParamAnnotation
	@Column(name="is_del")
	private Integer isDel;
	
	//是否参与
	@ParamAnnotation
	@Column
	private Integer isTakepart;

	//所需智慧豆
	@ParamAnnotation
	@Column(name="wisdom_count")
	private Long wisdomCount;
	
	//是不是本人发送的红包
	@ParamAnnotation
	@Column(name="is_myself")
	private Integer isMyself;
	
	//来源
	@ParamAnnotation
	@Column
	private Integer source;
	
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getHandUserImgUrl() {
		return handUserImgUrl;
	}

	public void setHandUserImgUrl(String handUserImgUrl) {
		this.handUserImgUrl = handUserImgUrl;
	}

	public String getHandNickname() {
		return handNickname;
	}

	public void setHandNickname(String handNickname) {
		this.handNickname = handNickname;
	}

	public Integer getIsReceive() {
		return isReceive;
	}

	public void setIsReceive(Integer isReceive) {
		this.isReceive = isReceive;
	}

	public Integer getIsTimeout() {
		return isTimeout;
	}

	public void setIsTimeout(Integer isTimeout) {
		this.isTimeout = isTimeout;
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

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
	
	public Integer getIsTakepart() {
		return isTakepart;
	}

	public void setIsTakepart(Integer isTakepart) {
		this.isTakepart = isTakepart;
	}

	public Long getWisdomCount() {
		return wisdomCount;
	}

	public void setWisdomCount(Long wisdomCount) {
		this.wisdomCount = wisdomCount;
	}

	public Integer getIsMyself() {
		return isMyself;
	}

	public void setIsMyself(Integer isMyself) {
		this.isMyself = isMyself;
	}
	
	

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
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

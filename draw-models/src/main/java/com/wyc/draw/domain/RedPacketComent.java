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
@Table(name="d_red_packet_comment")
@ParamEntityAnnotation
public class RedPacketComent {

	@Id
	@IdAnnotation
    private String id;
	
	//评论类型，0好评 1差评
	@Column
	@ParamAnnotation
	private Integer type;
	
	//问题答案符合度
	@ParamAnnotation
	@Column(name="accord_star")
	private Integer accordStar;
	
	//问题实用性
	@ParamAnnotation
	@Column(name="useful_star")
	private Integer usefulStar;
	
	//问题有趣度
	@ParamAnnotation
	@Column(name="isteresting_star")
	private Integer interestingStar;
	
	//评论内容
	@ParamAnnotation
	@Column
	private String content;
	
	//评论者
	@ParamAnnotation
	@Column(name="coment_draw_user_id")
	private String comentDrawUserId;
	
	//红包ID
	@ParamAnnotation
	@Column(name="red_packet_id")
	private String redPacketId;
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

	public Integer getAccordStar() {
		return accordStar;
	}

	public void setAccordStar(Integer accordStar) {
		this.accordStar = accordStar;
	}

	public Integer getUsefulStar() {
		return usefulStar;
	}

	public void setUsefulStar(Integer usefulStar) {
		this.usefulStar = usefulStar;
	}

	

	public Integer getInterestingStar() {
		return interestingStar;
	}

	public void setInterestingStar(Integer interestingStar) {
		this.interestingStar = interestingStar;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getComentDrawUserId() {
		return comentDrawUserId;
	}

	public void setComentDrawUserId(String comentDrawUserId) {
		this.comentDrawUserId = comentDrawUserId;
	}

	public String getRedPacketId() {
		return redPacketId;
	}

	public void setRedPacketId(String redPacketId) {
		this.redPacketId = redPacketId;
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

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
@Table(name="d_red_packet_to_coment")
@ParamEntityAnnotation
public class RedPacketToComent {

	@Id
	@IdAnnotation
	private String id;
	
	@Column(name="red_packet_id")
	@ParamAnnotation
	private String redPacketId;
	
	//问题答案符合度1颗星数量
	@Column(name="accord_star1_num")
	@ParamAnnotation
	private Integer accordStar1Num;
	
	//问题答案符合度2颗星数量
	@Column(name="accord_star2_num")
	@ParamAnnotation
	private Integer accordStar2Num;
	
	//问题答案符合度3颗星数量
	@Column(name="accord_star3_num")
	@ParamAnnotation
	private Integer accordStar3Num;
	
	//问题答案符合度4颗星数量
	@Column(name="accord_star4_num")
	@ParamAnnotation
	private Integer accordStar4Num;
	
	//问题答案符合度5颗星数量
	@Column(name="accord_star5_num")
	@ParamAnnotation
	private Integer accordStar5Num;
	
	//实用性1颗星数量
	@Column(name="useful_star1_num")
	@ParamAnnotation
	private Integer usefulStar1Num;
	
	//实用性2颗星数量
	@Column(name="useful_star2_num")
	@ParamAnnotation
	private Integer usefulStar2Num;
	
	//实用性3颗星数量
	@Column(name="useful_star3_num")
	@ParamAnnotation
	private Integer usefulStar3Num;
	
	//实用性4颗星数量
	@Column(name="useful_star4_num")
	@ParamAnnotation
	private Integer usefulStar4Num;
	
	//实用性5颗星数量
	@Column(name="useful_star5_num")
	@ParamAnnotation
	private Integer usefulStar5Num;
	
	//有趣性1颗星数量
	@Column(name="interesting_star1_num")
	@ParamAnnotation
	private Integer interestingStar1Num;
	
	//有趣性2颗星数量
	@Column(name="interesting_star2_num")
	@ParamAnnotation
	private Integer interestingStar2Num;
	
	//有趣性3颗星数量
	@Column(name="interesting_star3_num")
	@ParamAnnotation
	private Integer interestingStar3Num;

	//有趣性4颗星数量
	@Column(name="interesting_star4_num")
	@ParamAnnotation
	private Integer interestingStar4Num;
	
	//有趣性5颗星数量
	@Column(name="interesting_star5_num")
	@ParamAnnotation
	private Integer interestingStar5Num;
	
	//好评数量
	@ParamAnnotation
	@Column(name="good_comment_num")
	private Integer goodCommentNum;
	
	//差评数量
	@ParamAnnotation
	@Column(name="bad_comment_num")
	private Integer badCommentNum;
	
	
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

	public Integer getAccordStar1Num() {
		return accordStar1Num;
	}

	public void setAccordStar1Num(Integer accordStar1Num) {
		this.accordStar1Num = accordStar1Num;
	}

	public Integer getAccordStar2Num() {
		return accordStar2Num;
	}

	public void setAccordStar2Num(Integer accordStar2Num) {
		this.accordStar2Num = accordStar2Num;
	}

	public Integer getAccordStar3Num() {
		return accordStar3Num;
	}

	public void setAccordStar3Num(Integer accordStar3Num) {
		this.accordStar3Num = accordStar3Num;
	}

	public Integer getAccordStar4Num() {
		return accordStar4Num;
	}

	public void setAccordStar4Num(Integer accordStar4Num) {
		this.accordStar4Num = accordStar4Num;
	}

	public Integer getAccordStar5Num() {
		return accordStar5Num;
	}

	public void setAccordStar5Num(Integer accordStar5Num) {
		this.accordStar5Num = accordStar5Num;
	}

	public Integer getUsefulStar1Num() {
		return usefulStar1Num;
	}

	public void setUsefulStar1Num(Integer usefulStar1Num) {
		this.usefulStar1Num = usefulStar1Num;
	}

	public Integer getUsefulStar2Num() {
		return usefulStar2Num;
	}

	public void setUsefulStar2Num(Integer usefulStar2Num) {
		this.usefulStar2Num = usefulStar2Num;
	}

	public Integer getUsefulStar3Num() {
		return usefulStar3Num;
	}

	public void setUsefulStar3Num(Integer usefulStar3Num) {
		this.usefulStar3Num = usefulStar3Num;
	}

	public Integer getUsefulStar4Num() {
		return usefulStar4Num;
	}

	public void setUsefulStar4Num(Integer usefulStar4Num) {
		this.usefulStar4Num = usefulStar4Num;
	}

	public Integer getUsefulStar5Num() {
		return usefulStar5Num;
	}

	public void setUsefulStar5Num(Integer usefulStar5Num) {
		this.usefulStar5Num = usefulStar5Num;
	}

	public Integer getInterestingStar1Num() {
		return interestingStar1Num;
	}

	public void setInterestingStar1Num(Integer interestingStar1Num) {
		this.interestingStar1Num = interestingStar1Num;
	}

	public Integer getInterestingStar2Num() {
		return interestingStar2Num;
	}

	public void setInterestingStar2Num(Integer interestingStar2Num) {
		this.interestingStar2Num = interestingStar2Num;
	}

	public Integer getInterestingStar3Num() {
		return interestingStar3Num;
	}

	public void setInterestingStar3Num(Integer interestingStar3Num) {
		this.interestingStar3Num = interestingStar3Num;
	}

	public Integer getInterestingStar4Num() {
		return interestingStar4Num;
	}

	public void setInterestingStar4Num(Integer interestingStar4Num) {
		this.interestingStar4Num = interestingStar4Num;
	}

	public Integer getInterestingStar5Num() {
		return interestingStar5Num;
	}

	public void setInterestingStar5Num(Integer interestingStar5Num) {
		this.interestingStar5Num = interestingStar5Num;
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

	public Integer getGoodCommentNum() {
		return goodCommentNum;
	}

	public void setGoodCommentNum(Integer goodCommentNum) {
		this.goodCommentNum = goodCommentNum;
	}

	public Integer getBadCommentNum() {
		return badCommentNum;
	}

	public void setBadCommentNum(Integer badCommentNum) {
		this.badCommentNum = badCommentNum;
	}
	
	
}

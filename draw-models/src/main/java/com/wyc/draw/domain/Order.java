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

@Entity
@Table(name = "g_order")
@ParamEntityAnnotation
public class Order {
	@Id
	@IdAnnotation
	private String id;

	@Column(name = "good_id")
	@ParamAnnotation
	private String goodId;

	// 商品名称
	@Column
	@ParamAnnotation
	private String name;
	
	//商品规格
	@Column
	@ParamAnnotation
	private String spec;
	
	@Column
	@ParamAnnotation
	private String detail;

	// 图片
	@Column(name = "img_url")
	@ParamAnnotation
	private String imgUrl;

	// 爱心数量
	@Column(name = "love_num")
	@ParamAnnotation
	private Long loveNum;

	// 智慧豆数量
	@Column(name = "bean_num")
	@ParamAnnotation
	private Long beanNum;

	// 充钱
	@Column(name = "amount_num")
	@ParamAnnotation
	private BigDecimal amountNum;

	// 砖石数量
	@Column(name = "masonry_num")
	@ParamAnnotation
	private Long masonryNum;

	// 新增体力模块
	@Column(name = "phy_model_num")
	@ParamAnnotation
	private Long phyModelNum;

	// 新增爱心模块
	@Column(name = "love_model_num")
	@ParamAnnotation
	private Long loveModelNum;

	// 新增智慧豆模块
	@Column(name = "bean_model_num")
	@ParamAnnotation
	private Long beanModelNum;

	// 新增随机模块
	@Column(name = "random_model_num")
	@ParamAnnotation
	private Long randomModelNum;

	// 花费金额
	@Column(name = "cost_money")
	@ParamAnnotation
	private BigDecimal costMoney;

	// 花费智慧豆
	@Column(name = "cost_bean")
	@ParamAnnotation
	private Integer costBean;

	// 花费砖石
	@Column(name = "cost_masonry")
	@ParamAnnotation
	private Integer costMasonry;

	// 是否已经支付
	@Column(name = "is_pay")
	@ParamAnnotation
	private Integer isPay;

	// 是否已经到账
	@Column(name = "is_to_account")
	@ParamAnnotation
	private Integer isToAccount;

	// 支付方式 0余额支付 1微信支付 2豆子支付 3砖石支付
	@Column(name = "cost_type")
	@ParamAnnotation
	private Integer costType;


	// 微信支付的时候有这个编号
	// 支付编号
	@Column(name = "out_trade_no")
	@ParamAnnotation
	private String outTradeNo;
	
	//订单类型 0商品订单 1红包支付订单
	@Column(name = "order_type")
	@ParamAnnotation
	private Integer orderType;

	@Column(name = "create_at")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@JsonIgnore
	private DateTime createAt;
	@Column(name = "update_at")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@JsonIgnore
	private DateTime updateAt;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGoodId() {
		return goodId;
	}

	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Long getLoveNum() {
		return loveNum;
	}

	public void setLoveNum(Long loveNum) {
		this.loveNum = loveNum;
	}

	public Long getBeanNum() {
		return beanNum;
	}

	public void setBeanNum(Long beanNum) {
		this.beanNum = beanNum;
	}

	public BigDecimal getAmountNum() {
		return amountNum;
	}

	public void setAmountNum(BigDecimal amountNum) {
		this.amountNum = amountNum;
	}

	public Long getMasonryNum() {
		return masonryNum;
	}

	public void setMasonryNum(Long masonryNum) {
		this.masonryNum = masonryNum;
	}

	public Long getPhyModelNum() {
		return phyModelNum;
	}

	public void setPhyModelNum(Long phyModelNum) {
		this.phyModelNum = phyModelNum;
	}

	public Long getLoveModelNum() {
		return loveModelNum;
	}

	public void setLoveModelNum(Long loveModelNum) {
		this.loveModelNum = loveModelNum;
	}

	public Long getBeanModelNum() {
		return beanModelNum;
	}

	public void setBeanModelNum(Long beanModelNum) {
		this.beanModelNum = beanModelNum;
	}

	public Long getRandomModelNum() {
		return randomModelNum;
	}

	public void setRandomModelNum(Long randomModelNum) {
		this.randomModelNum = randomModelNum;
	}

	public BigDecimal getCostMoney() {
		return costMoney;
	}

	public void setCostMoney(BigDecimal costMoney) {
		this.costMoney = costMoney;
	}

	public Integer getCostBean() {
		return costBean;
	}

	public void setCostBean(Integer costBean) {
		this.costBean = costBean;
	}

	public Integer getCostMasonry() {
		return costMasonry;
	}

	public void setCostMasonry(Integer costMasonry) {
		this.costMasonry = costMasonry;
	}

	public Integer getIsPay() {
		return isPay;
	}

	public void setIsPay(Integer isPay) {
		this.isPay = isPay;
	}

	public Integer getIsToAccount() {
		return isToAccount;
	}

	public void setIsToAccount(Integer isToAccount) {
		this.isToAccount = isToAccount;
	}

	public Integer getCostType() {
		return costType;
	}

	public void setCostType(Integer costType) {
		this.costType = costType;
	}


	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	
	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}
	
	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
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

package com.wyc.draw.vo;

import java.math.BigDecimal;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;

@ParamEntityAnnotation
public class RewardVo {

	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	private Long addWisdomNum;
	
	@ParamAnnotation
	private Long subWisdomNum;
	
	@ParamAnnotation
	private Long addIntegralNum;
	
	@ParamAnnotation
	private Long addLoveLifeNum;
	
	@ParamAnnotation
	private Long subLoveLifeNum;
	
	@ParamAnnotation
	private BigDecimal addAmount;
	
	@ParamAnnotation
	private BigDecimal subAmount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getAddWisdomNum() {
		return addWisdomNum;
	}

	public void setAddWisdomNum(Long addWisdomNum) {
		this.addWisdomNum = addWisdomNum;
	}

	public Long getSubWisdomNum() {
		return subWisdomNum;
	}

	public void setSubWisdomNum(Long subWisdomNum) {
		this.subWisdomNum = subWisdomNum;
	}

	public Long getAddIntegralNum() {
		return addIntegralNum;
	}

	public void setAddIntegralNum(Long addIntegralNum) {
		this.addIntegralNum = addIntegralNum;
	}

	public Long getAddLoveLifeNum() {
		return addLoveLifeNum;
	}

	public void setAddLoveLifeNum(Long addLoveLifeNum) {
		this.addLoveLifeNum = addLoveLifeNum;
	}

	public Long getSubLoveLifeNum() {
		return subLoveLifeNum;
	}

	public void setSubLoveLifeNum(Long subLoveLifeNum) {
		this.subLoveLifeNum = subLoveLifeNum;
	}

	public BigDecimal getAddAmount() {
		return addAmount;
	}

	public void setAddAmount(BigDecimal addAmount) {
		this.addAmount = addAmount;
	}

	public BigDecimal getSubAmount() {
		return subAmount;
	}

	public void setSubAmount(BigDecimal subAmount) {
		this.subAmount = subAmount;
	}
	
	
}

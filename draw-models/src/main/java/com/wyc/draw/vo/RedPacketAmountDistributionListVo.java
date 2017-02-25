package com.wyc.draw.vo;

import java.util.List;

import com.wyc.annotation.IdAnnotation;
import com.wyc.annotation.ParamAnnotation;
import com.wyc.annotation.ParamEntityAnnotation;
import com.wyc.draw.domain.RedPacketAmountDistribution;

@ParamEntityAnnotation
public class RedPacketAmountDistributionListVo {

	@IdAnnotation
	private String id;
	
	@ParamAnnotation
	private List<RedPacketAmountDistribution> redPacketAmountDistributions;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<RedPacketAmountDistribution> getRedPacketAmountDistributions() {
		return redPacketAmountDistributions;
	}

	public void setRedPacketAmountDistributions(List<RedPacketAmountDistribution> redPacketAmountDistributions) {
		this.redPacketAmountDistributions = redPacketAmountDistributions;
	}
	
	
}

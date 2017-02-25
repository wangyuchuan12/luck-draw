package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.RedPacketAmountDistribution;
import com.wyc.draw.domain.param.VieDrawInfoParam;
import com.wyc.draw.service.RedPacketAmountDistributionService;
import com.wyc.draw.vo.RedPacketAmountDistributionListVo;

public class RedPacketAmountDistributionFilter extends Filter{

	@Autowired
	private RedPacketAmountDistributionService redPacketAmountDistributionService;
	
	@Override
	public Object handlerBefore(SessionManager sessionManager) throws Exception {
		
		VieDrawInfoParam vieDrawInfoParam = (VieDrawInfoParam)sessionManager.getObject(VieDrawInfoParam.class);
		List<RedPacketAmountDistribution> redPacketAmountDistributions = redPacketAmountDistributionService.findAllByRedPacketIdOrderBySeqAsc(vieDrawInfoParam.getRedPacketId());
		RedPacketAmountDistributionListVo redPacketAmountDistributionListVo = new RedPacketAmountDistributionListVo();
		redPacketAmountDistributionListVo.setRedPacketAmountDistributions(redPacketAmountDistributions);
		return redPacketAmountDistributionListVo;
	}

	@Override
	public Object handlerAfter(SessionManager filterManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerPrivateException(SessionManager filterManager, Method method, Exception e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerPublicException(SessionManager filterManager, Exception e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		// TODO Auto-generated method stub
		return null;
	}

}

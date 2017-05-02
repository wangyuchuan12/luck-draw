package com.wyc.draw.filter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.Dekorn;
import com.wyc.draw.domain.Reward;
import com.wyc.draw.vo.RewardVo;

public class DekornActiveRewardFilter extends Filter{

	
	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		
		String dekornId = httpServletRequest.getParameter("dekorn_id");
		
		Dekorn dekorn = filterManager.findOne(Dekorn.class, dekornId);
		Reward reward = filterManager.findOne(Reward.class,dekorn.getRewardId());
		RewardVo rewardVo = new RewardVo();
		rewardVo.setAddAmount(reward.getAddAmount());
		rewardVo.setAddIntegralNum(reward.getAddIntegralNum());
		rewardVo.setAddLoveLifeNum(reward.getAddLoveLifeNum());
		rewardVo.setAddWisdomNum(reward.getAddWisdomNum());
		rewardVo.setSubAmount(reward.getSubAmount());
		rewardVo.setSubLoveLifeNum(reward.getSubLoveLifeNum());
		rewardVo.setSubWisdomNum(reward.getSubWisdomNum());
		return rewardVo;
	}


	@Override
	public List<Class<? extends Filter>> dependClasses() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}

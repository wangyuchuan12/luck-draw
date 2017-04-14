package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.util.List;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.Dekorn;
import com.wyc.draw.domain.Reward;
import com.wyc.draw.domain.param.PutUpRingParam;
import com.wyc.draw.vo.RewardVo;

public class PutUpRingAgreeFilter extends Filter{

	@Override
	public Object handlerBefore(SessionManager sessionManager) throws Exception {
		PutUpRingParam putUpRingParam = (PutUpRingParam)sessionManager.getObject(PutUpRingParam.class);
		String dekornId = putUpRingParam.getDekornId();
		if(CommonUtil.isEmpty(dekornId)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("您输入的dekornId为空");
			sessionManager.setReturn(true);
			sessionManager.setReturnValue(resultVo);
			return null;
		}
		

		Dekorn dekorn = sessionManager.findOne(Dekorn.class, dekornId);
		dekorn.setStatus(Constant.DEKORN_PROGRESS_STATUS);
		sessionManager.update(dekorn);
		
		Reward reward = sessionManager.findOne(Reward.class,dekorn.getRewardId());
		
		RewardVo rewardVo = new RewardVo();
		rewardVo.setAddWisdomNum(reward.getAddWisdomNum());
		
		sessionManager.save(rewardVo);
		return dekorn;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerPrivateException(SessionManager sessionManager, Method method, Exception e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerPublicException(SessionManager sessionManager, Exception e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		// TODO Auto-generated method stub
		return null;
	}

}

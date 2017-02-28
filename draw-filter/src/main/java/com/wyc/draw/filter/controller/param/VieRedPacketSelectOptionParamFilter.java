package com.wyc.draw.filter.controller.param;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.param.VieSelectOptionParam;
import com.wyc.draw.filter.BaseDrawActionFilter;

public class VieRedPacketSelectOptionParamFilter extends Filter{

	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		
		VieSelectOptionParam vieSelectOptionParam = new VieSelectOptionParam();
		String isTimeout = httpServletRequest.getParameter("is_timeout");
		String memberId = httpServletRequest.getParameter("member_id");
		String optionId = httpServletRequest.getParameter("option_id");
		String problemId = httpServletRequest.getParameter("problem_id");
		String timeLong = httpServletRequest.getParameter("time_long");
		vieSelectOptionParam.setIsTimeout(isTimeout);
		vieSelectOptionParam.setMemberId(memberId);
		vieSelectOptionParam.setOptionId(optionId);
		vieSelectOptionParam.setProblemId(problemId);
		vieSelectOptionParam.setTimeLong(timeLong);
		return vieSelectOptionParam;
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
		List<Class<? extends Filter>> filterClasses = new ArrayList<>();
		filterClasses.add(BaseDrawActionFilter.class);
		return filterClasses;
	}

}

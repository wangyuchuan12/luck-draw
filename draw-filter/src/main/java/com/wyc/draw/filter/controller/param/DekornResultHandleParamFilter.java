package com.wyc.draw.filter.controller.param;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.param.DekornResultParam;
import com.wyc.draw.domain.param.DekornTakepartParam;
import com.wyc.draw.filter.BaseDrawActionFilter;

public class DekornResultHandleParamFilter extends Filter{

	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		String score = httpServletRequest.getParameter("score");
		String takepartId = httpServletRequest.getParameter("takepartId");
		String dekornId = httpServletRequest.getParameter("dekornId");
		DekornResultParam dekornResultParam = new DekornResultParam();
		dekornResultParam.setScore(Long.parseLong(score));
		dekornResultParam.setDekornId(dekornId);
		dekornResultParam.setTakepartMemberId(takepartId);
		
		filterManager.save(dekornResultParam);
		
		DekornTakepartParam dekornTakepartParam = new DekornTakepartParam();
		dekornTakepartParam.setDekornId(dekornId);
		
		filterManager.save(dekornTakepartParam);
		
		return dekornResultParam;
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
		List<Class<? extends Filter>> classes = new ArrayList<>();
		classes.add(BaseDrawActionFilter.class);
		return classes;
	}

}

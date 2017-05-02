package com.wyc.draw.filter.controller.param;
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
	public Object handlerFilter(SessionManager filterManager) throws Exception {
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
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> classes = new ArrayList<>();
		classes.add(BaseDrawActionFilter.class);
		return classes;
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

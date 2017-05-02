package com.wyc.draw.filter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
//红包系统的基类
public class BaseDrawActionFilter extends Filter{

	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		httpServletRequest.setAttribute("title", "问答红包");
		return null;
	}



	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> filterClasses = new ArrayList<>();
		filterClasses.add(DrawUserFilter.class);
		return filterClasses;
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

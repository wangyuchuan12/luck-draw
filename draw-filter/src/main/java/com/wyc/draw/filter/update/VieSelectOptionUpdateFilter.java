package com.wyc.draw.filter.update;

import java.lang.reflect.Method;
import java.util.List;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;

public class VieSelectOptionUpdateFilter extends Filter{

	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
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
		return null;
	}

}

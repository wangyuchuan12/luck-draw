package com.wyc.draw.filter.controller.api;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.filter.BalancePayTakepartFilter;
import com.wyc.draw.filter.controller.param.VieDrawTakepartParamFilter;
import com.wyc.draw.filter.getter.VieTakepartGetterFilter;
import com.wyc.draw.filter.update.BalancePayTakeparUpdateFilter;

public class VieRedPacketBalancePayTakepartFilter extends Filter{

	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
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
		List<Class<? extends Filter>> filterClasses = new ArrayList<>();
		filterClasses.add(VieDrawTakepartParamFilter.class);
		filterClasses.add(VieTakepartGetterFilter.class);
		filterClasses.add(BalancePayTakepartFilter.class);
	//	filterClasses.add(BalancePayTakeparUpdateFilter.class);
		return filterClasses;
	}

}
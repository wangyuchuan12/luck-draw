package com.wyc.draw.filter.controller.api;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.filter.CurrentDekornToTakepartFilter;
import com.wyc.draw.filter.DekornSuccessHandleFilter;
import com.wyc.draw.filter.RewardFilter;
import com.wyc.draw.filter.controller.param.DekornResultHandleParamFilter;

public class DekornSuccessApiFilter extends Filter{

	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		
		
		System.out.println("....................successHandle");
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
		List<Class<? extends Filter>> classes = new ArrayList<>();
		classes.add(DekornResultHandleParamFilter.class);
		classes.add(CurrentDekornToTakepartFilter.class);
		classes.add(DekornSuccessHandleFilter.class);
		classes.add(RewardFilter.class);
		return classes;
	}

}

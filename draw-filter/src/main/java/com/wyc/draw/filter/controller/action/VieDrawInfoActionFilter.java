package com.wyc.draw.filter.controller.action;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.filter.CurrentVieRedPacketToTakepartMemberFilter;
import com.wyc.draw.filter.GetRedPackInfoFilter;
import com.wyc.draw.filter.controller.param.VieDrawInfoParamFilter;

public class VieDrawInfoActionFilter extends Filter{

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
		List<Class<? extends Filter>> filterClasses = new ArrayList<>();
		filterClasses.add(VieDrawInfoParamFilter.class);
		filterClasses.add(CurrentVieRedPacketToTakepartMemberFilter.class);
		filterClasses.add(GetRedPackInfoFilter.class);
		return filterClasses;
	}

}

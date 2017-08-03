package com.wyc.draw.filter.controller.api;

import java.util.ArrayList;
import java.util.List;

import com.wyc.common.filter.BaseActionFilter;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.filter.pay.ChooseWxPayFilter;
import com.wyc.draw.filter.pay.CostFilter;

public class ChooseWxPayApiFilter extends Filter{

	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> filtes = new ArrayList<>();
		filtes.add(BaseActionFilter.class);
		filtes.add(CostFilter.class);
		filtes.add(ChooseWxPayFilter.class);
		return filtes;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}

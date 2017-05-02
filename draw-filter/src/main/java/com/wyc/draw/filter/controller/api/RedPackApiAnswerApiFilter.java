package com.wyc.draw.filter.controller.api;
import java.util.ArrayList;
import java.util.List;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.filter.AnswerRedPackFilter;
import com.wyc.draw.filter.controller.param.VieDrawInfoParamFilter;

public class RedPackApiAnswerApiFilter extends Filter{

	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> filterClasses = new ArrayList<>();
		filterClasses.add(VieDrawInfoParamFilter.class);
		
		filterClasses.add(AnswerRedPackFilter.class);
		
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

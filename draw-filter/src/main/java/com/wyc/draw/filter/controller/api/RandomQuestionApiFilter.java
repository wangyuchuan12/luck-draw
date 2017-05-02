package com.wyc.draw.filter.controller.api;

import java.util.ArrayList;
import java.util.List;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.RandomQuestionFilter;

public class RandomQuestionApiFilter extends Filter{

	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		Object name = sessionManager.getAttribute("name");
		
		System.out.println("name:"+name);
		return null;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		sessionManager.setAttribute("name", "wyc");
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> classes = new ArrayList<>();
		
		classes.add(BaseDrawActionFilter.class);
		
		classes.add(RandomQuestionFilter.class);
		
		return classes;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		System.out.println("...............after");
		return null;
	}

}

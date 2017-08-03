package com.wyc.draw.filter.controller.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.filter.CreateGoodOrderFilter;
import com.wyc.draw.filter.DrawUserFilter;
import com.wyc.draw.filter.GoodOrderMasonryPayFilter;
import com.wyc.draw.filter.RewardFilter;

public class ChooseGoodMasonryPayApiFilter extends Filter{

	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		
		return null;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
	
		HttpServletRequest httpServletRequest = sessionManager.getHttpServletRequest();
		
		String goodId = httpServletRequest.getParameter("goodId");
		String costType = httpServletRequest.getParameter("costType");
		
		sessionManager.setAttribute("goodId", goodId);
		sessionManager.setAttribute("costType", Integer.parseInt(costType));
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> filters = new ArrayList<>();
		filters.add(DrawUserFilter.class);
		filters.add(CreateGoodOrderFilter.class);
		filters.add(GoodOrderMasonryPayFilter.class);
		filters.add(RewardFilter.class);
		return filters;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}

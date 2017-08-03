package com.wyc.draw.filter.controller.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.wyc.common.filter.BaseActionFilter;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.filter.CreateGoodOrderFilter;
import com.wyc.draw.filter.pay.ChooseWxPayFilter;
import com.wyc.draw.filter.pay.CostFilter;

public class ChooseGoodWxPayApiFilter extends Filter{

	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		// TODO Auto-generated method stub
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
		List<Class<? extends Filter>> filtes = new ArrayList<>();
		filtes.add(BaseActionFilter.class);
		filtes.add(CreateGoodOrderFilter.class);
		filtes.add(CostFilter.class);
		filtes.add(ChooseWxPayFilter.class);
		return filtes;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {

		return null;
	}

}

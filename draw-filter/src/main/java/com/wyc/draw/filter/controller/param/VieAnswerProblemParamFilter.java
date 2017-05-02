package com.wyc.draw.filter.controller.param;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.param.VieDrawInfoParam;
import com.wyc.draw.filter.BaseDrawActionFilter;

public class VieAnswerProblemParamFilter extends Filter{

	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		String id = httpServletRequest.getParameter("red_packet_id");
		
		VieDrawInfoParam vieDrawInfoParam = new VieDrawInfoParam();
		vieDrawInfoParam.setRedPacketId(id);
		return vieDrawInfoParam;
	}


	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> filterClasses = new ArrayList<>();
		filterClasses.add(BaseDrawActionFilter.class);
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

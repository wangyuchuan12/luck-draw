package com.wyc.draw.filter.controller.param;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.param.VieDrawInfoParam;
import com.wyc.draw.domain.param.VieDrawTakepartParam;
import com.wyc.draw.filter.BaseDrawActionFilter;

public class VieDrawTakepartParamFilter extends Filter{

	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		String redPacketId = httpServletRequest.getParameter("red_packet_id");
		VieDrawTakepartParam vieDrawTakepartParam = new VieDrawTakepartParam();
		vieDrawTakepartParam.setTakepartId(redPacketId);;
		
		VieDrawInfoParam drawInfoParam = new VieDrawInfoParam();
		drawInfoParam.setRedPacketId(redPacketId);
		filterManager.save(drawInfoParam);
		return vieDrawTakepartParam;
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
		filterClasses.add(BaseDrawActionFilter.class);
		return filterClasses;
	}

}

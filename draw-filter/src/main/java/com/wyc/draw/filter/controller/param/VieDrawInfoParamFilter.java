package com.wyc.draw.filter.controller.param;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.draw.domain.param.VieDrawInfoParam;
import com.wyc.draw.filter.BaseDrawActionFilter;

public class VieDrawInfoParamFilter extends Filter{

	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		String id = httpServletRequest.getParameter("id");
		
		VieDrawInfoParam vieDrawInfoParam = new VieDrawInfoParam();
		vieDrawInfoParam.setRedPacketId(id);
		
		String page = httpServletRequest.getParameter("page");
		String size = httpServletRequest.getParameter("size");
		
		
		
		if(CommonUtil.isEmpty(page)){
			page = "0";
		}
		
		if(CommonUtil.isEmpty(size)){
			size = "10";
		}
		
		int pageInt = Integer.parseInt(page);
		int sizeInt = Integer.parseInt(size);
		
		vieDrawInfoParam.setTakepartMemberPage(pageInt);
		vieDrawInfoParam.setTakepartMemberSize(sizeInt);
		return vieDrawInfoParam;
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

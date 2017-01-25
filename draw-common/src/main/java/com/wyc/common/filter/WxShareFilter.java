package com.wyc.common.filter;

import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.wyc.common.session.SessionManager;

public class WxShareFilter extends Filter{

	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		
		 HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		 httpServletRequest.setAttribute("shareTitle", "城西拼团");
         httpServletRequest.setAttribute("shareInstruction", "城西拼团22");
         httpServletRequest.setAttribute("shareUrl", "http://www.chengxihome.com/");
         httpServletRequest.setAttribute("shareImg", "http://7xlw44.com1.z0.glb.clouddn.com/1fafbd4f-b763-4615-b744-fda59752a96e");
         httpServletRequest.setAttribute("shareType", "link");
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
		// TODO Auto-generated method stub
		return null;
	}

}

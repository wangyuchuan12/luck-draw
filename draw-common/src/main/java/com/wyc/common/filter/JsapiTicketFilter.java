package com.wyc.common.filter;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.wyc.common.domain.vo.WxConfigBean;
import com.wyc.common.filter.service.WxConfigService;
import com.wyc.common.session.SessionManager;
import com.wyc.common.smart.service.WxJsApiTicketSmartService;
import com.wyc.common.wx.domain.JsapiTicketBean;




public class JsapiTicketFilter extends Filter{
	@Autowired
	private WxConfigService wxConfigService;

	@Override
	public Object handlerBefore(SessionManager sessionManager) throws Exception {
		return wxConfigService.getJsapiTicketBean(sessionManager);
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

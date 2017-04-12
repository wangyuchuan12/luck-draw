package com.wyc.common.filter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.wyc.common.filter.service.WxConfigService;
import com.wyc.common.session.SessionManager;
import com.wyc.common.wx.domain.JsapiTicketBean;

public class WxConfigFilter extends Filter{

	
	final static Logger logger = LoggerFactory.getLogger(WxConfigFilter.class);
	
	@Autowired
	private WxConfigService wxConfigService;
	@Override
	public Object handlerBefore(SessionManager sessionManager) throws Exception {
		JsapiTicketBean jsapiTicketBean = (JsapiTicketBean)sessionManager.getObject(JsapiTicketBean.class);
		return wxConfigService.getWxConfigBean(sessionManager, jsapiTicketBean);
	}

	@Override
	public Object handlerAfter(SessionManager filterManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerPrivateException(SessionManager filterManager, Method method, Exception e) {
		e.printStackTrace();
		return null;
	}

	@Override
	public Object handlerPublicException(SessionManager filterManager, Exception e) {
		e.printStackTrace();
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> list = new ArrayList<>();
		list.add(JsapiTicketFilter.class);
		return list;
	}

}

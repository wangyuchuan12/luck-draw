package com.wyc.common.filter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.service.WxUserInfoService;
import com.wyc.common.session.SessionManager;
import com.wyc.common.smart.service.UserSmartService;
import com.wyc.common.wx.domain.UserInfo;
public class SyncUserInfoFilter extends Filter{

	@Autowired
	private UserSmartService userSmartService;
	
	@Autowired
	private WxUserInfoService userService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		UserInfo userInfo = (UserInfo)filterManager.getObject(UserInfo.class);
		String id = userInfo.getId();
		userInfo = userSmartService.getFromAccessToken(userInfo.getOpenid());
		userInfo.setId(id);
		userService.update(userInfo);
		return userInfo;
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
		filterClasses.add(UserInfoFilter.class);
		return filterClasses;
	}

}

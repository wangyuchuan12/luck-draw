package com.wyc.common.filter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.wyc.common.session.SessionManager;
import com.wyc.common.wx.domain.UserInfo;

public class WxShareFilter extends Filter{

	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		
		 UserInfo userInfo = (UserInfo)filterManager.getObject(UserInfo.class);
		 HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		 httpServletRequest.setAttribute("shareTitle", "["+userInfo.getNickname()+"]邀请你一起抢红包");
         httpServletRequest.setAttribute("shareInstruction", "红包社区，等你来抢");
         httpServletRequest.setAttribute("shareUrl", "/view/draw/main/home");
         httpServletRequest.setAttribute("shareImg", userInfo.getHeadimgurl());
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
		List<Class<? extends Filter>> list = new ArrayList<>();
		list.add(UserInfoFilter.class);
		return list;
	}

}

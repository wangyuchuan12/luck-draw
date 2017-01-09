package com.wyc.draw.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.session.SessionManager;
import com.wyc.common.wx.domain.UserInfo;
import com.wyc.draw.filter.BaseDrawActionFilter;

@Controller
@RequestMapping(value="/view/draw/luck_draw")
public class DrawController {
	
	
	@HandlerAnnotation(hanlerFilter=BaseDrawActionFilter.class)
	@RequestMapping(value="info")
	public String drawInfo(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		UserInfo userInfo = (UserInfo)sessionManager.getObject(UserInfo.class);
		return "drawInfo";
	}
	
	@HandlerAnnotation(hanlerFilter=BaseDrawActionFilter.class)
	@RequestMapping(value="add")
	public String addDrawInfo(HttpServletRequest httpServletRequest){
		return "addDrawInfo";
	}
	
	
}

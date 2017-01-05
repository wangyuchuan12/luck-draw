package com.wyc.draw.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wyc.common.session.SessionManager;
import com.wyc.common.wx.domain.UserInfo;

@Controller
public class DrawController {
	
	
//	@HandlerAnnotation(hanlerFilter=BaseActionFilter.class)
//	@ResponseBody
	@RequestMapping(value="/view/draw_info")
	public String drawInfo(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		UserInfo userInfo = (UserInfo)sessionManager.getObject(UserInfo.class);
		
		return "drawInfo";
	}
	
	@RequestMapping(value="/view/add_draw_info")
	public String addDrawInfo(HttpServletRequest httpServletRequest){
		return "addDrawInfo";
	}
	
	
}

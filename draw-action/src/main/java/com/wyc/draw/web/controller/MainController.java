package com.wyc.draw.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wyc.common.session.SessionManager;

@Controller
@RequestMapping(value="/view/draw/main/")
public class MainController {
	
	@RequestMapping(value="home")
	public String drawRooms(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
	
		return "mainView";
	}
	
	
	@RequestMapping(value="test")
	public String test(HttpServletRequest httpServletRequest)throws Exception{
		return "test/test";
	}
}

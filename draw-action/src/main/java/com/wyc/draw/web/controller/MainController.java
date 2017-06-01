package com.wyc.draw.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.filter.BaseDrawActionFilter;

@Controller
@RequestMapping(value="/view/draw/main/")
public class MainController {
	
	@HandlerAnnotation(hanlerFilter=BaseDrawActionFilter.class)
	@RequestMapping(value="home")
	public String drawRooms(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		return "mainView";
	}
	
	@RequestMapping(value="subjectCheck")
	public String subjectCheck(HttpServletRequest httpServletRequest)throws Exception{
		return "mainSubjectCheck";
	}
	
	
	@RequestMapping(value="themeCheck")
	public String themeCheck(HttpServletRequest httpServletRequest)throws Exception{
		return "mainThemeCheck";
	}
	
	
	@RequestMapping(value="test")
	public String test(HttpServletRequest httpServletRequest)throws Exception{
		return "test/test";
	}
}

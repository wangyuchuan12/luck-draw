package com.wyc.draw.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.draw.filter.DrawUserFilter;

@Controller
@RequestMapping(value="/view/draw/mall/")
public class MailController {
	
	
	@HandlerAnnotation(hanlerFilter=DrawUserFilter.class)
	@RequestMapping(value="mainView")
	public String mainView(HttpServletRequest httpServletRequest){
		return "mall";
	}
}

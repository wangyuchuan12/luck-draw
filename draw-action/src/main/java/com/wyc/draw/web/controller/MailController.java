package com.wyc.draw.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/view/draw/mall/")
public class MailController {
	
	@RequestMapping(value="mainView")
	public String mainView(HttpServletRequest httpServletRequest){
		return "mall";
	}
}

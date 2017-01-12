package com.wyc.draw.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/view/draw/personal_center/")
public class PersonalCenter {
	
	@RequestMapping(value="main")
	public String main(HttpServletRequest httpServletRequest){
		return "personalCenter";
	}
	
	
	@RequestMapping(value="takeOut")
	public String takeOut(HttpServletRequest httpServletRequest){
		return "takeOut";
	}
}

package com.wyc.draw.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wyc.annotation.HandlerAnnotation;
import com.wyc.draw.filter.BaseDrawActionFilter;

@Controller
@RequestMapping(value="/view/draw/personal_center/")
public class PersonalCenter {
	
	@HandlerAnnotation(hanlerFilter=BaseDrawActionFilter.class)
	@RequestMapping(value="main")
	public String main(HttpServletRequest httpServletRequest){
		return "personalCenter";
	}
	
	
	@HandlerAnnotation(hanlerFilter=BaseDrawActionFilter.class)
	@RequestMapping(value="takeOut")
	public String takeOut(HttpServletRequest httpServletRequest){
		return "takeOut";
	}
}

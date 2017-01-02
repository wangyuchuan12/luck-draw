package com.wyc.draw.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DrawController {
	
	@RequestMapping(value="/view/draw_info")
	public String drawInfo(HttpServletRequest httpServletRequest){
		return "drawInfo";
	}
}

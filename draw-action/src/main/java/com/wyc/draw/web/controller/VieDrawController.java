package com.wyc.draw.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/view/vie/draw/vie_draw")
public class VieDrawController {
	@RequestMapping(value="info")
	public String list(HttpServletRequest httpServletRequest)throws Exception{
		
		return "vie/vieRedPacket";
	}
}

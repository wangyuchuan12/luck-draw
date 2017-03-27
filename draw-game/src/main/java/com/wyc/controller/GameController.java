package com.wyc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/games")
public class GameController {
	
	@RequestMapping(value="znm123")
	public String znm123(HttpServletRequest httpServletRequest){
		return "znm123";
	}
}

package com.wyc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.draw.filter.BaseDrawActionFilter;

@Controller
@RequestMapping(value="/games")
public class GameController {
	
	@RequestMapping(value="znm123")
	@HandlerAnnotation(hanlerFilter=BaseDrawActionFilter.class)
	public String znm123(HttpServletRequest httpServletRequest){
		
		//0表示新游戏状态 1表示挑战状态
		String status = httpServletRequest.getParameter("status");
		httpServletRequest.setAttribute("status", status);
		return "znm123";
	}
}

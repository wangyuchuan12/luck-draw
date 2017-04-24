package com.wyc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.draw.filter.BaseDrawActionFilter;

@Controller
@RequestMapping(value="/games")
public class GameController {
	
	
	@RequestMapping(value="skipToGame")
	public Object skipToGame(HttpServletRequest httpServletRequest)throws Exception{
		String code = httpServletRequest.getParameter("code");
		if(code.equals("znm123")){
			return znm123(httpServletRequest);
		}
		
		return null;
	}
	@RequestMapping(value="znm123")
	@HandlerAnnotation(hanlerFilter=BaseDrawActionFilter.class)
	public String znm123(HttpServletRequest httpServletRequest)throws Exception{
		//0表示新游戏状态 1表示挑战状态
		String status = httpServletRequest.getParameter("status");
		String isRich = httpServletRequest.getParameter("isRich");
		
		httpServletRequest.setAttribute("isRich", isRich);
		httpServletRequest.setAttribute("status", status);
		
		String passScore = httpServletRequest.getParameter("passScore");
		httpServletRequest.setAttribute("passScore", passScore);
		
		String dekornId = httpServletRequest.getParameter("dekornId");
		
		String takepartId = httpServletRequest.getParameter("takepartId");
		httpServletRequest.setAttribute("takepartId", takepartId);
		httpServletRequest.setAttribute("dekornId",dekornId);
		return "znm123";
	}
}

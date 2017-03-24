package com.wyc.draw.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.DekornToTakepartMember;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.filter.controller.action.GameDekornInfoActionFilter;
import com.wyc.draw.filter.controller.action.SwitchSubjectPlugActionFilter;
import com.wyc.draw.vo.DekornVo;

@Controller
@RequestMapping(value="/view/game/game_dekorn")
public class GameController {


	@HandlerAnnotation(hanlerFilter=GameDekornInfoActionFilter.class)
	@RequestMapping(value="info")
	public String info(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		DekornVo dekornVo = (DekornVo)sessionManager.getObject(DekornVo.class);
		DekornToTakepartMember dekornToTakepartMember = (DekornToTakepartMember)sessionManager.getObject(DekornToTakepartMember.class);
		httpServletRequest.setAttribute("dekornInfo", dekornVo);
		httpServletRequest.setAttribute("dekornToTakepartMember", dekornToTakepartMember);
		return "game/gameDekorn";
	}
	
	@RequestMapping(value="gameCompltePlug")
	public String gameCompletePlug(HttpServletRequest httpServletRequest){
		return "plug/gameCompletePlug";
	}
	
	@HandlerAnnotation(hanlerFilter=SwitchSubjectPlugActionFilter.class)
	@RequestMapping(value="switchSubjectPlug")
	public String switchSubjectPlug(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		DekornVo dekornVo = (DekornVo)sessionManager.getObject(DekornVo.class);
		DrawUser drawUser = (DrawUser)sessionManager.getObject(DrawUser.class);
		httpServletRequest.setAttribute("dekornInfo", dekornVo);
		httpServletRequest.setAttribute("drawUser", drawUser);
		return "plug/switchSubjectPlug";
	}
	
	
}

package com.wyc.draw.web.controller;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wyc.annotation.HandlerAnnotation;
import com.wyc.draw.filter.BaseDrawActionFilter;

@Controller
@RequestMapping(value="/view/game/game_dekorn")
public class DekornController {
	
	@RequestMapping(value="subject")
	public String subject(HttpServletRequest httpServletRequest)throws Exception{
		return "paper/subject";
	}
	
	@HandlerAnnotation(hanlerFilter=BaseDrawActionFilter.class)
	@RequestMapping(value="info")
	public String info(HttpServletRequest httpServletRequest)throws Exception{
		String gameCode = httpServletRequest.getParameter("gameCode");
		
		String isOpenSwitch = httpServletRequest.getParameter("isOpenSwitch");
		
		String id = httpServletRequest.getParameter("id");
		/*
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		DekornVo dekornVo = (DekornVo)sessionManager.getObject(DekornVo.class);
		DekornToTakepartMember dekornToTakepartMember = (DekornToTakepartMember)sessionManager.getObject(DekornToTakepartMember.class);
		httpServletRequest.setAttribute("dekornInfo", dekornVo);
		httpServletRequest.setAttribute("dekornToTakepartMember", dekornToTakepartMember);
		httpServletRequest.setAttribute("gameCode", gameCode);
		httpServletRequest.setAttribute("passScore", dekornVo.getPassScore());
		
		httpServletRequest.setAttribute("isOpenSwitch", isOpenSwitch);*/
		
		httpServletRequest.setAttribute("gameCode", gameCode);
		httpServletRequest.setAttribute("isOpenSwitch", isOpenSwitch);
		httpServletRequest.setAttribute("id", id);
		return "game/gameDekorn";
	}
	
	@RequestMapping(value="gameCompltePlug")
	public String gameCompletePlug(HttpServletRequest httpServletRequest){
		System.out.println(".........sessionid2:"+httpServletRequest.getSession().getId());
		return "plug/gameCompletePlug";
	}
	
	@RequestMapping(value="gameInfo")
	public String gameInfo(HttpServletRequest httpServletRequest){
		return "game/gameInfo";
	}
}

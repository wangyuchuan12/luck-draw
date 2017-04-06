package com.wyc.draw.web.controller;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.DekornToTakepartMember;
import com.wyc.draw.filter.controller.action.GameDekornInfoActionFilter;
import com.wyc.draw.vo.DekornVo;

@Controller
@RequestMapping(value="/view/game/game_dekorn")
public class DekornController {


	@HandlerAnnotation(hanlerFilter=GameDekornInfoActionFilter.class)
	@RequestMapping(value="info")
	public String info(HttpServletRequest httpServletRequest)throws Exception{
		
		System.out.print(".............sessionid:"+httpServletRequest.getSession().getId());
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
}

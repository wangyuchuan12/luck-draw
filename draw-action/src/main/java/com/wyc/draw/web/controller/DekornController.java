package com.wyc.draw.web.controller;
import javax.servlet.http.HttpServletRequest;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wyc.annotation.HandlerAnnotation;
//import com.wyc.common.session.SessionManager;
//import com.wyc.draw.domain.BattleMember;
import com.wyc.draw.filter.BaseDrawActionFilter;
//import com.wyc.draw.filter.controller.api.BattleMemberInfoApiFilter;
//import com.wyc.draw.service.BattleMemberService;

@Controller
@RequestMapping(value="/view/dekorn")
public class DekornController {
	
//	@Autowired
//	private BattleMemberService battleMemberService;
	@RequestMapping(value="subject")
	public String subject(HttpServletRequest httpServletRequest)throws Exception{
		return "paper/subject";
	}
	
	
	@RequestMapping(value="battleInfo")
//	@HandlerAnnotation(hanlerFilter=BattleMemberInfoApiFilter.class)
	public String battleInfo(HttpServletRequest httpServletRequest)throws Exception{
//		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
//		BattleMember battleMember = sessionManager.getObject(BattleMember.class);
//		
//		httpServletRequest.setAttribute("battleMember", battleMember);
//		
//		Long rank = battleMemberService.rank(battleMember);
//		
//		httpServletRequest.setAttribute("rank", rank);
		return "battleInfo";
	}
	
	@RequestMapping(value="progressScore")
	public String progressScore(HttpServletRequest httpServletRequest)throws Exception{
		return "progressScore";
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
		return "dekorn/dekornInfo";
	}
	
	@RequestMapping(value="gameCompltePlug")
	public String gameCompletePlug(HttpServletRequest httpServletRequest){
		return "plug/gameCompletePlug";
	}
	
	@RequestMapping(value="gameInfo")
	public String gameInfo(HttpServletRequest httpServletRequest){
		return "game/gameInfo";
	}
}

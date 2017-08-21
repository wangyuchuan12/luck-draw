package com.wyc.draw.web.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.filter.BaseDrawActionFilter;

@Controller
@RequestMapping(value="/view/plug")
public class PlugController {
	
	@RequestMapping(value="dekornSuccessPlug")
	@HandlerAnnotation(hanlerFilter=BaseDrawActionFilter.class)
	public String dekornSuccessPlug(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		DrawUser drawUser = (DrawUser)sessionManager.getObject(DrawUser.class);
		
		String lifeLoveSolid = httpServletRequest.getParameter("lifeLoveSolid");
		String lifeLoveHollow = httpServletRequest.getParameter("lifeLoveHollow");
		String prompt = httpServletRequest.getParameter("prompt");
		String contents = httpServletRequest.getParameter("contents");
		String[] contentList = contents.split(",");
		httpServletRequest.setAttribute("drawUser", drawUser);
		
		httpServletRequest.setAttribute("lifeLoveSolid", lifeLoveSolid);
		httpServletRequest.setAttribute("lifeLoveHollow", lifeLoveHollow);
		httpServletRequest.setAttribute("prompt", prompt);
		httpServletRequest.setAttribute("contentList", contentList);
		return "plug/dekornSuccessPlug";
	}
	
	@RequestMapping(value="dekornFailPlug")
	@HandlerAnnotation(hanlerFilter=BaseDrawActionFilter.class)
	public String dekornFailPlug(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		DrawUser drawUser = (DrawUser)sessionManager.getObject(DrawUser.class);
		
		String lifeLoveSolid = httpServletRequest.getParameter("lifeLoveSolid");
		String lifeLoveHollow = httpServletRequest.getParameter("lifeLoveHollow");
		String prompt = httpServletRequest.getParameter("prompt");
		String contents = httpServletRequest.getParameter("contents");
		String[] contentList = contents.split(",");
		httpServletRequest.setAttribute("drawUser", drawUser);
		
		httpServletRequest.setAttribute("lifeLoveSolid", lifeLoveSolid);
		httpServletRequest.setAttribute("lifeLoveHollow", lifeLoveHollow);
		httpServletRequest.setAttribute("prompt", prompt);
		httpServletRequest.setAttribute("contentList", contentList);
		return "plug/dekornFailPlug";
	}
	
	@RequestMapping(value="switchSubjectPlug")
	@HandlerAnnotation(hanlerFilter=BaseDrawActionFilter.class)
	public String switchSubjectPlug(HttpServletRequest httpServletRequest)throws Exception{
		
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		String handDrawUserImg = httpServletRequest.getParameter("handDrawUserImg");
		String passScore = httpServletRequest.getParameter("passScore");
		String handDrawUserName = httpServletRequest.getParameter("handDrawUserName");
		String acceptFightSuccessWisdomNum = httpServletRequest.getParameter("acceptFightSuccessWisdomNum");
		String gameName = httpServletRequest.getParameter("gameName");
		
		String modeView = httpServletRequest.getParameter("modeView");
		
		DrawUser drawUser = (DrawUser)sessionManager.getObject(DrawUser.class);
		String myImgUrl = drawUser.getImgUrl();
		String myNickname = drawUser.getNickname();
		
		String fightSuccessWisdomNum = httpServletRequest.getParameter("fightSuccessWisdomNum");
		
		httpServletRequest.setAttribute("handDrawUserImg", handDrawUserImg);
		httpServletRequest.setAttribute("passScore", passScore);
		httpServletRequest.setAttribute("handDrawUserName", handDrawUserName);
		httpServletRequest.setAttribute("acceptFightSuccessWisdomNum", acceptFightSuccessWisdomNum);
		httpServletRequest.setAttribute("gameName", gameName);
		httpServletRequest.setAttribute("myImgUrl", myImgUrl);
		httpServletRequest.setAttribute("myNickname", myNickname);
		httpServletRequest.setAttribute("fightSuccessWisdomNum", fightSuccessWisdomNum);
		
		httpServletRequest.setAttribute("modeView", modeView);
		return "plug/switchSubjectPlug";
	}
	
	@RequestMapping(value="invitationPlug")
	public String invitationPlug(HttpServletRequest httpServletRequest){
		
		String title = httpServletRequest.getParameter("title");
		String title2 = httpServletRequest.getParameter("title2");
		String wisdomNum = httpServletRequest.getParameter("wisdomNum");
		
		String id = httpServletRequest.getParameter("id");
		
		httpServletRequest.setAttribute("title", title);
		httpServletRequest.setAttribute("title2", title2);
		httpServletRequest.setAttribute("wisdomNum", wisdomNum);
		
		httpServletRequest.setAttribute("id", id);
		return "plug/invitationPlug";
	}
	
	@RequestMapping(value="confirmPlug")
	public String confirmPlug(HttpServletRequest httpServletRequest){
		return "plug/confirmPlug";
	}
	
	@RequestMapping(value="alertPlug")
	public String alertPlug(HttpServletRequest httpServletRequest){
		return "plug/alertPlug";
	}
	
	@RequestMapping(value="rankRewardPlug")
	public String rankRewardPlug(HttpServletRequest httpServletRequest){
		return "plug/rankRewardPlug";
	}
	
	@RequestMapping(value="attrPlug")
	public String attrPlug(HttpServletRequest httpServletRequest){
		return "plug/attrPlug";
	}
	
	@RequestMapping(value="modelPlug")
	public String modelPlug(HttpServletRequest httpServletRequest){
		return "plug/modelPlug";
	}
	
	@RequestMapping(value="preload")
	public String preload(HttpServletRequest httpServletRequest){
		return "plug/preload";
	}
	
	@RequestMapping(value="battleMainPlug")
	public String battleMainPlug(HttpServletRequest httpServletRequest){
		return "plug/battleMainPlug";
	}
	
	@RequestMapping(value="battleInfoPlug")
	public String battleInfoPlug(HttpServletRequest httpServletRequest){
		return "plug/battleInfoPlug";
	}
	
	@RequestMapping(value="picSelect")
	public String picSelect(HttpServletRequest httpServletRequest){
		return "plug/picSelect";
	}
}

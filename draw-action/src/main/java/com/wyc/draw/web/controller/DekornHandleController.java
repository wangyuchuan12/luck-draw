package com.wyc.draw.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.Dekorn;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.controller.action.SwitchSubjectPlugActionFilter;
import com.wyc.draw.filter.controller.api.CreateDekornApiFilter;
import com.wyc.draw.filter.controller.api.DekornFailApiFilter;
import com.wyc.draw.filter.controller.api.DekornSuccessApiFilter;
import com.wyc.draw.vo.DekornVo;

@Controller
@RequestMapping(value="/view/dekornHandle")
public class DekornHandleController {
	
	@HandlerAnnotation(hanlerFilter=BaseDrawActionFilter.class)
	@RequestMapping(value="dekornResult")
	public Object dekornResult(HttpServletRequest httpServletRequest)throws Exception{
		String dekornId = httpServletRequest.getParameter("dekornId");
		String score = httpServletRequest.getParameter("score");
		Long scoreInt = Long.parseLong(score);
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		Dekorn dekorn = sessionManager.findOne(Dekorn.class, dekornId);
		Long passScore = dekorn.getPassScore();
		if(scoreInt>=passScore){
			return dekornSuccess(httpServletRequest);
		}else{
			return dekornFail(httpServletRequest);
		}
	}
	
	@RequestMapping(value="dekornSuccess")
	@HandlerAnnotation(hanlerFilter=DekornSuccessApiFilter.class)
	public Object dekornSuccess(HttpServletRequest httpServletRequest)throws Exception{
//		String dekornId = httpServletRequest.getParameter("dekornId");
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
//		Dekorn dekorn = sessionManager.findOne(Dekorn.class, dekornId);
		
		DrawUser drawUser = (DrawUser)sessionManager.getObject(DrawUser.class);
		
		ResultVo resultVo = (ResultVo)sessionManager.getObject(ResultVo.class);
		
		System.out.println("....................resultVo:"+resultVo);
		
		
		System.out.println("*****************drawUser:"+drawUser);
		Map<String, String> params = new HashMap<>();
		params.put("lifeLoveSolid", "4");
		params.put("lifeLoveHollow", "2");
		params.put("prompt", "恭喜您，挑战成功");
		params.put("contents", "智慧豆：40,经验：20,爱心：22");
		params.put("token", "1");
		ModelAndView modelAndView = new ModelAndView("redirect:/view/plug/dekornSuccessPlug",params);
		
		return modelAndView;
	}
	
	@RequestMapping(value="dekornFail")
	@HandlerAnnotation(hanlerFilter=DekornFailApiFilter.class)
	public Object dekornFail(HttpServletRequest httpServletRequest){
		
		Map<String, String> params = new HashMap<>();
		params.put("lifeLoveSolid", "4");
		params.put("lifeLoveHollow", "2");
		params.put("prompt", "恭喜您，挑战成功");
		params.put("contents", "智慧豆：40,经验：20,爱心：22");
		params.put("token", "1");
		ModelAndView modelAndView = new ModelAndView("redirect:/view/plug/dekornFailPlug",params);
		
		return modelAndView;
	}
	
	@HandlerAnnotation(hanlerFilter=SwitchSubjectPlugActionFilter.class)
	@RequestMapping(value="switchSubjectPlug")
	public Object switchSubjectPlug(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		DekornVo dekornVo = (DekornVo)sessionManager.getObject(DekornVo.class);
		DrawUser drawUser = (DrawUser)sessionManager.getObject(DrawUser.class);
		
		
		Map<String, String> params = new HashMap<>();
		String modeView = httpServletRequest.getParameter("modeView");
		params.put("handDrawUserImg", dekornVo.getHandDrawUserImg());
		params.put("passScore", dekornVo.getPassScore()+"");
		params.put("handDrawUserName", dekornVo.getHandDrawUserName());
		params.put("acceptFightSuccessWisdomNum", dekornVo.getAcceptFightSuccessWisdomNum()+"");
		params.put("gameName", dekornVo.getGameName());
		params.put("myImgUrl", drawUser.getImgUrl());
		params.put("myNickname", drawUser.getNickname());
		params.put("modeView", modeView);
		params.put("fightSuccessWisdomNum", dekornVo.getFightSuccessWisdomNum()+"");
		ModelAndView modelAndView = new ModelAndView("redirect:/view/plug/switchSubjectPlug",params);
		return modelAndView;
	}
	

	@HandlerAnnotation(hanlerFilter=CreateDekornApiFilter.class)
	@RequestMapping(value="invitationPlug")
	public Object invitationPlug(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		ResultVo resultVo = (ResultVo)sessionManager.getObject(ResultVo.class);
		if(resultVo!=null&&resultVo.isSuccess()){
			Map<String, String> params = new HashMap<>();
			ModelAndView modelAndView = new ModelAndView("redirect:/view/plug/invitationPlug",params);
			return modelAndView;
		}else{
			
			resultVo = (ResultVo)sessionManager.getReturnValue();

			return null;
		}
	}
}

package com.wyc.draw.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.filter.controller.action.SwitchSubjectPlugActionFilter;
import com.wyc.draw.vo.DekornVo;

@Controller
@RequestMapping(value="/dekornHandle")
public class DekornHandleController {
	
	
	@RequestMapping(value="dekornSuccess")
	public Object dekornSuccess(HttpServletRequest httpServletRequest){
		
		Map<String, String> params = new HashMap<>();
		params.put("lifeLoveSolid", "4");
		params.put("lifeLoveHollow", "2");
		params.put("prompt", "恭喜您，挑战成功");
		params.put("contents", "智慧豆：40,经验：20,爱心：22");
		params.put("token", "1");
		ModelAndView modelAndView = new ModelAndView("redirect:/plug/dekornSuccessPlug",params);
		
		return modelAndView;
	}
	
	@RequestMapping(value="dekornFail")
	public Object dekornFail(HttpServletRequest httpServletRequest){
		
		Map<String, String> params = new HashMap<>();
		params.put("lifeLoveSolid", "4");
		params.put("lifeLoveHollow", "2");
		params.put("prompt", "恭喜您，挑战成功");
		params.put("contents", "智慧豆：40,经验：20,爱心：22");
		params.put("token", "1");
		ModelAndView modelAndView = new ModelAndView("redirect:/plug/dekornFailPlug",params);
		
		return modelAndView;
	}
	
	@HandlerAnnotation(hanlerFilter=SwitchSubjectPlugActionFilter.class)
	@RequestMapping(value="switchSubjectPlug")
	public Object switchSubjectPlug(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		DekornVo dekornVo = (DekornVo)sessionManager.getObject(DekornVo.class);
		DrawUser drawUser = (DrawUser)sessionManager.getObject(DrawUser.class);
		
		
		Map<String, String> params = new HashMap<>();
		params.put("handDrawUserImg", dekornVo.getHandDrawUserImg());
		params.put("passScore", dekornVo.getPassScore()+"");
		params.put("handDrawUserName", dekornVo.getHandDrawUserName());
		params.put("acceptFightSuccessWisdomNum", dekornVo.getAcceptFightSuccessWisdomNum()+"");
		params.put("gameName", dekornVo.getGameName());
		params.put("myImgUrl", drawUser.getImgUrl());
		params.put("myNickname", drawUser.getNickname());
		params.put("fightSuccessWisdomNum", dekornVo.getFightSuccessWisdomNum()+"");
		ModelAndView modelAndView = new ModelAndView("redirect:/plug/switchSubjectPlug",params);
		return modelAndView;
	}
}

package com.wyc.draw.web.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.draw.domain.Dekorn;
import com.wyc.draw.domain.DekornToTakepartMember;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.param.DekornResultParam;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.controller.action.SwitchSubjectPlugActionFilter;
import com.wyc.draw.filter.controller.api.CreateDekornApiFilter;
import com.wyc.draw.filter.controller.api.DekornFailApiFilter;
import com.wyc.draw.filter.controller.api.DekornSuccessApiFilter;
import com.wyc.draw.vo.DekornVo;
import com.wyc.draw.vo.RewardVo;

@Controller
@RequestMapping(value="/view/dekornHandle")
public class DekornHandleController {

	private String getContents(RewardVo rewardVo,Long passScore , Long score){
		StringBuffer sb = new StringBuffer();
		BigDecimal addAmount = rewardVo.getAddAmount();
		BigDecimal subAmount = rewardVo.getSubAmount();
		Long addIntegralNum = rewardVo.getAddIntegralNum();
		Long addLoveLifeNum = rewardVo.getAddLoveLifeNum();
		Long addWisdomNum = rewardVo.getAddWisdomNum();
		Long subLoveLifeNum = rewardVo.getSubLoveLifeNum();
		Long subWisdomNum = rewardVo.getSubWisdomNum();
		
		sb.append("挑战分数："+passScore+",");
		sb.append("我的得分："+score+",");
		if(addAmount!=null&&addAmount.intValue()>0){
			sb.append("金额 +"+addAmount+",");
		}
		
		if(subAmount!=null&&subAmount.intValue()>0){
			sb.append("金额 -"+subAmount+",");
		}
		
		if(addIntegralNum!=null&&addIntegralNum>0){
			sb.append("经验 +"+addIntegralNum+",");
		}
		
		if(addLoveLifeNum!=null&&addLoveLifeNum>0){
			sb.append("爱心 +"+addLoveLifeNum+",");
		}
		
		if(subLoveLifeNum!=null&&subLoveLifeNum>0){
			sb.append("爱心 -"+subLoveLifeNum+",");
		}
		
		if(addWisdomNum!=null&&addWisdomNum>0){
			sb.append("智慧豆 +"+addWisdomNum+",");
		}
		
		if(subWisdomNum!=null&&subWisdomNum>0){
			sb.append("智慧豆 -"+subWisdomNum+",");
		}
		
		
		if(!CommonUtil.isEmpty(sb.toString())){
			sb = sb.deleteCharAt(sb.lastIndexOf(","));
			return sb.toString();
		}
		return "";
	}
	
	
	@Transactional
	@RequestMapping(value="dekornSuccess")
	@HandlerAnnotation(hanlerFilter=DekornSuccessApiFilter.class)
	public Object dekornSuccess(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		
		DekornToTakepartMember dekornToTakepartMember = (DekornToTakepartMember)sessionManager.getObject(DekornToTakepartMember.class);
		
		RewardVo rewardVo = (RewardVo)sessionManager.getObject(RewardVo.class);
		Dekorn dekorn = sessionManager.findOne(Dekorn.class, dekornToTakepartMember.getDekornId());
		
		DekornResultParam dekornResultParam = (DekornResultParam)sessionManager.getObject(DekornResultParam.class);
		String contents = getContents(rewardVo,dekorn.getPassScore(),dekornResultParam.getScore());
		Map<String, String> params = new HashMap<>();
		params.put("lifeLoveSolid", dekornToTakepartMember.getResidueLifeLove()+"");
		params.put("lifeLoveHollow",(dekornToTakepartMember.getLoveLifeCount()-dekornToTakepartMember.getResidueLifeLove())+"");
		params.put("prompt", "恭喜您，挑战成功");
		params.put("contents", contents);
		ModelAndView modelAndView = new ModelAndView("redirect:/view/plug/dekornSuccessPlug",params);
		
		return modelAndView;
	}
	
	
	@Transactional
	@RequestMapping(value="dekornFail")
	@HandlerAnnotation(hanlerFilter=DekornFailApiFilter.class)
	public Object dekornFail(HttpServletRequest httpServletRequest)throws Exception{
		
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		DekornToTakepartMember dekornToTakepartMember = (DekornToTakepartMember)sessionManager.getObject(DekornToTakepartMember.class);
		
		Dekorn dekorn = sessionManager.findOne(Dekorn.class, dekornToTakepartMember.getDekornId());
		
		RewardVo rewardVo = (RewardVo)sessionManager.getObject(RewardVo.class);
		
		DekornResultParam dekornResultParam = (DekornResultParam)sessionManager.getObject(DekornResultParam.class);
		String contents = getContents(rewardVo,dekorn.getPassScore(),dekornResultParam.getScore());
		Map<String, String> params = new HashMap<>();
		params.put("lifeLoveSolid", dekornToTakepartMember.getResidueLifeLove()+"");
		params.put("lifeLoveHollow",(dekornToTakepartMember.getLoveLifeCount()-dekornToTakepartMember.getResidueLifeLove())+"");
		params.put("prompt", "很遗憾，挑战失败");
		params.put("contents", contents);
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

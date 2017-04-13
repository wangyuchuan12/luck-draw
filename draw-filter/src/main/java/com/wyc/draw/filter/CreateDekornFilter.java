package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.Dekorn;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.Game;
import com.wyc.draw.domain.Reward;
import com.wyc.draw.service.DekornService;
import com.wyc.draw.service.RewardService;

public class CreateDekornFilter extends Filter{
	@Autowired
	private DekornService dekornService;
	
	@Autowired
	private RewardService rewardService;
	@Override
	public Object handlerBefore(SessionManager sessionManager) throws Exception {
		HttpServletRequest httpServletRequest = sessionManager.getHttpServletRequest();
		
		String gameId  = httpServletRequest.getParameter("gameId");
		
		String type = httpServletRequest.getParameter("type");
		
		String gameCode = httpServletRequest.getParameter("gameCode");
		
		String passScore = httpServletRequest.getParameter("passScore");
		
		if(CommonUtil.isEmpty(gameId)){
			ResultVo errorResultVo = new ResultVo();
			errorResultVo.setSuccess(false);
			errorResultVo.setErrorMsg("gameId参数不能为空");
			sessionManager.setReturn(true);
			sessionManager.setReturnValue(errorResultVo);
			return null;
		}
		
		if(CommonUtil.isEmpty(type)){
			ResultVo errorResultVo = new ResultVo();
			errorResultVo.setSuccess(false);
			errorResultVo.setErrorMsg("type参数不能为空");
			sessionManager.setReturn(true);
			sessionManager.setReturnValue(errorResultVo);
			return null;
		}
		
		if(CommonUtil.isEmpty(gameCode)){
			ResultVo errorResultVo = new ResultVo();
			errorResultVo.setSuccess(false);
			errorResultVo.setErrorMsg("gameCode参数不能为空");
			sessionManager.setReturn(true);
			sessionManager.setReturnValue(errorResultVo);
			return null;
		}
		
		if(CommonUtil.isEmpty(passScore)){
			ResultVo errorResultVo = new ResultVo();
			errorResultVo.setSuccess(false);
			errorResultVo.setErrorMsg("passScore参数不能为空");
			sessionManager.setReturn(true);
			sessionManager.setReturnValue(errorResultVo);
			return null;
		}
		
		Game game = sessionManager.findOne(Game.class, gameId);
		
		if(game==null){
			ResultVo errorResultVo = new ResultVo();
			errorResultVo.setSuccess(false);
			errorResultVo.setErrorMsg("所对应的game记录不能为空");
			sessionManager.setReturn(true);
			sessionManager.setReturnValue(errorResultVo);
			return null;
		}
		
		if(!game.getCode().equals(gameCode)){
			ResultVo errorResultVo = new ResultVo();
			errorResultVo.setSuccess(false);
			errorResultVo.setErrorMsg("所传的gameCode参数有问题");
			sessionManager.setReturn(true);
			sessionManager.setReturnValue(errorResultVo);
			return null;
		}
		
		Long passScoreLong = Long.parseLong(passScore);
		
		Integer typeInt = Integer.parseInt(type);
		
		DrawUser drawUser = (DrawUser)sessionManager.getObject(DrawUser.class);
		
		Reward reward = new Reward();
		reward.setAddAmount(rewardAmount(sessionManager));
		reward.setAddIntegralNum(rewardIntegralNum(sessionManager));
		reward.setAddLoveLifeNum(rewardLoveLifeNum(sessionManager));
		reward.setAddWisdomNum(rewardWisdomNum(sessionManager));
		
		rewardService.add(reward);
		
		Dekorn dekorn = new Dekorn();
	
		dekorn.setRewardId(reward.getId());
		
		dekorn.setFightSuccessWisdomNum(getFightSuccessWisdomNum(sessionManager));
		dekorn.setFightFailWisdomNum(getFightFailWisdomNum(sessionManager));
		dekorn.setFightSuccessIntegralNum(getFightSuccessIntegralNum(sessionManager));
		dekorn.setFightFailIntegralNum(getFightFailIntegralNum(sessionManager));
		dekorn.setAcceptFightSuccessWisdomNum(getAcceptFightSuccessWisdomNum(sessionManager));
		dekorn.setAcceptFightFailWisdomNum(getAcceptFightFailWisdomNum(sessionManager));
		dekorn.setAcceptFightSuccessIntegralNum(getAcceptFightSuccessIntegralNum(sessionManager));
		dekorn.setAcceptFightFailIntegralNum(getAcceptFightFailIntegralNum(sessionManager));
		dekorn.setPraiseWisdomNum(getPraiseWisdomNum(sessionManager));
		dekorn.setPraiseIntegralNum(getPraiseIntegralNum(sessionManager));
		dekorn.setTakepartCount(getTakepartCount(sessionManager));
		dekorn.setTakepartSuccessCount(getTakepartSuccessCount(sessionManager));
		dekorn.setTakepartFailCount(getTakepartFailCount(sessionManager));
		dekorn.setHighestScore(getHighestScore(sessionManager));
		dekorn.setAverageScore(getAverageScore(sessionManager));
		
		dekorn.setGameId(gameId);
		
		dekorn.setType(typeInt);
		
		dekorn.setGameCode(gameCode);
		
		dekorn.setHandDrawUserId(drawUser.getId());
		
		dekorn.setHandDrawUserImg(drawUser.getImgUrl());
		
		dekorn.setItemImg(game.getItemImgUrl());
		
		dekorn.setHandDrawUserName(drawUser.getNickname());
		
		dekorn.setPassScore(passScoreLong);
		
		dekorn.setStatus(Constant.DEKORN_FREE_STATUS);
		
		dekornService.add(dekorn);
	


		return dekorn;
	}
	

	private Long rewardWisdomNum(SessionManager sessionManager){
		return 50l;
	}

	private Long rewardIntegralNum(SessionManager sessionManager){
		return  0l;
	}

	private Long rewardLoveLifeNum(SessionManager sessionManager){
		return 0l;
	}
	
	private BigDecimal rewardAmount(SessionManager sessionManager){
		return new BigDecimal(0);
	}
	
	
	
	private Long getFightSuccessWisdomNum(SessionManager sessionManager){
		return 0l;
	}
	
	private Long getFightFailWisdomNum(SessionManager sessionManager){
		return 0l;
	}
	
	private Long getFightSuccessIntegralNum(SessionManager sessionManager){
		return 0l;
	}
	
	private Long getFightFailIntegralNum(SessionManager sessionManager){
		return 0l;
	}
	
	private Long getAcceptFightSuccessWisdomNum(SessionManager sessionManager){
		return 0l;
	}
	
	private Long getAcceptFightFailWisdomNum(SessionManager sessionManager){
		return 0l;
	}
	
	private Long getAcceptFightSuccessIntegralNum(SessionManager sessionManager){
		return 0l;
	}
	private Long getAcceptFightFailIntegralNum(SessionManager sessionManager){
		return 0l;
	}
	private Long getPraiseWisdomNum(SessionManager sessionManager){
		return 0l;
	}
	private Long getPraiseIntegralNum(SessionManager sessionManager){
		return 0l;
	}
	private Long getTakepartCount(SessionManager sessionManager){
		return 0l;
	}
	private Long getTakepartSuccessCount(SessionManager sessionManager){
		return 0l;
	}
	private Long getTakepartFailCount(SessionManager sessionManager){
		return 0l;
	}
	private Long getHighestScore(SessionManager sessionManager){
		return 0l;
	}
	private Long getAverageScore(SessionManager sessionManager){
		return 0l;
	}

	@Override
	public Object handlerAfter(SessionManager filterManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerPrivateException(SessionManager filterManager, Method method, Exception e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerPublicException(SessionManager filterManager, Exception e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		return null;
	}

}

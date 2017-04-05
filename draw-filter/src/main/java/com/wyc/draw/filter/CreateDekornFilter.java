package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.Dekorn;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.Game;
import com.wyc.draw.service.DekornService;

public class CreateDekornFilter extends Filter{
	@Autowired
	private DekornService dekornService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		
		String gameId  = httpServletRequest.getParameter("gameId");
		
		String type = httpServletRequest.getParameter("type");
		
		String gameType = httpServletRequest.getParameter("gameType");
		
		String passScore = httpServletRequest.getParameter("passScore");
		
		Long passScoreLong = Long.parseLong(passScore);
		
		Integer gameTypeInt = Integer.parseInt(gameType);
		
		Integer typeInt = Integer.parseInt(type);
		
		DrawUser drawUser = (DrawUser)filterManager.getObject(DrawUser.class);
		
		Game game = filterManager.findOne(Game.class, gameId);
		
		Dekorn dekorn = new Dekorn();
	
		
		dekorn.setFightSuccessWisdomNum(getFightSuccessWisdomNum(filterManager));
		dekorn.setFightFailWisdomNum(getFightFailWisdomNum(filterManager));
		dekorn.setFightSuccessIntegralNum(getFightSuccessIntegralNum(filterManager));
		dekorn.setFightFailIntegralNum(getFightFailIntegralNum(filterManager));
		dekorn.setAcceptFightSuccessWisdomNum(getAcceptFightSuccessWisdomNum(filterManager));
		dekorn.setAcceptFightFailWisdomNum(getAcceptFightFailWisdomNum(filterManager));
		dekorn.setAcceptFightSuccessIntegralNum(getAcceptFightSuccessIntegralNum(filterManager));
		dekorn.setAcceptFightFailIntegralNum(getAcceptFightFailIntegralNum(filterManager));
		dekorn.setPraiseWisdomNum(getPraiseWisdomNum(filterManager));
		dekorn.setPraiseIntegralNum(getPraiseIntegralNum(filterManager));
		dekorn.setTakepartCount(getTakepartCount(filterManager));
		dekorn.setTakepartSuccessCount(getTakepartSuccessCount(filterManager));
		dekorn.setTakepartFailCount(getTakepartFailCount(filterManager));
		dekorn.setHighestScore(getHighestScore(filterManager));
		dekorn.setAverageScore(getAverageScore(filterManager));
		
		dekorn.setGameId(gameId);
		
		dekorn.setType(typeInt);
		
		dekorn.setGameType(gameTypeInt);
		
		dekorn.setHandDrawUserId(drawUser.getId());
		
		dekorn.setHandDrawUserImg(drawUser.getImgUrl());
		
		dekorn.setItemImg(game.getItemImgUrl());
		
		dekorn.setHandDrawUserName(drawUser.getNickname());
		
		dekorn.setPassScore(passScoreLong);
		
		dekornService.add(dekorn);
	

		return dekorn;
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
		// TODO Auto-generated method stub
		return null;
	}

}

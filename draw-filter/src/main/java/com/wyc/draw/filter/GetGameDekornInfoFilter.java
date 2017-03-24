package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.util.List;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.Dekorn;
import com.wyc.draw.domain.Game;
import com.wyc.draw.domain.param.GameDekornInfoParam;
import com.wyc.draw.vo.DekornVo;

public class GetGameDekornInfoFilter extends Filter{
	
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		GameDekornInfoParam gameDekornInfoParam = (GameDekornInfoParam)filterManager.getObject(GameDekornInfoParam.class);
		Dekorn dekorn = filterManager.findOne(Dekorn.class, gameDekornInfoParam.getDekornId());
		Game game = filterManager.findOne(Game.class, dekorn.getGameId());
		
		DekornVo dekornVo = new DekornVo();
		
		dekornVo.setId(dekorn.getId());
		dekornVo.setType(dekornVo.getType());
		dekornVo.setGameId(dekornVo.getGameId());
		dekornVo.setTestPaperId(dekornVo.getTestPaperId());
		dekornVo.setHandDrawUserId(dekornVo.getHandDrawUserId());
		dekornVo.setHandDrawUserImg(dekornVo.getHandDrawUserImg());
		dekornVo.setPassScore(dekornVo.getPassScore());
		dekornVo.setItemImg(dekornVo.getItemImg());
		dekornVo.setFightSuccessWisdomNum(dekornVo.getFightSuccessWisdomNum());
		dekornVo.setFightFailWisdomNum(dekornVo.getFightFailWisdomNum());
		dekornVo.setFightSuccessIntegralNum(dekornVo.getFightSuccessIntegralNum());
		dekornVo.setFightFailIntegralNum(dekornVo.getFightFailIntegralNum());
		dekornVo.setAcceptFightSuccessWisdomNum(dekornVo.getAcceptFightSuccessWisdomNum());
		dekornVo.setAcceptFightFailWisdomNum(dekornVo.getAcceptFightFailWisdomNum());
		dekornVo.setAcceptFightSuccessIntegralNum(dekornVo.getAcceptFightSuccessIntegralNum());
		dekornVo.setAcceptFightFailIntegralNum(dekornVo.getAcceptFightFailIntegralNum());
		dekornVo.setPraiseWisdomNum(dekornVo.getPraiseWisdomNum());
		dekornVo.setPraiseIntegralNum(dekornVo.getPraiseIntegralNum());
		dekornVo.setTakepartCount(dekornVo.getTakepartCount());
		dekornVo.setTakepartSuccessCount(dekornVo.getTakepartSuccessCount());
		dekornVo.setTakepartFailCount(dekornVo.getTakepartFailCount());
		dekornVo.setHighestScore(dekornVo.getHighestScore());
		dekornVo.setAverageScore(dekornVo.getAverageScore());
		dekornVo.setGameUrl(game.getUrl());
		return dekornVo;
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

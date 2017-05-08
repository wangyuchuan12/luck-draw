package com.wyc.draw.filter;
import java.util.List;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.Dekorn;
import com.wyc.draw.domain.Game;
import com.wyc.draw.domain.param.GameDekornInfoParam;
import com.wyc.draw.vo.DekornVo;

public class GetGameDekornInfoFilter extends Filter{
	
	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		GameDekornInfoParam gameDekornInfoParam = (GameDekornInfoParam)filterManager.getObject(GameDekornInfoParam.class);
		Dekorn dekorn = filterManager.findOne(Dekorn.class, gameDekornInfoParam.getDekornId());
		Game game = filterManager.findOne(Game.class, dekorn.getGameId());
		
		DekornVo dekornVo = new DekornVo();
		
		dekornVo.setId(dekorn.getId());
		dekornVo.setType(dekorn.getType());
		dekornVo.setGameId(dekorn.getGameId());
		dekornVo.setHandDrawUserId(dekorn.getHandDrawUserId());
		dekornVo.setHandDrawUserImg(dekorn.getHandDrawUserImg());
		dekornVo.setHandDrawUserName(dekorn.getHandDrawUserName());
		dekornVo.setPassScore(dekorn.getPassScore());
		dekornVo.setItemImg(dekorn.getItemImg());
		dekornVo.setFightSuccessWisdomNum(dekorn.getFightSuccessWisdomNum());
		dekornVo.setFightFailWisdomNum(dekorn.getFightFailWisdomNum());
		dekornVo.setFightSuccessIntegralNum(dekorn.getFightSuccessIntegralNum());
		dekornVo.setFightFailIntegralNum(dekorn.getFightFailIntegralNum());
		dekornVo.setAcceptFightSuccessWisdomNum(dekorn.getAcceptFightSuccessWisdomNum());
		dekornVo.setAcceptFightFailWisdomNum(dekorn.getAcceptFightFailWisdomNum());
		dekornVo.setAcceptFightSuccessIntegralNum(dekorn.getAcceptFightSuccessIntegralNum());
		dekornVo.setAcceptFightFailIntegralNum(dekorn.getAcceptFightFailIntegralNum());
		dekornVo.setPraiseWisdomNum(dekorn.getPraiseWisdomNum());
		dekornVo.setPraiseIntegralNum(dekorn.getPraiseIntegralNum());
		dekornVo.setTakepartCount(dekorn.getTakepartCount());
		dekornVo.setTakepartSuccessCount(dekorn.getTakepartSuccessCount());
		dekornVo.setTakepartFailCount(dekorn.getTakepartFailCount());
		dekornVo.setHighestScore(dekorn.getHighestScore());
		dekornVo.setAverageScore(dekorn.getAverageScore());
		dekornVo.setGameUrl(game.getUrl());
		dekornVo.setGameName(game.getName());
		
		dekornVo.setPaperId(dekorn.getPaperId());
		return dekornVo;
	}


	@Override
	public List<Class<? extends Filter>> dependClasses() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.wyc.draw.filter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.GameToDrawUser;
import com.wyc.draw.domain.param.GameParam;
import com.wyc.draw.service.GameToDrawUserService;

public class CurrentGameToDrawUserFilter extends Filter{
	@Autowired
	private GameToDrawUserService gameToDrawUserService;
	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		
		GameParam gameParam = (GameParam)filterManager.getObject(GameParam.class);
		String gameId = gameParam.getGameId();
		DrawUser drawUser = (DrawUser)filterManager.getObject(DrawUser.class);
		
		GameToDrawUser gameToDrawUser = gameToDrawUserService.findOneByGameIdAndDrawUserId(gameId,drawUser.getId());
		if(gameToDrawUser==null){
			gameToDrawUser = initGameToDrawUser(drawUser,gameId);
			gameToDrawUser = gameToDrawUserService.add(gameToDrawUser);
		}
		return gameToDrawUser;
	}
	
	public GameToDrawUser initGameToDrawUser(DrawUser drawUser,String gameId){
		GameToDrawUser gameToDrawUser = new GameToDrawUser();
		gameToDrawUser.setDrawUserId(drawUser.getId());
		gameToDrawUser.setGameId(gameId);
		gameToDrawUser.setInitiateCount(0);
		gameToDrawUser.setTakepartCount(0);
		return gameToDrawUser;
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

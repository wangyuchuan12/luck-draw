package com.wyc.draw.filter.controller.param;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.param.DekornTakepartParam;
import com.wyc.draw.domain.param.GameDekornInfoParam;
import com.wyc.draw.filter.BaseDrawActionFilter;


//游戏挑战信息详情参数过滤器
public class GameDekornInfoParamFilter extends Filter{

	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		GameDekornInfoParam gameDekornInfoParam = new GameDekornInfoParam();
		
		String dekornId = httpServletRequest.getParameter("id");
		gameDekornInfoParam.setDekornId(dekornId);
		
		DekornTakepartParam dekornTakepartParam = new DekornTakepartParam();
		dekornTakepartParam.setDekornId(dekornId);
		filterManager.save(dekornTakepartParam);
		return gameDekornInfoParam;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> filterClasses = new ArrayList<>();
		filterClasses.add(BaseDrawActionFilter.class);
		return filterClasses;
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

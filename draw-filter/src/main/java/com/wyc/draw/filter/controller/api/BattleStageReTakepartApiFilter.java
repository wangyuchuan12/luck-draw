package com.wyc.draw.filter.controller.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.BattleMmeberStageIndexCreateFilter;
import com.wyc.draw.filter.BattleStageRebuildFilter;
import com.wyc.draw.filter.BattleStageTakepartFilter;
import com.wyc.draw.filter.CurrentBattleMemberFilter;
import com.wyc.draw.filter.RewardFilter;

public class BattleStageReTakepartApiFilter extends Filter{
	
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		HttpServletRequest httpServletRequest = sessionManager.getHttpServletRequest();
		String battleId = httpServletRequest.getParameter("battleId");
		String stage = httpServletRequest.getParameter("stage");
		sessionManager.setAttribute("battleId", battleId);
		sessionManager.setAttribute("stage", Integer.parseInt(stage));
			
		//给BattleMmeberIndexCreateFilter提供参数
		List<Integer> stageIndexes = new ArrayList<>();
		stageIndexes.add(Integer.parseInt(stage));
		sessionManager.setAttribute("stageIndexes", stageIndexes);
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> classes = new ArrayList<>();
		classes.add(BaseDrawActionFilter.class);
		classes.add(CurrentBattleMemberFilter.class);
		classes.add(BattleStageRebuildFilter.class);
		classes.add(BattleStageTakepartFilter.class);
		classes.add(BattleMmeberStageIndexCreateFilter.class);
		classes.add(RewardFilter.class);
		return classes;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}

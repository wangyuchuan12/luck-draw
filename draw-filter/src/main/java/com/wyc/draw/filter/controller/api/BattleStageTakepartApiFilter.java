package com.wyc.draw.filter.controller.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.BattleMmeberIndexCreateFilter;
import com.wyc.draw.filter.BattleStageTakepartFilter;
import com.wyc.draw.filter.CurrentBattleMemberFilter;

public class BattleStageTakepartApiFilter extends Filter{

	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		
		ResultVo resultVo = sessionManager.getObject(ResultVo.class);
		
		return resultVo;
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
		classes.add(BattleStageTakepartFilter.class);
		classes.add(BattleMmeberIndexCreateFilter.class);
		return classes;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}

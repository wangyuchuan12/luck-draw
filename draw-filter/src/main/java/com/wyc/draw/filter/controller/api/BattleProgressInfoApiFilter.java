package com.wyc.draw.filter.controller.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.draw.domain.BattleToMember;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.CurrentBattleMemberFilter;

public class BattleProgressInfoApiFilter extends Filter{

	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		
		BattleToMember battleToMember = sessionManager.getObject(BattleToMember.class);
		
		List<String> stageIndexs = (List<String>)sessionManager.getAttribute("stageIndexs");
		return null;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		HttpServletRequest httpServletRequest = sessionManager.getHttpServletRequest();
		String battleId = httpServletRequest.getParameter("battleId");
		
		sessionManager.setAttribute("battleId", battleId);
		
		if(CommonUtil.isEmpty(battleId)){
			sessionManager.setReturn(true);
		}
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> classes = new ArrayList<>();
		classes.add(BaseDrawActionFilter.class);
		classes.add(CurrentBattleMemberFilter.class);
		return classes;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}

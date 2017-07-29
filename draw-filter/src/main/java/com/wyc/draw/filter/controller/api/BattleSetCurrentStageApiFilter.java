package com.wyc.draw.filter.controller.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.BattleMember;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.CurrentBattleMemberFilter;

public class BattleSetCurrentStageApiFilter extends Filter{
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		Integer stage = (Integer)sessionManager.getAttribute("stage");
		BattleMember battleMember = (BattleMember)sessionManager.getObject(BattleMember.class);
		battleMember.setCurrentStageIndex(stage);
		sessionManager.update(battleMember);
		
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setMsg("success");
		return resultVo;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		HttpServletRequest httpServletRequest = sessionManager.getHttpServletRequest();
		String stage = httpServletRequest.getParameter("stage");
		String battleId = httpServletRequest.getParameter("battleId");
		
		sessionManager.setAttribute("stage", Integer.parseInt(stage));
		sessionManager.setAttribute("battleId", battleId);
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

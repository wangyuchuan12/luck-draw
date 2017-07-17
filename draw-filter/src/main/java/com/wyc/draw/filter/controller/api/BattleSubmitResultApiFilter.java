package com.wyc.draw.filter.controller.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.BattleMemberStage;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.BattleRankInfoFilter;
import com.wyc.draw.filter.BattleRankMemberListFilter;
import com.wyc.draw.filter.BattleSubmitResultFilter;
import com.wyc.draw.filter.BattleSyncStageIndexFilter;
import com.wyc.draw.filter.CurrentBattleMemberFilter;
import com.wyc.draw.filter.CurrentBattleRankMemberFilter;

public class BattleSubmitResultApiFilter extends Filter{

	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		
		BattleMemberStage battleMemberStage = sessionManager.getObject(BattleMemberStage.class);
		
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setData(battleMemberStage);
		
		return resultVo;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		HttpServletRequest httpServletRequest = sessionManager.getHttpServletRequest();
		String battleId = httpServletRequest.getParameter("battleId");
		String stage = httpServletRequest.getParameter("stage");
		
		sessionManager.setAttribute("battleId", battleId);
		sessionManager.setAttribute("stage", Integer.parseInt(stage));
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> classes = new ArrayList<>();
		classes.add(BaseDrawActionFilter.class);
		classes.add(CurrentBattleMemberFilter.class);
		classes.add(BattleRankInfoFilter.class);
		classes.add(CurrentBattleRankMemberFilter.class);
		classes.add(BattleSyncStageIndexFilter.class);
		classes.add(BattleSubmitResultFilter.class);
		return classes;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}

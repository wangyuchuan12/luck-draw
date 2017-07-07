package com.wyc.draw.filter.controller.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.BattleRank;
import com.wyc.draw.filter.BattleRankInfoFilter;
import com.wyc.draw.filter.BattleRankMemberListFilter;
import com.wyc.draw.filter.CurrentBattleMemberFilter;
import com.wyc.draw.vo.BattleRankMemberListVo;

public class BattleRankApiFilter extends Filter{

	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		BattleRank battleRank = sessionManager.getObject(BattleRank.class);
		
		BattleRankMemberListVo battleRankMemberListVo = sessionManager.getObject(BattleRankMemberListVo.class);
		
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("rankInfo", battleRank);
		responseData.put("members", battleRankMemberListVo);
		
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setData(responseData);
		return resultVo;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		HttpServletRequest httpServletRequest = sessionManager.getHttpServletRequest();
		String battleId = httpServletRequest.getParameter("battleId");
		sessionManager.setAttribute("battleId", battleId);
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> classes = new ArrayList<>();
		classes.add(CurrentBattleMemberFilter.class);
		classes.add(BattleRankInfoFilter.class);
		classes.add(BattleRankMemberListFilter.class);
		return classes;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}

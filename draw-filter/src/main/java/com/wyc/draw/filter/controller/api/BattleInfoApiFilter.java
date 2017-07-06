package com.wyc.draw.filter.controller.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.Battle;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.BattleInfoFilter;
import com.wyc.draw.filter.BattleMemberOfNumFilter;
import com.wyc.draw.vo.BattleMemberListVo;

public class BattleInfoApiFilter extends Filter{

	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		
		Battle battle = sessionManager.getObject(Battle.class);
		
		/*BattleMemberListVo battleMemberListVo = sessionManager.getObject(BattleMemberListVo.class);
		
		ResultVo resultVo = new ResultVo();
		Map<String, Object> data = new HashMap<>();
		data.put("info", battle);
		data.put("member", battleMemberListVo.getBattleMembers());*/
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setData(battle);
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
		classes.add(BaseDrawActionFilter.class);
		classes.add(BattleInfoFilter.class);
		//classes.add(BattleMemberOfNumFilter.class);
		return classes;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}

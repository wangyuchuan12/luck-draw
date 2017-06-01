package com.wyc.draw.filter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.Battle;
import com.wyc.draw.service.BattleService;

public class BattleInfoFilter extends Filter{

	@Autowired
	private BattleService battleService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		String paperId = sessionManager.getAttribute("paperId").toString();
		Battle battle = battleService.findOneByPaperId(paperId);
		return battle;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}

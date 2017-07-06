package com.wyc.draw.filter.controller.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.hql.internal.ast.tree.ResultVariableRefNode;
import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.BattleStage;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.service.BattleStageService;

public class BattleStageListApiFilter extends Filter{

	@Autowired
	private BattleStageService battleStageService;
	
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		
		String battleId = (String)sessionManager.getAttribute("battleId");
		
		List<BattleStage> battleStages = battleStageService.findAllByBattleIdAndIsDel(battleId, 0);
		
		ResultVo resultVo = new ResultVo();
		resultVo.setData(battleStages);
		resultVo.setSuccess(true);
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
		return classes;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}

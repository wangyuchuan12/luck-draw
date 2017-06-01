package com.wyc.draw.filter.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.Battle;
import com.wyc.draw.service.BattleService;

public class BattleListApiFilter extends Filter{

	@Autowired
	private BattleService battleService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		String subjectId= sessionManager.getAttribute("subjectId").toString();
		List<Battle> battles = battleService.findAllBySubjectId(subjectId);
		
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setData(battles);
		return resultVo;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		sessionManager.setAttribute("subjectId", 1);
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

package com.wyc.draw.filter.controller.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.BattleMember;
import com.wyc.draw.domain.BattleMemberStage;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.CurrentBattleMemberFilter;
import com.wyc.draw.service.BattleMemberStageService;

public class BattleMemberStageListApiFilter extends Filter{

	@Autowired
	private BattleMemberStageService battleMemberStageService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		
		
		BattleMember battleMember = sessionManager.getObject(BattleMember.class);
		
		List<BattleMemberStage> battleMemberStages = battleMemberStageService.findAllByMemberIdOrderByStageIndexAsc(battleMember.getId());
		
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setData(battleMemberStages);
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
		classes.add(CurrentBattleMemberFilter.class);
		return classes;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}

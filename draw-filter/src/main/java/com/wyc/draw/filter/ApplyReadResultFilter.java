package com.wyc.draw.filter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.BattleMember;
import com.wyc.draw.domain.BattleMemberStage;
import com.wyc.draw.service.BattleMemberStageService;

public class ApplyReadResultFilter extends Filter{

	@Autowired
	private BattleMemberStageService battleMemberStageService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		
		
		String battleId = (String)sessionManager.getAttribute("battleId");
		Integer stage = (Integer)sessionManager.getAttribute("stage");
		
		BattleMember battleMember = sessionManager.getObject(BattleMember.class);
		
		BattleMemberStage battleMemberStage  = battleMemberStageService.findOneByMemberIdAndBattleIdAndStageIndexAndIsDel(battleMember.getId(), battleId, stage, 0);
		
		battleMemberStage.setIsReadResult(1);
		
		
		return null;
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

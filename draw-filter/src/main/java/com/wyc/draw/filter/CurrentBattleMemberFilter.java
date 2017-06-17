package com.wyc.draw.filter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.BattleMember;
import com.wyc.draw.domain.BattleToMember;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.service.BattleMemberService;
import com.wyc.draw.service.BattleToMemberService;

public class CurrentBattleMemberFilter extends Filter{

	@Autowired
	private BattleMemberService battleMemberService;
	
	@Autowired
	private BattleToMemberService battleToMemberService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		DrawUser drawUser = sessionManager.getObject(DrawUser.class);
		String battleId = sessionManager.getAttribute("battleId").toString();
		BattleToMember battleToMember = battleToMemberService.findOneByDrawUserIdAndBattleId(drawUser.getId(),battleId);
		
		BattleMember battleMember = null;
		
		if(battleToMember==null){
			
			battleMember = new BattleMember();
			battleMember.setBattleId(battleId);
			battleMember.setDrawUserId(drawUser.getId());
			battleMember.setNickname(drawUser.getNickname());
			battleMember.setScore(0);
			battleMember.setCurrentIndex(0);
			battleMember.setCurrentStageIndex(0);
			battleMember = battleMemberService.add(battleMember);
			
			battleToMember = new BattleToMember();
			battleToMember.setBattleId(battleId);
			battleToMember.setDrawUserId(drawUser.getId());
			battleToMember.setStatus(Constant.BM_STATUS_FREE);
			battleToMember.setCurrentMemberId(battleMember.getId());
			battleToMember = battleToMemberService.add(battleToMember);
	
		}else {
			battleMember = battleMemberService.findOne(battleToMember.getCurrentMemberId());
		}
	
		sessionManager.save(battleMember);
		return battleToMember;
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

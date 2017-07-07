package com.wyc.draw.filter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.BattleMember;
import com.wyc.draw.domain.BattleRankMember;
import com.wyc.draw.service.BattleRankMemberService;

public class BattleRankMemberTakepartFilter extends Filter{

	@Autowired
	private BattleRankMemberService battleRankMemberService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		
		BattleMember battleMember = sessionManager.getObject(BattleMember.class);
		BattleRankMember battleRankMember = sessionManager.getObject(BattleRankMember.class);
		battleRankMember.setStatus(Constant.BATTLE_RANK_MEMBER_STATUS_IN);
		battleRankMember.setMemberImg(battleMember.getHeadImg());
		battleRankMember.setScore(0);
		battleRankMemberService.save(battleRankMember);
		return battleRankMember;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> classes = new ArrayList<>();
		classes.add(BattleRankInfoFilter.class);
		classes.add(CurrentBattleMemberFilter.class);
		classes.add(CurrentBattleRankMemberFilter.class);
		return classes;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}

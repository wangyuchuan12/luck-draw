package com.wyc.draw.filter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.BattleMember;
import com.wyc.draw.domain.BattleRank;
import com.wyc.draw.domain.BattleRankMember;
import com.wyc.draw.service.BattleRankMemberService;

public class CurrentBattleRankMemberFilter extends Filter{

	@Autowired
	private BattleRankMemberService battleRankMemberService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		BattleRank battleRank = sessionManager.getObject(BattleRank.class);
		BattleMember battleMember = sessionManager.getObject(BattleMember.class);
		
		BattleRankMember battleRankMember = battleRankMemberService.findOneByBattleRankIdAndMemberId(battleRank.getId(),battleMember.getId());
		if(battleRankMember==null){
			battleRankMember = new BattleRankMember();
			battleRankMember.setStatus(Constant.BATTLE_RANK_MEMBER_STATUS_FREE);
			battleRankMember.setBattleId(battleRank.getBattleId());
			battleRankMember.setBattleRankId(battleRank.getId());
			battleRankMember.setIndex(0);
			battleRankMember.setMemberId(battleMember.getId());
			
			System.out.println(".........headImg:"+battleMember.getHeadImg());
			battleRankMember.setMemberImg(battleMember.getHeadImg());
			battleRankMember.setMemberNickname(battleMember.getNickname());
			battleRankMember.setScore(0);
			battleRankMember.setStageIndex(0);
			battleRankMemberService.add(battleRankMember);
		}
		return battleRankMember;
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

package com.wyc.draw.filter;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.BattleMember;
import com.wyc.draw.domain.BattleRank;
import com.wyc.draw.service.BattleRankService;

public class BattleRankInfoFilter extends Filter{

	@Autowired
	private BattleRankService battleRankService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		String battleId = (String)sessionManager.getAttribute("battleId");
		BattleRank battleRank = battleRankService.findOneByBattleId(battleId);
		BattleMember battleMember = sessionManager.getObject(BattleMember.class);
	
		if(battleRank==null){
			battleRank = new BattleRank();
			battleRank.setBattleId(battleId);
			battleRank.setCreaterMemberId(battleMember.getId());
			battleRank.setMemberMax(8);
			battleRank.setMemberMin(4);
			battleRank.setMemberTakepartNum(0);
			battleRank.setStatus(Constant.BATTLE_RANK_IN);
			battleRankService.add(battleRank);
		}
		sessionManager.setAttribute("battleRankId", battleRank.getId());
		return battleRank;
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
	public Object handlerAfter(SessionManager sessionManager){
		try{
		}catch(Exception e){
			
		}
		return null;
	}

}

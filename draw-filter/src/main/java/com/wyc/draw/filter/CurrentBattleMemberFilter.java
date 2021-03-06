package com.wyc.draw.filter;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.Battle;
import com.wyc.draw.domain.BattleMember;
import com.wyc.draw.domain.BattleToMember;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.service.BattleMemberService;
import com.wyc.draw.service.BattleStageService;
import com.wyc.draw.service.BattleToMemberService;

public class CurrentBattleMemberFilter extends Filter{

	@Autowired
	private BattleMemberService battleMemberService;
	
	@Autowired
	private BattleToMemberService battleToMemberService;
	
	@Autowired
	private BattleStageService battleStageService;
	
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		DrawUser drawUser = sessionManager.getObject(DrawUser.class);
		String battleId = sessionManager.getAttribute("battleId").toString();
		BattleToMember battleToMember = battleToMemberService.findOneByDrawUserIdAndBattleId(drawUser.getId(),battleId);
		
		BattleMember battleMember = null;
		
		if(battleToMember==null){
			
			Battle battle = sessionManager.findOne(Battle.class, battleId);
			battleMember = new BattleMember();
			battleMember.setBattleId(battleId);
			battleMember.setDrawUserId(drawUser.getId());
			battleMember.setNickname(drawUser.getNickname());
			battleMember.setScore(0);
			battleMember.setCurrentIndex(1);
			battleMember.setCurrentStageIndex(1);
			battleMember.setHeadImg(drawUser.getImgUrl());
			battleMember.setLoveLife(battle.getLoveLifeGive());
			battleMember.setLoveLifeLimit(battle.getLoveLifeGive());
			
			Long count = battleStageService.countByBattleId(battleId);
			battleMember.setStageIndexCount(count.intValue());
			battleMember = battleMemberService.add(battleMember);
			
			battleToMember = new BattleToMember();
			battleToMember.setBattleId(battleId);
			battleToMember.setDrawUserId(drawUser.getId());
			battleToMember.setStatus(Constant.BM_STATUS_FREE);
			battleToMember.setCurrentMemberId(battleMember.getId());
		
			battleToMember = battleToMemberService.add(battleToMember);
	
		}else {
			battleMember = sessionManager.findOne(BattleMember.class, battleToMember.getCurrentMemberId());
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

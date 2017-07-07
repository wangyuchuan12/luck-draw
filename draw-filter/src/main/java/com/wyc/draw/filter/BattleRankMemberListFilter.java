package com.wyc.draw.filter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.BattleRankMember;
import com.wyc.draw.service.BattleRankMemberService;
import com.wyc.draw.vo.BattleRankMemberListVo;

public class BattleRankMemberListFilter extends Filter{

	@Autowired
	private BattleRankMemberService battleRankMemberService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		String battleId = (String)sessionManager.getAttribute("battleId");
	
		List<Integer> statuses = new ArrayList<>();
		statuses.add(Constant.BATTLE_RANK_MEMBER_STATUS_IN);
		statuses.add(Constant.BATTLE_RANK_MEMBER_STATUS_END);
		
		Integer pageInt = 0;
		Integer sizeInt = 10;
		
		Sort sort = new Sort(Direction.DESC,"score");
		Pageable pageable = new PageRequest(pageInt, sizeInt, sort);
		List<BattleRankMember> battleRankMembers = battleRankMemberService.findAllByBattleIdAndStatusIn(battleId,statuses,pageable);
		
		BattleRankMemberListVo battleRankMemberListVo = new BattleRankMemberListVo();
		battleRankMemberListVo.setBattleRankMembers(battleRankMembers);
		
		return battleRankMemberListVo;
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

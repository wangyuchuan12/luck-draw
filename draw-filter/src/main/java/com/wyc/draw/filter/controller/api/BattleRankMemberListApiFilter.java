package com.wyc.draw.filter.controller.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.BattleMember;
import com.wyc.draw.domain.BattleRank;
import com.wyc.draw.domain.BattleRankMember;
import com.wyc.draw.filter.BattleRankInfoFilter;
import com.wyc.draw.filter.BattleRankMemberListFilter;
import com.wyc.draw.filter.CurrentBattleMemberFilter;
import com.wyc.draw.vo.BattleRankMemberListVo;

public class BattleRankMemberListApiFilter extends Filter{

	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		
		BattleRankMemberListVo battleRankMemberListVo = sessionManager.getObject(BattleRankMemberListVo.class);
		
		BattleMember battleMember = sessionManager.getObject(BattleMember.class);
		
		BattleRank battleRank = sessionManager.getObject(BattleRank.class);
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		
		Map<String, Object> data = new HashMap<>();
		
		if(battleRankMemberListVo.getBattleRankMembers()!=null&&battleRankMemberListVo.getBattleRankMembers().size()>0){
			for(int i = 0;i<battleRankMemberListVo.getBattleRankMembers().size();i++){
				BattleRankMember battleRankMember = battleRankMemberListVo.getBattleRankMembers().get(i);
				if(battleRankMember.getMemberId().equals(battleMember.getId())){
					data.put("thisMember",battleMember);
					break;
				}
			}
		}
		
		
		
		data.put("members",battleRankMemberListVo.getBattleRankMembers());
		data.put("rankInfo", battleRank);
		resultVo.setData(data);
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
		classes.add(CurrentBattleMemberFilter.class);
		classes.add(BattleRankInfoFilter.class);
		classes.add(BattleRankMemberListFilter.class);
		return classes;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.wyc.draw.filter.controller.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.MyLongDateFormat;
import com.wyc.draw.domain.Battle;
import com.wyc.draw.domain.BattleMember;
import com.wyc.draw.domain.BattleRank;
import com.wyc.draw.domain.BattleRankMember;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.BattleInfoFilter;
import com.wyc.draw.filter.BattleRankInfoFilter;
import com.wyc.draw.filter.BattleRankMemberListFilter;
import com.wyc.draw.filter.BattleReceiveRewardsFilter;
import com.wyc.draw.filter.BattleTimeoutCheckFilter;
import com.wyc.draw.filter.CurrentBattleMemberFilter;
import com.wyc.draw.vo.BattleRankMemberListVo;

public class BattleInfoApiFilter extends Filter{

	@Autowired
	private MyLongDateFormat mySimpleDateFormat;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		
		Battle battle = sessionManager.getObject(Battle.class);
		
		BattleRank battleRank = sessionManager.getObject(BattleRank.class);
		
		BattleMember battleMember = sessionManager.getObject(BattleMember.class);
		
		/*BattleMemberListVo battleMemberListVo = sessionManager.getObject(BattleMemberListVo.class);
		
		ResultVo resultVo = new ResultVo();
		Map<String, Object> data = new HashMap<>();
		data.put("info", battle);
		data.put("member", battleMemberListVo.getBattleMembers());*/
		ResultVo resultVo = new ResultVo();
		Map<String, Object> data = new HashMap<>();
		resultVo.setSuccess(true);
		data.put("beanConsume", battle.getBeanConsume());
		data.put("loveConsume", battle.getLoveLifeConsume());
		data.put("id", battle.getId());
		data.put("imgUrl", battle.getImgUrl());
		data.put("instruction", battle.getInstruction());
		data.put("loveLifeGive", battle.getLoveLifeGive());
		data.put("modelId", battle.getModelId());
		data.put("name", battle.getName());
		data.put("paperId", battle.getPaperId());
		data.put("subjectId", battle.getSubjectId());
		data.put("takepartCount", battle.getTakepartCount());
		data.put("title", battle.getTitle());
		data.put("type", battle.getType());
		data.put("beginDate", mySimpleDateFormat.format(battle.getBeginDate().toDate()));
		data.put("timeLong", battle.getTimeLong());
		data.put("status", battle.getStatus());
		
		BattleRankMemberListVo battleRankMemberListVo = sessionManager.getObject(BattleRankMemberListVo.class);
		data.put("rankMembers", battleRankMemberListVo.getBattleRankMembers());
		
		data.put("battleRank", battleRank);
		data.put("stageIndexCount", battle.getStageIndexCount());
		
		if(battleRankMemberListVo.getBattleRankMembers()!=null&&battleRankMemberListVo.getBattleRankMembers().size()>0){
			for(int i = 0;i<battleRankMemberListVo.getBattleRankMembers().size();i++){
				BattleRankMember battleRankMember = battleRankMemberListVo.getBattleRankMembers().get(i);
				if(battleRankMember.getMemberId().equals(battleMember.getId())){
					data.put("thisMember",battleMember);
					break;
				}
			}
		}
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
		classes.add(BaseDrawActionFilter.class);
		classes.add(CurrentBattleMemberFilter.class);
		classes.add(BattleInfoFilter.class);
		classes.add(BattleRankMemberListFilter.class);
		classes.add(BattleRankInfoFilter.class);
		//classes.add(BattleMemberOfNumFilter.class);
		classes.add(BattleTimeoutCheckFilter.class);
		
		classes.add(BattleReceiveRewardsFilter.class);
		
		return classes;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}

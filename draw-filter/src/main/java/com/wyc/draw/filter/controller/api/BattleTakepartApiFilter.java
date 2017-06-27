package com.wyc.draw.filter.controller.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.Account;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.service.AccountService;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.Battle;
import com.wyc.draw.domain.BattleMember;
import com.wyc.draw.domain.BattleToMember;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.BattleMemberStageCreateFilter;
import com.wyc.draw.filter.CurrentBattleMemberFilter;
import com.wyc.draw.service.other.AccountHandleService;
import com.wyc.draw.vo.BattleMemberStageListVo;

public class BattleTakepartApiFilter extends Filter{
	
	@Autowired
	private AccountHandleService accountHandleService;
	
	@Autowired
	private AccountService accountService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		
		DrawUser drawUser = sessionManager.getObject(DrawUser.class);
		BattleMember battleMember = sessionManager.getObject(BattleMember.class);
		BattleToMember battleToMember = sessionManager.getObject(BattleToMember.class);
		
		if(battleToMember.getStatus()==Constant.BM_STATUS_IN){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setMsg("不能参加，该比赛正在进行中");
			return resultVo;
		}
		
		String battleId = sessionManager.getAttribute("battleId").toString();
		Battle battle = sessionManager.findOne(Battle.class, battleId);
		
		Integer beanConsume = battle.getBeanConsume();
		Integer loveLifeConsume = battle.getLoveLifeConsume();
		
		Account account = accountService.fineOneSync(drawUser.getAccountId());
		
		accountHandleService.subBean(account, beanConsume.longValue());
		accountHandleService.subLove(account, loveLifeConsume);
		
		battleMember.setLoveLife(battle.getLoveLifeGive());
		
		battleMember.setLoveLifeLimit(battle.getLoveLifeGive());
		
		battleToMember.setStatus(Constant.BM_STATUS_IN);
		
		sessionManager.update(battleMember);
		sessionManager.update(battleToMember);
		
		
		Map<String,Object> map = new HashMap<>();
		
		map.put("beanConsume", beanConsume);
		map.put("loveLifeConsume", loveLifeConsume);
		
		BattleMemberStageListVo battleMemberStageListVo = sessionManager.getObject(BattleMemberStageListVo.class);
		map.put("stages", battleMemberStageListVo.getBattleMemberStages());
		
		
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setMsg("保存成功");
		resultVo.setData(map);
		return resultVo;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		HttpServletRequest httpServletRequest = sessionManager.getHttpServletRequest();
		String battleId = httpServletRequest.getParameter("battleId");
		sessionManager.setAttribute("battleId", battleId);
		
		String stageIndexes = httpServletRequest.getParameter("stageIndexes");
		sessionManager.setAttribute("stageIndexes", stageIndexes);
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> classes = new ArrayList<>();
		classes.add(BaseDrawActionFilter.class);
		classes.add(CurrentBattleMemberFilter.class);
		
		classes.add(BattleMemberStageCreateFilter.class);
		return classes;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.wyc.draw.filter;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.Battle;
import com.wyc.draw.service.BattleService;

public class BattleTimeoutCheckFilter extends Filter{
	
	@Autowired
	private BattleService battleService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		
		String battleId = (String)sessionManager.getAttribute("battleId");
		
		Battle battle = sessionManager.findOne(Battle.class, battleId);
		
		
		DateTime beginDate = battle.getBeginDate();
		
		Integer timeLong = battle.getTimeLong();

		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(beginDate.toDate());
		
		calendar.add(Calendar.HOUR, timeLong);
		
		if(calendar.getTime().getTime()<new Date().getTime()){
			if(battle.getStatus()==Constant.BATTLE_STATUS_IN||battle.getStatus()==Constant.BATTLE_STATUS_FREE){
				battle.setStatus(Constant.BATTLE_STATUS_TIMEOUT);
				battle.setEndDate(new DateTime());
				
				sessionManager.update(battle);
			}
		}
		
		return battle;
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

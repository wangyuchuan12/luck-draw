package com.wyc.draw.filter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.filter.manager.FilterBroadcastAnnotation;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.BattleModelToDrawUser;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.service.BattleModelToDrawUserService;

public class CurrentBattleModelToDrawUserFilter extends Filter{

	@Autowired
	private BattleModelToDrawUserService battleModelToDrawUserService;
	
	@FilterBroadcastAnnotation(name="currentBattleModelToDrawUser")
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		DrawUser drawUser = sessionManager.getObject(DrawUser.class);
		
		String modelId = (String)sessionManager.getAttribute("modelId");
		
		
		BattleModelToDrawUser battleModelToDrawUser = battleModelToDrawUserService.findOneByModelIdAndDrawUserId(modelId,drawUser.getId());
		if(battleModelToDrawUser==null){
			battleModelToDrawUser = new BattleModelToDrawUser();
			battleModelToDrawUser.setDrawUserId(drawUser.getId());
			battleModelToDrawUser.setModelId(modelId);
			battleModelToDrawUser.setStatus(Constant.BATTLE_MODEL_TO_DRAWUSER_FREE);
			battleModelToDrawUserService.add(battleModelToDrawUser);
		}else{
			//不让执行BattleCreaterByModelFilter
			sessionManager.containNotExecuteFilter(BattleCreaterByModelFilter.class);
		}
		return battleModelToDrawUser;
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

package com.wyc.draw.filter.controller.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.filter.manager.FilterListenerAnnotation;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.Battle;
import com.wyc.draw.domain.BattleModel;
import com.wyc.draw.domain.BattleModelToDrawUser;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.BattleCreaterByModelFilter;
import com.wyc.draw.filter.CurrentBattleModelToDrawUserFilter;
import com.wyc.draw.service.BattleModelService;
import com.wyc.draw.service.BattleModelToDrawUserService;

public class CurrentBattleModelToDrawUserApiFilter extends Filter{

	@Autowired
	private BattleModelToDrawUserService battleModelToDrawUserService;
	
	@Autowired
	private BattleModelService battleModelService;
	
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		BattleModelToDrawUser battleModelToDrawUser = sessionManager.getObject(BattleModelToDrawUser.class);
		Battle battle = sessionManager.getObject(Battle.class);
		if(battleModelToDrawUser.getStatus()==Constant.BATTLE_MODEL_TO_DRAWUSER_FREE){
			battleModelToDrawUser.setStatus(Constant.BATTLE_MODEL_TO_DRAWUSER_IN);
			battleModelToDrawUser.setCurrentBattleId(battle.getId());
			
			battleModelToDrawUserService.save(battleModelToDrawUser);
		}
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setMsg("成功");
		resultVo.setData(battleModelToDrawUser);
		return resultVo;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		HttpServletRequest httpServletRequest = sessionManager.getHttpServletRequest();
		String code = httpServletRequest.getParameter("battleCode");
		BattleModel battleModel = battleModelService.findOneByCode(code);
		sessionManager.setAttribute("modelId", battleModel.getId());
		return null;
	}

	@FilterListenerAnnotation(name="currentBattleModelToDrawUser")
	public void currentBattleModelToDrawUserListener(SessionManager sessionManager)throws Exception{
		BattleModelToDrawUser battleModelToDrawUser = sessionManager.getObject(BattleModelToDrawUser.class);
		
		if(battleModelToDrawUser.getStatus()==Constant.BATTLE_MODEL_TO_DRAWUSER_IN){
			sessionManager.addNotExecuteFilterClass(BattleCreaterByModelFilter.class);
		}
	}
	
	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> classes = new ArrayList<>();
		classes.add(BaseDrawActionFilter.class);
		classes.add(CurrentBattleModelToDrawUserFilter.class);
		classes.add(BattleCreaterByModelFilter.class);
		return classes;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}

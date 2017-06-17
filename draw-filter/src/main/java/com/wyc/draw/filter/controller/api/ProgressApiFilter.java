package com.wyc.draw.filter.controller.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.CurrentBattleMemberFilter;
import com.wyc.draw.filter.ProgressFilter;
import com.wyc.draw.vo.BattleProgressInfoVo;
import com.wyc.draw.vo.BattleStageVo;

public class ProgressApiFilter extends Filter{

	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		BattleProgressInfoVo battleProgressInfoVo = sessionManager.getObject(BattleProgressInfoVo.class);
		
		Map<Object, Object> data = new HashMap<Object, Object>();
		for(BattleStageVo battleStageVo:battleProgressInfoVo.getBattleStageVos()){
			Map<Object, Object> stageMap = new HashMap<>();
			data.put(battleStageVo.getStageIndex(), stageMap);
			stageMap.put("battleIndexs", battleStageVo.getBattleIndexVos());
		}
		ResultVo resultVo = new ResultVo();
		resultVo.setData(data);
		resultVo.setSuccess(true);
		return resultVo;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		
		HttpServletRequest httpServletRequest = sessionManager.getHttpServletRequest();
		
		String stageIndexsStr = httpServletRequest.getParameter("stageIndexs");
		
		String[]stageIndexs = stageIndexsStr.split(",");
		List<Integer> stageIndexList = new ArrayList<>();
		for(String stageIndex:stageIndexs){
			stageIndexList.add(Integer.parseInt(stageIndex));
		}
		
		String battleId = httpServletRequest.getParameter("battleId");
		sessionManager.setAttribute("stageIndexs", stageIndexList);
		
		sessionManager.setAttribute("battleId", battleId);
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> classes = new ArrayList<>();
		classes.add(BaseDrawActionFilter.class);
		classes.add(CurrentBattleMemberFilter.class);
		classes.add(ProgressFilter.class);
		return classes;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.wyc.draw.filter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.BattleMemberStage;
import com.wyc.draw.service.BattleMemberStageService;

public class BattleSubmitResultFilter extends Filter{

	@Autowired
	private BattleMemberStageService battleMemberStageService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		BattleMemberStage battleMemberStage = sessionManager.getObject(BattleMemberStage.class);
		
		if(battleMemberStage.getStatus()==Constant.BM_STATUS_IN){
			battleMemberStage.setStatus(Constant.BM_STATUS_END);
			battleMemberStageService.update(battleMemberStage);
			return battleMemberStage;
		}else{
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("该阶段状态不对");
			sessionManager.setReturn(true);
			sessionManager.setReturnValue(resultVo);
		}
		return battleMemberStage;
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

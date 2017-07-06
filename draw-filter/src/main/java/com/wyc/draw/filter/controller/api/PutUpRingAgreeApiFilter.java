package com.wyc.draw.filter.controller.api;
import java.util.ArrayList;
import java.util.List;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.Dekorn;
import com.wyc.draw.filter.PutUpRingAgreeFilter;
import com.wyc.draw.filter.RewardFilter;
import com.wyc.draw.filter.controller.param.PutUpRingParamFilter;

public class PutUpRingAgreeApiFilter extends Filter{

	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		Dekorn dekorn = (Dekorn)sessionManager.getObject(Dekorn.class);
		
		resultVo.setData(dekorn);
		return resultVo;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> classes = new ArrayList<>();
		classes.add(PutUpRingParamFilter.class);
		classes.add(PutUpRingAgreeFilter.class);
		
		classes.add(RewardFilter.class);
		return classes;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}

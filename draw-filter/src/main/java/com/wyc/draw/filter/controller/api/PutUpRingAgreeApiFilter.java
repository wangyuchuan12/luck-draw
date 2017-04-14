package com.wyc.draw.filter.controller.api;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.Dekorn;
import com.wyc.draw.filter.PutUpRingAgreeFilter;
import com.wyc.draw.filter.controller.param.PutUpRingParamFilter;

public class PutUpRingAgreeApiFilter extends Filter{

	@Override
	public Object handlerBefore(SessionManager sessionManager) throws Exception {
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		Dekorn dekorn = (Dekorn)sessionManager.getObject(Dekorn.class);
		resultVo.setData(dekorn);
		return resultVo;
	}

	@Override
	public Object handlerAfter(SessionManager filterManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerPrivateException(SessionManager filterManager, Method method, Exception e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerPublicException(SessionManager filterManager, Exception e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> classes = new ArrayList<>();
		classes.add(PutUpRingParamFilter.class);
		classes.add(PutUpRingAgreeFilter.class);
		return classes;
	}

}

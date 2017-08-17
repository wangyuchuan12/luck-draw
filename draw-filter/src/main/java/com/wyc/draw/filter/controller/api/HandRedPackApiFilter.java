package com.wyc.draw.filter.controller.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.BaseHandRedPackFilter;
import com.wyc.draw.filter.CurrentRedPacketOwnerFilter;

public class HandRedPackApiFilter extends Filter{
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setMsg("提交红包成功");
		return resultVo;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		HttpServletRequest httpServletRequest = sessionManager.getHttpServletRequest();
		String isSearchAble = httpServletRequest.getParameter("isSearchAble");
		if(isSearchAble!=null){
			sessionManager.setAttribute("isSearchAble", Integer.parseInt(isSearchAble));
		}
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> filters = new ArrayList<>();
		filters.add(BaseDrawActionFilter.class);
		filters.add(BaseHandRedPackFilter.class);
		filters.add(CurrentRedPacketOwnerFilter.class);
		return filters;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}

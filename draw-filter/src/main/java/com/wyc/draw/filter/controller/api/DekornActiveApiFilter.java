package com.wyc.draw.filter.controller.api;
import java.util.ArrayList;
import java.util.List;

import com.wyc.common.domain.Account;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.DekornActiveRewardFilter;
import com.wyc.draw.filter.RewardFilter;

public class DekornActiveApiFilter extends Filter{

	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		Account account = (Account)filterManager.getObject(Account.class);
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setData(account);
		return resultVo;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> classes = new ArrayList<>();
		classes.add(BaseDrawActionFilter.class);
		classes.add(DekornActiveRewardFilter.class);
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

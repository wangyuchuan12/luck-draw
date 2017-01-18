package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.ApplyForm;
import com.wyc.common.filter.Filter;
import com.wyc.common.service.ApplyFormService;
import com.wyc.common.session.SessionManager;
import com.wyc.common.wx.domain.UserInfo;
import com.wyc.draw.vo.ApplyFormListVo;

public class GetApplyFormListFilterByUser extends Filter{

	@Autowired
	private ApplyFormService applyFormService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		UserInfo userInfo = (UserInfo)filterManager.getObject(UserInfo.class);
		String openid = userInfo.getOpenid();
		
		List<ApplyForm> applyForms = applyFormService.findAllByOpenidOrderByApplyTimeDesc(openid);
		
		ApplyFormListVo applyFormListVo = new ApplyFormListVo();
		applyFormListVo.setApplyForms(applyForms);
		return applyFormListVo;
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
		List<Class<? extends Filter>> filters = new ArrayList<>();
		filters.add(BaseDrawActionFilter.class);
		return filters;
	}

}

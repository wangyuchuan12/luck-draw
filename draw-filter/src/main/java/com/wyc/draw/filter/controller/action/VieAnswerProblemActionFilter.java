package com.wyc.draw.filter.controller.action;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.VieRedPacketToTakepartMember;
import com.wyc.draw.filter.CurrentVieRedPacketToTakepartMemberFilter;
import com.wyc.draw.filter.GetRedPacketProblemListFilter;
import com.wyc.draw.filter.controller.param.VieAnswerProblemParamFilter;
import com.wyc.draw.service.VieRedPacketToTakepartMemberService;

public class VieAnswerProblemActionFilter extends Filter{

	@Autowired
	private VieRedPacketToTakepartMemberService vieRedPacketToTakepartMemberService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		VieRedPacketToTakepartMember vieRedPacketToTakepartMember = (VieRedPacketToTakepartMember)filterManager.getObject(VieRedPacketToTakepartMember.class);
		vieRedPacketToTakepartMember.setTakepartStatus(Constant.UNDERWAY_TAKEPART_STATUS);
		
		vieRedPacketToTakepartMemberService.update(vieRedPacketToTakepartMember);
		return vieRedPacketToTakepartMember;
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
		List<Class<? extends Filter>> filterClasses = new ArrayList<>();
		filterClasses.add(VieAnswerProblemParamFilter.class);
		filterClasses.add(GetRedPacketProblemListFilter.class);
		filterClasses.add(CurrentVieRedPacketToTakepartMemberFilter.class);
		return filterClasses;
	}

}

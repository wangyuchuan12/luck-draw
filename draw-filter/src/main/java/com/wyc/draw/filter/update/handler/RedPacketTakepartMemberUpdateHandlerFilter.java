package com.wyc.draw.filter.update.handler;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.RedPacketTakepartMember;
import com.wyc.draw.service.VieRedPacketTakepartMemberService;

public class RedPacketTakepartMemberUpdateHandlerFilter extends Filter{

	@Autowired
	private VieRedPacketTakepartMemberService vieRedPacketTakepartMemberService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		RedPacketTakepartMember redPacketTakepartMember = (RedPacketTakepartMember)filterManager.getObject(RedPacketTakepartMember.class);
		vieRedPacketTakepartMemberService.update(redPacketTakepartMember);
		return redPacketTakepartMember;
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
		// TODO Auto-generated method stub
		return null;
	}

}

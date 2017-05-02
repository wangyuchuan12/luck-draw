package com.wyc.draw.filter.update.handler;
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
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		RedPacketTakepartMember redPacketTakepartMember = (RedPacketTakepartMember)filterManager.getObject(RedPacketTakepartMember.class);
		vieRedPacketTakepartMemberService.update(redPacketTakepartMember);
		return redPacketTakepartMember;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		// TODO Auto-generated method stub
		return null;
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

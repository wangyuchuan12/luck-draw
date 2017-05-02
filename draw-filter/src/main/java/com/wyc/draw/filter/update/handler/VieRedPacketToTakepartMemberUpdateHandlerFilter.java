package com.wyc.draw.filter.update.handler;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.RedPacketToTakepartMember;
import com.wyc.draw.service.VieRedPacketToTakepartMemberService;

public class VieRedPacketToTakepartMemberUpdateHandlerFilter extends Filter{

	@Autowired
	private VieRedPacketToTakepartMemberService vieRedPacketToTakepartMemberService;
	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		RedPacketToTakepartMember vieRedPacketToTakepartMember = (RedPacketToTakepartMember)filterManager.getObject(RedPacketToTakepartMember.class);
		vieRedPacketToTakepartMemberService.update(vieRedPacketToTakepartMember);
		return vieRedPacketToTakepartMember;
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

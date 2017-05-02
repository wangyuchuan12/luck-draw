package com.wyc.draw.filter.update.handler;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.service.RedPacketService;

public class RedPacketUpdateHandlerFilter extends Filter{

	@Autowired
	private RedPacketService redPacketService;
	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		RedPacket redPacket = (RedPacket)filterManager.getObject(RedPacket.class);
		redPacketService.update(redPacket);
		return redPacket;
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

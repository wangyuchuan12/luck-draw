package com.wyc.draw.filter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.RedPacketOwner;
import com.wyc.draw.service.RedPacketOwnerService;

public class RedPacketOwerTakepartFilter extends Filter{

	@Autowired
	private RedPacketOwnerService redPacketOwerService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
	
		DrawUser drawUser = sessionManager.getObject(DrawUser.class);
		String redPacketId = (String)sessionManager.getAttribute("redPacketId");
		
		RedPacketOwner redPacketOwner = redPacketOwerService.findOneByDrawUserIdAndRedPacketId(drawUser.getId(),redPacketId);
		
		redPacketOwner.setIsTakepart(1);
		
		redPacketOwerService.update(redPacketOwner);
		return redPacketOwner;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}

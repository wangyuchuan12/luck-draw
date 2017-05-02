package com.wyc.draw.filter.test;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.service.RedPacketService;

public class RedPacketReceiveAbleTestFilter extends Filter{

	@Autowired
	private RedPacketService redPacketService;
	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		RedPacket redPacket = (RedPacket)filterManager.getObject(RedPacket.class);
		if(redPacket.getIsTimeout()==0&&redPacket.getIsPay()==1){
			redPacket.setIsReceiveAble(1);
			redPacket.setIsDisplay(1);
		}else{
			redPacket.setIsReceiveAble(0);
			redPacket.setIsDisplay(0);
		}
		
		redPacket = redPacketService.update(redPacket);
		
		return redPacket;
	}


	@Override
	public List<Class<? extends Filter>> dependClasses() {
		
		List<Class<? extends Filter>> filterClasses = new ArrayList<>();
		
		filterClasses.add(RedPacketIsPayTestFilter.class);
		
		filterClasses.add(RedPacketTimeOutTestFilter.class);
		return filterClasses;
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

package com.wyc.draw.filter.test;

import java.lang.reflect.Method;
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
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		RedPacket redPacket = (RedPacket)filterManager.getObject(RedPacket.class);
		if(redPacket.getIsTimeout()==0&&redPacket.getIsPay()==1){
			redPacket.setIsReceiveAble(1);
		}else{
			redPacket.setIsReceiveAble(0);
		}
		
		redPacket = redPacketService.update(redPacket);
		
		return redPacket;
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
		
		filterClasses.add(RedPacketIsPayTestFilter.class);
		
		filterClasses.add(RedPacketTimeOutTestFilter.class);
		return filterClasses;
	}

}

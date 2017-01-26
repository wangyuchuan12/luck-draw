package com.wyc.draw.filter.test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.service.RedPacketService;


//红包是否到期检测
public class RedPacketTimeOutTestFilter extends Filter{

	
	@Autowired
	private RedPacketService redPackageService;
	
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		RedPacket redPacket  = (RedPacket)filterManager.getObject(RedPacket.class);
		
		if(redPacket.getIsTimeout()==1){
			return redPacket;
		}
		
		DateTime handTime = redPacket.getHandTime();
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(handTime.toDate());
		
		calendar.add(Calendar.HOUR, redPacket.getTimeLong());
		
		if(calendar.getTime().getTime()<new Date().getTime()){
			redPacket.setIsTimeout(1);
			redPacket.setIsAmountDisplay(1);
			redPackageService.update(redPacket);
		}
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
		
		filterClasses.add(GetRedPacketFilter.class);
		return filterClasses;
	}

}

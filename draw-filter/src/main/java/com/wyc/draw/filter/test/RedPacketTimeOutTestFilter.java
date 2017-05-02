package com.wyc.draw.filter.test;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.joda.time.DateTime;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.RedPacket;


//红包是否到期检测
public class RedPacketTimeOutTestFilter extends Filter{
	
	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
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
	//		redPackageService.update(redPacket);
		}
		return redPacket;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		
		
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

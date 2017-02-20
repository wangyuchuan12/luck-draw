package com.wyc.draw.filter.test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.PaySuccess;
import com.wyc.common.filter.Filter;
import com.wyc.common.service.PaySuccessService;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.service.RedPacketService;

//红包是否已付款检测
public class RedPacketIsPayTestFilter extends Filter{

	@Autowired
	private PaySuccessService paySuccessService;
	
	@Autowired
	private RedPacketService redPackageService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		
		RedPacket redPacket = (RedPacket)filterManager.getObject(RedPacket.class);
		
		if(redPacket.getIsPay()==1){
			return null;
		}
		PaySuccess paySuccess = paySuccessService.findOneByOutTradeNo(redPacket.getOutTradeNo());
		
		if(paySuccess!=null&&paySuccess.getResultCode().equals("SUCCESS")){
			redPacket.setIsPay(1);
	//		redPackageService.update(redPacket);
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

package com.wyc.draw.filter.test;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.PaySuccess;
import com.wyc.common.filter.Filter;
import com.wyc.common.service.PaySuccessService;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.RedPacket;

//红包是否已付款检测
public class RedPacketIsPayTestFilter extends Filter{

	@Autowired
	private PaySuccessService paySuccessService;
	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		
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

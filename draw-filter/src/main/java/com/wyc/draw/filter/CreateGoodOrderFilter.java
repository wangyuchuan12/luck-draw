package com.wyc.draw.filter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.Good;
import com.wyc.draw.domain.Order;
import com.wyc.draw.service.OrderService;

public class CreateGoodOrderFilter extends Filter{

	@Autowired
	private OrderService orderService;
	
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		String goodId = (String)sessionManager.getAttribute("goodId");
		Integer costType = (Integer)sessionManager.getAttribute("costType");
		
		Good good = sessionManager.findOne(Good.class, goodId);
		
		Order order = new Order();
		
		order.setAmountNum(good.getAmountNum());
		order.setBeanModelNum(good.getBeanModelNum());
		order.setLoveModelNum(good.getLoveModelNum());
		order.setPhyModelNum(good.getPhyModelNum());
		order.setRandomModelNum(good.getRandomModelNum());
		order.setBeanNum(good.getBeanNum());
		order.setLoveNum(good.getLoveNum());
		order.setMasonryNum(good.getMasonryNum());
		order.setCostMoney(good.getCostMoney());
		order.setCostType(costType);
		order.setGoodId(goodId);
		order.setName(good.getName());
		order.setImgUrl(good.getImgUrl());
		order.setIsPay(0);
		order.setIsToAccount(0);
		order.setDetail(good.getDetail());
		
		orderService.add(order);

		sessionManager.setAttribute("orderId", order.getId());
		return order;
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
	public Object handlerAfter(SessionManager sessionManager){
		try{
			
		}catch(Exception e){
			
		}
		
		return null;
	}

}

package com.wyc.draw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.Good;
import com.wyc.draw.domain.Order;


//生成订单
public class CreateGoodOrderFilter extends Filter{
	
	@Autowired
	private OrderService orderService;

	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		String goodId = (String)sessionManager.getAttribute("goodId");
		
		Good good = sessionManager.findOne(Good.class, goodId);
		
		Order order = new Order();
		order.setAmountNum(good.getAmountNum());
	//	order.setAmountPayType(Cons);
		order.setBeanModelNum(good.getBeanModelNum());
		order.setBeanNum(good.getBeanNum());
		order.setCostBean(good.getCostBean());
		order.setCostMasonry(good.getCostMasonry());
		
		order.setCostMoney(good.getCostMoney());
		order.setCostType(good.getCostType());
		
		order.setGoodId(good.getId());
		order.setImgUrl(good.getImgUrl());
		order.setIsPay(0);
		order.setIsToAccount(0);
		order.setLoveModelNum(good.getLoveModelNum());
		order.setLoveNum(good.getLoveNum());
		order.setMasonryNum(good.getMasonryNum());
		order.setName(good.getName());
		order.setOrderType(Constant.GOOD_ORDER_TYPE);
		order.setPhyModelNum(good.getPhyModelNum());
		order.setRandomModelNum(good.getRandomModelNum());
		
		orderService.add(order);
		
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
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}

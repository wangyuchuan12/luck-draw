package com.wyc.draw.filter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.Account;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.service.AccountService;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.Order;
import com.wyc.draw.vo.RewardVo;

public class GoodOrderMasonryPayFilter extends Filter{

	@Autowired
	private AccountService accountService;
	
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		
		DrawUser drawUser = sessionManager.getObject(DrawUser.class);
		String orderId = (String)sessionManager.getAttribute("orderId");
		Order order = sessionManager.findOne(Order.class, orderId);
		
		Account account = accountService.fineOneSync(drawUser.getAccountId());
		
		Integer  masonry = account.getMasonry();
		
		if(order.getCostMasonry()==null||order.getCostMasonry()==0){
			ResultVo resultVo = new ResultVo();
			
			resultVo.setSuccess(false);
			
			resultVo.setErrorMsg("花费的砖石不能为0");
			
			Map<String, Object> data = new HashMap<>();
			
			data.put("errorCode", Constant.MASONRY_NUM_ERROR_CODE);
			
			resultVo.setData(data);
			
			sessionManager.setReturn(true);
			
			sessionManager.setReturnValue(resultVo);
		}else if(masonry<order.getCostMasonry()){
			ResultVo resultVo = new ResultVo();
			
			resultVo.setSuccess(false);
			
			resultVo.setErrorMsg("余额不足");
			
			Map<String, Object> data = new HashMap<>();
			
			data.put("errorCode", Constant.MASONRY_SHORTAGE_ERROR_CODE);
			
			resultVo.setData(data);
			
			sessionManager.setReturn(true);
			
			sessionManager.setReturnValue(resultVo);
		}else{
			
			
			
			RewardVo rewardVo = new RewardVo();
			rewardVo.setSubMasonry(order.getCostMasonry());
			
			rewardVo.setAddAmount(order.getAmountNum());
			rewardVo.setAddLoveLifeNum(order.getLoveNum());
			rewardVo.setAddWisdomNum(order.getBeanNum());
			
			sessionManager.save(rewardVo);
		}
	
		return null;
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

package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.Account;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.service.AccountService;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.RedPacketTakepartMember;

public class BalancePayTakepartFilter extends Filter{

	@Autowired
	private AccountService accountService;
	@Override
	public Object handlerBefore(SessionManager sessionManager) throws Exception {
		
		ResultVo resultVo = (ResultVo)sessionManager.getObject(ResultVo.class);
		
		RedPacketTakepartMember vieRedPacketTakepartMember = (RedPacketTakepartMember)resultVo.getData();
		
		DrawUser drawUser = (DrawUser)sessionManager.getObject(DrawUser.class);
		
		Account account = accountService.fineOneSync(drawUser.getAccountId());
		
		if(vieRedPacketTakepartMember.getIsGiveEntryFee()!=1){
			ResultVo errorResultVo = new ResultVo();
			errorResultVo.setSuccess(false);
			errorResultVo.setErrorMsg("该红包不需要上缴参赛费");
			sessionManager.setReturn(true);
			sessionManager.setReturnValue(errorResultVo);
			resultVo.setSuccess(false);
			return null;
		}
		
		if(account.getAmountBalance().compareTo(vieRedPacketTakepartMember.getEntryFee())<0){
			ResultVo errorResultVo = new ResultVo();
			errorResultVo.setSuccess(false);
			errorResultVo.setErrorMsg("该红包余额不足");
			sessionManager.setReturn(true);
			sessionManager.setReturnValue(errorResultVo);
			return null;
		}
		
		
		System.out.println("...........account:"+account.getAmountBalance());
		BigDecimal accountBalance = account.getAmountBalance();
		
		System.out.println(".............entryFee:"+vieRedPacketTakepartMember.getEntryFee());
		accountBalance = accountBalance.subtract(vieRedPacketTakepartMember.getEntryFee());
		
		System.out.println("...........account:"+account.getAmountBalance());
		
		account.setAmountBalance(accountBalance);
		accountService.update(account);
		
		return resultVo;

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
		List<Class<? extends Filter>> filters = new ArrayList<>();
		filters.add(VieTakepartFilter.class);
		return filters;
	}

}

package com.wyc.draw.filter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.Account;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.service.AccountService;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.RedPacketTakepartMember;
import com.wyc.draw.domain.RedPacketToTakepartMember;
import com.wyc.draw.service.RedPacketTakepartMemberService;

public class BalancePayTakepartFilter extends Filter{

	
	@Autowired
	private RedPacketTakepartMemberService redPacketTakepartMemberService;
	
	@Autowired
	private AccountService accountService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		
		ResultVo resultVo = (ResultVo)sessionManager.getObject(ResultVo.class);
		
		RedPacketTakepartMember vieRedPacketTakepartMember = (RedPacketTakepartMember)resultVo.getData();
		
		
		Account account = (Account)sessionManager.getObject(Account.class);
		
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
		
		BigDecimal accountBalance = account.getAmountBalance();

		accountBalance = accountBalance.subtract(vieRedPacketTakepartMember.getEntryFee());
		
		account.setAmountBalance(accountBalance);
		
		accountService.update(account);
		
		vieRedPacketTakepartMember.setIsPay(1);
	
		redPacketTakepartMemberService.update(vieRedPacketTakepartMember);
		
		RedPacketToTakepartMember vieRedPacketToTakepartMember = (RedPacketToTakepartMember)sessionManager.getObject(RedPacketToTakepartMember.class);
		vieRedPacketToTakepartMember.setIsPay(1);
		vieRedPacketToTakepartMember.setTakepartStatus(Constant.UNDERWAY_TAKEPART_STATUS);
		
		sessionManager.update(vieRedPacketToTakepartMember);
		
		System.out.println("takepartStatus:"+vieRedPacketToTakepartMember.getTakepartStatus());
		
		return resultVo;

	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> filters = new ArrayList<>();
		filters.add(VieTakepartFilter.class);
		return filters;
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

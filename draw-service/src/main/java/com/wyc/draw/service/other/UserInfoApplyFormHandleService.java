package com.wyc.draw.service.other;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.common.domain.Account;
import com.wyc.common.domain.ApplyForm;
import com.wyc.common.domain.PaySuccess;
import com.wyc.common.service.AccountService;
import com.wyc.common.service.ApplyFormService;
import com.wyc.common.service.PaySuccessService;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.service.DrawUserService;

@Service
public class UserInfoApplyFormHandleService {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private PaySuccessService paySuccessService;
	
	@Autowired
	private ApplyFormService applyFormService;

	@Transactional
	public Account handTakeIn(String accountId, ApplyForm applyForm) {
		if(applyForm.getStatus()==Constant.APPLY_FORM_STATUS_IN&&applyForm.getType()==Constant.APPLY_FORM_TYPE_TAKE_IN){
			PaySuccess paySuccess = paySuccessService.findOneByOutTradeNo(applyForm.getTradeOutNo());
			Account account = accountService.fineOneSync(accountId);
			
			if(paySuccess!=null){
				BigDecimal drawUserAmountBalance = account.getAmountBalance();
				if(drawUserAmountBalance==null){
					drawUserAmountBalance = new BigDecimal("0");
				}
				drawUserAmountBalance = drawUserAmountBalance.add(applyForm.getRealHandleAmount());
				account.setAmountBalance(drawUserAmountBalance);
				
				accountService.update(account);
				
				applyForm.setStatus(Constant.APPLY_FORM_STATUS_SUCCESS);
				
				applyFormService.update(applyForm);
				return account;
			}
		}
		return null;
		
	}
}

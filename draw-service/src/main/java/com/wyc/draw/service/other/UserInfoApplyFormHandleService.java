package com.wyc.draw.service.other;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.common.domain.ApplyForm;
import com.wyc.common.domain.PaySuccess;
import com.wyc.common.service.ApplyFormService;
import com.wyc.common.service.PaySuccessService;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.service.DrawUserService;

@Service
public class UserInfoApplyFormHandleService {

	@Autowired
	private DrawUserService drawUserService;
	
	@Autowired
	private PaySuccessService paySuccessService;
	
	@Autowired
	private ApplyFormService applyFormService;

	@Transactional
	public DrawUser handTakeIn(String drawUserId, ApplyForm applyForm) {
		if(applyForm.getStatus()==Constant.APPLY_FORM_STATUS_IN&&applyForm.getType()==Constant.APPLY_FORM_TYPE_TAKE_IN){
			PaySuccess paySuccess = paySuccessService.findOneByOutTradeNo(applyForm.getTradeOutNo());
			DrawUser drawUser = drawUserService.findOneWithLuck(drawUserId);
			if(paySuccess!=null){
				BigDecimal drawUserAmountBalance = drawUser.getAmountBalance();
				if(drawUserAmountBalance==null){
					drawUserAmountBalance = new BigDecimal("0");
				}
				drawUserAmountBalance = drawUserAmountBalance.add(applyForm.getRealHandleAmount());
				drawUser.setAmountBalance(drawUserAmountBalance);
				
				drawUserService.update(drawUser);
				
				applyForm.setStatus(Constant.APPLY_FORM_STATUS_SUCCESS);
				
				applyFormService.update(applyForm);
				return drawUser;
			}
		}
		return null;
		
	}
}

package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.ApplyForm;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.service.ApplyFormService;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.DrawUser;

public class TakeInApplyFilter extends Filter{

	@Autowired
	private ApplyFormService applyFormService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		
		DrawUser drawUser = (DrawUser)filterManager.getObject(DrawUser.class);
		String amount = httpServletRequest.getParameter("amount");
		
		if(CommonUtil.isEmpty(amount)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("对不起，请输入金额参数");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		
		BigDecimal amountBigDecimal = new BigDecimal(amount);
		
		if(amountBigDecimal.floatValue()<0.01){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("对不起，金额数量不能小于0.01元");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(amountBigDecimal.floatValue()>200){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("对不起，金额数量不能大于200元");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		ApplyForm applyForm = new ApplyForm();
		
		applyForm.setAmount(amountBigDecimal);
		applyForm.setApplyTime(new DateTime());
		
		
		Calendar now = Calendar.getInstance();
		now.setTime(new Date());
		
		String outTradeNo = now.get(Calendar.YEAR)
                +"-"+(now.get(Calendar.MONTH) + 1)
                +"-"+now.get(Calendar.DAY_OF_MONTH)
                +"-"+now.get(Calendar.HOUR_OF_DAY)
                +"-"+now.get(Calendar.MINUTE)
                +"-"+now.get(Calendar.SECOND)
                +"-"+now.get(Calendar.MILLISECOND)
                +"-"+new Random().nextInt(1000)+"";
		
		applyForm.setTradeOutNo(outTradeNo);
		applyForm.setType(Constant.APPLY_FORM_TYPE_TAKE_IN);
		
		applyForm.setStatus(Constant.APPLY_FORM_STATUS_IN);
		
		applyForm.setAmount(amountBigDecimal);
		applyForm.setOpenid(drawUser.getOpenid());
		applyForm.setRealHandleAmount(amountBigDecimal);
		
		applyFormService.add(applyForm);
		return applyForm;
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
		// TODO Auto-generated method stub
		return null;
	}

}

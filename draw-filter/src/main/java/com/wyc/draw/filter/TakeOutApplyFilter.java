package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
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
import com.wyc.common.wx.domain.UserInfo;

public class TakeOutApplyFilter extends Filter{

	@Autowired
	private ApplyFormService applyFormService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(new Date());
//		StringBuffer sb = new StringBuffer();
//		sb.append("42899912");
//		sb.append(calendar.get(Calendar.YEAR));
//		sb.append(calendar.get)
		
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		
		
		UserInfo userInfo = (UserInfo)filterManager.getObject(UserInfo.class);
		String amount = httpServletRequest.getParameter("amount");
		
		if(CommonUtil.isEmpty(amount)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("提现金额不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		BigDecimal amountBigDecimal = new BigDecimal(amount);
		
		if(new BigDecimal(amountBigDecimal.intValue()).compareTo(amountBigDecimal)!=0){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("提现金额必须是整数");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(amountBigDecimal.compareTo(new BigDecimal("200"))>0){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("提现金额不能超过200块");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
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
		
		
		ApplyForm applyForm = new ApplyForm();
		applyForm.setAmount(amountBigDecimal);
		applyForm.setApplyTime(new DateTime());
		applyForm.setTradeOutNo(outTradeNo);
		applyForm.setMsg(userInfo.getNickname()+"申请提现"+amount+"元");
		applyForm.setOpenid(userInfo.getOpenid());
		applyForm.setStatus(Constant.APPLY_FORM_STATUS_IN);
		applyForm.setType(Constant.APPLY_FORM_TYPE_TAKE_OUT);
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
		List<Class<? extends Filter>> filters = new ArrayList<>();
		filters.add(DrawUserFilter.class);
		return filters;
	}

}

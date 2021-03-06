package com.wyc.draw.filter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.Account;
import com.wyc.common.domain.ApplyForm;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.domain.vo.TransfersResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.service.AccountService;
import com.wyc.common.service.ApplyFormService;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.common.util.Constant;
import com.wyc.common.wx.domain.Article;
import com.wyc.common.wx.domain.UserInfo;
import com.wyc.common.wx.domain.WxContext;
import com.wyc.common.wx.service.SendMessageService;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.service.other.PayService;


public class TakeOutApplyFilter extends Filter{

	@Autowired
	private ApplyFormService applyFormService;
	
	@Autowired
	private PayService payService;
	
	@Autowired
	private WxContext wxContext;
	
	@Autowired
	private SendMessageService sendMessageService;
	
	@Autowired
	private AccountService accountService;
	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(new Date());
//		StringBuffer sb = new StringBuffer();
//		sb.append("42899912");
//		sb.append(calendar.get(Calendar.YEAR));
//		sb.append(calendar.get)
		
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		
		
		UserInfo userInfo = (UserInfo)filterManager.getObject(UserInfo.class);
		DrawUser drawUser = (DrawUser)filterManager.getObject(DrawUser.class);
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
//		String outTradeNo = now.get(Calendar.YEAR)
//                +"-"+(now.get(Calendar.MONTH) + 1)
//                +"-"+now.get(Calendar.DAY_OF_MONTH)
//                +"-"+now.get(Calendar.HOUR_OF_DAY)
//                +"-"+now.get(Calendar.MINUTE)
//                +"-"+now.get(Calendar.SECOND)
//                +"-"+now.get(Calendar.MILLISECOND)
//                +"-"+new Random().nextInt(1000)+"";
		
		

		Account account = accountService.fineOneSync(drawUser.getAccountId());
		if(account.getCanTakeOutCount()<=0){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("用户本月可提现次数已经用完");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(account.getAmountBalance()==null||account.getAmountBalance().compareTo(amountBigDecimal)<0){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("对不起，余额不足");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		ApplyForm applyForm = new ApplyForm();
		applyForm.setAmount(amountBigDecimal);
		applyForm.setApplyTime(new DateTime());
		//applyForm.setTradeOutNo(outTradeNo);
		applyForm.setMsg(userInfo.getNickname()+"申请提现"+amount+"元");
		applyForm.setOpenid(userInfo.getOpenid());
		applyForm.setStatus(Constant.APPLY_FORM_STATUS_IN);
		
	
		applyForm.setType(Constant.APPLY_FORM_TYPE_TAKE_OUT);
		
		BigDecimal realAmountBigDecimal = new BigDecimal(amountBigDecimal.floatValue());
		
		BigDecimal transferFeeBigDecimal = new BigDecimal(wxContext.getTransferFee());
		transferFeeBigDecimal = transferFeeBigDecimal.divide(new BigDecimal(100));
		realAmountBigDecimal = realAmountBigDecimal.subtract(realAmountBigDecimal.multiply(transferFeeBigDecimal));
		
		
		applyForm.setRealHandleAmount(realAmountBigDecimal);
		applyFormService.add(applyForm);
		
		account.setAmountBalance(account.getAmountBalance().subtract(amountBigDecimal));
		
		account.setCanTakeOutCount(account.getCanTakeOutCount()-1);
		accountService.update(account);
		
		try{
			
			TransfersResultVo resultVo = null;
			if(wxContext.getInstantArrival()==1){
				resultVo = payService.transfers(userInfo.getOpenid(), realAmountBigDecimal, httpServletRequest.getRemoteAddr(), drawUser.getNickname()+"提取现金红包,openid:"+drawUser.getOpenid());
			}
			
			if(resultVo!=null){
				applyForm.setTradeOutNo(resultVo.getOutTradeNo());
			}else{
				resultVo = new TransfersResultVo();
			}
			if(resultVo!=null&&resultVo.getResultCode()!=null&&resultVo.getResultCode().equals("SUCCESS")){
				applyForm.setStatus(Constant.APPLY_FORM_STATUS_SUCCESS);
				applyForm.setHandleTime(new DateTime());
				applyFormService.update(applyForm);
				
				
				List<Article> articles = new ArrayList<>();
				Article article = new Article();
				article.setDescription("你申请的金额"+applyForm.getRealHandleAmount()+"元已经入账，点击查看详情");
				article.setTitle("红包提现入账通知");
				article.setUrl(wxContext.getDomainName()+"/view/draw/personal_center/main");
				articles.add(article);
				
				sendMessageService.sendImgMessage(applyForm.getOpenid(), articles);
			}else{
				
				
				applyForm.setStatus(Constant.APPLY_FORM_STATUS_FAILURE);
				applyForm.setHandleTime(new DateTime());
				
				if(wxContext.getInstantArrival()==1){
					applyForm.setMsg(userInfo.getNickname()+"申请提现失败"+","+resultVo.getReturnMsg());
					applyForm.setErrCode(resultVo.getErrCode());
					applyForm.setErrorCount(1);
				}else{
					applyForm.setMsg(userInfo.getNickname()+"非即时到账"+","+resultVo.getReturnMsg());
					applyForm.setErrorCount(0);
				}
				
				applyFormService.update(applyForm);
				
				List<Article> articles = new ArrayList<>();
				Article article = new Article();
				article.setDescription("你申请的金额"+applyForm.getRealHandleAmount()+"提交成功，现金将会在24个小时内入账，点击查看详情");
				article.setTitle("红包现金申请成功通知");
				article.setUrl(wxContext.getDomainName()+"/view/draw/personal_center/main");
				articles.add(article);
				
				sendMessageService.sendImgMessage(applyForm.getOpenid(), articles);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		filterManager.save(drawUser);
		return applyForm;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> filters = new ArrayList<>();
		filters.add(DrawUserFilter.class);
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

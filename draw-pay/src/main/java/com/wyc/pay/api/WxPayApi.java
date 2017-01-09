package com.wyc.pay.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.domain.vo.WxChooseWxPayBean;
import com.wyc.common.session.SessionManager;
import com.wyc.pay.filter.ChooseWxPayFilter;

@Controller
@RequestMapping(value="/api/pay/wx/")
public class WxPayApi {
	
	@HandlerAnnotation(hanlerFilter=ChooseWxPayFilter.class)
	@RequestMapping(value="choose_wx_pay_config")
	@ResponseBody
	public Object chooseWxPayConfig(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		WxChooseWxPayBean chooseWxPayBean = (WxChooseWxPayBean)sessionManager.getObject(WxChooseWxPayBean.class);
		return chooseWxPayBean;
	}
}

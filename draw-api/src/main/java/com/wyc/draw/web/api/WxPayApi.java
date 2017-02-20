package com.wyc.draw.web.api;
import javax.servlet.http.HttpServletRequest;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.domain.PaySuccess;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.domain.vo.WxChooseWxPayBean;
import com.wyc.common.filter.UserInfoFilter;
import com.wyc.common.service.PaySuccessService;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.XmlUtil;
import com.wyc.draw.filter.pay.ChooseWxPayFilter;
import com.wyc.draw.service.other.PayService;



@Controller
@RequestMapping(value="/api/pay/wx/")
public class WxPayApi {
	
	@Autowired
	private PaySuccessService paySuccessService;
	
	
	@Autowired
	private PayService payService;
	
	@HandlerAnnotation(hanlerFilter=ChooseWxPayFilter.class)
	@RequestMapping(value="choose_wx_pay_config")
	@ResponseBody
	public Object chooseWxPayConfig(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		ResultVo resultVo = (ResultVo)sessionManager.getObject(ResultVo.class);
		if(sessionManager.getObject(ResultVo.class)!=null){
			resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setMsg("返回数据失败");
			return sessionManager.getObject(ResultVo.class);
		}
		WxChooseWxPayBean chooseWxPayBean = (WxChooseWxPayBean)sessionManager.getObject(WxChooseWxPayBean.class);
		resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setMsg("返回数据成功");
		resultVo.setData(chooseWxPayBean);
		return resultVo;
	}
	
	@ResponseBody
	@RequestMapping(value="pa_pay_success")
	public Object qaPaySuccess(HttpServletRequest httpServletRequest)throws Exception{
		SAXBuilder saxBuilder = new SAXBuilder();
		Document document = saxBuilder.build(httpServletRequest.getInputStream());
		PaySuccess paySuccess = XmlUtil.xmlToObject(document,PaySuccess.class);
		PaySuccess paySuccess2 = paySuccessService.findOneByOutTradeNo(paySuccess.getOutTradeNo());
		if(paySuccess2==null){
			if(paySuccess.getNonceStr().equals("1add1a30ac87aa2db72f57a2375d8f22")&&paySuccess.getResultCode().equals("SUCCESS")){
			
				paySuccessService.add(paySuccess);
			}
		}
		return paySuccess;
	}
	
	@ResponseBody
	@HandlerAnnotation(hanlerFilter=UserInfoFilter.class)
	@RequestMapping(value="pay_success")
	public Object paySuccess(HttpServletRequest httpServletRequest)throws Exception{
		SAXBuilder saxBuilder = new SAXBuilder();
		Document document = saxBuilder.build(httpServletRequest.getInputStream());
		PaySuccess paySuccess = XmlUtil.xmlToObject(document,PaySuccess.class);
		PaySuccess paySuccess2 = paySuccessService.findOneByOutTradeNo(paySuccess.getOutTradeNo());
		if(paySuccess2==null){
			if(paySuccess.getNonceStr().equals("1add1a30ac87aa2db72f57a2375d8f22")&&paySuccess.getResultCode().equals("SUCCESS")){
			
				paySuccessService.add(paySuccess);
			}
		}
		return paySuccess;
	} 
}
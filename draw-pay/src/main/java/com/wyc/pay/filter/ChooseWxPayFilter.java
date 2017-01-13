package com.wyc.pay.filter;

import java.io.StringReader;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.domain.vo.WxChooseWxPayBean;
import com.wyc.common.filter.BaseActionFilter;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.common.util.MD5Util;
import com.wyc.common.util.Request;
import com.wyc.common.util.RequestFactory;
import com.wyc.common.util.Response;
import com.wyc.common.wx.domain.UserInfo;
import com.wyc.common.wx.domain.WxContext;

public class ChooseWxPayFilter extends Filter{

	@Autowired
	private RequestFactory requestFactory;
	
	@Autowired
	private WxContext wxContext;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		
		UserInfo userInfo = (UserInfo) filterManager.getObject(UserInfo.class);
		
		String openid = userInfo.getOpenid();
		String cost = httpServletRequest.getParameter("cost");
		
		if(CommonUtil.isEmpty(cost)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("输入的金额不能为空");
			filterManager.setEnd(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		BigDecimal costBigDecimail = null;
		try{
			costBigDecimail = new BigDecimal(cost);
		}catch(Exception e){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("输入的参数cost不是数字类型");
			filterManager.setEnd(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		
		if(costBigDecimail.floatValue()==0){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("输入的参数cost数值不能为0");
			filterManager.setEnd(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		
		String body = httpServletRequest.getParameter("body");
		
		if(CommonUtil.isEmpty(body)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("支付body不能为空");
			filterManager.setEnd(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		String detail = httpServletRequest.getParameter("detail");
		
		if(CommonUtil.isEmpty(detail)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("支付detail不能为空");
			filterManager.setEnd(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		
		
		
        /*Calendar now = Calendar.getInstance();
         * String outTradeNo = now.get(Calendar.YEAR)
                +"-"+(now.get(Calendar.MONTH) + 1)
                +"-"+now.get(Calendar.DAY_OF_MONTH)
                +"-"+now.get(Calendar.HOUR_OF_DAY)
                +"-"+now.get(Calendar.MINUTE)
                +"-"+now.get(Calendar.SECOND)
                +"-"+now.get(Calendar.MILLISECOND)
                +"-"+new Random().nextInt(1000)+"";*/
		
		String outTradeNo = httpServletRequest.getParameter("outTradeNo");
		
		if(CommonUtil.isEmpty(outTradeNo)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("商品订单号不能为空");
			filterManager.setEnd(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
        
        
        
        Request request = requestFactory.payUnifiedorder();
        String appid = wxContext.getAppid();
        String attach = "paytest";
        String mchId = wxContext.getMchId();
        String nonceStr = "1add1a30ac87aa2db72f57a2375d8f22";
        String notifyUrl = "http://"+wxContext.getDomainName()+"/api/pay/wx/pay_success";
        String spbillCreateIp = httpServletRequest.getRemoteAddr();
        String datetime = String.valueOf(System.currentTimeMillis() / 1000);
        BigDecimal totalFee = costBigDecimail.multiply(new BigDecimal(100));
        Long totalFeeLong = totalFee.setScale(0, BigDecimal.ROUND_HALF_UP).longValue();
        String tradeType = "JSAPI";
        TreeMap<String, String> map = new TreeMap<String, String>();
        map.put("openid", openid);
        map.put("body", body);
        map.put("out_trade_no", outTradeNo);
        map.put("total_fee", totalFeeLong+"");
        map.put("notify_url", notifyUrl);
        map.put("trade_type", tradeType);
        map.put("appid", appid);
        map.put("mch_id", mchId);
        map.put("spbill_create_ip", spbillCreateIp);
        map.put("nonce_str", nonceStr);
        map.put("attach", attach);
        map.put("detail", detail);
        String sign = MD5Util.createMd5Sign(map,wxContext.getKey()).toUpperCase();
        StringBuffer sb2 = new StringBuffer();
        sb2.append("<xml>");
        sb2.append("<appid>"+appid+"</appid>");
        sb2.append("<attach>"+attach+"</attach>");
        sb2.append("<body>"+body+"</body>");
        sb2.append("<mch_id>"+mchId+"</mch_id>");
        sb2.append("<nonce_str>"+nonceStr+"</nonce_str>");
        sb2.append("<notify_url>"+notifyUrl+"</notify_url>");
        sb2.append("<openid>"+openid+"</openid>");
        sb2.append("<out_trade_no>"+outTradeNo+"</out_trade_no>");
        sb2.append("<spbill_create_ip>"+spbillCreateIp+"</spbill_create_ip>");
        sb2.append("<total_fee>"+totalFeeLong+"</total_fee>");
        sb2.append("<detail>"+detail+"</detail>");
        sb2.append("<trade_type>"+tradeType+"</trade_type>");
        sb2.append("<sign>"+sign+"</sign>");
        sb2.append("</xml>");
        Response response = request.post(sb2.toString());
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(new StringReader(response.read()));
        Element rootElement = document.getRootElement();
        
        String returnCode = rootElement.getChildText("return_code");
        
        if(returnCode.equals("SUCCESS")){
	        String prepayId = rootElement.getChildText("prepay_id");
	        datetime = String.valueOf(System.currentTimeMillis() / 1000);
	        SortedMap<String, String> map2  = new TreeMap<String, String>();
	        map2.put("appId", wxContext.getAppid());
	        map2.put("nonceStr", nonceStr);
	        map2.put("package", "prepay_id="+prepayId);
	        map2.put("signType", "MD5");
	        map2.put("timeStamp", datetime);
	        String paySign = MD5Util.createMd5Sign(map2,wxContext.getKey()).toUpperCase();
	        
	        WxChooseWxPayBean wxChooseWxPayBean = new WxChooseWxPayBean();
	        
	        
	        wxChooseWxPayBean.setPrepayId(prepayId);
	        wxChooseWxPayBean.setPack("prepay_id="+prepayId);
	        wxChooseWxPayBean.setNonceStr(nonceStr);
	        wxChooseWxPayBean.setPaySign(paySign);
	        wxChooseWxPayBean.setSignType("MD5");
	        wxChooseWxPayBean.setTimestamp(datetime);
	        wxChooseWxPayBean.setAppId(wxContext.getAppid());
	        
	        wxChooseWxPayBean.setOutTradeNo(outTradeNo);
	        wxChooseWxPayBean.setCost(costBigDecimail);
	       
			return wxChooseWxPayBean;
        }else{
        	ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("支付失败了");
			filterManager.setEnd(true);
			filterManager.setReturnValue(resultVo);
			return null;
        }
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
		List<Class<? extends Filter>> filtes = new ArrayList<>();
		filtes.add(BaseActionFilter.class);
		return filtes;
	}

}

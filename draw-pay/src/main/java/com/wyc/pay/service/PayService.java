package com.wyc.pay.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Random;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.common.util.MD5Util;
import com.wyc.common.util.Request;
import com.wyc.common.util.RequestFactory;
import com.wyc.common.util.Response;
import com.wyc.common.wx.domain.WxContext;

@Service
public class PayService {
	
	@Autowired
	private RequestFactory requestFactory;
	
	@Autowired
	private WxContext wxContext;
	public String transfers(String openid,BigDecimal amount,String remoteAddress)throws Exception{
		String appid = wxContext.getAppid();
		String mchid = wxContext.getMchId();
		String deviceInfo = "wyc";
		String nonceStr = "1add1a30ac87aa2db72f57a2375d8f22";
		Calendar now = Calendar.getInstance();
        String outTradeNo = now.get(Calendar.YEAR)
                +"-"+(now.get(Calendar.MONTH) + 1)
                +"-"+now.get(Calendar.DAY_OF_MONTH)
                +"-"+now.get(Calendar.HOUR_OF_DAY)
                +"-"+now.get(Calendar.MINUTE)
                +"-"+now.get(Calendar.SECOND)
                +"-"+now.get(Calendar.MILLISECOND)
                +"-"+new Random().nextInt(1000)+"";
        String checkName = "NO_CHECK";
        String desc = "转账";
        String spbillCreateIp = remoteAddress;
        
        BigDecimal totalFree = amount.multiply(new BigDecimal(100));
        
        Long totalFeeLong = totalFree.setScale(0, BigDecimal.ROUND_HALF_UP).longValue();
        TreeMap<String, String> map = new TreeMap<String, String>();
        map.put("mch_appid", appid);
        map.put("mchid", mchid);
        map.put("device_info", deviceInfo);
        map.put("nonce_str", nonceStr);
        map.put("partner_trade_no", outTradeNo);
        map.put("openid",openid);
        map.put("check_name", checkName);
        map.put("amount", totalFeeLong+"");
        map.put("desc", desc);
        map.put("spbill_create_ip", spbillCreateIp);
        
        String sign = MD5Util.createMd5Sign(map,wxContext.getKey()).toUpperCase();
        
        
        StringBuffer sb2 = new StringBuffer();
        sb2.append("<xml>");
        sb2.append("<mch_appid>"+appid+"</mch_appid>");
        sb2.append("<mchid>"+mchid+"</mchid>");
        sb2.append("<nonce_str>"+nonceStr+"</nonce_str>");
        sb2.append("<partner_trade_no>"+outTradeNo+"</partner_trade_no>");
        sb2.append("<openid>"+openid+"</openid>");
        sb2.append("<check_name>"+checkName+"</check_name>");
        sb2.append("<amount>"+totalFeeLong+"</amount>");
        sb2.append("<desc>"+outTradeNo+"</desc>");
        sb2.append("<spbill_create_ip>"+spbillCreateIp+"</spbill_create_ip>");
        sb2.append("<sign>"+sign+"</sign>");
        sb2.append("</xml>");
        
        Request request = requestFactory.transfers();
        
        Response response = request.post(sb2.toString());
        
        return response.read();
	}
}

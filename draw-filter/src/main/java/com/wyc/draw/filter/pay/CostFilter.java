package com.wyc.draw.filter.pay;

import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.service.RedPacketService;
import com.wyc.draw.vo.PayCostVo;


public class CostFilter extends Filter{

	@Autowired
	private RedPacketService redPacketService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		String type = httpServletRequest.getParameter("type");
		if(CommonUtil.isEmpty(type)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("type参数不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			filterManager.save(resultVo);
			return null;
		}
		
		Integer typeInt;
		try{
			typeInt = Integer.parseInt(type);
		}catch(Exception e){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("type无法转变成数字");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			filterManager.save(resultVo);
			return null;
		}
		

        Calendar now = Calendar.getInstance();
        String outTradeNo = now.get(Calendar.YEAR)
                +"-"+(now.get(Calendar.MONTH) + 1)
                +"-"+now.get(Calendar.DAY_OF_MONTH)
                +"-"+now.get(Calendar.HOUR_OF_DAY)
                +"-"+now.get(Calendar.MINUTE)
                +"-"+now.get(Calendar.SECOND)
                +"-"+now.get(Calendar.MILLISECOND)
                +"-"+new Random().nextInt(1000)+"";
        
        String noticStr = "1add1a30ac87aa2db72f57a2375d8f22";
		
		PayCostVo payCostVo = new PayCostVo();
		payCostVo.setNonceStr(noticStr);
		payCostVo.setOutTradeNo(outTradeNo);
		if(typeInt==Constant.PAY_QA_TYPE){
			String redPacketId = httpServletRequest.getParameter("red_packet_id");
			if(CommonUtil.isEmpty(redPacketId)){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("redPacketId参数不能为空");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				filterManager.save(resultVo);
				return null;
			}
			RedPacket redPacket = redPacketService.findOne(redPacketId);
			if(CommonUtil.isEmpty(redPacket)){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("返回的redPacket对象为空");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				filterManager.save(resultVo);
				return null;
			}
			if(redPacket.getType()!=Constant.QUESTION_TYPE){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("该红包类型不是问答红包");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				filterManager.save(resultVo);
				return null;
			}
			
			String notifyUrl = Constant.PAY_QA_TYPE_NONCE_URL+"?redPacketId="+redPacketId;
			payCostVo.setNotifyUrl(notifyUrl);
			payCostVo.setPayType(Constant.PAY_QA_TYPE);
			payCostVo.setCost(redPacket.getAmount());
			return payCostVo;
		}else if(typeInt == Constant.PAY_VIE_TYPE){
			String redPacketId = httpServletRequest.getParameter("red_packet_id");
			if(CommonUtil.isEmpty(redPacketId)){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("redPacketId参数不能为空");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				filterManager.save(resultVo);
				return null;
			}
			RedPacket redPacket = redPacketService.findOne(redPacketId);
			if(CommonUtil.isEmpty(redPacket)){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("返回的redPacket对象为空");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				filterManager.save(resultVo);
				return null;
			}
			if(redPacket.getType()!=Constant.VIE_TYPE){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("该红包类型不是竞答红包");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				filterManager.save(resultVo);
				return null;
			}
			
			payCostVo.setNotifyUrl(Constant.PAY_VIE_TYPE_NONCE_URL);
			payCostVo.setPayType(Constant.PAY_VIE_TYPE);
			payCostVo.setCost(redPacket.getAmount());
			return payCostVo;
		}
		return null;
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

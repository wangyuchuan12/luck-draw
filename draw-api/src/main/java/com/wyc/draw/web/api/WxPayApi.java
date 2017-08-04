package com.wyc.draw.web.api;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

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
import com.wyc.common.util.Constant;
import com.wyc.common.util.XmlUtil;
import com.wyc.draw.domain.Order;
import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.domain.RedPacketTakepartMember;
import com.wyc.draw.domain.RedPacketToTakepartMember;
import com.wyc.draw.filter.controller.api.ChooseGoodMasonryPayApiFilter;
import com.wyc.draw.filter.controller.api.ChooseGoodWxPayApiFilter;
import com.wyc.draw.filter.pay.ChooseWxPayFilter;
import com.wyc.draw.service.RedPacketService;
import com.wyc.draw.service.RedPacketTakepartMemberService;
import com.wyc.draw.service.VieRedPacketToTakepartMemberService;
import com.wyc.draw.vo.RewardVo;

@Controller
@RequestMapping(value="/api/pay/wx/")
public class WxPayApi {
	
	@Autowired
	private PaySuccessService paySuccessService;

	@Autowired
	private RedPacketService redPacketService;
	
	@Autowired
	private RedPacketTakepartMemberService redPacketTakepartMemberService;
	
	@Autowired
	private VieRedPacketToTakepartMemberService vieRedPacketToTakepartMemberService;
	
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
	
	
	
	@Transactional
	@HandlerAnnotation(hanlerFilter=ChooseGoodMasonryPayApiFilter.class)
	@RequestMapping(value="choose_good_masonry_pay")
	@ResponseBody
	public Object chooseGoodMasonryPay(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		System.out.println("请问这里有没有进来");
		if(sessionManager.isReturn()){
			ResultVo resultVo = (ResultVo)sessionManager.getReturnValue();
			System.out.println("isReturn:"+resultVo);
			return resultVo;
		}else{
			RewardVo rewardVo = sessionManager.getObject(RewardVo.class);
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(true);
			resultVo.setData(rewardVo);
			return resultVo;
		}
	}
	
	@Transactional
	@HandlerAnnotation(hanlerFilter=ChooseGoodWxPayApiFilter.class)
	@RequestMapping(value="choose_good_wx_pay_config")
	@ResponseBody
	public Object chooseGoodWxPayConfig(HttpServletRequest httpServletRequest)throws Exception{
		
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		ResultVo resultVo = (ResultVo)sessionManager.getObject(ResultVo.class);
		if(sessionManager.getObject(ResultVo.class)!=null){
			resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setMsg("返回数据失败");
			return sessionManager.getObject(ResultVo.class);
		}
		WxChooseWxPayBean chooseWxPayBean = (WxChooseWxPayBean)sessionManager.getObject(WxChooseWxPayBean.class);
		
		Order order = sessionManager.getObject(Order.class);
		
		Map<String, Object> data = new HashMap<>();
		data.put("chooseWxPayBean", chooseWxPayBean);
		data.put("order", order);

		resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setMsg("返回数据成功");
		resultVo.setData(data);
		return resultVo;
	}
	
	
	
	@ResponseBody
	@Transactional
	@RequestMapping(value="order_pay_success")
	public Object orderPaySuccess(HttpServletRequest httpServletRequest)throws Exception{
		SAXBuilder saxBuilder = new SAXBuilder();
		Document document = saxBuilder.build(httpServletRequest.getInputStream());
		PaySuccess paySuccess = XmlUtil.xmlToObject(document,PaySuccess.class);
		PaySuccess paySuccess2 = paySuccessService.findOneByOutTradeNo(paySuccess.getOutTradeNo());
		if(paySuccess2==null){
			if(paySuccess.getNonceStr().equals("2add1a30ac87aa2db72f57a2375d8f25")&&paySuccess.getResultCode().equals("SUCCESS")){
				System.out.println("......................支付成功");
			}
		}
		return paySuccess;
	}
	
	
	@ResponseBody
	@Transactional
	@RequestMapping(value="pa_pay_success")
	public Object qaPaySuccess(HttpServletRequest httpServletRequest)throws Exception{
		SAXBuilder saxBuilder = new SAXBuilder();
		Document document = saxBuilder.build(httpServletRequest.getInputStream());
		PaySuccess paySuccess = XmlUtil.xmlToObject(document,PaySuccess.class);
		PaySuccess paySuccess2 = paySuccessService.findOneByOutTradeNo(paySuccess.getOutTradeNo());
		if(paySuccess2==null){
			if(paySuccess.getNonceStr().equals("2add1a30ac87aa2db72f57a2375d8f25")&&paySuccess.getResultCode().equals("SUCCESS")){
				RedPacket redPacket = redPacketService.findOneByOutTradeNo(paySuccess.getOutTradeNo());
				redPacket.setIsPay(1);
				redPacket.setIsDisplay(1);
				redPacketService.update(redPacket);
				paySuccessService.add(paySuccess);
			}
		}
		return paySuccess;
	}
	
	@ResponseBody
	@Transactional
	@RequestMapping(value="vie_pay_success")
	public Object viePaySuccess(HttpServletRequest httpServletRequest)throws Exception{
		SAXBuilder saxBuilder = new SAXBuilder();
		Document document = saxBuilder.build(httpServletRequest.getInputStream());
		PaySuccess paySuccess = XmlUtil.xmlToObject(document,PaySuccess.class);		
		PaySuccess paySuccess2 = paySuccessService.findOneByOutTradeNo(paySuccess.getOutTradeNo());
		if(paySuccess2==null){
			if(paySuccess.getNonceStr().equals("2add1a30ac87aa2db72f57a2375d8f23")&&paySuccess.getResultCode().equals("SUCCESS")){
				RedPacket redPacket = redPacketService.findOneByOutTradeNo(paySuccess.getOutTradeNo());
				redPacket.setIsPay(1);
				redPacket.setIsDisplay(1);
				redPacketService.update(redPacket);
				paySuccessService.add(paySuccess);
			}
		}
		return paySuccess;
	}
	
	@ResponseBody
	@Transactional
	@RequestMapping(value="vie_takepart_pay_success")
	public Object vieTakepartPaySuccess(HttpServletRequest httpServletRequest)throws Exception{
		SAXBuilder saxBuilder = new SAXBuilder();
		Document document = saxBuilder.build(httpServletRequest.getInputStream());
		PaySuccess paySuccess = XmlUtil.xmlToObject(document,PaySuccess.class);		
		PaySuccess paySuccess2 = paySuccessService.findOneByOutTradeNo(paySuccess.getOutTradeNo());
		if(paySuccess2==null){
			if(paySuccess.getNonceStr().equals("2add1a30ac87aa2db72f57a2375d2232s")&&paySuccess.getResultCode().equals("SUCCESS")){
				RedPacketTakepartMember redPacketTakepartMember = redPacketTakepartMemberService.findByOutTradeNo(paySuccess.getOutTradeNo());
				redPacketTakepartMember.setIsPay(1);
				redPacketTakepartMemberService.update(redPacketTakepartMember);
				paySuccessService.add(paySuccess);
				
				RedPacketToTakepartMember vieRedPacketToTakepartMember = vieRedPacketToTakepartMemberService.findByDrawUserIdAndRedPacketId(redPacketTakepartMember.getDrawUserId(), redPacketTakepartMember.getRedPacketId());
				
				vieRedPacketToTakepartMember.setIsPay(1);
				vieRedPacketToTakepartMember.setTakepartStatus(Constant.UNDERWAY_TAKEPART_STATUS);
				vieRedPacketToTakepartMemberService.update(vieRedPacketToTakepartMember);
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
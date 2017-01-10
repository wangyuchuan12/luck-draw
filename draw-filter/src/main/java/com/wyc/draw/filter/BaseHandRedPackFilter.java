package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.DrawRoomMember;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.service.DrawRoomMemberService;
import com.wyc.draw.service.DrawUserService;
import com.wyc.draw.service.RedPackageService;
import com.wyc.draw.vo.RedPacketVo;


//发送红包的基类
public class BaseHandRedPackFilter extends Filter{

	@Autowired
	private RedPackageService redPackageService;
	
	@Autowired
	private DrawRoomMemberService drawRoomMemberService;
	
	@Autowired
	private DrawUserService drawUserService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		
		Integer timeLong = 24;
		DrawUser drawUser = (DrawUser)filterManager.getObject(DrawUser.class);

		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		
		String drawRoomId = httpServletRequest.getParameter("draw_room_id");
		
		
		String type = httpServletRequest.getParameter("type");
		
		String amount = httpServletRequest.getParameter("amount");
		
		String question = httpServletRequest.getParameter("question");
		
		String answer = httpServletRequest.getParameter("answer");
		
		String payType = httpServletRequest.getParameter("payType");
		
		if(CommonUtil.isEmpty(amount)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("输入的金额数量不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(CommonUtil.isEmpty(type)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("参数type不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		BigDecimal amountBigDecimal = new BigDecimal(amount);
		Integer typeInt = Integer.parseInt(type);
		
		
		if(CommonUtil.isEmpty(payType)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("支付类型不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}else{
			Integer payTypeInt = Integer.parseInt(payType);
			if(payTypeInt!=Constant.ACCOUNT_PAY_TYPE&&payTypeInt!=Constant.WX_PAY_TYPE){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("支付类型不合法");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
			
			if(payTypeInt==Constant.ACCOUNT_PAY_TYPE){
				
				//涉及到用户的账户余额资金数据，必须要加锁
				drawUser = drawUserService.findByUserIdWithLuck(drawUser.getUserId());
				if(drawUser.getAmountBalance().compareTo(amountBigDecimal)<0){
					ResultVo resultVo = new ResultVo();
					resultVo.setSuccess(false);
					resultVo.setErrorMsg("账户可用余额小于实际可用余额");
					filterManager.setReturn(true);
					filterManager.setReturnValue(resultVo);
					return null;
				}else{
					drawUser.setAmountBalance(drawUser.getAmountBalance().subtract(amountBigDecimal));
					drawUserService.update(drawUser);
					filterManager.save(drawUser);
				}
			}
		}
		
		
		RedPacket redPacket = new RedPacket();
		
		if(CommonUtil.isEmpty(question)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("问题红包参数question不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(CommonUtil.isEmpty(answer)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("问题红包参数answer不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		Integer payTypeInt = Integer.parseInt(payType);
		//如果是账号余额付款，就把状态改成已支付，直接扣除账号中的余额,领取状态也改成可领取
		if(payTypeInt==Constant.ACCOUNT_PAY_TYPE){
			redPacket.setIsPay(1);
			redPacket.setIsReceiveAble(1);
		}else{
			redPacket.setIsPay(0);
			redPacket.setIsReceiveAble(0);
		}
		
		redPacket.setIsReceive(0);
		redPacket.setPayType(payTypeInt);
		redPacket.setIsTimeout(0);
		if(typeInt==Constant.ROOM_QUESTION_TYPE){
			DrawRoomMember drawRoomMember = drawRoomMemberService.findByDrawUserIdAndDrawRoomId(drawUser.getId(),drawRoomId);
			ResultVo resultVo = new ResultVo();
			if(CommonUtil.isEmpty(drawRoomId)){
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("该红包为房间红包，drawRoomId参数不能为空");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
			
			if(CommonUtil.isEmpty(drawRoomMember)){
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("该用户不在该房间中，无法执行发红包操作");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
				
			}
			
			redPacket.setDrawRoomId(drawRoomId);
			redPacket.setHandDrawUserId(drawUser.getId());
			
			
			redPacket.setHandRoomMemberId(drawRoomMember.getId());
			
			redPacket.setQuestion(question);
			redPacket.setAnswer(answer);
			redPacket.setHandTime(new DateTime());
			redPacket.setTimeLong(timeLong);
			redPacket.setType(typeInt);
			redPacket.setAmount(amountBigDecimal);
			
			
			redPacket = redPackageService.add(redPacket);
		}else if(typeInt==Constant.PERSONAL_QUESTION_TYPE){
			
			redPacket.setQuestion(question);
			redPacket.setAnswer(answer);
			redPacket.setHandDrawUserId(drawUser.getId());
			redPacket.setHandTime(new DateTime());
			redPacket.setTimeLong(timeLong);
			redPacket.setType(typeInt);
			redPacket.setAmount(amountBigDecimal);
			redPacket = redPackageService.add(redPacket);
		}else{
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("输入的红包类型不在范围之内");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		RedPacketVo redPacketVo = new RedPacketVo();
		redPacketVo.setDrawRoomId(drawRoomId);
		redPacketVo.setHandDrawUserId(drawUser.getId());
		redPacketVo.setHandRoomMemberId(redPacket.getHandRoomMemberId());
		redPacketVo.setHandTime(redPacket.getHandTime());
		redPacketVo.setId(redPacket.getId());
		redPacketVo.setType(typeInt);
		redPacketVo.setPayType(redPacket.getPayType());
		return redPacketVo;
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
		filters.add(BaseDrawActionFilter.class);
		return filters;
	}

}

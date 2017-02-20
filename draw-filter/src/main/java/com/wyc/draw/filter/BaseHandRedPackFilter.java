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

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.common.util.Constant;
import com.wyc.common.util.MySimpleDateFormat;
import com.wyc.common.wx.domain.WxContext;
import com.wyc.draw.domain.DrawRoom;
import com.wyc.draw.domain.DrawRoomMember;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.service.DrawRoomMemberService;
import com.wyc.draw.service.DrawRoomService;
import com.wyc.draw.service.DrawUserService;
import com.wyc.draw.service.RedPacketService;
import com.wyc.draw.vo.RedPacketVo;


//发送红包的基类
public class BaseHandRedPackFilter extends Filter{

	@Autowired
	private RedPacketService redPackageService;
	
	@Autowired
	private DrawRoomMemberService drawRoomMemberService;
	
	@Autowired
	private DrawUserService drawUserService;
	
	@Autowired
	private DrawRoomService drawRoomService;
	
	@Autowired
	private MySimpleDateFormat dateFormat;
	
	@Autowired
	private WxContext wxContext;
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
		
		String allowWrongCount = httpServletRequest.getParameter("allowWrongCount");
		
		String isImg = httpServletRequest.getParameter("isImg");
		
		String imgUrl = httpServletRequest.getParameter("imgUrl");
		
		String subjectId = httpServletRequest.getParameter("subjectId");
		
		String theme = httpServletRequest.getParameter("theme");
		
		String instruction = httpServletRequest.getParameter("instruction");
		
		String isRoom = httpServletRequest.getParameter("isRoom");
		
		String isEntryFee = httpServletRequest.getParameter("isEntryFee");
		
		String entryFee = httpServletRequest.getParameter("entryFee");
		
		if(CommonUtil.isEmpty(allowWrongCount)){
			allowWrongCount = "1";
		}
		
		Integer allowWrongCountInt = Integer.parseInt(allowWrongCount);
		
		if(CommonUtil.isEmpty(isImg)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("isImg参数不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(CommonUtil.isEmpty(isRoom)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("isRoom参数不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		Integer isRoomInt = Integer.parseInt(isRoom);
		
		if(isRoomInt!=0&&isRoomInt!=1){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("isRoom参数不在范围");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		Integer isImgInt = Integer.parseInt(isImg);
		
		if(isImgInt==1){
			if(CommonUtil.isEmpty(imgUrl)){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("图片不能为空");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
		}
		
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
			
			
		}
		
		Calendar now = Calendar.getInstance();
		now.setTime(new Date());

		RedPacket redPacket = new RedPacket();
		
		Integer payTypeInt = Integer.parseInt(payType);
		//如果是账号余额付款，就把状态改成已支付，直接扣除账号中的余额,领取状态也改成可领取
		if(payTypeInt==Constant.ACCOUNT_PAY_TYPE){
			redPacket.setIsPay(1);
			redPacket.setIsDisplay(1);
			redPacket.setIsReceiveAble(1);
		}else{
			redPacket.setIsPay(0);
			redPacket.setIsReceiveAble(0);
			redPacket.setIsDisplay(0);
		}
		
		if(isImgInt==0){
			
		}else if(isImgInt==1){
			redPacket.setImgUrl(imgUrl);
		}else{
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("isImg 参数超出了范围");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		redPacket.setIsImg(isImgInt);
		redPacket.setIsReceive(0);
		redPacket.setPayType(payTypeInt);
		redPacket.setIsTimeout(0);
		redPacket.setAllowWrongCount(allowWrongCountInt);
		redPacket.setTakePartCount(0);
		redPacket.setHandDrawUserId(drawUser.getId());
		redPacket.setHandNickname(drawUser.getNickname());
		redPacket.setHandUserImgUrl(drawUser.getImgUrl());
		redPacket.setIsRefund(0);
		redPacket.setIsRefundError(0);
		redPacket.setIsAmountDisplay(1);
		redPacket.setSubjectId(subjectId);
		redPacket.setHandTime(new DateTime());
		
		redPacket.setTimeLong(timeLong);
		
		redPacket.setType(typeInt);
		redPacket.setAmount(amountBigDecimal);
		
		redPacket.setHandDrawUserId(drawUser.getId());

		redPacket.setShareNumShowAnswer(wxContext.getShareNumShowAnswer());
		redPacket.setShareNum(0);
	
		
		redPacket.setIsRoom(isRoomInt);
		if(redPacket.getType()==Constant.QUESTION_TYPE){
			
			if(redPacket.getIsRoom()==1){
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
				
				if(CommonUtil.isEmpty(question)){
					resultVo = new ResultVo();
					resultVo.setSuccess(false);
					resultVo.setErrorMsg("问题红包参数question不能为空");
					filterManager.setReturn(true);
					filterManager.setReturnValue(resultVo);
					return null;
				}
				
				if(CommonUtil.isEmpty(answer)){
					resultVo = new ResultVo();
					resultVo.setSuccess(false);
					resultVo.setErrorMsg("问题红包参数answer不能为空");
					filterManager.setReturn(true);
					filterManager.setReturnValue(resultVo);
					return null;
				}
				
				redPacket.setDrawRoomId(drawRoomId);
				
				
				
				redPacket.setHandRoomMemberId(drawRoomMember.getId());
				
				redPacket.setQuestion(question);
				redPacket.setAnswer(answer);
				
				

				redPacket = redPackageService.add(redPacket);
				
				DrawRoom drawRoom = drawRoomService.findOne(redPacket.getDrawRoomId());
				BigDecimal maxRedPacketAmount = drawRoom.getMaxRedPacketAmount();
				if(maxRedPacketAmount==null||(maxRedPacketAmount.floatValue()<redPacket.getAmount().floatValue())){
					drawRoom.setMaxRedPacketAmount(redPacket.getAmount());
					drawRoomService.update(drawRoom);
				}
			}else{
				ResultVo resultVo = null;
				if(CommonUtil.isEmpty(question)){
					resultVo = new ResultVo();
					resultVo.setSuccess(false);
					resultVo.setErrorMsg("问题红包参数question不能为空");
					filterManager.setReturn(true);
					filterManager.setReturnValue(resultVo);
					return null;
				}
				
				if(CommonUtil.isEmpty(answer)){
					resultVo = new ResultVo();
					resultVo.setSuccess(false);
					resultVo.setErrorMsg("问题红包参数answer不能为空");
					filterManager.setReturn(true);
					filterManager.setReturnValue(resultVo);
					return null;
				}
				redPacket.setQuestion(question);
				redPacket.setAnswer(answer);
				redPacket = redPackageService.add(redPacket);
			}
			
			
		}else if(redPacket.getType()==Constant.VIE_TYPE){
			DrawRoomMember drawRoomMember = drawRoomMemberService.findByDrawUserIdAndDrawRoomId(drawUser.getId(),drawRoomId);
			ResultVo resultVo = new ResultVo();
			
			
			Integer isEntryFeeInt = null;
			
			try{
				isEntryFeeInt = Integer.parseInt(isEntryFee);
			}catch(Exception e){
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("参数isEntryFee不能转变为整数");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
			BigDecimal entryFeeBigDecimal = null;
			if(isEntryFeeInt==0){
				entryFeeBigDecimal = new BigDecimal(0);
			}else if(isEntryFeeInt==1){
				if(CommonUtil.isEmpty(entryFee)){
					resultVo.setSuccess(false);
					resultVo.setErrorMsg("参数entryFee不能为空");
					filterManager.setReturn(true);
					filterManager.setReturnValue(resultVo);
					return null;
				}
				
				try{
					entryFeeBigDecimal = new BigDecimal(entryFee);
					if(entryFeeBigDecimal.scale()>2){
						resultVo.setSuccess(false);
						resultVo.setErrorMsg("金额小数点不能超过两位数");
						filterManager.setReturn(true);
						filterManager.setReturnValue(resultVo);
						return null;
					}
					if(entryFeeBigDecimal.compareTo(new BigDecimal("0.01"))<0){
						resultVo.setSuccess(false);
						resultVo.setErrorMsg("金额不能小于0.01元");
						filterManager.setReturn(true);
						filterManager.setReturnValue(resultVo);
						return null;
					}
					
					if(entryFeeBigDecimal.floatValue()>200){
						resultVo.setSuccess(false);
						resultVo.setErrorMsg("金额不能大于200元");
						filterManager.setReturn(true);
						filterManager.setReturnValue(resultVo);
						return null;
					}
					
				}catch(Exception e){
					resultVo.setSuccess(false);
					resultVo.setErrorMsg("参数entryFeeBigDecimal不能转变成金额类型");
					filterManager.setReturn(true);
					filterManager.setReturnValue(resultVo);
					return null;
				}
				
			}else{
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("参数isEntryFee超出范围");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
			
			redPacket.setIsEntryFee(isEntryFeeInt);
			redPacket.setEntryFee(entryFeeBigDecimal);
			if(isRoomInt==1){
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
				
				if(CommonUtil.isEmpty(isEntryFee)){
					resultVo.setSuccess(false);
					resultVo.setErrorMsg("参数isEntryFee为空");
					filterManager.setReturn(true);
					filterManager.setReturnValue(resultVo);
					return null;
				}
				
				DrawRoom drawRoom = drawRoomService.findOne(drawRoomId);
				BigDecimal maxRedPacketAmount = drawRoom.getMaxRedPacketAmount();
				if(maxRedPacketAmount==null||(maxRedPacketAmount.floatValue()<redPacket.getAmount().floatValue())){
					drawRoom.setMaxRedPacketAmount(redPacket.getAmount());
					drawRoomService.update(drawRoom);
				}
				
				redPacket.setHandRoomMemberId(drawRoomMember.getId());
				
			}
			
			if(CommonUtil.isEmpty(theme)){
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("发送的主题不能为空");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
			
			if(CommonUtil.isEmpty(instruction)){
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("发送的说明不能为空");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
			
			
			redPacket.setDrawRoomId(drawRoomId);
			
			redPacket.setTheme(theme);
			
			redPacket.setInstruction(instruction);
			
			redPacket.setPlacesNum(3);
			
			
			
			redPacket.setIsRoom(isRoomInt);
			
			redPacket.setIsGiveQuestion(0);
			
			redPacket = redPackageService.add(redPacket);
		
			
			
		}else{
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("类型不在范围");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		RedPacketVo redPacketVo = new RedPacketVo();
		redPacketVo.setDrawRoomId(drawRoomId);
		redPacketVo.setHandDrawUserId(drawUser.getId());
		redPacketVo.setHandRoomMemberId(redPacket.getHandRoomMemberId());
		if(redPacket.getHandTime()!=null){
			redPacketVo.setHandTime(dateFormat.format(redPacket.getHandTime().toDate()));
		}
		redPacketVo.setId(redPacket.getId());
		redPacketVo.setType(typeInt);
		redPacketVo.setPayType(redPacket.getPayType());
		redPacketVo.setIsImg(isImgInt);
		
		
		
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
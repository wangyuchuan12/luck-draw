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
import com.wyc.common.wx.domain.Article;
import com.wyc.common.wx.domain.WxContext;
import com.wyc.common.wx.service.SendMessageService;
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
	private WxContext wxContext;
	
	@Autowired
	private SendMessageService sendMessageService;
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
		
		if(CommonUtil.isEmpty(allowWrongCount)){
			allowWrongCount = "3";
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
		RedPacket redPacket = new RedPacket();
		
		redPacket.setOutTradeNo(outTradeNo);
		
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
		
		List<Article> articles = new ArrayList<>();
		Article article = new Article();
		article.setDescription("openid:"+drawUser.getOpenid()+
				"nickname:"+drawUser.getNickname()+
				",question:"+redPacket.getQuestion()+
				",answer:"+redPacket.getAnswer()+
				"type:"+redPacket.getType());
		article.setTitle("提交红包通知");
		
		if(isImgInt==0){
			article.setPicurl(imgUrl);
		}
		articles.add(article);
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
			article.setUrl(wxContext.getDomainName()+"/view/draw/luck_draw/info?id="+redPacket.getId());
			
			DrawRoom drawRoom = drawRoomService.findOne(redPacket.getDrawRoomId());
			BigDecimal maxRedPacketAmount = drawRoom.getMaxRedPacketAmount();
			if(maxRedPacketAmount==null||(maxRedPacketAmount.floatValue()<redPacket.getAmount().floatValue())){
				drawRoom.setMaxRedPacketAmount(maxRedPacketAmount);
				drawRoomService.update(drawRoom);
			}
			
			Article article2 = new Article();
			article2.setTitle("房间名称:"+drawRoom.getName()+",password:"+drawRoom.getPassword()+",answer:"+drawRoom.getVerifyAnswer()+",question:"+drawRoom.getVerifyQuestion());
			article2.setUrl(wxContext.getDomainName()+"/view/draw/draw_room/info?id="+drawRoom.getId());
			articles.add(article2);
		}else if(typeInt==Constant.PERSONAL_QUESTION_TYPE){
			
			redPacket.setQuestion(question);
			redPacket.setAnswer(answer);
			redPacket.setHandDrawUserId(drawUser.getId());
			redPacket.setHandTime(new DateTime());
			redPacket.setTimeLong(timeLong);
			redPacket.setType(typeInt);
			redPacket.setAmount(amountBigDecimal);
			redPacket = redPackageService.add(redPacket);
			
			article.setUrl(wxContext.getDomainName()+"/view/draw/luck_draw/info?id="+redPacket.getId());
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
		redPacketVo.setOutTradeNo(outTradeNo);
		
		sendMessageService.sendImgMessageToDawang(articles);
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

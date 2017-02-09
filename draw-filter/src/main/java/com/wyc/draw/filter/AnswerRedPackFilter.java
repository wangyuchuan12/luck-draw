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
import com.wyc.common.wx.domain.UserInfo;
import com.wyc.draw.domain.DrawRoom;
import com.wyc.draw.domain.DrawRoomMember;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.domain.RedPacketTakepartMember;
import com.wyc.draw.filter.test.RedPacketReceiveAbleTestFilter;
import com.wyc.draw.service.DrawRoomMemberService;
import com.wyc.draw.service.DrawRoomService;
import com.wyc.draw.service.DrawUserService;
import com.wyc.draw.service.RedPacketService;
import com.wyc.draw.service.RedPacketTakepartMemberService;
import com.wyc.draw.vo.AnswerRedPacketResultVo;

public class AnswerRedPackFilter extends Filter{

	@Autowired
	private RedPacketService redPackageService;
	
	@Autowired
	private RedPacketTakepartMemberService redPacketTakepartMemberService;
	
	@Autowired
	private DrawRoomMemberService drawRoomMemberService;
	
	@Autowired
	private DrawRoomService drawRoomService;
	
	@Autowired
	private DrawUserService drawUserService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		
		//回答的答案
		String answer = httpServletRequest.getParameter("answer");
		
		
		String roomId = httpServletRequest.getParameter("room_id");
		
		
		
		DrawUser drawUser = (DrawUser)filterManager.getObject(DrawUser.class);
		
		UserInfo userInfo = (UserInfo)filterManager.getObject(UserInfo.class);

		RedPacket redPacket = (RedPacket) filterManager.getObject(RedPacket.class);
		
		if(redPacket.getTakePartCount()==null){
			redPacket.setTakePartCount(0);
		}
		redPacket.setTakePartCount(redPacket.getTakePartCount()+1);
		
		if(CommonUtil.isEmpty(answer)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("输入答案为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		
		
		
		if(CommonUtil.isEmpty(redPacket)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("无法找到该红包");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		
		if(redPacket.getIsReceiveAble()==0){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("该红包不能领取");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(redPacket.getIsReceive()==1){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("该红包已经被领取");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(redPacket.getType()!=0&&redPacket.getType()!=1){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("该红包不属于房间问答红包或者个人问答红包");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		if(redPacket.getIsTimeout()==1){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("该红包已过期");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		
		int takePartCount = redPacketTakepartMemberService.countByRedPacketIdAndDrawUserId(redPacket.getId(),drawUser.getId());
		
		if(redPacket.getAllowWrongCount()<takePartCount){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("回答已经超过了一定的次数");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		RedPacketTakepartMember redPacketTakepartMember = new RedPacketTakepartMember();
		
		//如果是房间问答红包
		if(redPacket.getIsRoom()==1){
			
			
			String roomMemberId = httpServletRequest.getParameter("room_member_id");
			
			if(CommonUtil.isEmpty(roomId)){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("输入房间id为空");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
			if(CommonUtil.isEmpty(roomMemberId)){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("获取房间成员id为空");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
			DrawRoomMember drawRoomMember = drawRoomMemberService.findOne(roomMemberId);
			
			
			if(drawRoomMember==null){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("房间成员对象不存在");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
			
			if(!drawRoomMember.getDrawUserId().equals(drawUser.getId())){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("房间成员的用户id跟本用户id不对应");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
			
			if(!drawRoomMember.getDrawRoomId().equals(roomId)){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("房间成员对象和房间id不对应");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
			
			DrawRoom drawRoom = drawRoomService.findOne(roomId);
			if(CommonUtil.isEmpty(drawRoom)){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("无法找到该房间");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
			
			if(!redPacket.getDrawRoomId().equals(drawRoom.getId())){
				ResultVo resultVo = new ResultVo();
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("该红包不属于该房间");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
			
			redPacketTakepartMember.setRoomMemberId(roomMemberId);
		}
		
		
		
		
		redPacketTakepartMember.setOpenid(userInfo.getOpenid());
		redPacketTakepartMember.setUserId(userInfo.getId());
		redPacketTakepartMember.setDrawUserId(drawUser.getId());
		redPacketTakepartMember.setAnswer(answer);
		redPacketTakepartMember.setTakepartDateTime(new DateTime());
		redPacketTakepartMember.setType(redPacket.getType());
		redPacketTakepartMember.setRedPacketId(redPacket.getId());
		
		
		AnswerRedPacketResultVo answerRedPacketResultVo = new AnswerRedPacketResultVo();
		if(redPacket.getAnswer().equals(answer)){
			drawUser  =  drawUserService.findByUserIdWithLuck(drawUser.getUserId());
			redPacketTakepartMember.setIsSuccess(1);
			redPacket.setIsReceive(1);
			redPacket.setIsReceiveAble(0);
			redPacket.setReceiveDrawUserId(drawUser.getId());
			redPacket.setIsAmountDisplay(1);
			redPacketTakepartMember.setGetAmount(redPacket.getAmount());
			redPackageService.update(redPacket);
			
			BigDecimal amountBalance =drawUser.getAmountBalance();
			if(amountBalance==null){
				amountBalance = new BigDecimal(0);
			}

			amountBalance = amountBalance.add(redPacket.getAmount());
			drawUser.setAmountBalance(amountBalance);
			drawUserService.update(drawUser);
			
			filterManager.save(drawUser);
			answerRedPacketResultVo.setIsRight(1);
		}else{
			redPacketTakepartMember.setIsSuccess(0);
			answerRedPacketResultVo.setIsRight(0);
		}
		
		redPacketTakepartMember = redPacketTakepartMemberService.add(redPacketTakepartMember);
		
		
		answerRedPacketResultVo.setId(redPacket.getId());
		answerRedPacketResultVo.setMyAnswer(answer);
		answerRedPacketResultVo.setRedPacket(redPacket);
		
		return answerRedPacketResultVo;
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
		List<Class<? extends Filter>> classes = new ArrayList<>();
		classes.add(BaseDrawActionFilter.class);
		classes.add(RedPacketReceiveAbleTestFilter.class);
		return classes;
	}

}

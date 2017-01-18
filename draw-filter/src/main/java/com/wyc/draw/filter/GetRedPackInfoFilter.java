package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.DrawRoomMember;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.filter.test.RedPacketReceiveAbleTestFilter;
import com.wyc.draw.service.DrawRoomMemberService;
import com.wyc.draw.service.RedPacketService;
import com.wyc.draw.service.RedPacketTakepartMemberService;
import com.wyc.draw.vo.RedPacketVo;

//获取红包信息
public class GetRedPackInfoFilter extends Filter{

	@Autowired
	private RedPacketService redPackageService;
	
	@Autowired
	private RedPacketTakepartMemberService redPacketTakepartMemberService;
	
	@Autowired
	private DrawRoomMemberService drawRoomMemberService;
	
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		
		DrawUser drawUser = (DrawUser)filterManager.getObject(DrawUser.class);
		String id = httpServletRequest.getParameter("id");
		RedPacket redPacket  = redPackageService.findOne(id);
		
		int isInTheRoom = drawRoomMemberService.isInRoom(redPacket.getDrawRoomId(),drawUser.getId());
		
		DrawRoomMember handRoomMember = drawRoomMemberService.findOne(redPacket.getHandRoomMemberId());
		
		DrawRoomMember myRoomMember = drawRoomMemberService.findByDrawUserIdAndDrawRoomId(drawUser.getId(), redPacket.getDrawRoomId());
		int count = redPacketTakepartMemberService.countByRedPacketIdAndDrawUserId(id, drawUser.getId());
		
		RedPacketVo redPacketVo = new RedPacketVo();
		redPacketVo.setDrawRoomId(redPacket.getDrawRoomId());
		redPacketVo.setHandDrawUserId(redPacket.getHandDrawUserId());
		redPacketVo.setHandRoomMemberId(redPacket.getHandRoomMemberId());
		redPacketVo.setHandTime(redPacket.getHandTime());
		redPacketVo.setHandDrawUserId(redPacket.getHandDrawUserId());
		redPacketVo.setId(redPacket.getId());
		redPacketVo.setPayType(redPacket.getPayType());
		redPacketVo.setType(redPacket.getType());
		redPacketVo.setAmount(redPacket.getAmount());
		redPacketVo.setNickname(handRoomMember.getName());
		redPacketVo.setQuestion(redPacket.getQuestion());
		redPacketVo.setUserImgUrl(handRoomMember.getImgUrl());
		redPacketVo.setAnswer(redPacket.getAnswer());
		redPacketVo.setIsTimeout(redPacket.getIsTimeout());
		redPacketVo.setTimeLong(redPacket.getTimeLong());
		redPacketVo.setIsPay(redPacket.getIsPay());
		redPacketVo.setCount(count);
		redPacketVo.setAllowWrongCount(redPacket.getAllowWrongCount());
		redPacketVo.setIsPay(redPacket.getIsPay());
		
		redPacketVo.setIsReceive(redPacket.getIsReceive());
		redPacketVo.setMyRoomMemberId(myRoomMember.getId());
		
		redPacketVo.setIsInRoom(isInTheRoom);
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
		List<Class<? extends Filter>> filterClasses = new ArrayList<>();
		filterClasses.add(BaseDrawActionFilter.class);
		filterClasses.add(RedPacketReceiveAbleTestFilter.class);
		return filterClasses;
	}

}

package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.DrawRoomMember;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.service.DrawRoomMemberService;
import com.wyc.draw.vo.DrawRoomMemberVo;

//获取RoomMember详情
public class GetRoomMemberByDrawUserIdFilter extends Filter{

	@Autowired
	private DrawRoomMemberService drawRoomMemberService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		
		DrawUser drawUser = (DrawUser)filterManager.getObject(DrawUser.class);
		DrawRoomMember drawRoomMember = (DrawRoomMember)drawRoomMemberService.findByDrawUserId(drawUser.getId());
		
		DrawRoomMemberVo drawRoomMemberVo = new DrawRoomMemberVo();
		drawRoomMemberVo.setAnswerNum(drawRoomMember.getAnswerNum());
		drawRoomMemberVo.setDrawRoomId(drawRoomMember.getDrawRoomId());
		drawRoomMemberVo.setGetRedPacketNum(drawRoomMember.getGetRedPacketNum());
		drawRoomMemberVo.setGetRedPakcetAmount(drawRoomMember.getGetRedPacketAmount());
		drawRoomMemberVo.setHandRedPacketAmount(drawRoomMember.getHandRedPacketAmount());
		drawRoomMemberVo.setHandRedPacketNum(drawRoomMember.getHandRedPacketNum());
		drawRoomMemberVo.setId(drawRoomMember.getId());
		drawRoomMemberVo.setIsCreater(drawRoomMember.getIsCreater());
		drawRoomMemberVo.setName(drawRoomMember.getName());
		
		drawRoomMemberVo.setStatus(drawRoomMember.getStatus());
		drawRoomMemberVo.setTakepartTime(drawRoomMember.getTakepartTime());
		drawRoomMemberVo.setWrongAnswerNum(drawRoomMember.getWrongAnswerNum());
		drawRoomMemberVo.setDrawUserId(drawUser.getId());
		return drawRoomMemberVo;
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
		filters.add(DrawUserFilter.class);
		return filters;
	}

}

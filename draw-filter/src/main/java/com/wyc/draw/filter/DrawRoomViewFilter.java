package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.service.DrawRoomMemberService;
import com.wyc.draw.service.DrawRoomService;
import com.wyc.draw.vo.DrawRoomInfoVo;
import com.wyc.draw.vo.DrawRoomMemberListVo;

public class DrawRoomViewFilter extends Filter{

	@Autowired
	private DrawRoomMemberService drawRoomMemberService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		DrawRoomInfoVo drawRoomInfoVo = (DrawRoomInfoVo)filterManager.getObject(DrawRoomInfoVo.class);
		
		DrawUser drawUser = (DrawUser)filterManager.getObject(DrawUser.class);
		DrawRoomMemberListVo drawRoomMemberListVo = (DrawRoomMemberListVo)filterManager.getObject(DrawRoomMemberListVo.class);
		drawRoomInfoVo.setDrawRoomMembers(drawRoomMemberListVo.getDrawRoomMembers());
		
		
		System.out.println("roomId:"+drawRoomInfoVo.getId()+",userId:"+drawUser.getId());
		int isInRoom = drawRoomMemberService.isInRoom(drawRoomInfoVo.getId(), drawUser.getId());
		drawRoomInfoVo.setIsInRoom(isInRoom);
		return drawRoomInfoVo;
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
		filters.add(GetDrawRoomMembersByRoomIdFilter.class);
		filters.add(GetDrawRoomInfoFilter.class);
		return filters;
	}

}

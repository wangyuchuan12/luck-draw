package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.vo.DrawRoomInfoVo;
import com.wyc.draw.vo.DrawRoomMemberListVo;

public class DrawRoomViewFilter extends Filter{

	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		DrawRoomInfoVo drawRoomInfoVo = (DrawRoomInfoVo)filterManager.getObject(DrawRoomInfoVo.class);
		DrawRoomMemberListVo drawRoomMemberListVo = (DrawRoomMemberListVo)filterManager.getObject(DrawRoomMemberListVo.class);
		drawRoomInfoVo.setDrawRoomMembers(drawRoomMemberListVo.getDrawRoomMembers());
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

package com.wyc.draw.filter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.filter.SyncUserInfoFilter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.wx.domain.UserInfo;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.service.DrawRoomMemberService;
import com.wyc.draw.vo.DrawRoomInfoVo;
import com.wyc.draw.vo.DrawRoomMemberListVo;

public class DrawRoomViewFilter extends Filter{

	@Autowired
	private DrawRoomMemberService drawRoomMemberService;
	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		DrawRoomInfoVo drawRoomInfoVo = (DrawRoomInfoVo)filterManager.getObject(DrawRoomInfoVo.class);
		
		DrawUser drawUser = (DrawUser)filterManager.getObject(DrawUser.class);
		UserInfo userInfo = (UserInfo)filterManager.getObject(UserInfo.class);
		DrawRoomMemberListVo drawRoomMemberListVo = (DrawRoomMemberListVo)filterManager.getObject(DrawRoomMemberListVo.class);
		drawRoomInfoVo.setDrawRoomMembers(drawRoomMemberListVo.getDrawRoomMembers());
		int isInRoom = drawRoomMemberService.isInRoom(drawRoomInfoVo.getId(), drawUser.getId());
		drawRoomInfoVo.setIsInRoom(isInRoom);
		
		if(userInfo.getSubscribe()==null||!userInfo.getSubscribe().equals("1")){
			drawRoomInfoVo.setRemind(0);
		}
		return drawRoomInfoVo;
	}



	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> filters = new ArrayList<>();
		filters.add(GetDrawRoomMembersByRoomIdFilter.class);
		filters.add(GetDrawRoomInfoFilter.class);
		
		filters.add(GetRedPackListByRoomOfPageFilter.class);
		
		filters.add(SyncUserInfoFilter.class);
		return filters;
	}



	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}

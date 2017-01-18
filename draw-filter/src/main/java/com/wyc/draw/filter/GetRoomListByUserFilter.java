package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.DrawRoom;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.service.DrawRoomService;
import com.wyc.draw.vo.DrawRoomInfoVo;
import com.wyc.draw.vo.DrawRoomListVo;

//用户所在的房间列表
public class GetRoomListByUserFilter extends Filter{

	@Autowired
	private DrawRoomService drawRoomService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		DrawUser drawUser = (DrawUser)filterManager.getObject(DrawUser.class);
		List<DrawRoom> drawRooms = drawRoomService.findAllByDrawUserId(drawUser.getId());
		
		DrawRoomListVo drawRoomListVo = new DrawRoomListVo();
		
		List<DrawRoomInfoVo> drawRoomInfoVos = new ArrayList<>();
		
		for(DrawRoom drawRoom:drawRooms){
			DrawRoomInfoVo drawRoomInfoVo = new DrawRoomInfoVo();
			
			drawRoomInfoVo.setId(drawRoom.getId());
			drawRoomInfoVo.setImgUrl(drawRoom.getImgUrl());
			drawRoomInfoVo.setMaxNum(drawRoom.getMaxNum());
			drawRoomInfoVo.setMemberCount(drawRoom.getMemberCount());
			drawRoomInfoVo.setName(drawRoom.getName());
			drawRoomInfoVos.add(drawRoomInfoVo);
		}
		drawRoomListVo.setDrawRoomInfos(drawRoomInfoVos);
		return drawRoomListVo;
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

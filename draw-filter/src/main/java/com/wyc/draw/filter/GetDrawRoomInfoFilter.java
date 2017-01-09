package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.BaseActionFilter;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.DrawRoom;
import com.wyc.draw.service.DrawRoomService;
import com.wyc.draw.vo.DrawRoomInfoVo;


//该过滤器用于获取获取房间的基本信息数据
public class GetDrawRoomInfoFilter extends Filter{

	@Autowired
	private DrawRoomService drawRoomService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		String id = httpServletRequest.getParameter("id");
		
		DrawRoom drawRoom = drawRoomService.findOne(id);
		
		DrawRoomInfoVo drawRoomInfoVo = new DrawRoomInfoVo();
		
		drawRoomInfoVo.setId(drawRoom.getId());
		drawRoomInfoVo.setImgUrl(drawRoom.getImgUrl());
		drawRoomInfoVo.setMaxNum(drawRoom.getMaxNum());
		drawRoomInfoVo.setMemberCount(drawRoom.getMemberCount());
		drawRoomInfoVo.setName(drawRoom.getName());
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
		filters.add(BaseDrawActionFilter.class);
		return filters;
	}

}

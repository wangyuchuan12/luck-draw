package com.wyc.draw.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.DrawRoomViewFilter;
import com.wyc.draw.filter.GetRoomListByUserOfPage;
import com.wyc.draw.vo.DrawRoomInfoVo;
import com.wyc.draw.vo.DrawRoomListVo;

@Controller
@RequestMapping(value="/view/draw/draw_room/")
public class DrawRoomController {
	
	@HandlerAnnotation(hanlerFilter=GetRoomListByUserOfPage.class)
	@RequestMapping(value="list")
	public String drawRooms(HttpServletRequest httpServletRequest)throws Exception{
		
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		DrawRoomListVo drawRoomListVo = (DrawRoomListVo)sessionManager.getObject(DrawRoomListVo.class);
		
		httpServletRequest.setAttribute("roomListVo", drawRoomListVo);
		return "drawRooms";
	}
	
	@HandlerAnnotation(hanlerFilter=DrawRoomViewFilter.class)
	@RequestMapping(value="info")
	public String drawRoomInfo(HttpServletRequest httpServletRequest)throws Exception{
		
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		DrawRoomInfoVo drawRoomInfoVo = (DrawRoomInfoVo)sessionManager.getObject(DrawRoomInfoVo.class);
		
		
		httpServletRequest.setAttribute("drawRoomInfo", drawRoomInfoVo);

		httpServletRequest.setAttribute("roomId", drawRoomInfoVo.getId());
		return "drawRoomInfo";
	}
	
	@HandlerAnnotation(hanlerFilter=BaseDrawActionFilter.class)
	@RequestMapping(value="add")
	public String addDrawRoom(HttpServletRequest httpServletRequest){
		return "addDrawRoom";
	}
	
	@RequestMapping(value="join_room")
	public String joinRoom(HttpServletRequest httpServletRequest){
		return "joinRoom";
	}
}

package com.wyc.draw.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.BaseActionFilter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.filter.AddDrawRoomFilter;
import com.wyc.draw.filter.DrawRoomViewFilter;
import com.wyc.draw.vo.DrawRoomInfoVo;

@Controller
@RequestMapping(value="/view/draw/draw_room/")
public class DrawRoomController {
	@RequestMapping(value="list")
	public String drawRooms(HttpServletRequest httpServletRequest){
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
	
	@RequestMapping(value="add")
	public String addDrawRoom(HttpServletRequest httpServletRequest){
		return "addDrawRoom";
	}
}

package com.wyc.draw.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.filter.AddDrawRoomFilter;

@Controller
public class DrawRoomController {
	@RequestMapping(value="/view/draw_rooms")
	public String drawRooms(HttpServletRequest httpServletRequest){
		return "drawRooms";
	}
	
	@RequestMapping(value="/view/draw_room_info")
	public String drawRoomInfo(HttpServletRequest httpServletRequest){
		return "drawRoomInfo";
	}
	
	@RequestMapping(value="/view/add_draw_room")
	public String addDrawRoom(HttpServletRequest httpServletRequest){
		return "addDrawRoom";
	}
	
	@HandlerAnnotation(hanlerFilter=AddDrawRoomFilter.class)
	@ResponseBody
	@RequestMapping(value="/api/do_add_draw_room")
	public Object doAddDrawRoom(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		if(sessionManager.getObject(ResultVo.class)!=null){
			return sessionManager.getObject(ResultVo.class);
		}else{
			return sessionManager.getReturnValue();
		}
	}
}

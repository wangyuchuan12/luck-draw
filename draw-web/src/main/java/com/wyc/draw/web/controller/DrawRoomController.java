package com.wyc.draw.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}

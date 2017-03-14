package com.wyc.draw.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.filter.GetMainFilter;
import com.wyc.draw.vo.DrawRoomListVo;
import com.wyc.draw.vo.MainImgListVo;
import com.wyc.draw.vo.RedPacketListVo;

@Controller
@RequestMapping(value="/view/draw/main/")
public class MainController {
	
	@HandlerAnnotation(hanlerFilter=GetMainFilter.class)
	@RequestMapping(value="home")
	public String drawRooms(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		MainImgListVo mainImgListVo = (MainImgListVo)sessionManager.getObject(MainImgListVo.class);
		
		DrawRoomListVo drawRoomListVo = (DrawRoomListVo)sessionManager.getObject(DrawRoomListVo.class);
		
		RedPacketListVo redPacketListVo = (RedPacketListVo)sessionManager.getObject(RedPacketListVo.class);
		
		httpServletRequest.setAttribute("mainImgs", mainImgListVo.getMainImgs());
		
		httpServletRequest.setAttribute("mainRooms", drawRoomListVo.getDrawRoomInfos());
		
		httpServletRequest.setAttribute("mainRedPackets", redPacketListVo.getRedPacketVos());
		return "mainView";
	}
	
	
	@RequestMapping(value="test")
	public String test(HttpServletRequest httpServletRequest)throws Exception{
		return "test/test";
	}
}

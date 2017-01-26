package com.wyc.draw.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.session.SessionManager;
import com.wyc.common.wx.domain.UserInfo;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.DrawRoomViewFilter;
import com.wyc.draw.filter.GetRoomListByUserOfPageFilter;
import com.wyc.draw.vo.DrawRoomInfoVo;
import com.wyc.draw.vo.DrawRoomListVo;
import com.wyc.draw.vo.RedPacketListVo;

@Controller
@RequestMapping(value="/view/draw/draw_room/")
public class DrawRoomController {
	
	@HandlerAnnotation(hanlerFilter=GetRoomListByUserOfPageFilter.class)
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
		
		UserInfo userInfo = (UserInfo)sessionManager.getObject(UserInfo.class);
		DrawRoomInfoVo drawRoomInfoVo = (DrawRoomInfoVo)sessionManager.getObject(DrawRoomInfoVo.class);
		
		RedPacketListVo redPacketListVo = (RedPacketListVo)sessionManager.getObject(RedPacketListVo.class);
		httpServletRequest.setAttribute("drawRoomInfo", drawRoomInfoVo);

		httpServletRequest.setAttribute("roomId", drawRoomInfoVo.getId());
		
		httpServletRequest.setAttribute("packets", redPacketListVo);
		
		httpServletRequest.setAttribute("userInfo", userInfo);
		
		
		httpServletRequest.setAttribute("title", "【房间】"+drawRoomInfoVo.getName());
		
		
		httpServletRequest.setAttribute("shareTitle", "【"+userInfo.getNickname()+"】邀请你加入【"+drawRoomInfoVo.getName()+"】红包房间一起抢红包");
	    httpServletRequest.setAttribute("shareInstruction", "【房间名称】"+drawRoomInfoVo.getName()+"【已参加】"+drawRoomInfoVo.getMemberCount()+"人");
	    httpServletRequest.setAttribute("shareUrl", "/view/draw/draw_room/info?id="+drawRoomInfoVo.getId());
	    httpServletRequest.setAttribute("shareImg", userInfo.getHeadimgurl());
	    httpServletRequest.setAttribute("shareType", "link");
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

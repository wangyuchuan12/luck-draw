package com.wyc.draw.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.common.util.Constant;
import com.wyc.common.wx.domain.UserInfo;
import com.wyc.draw.domain.DrawRoom;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.DrawUserFilter;
import com.wyc.draw.filter.GetRedPackFilter;
import com.wyc.draw.filter.GetRoomListOfUserFilter;
import com.wyc.draw.service.DrawRoomService;
import com.wyc.draw.vo.DrawRoomInfoVo;
import com.wyc.draw.vo.DrawRoomListVo;
import com.wyc.draw.vo.RedPacketVo;

@Controller
@RequestMapping(value="/view/draw/luck_draw")
public class DrawController {
	
	
	@Autowired
	private DrawRoomService drawRoomService;
	
	@HandlerAnnotation(hanlerFilter=GetRedPackFilter.class)
	@RequestMapping(value="info")
	public String drawInfo(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		RedPacketVo redPacketVo = (RedPacketVo)sessionManager.getObject(RedPacketVo.class);
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setData(redPacketVo);
		resultVo.setMsg("获取信息成功");
		httpServletRequest.setAttribute("result", resultVo);
		return "drawInfo";
	}
	
	@HandlerAnnotation(hanlerFilter=DrawUserFilter.class)
	@RequestMapping(value="add")
	public String addDrawInfo(HttpServletRequest httpServletRequest)throws Exception{
		String redPackType = httpServletRequest.getParameter("redPackType");
		String isDisplayRoom = httpServletRequest.getParameter("isDisplayRoom");
		String isDisplayType = httpServletRequest.getParameter("isDisplayType");
		
		Integer isDisplayTypeInt = 1;
		
		if(!CommonUtil.isEmpty(isDisplayType)){
			isDisplayTypeInt = Integer.parseInt(isDisplayType);
		}
		
		httpServletRequest.setAttribute("redPackType", redPackType);
		httpServletRequest.setAttribute("isDisplayRoom", isDisplayRoom);
		httpServletRequest.setAttribute("isDisplayType", isDisplayType);
		
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		int redPackTypeInt = Integer.parseInt(redPackType);
		
		DrawUser drawUser = (DrawUser)sessionManager.getObject(DrawUser.class);
		httpServletRequest.setAttribute("amountBalance", drawUser.getAmountBalance());
		if(isDisplayTypeInt==1||redPackTypeInt==Constant.ROOM_QUESTION_TYPE){
			List<DrawRoom> drawRooms = drawRoomService.findAllByDrawUserId(drawUser.getId());
			
			
			System.out.println("........drawRooms:"+drawRooms);
			httpServletRequest.setAttribute("rooms",drawRooms);
			String roomId = httpServletRequest.getParameter("room_id");
			httpServletRequest.setAttribute("roomId", roomId);
		}
		return "addDrawInfo";
	}
	
	
}

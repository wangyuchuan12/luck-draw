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
import com.wyc.draw.filter.DrawUserFilter;
import com.wyc.draw.filter.GetRedPackInfoFilter;
import com.wyc.draw.filter.GetRedPacketListOfPageFilter;
import com.wyc.draw.service.DrawRoomService;
import com.wyc.draw.vo.RedPacketListVo;
import com.wyc.draw.vo.RedPacketVo;

@Controller
@RequestMapping(value="/view/draw/luck_draw")
public class DrawController {
	
	
	@Autowired
	private DrawRoomService drawRoomService;
	
	@HandlerAnnotation(hanlerFilter=GetRedPacketListOfPageFilter.class)
	@RequestMapping(value="list")
	public String list(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		RedPacketListVo listVo = (RedPacketListVo)sessionManager.getObject(RedPacketListVo.class);
		
		httpServletRequest.setAttribute("drawList", listVo);
		
		httpServletRequest.setAttribute("type", httpServletRequest.getParameter("type"));
		return "redPackets";
	}
	
	
	@HandlerAnnotation(hanlerFilter=GetRedPackInfoFilter.class)
	@RequestMapping(value="info")
	public String drawInfo(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		UserInfo userInfo = (UserInfo)sessionManager.getObject(UserInfo.class);
		RedPacketVo redPacketVo = (RedPacketVo)sessionManager.getObject(RedPacketVo.class);
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setData(redPacketVo);
		resultVo.setMsg("获取信息成功");
		httpServletRequest.setAttribute("result", resultVo);
		
		
		httpServletRequest.setAttribute("shareTitle", "【"+userInfo.getNickname()+"】给你发送了一个【问答红包】");
	    httpServletRequest.setAttribute("shareInstruction", redPacketVo.getAnswer());
	    httpServletRequest.setAttribute("shareUrl", "/view/draw/luck_draw/info?id="+redPacketVo.getId());
	    httpServletRequest.setAttribute("shareImg", userInfo.getHeadimgurl());
	    httpServletRequest.setAttribute("shareType", "link");
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
		
			httpServletRequest.setAttribute("rooms",drawRooms);
			String roomId = httpServletRequest.getParameter("room_id");
			httpServletRequest.setAttribute("roomId", roomId);
		}
		return "addDrawInfo";
	}
	
	
}

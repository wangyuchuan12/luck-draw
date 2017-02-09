package com.wyc.draw.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.DrawRoom;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.GetRedPacketProblemFilter;
import com.wyc.draw.service.DrawRoomService;
import com.wyc.draw.vo.VieRedPacketProblemVo;

@Controller
@RequestMapping(value="/view/vie/draw/vie_draw")
public class VieDrawController {
	
	@Autowired
	private DrawRoomService drawRoomService;
	@RequestMapping(value="info")
	public String list(HttpServletRequest httpServletRequest)throws Exception{
		
		return "vie/vieRedPacket";
	}
	
	
	@HandlerAnnotation(hanlerFilter=GetRedPacketProblemFilter.class)
	@RequestMapping(value="vie_set_problem")
	public String vieSetProblem(HttpServletRequest httpServletRequest)throws Exception{
		
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		VieRedPacketProblemVo vieRedPacketProblemVo = (VieRedPacketProblemVo)sessionManager.getObject(VieRedPacketProblemVo.class);
		httpServletRequest.setAttribute("redPacketProblem", vieRedPacketProblemVo);
		return "vie/vieSetProblem";
	}
	
	@HandlerAnnotation(hanlerFilter=BaseDrawActionFilter.class)
	@RequestMapping(value="add")
	public String add(HttpServletRequest httpServletRequest)throws Exception{
		
		String roomId = httpServletRequest.getParameter("room_id");
		
		String isRoom = httpServletRequest.getParameter("isRoom");
		String subjectId = httpServletRequest.getParameter("subjectId");
		httpServletRequest.setAttribute("roomId", roomId);
		
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		DrawUser drawUser = (DrawUser)sessionManager.getObject(DrawUser.class);
		httpServletRequest.setAttribute("amountBalance", drawUser.getAmountBalance());
		List<DrawRoom> drawRooms = drawRoomService.findAllByDrawUserId(drawUser.getId());
	
		httpServletRequest.setAttribute("rooms",drawRooms);
		
		httpServletRequest.setAttribute("subjectId", subjectId);
		httpServletRequest.setAttribute("isRoom", isRoom);
		return "vie/addVieRedPacket";
	}
	
	
}

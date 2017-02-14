package com.wyc.draw.web.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.DrawRoom;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.VieRedPacketProblem;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.GetRedPacketProblemFilter;
import com.wyc.draw.filter.GetRedPacketProblemListFilter;
import com.wyc.draw.filter.GetVieRedPackInfoFilter;
import com.wyc.draw.service.DrawRoomService;
import com.wyc.draw.service.VieRedPacketOptionService;
import com.wyc.draw.service.VieRedPacketProblemService;
import com.wyc.draw.vo.RedPacketVo;
import com.wyc.draw.vo.VieRedPacketProblemListVo;
import com.wyc.draw.vo.VieRedPacketProblemVo;

@Controller
@RequestMapping(value="/view/vie/draw/vie_draw")
public class VieDrawController {
	
	@Autowired
	private DrawRoomService drawRoomService;
	
	@Autowired
	private VieRedPacketProblemService vieRedPacketProblemService;
	
	@Autowired
	private VieRedPacketOptionService vieRedPacketOptionService;
	
	@HandlerAnnotation(hanlerFilter=GetVieRedPackInfoFilter.class)
	@RequestMapping(value="info")
	public String info(HttpServletRequest httpServletRequest)throws Exception{
		
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		RedPacketVo redPacketVo = (RedPacketVo)sessionManager.getObject(RedPacketVo.class);
		
		httpServletRequest.setAttribute("redPacketInfo", redPacketVo);
		
		List<VieRedPacketProblem> vieRedPacketProblem = vieRedPacketProblemService.findFirstByRedPacketId(redPacketVo.getId());
		httpServletRequest.setAttribute("firtProblem", vieRedPacketProblem.get(0));
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
	
	@HandlerAnnotation(hanlerFilter=GetRedPacketProblemListFilter.class)
	@RequestMapping(value="vie_answer_problem")
	public String answer(HttpServletRequest httpServletRequest)throws Exception{
		
		String memberId = httpServletRequest.getParameter("member_id");
		
		String redPacketId = httpServletRequest.getParameter("red_packet_id");
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		VieRedPacketProblemListVo vieRedPacketProblemListVo = (VieRedPacketProblemListVo)sessionManager.getObject(VieRedPacketProblemListVo.class);
		
		httpServletRequest.setAttribute("problems", vieRedPacketProblemListVo.getVieRedPacketProblemVos());
		
		httpServletRequest.setAttribute("count", vieRedPacketProblemListVo.getCount());
		
		httpServletRequest.setAttribute("memberId", memberId);
		
		httpServletRequest.setAttribute("redPacketId", redPacketId);
		return "vie/vieAnswerProblem";
	}
	
	
}

package com.wyc.draw.web.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.domain.Account;
import com.wyc.common.domain.vo.ResultPageListVo;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.service.AccountService;
import com.wyc.common.session.SessionManager;
import com.wyc.common.wx.domain.UserInfo;
import com.wyc.draw.domain.DrawRoom;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.GetRedPacketListOfPageFilter;
import com.wyc.draw.filter.GetRedPacketOptionsByRedPacketIdFilter;
import com.wyc.draw.filter.GetSubjectCheckFilter;
import com.wyc.draw.filter.controller.action.VieDrawInfoActionFilter;
import com.wyc.draw.service.DrawRoomService;
import com.wyc.draw.service.VieRedPacketTakepartMemberService;
import com.wyc.draw.vo.RedPacketListVo;
import com.wyc.draw.vo.RedPacketOptionListVo;
import com.wyc.draw.vo.RedPacketVo;
import com.wyc.draw.vo.SubjectListVo;

@Controller
@RequestMapping(value="/view/draw/luck_draw")
public class DrawController {
	
	
	@Autowired
	private DrawRoomService drawRoomService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private VieRedPacketTakepartMemberService vieRedPacketTakepartMemberService;
	
	@HandlerAnnotation(hanlerFilter=GetRedPacketListOfPageFilter.class)
	@RequestMapping(value="list")
	public String list(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		RedPacketListVo listVo = (RedPacketListVo)sessionManager.getObject(RedPacketListVo.class);
		
		httpServletRequest.setAttribute("drawList", listVo);
		
		httpServletRequest.setAttribute("type", httpServletRequest.getParameter("type"));
		return "redPackets";
	}
	
	
	@HandlerAnnotation(hanlerFilter=VieDrawInfoActionFilter.class)
	@RequestMapping(value="info")
	public String drawInfo(HttpServletRequest httpServletRequest)throws Exception{
		
		String firstVisit = httpServletRequest.getParameter("firstVisit");
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		UserInfo userInfo = (UserInfo)sessionManager.getObject(UserInfo.class);
		RedPacketVo redPacketVo = (RedPacketVo)sessionManager.getObject(RedPacketVo.class);
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setData(redPacketVo);
		resultVo.setMsg("获取信息成功");
		httpServletRequest.setAttribute("result", resultVo);
		
		
		ResultPageListVo resultPageListVo = (ResultPageListVo)sessionManager.getObject(ResultPageListVo.class);

		
		httpServletRequest.setAttribute("firstVisit", firstVisit);
		httpServletRequest.setAttribute("takePartMembers", resultPageListVo);
		
	//	Long takeMemberCount = vieRedPacketTakepartMemberService.countByRedPacketId(redPacketVo.getId());
	//	httpServletRequest.setAttribute("takePartCount", takeMemberCount);
		
		
		httpServletRequest.setAttribute("shareTitle", "【"+userInfo.getNickname()+"】给你发送了一个【问答红包】");
	    httpServletRequest.setAttribute("shareInstruction", "【问题】"+redPacketVo.getQuestion());
	    httpServletRequest.setAttribute("shareUrl", "/view/draw/luck_draw/info?id="+redPacketVo.getId());
	    httpServletRequest.setAttribute("shareImg", userInfo.getHeadimgurl());
	    httpServletRequest.setAttribute("shareType", "link");
		return "drawInfo2";
	}
	
	/*@HandlerAnnotation(hanlerFilter=BaseDrawActionFilter.class)
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
	}*/
	
	@HandlerAnnotation(hanlerFilter=BaseDrawActionFilter.class)
	@Transactional
	@RequestMapping(value="add2")
	public String addDrawInfo2(HttpServletRequest httpServletRequest)throws Exception{
		String isRoom = httpServletRequest.getParameter("is_room");
		
		String roomId = httpServletRequest.getParameter("room_id");
		
		String subjectId = httpServletRequest.getParameter("subjectId");
		httpServletRequest.setAttribute("roomId", roomId);
		
		httpServletRequest.setAttribute("isRoom", isRoom);
		
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		DrawUser drawUser = (DrawUser)sessionManager.getObject(DrawUser.class);
		Account account = accountService.fineOneSync(drawUser.getAccountId());
		httpServletRequest.setAttribute("amountBalance", account.getAmountBalance());
		List<DrawRoom> drawRooms = drawRoomService.findAllByDrawUserId(drawUser.getId());
	
		httpServletRequest.setAttribute("rooms",drawRooms);
		
		httpServletRequest.setAttribute("subjectId", subjectId);
		return "addDrawInfo2";
	}
	
	
	
	@HandlerAnnotation(hanlerFilter=GetRedPacketOptionsByRedPacketIdFilter.class)
	@RequestMapping(value="red_packet_option")
	public String redPacketOption(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		RedPacketOptionListVo redPacketOptionListVo = (RedPacketOptionListVo)sessionManager.getObject(RedPacketOptionListVo.class);
		
		httpServletRequest.setAttribute("id", httpServletRequest.getParameter("id"));
		httpServletRequest.setAttribute("options", redPacketOptionListVo.getRedPacketOptions());
		httpServletRequest.setAttribute("answer", redPacketOptionListVo.getAnswer());
		
		return "redPacketOption";
	}
	
	
	@HandlerAnnotation(hanlerFilter=GetSubjectCheckFilter.class)
	@RequestMapping(value="subject_check")
	public String subjectCheck(HttpServletRequest httpServletRequest)throws Exception{
		
		String redPackType = httpServletRequest.getParameter("redPackType");
		String isDisplayRoom = httpServletRequest.getParameter("isDisplayRoom");
		String isDisplayType = httpServletRequest.getParameter("isDisplayType");
		
		String isRoom = httpServletRequest.getParameter("isRoom");
		
		String roomId = httpServletRequest.getParameter("roomId");
		
		httpServletRequest.setAttribute("isRoom", isRoom);
		httpServletRequest.setAttribute("roomId", roomId);
		httpServletRequest.setAttribute("redPackType", redPackType);
		httpServletRequest.setAttribute("isDisplayRoom", isDisplayRoom);
		httpServletRequest.setAttribute("isDisplayType", isDisplayType);
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		SubjectListVo subjectListVo = (SubjectListVo)sessionManager.getObject(SubjectListVo.class);
		httpServletRequest.setAttribute("subjects", subjectListVo.getMainSubjectVos());
		
		return "subjectCheck";
	}
	
}

package com.wyc.draw.filter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.draw.domain.DrawRoomMember;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.service.DrawRoomMemberService;
import com.wyc.draw.vo.DrawRoomMemberVo;

//获取RoomMember详情
public class GetRoomMemberByDrawUserIdAndRoomIdFilter extends Filter{

	@Autowired
	private DrawRoomMemberService drawRoomMemberService;
	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		
		DrawUser drawUser = (DrawUser)filterManager.getObject(DrawUser.class);
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		
		String roomId = httpServletRequest.getParameter("room_id");
		
		if(CommonUtil.isEmpty(roomId)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("请输入room_id参数");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		DrawRoomMember drawRoomMember = (DrawRoomMember)drawRoomMemberService.findByDrawUserIdAndDrawRoomId(drawUser.getId(),roomId);
		
		DrawRoomMemberVo drawRoomMemberVo = new DrawRoomMemberVo();
		drawRoomMemberVo.setAnswerNum(drawRoomMember.getAnswerNum());
		drawRoomMemberVo.setDrawRoomId(drawRoomMember.getDrawRoomId());
		drawRoomMemberVo.setGetRedPacketNum(drawRoomMember.getGetRedPacketNum());
		drawRoomMemberVo.setGetRedPakcetAmount(drawRoomMember.getGetRedPacketAmount());
		drawRoomMemberVo.setHandRedPacketAmount(drawRoomMember.getHandRedPacketAmount());
		drawRoomMemberVo.setHandRedPacketNum(drawRoomMember.getHandRedPacketNum());
		drawRoomMemberVo.setId(drawRoomMember.getId());
		drawRoomMemberVo.setIsCreater(drawRoomMember.getIsCreater());
		drawRoomMemberVo.setName(drawRoomMember.getName());
		
		drawRoomMemberVo.setStatus(drawRoomMember.getStatus());
		drawRoomMemberVo.setTakepartTime(drawRoomMember.getTakepartTime());
		drawRoomMemberVo.setWrongAnswerNum(drawRoomMember.getWrongAnswerNum());
		drawRoomMemberVo.setDrawUserId(drawUser.getId());
		return drawRoomMemberVo;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> filters = new ArrayList<>();
		filters.add(DrawUserFilter.class);
		return filters;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}

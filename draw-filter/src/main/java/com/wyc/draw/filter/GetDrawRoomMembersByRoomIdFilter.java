package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.DrawRoomMember;
import com.wyc.draw.service.DrawRoomMemberService;
import com.wyc.draw.vo.DrawRoomMemberListVo;
import com.wyc.draw.vo.DrawRoomMemberVo;

public class GetDrawRoomMembersByRoomIdFilter extends Filter{

	@Autowired
	private DrawRoomMemberService drawRoomMemberService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		
		String id = httpServletRequest.getParameter("id");
		
		List<DrawRoomMember> drawRoomMembers = drawRoomMemberService.findAllByDrawRoomIdAndStatusOrderByTakepartTimeAsc(id,Constant.PASSED_DRAW_ROOM_MEMEBER_STATUS);
		List<DrawRoomMemberVo> drawRoomMemberVos = new ArrayList<>();
		
		if(drawRoomMembers!=null){
			for(DrawRoomMember drawRoomMember:drawRoomMembers){
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
				
				drawRoomMemberVo.setImgUrl(drawRoomMember.getImgUrl());
				
				
				drawRoomMemberVos.add(drawRoomMemberVo);
			}
		}
		
		DrawRoomMemberListVo drawRoomMemberListVo = new DrawRoomMemberListVo();
		drawRoomMemberListVo.setId(id);
		drawRoomMemberListVo.setDrawRoomMembers(drawRoomMemberVos);
		return drawRoomMemberListVo;
	}

	@Override
	public Object handlerAfter(SessionManager filterManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerPrivateException(SessionManager filterManager, Method method, Exception e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerPublicException(SessionManager filterManager, Exception e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		// TODO Auto-generated method stub
		return null;
	}

}

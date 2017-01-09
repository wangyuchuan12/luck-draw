package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.DrawRoomMember;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.service.DrawRoomMemberService;
import com.wyc.draw.service.RedPackageService;
import com.wyc.draw.vo.RedPacketVo;

public class BaseHandRedPackFilter extends Filter{

	@Autowired
	private RedPackageService redPackageService;
	
	@Autowired
	private DrawRoomMemberService drawRoomMemberService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		
		Integer timeLong = 24;
		DrawUser drawUser = (DrawUser)filterManager.getObject(DrawUser.class);

		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		
		String drawRoomId = httpServletRequest.getParameter("draw_room_id");
		
		
		String type = httpServletRequest.getParameter("type");
		
		String amount = httpServletRequest.getParameter("amount");
		Integer typeInt = Integer.parseInt(type);
		RedPacket redPacket = new RedPacket();
		if(typeInt==Constant.ROOM_QUESTION_TYPE){
			DrawRoomMember drawRoomMember = drawRoomMemberService.findByDrawUserId(drawUser.getId());
			ResultVo resultVo = new ResultVo();
			if(CommonUtil.isEmpty(drawRoomId)){
				resultVo.setSuccess(false);
				resultVo.setErrorMsg("该红包为房间红包，drawRoomId参数不能为空");
				filterManager.setReturn(true);
				filterManager.setReturnValue(resultVo);
				return null;
			}
			
			redPacket.setDrawRoomId(drawRoomId);
			redPacket.setHandDrawUserId(drawUser.getId());
			
			
			redPacket.setHandRoomMemberId(drawRoomMember.getId());
			
			
			redPacket.setHandTime(new DateTime());
			redPacket.setTimeLong(timeLong);
			redPacket.setType(typeInt);
			redPacket = redPackageService.add(redPacket);
		}else if(typeInt==Constant.PERSONAL_QUESTION_TYPE){
			redPacket.setHandDrawUserId(drawUser.getId());
			redPacket.setHandTime(new DateTime());
			redPacket.setTimeLong(timeLong);
			redPacket.setType(typeInt);
			redPacket = redPackageService.add(redPacket);
		}
		
		RedPacketVo redPacketVo = new RedPacketVo();
		redPacketVo.setDrawRoomId(drawRoomId);
		redPacketVo.setHandDrawUserId(drawUser.getId());
		redPacketVo.setHandRoomMemberId(redPacket.getHandRoomMemberId());
		redPacketVo.setHandTime(redPacket.getHandTime());
		redPacketVo.setId(redPacket.getId());
		redPacketVo.setType(typeInt);
		return redPacketVo;
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
		List<Class<? extends Filter>> filters = new ArrayList<>();
		filters.add(BaseDrawActionFilter.class);
		return filters;
	}

}

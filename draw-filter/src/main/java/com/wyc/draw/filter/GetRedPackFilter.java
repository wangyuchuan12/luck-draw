package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.wx.domain.UserInfo;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.domain.RedPacketTakepartMember;
import com.wyc.draw.service.RedPacketService;
import com.wyc.draw.service.RedPacketTakepartMemberService;
import com.wyc.draw.vo.RedPacketVo;

//获取红包信息
public class GetRedPackFilter extends Filter{

	@Autowired
	private RedPacketService redPackageService;
	
	@Autowired
	private RedPacketTakepartMemberService redPacketTakepartMemberService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		
		UserInfo userInfo = (UserInfo)filterManager.getObject(UserInfo.class);
		
		DrawUser drawUser = (DrawUser)filterManager.getObject(DrawUser.class);
		String id = httpServletRequest.getParameter("id");
		RedPacket redPacket  = redPackageService.findOne(id);
		
		
		int count = redPacketTakepartMemberService.countByRedPacketIdAndDrawUserId(id, drawUser.getId());
		
		RedPacketVo redPacketVo = new RedPacketVo();
		redPacketVo.setDrawRoomId(redPacket.getDrawRoomId());
		redPacketVo.setHandDrawUserId(redPacket.getHandDrawUserId());
		redPacketVo.setHandRoomMemberId(redPacket.getHandRoomMemberId());
		redPacketVo.setHandTime(redPacket.getHandTime());
		redPacketVo.setHandDrawUserId(redPacket.getHandDrawUserId());
		redPacketVo.setId(redPacket.getId());
		redPacketVo.setPayType(redPacket.getPayType());
		redPacketVo.setType(redPacket.getType());
		redPacketVo.setAmount(redPacket.getAmount());
		redPacketVo.setNickname(userInfo.getNickname());
		redPacketVo.setQuestion(redPacket.getQuestion());
		redPacketVo.setUserImgUrl(userInfo.getHeadimgurl());
		redPacketVo.setAnswer(redPacket.getAnswer());
		redPacketVo.setIsTimeout(redPacket.getIsTimeout());
		redPacketVo.setTimeLong(redPacket.getTimeLong());
		redPacketVo.setIsPay(redPacket.getIsPay());
		redPacketVo.setCount(count);
		redPacketVo.setAllowWrongCount(redPacket.getAllowWrongCount());
		redPacketVo.setIsPay(redPacket.getIsPay());
		
		redPacketVo.setIsReceive(redPacket.getIsReceive());
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
		List<Class<? extends Filter>> filterClasses = new ArrayList<>();
		filterClasses.add(BaseDrawActionFilter.class);
		return filterClasses;
	}

}

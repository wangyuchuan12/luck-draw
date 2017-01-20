package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.domain.view.MainPeriod;
import com.wyc.draw.service.DrawUserService;
import com.wyc.draw.service.RedPacketService;
import com.wyc.draw.vo.RedPacketListVo;
import com.wyc.draw.vo.RedPacketVo;

public class GetMainRedPacketFilter extends Filter{

	@Autowired
	private RedPacketService redPacketService;
	
	@Autowired
	private DrawUserService drawUserService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		MainPeriod mainPeriod = (MainPeriod)filterManager.getObject(MainPeriod.class);
		
		List<RedPacket> redPackets = redPacketService.findAllOfMainByPeriodId(mainPeriod.getId());
		
		List<RedPacketVo> redPacketVos = new ArrayList<>();
		
		RedPacketListVo redPacketListVo = new RedPacketListVo();
		
		redPacketListVo.setRedPacketVos(redPacketVos);
		
		for(RedPacket redPacket:redPackets){
			RedPacketVo redPacketVo = new RedPacketVo();
			
			DrawUser drawUser = drawUserService.findOne(redPacket.getHandDrawUserId());
			
			redPacketVo.setNickname(drawUser.getNickname());
			
			redPacketVo.setTakePartCount(redPacket.getTakePartCount());
			redPacketVo.setImgUrl(redPacket.getImgUrl());
			redPacketVo.setUserImgUrl(drawUser.getImgUrl());
			redPacketVo.setDrawRoomId(redPacket.getDrawRoomId());
			redPacketVo.setHandDrawUserId(redPacket.getHandDrawUserId());
			redPacketVo.setHandRoomMemberId(redPacket.getHandRoomMemberId());
			redPacketVo.setHandTime(redPacket.getHandTime());
			redPacketVo.setHandDrawUserId(redPacket.getHandDrawUserId());
			redPacketVo.setId(redPacket.getId());
			redPacketVo.setPayType(redPacket.getPayType());
			redPacketVo.setType(redPacket.getType());
			redPacketVo.setAmount(redPacket.getAmount());
			redPacketVo.setQuestion(redPacket.getQuestion());
			redPacketVo.setAnswer(redPacket.getAnswer());
			redPacketVo.setIsTimeout(redPacket.getIsTimeout());
			redPacketVo.setTimeLong(redPacket.getTimeLong());
			redPacketVo.setIsPay(redPacket.getIsPay());
			redPacketVo.setAllowWrongCount(redPacket.getAllowWrongCount());
			redPacketVo.setIsPay(redPacket.getIsPay());
			
			redPacketVo.setIsReceive(redPacket.getIsReceive());
			
			redPacketVos.add(redPacketVo);
		}
		return redPacketListVo;
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
		List<Class<? extends Filter>> classes = new ArrayList<>();
		classes.add(GetMainPeriodFilter.class);
		
		return classes;
	}

}

package com.wyc.draw.filter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.MyLongDateFormat;
import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.domain.view.MainPeriod;
import com.wyc.draw.service.RedPacketService;
import com.wyc.draw.vo.RedPacketListVo;
import com.wyc.draw.vo.RedPacketVo;

public class GetMainRedPacketFilter extends Filter{

	@Autowired
	private RedPacketService redPacketService;

	@Autowired
	private MyLongDateFormat dateFormat;
	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		MainPeriod mainPeriod = (MainPeriod)filterManager.getObject(MainPeriod.class);
		
		List<RedPacket> redPackets = redPacketService.findAllOfMainByPeriodId(mainPeriod.getId());
		
		List<RedPacketVo> redPacketVos = new ArrayList<>();
		
		RedPacketListVo redPacketListVo = new RedPacketListVo();
		
		redPacketListVo.setRedPacketVos(redPacketVos);
		
		for(RedPacket redPacket:redPackets){
			RedPacketVo redPacketVo = new RedPacketVo();
			
			redPacketVo.setNickname(redPacket.getHandNickname());
			
			redPacketVo.setTakePartCount(redPacket.getTakePartCount());
			redPacketVo.setImgUrl(redPacket.getImgUrl());
			redPacketVo.setUserImgUrl(redPacket.getHandUserImgUrl());
			redPacketVo.setDrawRoomId(redPacket.getDrawRoomId());
			redPacketVo.setHandDrawUserId(redPacket.getHandDrawUserId());
			redPacketVo.setHandRoomMemberId(redPacket.getHandRoomMemberId());
			if(redPacket.getHandTime()!=null){
				redPacketVo.setHandTime(dateFormat.format(redPacket.getHandTime().toDate()));
			}
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
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> classes = new ArrayList<>();
		classes.add(GetMainPeriodFilter.class);
		
		return classes;
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

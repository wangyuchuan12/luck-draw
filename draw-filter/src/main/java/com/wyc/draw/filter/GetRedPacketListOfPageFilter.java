package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.common.util.Constant;
import com.wyc.common.util.MySimpleDateFormat;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.service.RedPacketService;
import com.wyc.draw.vo.RedPacketListVo;
import com.wyc.draw.vo.RedPacketVo;

public class GetRedPacketListOfPageFilter extends Filter{

	@Autowired
	private MySimpleDateFormat dateFormat;
	@Autowired
	private RedPacketService redPacketService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		
		DrawUser drawUser = (DrawUser)filterManager.getObject(DrawUser.class);
		String type = httpServletRequest.getParameter("type");
		
		String page = httpServletRequest.getParameter("page");
		String size = httpServletRequest.getParameter("size");
		
		if(CommonUtil.isEmpty(page)){
			page = "0";
		}
		
		if(CommonUtil.isEmpty(size)){
			size = "50";
		}
		
		int pageInt = Integer.parseInt(page);
		
		int sizeInt = Integer.parseInt(size);
		
		Sort sort = new Sort(Direction.DESC,"handTime");
		PageRequest pageRequest = new PageRequest(pageInt, sizeInt, sort);
		
		Integer typeInt = Integer.parseInt(type);
		List<RedPacket> redPackets = new ArrayList<>();
		if(typeInt==Constant.RED_PACKET_TYPE_ALL){
			redPackets   = redPacketService.findAllOfRelatedToDrawUserId(drawUser.getId(),pageInt*sizeInt,sizeInt);
		}else if(typeInt==Constant.RED_PACKET_TYPE_HAND){
			redPackets   = redPacketService.findAllByHandDrawUserId(drawUser.getId(),pageRequest).getContent();
		}else if(typeInt==Constant.RED_PACKET_TYPE_TAKEPART){
			redPackets = redPacketService.findAllByHandDrawUserIdOfTakepart(drawUser.getId(),pageRequest).getContent();
		}
		
		
		RedPacketListVo redPacketListVo = new RedPacketListVo();
		List<RedPacketVo> redPacketVos = new ArrayList<>();
		
		for(RedPacket redPacket:redPackets){
			RedPacketVo redPacketVo = new RedPacketVo();
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
			redPacketVo.setUserImgUrl(redPacket.getHandUserImgUrl());
			redPacketVo.setImgUrl(redPacket.getImgUrl());
			
			redPacketVo.setIsReceive(redPacket.getIsReceive());
			
			redPacketVo.setIsAmountDisplay(redPacket.getIsAmountDisplay());
			
			redPacketVo.setInstruction(redPacket.getInstruction());
			
			redPacketVo.setTheme(redPacket.getTheme());
			
			redPacketVo.setIsGiveQuestion(redPacket.getIsGiveQuestion());
			redPacketVos.add(redPacketVo);
		}
		redPacketListVo.setRedPacketVos(redPacketVos);
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
		classes.add(BaseDrawActionFilter.class);
		
		return classes;
	}

}

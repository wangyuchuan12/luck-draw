package com.wyc.draw.filter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.common.util.MyLongDateFormat;
import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.service.RedPacketService;
import com.wyc.draw.vo.RedPacketListVo;
import com.wyc.draw.vo.RedPacketVo;

public class GetRedPackListByRoomOfPageFilter extends Filter{

	@Autowired
	private RedPacketService redPacketService;
	
	
	@Autowired
	private MyLongDateFormat dateFormat;
	
	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		String roomId = httpServletRequest.getParameter("id");
		
		String page = httpServletRequest.getParameter("page");
		String size = httpServletRequest.getParameter("size");
		
		if(CommonUtil.isEmpty(page)){
			page = "0";
		}
		
		if(CommonUtil.isEmpty(size)){
			size = "10";
		}
		
		int pageInt = Integer.parseInt(page);
		
		int sizeInt = Integer.parseInt(size);
		Sort sort = new Sort(Direction.DESC,"handTime");
		PageRequest pageRequest = new PageRequest(pageInt, sizeInt, sort);
		Page<RedPacket> redPackets = redPacketService.findAllByDrawRoomId(roomId,pageRequest);
		
		RedPacketListVo redPacketListVo = new RedPacketListVo();
		
		redPacketListVo.setCount(redPackets.getTotalElements());
		
		redPacketListVo.setSize(redPackets.getSize());
		
		redPacketListVo.setPage(pageInt);
		List<RedPacketVo> redPacketVos = new ArrayList<>();
		
		for(RedPacket redPacket:redPackets.getContent()){
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
			redPacketVo.setNickname(redPacket.getHandNickname());
			redPacketVo.setQuestion(redPacket.getQuestion());
			redPacketVo.setUserImgUrl(redPacket.getHandUserImgUrl());
			redPacketVo.setAnswer(redPacket.getAnswer());
			redPacketVo.setIsTimeout(redPacket.getIsTimeout());
			redPacketVo.setTimeLong(redPacket.getTimeLong());
			redPacketVo.setIsPay(redPacket.getIsPay());
			redPacketVo.setAllowWrongCount(redPacket.getAllowWrongCount());
			redPacketVo.setIsPay(redPacket.getIsPay());
			
			redPacketVo.setIsReceive(redPacket.getIsReceive());
			
			redPacketVo.setIsAmountDisplay(redPacket.getIsAmountDisplay());
			
			redPacketVos.add(redPacketVo);
		}
		redPacketListVo.setRedPacketVos(redPacketVos);
		return redPacketListVo;
	}


	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> filterClasses = new ArrayList<>();
		filterClasses.add(BaseDrawActionFilter.class);
		
		return filterClasses;
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

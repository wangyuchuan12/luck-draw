package com.wyc.draw.filter.controller.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.wyc.common.domain.Account;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.service.AccountService;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.domain.RedPacketOwner;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.service.RedPacketOwnerService;
import com.wyc.draw.service.RedPacketService;

public class SearchRedPacketApiFilter extends Filter{

	
	@Autowired
	private RedPacketService redPacketService;
	
	@Autowired
	private RedPacketOwnerService redPacketOwnerService;
	
	@Autowired
	private AccountService accountService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		
		Long costBean = 2l;
		
		DrawUser drawUser = sessionManager.getObject(DrawUser.class);
		
		List<String> redPacketIds = redPacketOwnerService.redPacketIdsByDrawUserId(drawUser.getId());
		
		PageRequest pageable = new PageRequest(0, 1);
		
		Page<RedPacket> redPacketPage = null;
		if(redPacketIds!=null&&redPacketIds.size()>0){
			redPacketPage = redPacketService.findAllByIsReceiveAndIsTimeoutAndIsPayAndIsSearchAbleAndIdNotInAndIsDel(0, 0, 1, 1, redPacketIds ,0, pageable);
		}else{
			redPacketPage = redPacketService.findAllByIsReceiveAndIsTimeoutAndIsPayAndIsSearchAbleAndIsDel(0, 0, 1, 1 ,0, pageable);
		}
		
		List<RedPacket> redPackets = redPacketPage.getContent();
		
		Map<String, Object> responseData = new HashMap<>();
		if(redPackets!=null&&redPackets.size()>0){
			
			RedPacket redPacket = redPackets.get(0);
			RedPacketOwner redPacketOwner = redPacketOwnerService.findOneByDrawUserIdAndRedPacketId(drawUser.getId(), redPacket.getId());
			
			if(redPacketOwner == null){
				redPacketOwner = new RedPacketOwner();
				redPacketOwner.setDrawUserId(drawUser.getId());
				redPacketOwner.setIsDel(0);
				redPacketOwner.setIsMyself(0);
				redPacketOwner.setIsReceive(redPacket.getIsReceiveAble());
				redPacketOwner.setIsTakepart(0);
				redPacketOwner.setIsTimeout(redPacket.getIsTimeout());
				redPacketOwner.setRedPacketId(redPacket.getId());
				redPacketOwner.setSource(Constant.RED_PACKET_SEARCH_SOURCE);
				redPacketOwner.setType(redPacket.getType());
				redPacketOwner.setHandNickname(redPacket.getHandNickname());
				redPacketOwner.setHandUserImgUrl(redPacket.getHandUserImgUrl());
				redPacketOwner.setWisdomCount(redPacket.getWisdomCount());
				
				redPacketOwnerService.add(redPacketOwner);
				
				responseData.put("redPacketOwner", redPacketOwner);
			}

		}
		
		Account account = accountService.fineOneSync(drawUser.getAccountId());
		
		Long wisdomCount = account.getWisdomCount();
		
		if(wisdomCount==null){
			wisdomCount = 0l;
		}
		
		wisdomCount = wisdomCount - costBean;
		
		if(wisdomCount<0){
			wisdomCount = 0l;
		}
		
		account.setWisdomCount(wisdomCount);
		accountService.update(account);
		
		//消耗豆子数量
		responseData.put("costBean", costBean);

		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setData(responseData);
		return resultVo;
		
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> filters = new ArrayList<>();
		filters.add(BaseDrawActionFilter.class);
		return filters;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}

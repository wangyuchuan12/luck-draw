package com.wyc.draw.filter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.RedPacketOwner;
import com.wyc.draw.service.RedPacketOwnerService;
import com.wyc.draw.vo.RedPacketVo;

public class CurrentRedPacketOwnerFilter extends Filter{

	@Autowired
	private RedPacketOwnerService redPacketOwnerService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		DrawUser drawUser = sessionManager.getObject(DrawUser.class);
		RedPacketVo redPacketVo = sessionManager.getObject(RedPacketVo.class);
		
		RedPacketOwner redPacketOwner = redPacketOwnerService.findOneByDrawUserIdAndRedPacketId(drawUser.getId(), redPacketVo.getId());
		
		if(redPacketOwner==null){
			redPacketOwner = new RedPacketOwner();
			redPacketOwner.setDrawUserId(drawUser.getId());
			redPacketOwner.setHandNickname(redPacketVo.getNickname());
			redPacketOwner.setHandUserImgUrl(redPacketVo.getImgUrl());
			redPacketOwner.setIsDel(0);
			if(drawUser.getId().equals(redPacketVo.getHandDrawUserId())){
				redPacketOwner.setIsMyself(1);
				
			}else{
				redPacketOwner.setIsMyself(0);
			}
			
			
			redPacketOwner.setIsTakepart(0);
			redPacketOwner.setIsTimeout(0);
			redPacketOwner.setRedPacketId(redPacketVo.getId());
			redPacketOwner.setType(redPacketVo.getType());
			redPacketOwner.setIsReceive(redPacketVo.getIsReceiveAble());
			redPacketOwner.setIsTimeout(redPacketVo.getIsTimeout());
			redPacketOwner.setWisdomCount(redPacketVo.getWisdomCount());
			
			redPacketOwnerService.add(redPacketOwner);
		
		}else{
			redPacketOwner.setIsReceive(redPacketVo.getIsReceiveAble());
			redPacketOwner.setIsTimeout(redPacketVo.getIsTimeout());
			sessionManager.update(redPacketOwner);
		}
		
		
		return redPacketOwner;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}

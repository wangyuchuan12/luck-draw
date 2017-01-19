package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.wyc.common.filter.Filter;
import com.wyc.common.service.WxUserInfoService;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.common.wx.domain.UserInfo;
import com.wyc.draw.domain.DrawRoomMember;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.filter.test.RedPacketReceiveAbleTestFilter;
import com.wyc.draw.service.DrawRoomMemberService;
import com.wyc.draw.service.DrawUserService;
import com.wyc.draw.service.RedPacketService;
import com.wyc.draw.service.RedPacketTakepartMemberService;
import com.wyc.draw.vo.RedPacketTakepartMemberListVo;
import com.wyc.draw.vo.RedPacketVo;

//获取红包信息
public class GetRedPackInfoFilter extends Filter{

	@Autowired
	private RedPacketService redPackageService;
	
	@Autowired
	private RedPacketTakepartMemberService redPacketTakepartMemberService;
	
	@Autowired
	private DrawRoomMemberService drawRoomMemberService;
	
	@Autowired
	private WxUserInfoService userInfoService;
	
	@Autowired
	private DrawUserService drawUserService;
	
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		
		DrawUser drawUser = (DrawUser)filterManager.getObject(DrawUser.class);
		String id = httpServletRequest.getParameter("id");
		RedPacket redPacket  = redPackageService.findOne(id);
		
		RedPacketTakepartMemberListVo redPacketTakepartMemberListVo = (RedPacketTakepartMemberListVo)filterManager.getObject(RedPacketTakepartMemberListVo.class);
		
		
		
		
		
		
		int count = redPacketTakepartMemberService.countByRedPacketIdAndDrawUserId(id, drawUser.getId());
		
		RedPacketVo redPacketVo = new RedPacketVo();
		
		if(redPacket.getType()==Constant.ROOM_QUESTION_TYPE){
			DrawRoomMember handRoomMember = drawRoomMemberService.findOne(redPacket.getHandRoomMemberId());
			redPacketVo.setNickname(handRoomMember.getName());
			redPacketVo.setUserImgUrl(handRoomMember.getImgUrl());
			redPacketVo.setDrawRoomId(redPacket.getDrawRoomId());
			redPacketVo.setHandRoomMemberId(redPacket.getHandRoomMemberId());
			
			int isInTheRoom = drawRoomMemberService.isInRoom(redPacket.getDrawRoomId(),drawUser.getId());
			
			if(isInTheRoom==1){
				DrawRoomMember myRoomMember = drawRoomMemberService.findByDrawUserIdAndDrawRoomId(drawUser.getId(), redPacket.getDrawRoomId());
				redPacketVo.setMyRoomMemberId(myRoomMember.getId());
				redPacketVo.setIsCreater(myRoomMember.getIsCreater());
			}
			
			redPacketVo.setIsInRoom(isInTheRoom);
		}else if(redPacket.getType()==Constant.PERSONAL_QUESTION_TYPE){
			
			DrawUser thisDrawUser = drawUserService.findOne(redPacket.getHandDrawUserId());
			redPacketVo.setNickname(thisDrawUser.getNickname());
			redPacketVo.setUserImgUrl(thisDrawUser.getImgUrl());
			
			
			if(redPacket.getHandDrawUserId().equals(drawUser.getId())){
				redPacketVo.setIsCreater(1);
			}
		}
		
		redPacketVo.setHandDrawUserId(redPacket.getHandDrawUserId());
		
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
		redPacketVo.setCount(count);
		redPacketVo.setAllowWrongCount(redPacket.getAllowWrongCount());
		redPacketVo.setIsPay(redPacket.getIsPay());
		
		redPacketVo.setIsReceive(redPacket.getIsReceive());
		
		redPacketVo.setRedPacketTakepartMemberVos(redPacketTakepartMemberListVo.getRedPacketTakepartMemberVos());
		
		redPacketVo.setIsImg(redPacket.getIsImg());
		redPacketVo.setImgUrl(redPacket.getImgUrl());
		
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
		filterClasses.add(RedPacketReceiveAbleTestFilter.class);
		
		filterClasses.add(GetTakepartMemberListByRedPacketOfPageFilter.class);
		return filterClasses;
	}

}

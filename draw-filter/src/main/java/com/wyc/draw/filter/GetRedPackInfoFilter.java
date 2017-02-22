package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.wyc.common.filter.Filter;
import com.wyc.common.service.ShareRecordService;
import com.wyc.common.service.WxUserInfoService;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.common.util.MySimpleDateFormat;
import com.wyc.common.wx.domain.WxContext;
import com.wyc.draw.domain.DrawRoomMember;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.domain.RedPacketTakepartMember;
import com.wyc.draw.filter.test.RedPacketReceiveAbleTestFilter;
import com.wyc.draw.service.DrawRoomMemberService;
import com.wyc.draw.service.DrawUserService;
import com.wyc.draw.service.RedPacketService;
import com.wyc.draw.service.RedPacketTakepartMemberService;
import com.wyc.draw.service.VieRedPacketTakepartMemberService;
import com.wyc.draw.vo.RedPacketOptionListVo;
import com.wyc.draw.vo.RedPacketTakepartMemberListVo;
import com.wyc.draw.vo.RedPacketVo;

//获取红包信息
public class GetRedPackInfoFilter extends Filter{

	@Autowired
	private RedPacketService redPackageService;
	
	@Autowired
	private RedPacketTakepartMemberService redPacketTakepartMemberService;
	
	@Autowired
	private VieRedPacketTakepartMemberService vieRedPacketTakepartMemberService;
	
	@Autowired
	private DrawRoomMemberService drawRoomMemberService;
	
	@Autowired
	private WxUserInfoService userInfoService;
	
	@Autowired
	private DrawUserService drawUserService;
	
	@Autowired
	private MySimpleDateFormat dateFormat;
	
	@Autowired
	private ShareRecordService shareRecordService;
	
	@Autowired
	private WxContext wxContext;
	
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		
		DrawUser drawUser = (DrawUser)filterManager.getObject(DrawUser.class);
		String id = httpServletRequest.getParameter("id");
		RedPacket redPacket  = redPackageService.findOne(id);
		
		RedPacketTakepartMemberListVo redPacketTakepartMemberListVo = (RedPacketTakepartMemberListVo)filterManager.getObject(RedPacketTakepartMemberListVo.class);
		
		
		RedPacketOptionListVo redPacketOptionListVo = (RedPacketOptionListVo)filterManager.getObject(RedPacketOptionListVo.class);
		
		
		
		int count = redPacketTakepartMemberService.countByRedPacketIdAndDrawUserId(id, drawUser.getId());
		
		RedPacketVo redPacketVo = new RedPacketVo();
		
		if(redPacket.getIsRoom()!=null&&redPacket.getIsRoom()==1){
			DrawRoomMember handRoomMember = drawRoomMemberService.findOne(redPacket.getHandRoomMemberId());
			redPacketVo.setNickname(handRoomMember.getName());
			redPacketVo.setUserImgUrl(handRoomMember.getImgUrl());
			redPacketVo.setDrawRoomId(redPacket.getDrawRoomId());
			redPacketVo.setHandRoomMemberId(redPacket.getHandRoomMemberId());
			
			int isInTheRoom = drawRoomMemberService.isInRoom(redPacket.getDrawRoomId(),drawUser.getId());
			
			if(isInTheRoom==1){
				DrawRoomMember myRoomMember = drawRoomMemberService.findByDrawUserIdAndDrawRoomId(drawUser.getId(), redPacket.getDrawRoomId());
				redPacketVo.setMyRoomMemberId(myRoomMember.getId());
			//	redPacketVo.setIsCreater(myRoomMember.getIsCreater());
			}
			
			redPacketVo.setIsInRoom(isInTheRoom);
		}else if(redPacket.getIsRoom()==null||redPacket.getIsRoom()==0){
			redPacketVo.setNickname(redPacket.getHandNickname());
			redPacketVo.setUserImgUrl(redPacket.getHandUserImgUrl());
			
			
			
		}
		
		
		if(redPacket.getHandDrawUserId().equals(drawUser.getId())){
			redPacketVo.setIsCreater(1);
		}else{
			redPacketVo.setIsCreater(0);
		}
		
		redPacketVo.setHandDrawUserId(redPacket.getHandDrawUserId());
		
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
		redPacketVo.setCount(count);
		redPacketVo.setAllowWrongCount(redPacket.getAllowWrongCount());
		
		redPacketVo.setIsReceive(redPacket.getIsReceive());
		
		redPacketVo.setRedPacketTakepartMemberVos(redPacketTakepartMemberListVo.getRedPacketTakepartMemberVos());
		
		redPacketVo.setIsImg(redPacket.getIsImg());
		redPacketVo.setImgUrl(redPacket.getImgUrl());
		
		redPacketVo.setIsAmountDisplay(redPacket.getIsAmountDisplay());
		
		redPacketVo.setRedPacketOptions(redPacketOptionListVo.getRedPacketOptions());
		
		redPacketVo.setIsRoom(redPacket.getIsRoom());
		
		redPacketVo.setShareCount(redPacket.getShareNum());
		
		redPacketVo.setIsGiveQuestion(redPacket.getIsGiveQuestion());
		
		
		
		Integer shareNumShowAnswer = redPacket.getShareNumShowAnswer();
		
		if(shareNumShowAnswer==null){
			shareNumShowAnswer = wxContext.getShareNumShowAnswer();
		}
		redPacketVo.setShareNumShowAnswer(shareNumShowAnswer);
		
		Integer isSetOption = redPacket.getIsSetOption();
		
		if(isSetOption==null){
			isSetOption = 0;
		}
		redPacketVo.setIsSetOption(isSetOption);
		
		//竞答红包类型有以下几个字段
		if(redPacket.getType()==Constant.VIE_TYPE){
			redPacketVo.setTheme(redPacket.getTheme());
			redPacketVo.setTakePartCount(redPacket.getTakePartCount());
			redPacketVo.setEntryFee(redPacket.getEntryFee());
			redPacketVo.setInstruction(redPacket.getInstruction());
			redPacketVo.setIsEntryFee(redPacket.getIsEntryFee());
			
			List<RedPacketTakepartMember> vieRedPacketTakepartMembers = vieRedPacketTakepartMemberService.findByRedPacketIdAndDrawUserId(redPacket.getId(),drawUser.getId());
			
			RedPacketTakepartMember vieRedPacketTakepartMember = null;
			if(vieRedPacketTakepartMembers.size()>0){
				vieRedPacketTakepartMember = vieRedPacketTakepartMembers.get(0);
			}
			
			if(vieRedPacketTakepartMember!=null&&vieRedPacketTakepartMember.getIsComplete()==1){
				//已经答过
				redPacketVo.setIsAnswer(1);
			}else{
				//未曾答过
				redPacketVo.setIsAnswer(0);
			}
			
			if(vieRedPacketTakepartMember!=null){
				redPacketVo.setIsGiveEntryFee(vieRedPacketTakepartMember.getIsGiveEntryFee());
			}else{
				redPacketVo.setIsGiveEntryFee(0);
			}
		}
		
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
		
		filterClasses.add(GetRedPacketOptionsByRedPacketIdFilter.class);
		return filterClasses;
	}

}

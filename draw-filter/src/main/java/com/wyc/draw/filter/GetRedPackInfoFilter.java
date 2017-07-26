package com.wyc.draw.filter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.common.util.MyLongDateFormat;
import com.wyc.common.wx.domain.WxContext;
import com.wyc.draw.domain.DrawRoomMember;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.domain.RedPacketToTakepartMember;
import com.wyc.draw.domain.param.VieDrawInfoParam;
import com.wyc.draw.filter.test.GetRedPacketFilter;
import com.wyc.draw.filter.test.RedPacketReceiveAbleTestFilter;
import com.wyc.draw.service.DrawRoomMemberService;
import com.wyc.draw.service.RedPacketTakepartMemberService;
import com.wyc.draw.vo.RedPacketOptionListVo;
import com.wyc.draw.vo.RedPacketVo;

//获取红包信息
public class GetRedPackInfoFilter extends Filter{
	
	@Autowired
	private RedPacketTakepartMemberService redPacketTakepartMemberService;
	
	
	@Autowired
	private DrawRoomMemberService drawRoomMemberService;
	
	
	@Autowired
	private MyLongDateFormat dateFormat;
	
	
	@Autowired
	private WxContext wxContext;
	

	
	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		
		
		System.out.println("getRedPacketInfoFilter");
		DrawUser drawUser = (DrawUser)filterManager.getObject(DrawUser.class);
		VieDrawInfoParam vieDrawInfoParam = (VieDrawInfoParam)filterManager.getObject(VieDrawInfoParam.class);
		String id = vieDrawInfoParam.getRedPacketId();
		RedPacket redPacket  = (RedPacket)filterManager.getObject(RedPacket.class);
		
		
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
		
		redPacketVo.setIsImg(redPacket.getIsImg());
		redPacketVo.setImgUrl(redPacket.getImgUrl());
		
		redPacketVo.setIsAmountDisplay(redPacket.getIsAmountDisplay());
		
		redPacketVo.setRedPacketOptions(redPacketOptionListVo.getRedPacketOptions());
		
		redPacketVo.setIsRoom(redPacket.getIsRoom());
		
		redPacketVo.setShareCount(redPacket.getShareNum());
		
		redPacketVo.setIsGiveQuestion(redPacket.getIsGiveQuestion());
		
		redPacketVo.setPlacesNum(redPacket.getPlacesNum());
		
		redPacketVo.setIsWisdom(redPacket.getIsWisdom());
		
		redPacketVo.setWisdomCount(redPacket.getWisdomCount());
		
		redPacketVo.setReceiveAmount(redPacket.getReceiveAmount());
		
		redPacketVo.setReceiveNum(redPacket.getReceiveNum());
		
		redPacketVo.setGetWisdomCount(redPacket.getGetWisdomCount());
		
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
			
			RedPacketToTakepartMember vieRedPacketToTakepartMember = (RedPacketToTakepartMember)filterManager.getObject(RedPacketToTakepartMember.class);
			
			if(vieRedPacketToTakepartMember!=null){
				int takepartStatus = vieRedPacketToTakepartMember.getTakepartStatus();
				if(takepartStatus==Constant.NOT_INVOLVED_TAKEPART_STATUS){
					redPacketVo.setIsAnswer(0);
				}else{
					redPacketVo.setIsAnswer(1);
				}
				redPacketVo.setIsGiveEntryFee(vieRedPacketToTakepartMember.getIsPay());
				redPacketVo.setGetAmount(vieRedPacketToTakepartMember.getGetAmount());
				
			}else{
				redPacketVo.setIsAnswer(0);
				redPacketVo.setIsGiveEntryFee(0);
			}
		}
		
		
		System.out.println(".................redPacketVo:"+redPacketVo);
		return redPacketVo;
	}


	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> filterClasses = new ArrayList<>();
		
		
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

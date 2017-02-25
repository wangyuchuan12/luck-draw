package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.domain.RedPacketTakepartMember;
import com.wyc.draw.domain.VieRedPacketToTakepartMember;
import com.wyc.draw.domain.param.VieDrawTakepartParam;
import com.wyc.draw.service.RedPacketService;
import com.wyc.draw.service.VieRedPacketTakepartMemberService;

public class VieTakepartFilter extends Filter{

	@Autowired
	private VieRedPacketTakepartMemberService vieRedPacketTakepartMemberService;
	
	@Autowired
	private RedPacketService redPacketService;
	
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		
		DrawUser drawUser = (DrawUser)filterManager.getObject(DrawUser.class);
		
		VieDrawTakepartParam vieDrawTakepartParam = (VieDrawTakepartParam)filterManager.getObject(VieDrawTakepartParam.class);
		
		String redPacketId = vieDrawTakepartParam.getTakepartId();
		
		if(CommonUtil.isEmpty(redPacketId)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("redPacketId参数不能为空");
			filterManager.setReturn(true);
			filterManager.setReturnValue(resultVo);
			return null;
		}
		
		RedPacket redPacket = redPacketService.findOne(redPacketId);
		Integer takePartCount = redPacket.getTakePartCount();
		if(takePartCount==0){
			takePartCount=0;
		}
		redPacket.setTakePartCount(takePartCount+1);
		redPacketService.update(redPacket);
		
		RedPacketTakepartMember vieRedPacketTakepartMember = new RedPacketTakepartMember();
		vieRedPacketTakepartMember.setDrawUserId(drawUser.getId());
		vieRedPacketTakepartMember.setIsBest(0);
		vieRedPacketTakepartMember.setIsPay(0);
		vieRedPacketTakepartMember.setOpenid(drawUser.getOpenid());
		vieRedPacketTakepartMember.setRedPacketId(redPacketId);
		vieRedPacketTakepartMember.setRightCount(0l);
		vieRedPacketTakepartMember.setTimeLong(0f);
		vieRedPacketTakepartMember.setUserId(drawUser.getUserId());
		vieRedPacketTakepartMember.setWrongCount(0l);
		vieRedPacketTakepartMember.setIsComplete(0);
		vieRedPacketTakepartMember.setNickname(drawUser.getNickname());
		vieRedPacketTakepartMember.setHeadImg(drawUser.getImgUrl());
		vieRedPacketTakepartMember.setTakepartDateTime(new DateTime());
		vieRedPacketTakepartMember.setEntryFee(redPacket.getEntryFee());
		vieRedPacketTakepartMember.setIsGiveEntryFee(redPacket.getIsEntryFee());
		vieRedPacketTakepartMember = vieRedPacketTakepartMemberService.add(vieRedPacketTakepartMember);
		
		VieRedPacketToTakepartMember vieRedPacketToTakepartMember = (VieRedPacketToTakepartMember)filterManager.getObject(VieRedPacketToTakepartMember.class);
		
		vieRedPacketToTakepartMember.setTakepartStatus(Constant.NOT_INVOLVED_TAKEPART_STATUS);
		vieRedPacketToTakepartMember.setCurrentTakepartMemberId(vieRedPacketTakepartMember.getId());
		if(redPacket.getIsEntryFee()==0){
			vieRedPacketTakepartMember.setIsPay(1);
			vieRedPacketToTakepartMember.setIsPay(1);
			vieRedPacketToTakepartMember.setTakepartStatus(Constant.UNDERWAY_TAKEPART_STATUS);
		}else{
			vieRedPacketTakepartMember.setIsPay(0);
			vieRedPacketToTakepartMember.setIsPay(0);
			
		}

		filterManager.save(vieRedPacketTakepartMember);
		
		filterManager.save(vieRedPacketToTakepartMember);
		
		ResultVo resultVo = new ResultVo();
		resultVo.setData(vieRedPacketTakepartMember);
		resultVo.setSuccess(true);
		resultVo.setMsg("参加成功");
		
		return resultVo;
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
		filterClasses.add(CurrentVieRedPacketToTakepartMemberFilter.class);
		return filterClasses;
	}

}

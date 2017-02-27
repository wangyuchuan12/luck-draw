package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.VieRedPacketToTakepartMember;
import com.wyc.draw.domain.param.VieDrawInfoParam;
import com.wyc.draw.service.VieRedPacketToTakepartMemberService;


//初始化当前的红包对应参赛人员中间表
public class CurrentVieRedPacketToTakepartMemberFilter extends Filter{

	@Autowired
	private VieRedPacketToTakepartMemberService vieRedPacketToTakepartMemberService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		DrawUser drawUser = (DrawUser)filterManager.getObject(DrawUser.class);
		VieDrawInfoParam vieDrawInfoParam = (VieDrawInfoParam)filterManager.getObject(VieDrawInfoParam.class);
		String redPacketId = vieDrawInfoParam.getRedPacketId();
		VieRedPacketToTakepartMember vieRedPacketToTakepartMember = vieRedPacketToTakepartMemberService.findByDrawUserIdAndRedPacketId(drawUser.getId(),redPacketId);
		if(vieRedPacketToTakepartMember==null){
			vieRedPacketToTakepartMember = new VieRedPacketToTakepartMember();
			vieRedPacketToTakepartMember.setDrawUserId(drawUser.getId());
			vieRedPacketToTakepartMember.setIsAnswer(0);
			vieRedPacketToTakepartMember.setIsPay(0);
			vieRedPacketToTakepartMember.setRedPacketId(redPacketId);
			vieRedPacketToTakepartMember.setTakepartCount(0);
			vieRedPacketToTakepartMember.setTakepartStatus(Constant.NOT_INVOLVED_TAKEPART_STATUS);
			vieRedPacketToTakepartMember.setVisitCount(1);
			
			vieRedPacketToTakepartMemberService.add(vieRedPacketToTakepartMember);
		}else{
			String currentTakepartMembetId = vieRedPacketToTakepartMember.getCurrentTakepartMemberId();
			if(!CommonUtil.isEmpty(currentTakepartMembetId)){
				
			}
			vieRedPacketToTakepartMember.setVisitCount(vieRedPacketToTakepartMember.getVisitCount()+1);
			vieRedPacketToTakepartMemberService.update(vieRedPacketToTakepartMember);
		}
		return vieRedPacketToTakepartMember;
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
		return null;
	}

}

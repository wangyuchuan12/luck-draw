package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.DekornToTakepartMember;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.param.DekornTakepartParam;
import com.wyc.draw.service.DekornToTakepartMemberService;

public class CurrentDekornToTakepartFilter extends Filter{


	@Autowired
	private DekornToTakepartMemberService dekornToTakepartMemberService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		DekornTakepartParam dekornTakepartParam = (DekornTakepartParam)filterManager.getObject(DekornTakepartParam.class);
		DrawUser drawUser = (DrawUser)filterManager.getObject(DrawUser.class);
		
		DekornToTakepartMember dekornToTakepartMember = dekornToTakepartMemberService.findOneByDekornIdAndDrawUserId(dekornTakepartParam.getDekornId(),drawUser.getId());
		if(dekornToTakepartMember==null){
			dekornToTakepartMember = new DekornToTakepartMember();
			dekornToTakepartMember.setDekornId(dekornTakepartParam.getDekornId());
			dekornToTakepartMember.setAdminId(drawUser.getAdminId());
			dekornToTakepartMember.setOpernid(drawUser.getOpenid());
			dekornToTakepartMember.setTakepartCount(0l);
			dekornToTakepartMember.setTakepartSuccessCount(0l);
			dekornToTakepartMember.setTakepartFailCount(0l);
			dekornToTakepartMember.setHighestScore(0l);
			dekornToTakepartMember.setAverageScore(0l);
			dekornToTakepartMember.setLoveLifeCount(0l);
			dekornToTakepartMember.setObtainWisdomNum(0l);
			dekornToTakepartMember.setObtainIntegralNum(0l);
			dekornToTakepartMember.setTakepartStatus(Constant.DEKORN_NOT_INVOLVED_TAKEPART_STATUS);
			dekornToTakepartMember.setVisitCount(0);
			dekornToTakepartMember.setDrawUserId(drawUser.getId());
			dekornToTakepartMember.setOpernid(drawUser.getOpenid());
			dekornToTakepartMemberService.add(dekornToTakepartMember);
		}
		return dekornToTakepartMember;
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
		// TODO Auto-generated method stub
		return null;
	}

}

package com.wyc.draw.filter.controller.api;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.DekornTakepartMember;
import com.wyc.draw.domain.DekornToTakepartMember;
import com.wyc.draw.filter.CurrentDekornToTakepartFilter;
import com.wyc.draw.filter.DekornSuccessHandleFilter;
import com.wyc.draw.filter.RewardFilter;
import com.wyc.draw.filter.controller.param.DekornResultHandleParamFilter;
import com.wyc.draw.service.DekornTakepartMemberService;

public class DekornSuccessApiFilter extends Filter{

	
	@Autowired
	private DekornTakepartMemberService dekornTakepartMemberService;
	
	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		Integer score = (Integer)filterManager.getAttribute("score");
		DekornToTakepartMember dekornToTakepartMember = (DekornToTakepartMember)filterManager.getObject(DekornToTakepartMember.class);
		if(dekornToTakepartMember.getHighestScore()==null||dekornToTakepartMember.getHighestScore()<score){
			dekornToTakepartMember.setHighestScore(score.longValue());
	//		dekornToTakepartMemberService.update(dekornToTakepartMember);
		}
		
		DekornTakepartMember dekornTakepartMember = (DekornTakepartMember)filterManager.getObject(DekornTakepartMember.class);
		
		dekornTakepartMember.setScore(score.longValue());
		
		dekornTakepartMemberService.update(dekornTakepartMember);
		
		
		return null;
	}


	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> classes = new ArrayList<>();
		classes.add(DekornResultHandleParamFilter.class);
		classes.add(CurrentDekornToTakepartFilter.class);
		classes.add(DekornSuccessHandleFilter.class);
		classes.add(RewardFilter.class);
		return classes;
	}


	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		HttpServletRequest httpServletRequest = sessionManager.getHttpServletRequest();
		
		String score = httpServletRequest.getParameter("score");
		String dekornId = httpServletRequest.getParameter("dekornId");
		String takepartId = httpServletRequest.getParameter("takepartId");
		sessionManager.setAttribute("score", Integer.parseInt(score));
		sessionManager.setAttribute("dekornId", dekornId);
		sessionManager.setAttribute("takepartId", takepartId);
		return null;
	}


	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}

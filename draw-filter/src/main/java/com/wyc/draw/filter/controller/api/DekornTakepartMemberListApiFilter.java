package com.wyc.draw.filter.controller.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.draw.domain.DekornTakepartMember;
import com.wyc.draw.domain.DekornToTakepartMember;
import com.wyc.draw.domain.param.DekornTakepartParam;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.CurrentDekornToTakepartFilter;
import com.wyc.draw.filter.GetDekornTakepartMemberListByPageFilter;
import com.wyc.draw.service.DekornTakepartMemberService;
import com.wyc.draw.vo.DekornTakepartMemberListVo;

public class DekornTakepartMemberListApiFilter extends Filter{

	@Autowired
	private DekornTakepartMemberService dekornTakepartMemberService;
	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		DekornTakepartMemberListVo dekornTakepartMemberListVo = (DekornTakepartMemberListVo)filterManager.getObject(DekornTakepartMemberListVo.class);
		
		
		DekornToTakepartMember dekornToTakepartMember = (DekornToTakepartMember)filterManager.getObject(DekornToTakepartMember.class);
		
		
		Map<String, Object> data = new HashMap<>();
		
		if(!CommonUtil.isEmpty(dekornToTakepartMember.getCurrentTakepartMemberId())){
		
			DekornTakepartMember dekornTakepartMember = dekornTakepartMemberService.findOne(dekornToTakepartMember.getCurrentTakepartMemberId());
			
			
			
			Long rank = dekornTakepartMemberService.rankOfTakepartMember(dekornToTakepartMember.getCurrentTakepartMemberId());
			
			Map<String, Object> dekornTakepartMemberMap = new HashMap<>();
			
			dekornTakepartMemberMap.put("rank", rank);
			dekornTakepartMemberMap.put("nickname", dekornTakepartMember.getNickname());
			dekornTakepartMemberMap.put("headImg", dekornTakepartMember.getHeadImg());
			dekornTakepartMemberMap.put("score", dekornTakepartMember.getScore());
			
			
			data.put("thisMember", dekornTakepartMemberMap);
		}
		
		data.put("members", dekornTakepartMemberListVo.getDekornTakepartMembers());
		
		resultVo.setData(data);
		return resultVo;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		
		List<Class<? extends Filter>> classes = new ArrayList<>();
		classes.add(BaseDrawActionFilter.class);
		classes.add(CurrentDekornToTakepartFilter.class);
		classes.add(GetDekornTakepartMemberListByPageFilter.class);
		return classes;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		HttpServletRequest httpServletRequest = sessionManager.getHttpServletRequest();
		DekornTakepartParam dekornTakepartParam = new DekornTakepartParam();
		String dekornId = httpServletRequest.getParameter("dekornId");
		dekornTakepartParam.setDekornId(dekornId);
		sessionManager.save(dekornTakepartParam);
		return dekornTakepartParam;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}

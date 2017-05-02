package com.wyc.draw.filter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.draw.domain.DekornTakepartMember;
import com.wyc.draw.service.DekornTakepartMemberService;
import com.wyc.draw.vo.DekornTakepartMemberListVo;

public class GetDekornTakepartMemberListByPageFilter extends Filter{

	
	@Autowired
	private DekornTakepartMemberService dekornTakepartMemberService;
	
	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		
		String page = httpServletRequest.getParameter("page");
		String size = httpServletRequest.getParameter("size");
		
		String dekornId = httpServletRequest.getParameter("dekornId");
		
		if(CommonUtil.isEmpty(page)){
			page = "0";
		}
		
		if(CommonUtil.isEmpty(size)){
			size = "10";
		}
		Integer pageInt = Integer.parseInt(page);
		Integer sizeInt = Integer.parseInt(size);
		
		Sort sort = new Sort(Direction.DESC,"score");
		Pageable pageable = new PageRequest(pageInt, sizeInt, sort);
		
		List<DekornTakepartMember> dekornTakepartMembers = dekornTakepartMemberService.findAllByDekornId(dekornId, pageable);
		
		DekornTakepartMemberListVo dekornTakepartMemberListVo = new DekornTakepartMemberListVo();
		dekornTakepartMemberListVo.setDekornTakepartMembers(dekornTakepartMembers);
		return dekornTakepartMemberListVo;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		// TODO Auto-generated method stub
		return null;
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

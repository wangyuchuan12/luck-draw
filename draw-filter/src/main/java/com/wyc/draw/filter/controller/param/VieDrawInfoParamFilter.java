package com.wyc.draw.filter.controller.param;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.param.GetCommentParam;
import com.wyc.draw.domain.param.VieDrawInfoParam;
import com.wyc.draw.filter.BaseDrawActionFilter;

public class VieDrawInfoParamFilter extends Filter{

	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		
		DrawUser drawUser = (DrawUser)filterManager.getObject(DrawUser.class);
		String id = httpServletRequest.getParameter("id");
		
		VieDrawInfoParam vieDrawInfoParam = new VieDrawInfoParam();
		
		GetCommentParam getCommentParam = new GetCommentParam();
		
		vieDrawInfoParam.setRedPacketId(id);
		
		getCommentParam.setRedPacketId(id);
		
		getCommentParam.setDrawUserId(drawUser.getId());
		
		filterManager.save(getCommentParam);
		
		String page = httpServletRequest.getParameter("page");
		String size = httpServletRequest.getParameter("size");
		
		
		
		if(CommonUtil.isEmpty(page)){
			page = "0";
		}
		
		if(CommonUtil.isEmpty(size)){
			size = "10";
		}
		
		int pageInt = Integer.parseInt(page);
		int sizeInt = Integer.parseInt(size);
		
		vieDrawInfoParam.setTakepartMemberPage(pageInt);
		vieDrawInfoParam.setTakepartMemberSize(sizeInt);
		return vieDrawInfoParam;
	}


	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> filterClasses = new ArrayList<>();
		filterClasses.add(BaseDrawActionFilter.class);
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

package com.wyc.draw.filter.controller.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.RedPacketOwner;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.service.RedPacketOwnerService;

public class RedPacketOwnerListApiFilter extends Filter{

	@Autowired
	private RedPacketOwnerService redPacketDisplayService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		
		Integer isMyself = (Integer)sessionManager.getAttribute("isMyself");
		DrawUser drawUser = sessionManager.getObject(DrawUser.class);
		List<RedPacketOwner> redPacketDisplays = redPacketDisplayService.findAllByDrawUserIdAndIsMyselfAndIsDel(drawUser.getId(),isMyself,0);
		
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setData(redPacketDisplays);
		
		return resultVo;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		HttpServletRequest httpServletRequest = sessionManager.getHttpServletRequest();
		String isMyself = httpServletRequest.getParameter("isMyself");
		
		if(CommonUtil.isEmpty(isMyself)){
			isMyself = "0";
		}
		sessionManager.setAttribute("isMyself", Integer.parseInt(isMyself));
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> classes = new ArrayList<>();
		classes.add(BaseDrawActionFilter.class);
		return classes;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}

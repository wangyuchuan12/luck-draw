package com.wyc.draw.filter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.domain.RedPacketOption;
import com.wyc.draw.service.RedPacketOptionService;
import com.wyc.draw.service.RedPacketService;
import com.wyc.draw.vo.RedPacketOptionListVo;

public class GetRedPacketOptionsByRedPacketIdFilter extends Filter{

	@Autowired
	private RedPacketOptionService redPacketOptionService;
	
	@Autowired
	private RedPacketService redPacketService;
	@Override
	public Object handlerBefore(SessionManager filterManager) throws Exception {
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		
		String id = httpServletRequest.getParameter("id");
		
		RedPacket packet = redPacketService.findOne(id);
		
		List<RedPacketOption> redPacketOptions = redPacketOptionService.findAllByRedPacketIdAndIsDelOrderBySeqAsc(id,0);
		
		
		RedPacketOptionListVo redPacketOptionListVo = new RedPacketOptionListVo();
		
		redPacketOptionListVo.setAnswer(packet.getAnswer());
		
		redPacketOptionListVo.setRedPacketOptions(redPacketOptions);
		
		return redPacketOptionListVo;
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
		List<Class<? extends Filter>> classes = new ArrayList<>();
		classes.add(BaseDrawActionFilter.class);
		
		return classes;
	}

}

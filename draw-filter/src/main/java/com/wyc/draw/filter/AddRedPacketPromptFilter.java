package com.wyc.draw.filter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.RedPacketPrompt;
import com.wyc.draw.service.RedPacketPromptService;
import com.wyc.draw.vo.RedPacketPromptVo;

public class AddRedPacketPromptFilter extends Filter{

	@Autowired
	private RedPacketPromptService redPacketPromptService;
	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		String prompt = httpServletRequest.getParameter("prompt");
		String redPacketId = httpServletRequest.getParameter("red_packet_id");
		
		RedPacketPrompt redPacketPrompt = new RedPacketPrompt();
		redPacketPrompt.setPrompt(prompt);
		redPacketPrompt.setIsDel(0);
		redPacketPrompt.setRedPacketId(redPacketId);
		
		redPacketPrompt = redPacketPromptService.add(redPacketPrompt);
		
		
		RedPacketPromptVo redPacketPromptVo = new RedPacketPromptVo();
		redPacketPromptVo.setId(redPacketPrompt.getId());
		redPacketPromptVo.setPrompt(redPacketPrompt.getPrompt());
		redPacketPromptVo.setRedPacketId(redPacketPrompt.getRedPacketId());
		return redPacketPromptVo;
	}


	@Override
	public List<Class<? extends Filter>> dependClasses() {
		
		List<Class<? extends Filter>> classes = new ArrayList<>();
		classes.add(BaseDrawActionFilter.class);
		
		return classes;
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

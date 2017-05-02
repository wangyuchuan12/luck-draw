package com.wyc.draw.filter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.RedPacketPrompt;
import com.wyc.draw.service.RedPacketPromptService;
public class DelRedPacketPromptFilter extends Filter{

	@Autowired
	private RedPacketPromptService redPacketPromptService;
	@Override
	public Object handlerFilter(SessionManager filterManager) throws Exception {
		
		HttpServletRequest httpServletRequest = filterManager.getHttpServletRequest();
		String id = httpServletRequest.getParameter("id");
		
		RedPacketPrompt redPacketPrompt = redPacketPromptService.findOne(id);
		redPacketPrompt.setIsDel(1);
		
		redPacketPromptService.update(redPacketPrompt);
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setMsg("删除成功");
		
		return resultVo;
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

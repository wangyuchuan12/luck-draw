package com.wyc.draw.filter.controller.api;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.draw.domain.Question;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.RandomQuestionFilter;

public class RandomQuestionApiFilter extends Filter{

	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		ResultVo resultVo = new ResultVo();
		Question question = (Question)sessionManager.getObject(Question.class);
		
		resultVo.setData(question);
		resultVo.setSuccess(true);
		
		return resultVo;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		HttpServletRequest httpServletRequest = sessionManager.getHttpServletRequest();
		String paperId = httpServletRequest.getParameter("id");
		if(!CommonUtil.isEmpty(paperId)){
			sessionManager.setAttribute("paperId", paperId);
		}
		return null;
	}
	
	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> classes = new ArrayList<>();
		
		classes.add(BaseDrawActionFilter.class);
		
		classes.add(RandomQuestionFilter.class);
		
		return classes;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		System.out.println("...............after");
		return null;
	}
}

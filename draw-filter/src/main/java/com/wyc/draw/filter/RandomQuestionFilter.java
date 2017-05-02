package com.wyc.draw.filter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.service.QuestionService;

public class RandomQuestionFilter extends Filter{

	@Autowired
	private QuestionService questionService;
	
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		
		return null;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		return null;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}

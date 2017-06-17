package com.wyc.draw.filter.controller.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.PaperAnswer;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.PaperAnswerFilter;


public class AnswerQuestionApiFilter extends Filter{

	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		
		PaperAnswer paperAnswer = (PaperAnswer)sessionManager.getObject(PaperAnswer.class);
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setMsg("成功");
		resultVo.setData(paperAnswer);
		return resultVo;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		HttpServletRequest httpServletRequest = sessionManager.getHttpServletRequest();
		
		String paperId = httpServletRequest.getParameter("paperId");
		String questionId = httpServletRequest.getParameter("questionId");
		
		String isTimeout = httpServletRequest.getParameter("isTimeout");
		
		String timelong = httpServletRequest.getParameter("timelong");
		
		String optionId = httpServletRequest.getParameter("optionId");
		
		String keyId = httpServletRequest.getParameter("keyId");
		
		String type = httpServletRequest.getParameter("type");
		
		sessionManager.setAttribute("paperId", paperId);
		
		sessionManager.setAttribute("questionId", questionId);
		
		sessionManager.setAttribute("isTimeout", Integer.parseInt(isTimeout));
		
		sessionManager.setAttribute("timelong", Float.parseFloat(timelong));
		
		sessionManager.setAttribute("optionId", optionId);
		
		sessionManager.setAttribute("keyId", keyId);
		
		sessionManager.setAttribute("type", Integer.parseInt(type));
		return null;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> classes = new ArrayList<>();
		classes.add(BaseDrawActionFilter.class);
		
		classes.add(PaperAnswerFilter.class);
		
		return classes;
	}

}

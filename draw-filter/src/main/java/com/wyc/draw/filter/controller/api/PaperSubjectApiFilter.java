package com.wyc.draw.filter.controller.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.PaperSubject;
import com.wyc.draw.service.PaperSubjectService;

public class PaperSubjectApiFilter extends Filter{

	@Autowired
	private PaperSubjectService paperSubjectService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		String patternId = sessionManager.getAttribute("patternId").toString();
		List<PaperSubject> paperSubjects = paperSubjectService.findAllByPatternId(patternId);
		
		ResultVo resultVo = new ResultVo();
		resultVo.setData(paperSubjects);
		resultVo.setSuccess(true);
		return resultVo;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		HttpServletRequest httpServletRequest = sessionManager.getHttpServletRequest();
		String patternId = httpServletRequest.getParameter("patternId");
		sessionManager.setAttribute("patternId", patternId);
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}

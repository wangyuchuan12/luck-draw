package com.wyc.draw.web.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.Paper;
import com.wyc.draw.domain.Question;
import com.wyc.draw.filter.controller.api.RandomQuestionApiFilter;
import com.wyc.draw.service.PaperService;

@Controller
@RequestMapping(value="/view/question/")
public class QuestionController {

	
	@Autowired
	private PaperService paperService;
	
	@RequestMapping(value="paperInfo")
	@HandlerAnnotation(hanlerFilter=RandomQuestionApiFilter.class)
	public String paperInfo(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		String paperId = httpServletRequest.getParameter("id");
		String keyId = httpServletRequest.getParameter("keyId");
		Question question = (Question)sessionManager.getObject(Question.class);
		httpServletRequest.setAttribute("paperId", paperId);
		httpServletRequest.setAttribute("question", question);
		
		Paper paper = paperService.findOne(paperId);
		
		httpServletRequest.setAttribute("paper", paper);
		httpServletRequest.setAttribute("keyId", keyId);
		return "paper/paper";
	}
	
	@RequestMapping(value="papers")
	public String paperList(HttpServletRequest httpServletRequest)throws Exception{
		return "mainPaper";
	}
	
	@RequestMapping(value="info")
	public String info(HttpServletRequest httpServletRequest){
		
		return "paper/questionInfo";
	}
	
	@RequestMapping(value="questionresult")
	public String questionResult(HttpServletRequest httpServletRequest)throws Exception{
		
		String paperId = httpServletRequest.getParameter("paperId");
		
		String keyId = httpServletRequest.getParameter("keyId");
		
		httpServletRequest.setAttribute("paperId", paperId);
		
		httpServletRequest.setAttribute("keyId", keyId);
		return "paper/questionresult";
	}
	
	@RequestMapping(value="addQuestionBank")
	public String addQuestionBank(HttpServletRequest httpServletRequest)throws Exception{
		return "paper/addQuestionBank";
	}
}

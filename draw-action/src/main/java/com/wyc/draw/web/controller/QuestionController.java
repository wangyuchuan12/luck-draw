package com.wyc.draw.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.draw.domain.Paper;
import com.wyc.draw.domain.Question;
import com.wyc.draw.domain.QuestionOption;
import com.wyc.draw.filter.controller.api.RandomQuestionApiFilter;
import com.wyc.draw.service.PaperService;
import com.wyc.draw.service.QuestionOptionService;
import com.wyc.draw.service.QuestionService;

@Controller
@RequestMapping(value="/view/question/")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuestionOptionService questionOptionService;
	
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
		String id = httpServletRequest.getParameter("id");
		
		Question question = questionService.findOne(id);
		
		List<QuestionOption> questionOptions = questionOptionService.findAllByQuestionId(id);
		
		httpServletRequest.setAttribute("question", question);
		
		httpServletRequest.setAttribute("questionOptions", questionOptions);
		String index = httpServletRequest.getParameter("index");
		
		String count = httpServletRequest.getParameter("count");
		if(CommonUtil.isEmpty(index)){
			index = "0";
		}
		
		httpServletRequest.setAttribute("index", index);
		httpServletRequest.setAttribute("count", count);
		
		return "paper/questionInfo";
	}
}

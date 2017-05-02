package com.wyc.draw.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wyc.draw.domain.Question;
import com.wyc.draw.domain.QuestionOption;
import com.wyc.draw.service.QuestionOptionService;
import com.wyc.draw.service.QuestionService;

@Controller
@RequestMapping(value="/view/question/")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuestionOptionService questionOptionService;
	
	
	@RequestMapping(value="paperInfo")
	public String paperInfo(HttpServletRequest httpServletRequest)throws Exception{
		String paperId = httpServletRequest.getParameter("paperId");
		httpServletRequest.setAttribute("paperId", paperId);
		
		
		
		List<Question> questions = questionService.findAllByPaperId(paperId);
		
		httpServletRequest.setAttribute("questions", questions);
		return "paper/paper";
	}
	
	@RequestMapping(value="info")
	public String info(HttpServletRequest httpServletRequest){
		String id = httpServletRequest.getParameter("id");
		
		Question question = questionService.findOne(id);
		
		List<QuestionOption> questionOptions = questionOptionService.findAllByQuestionId(id);
		
		httpServletRequest.setAttribute("question", question);
		
		httpServletRequest.setAttribute("questionOptions", questionOptions);
		
		return "paper/questionInfo";
	}
}

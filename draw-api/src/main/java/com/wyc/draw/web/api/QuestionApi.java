package com.wyc.draw.web.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.Paper;
import com.wyc.draw.domain.Question;
import com.wyc.draw.domain.QuestionAnswer;
import com.wyc.draw.domain.QuestionOption;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.controller.api.AnswerQuestionApiFilter;
import com.wyc.draw.filter.controller.api.RandomQuestionApiFilter;
import com.wyc.draw.service.PaperService;
import com.wyc.draw.service.QuestionAnswerService;
import com.wyc.draw.service.QuestionOptionService;
import com.wyc.draw.service.QuestionService;

@Controller
@RequestMapping(value="/api/draw/question/")
public class QuestionApi {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private PaperService paperService;
	
	@Autowired
	private QuestionOptionService questionOptionService;
	
	@Autowired
	private QuestionAnswerService questionAnswerService;
	
	@RequestMapping(value="answerPaper")
	@HandlerAnnotation(hanlerFilter=BaseDrawActionFilter.class)
	@ResponseBody
	public Object answerPaper(HttpServletRequest httpServletRequest)throws Exception{
		String paperId = httpServletRequest.getParameter("paperId");
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		DrawUser drawUser = (DrawUser)sessionManager.getObject(DrawUser.class);
		
		List<QuestionAnswer> questionAnswers = questionAnswerService.findAllByPaperIdAndDrawUserIdAndIsDel(paperId,drawUser.getId(),0);
		
		Map<String, QuestionAnswer>  questionAnswerMap = new HashMap<>();
		
		for(QuestionAnswer questionAnswer:questionAnswers){
			questionAnswerMap.put(questionAnswer.getQuestionId(), questionAnswer);
		}
		
		Paper paper = paperService.findOne(paperId);
		
		List<Question> questions = questionService.findAllByPaperIdAndIsDel(paperId, 0);
		
		Map<String, Object> responseData = new HashMap<>();
	
		List<QuestionOption> questionOptions = questionOptionService.findAllByPaperIdOrderBySeqAsc(paperId);
		Map<String, List<QuestionOption>> optionMap = new HashMap<>();
		for(QuestionOption questionOption:questionOptions){
			List<QuestionOption> thisOptions = optionMap.get(questionOption.getQuestionId());
			if(thisOptions==null){
				thisOptions = new ArrayList<>();
				optionMap.put(questionOption.getQuestionId(), thisOptions);
			}
			thisOptions.add(questionOption);
		}
		
		List<Map<String, Object>> responseQuestions = new ArrayList<>();
		
		for(Question question:questions){
			
			QuestionAnswer questionAnswer = questionAnswerMap.get(question.getId());
			Map<String, Object> responseQuestion = new HashMap<>();
			responseQuestion.put("answer", question.getAnswer());
			responseQuestion.put("fillWords", question.getFillWords());
			responseQuestion.put("id", question.getId());
			responseQuestion.put("imgUrl", question.getImgUrl());
			responseQuestion.put("index", question.getIndex());
			responseQuestion.put("isDel", question.getIsDel());
			responseQuestion.put("isImg", question.getIsImg());
			responseQuestion.put("paperId", question.getPaperId());
			responseQuestion.put("question", question.getQuestion());
			responseQuestion.put("instruction", question.getInstruction());
			responseQuestion.put("rightOptionId", question.getRightOptionId());
			if(questionAnswer!=null){
				responseQuestion.put("checkOptionId", questionAnswer.getCheckOptionId());
			}
			
			responseQuestion.put("score", question.getScore());
			responseQuestion.put("type", question.getType());
			List<QuestionOption> thisOptions = optionMap.get(question.getId());
			responseQuestion.put("options", thisOptions);
			responseQuestions.add(responseQuestion);	
		}
		responseData.put("paper", paper);
		responseData.put("questions", responseQuestions);
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setData(responseData);
		
		return resultVo;
	}
	
	
	@RequestMapping(value="randomQuestion")
	@HandlerAnnotation(hanlerFilter=RandomQuestionApiFilter.class)
	@ResponseBody
	public Object randomQuestion(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		if(sessionManager.getObject(ResultVo.class)!=null){
			ResultVo resultVo = (ResultVo)sessionManager.getObject(ResultVo.class);
			return resultVo;
		}else{
			return sessionManager.getReturnValue();
		}
	}
	
	@Transactional
	@RequestMapping(value="answerQuestion")
	@HandlerAnnotation(hanlerFilter=AnswerQuestionApiFilter.class)
	@ResponseBody
	public Object answerQuestion(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		if(sessionManager.getObject(ResultVo.class)!=null){
			ResultVo resultVo = (ResultVo)sessionManager.getObject(ResultVo.class);
			return resultVo;
		}else{
			return sessionManager.getReturnValue();
		}
	}
}

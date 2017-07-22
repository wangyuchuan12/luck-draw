package com.wyc.draw.filter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.domain.Question;
import com.wyc.draw.domain.QuestionAnswer;
import com.wyc.draw.domain.QuestionOption;
import com.wyc.draw.service.QuestionAnswerService;
import com.wyc.draw.service.QuestionOptionService;
import com.wyc.draw.service.QuestionService;

public class AnswerQuestionFilter extends Filter{

	@Autowired
	private QuestionAnswerService questionAnswerService;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuestionOptionService questionOptionService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		
		DrawUser drawUser = sessionManager.getObject(DrawUser.class);
		String questionId = sessionManager.getAttribute("questionId").toString();
		Integer isTimeout = (Integer)sessionManager.getAttribute("isTimeout");
		Float timelong = (Float)sessionManager.getAttribute("timelong");
		String optinId = sessionManager.getAttribute("optionId").toString();
		String keyId = sessionManager.getAttribute("keyId").toString();
		Integer type = (Integer)sessionManager.getAttribute("type");
		
		Question question = questionService.findOne(questionId);
		
		
		
		QuestionOption checkQuestionOption = (QuestionOption)questionOptionService.findOne(optinId);
		
		Integer isRight=0;
		QuestionOption rightQuestionOption = null;
		if(question.getRightOptionId().equals(optinId)){
			rightQuestionOption = checkQuestionOption;
			isRight= 1;
		}else{
			rightQuestionOption = (QuestionOption)questionOptionService.findOne(question.getRightOptionId());
			isRight= 0;
		}
		
		QuestionAnswer questionAnswer = new QuestionAnswer();
		if(isTimeout==0){
			questionAnswer.setAnswer(checkQuestionOption.getContent());
		}
		questionAnswer.setCheckOptionId(optinId);
		questionAnswer.setIsRight(isRight);
		questionAnswer.setPaperId(question.getPaperId());
		questionAnswer.setQuestionId(questionId);
		questionAnswer.setRightAnswer(rightQuestionOption.getContent());
		questionAnswer.setTimeLong(timelong);
		questionAnswer.setIsTimeout(isTimeout);
		questionAnswer.setKeyId(keyId);
		questionAnswer.setType(type);
		questionAnswer.setIsDel(0);
		questionAnswer.setDrawUserId(drawUser.getId());
		if(isRight==1){
			questionAnswer.setScore(question.getScore());
		}else{
			questionAnswer.setScore(0);
		}
		
		sessionManager.save(question);
		questionAnswer = questionAnswerService.add(questionAnswer);
		return questionAnswer;
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

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	

}

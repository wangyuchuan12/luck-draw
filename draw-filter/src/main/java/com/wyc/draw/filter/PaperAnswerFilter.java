package com.wyc.draw.filter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.PaperAnswer;
import com.wyc.draw.domain.Question;
import com.wyc.draw.domain.QuestionAnswer;
import com.wyc.draw.service.PaperAnswerService;
public class PaperAnswerFilter extends Filter{

	@Autowired
	private PaperAnswerService paperAnswerService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		String paperId = sessionManager.getAttribute("paperId").toString();
		Question question = (Question)sessionManager.getObject(Question.class);
		if(!question.getPaperId().equals(paperId)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("paperId跟该question不匹配");
			sessionManager.setReturn(true);
			sessionManager.setReturnValue(resultVo);
			return null;
		}
		
		QuestionAnswer questionAnswer = (QuestionAnswer)sessionManager.getObject(QuestionAnswer.class);
		
		PaperAnswer paperAnswer = (PaperAnswer)sessionManager.getObject(PaperAnswer.class);
		if(questionAnswer.getIsRight()==1){
			paperAnswer.setRightCount(paperAnswer.getRightCount()+1);
			paperAnswer.setScore(paperAnswer.getScore()+question.getScore());
			
		}else{
			paperAnswer.setWrongCount(paperAnswer.getWrongCount()+1);
		}
		
		paperAnswer = paperAnswerService.update(paperAnswer);
		
		return paperAnswer;
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
		List<Class<? extends Filter>> classes = new ArrayList<>();
		classes.add(AnswerQuestionFilter.class);
		classes.add(CurrentPaperAnswerFilter.class);
		return classes;
	}

}

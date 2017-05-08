package com.wyc.draw.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.Question;
import com.wyc.draw.service.QuestionService;

public class RandomQuestionFilter extends Filter{

	@Autowired
	private QuestionService questionService;
	
	private String key="questions123";
	
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		
		Object paperId = sessionManager.getAttribute("paperId");
		
		List<String> questionids = (List<String>)sessionManager.rawGetBySession(key);
		Long count = questionService.countAllByPaperIdAndByIdNotInAndIsDel(paperId.toString(), questionids,0);
		
		if(count==0l&&questionids.size()<=1){
			return null;
		}else{
			questionids = new ArrayList<>();
			questionids.add(UUID.randomUUID().toString());
			count = questionService.countAllByPaperIdAndByIdNotInAndIsDel(paperId.toString(), questionids,0);
		}
		
		if(count==0){
			return null;
		}
		
		Random random = new Random();
		
		int index = random.nextInt(count.intValue());
		
		
		Pageable pageable = new PageRequest(index, 1);
		List<Question> questions = questionService.findAllByPaperIdAndByIdNotInAndIsDel(paperId.toString(),questionids,0,pageable);
		
		if(questions!=null&&questions.size()>0){
			return questions.get(0);
		}
		
		return null;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		List<String> questionids = (List<String>)sessionManager.rawGetBySession(key);
		if(questionids==null||questionids.size()==0){
			questionids = new ArrayList<>();
			questionids.add(UUID.randomUUID().toString());
		}
		sessionManager.rawSaveToSession(key, questionids);
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		return null;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager){
		try{
			Question question = (Question)sessionManager.getObject(Question.class);
			List<String> questionids = (List<String>)sessionManager.rawGetBySession(key);
			questionids.add(question.getId());
		}catch(Exception e){
			
		}
		
		return null;
	}

}

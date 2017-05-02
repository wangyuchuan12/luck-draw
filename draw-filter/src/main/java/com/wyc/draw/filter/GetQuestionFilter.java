package com.wyc.draw.filter;
import java.util.List;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.Question;

public class GetQuestionFilter extends Filter{

	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		Object paperId = sessionManager.getAttribute("paperId");
		Object questionId = sessionManager.getAttribute("questionId");
		
		Question question = (Question)sessionManager.findOne(Question.class,questionId.toString());
		
		if(!question.getPaperId().equals(paperId)){
			ResultVo resultVo = new ResultVo();
			resultVo.setSuccess(false);
			resultVo.setErrorMsg("该题目不属于该试卷");
			sessionManager.setReturn(true);
			sessionManager.setReturnValue(resultVo);
			return null;
		}
		
		return question;
	}
	
	@Override
	public List<Class<? extends Filter>> dependClasses() {
		// TODO Auto-generated method stub
		return null;
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

}

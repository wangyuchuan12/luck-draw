package com.wyc.draw.filter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.PaperAnswer;
import com.wyc.draw.service.PaperAnswerService;

public class CurrentPaperAnswerFilter extends Filter{

	@Autowired
	private PaperAnswerService paperAnswerService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		String paperId = (String)sessionManager.getAttribute("paperId");
		String keyId = (String)sessionManager.getAttribute("keyId");
		Integer type = (Integer)sessionManager.getAttribute("type");
		
		PaperAnswer paperAnswer = paperAnswerService.findOneByKeyIdAndPaperIdAndType(keyId,paperId,type);
		
		if(paperAnswer==null){
			paperAnswer = new PaperAnswer();
			paperAnswer.setKeyId(keyId);
			paperAnswer.setPaperId(paperId);
			paperAnswer.setRightCount(0);
			paperAnswer.setScore(0);
			paperAnswer.setTimeLong(0);
			paperAnswer.setWrongCount(0);
			paperAnswer.setStatus(Constant.PAPER_ANSWER_UNDERWAY_TAKEPART_STATUS);
			paperAnswer.setType(type);
			paperAnswer = paperAnswerService.add(paperAnswer);
		}
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
		// TODO Auto-generated method stub
		return null;
	}

}

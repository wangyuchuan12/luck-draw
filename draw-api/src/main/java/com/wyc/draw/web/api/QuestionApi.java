package com.wyc.draw.web.api;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.filter.controller.api.AnswerQuestionApiFilter;
import com.wyc.draw.filter.controller.api.RandomQuestionApiFilter;

@Controller
@RequestMapping(value="/api/draw/question/")
public class QuestionApi {
	
	
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

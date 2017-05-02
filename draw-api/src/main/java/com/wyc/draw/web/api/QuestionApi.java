package com.wyc.draw.web.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.draw.filter.controller.api.RandomQuestionApiFilter;

@Controller
@RequestMapping(value="/api/draw/question/")
public class QuestionApi {
	
	
	@RequestMapping(value="randomQuestionId")
	@HandlerAnnotation(hanlerFilter=RandomQuestionApiFilter.class)
	@ResponseBody
	public Object randomQuestionId(HttpServletRequest httpServletRequest){
		return null;
	}
}

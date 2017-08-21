package com.wyc.draw.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.draw.filter.BaseDrawActionFilter;

@Controller
@RequestMapping(value="/view/manager/")
public class ManagerController {
	
	@HandlerAnnotation(hanlerFilter=BaseDrawActionFilter.class)
	@RequestMapping(value="addQuestionBank")
	public String addQuestionBank(HttpServletRequest httpServletRequest)throws Exception{
		return "manager/addQuestionBank";
	}
	
	
	@HandlerAnnotation(hanlerFilter=BaseDrawActionFilter.class)
	@RequestMapping(value="addBattleModel")
	public String addBattleModel(HttpServletRequest httpServletRequest)throws Exception{
		return "manager/addBattleModel";
	}
	
	
	@HandlerAnnotation(hanlerFilter=BaseDrawActionFilter.class)
	@RequestMapping(value="addBattleModelStage")
	public String addBattleModelStage(HttpServletRequest httpServletRequest)throws Exception{
		return "manager/addBattleModelStage";
	}
	
	
	
	@HandlerAnnotation(hanlerFilter=BaseDrawActionFilter.class)
	@RequestMapping(value="addBattleModelStageIndex")
	public String addBattleModelStageIndex(HttpServletRequest httpServletRequest)throws Exception{
		return "manager/addBattleModelStageIndex";
	}
	
	@HandlerAnnotation(hanlerFilter=BaseDrawActionFilter.class)
	@RequestMapping(value="editQuestionModel")
	public String editQuestionModel(HttpServletRequest httpServletRequest)throws Exception{
		return "manager/editQuestionModel";
	}
	
	@HandlerAnnotation(hanlerFilter=BaseDrawActionFilter.class)
	@RequestMapping(value="questionList")
	public String questionList(HttpServletRequest httpServletRequest)throws Exception{
		return "manager/questionList";
	}
	
	
}

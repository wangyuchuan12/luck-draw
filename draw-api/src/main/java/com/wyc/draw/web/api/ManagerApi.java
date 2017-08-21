package com.wyc.draw.web.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.PaperSubject;
import com.wyc.draw.domain.QuestionBank;
import com.wyc.draw.filter.controller.api.AddBattleModelApiFilter;
import com.wyc.draw.filter.controller.api.AddQuestionBankApiFilter;
import com.wyc.draw.filter.controller.api.BattleCreaterByModelApiFilter;
import com.wyc.draw.filter.controller.api.UpdateQuestionBankApiFilter;
import com.wyc.draw.service.PaperSubjectService;
import com.wyc.draw.service.QuestionBankService;

@Controller
@RequestMapping(value="/api/manager/")
public class ManagerApi {
	
	@Autowired
	private PaperSubjectService paperSubjectService;
	
	@Autowired
	private QuestionBankService questionBankService;

	@Transactional
	@HandlerAnnotation(hanlerFilter=BattleCreaterByModelApiFilter.class)
	@ResponseBody
	@RequestMapping(value="createBattle")
	public Object createBattle(HttpServletRequest httpServletRequest)throws Exception{
		
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		ResultVo resultVo = sessionManager.getObject(ResultVo.class);
		return resultVo;
	}
	
	
	@Transactional
	@HandlerAnnotation(hanlerFilter=AddQuestionBankApiFilter.class)
	@RequestMapping(value="addQuestionBank")
	@ResponseBody
	public Object addQuestionBank(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		if(sessionManager.getObject(ResultVo.class)!=null){
			ResultVo resultVo = (ResultVo)sessionManager.getObject(ResultVo.class);
			return resultVo;
		}else{
			return sessionManager.getReturnValue();
		}
	}
	
	
	@Transactional
	@HandlerAnnotation(hanlerFilter=UpdateQuestionBankApiFilter.class)
	@RequestMapping(value="updateQuestionBank")
	@ResponseBody
	public Object updateQuestionBank(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		if(sessionManager.getObject(ResultVo.class)!=null){
			ResultVo resultVo = (ResultVo)sessionManager.getObject(ResultVo.class);
			return resultVo;
		}else{
			return sessionManager.getReturnValue();
		}
	}
	
	@Transactional
	@RequestMapping(value="subjects")
	@ResponseBody
	public Object getPaperSubjects(HttpServletRequest httpServletRequest)throws Exception{
		List<PaperSubject> paperSubjects = paperSubjectService.findAll();
		
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setData(paperSubjects);
		
		return resultVo;
	}
	
	
	@Transactional
	@RequestMapping(value="questionBanksByThemeCode")
	@ResponseBody
	public Object questionBanksByThemeCode(HttpServletRequest httpServletRequest)throws Exception{
		
		String themeCode = httpServletRequest.getParameter("themeCode");
		
		List<QuestionBank> questionBanks = questionBankService.findAllByThemeCode(themeCode);
		
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		
		resultVo.setData(questionBanks);
		
		return resultVo;
	}
	
	
	
	
	
	@Transactional
	@RequestMapping(value="addBattleModel")
	@HandlerAnnotation(hanlerFilter=AddBattleModelApiFilter.class)
	@ResponseBody
	public Object addBattleModel(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		if(sessionManager.getObject(ResultVo.class)!=null){
			ResultVo resultVo = (ResultVo)sessionManager.getObject(ResultVo.class);
			return resultVo;
		}else{
			return sessionManager.getReturnValue();
		}
	}
}

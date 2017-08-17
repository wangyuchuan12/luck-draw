package com.wyc.draw.filter.controller.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.QuestionBank;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.service.QuestionBankService;

public class UpdateQuestionBankApiFilter extends Filter{

	@Autowired
	private QuestionBankService questionBankService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		Integer isImg = (Integer)sessionManager.getAttribute("isImg");
		String imgUrl = (String)sessionManager.getAttribute("imgUrl");
		String question = (String)sessionManager.getAttribute("question");
		String answer = (String)sessionManager.getAttribute("answer");
		String fillWords = (String)sessionManager.getAttribute("fillWords");
		String wrongOptions = (String)sessionManager.getAttribute("wrongOptions");
		String rightOption = (String)sessionManager.getAttribute("rightOption");
		String instruction = (String)sessionManager.getAttribute("instruction");
		String themeCode = (String)sessionManager.getAttribute("thmeCode");
		String id = (String)sessionManager.getAttribute("id");
		
		QuestionBank questionBank = questionBankService.findOne(id);
		questionBank.setAnswer(answer);
		questionBank.setFillWords(fillWords);
		questionBank.setImgUrl(imgUrl);
		questionBank.setIsImg(isImg);
		questionBank.setQuestion(question);
		questionBank.setRightOption(rightOption);
		questionBank.setWrongOptions(wrongOptions);
		questionBank.setInstruction(instruction);
		questionBank.setThemeCode(themeCode);
		
		questionBankService.update(questionBank);
		
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setData(questionBank);
		return resultVo;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		HttpServletRequest httpServletRequest = sessionManager.getHttpServletRequest();
		String type = httpServletRequest.getParameter("type");
		String imgUrl = httpServletRequest.getParameter("imgUrl");
		String question = httpServletRequest.getParameter("question");
		String answer = httpServletRequest.getParameter("answer");
		String isImg = httpServletRequest.getParameter("isImg");
		
		String fillWords = httpServletRequest.getParameter("fillWords");
		
		String wrongOptions = httpServletRequest.getParameter("wrongOptions");
		
		String rightOption = httpServletRequest.getParameter("rightOption");
		
		String instruction = httpServletRequest.getParameter("instruction");
		
		String themeCode = httpServletRequest.getParameter("themeCode");
		
		String id = httpServletRequest.getParameter("id");
		
		sessionManager.setAttribute("type", Integer.parseInt(type));
		sessionManager.setAttribute("isImg", Integer.parseInt(isImg));
		sessionManager.setAttribute("imgUrl", imgUrl);
		sessionManager.setAttribute("question", question);
		sessionManager.setAttribute("answer", answer);
		sessionManager.setAttribute("fillWords", fillWords);
		sessionManager.setAttribute("wrongOptions", wrongOptions);
		sessionManager.setAttribute("rightOption", rightOption);
		sessionManager.setAttribute("instruction", instruction);
		sessionManager.setAttribute("themeCode", themeCode);
		sessionManager.setAttribute("id", id);
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> classes = new ArrayList<>();
		classes.add(BaseDrawActionFilter.class);
		return classes;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}

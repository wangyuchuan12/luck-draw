package com.wyc.draw.filter.controller.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.BattleModel;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.service.BattleModelService;

public class AddBattleModelApiFilter extends Filter{
	
	@Autowired
	private BattleModelService battleModelService;

	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		String code = (String)sessionManager.getAttribute("code");
		String imgUrl = (String)sessionManager.getAttribute("imgUrl");
		String instruction = (String)sessionManager.getAttribute("instruction");
		String name = (String)sessionManager.getAttribute("name");
		String title = (String)sessionManager.getAttribute("title");
		BattleModel battleModel = new BattleModel();
		battleModel.setCode(code);
		battleModel.setImgUrl(imgUrl);
		battleModel.setInstruction(instruction);
		battleModel.setIsEnable(0);
		battleModel.setName(name);
		battleModel.setTakepartCount(0);
		battleModel.setTitle(title);
		battleModel.setType(0);
		
		battleModelService.add(battleModel);
		
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setData(battleModel);
		return resultVo;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		HttpServletRequest httpServletRequest = sessionManager.getHttpServletRequest();
		String code = httpServletRequest.getParameter("code");
		String imgUrl = httpServletRequest.getParameter("imgUrl");
		String instruction = httpServletRequest.getParameter("instruction");
		String name = httpServletRequest.getParameter("name");
		String title = httpServletRequest.getParameter("title");
		
		sessionManager.setAttribute("code", code);
		sessionManager.setAttribute("imgUrl",imgUrl);
		sessionManager.setAttribute("instruction", instruction);
		sessionManager.setAttribute("name", name);
		sessionManager.setAttribute("title", title);
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		List<Class<? extends Filter>> filerClasses = new ArrayList<>();
		
		filerClasses.add(BaseDrawActionFilter.class);
		return filerClasses;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}

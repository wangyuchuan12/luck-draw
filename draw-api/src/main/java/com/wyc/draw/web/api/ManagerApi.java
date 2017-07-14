package com.wyc.draw.web.api;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.filter.controller.api.BattleCreaterByModelApiFilter;

@Controller
@RequestMapping(value="/api/manager/")
public class ManagerApi {

	@Transactional
	@HandlerAnnotation(hanlerFilter=BattleCreaterByModelApiFilter.class)
	@ResponseBody
	@RequestMapping(value="createBattle")
	public Object createBattle(HttpServletRequest httpServletRequest)throws Exception{
		
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		ResultVo resultVo = sessionManager.getObject(ResultVo.class);
		return resultVo;
	}
}

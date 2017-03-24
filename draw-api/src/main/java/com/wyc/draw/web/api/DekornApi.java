package com.wyc.draw.web.api;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.filter.controller.api.DekornTakepartApiFilter;

@Controller
@RequestMapping(value="/api/dekorn/")
public class DekornApi {
	
	
	
	@RequestMapping(value="takepart")
	@Transactional
	@ResponseBody
	@HandlerAnnotation(hanlerFilter=DekornTakepartApiFilter.class)
	public Object takepart(HttpServletRequest httpServletRequest)throws Exception{
		
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		if(sessionManager.getObject(ResultVo.class)!=null){
			return sessionManager.getObject(ResultVo.class);
		}else{
			return sessionManager.getReturnValue();
		}
	}
}

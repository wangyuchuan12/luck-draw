package com.wyc.draw.web.api;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.filter.controller.api.CreateDekornApiFilter;
import com.wyc.draw.filter.controller.api.DekornActiveApiFilter;
import com.wyc.draw.filter.controller.api.DekornTakepartApiFilter;
import com.wyc.draw.filter.controller.api.PutUpRingAgreeApiFilter;
import com.wyc.draw.filter.controller.api.PutUpRingRejectApiFilter;
import com.wyc.draw.filter.controller.api.SubmitScoreApiFilter;

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
	
	@Transactional
	@RequestMapping(value="rejectPutUpRing")
	@ResponseBody
	@HandlerAnnotation(hanlerFilter=PutUpRingRejectApiFilter.class)
	public Object rejectPutUpRing(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		if(sessionManager.getObject(ResultVo.class)!=null){
			return sessionManager.getObject(ResultVo.class);
		}else{
			return sessionManager.getReturnValue();
		}
	}
	
	@Transactional
	@RequestMapping(value="agreePutUpRing")
	@ResponseBody
	@HandlerAnnotation(hanlerFilter=PutUpRingAgreeApiFilter.class)
	public Object agreePutUpRing(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		if(sessionManager.getObject(ResultVo.class)!=null){
			return sessionManager.getObject(ResultVo.class);
		}else{
			return sessionManager.getReturnValue();
		}
	}
	

	@RequestMapping(value="submit_score")
	@HandlerAnnotation(hanlerFilter=SubmitScoreApiFilter.class)
	@Transactional
	@ResponseBody
	public Object submitScore(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		if(sessionManager.getObject(ResultVo.class)!=null){
			return sessionManager.getObject(ResultVo.class);
		}else{
			return sessionManager.getReturnValue();
		}
	}
	
	@RequestMapping(value="create_dekorn")
	@HandlerAnnotation(hanlerFilter=CreateDekornApiFilter.class)
	@Transactional
	@ResponseBody
	public Object createDekorn(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		if(sessionManager.getObject(ResultVo.class)!=null){
			return sessionManager.getObject(ResultVo.class);
		}else{
			return sessionManager.getReturnValue();
		}
	}
	
	@RequestMapping(value="active")
	@HandlerAnnotation(hanlerFilter=DekornActiveApiFilter.class)
	@Transactional
	@ResponseBody
	public Object active(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		if(sessionManager.getObject(ResultVo.class)!=null){
			return sessionManager.getObject(ResultVo.class);
		}else{
			return sessionManager.getReturnValue();
		}
	}
}

package com.wyc.draw.web.api;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.filter.controller.api.BattleInfoApiFilter;
import com.wyc.draw.filter.controller.api.BattleListApiFilter;
import com.wyc.draw.filter.controller.api.BattleMemberInfoApiFilter;
import com.wyc.draw.filter.controller.api.BattleMemberStageListApiFilter;
import com.wyc.draw.filter.controller.api.BattleSetCurrentStageApiFilter;
import com.wyc.draw.filter.controller.api.BattleStageListApiFilter;
import com.wyc.draw.filter.controller.api.BattleStageTakepartApiFilter;
import com.wyc.draw.filter.controller.api.BattleSubmitResultApiFilter;
import com.wyc.draw.filter.controller.api.BattleTakepartApiFilter;
import com.wyc.draw.filter.controller.api.CurrentPropApiFilter;
import com.wyc.draw.filter.controller.api.CurrentPropBeanApiFilter;
import com.wyc.draw.filter.controller.api.CurrentPropLoveApiFilter;
import com.wyc.draw.filter.controller.api.PaperSubjectApiFilter;
import com.wyc.draw.filter.controller.api.ProgressApiFilter;
import com.wyc.draw.filter.controller.api.PropReceiveBeanApiFilter;
import com.wyc.draw.filter.controller.api.PropReceiveLoveApiFilter;
import com.wyc.draw.filter.controller.api.PropReceiveRandomApiFilter;

@Controller
@RequestMapping(value="/api/main/")
public class MainApi {

	@Transactional
	@HandlerAnnotation(hanlerFilter=CurrentPropLoveApiFilter.class)
	@ResponseBody
	@RequestMapping(value="propLoveInfo")
	public Object propLoveInfo(HttpServletRequest httpServletRequest)throws Exception{
		
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		ResultVo resultVo = sessionManager.getObject(ResultVo.class);
		return resultVo;
	}
	
	@Transactional
	@HandlerAnnotation(hanlerFilter=CurrentPropBeanApiFilter.class)
	@ResponseBody
	@RequestMapping(value="propBeanInfo")
	public Object propBeanInfo(HttpServletRequest httpServletRequest)throws Exception{
		
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		
		ResultVo resultVo = sessionManager.getObject(ResultVo.class);
		return resultVo;
	}
	
	@Transactional
	@HandlerAnnotation(hanlerFilter=PaperSubjectApiFilter.class)
	@ResponseBody
	@RequestMapping(value="paperSubject")
	public Object paperSubject(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		ResultVo resultVo = sessionManager.getObject(ResultVo.class);
		return resultVo;
	}
	
	@Transactional
	@HandlerAnnotation(hanlerFilter=CurrentPropApiFilter.class)
	@ResponseBody
	@RequestMapping(value="propInfo")
	public Object propInfo(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		ResultVo resultVo = sessionManager.getObject(ResultVo.class);
		return resultVo;
	}
	
	
	@HandlerAnnotation(hanlerFilter=PropReceiveLoveApiFilter.class)
	@ResponseBody
	@Transactional
	@RequestMapping(value="receiveLove")
	public Object receiveLove(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		ResultVo resultVo = sessionManager.getObject(ResultVo.class);
		return resultVo;
	}
	
	@HandlerAnnotation(hanlerFilter=PropReceiveBeanApiFilter.class)
	@ResponseBody
	@Transactional
	@RequestMapping(value="receiveBean")
	public Object receiveBean(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		ResultVo resultVo = sessionManager.getObject(ResultVo.class);
		return resultVo;
	}
	
	@HandlerAnnotation(hanlerFilter=PropReceiveRandomApiFilter.class)
	@ResponseBody
	@Transactional
	@RequestMapping(value="receiveRandom")
	public Object receiveRandom(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		ResultVo resultVo = sessionManager.getObject(ResultVo.class);
		return resultVo;
	}
	
	@HandlerAnnotation(hanlerFilter=BattleInfoApiFilter.class)
	@ResponseBody
	@Transactional
	@RequestMapping(value="battleInfo")
	public Object battleInfo(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		ResultVo resultVo = sessionManager.getObject(ResultVo.class);
		return resultVo;
	}
	
	
	@HandlerAnnotation(hanlerFilter=BattleListApiFilter.class)
	@ResponseBody
	@Transactional
	@RequestMapping(value="battleList")
	public Object battleList(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		ResultVo resultVo = sessionManager.getObject(ResultVo.class);
		return resultVo;
	}
	
	@HandlerAnnotation(hanlerFilter=BattleTakepartApiFilter.class)
	@ResponseBody
	@Transactional
	@RequestMapping(value="battleTakepart")
	public Object battleTakepart(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		ResultVo resultVo = sessionManager.getObject(ResultVo.class);
		return resultVo;
	}
	
	
	@HandlerAnnotation(hanlerFilter=BattleStageTakepartApiFilter.class)
	@ResponseBody
	@Transactional
	@RequestMapping(value="stageTakepart")
	public Object stageTakepart(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		if(sessionManager.isReturn()){
			ResultVo resultVo = (ResultVo)sessionManager.getReturnValue();
			return resultVo;
		}else{
			ResultVo resultVo = (ResultVo)sessionManager.getObject(ResultVo.class);
			return resultVo;
		}
	}
	
	
	@HandlerAnnotation(hanlerFilter=BattleSetCurrentStageApiFilter.class)
	@ResponseBody
	@Transactional
	@RequestMapping(value="setCurrentStage")
	public Object setCurrentStage(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		if(sessionManager.isReturn()){
			ResultVo resultVo = (ResultVo)sessionManager.getReturnValue();
			return resultVo;
		}else{
			ResultVo resultVo = (ResultVo)sessionManager.getObject(ResultVo.class);
			return resultVo;
		}
	}
	
	@Transactional
	@ResponseBody
	@HandlerAnnotation(hanlerFilter=BattleMemberInfoApiFilter.class)
	@RequestMapping(value="battleMemberInfo")
	public Object testBattleMemberInfoApiFilter(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		ResultVo resultVo = sessionManager.getObject(ResultVo.class);
		return resultVo;
	}
	
	@Transactional
	@ResponseBody
	@HandlerAnnotation(hanlerFilter=ProgressApiFilter.class)
	@RequestMapping(value="progressInfo")
	public Object progressInfo(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		ResultVo resultVo = sessionManager.getObject(ResultVo.class);
		return resultVo;
	}
	
	@Transactional
	@ResponseBody
	@HandlerAnnotation(hanlerFilter=BattleStageListApiFilter.class)
	@RequestMapping(value="battleStages")
	public Object battleStages(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		ResultVo resultVo = sessionManager.getObject(ResultVo.class);
		return resultVo;
	}
	
	@Transactional
	@ResponseBody
	@HandlerAnnotation(hanlerFilter=BattleMemberStageListApiFilter.class)
	@RequestMapping(value="battleMemberStages")
	public Object battleMemberStages(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		ResultVo resultVo = sessionManager.getObject(ResultVo.class);
		return resultVo;
	}
	
	@ResponseBody
	@Transactional
	@HandlerAnnotation(hanlerFilter=BattleSubmitResultApiFilter.class)
	@RequestMapping(value="submitResult")
	public Object submitResult(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		if(sessionManager.isReturn()){
			ResultVo resultVo = (ResultVo)sessionManager.getReturnValue();
			return resultVo;
		}else{
			ResultVo resultVo = (ResultVo)sessionManager.getObject(ResultVo.class);
			return resultVo;
		}
	}
	
}

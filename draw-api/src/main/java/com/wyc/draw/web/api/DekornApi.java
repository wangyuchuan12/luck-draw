package com.wyc.draw.web.api;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyc.annotation.HandlerAnnotation;
import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.DekornToTakepartMember;
import com.wyc.draw.filter.controller.action.GameDekornInfoActionFilter;
import com.wyc.draw.filter.controller.api.CreateDekornApiFilter;
import com.wyc.draw.filter.controller.api.DekornActiveApiFilter;
import com.wyc.draw.filter.controller.api.DekornTakepartApiFilter;
import com.wyc.draw.filter.controller.api.DekornTakepartMemberListApiFilter;
import com.wyc.draw.filter.controller.api.PutUpRingAgreeApiFilter;
import com.wyc.draw.filter.controller.api.PutUpRingRejectApiFilter;
import com.wyc.draw.filter.controller.api.SubmitScoreApiFilter;
import com.wyc.draw.vo.DekornVo;

@Controller
@RequestMapping(value="/api/dekorn/")
public class DekornApi {
	
	
	@RequestMapping(value="takepartMembers")
	@Transactional
	@ResponseBody
	@HandlerAnnotation(hanlerFilter=DekornTakepartMemberListApiFilter.class)
	public Object takepartMembers(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		if(sessionManager.getObject(ResultVo.class)!=null){
			ResultVo resultVo = (ResultVo)sessionManager.getObject(ResultVo.class);
			return resultVo;
		}else{
			return sessionManager.getReturnValue();
		}
	}
	
	@RequestMapping(value="info")
	@Transactional
	@ResponseBody
	@HandlerAnnotation(hanlerFilter=GameDekornInfoActionFilter.class)
	public Object info(HttpServletRequest httpServletRequest)throws Exception{
		SessionManager sessionManager = SessionManager.getFilterManager(httpServletRequest);
		DekornVo dekornVo = (DekornVo)sessionManager.getObject(DekornVo.class);
		DekornToTakepartMember dekornToTakepartMember = (DekornToTakepartMember)sessionManager.getObject(DekornToTakepartMember.class);
		Map<String, Object> data = new HashMap<String, Object>();
		
		data.put("adminId", dekornToTakepartMember.getAdminId());
		data.put("averageScore", dekornToTakepartMember.getAverageScore());
		data.put("currentTakepartMemberId", dekornToTakepartMember.getCurrentTakepartMemberId());
		data.put("dekornId", dekornToTakepartMember.getDekornId());
		data.put("highestScore", dekornToTakepartMember.getHighestScore());
		data.put("loveLifeCount", dekornToTakepartMember.getLoveLifeCount());
		data.put("obtainIntegralNum", dekornToTakepartMember.getObtainIntegralNum());
		data.put("obtainWisdomNum", dekornToTakepartMember.getObtainWisdomNum());
		data.put("opernid", dekornToTakepartMember.getOpernid());
		data.put("residueLifeLove", dekornToTakepartMember.getResidueLifeLove());
		data.put("takepartCount", dekornToTakepartMember.getTakepartCount());
		data.put("takepartFailCount", dekornToTakepartMember.getTakepartFailCount());
		data.put("takepartStatus", dekornToTakepartMember.getTakepartStatus());
		data.put("takepartSuccessCount", dekornToTakepartMember.getTakepartSuccessCount());
		data.put("visitCount", dekornToTakepartMember.getVisitCount());
		
		
		data.put("gameId", dekornVo.getGameId());
		data.put("gameName", dekornVo.getGameName());
		data.put("gameUrl", dekornVo.getGameUrl());
		data.put("handDrawUserId", dekornVo.getHandDrawUserId());
		data.put("handDrawUserImg", dekornVo.getHandDrawUserImg());
		data.put("handDrawUserName", dekornVo.getHandDrawUserName());
		data.put("id", dekornVo.getId());
		data.put("itemImg", dekornVo.getItemImg());
		data.put("acceptFightFailIntegralNum", dekornVo.getAcceptFightFailIntegralNum());
		data.put("acceptFightFailWisdomNum", dekornVo.getAcceptFightFailWisdomNum());
		data.put("acceptFightSuccessIntegralNum", dekornVo.getAcceptFightSuccessIntegralNum());
		data.put("acceptFightSuccessWisdomNum", dekornVo.getAcceptFightSuccessWisdomNum());
		data.put("averageScore", dekornVo.getAverageScore());
		data.put("fightFailIntegralNum", dekornVo.getFightFailIntegralNum());
		data.put("fightFailWisdomNum", dekornVo.getFightFailWisdomNum());
		data.put("fightSuccessIntegralNum", dekornVo.getFightSuccessIntegralNum());
		data.put("fightSuccessWisdomNum", dekornVo.getFightSuccessWisdomNum());
		
		data.put("highestScore", dekornVo.getHighestScore());
		data.put("passScore", dekornVo.getPassScore());
		
		data.put("praiseIntegralNum", dekornVo.getPraiseIntegralNum());
		data.put("praiseWisdomNum", dekornVo.getPraiseWisdomNum());
		
		data.put("takepartCount", dekornVo.getTakepartCount());

		
		data.put("takepartFailCount", dekornVo.getTakepartFailCount());

		
		data.put("takepartSuccessCount", dekornVo.getTakepartSuccessCount());

		
		data.put("type", dekornVo.getType());
		
		data.put("paperId", dekornVo.getPaperId());
		
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		resultVo.setData(data);

		return resultVo;

	}
	
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

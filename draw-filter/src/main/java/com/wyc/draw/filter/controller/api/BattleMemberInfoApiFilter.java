package com.wyc.draw.filter.controller.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.domain.vo.ResultVo;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.CommonUtil;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.BattleMember;
import com.wyc.draw.domain.BattleMemberStage;
import com.wyc.draw.domain.BattleStage;
import com.wyc.draw.domain.BattleToMember;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.CurrentBattleMemberFilter;
import com.wyc.draw.service.BattleMemberService;
import com.wyc.draw.service.BattleMemberStageService;
import com.wyc.draw.service.BattleStageService;

public class BattleMemberInfoApiFilter extends Filter{

	@Autowired
	private BattleMemberService battleMemberService;
	
	
	@Autowired
	private BattleStageService battleStageService;
	
	@Autowired
	private BattleMemberStageService battleMemberStageService;
	
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		BattleToMember battleToMember = sessionManager.getObject(BattleToMember.class);
		
		BattleMember battleMember = (BattleMember)sessionManager.getObject(BattleMember.class);
		
		ResultVo resultVo = new ResultVo();
		resultVo.setSuccess(true);
		Map<String, Object> data = new HashMap<>();
		data.put("status", battleToMember.getStatus());
		data.put("loveLife", battleMember.getLoveLife());
		
		data.put("loveLifeLimit", battleMember.getLoveLifeLimit());
		
		data.put("battleId", battleMember.getBattleId());
		
		data.put("allScore", battleMember.getScore());
		
		data.put("currentStageIndex", battleMember.getCurrentStageIndex());
		
		data.put("index", battleMember.getCurrentIndex());
		
		data.put("currentStageScore", battleMember.getCurrentStageScore());
		
		data.put("memberId", battleMember.getId());
		
		data.put("stageIndexCount", battleMember.getStageIndexCount());
		
		
		Long rank = battleMemberService.rank(battleMember);
		
		data.put("rank", rank);
			
		BattleMemberStage battleMemberStage = battleMemberStageService.findOneByMemberIdAndBattleIdAndStageIndexAndIsDel(battleMember.getId(),battleMember.getBattleId(),battleMember.getCurrentStageIndex(),0);
		BattleStage battleStage = battleStageService.findOneByBattleIdAndStageIndex(battleMember.getBattleId(), battleMember.getCurrentStageIndex());

		data.put("passScore", battleStage.getPassScore());
		data.put("passScore2", battleStage.getPassScore2());
		data.put("passScore3", battleStage.getPassScore3());
		data.put("passScore4", battleStage.getPassScore4());
		if(battleMemberStage!=null){
			data.put("rewardBeanNum", battleMemberStage.getRewardBeanNum());
			data.put("thisScore", battleMemberStage.getScore());
			data.put("stageStatus", battleMemberStage.getStatus());
			data.put("paperId", battleMemberStage.getPaperId());
			data.put("isPass", battleMemberStage.getIsPass());
			data.put("imgUrl", battleMemberStage.getImgUrl());
			data.put("name", battleMemberStage.getName());
			data.put("isReadResult", battleMemberStage.getIsReadResult());
		}else{
			data.put("rewardBeanNum", 0);
			data.put("thisScore", 0);
			data.put("stageStatus", Constant.BM_STATUS_FREE);
			data.put("paperId", battleStage.getPaperId());
			data.put("imgUrl", battleStage.getImgUrl());
			data.put("name", battleStage.getName());
			data.put("isReadResult", 0);
		}
		
		resultVo.setData(data);
		return resultVo;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		HttpServletRequest httpServletRequest = sessionManager.getHttpServletRequest();
		String battleId = httpServletRequest.getParameter("battleId");
		
		sessionManager.setAttribute("battleId", battleId);
		
		if(CommonUtil.isEmpty(battleId)){
			sessionManager.setReturn(true);
		}
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		
		List<Class<? extends Filter>> classes = new ArrayList<>();
		classes.add(BaseDrawActionFilter.class);
		classes.add(CurrentBattleMemberFilter.class);
		return classes;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}

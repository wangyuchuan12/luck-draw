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
import com.wyc.draw.domain.BattleStageIndexDetail;
import com.wyc.draw.domain.BattleToMember;
import com.wyc.draw.filter.BaseDrawActionFilter;
import com.wyc.draw.filter.CurrentBattleMemberFilter;
import com.wyc.draw.service.BattleMemberService;
import com.wyc.draw.service.BattleMemberStageIndexService;
import com.wyc.draw.service.BattleMemberStageService;
import com.wyc.draw.service.BattleStageIndexDetailService;

public class BattleMemberInfoApiFilter extends Filter{

	@Autowired
	private BattleMemberService battleMemberService;
	
	@Autowired
	private BattleStageIndexDetailService battleStageIndexDetailService;
	
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
		
		Long rank = battleMemberService.rank(battleMember);
		
		data.put("rank", rank);
		
		BattleMemberStage battleMemberStage = battleMemberStageService.findOneByBattleIdAndStageIndexAndStatus(battleMember.getBattleId(),battleMember.getCurrentStageIndex(),Constant.BM_STATUS_END);
		
		if(battleMemberStage!=null){
			data.put("rewardBeanNum", battleMemberStage.getRewardBeanNum());
			data.put("thisScore", battleMemberStage.getScore());
		}else{
			BattleStageIndexDetail battleStageIndexDetail = battleStageIndexDetailService.findOneByBattleIdAndStageIndex(battleMember.getBattleId(),battleMember.getCurrentStageIndex());
			if(battleStageIndexDetail!=null){
				data.put("rewardBeanNum", battleStageIndexDetail.getRewardBeanNum());
				data.put("thisScore", 0);
			}else{
				data.put("rewardBeanNum", 0);
				data.put("thisScore", 0);
			}
			
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

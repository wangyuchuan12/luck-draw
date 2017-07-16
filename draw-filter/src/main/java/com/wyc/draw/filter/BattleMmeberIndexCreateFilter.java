package com.wyc.draw.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.BattleMemberIndex;
import com.wyc.draw.domain.BattleMemberStage;
import com.wyc.draw.domain.BattleStageIndexDetail;
import com.wyc.draw.service.BattleMemberStageIndexService;
import com.wyc.draw.service.BattleMemberStageService;
import com.wyc.draw.service.BattleStageIndexDetailService;

public class BattleMmeberIndexCreateFilter extends Filter{

	
	@Autowired
	private BattleStageIndexDetailService battleStageIndexDetailService;
	
	@Autowired
	private BattleMemberStageService battleMemberStageService;
	
	@Autowired
	private BattleMemberStageIndexService battleMemberStageIndexService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		List<Integer> stageIndexes = (List<Integer>)sessionManager.getAttribute("stageIndexes");
		String battleId = (String)sessionManager.getAttribute("battleId");
		

		List<BattleMemberStage> battleMemberStages = battleMemberStageService.findAllByBattleIdAndIsDelAndStageIndexIn(battleId, 0, stageIndexes);
		
		List<BattleStageIndexDetail> battleStageIndexDetails = battleStageIndexDetailService.findAllByBattleIdAndIsDelAndStageIndexIn(battleId, 0, stageIndexes);
		
		Map<Integer, List<BattleStageIndexDetail>> battleStageIndexDetailMap = new HashMap<>();
		
		for(BattleStageIndexDetail battleStageIndexDetail:battleStageIndexDetails){
			List<BattleStageIndexDetail> thisBattleStageIndexDetails = battleStageIndexDetailMap.get(battleStageIndexDetail.getStageindex());
			if(thisBattleStageIndexDetails==null){
				thisBattleStageIndexDetails = new ArrayList<>();
				battleStageIndexDetailMap.put(battleStageIndexDetail.getStageindex(), thisBattleStageIndexDetails);
			}
			thisBattleStageIndexDetails.add(battleStageIndexDetail);
		}

		for(BattleMemberStage battleMemberStage:battleMemberStages){
			if(battleMemberStage.getIsSyncIndex()==null||battleMemberStage.getIsSyncIndex()==0){
				List<BattleStageIndexDetail> thisDetails = battleStageIndexDetailMap.get(battleMemberStage.getStageIndex());
				if(thisDetails!=null){
					for(BattleStageIndexDetail battleStageIndexDetail:thisDetails){
						BattleMemberIndex battleMemberIndex = new BattleMemberIndex();
						battleMemberIndex.setBattleId(battleStageIndexDetail.getBattleId());
						battleMemberIndex.setIconUrl(battleStageIndexDetail.getIconUrl());
						battleMemberIndex.setIndex(battleStageIndexDetail.getIndex());
						battleMemberIndex.setIsGuide(battleStageIndexDetail.getIsGuide());
						battleMemberIndex.setIsRight(0);
						battleMemberIndex.setMemberId(battleMemberStage.getMemberId());
						battleMemberIndex.setIsDel(0);
						battleMemberIndex.setQuestionId(battleStageIndexDetail.getQuestionId());
						battleMemberIndex.setRewardBeanNum(battleStageIndexDetail.getRewardBeanNum());
						battleMemberIndex.setScore(battleStageIndexDetail.getScore());
						battleMemberIndex.setStageIndex(battleStageIndexDetail.getStageindex());
						battleMemberIndex.setStatus(Constant.BM_STATUS_FREE);
						battleMemberIndex.setToHide(battleStageIndexDetail.getToHide());
						
						battleMemberStageIndexService.add(battleMemberIndex);
					}
				}
				battleMemberStage.setIsSyncIndex(1);
				battleMemberStageService.update(battleMemberStage);
				
			}else{
				
			}
		}
		
		return null;
	}

	@Override
	public Object handlerPre(SessionManager sessionManager) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Class<? extends Filter>> dependClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object handlerAfter(SessionManager sessionManager) {
		// TODO Auto-generated method stub
		return null;
	}

}

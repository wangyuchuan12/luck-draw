package com.wyc.draw.filter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.BattleMember;
import com.wyc.draw.domain.BattleMemberStage;
import com.wyc.draw.domain.BattleStage;
import com.wyc.draw.service.BattleMemberStageService;
import com.wyc.draw.service.BattleStageService;
import com.wyc.draw.vo.BattleMemberStageListVo;

public class BattleMemberStageCreateFilter extends Filter{

	@Autowired
	private BattleMemberStageService battleMemberStageService;
	
	@Autowired
	private BattleStageService battleStageService;
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		
		BattleMember battleMember = sessionManager.getObject(BattleMember.class);
		String battleId = sessionManager.getAttribute("battleId").toString();
		String stageIndexes = sessionManager.getAttribute("stageIndexes").toString();
		
		String[] stageIndexArray = stageIndexes.split(",");
		
		List<Integer> stageIndexArrayList = new ArrayList<>();
		
		for(String stageIndex:stageIndexArray){
			stageIndexArrayList.add(Integer.parseInt(stageIndex));
		}
		
		List<BattleStage> battleStages = battleStageService.findAllByBattleIdAndIsDelAndStageIndexIn(battleId,0,stageIndexArrayList);
		List<BattleMemberStage> battleMemberStages = battleMemberStageService.findAllByBattleIdAndIsDelAndStageIndexIn(battleId,0,stageIndexArrayList);
		
		for(BattleMemberStage battleMemberStage:battleMemberStages){
			battleMemberStage.setIsDel(1);
			battleMemberStageService.update(battleMemberStage);
		}
		
		List<BattleMemberStage> returnBattleMemberStages = new ArrayList<>();
		for(BattleStage battleStage:battleStages){
			BattleMemberStage battleMemberStage = new BattleMemberStage();
			battleMemberStage.setBattleId(battleStage.getBattleId());
			battleMemberStage.setCurrentIndex(0);
			battleMemberStage.setIsDel(0);
			battleMemberStage.setMemberId(battleMember.getId());
			battleMemberStage.setRewardBeanNum(battleMember.getRewardBeanNum());
			battleMemberStage.setStatus(Constant.BM_STATUS_FREE);
			battleMemberStage.setScore(0);
			battleMemberStage.setStageIndex(battleStage.getStageIndex());
			battleMemberStage.setPaperId(battleStage.getPaperId());
			battleMemberStage.setPassScore(battleStage.getPassScore());
			battleMemberStage.setPassScore2(battleStage.getPassScore2());
			battleMemberStage.setPassScore3(battleStage.getPassScore3());
			battleMemberStage.setPassScore4(battleStage.getPassScore4());
			battleMemberStageService.add(battleMemberStage);
			returnBattleMemberStages.add(battleMemberStage);
			
		}
		
		BattleMemberStageListVo battleMemberStageListVo = new BattleMemberStageListVo();
		battleMemberStageListVo.setBattleMemberStages(returnBattleMemberStages);
		return battleMemberStageListVo;
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

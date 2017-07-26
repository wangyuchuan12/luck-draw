package com.wyc.draw.filter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.draw.domain.BattleMember;
import com.wyc.draw.domain.BattleMemberIndex;
import com.wyc.draw.service.BattleMemberStageIndexService;
import com.wyc.draw.vo.BattleIndexVo;
import com.wyc.draw.vo.BattleProgressInfoVo;
import com.wyc.draw.vo.BattleStageVo;

public class ProgressFilter extends Filter{
	@Autowired
	private BattleMemberStageIndexService battleMemberStageIndexService;
	
	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		
		BattleMember battleMember = sessionManager.getObject(BattleMember.class);
		
		List<Integer> stageIndexs = (List<Integer>)sessionManager.getAttribute("stageIndexs");

		BattleProgressInfoVo battleProgressInfoVo = new BattleProgressInfoVo();
		battleProgressInfoVo.setLoveLife(battleMember.getLoveLife());
		battleProgressInfoVo.setLoveLifeLimit(battleMember.getLoveLifeLimit());
		battleProgressInfoVo.setScore(battleMember.getScore());
		battleProgressInfoVo.setStageIndex(battleMember.getCurrentStageIndex());
		battleProgressInfoVo.setStatus(battleMember.getStatus());
		
		List<BattleStageVo> battleStageVos = new ArrayList<>();
		battleProgressInfoVo.setBattleStageVos(battleStageVos);
		
		for(Integer stageIndex:stageIndexs){
			
			List<BattleMemberIndex> battleMemberIndexs = battleMemberStageIndexService.
					findAllByBattleIdAndMemberIdAndStageIndexAndIsDelOrderByIndexAsc(battleMember.getBattleId(),battleMember.getId(),stageIndex,0);
			List<BattleIndexVo> battleIndexVos = new ArrayList<>();
			BattleStageVo battleStageVo = new BattleStageVo();
			battleStageVos.add(battleStageVo);
			battleStageVo.setBattleIndexVos(battleIndexVos);
			battleStageVo.setStageIndex(stageIndex);
			battleStageVo.setId(stageIndex+"");
			for(BattleMemberIndex battleMemberIndex:battleMemberIndexs){
				BattleIndexVo battleIndexVo = new BattleIndexVo();
				battleIndexVo.setId(battleMemberIndex.getId());
				battleIndexVo.setIndex(battleMemberIndex.getIndex());
				battleIndexVo.setIsRight(battleMemberIndex.getIsRight());
				battleIndexVo.setRewardBeanNum(battleMemberIndex.getRewardBeanNum());
				battleIndexVo.setScore(battleMemberIndex.getScore());
				battleIndexVo.setStatus(battleMemberIndex.getStatus());
				battleIndexVo.setIconUrl(battleMemberIndex.getIconUrl());
				battleIndexVo.setToHide(battleMemberIndex.getToHide());
				battleIndexVo.setIsGuide(battleMemberIndex.getIsGuide());
				battleIndexVos.add(battleIndexVo);
			}
			
		}
		
		return battleProgressInfoVo;
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

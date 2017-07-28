package com.wyc.draw.filter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.wyc.common.filter.Filter;
import com.wyc.common.session.SessionManager;
import com.wyc.common.util.Constant;
import com.wyc.draw.domain.Battle;
import com.wyc.draw.domain.BattleMember;
import com.wyc.draw.domain.BattleReward;
import com.wyc.draw.service.BattleMemberService;
import com.wyc.draw.service.BattleRewardService;
import com.wyc.draw.vo.BattleRewardListVo;

public class BattleReceiveRewardsFilter extends Filter{

	@Autowired
	private BattleMemberService battleMemberService;
	
	@Autowired
	private BattleRewardService battleRewardService;

	@Override
	public Object handlerFilter(SessionManager sessionManager) throws Exception {
		String battleId = (String)sessionManager.getAttribute("battleId");
		
		Battle battle = sessionManager.findOne(Battle.class, battleId);
		
		Sort rewardSort = new Sort(Direction.ASC,"rank");
		Pageable rewardPageable = new PageRequest(0, 10, rewardSort);
	
		List<BattleReward> battleRewards = battleRewardService.findAllByBattleId(battleId,rewardPageable);
		
		if(battle.getStatus()==Constant.BATTLE_STATUS_TIMEOUT||battle.getStatus()==Constant.BATTLE_STATUS_SUCCESS){
			Sort sort = new Sort(Direction.DESC,"score");
			
			Pageable pageable = new PageRequest(0, 10, sort);
			
			List<BattleMember> battleMembers = battleMemberService.findAllByBattleId(battleId, pageable);

			Map<Integer, BattleReward> battleRewardMap = new HashMap<>();
			for(BattleReward battleReward:battleRewards){
				battleRewardMap.put(battleReward.getRank(), battleReward);
			}
			
			Integer rank = 1;
			for(BattleMember battleMember:battleMembers){
				BattleReward battleReward = battleRewardMap.get(rank);
				if(battleReward!=null){
					//表示未分配
					if(battleReward.getStatus()==Constant.BATTLE_REWARD_STATUS_FRESS){
						battleReward.setStatus(Constant.BATTLE_REWARD_STATUS_IN);
						battleReward.setReceiveMemberId(battleMember.getId());
						battleReward.setReceiveNickname(battleMember.getNickname());
						battleReward.setReceiveHeadImg(battleMember.getHeadImg());
						sessionManager.update(battleReward);
					}
				}else{
					
				}
				
				rank++;
				
			}
		}
		
		BattleRewardListVo battleRewardListVo = new BattleRewardListVo();
		
		battleRewardListVo.setBattleRewardList(battleRewards);
		
		return battleRewardListVo;
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

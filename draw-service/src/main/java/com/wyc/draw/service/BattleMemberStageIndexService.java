package com.wyc.draw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.BattleMemberIndex;
import com.wyc.draw.repositories.BattleMemberStageIndexRepository;

@Service
public class BattleMemberStageIndexService {

	@Autowired
	private BattleMemberStageIndexRepository battleMemberStageIndexRepository;

	public List<BattleMemberIndex> findAllByBattleIdAndMemberIdAndStageIndexOrderByIndexAsc(String battleId, String memberId,
			Integer stageIndex) {
		return battleMemberStageIndexRepository.findAllByBattleIdAndMemberIdAndStageIndexOrderByIndexAsc(battleId,memberId,stageIndex);
	}
}

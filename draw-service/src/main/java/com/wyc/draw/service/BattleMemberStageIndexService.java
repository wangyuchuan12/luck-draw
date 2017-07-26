package com.wyc.draw.service;

import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.BattleMemberIndex;
import com.wyc.draw.repositories.BattleMemberStageIndexRepository;

@Service
public class BattleMemberStageIndexService {

	@Autowired
	private BattleMemberStageIndexRepository battleMemberStageIndexRepository;

	public List<BattleMemberIndex> findAllByBattleIdAndMemberIdAndStageIndexAndIsDelOrderByIndexAsc(String battleId, String memberId,
			Integer stageIndex,Integer isDel) {
		return battleMemberStageIndexRepository.findAllByBattleIdAndMemberIdAndStageIndexAndIsDelOrderByIndexAsc(battleId,memberId,stageIndex,isDel);
	}

	public void update(BattleMemberIndex battleMemberIndex) {
		battleMemberIndex.setUpdateAt(new DateTime());
		battleMemberStageIndexRepository.save(battleMemberIndex);
		
	}

	public void add(BattleMemberIndex battleMemberIndex) {
		battleMemberIndex.setId(UUID.randomUUID().toString());
		battleMemberIndex.setCreateAt(new DateTime());
		battleMemberIndex.setUpdateAt(new DateTime());
		battleMemberStageIndexRepository.save(battleMemberIndex);
	}
}

package com.wyc.draw.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.BattleMemberIndex;

public interface BattleMemberStageIndexRepository extends CrudRepository<BattleMemberIndex, String>{

	List<BattleMemberIndex> findAllByBattleIdAndMemberIdAndStageIndexOrderByIndexAsc(String battleId,
			String memberId, Integer stageIndex);

}

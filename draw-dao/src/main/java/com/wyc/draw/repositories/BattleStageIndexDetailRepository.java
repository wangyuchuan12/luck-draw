package com.wyc.draw.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.BattleStageIndexDetail;

public interface BattleStageIndexDetailRepository extends CrudRepository<BattleStageIndexDetail, String>{

	BattleStageIndexDetail findOneByBattleIdAndStageIndex(String battleId, Integer stageIndex);

}

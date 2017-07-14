package com.wyc.draw.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.BattleStageIndexDetail;

public interface BattleStageIndexDetailRepository extends CrudRepository<BattleStageIndexDetail, String>{


	List<BattleStageIndexDetail> findAllByBattleIdAndIsDelAndStageindexIn(String battleId, int isDel,
			List<Integer> stageIndexes);

	List<BattleStageIndexDetail> findAllByBattleIdOrderByIndexAsc(String battleId);

}

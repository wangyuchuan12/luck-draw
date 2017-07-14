package com.wyc.draw.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.BattleModelStageIndex;

public interface BattleModelStageIndexRepository extends CrudRepository<BattleModelStageIndex, String>{

	List<BattleModelStageIndex> findAllByBattleModelId(String modelId);

}

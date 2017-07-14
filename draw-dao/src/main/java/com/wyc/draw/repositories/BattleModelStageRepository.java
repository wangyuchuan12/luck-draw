package com.wyc.draw.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.BattleModelStage;

public interface BattleModelStageRepository extends CrudRepository<BattleModelStage, String>{

	List<BattleModelStage> findAllByBattleModelId(String modelId);

}

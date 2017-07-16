package com.wyc.draw.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.BattleModelToDrawUser;

public interface BattleModelToDrawUserRepository extends CrudRepository<BattleModelToDrawUser, String>{

	BattleModelToDrawUser findOneByModelIdAndDrawUserId(String modelId, String drawUserId);

}

package com.wyc.draw.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.BattleRank;

public interface BattleRankRepository extends CrudRepository<BattleRank, String>{

	BattleRank findOneByBattleId(String battleId);

}

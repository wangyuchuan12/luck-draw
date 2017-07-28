package com.wyc.draw.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.BattleReward;

public interface BattleRewardRepository extends CrudRepository<BattleReward, String>{

	List<BattleReward> findAllByBattleId(String battleId, Pageable pageable);

}

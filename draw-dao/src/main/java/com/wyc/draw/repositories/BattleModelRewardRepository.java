package com.wyc.draw.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.BattleModelReward;

public interface BattleModelRewardRepository extends CrudRepository<BattleModelReward, String>{

	List<BattleModelReward> findAllByModelIdAndIsDel(String modelId, int isDel);

}

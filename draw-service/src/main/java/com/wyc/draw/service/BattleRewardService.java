package com.wyc.draw.service;

import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.BattleReward;
import com.wyc.draw.repositories.BattleRewardRepository;

@Service
public class BattleRewardService {

	@Autowired
	private BattleRewardRepository battleRewardRepository;

	public List<BattleReward> findAllByBattleId(String battleId, Pageable pageable) {
		return battleRewardRepository.findAllByBattleId(battleId,pageable);
	}

	public void add(BattleReward battleReward) {
		battleReward.setId(UUID.randomUUID().toString());
		battleReward.setUpdateAt(new DateTime());
		battleReward.setCreateAt(new DateTime());
		battleRewardRepository.save(battleReward);
		
	}
}

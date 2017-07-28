package com.wyc.draw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.BattleModelReward;
import com.wyc.draw.repositories.BattleModelRewardRepository;

@Service
public class BattleModelRewardService {

	@Autowired
	private BattleModelRewardRepository battleModelRewardRepository;

	public List<BattleModelReward> findAllByModelIdAndIsDel(String modelId, int isDel) {
		return battleModelRewardRepository.findAllByModelIdAndIsDel(modelId,isDel);
	}
}

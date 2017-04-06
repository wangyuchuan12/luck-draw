package com.wyc.draw.service;

import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.Reward;
import com.wyc.draw.repositories.RewardRepository;

@Service
public class RewardService {
	@Autowired
	private RewardRepository rewardRepository;

	public Reward add(Reward reward) {
		reward.setId(UUID.randomUUID().toString());
		reward.setCreateAt(new DateTime());
		reward.setUpdateAt(new DateTime());
		
		return rewardRepository.save(reward);
		
	}

	public Reward findOne(String id) {
		
		return rewardRepository.findOne(id);
	}
}

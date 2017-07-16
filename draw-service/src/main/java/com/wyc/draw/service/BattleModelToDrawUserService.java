package com.wyc.draw.service;

import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.BattleModelToDrawUser;
import com.wyc.draw.repositories.BattleModelToDrawUserRepository;

@Service
public class BattleModelToDrawUserService {

	@Autowired
	private BattleModelToDrawUserRepository battleModelToDrawUserRepository;

	public BattleModelToDrawUser findOneByModelIdAndDrawUserId(String modelId, String drawUserId) {
		return battleModelToDrawUserRepository.findOneByModelIdAndDrawUserId(modelId,drawUserId);
	}

	public void add(BattleModelToDrawUser battleModelToDrawUser) {
		battleModelToDrawUser.setId(UUID.randomUUID().toString());
		battleModelToDrawUser.setUpdateAt(new DateTime());
		battleModelToDrawUser.setCreateAt(new DateTime());
		
		battleModelToDrawUserRepository.save(battleModelToDrawUser);
	}

	public void save(BattleModelToDrawUser battleModelToDrawUser) {
		
		battleModelToDrawUser.setUpdateAt(new DateTime());
		battleModelToDrawUserRepository.save(battleModelToDrawUser);
		
	}
}

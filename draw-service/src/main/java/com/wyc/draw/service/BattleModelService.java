package com.wyc.draw.service;

import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.BattleModel;
import com.wyc.draw.repositories.BattleModelRepository;

@Service
public class BattleModelService {

	@Autowired
	private BattleModelRepository battleModelRepository;

	public BattleModel findOne(String id) {
		return battleModelRepository.findOne(id);
	}

	public BattleModel findOneByCode(String code) {
		return battleModelRepository.findOneByCode(code);
	}

	public void add(BattleModel battleModel) {
		
		battleModel.setId(UUID.randomUUID().toString());
		battleModel.setUpdateAt(new DateTime());
		battleModel.setCreateAt(new DateTime());
		
		battleModelRepository.save(battleModel);
		
	}
}

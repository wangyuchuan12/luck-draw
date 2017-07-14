package com.wyc.draw.service;

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
}

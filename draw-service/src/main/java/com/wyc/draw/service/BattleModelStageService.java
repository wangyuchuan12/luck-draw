package com.wyc.draw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.BattleModelStage;
import com.wyc.draw.repositories.BattleModelStageRepository;

@Service
public class BattleModelStageService {

	@Autowired
	private BattleModelStageRepository battleModelStageRepository;

	public List<BattleModelStage> findAllByBattleModelId(String modelId) {
		return battleModelStageRepository.findAllByBattleModelId(modelId);
	}
	
}

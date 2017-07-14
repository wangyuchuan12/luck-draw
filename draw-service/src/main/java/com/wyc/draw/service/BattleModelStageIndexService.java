package com.wyc.draw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.BattleModelStageIndex;
import com.wyc.draw.repositories.BattleModelStageIndexRepository;

@Service
public class BattleModelStageIndexService {

	@Autowired
	private BattleModelStageIndexRepository battleModelStageIndexRepository;

	public List<BattleModelStageIndex> findAllByBattleModelId(String modelId) {
		return battleModelStageIndexRepository.findAllByBattleModelId(modelId);
	}
}

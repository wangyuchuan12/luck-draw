package com.wyc.draw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.BattleStage;
import com.wyc.draw.repositories.BattleStageRepository;

@Service
public class BattleStageService {

	@Autowired
	private BattleStageRepository battleStageRepository;

	public BattleStage findOneByBattleIdAndStageIndex(String battleId, Integer stageIndex) {
		return battleStageRepository.findOneByBattleIdAndStageIndex(battleId,stageIndex);
	}

	public List<BattleStage> findAllByBattleIdAndAndIsDelAndStageIndexIn(String battleId, Integer isDel , List<Integer> stageIndexArray) {
		return battleStageRepository.findAllByBattleIdAndAndIsDelAndStageIndexIn(battleId,isDel,stageIndexArray);
	}
	
	public Long countByBattleId(String battleId){
		
		return battleStageRepository.countByBattleId(battleId);
	}
	
	
}

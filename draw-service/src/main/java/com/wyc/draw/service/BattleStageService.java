package com.wyc.draw.service;

import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;
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

	public List<BattleStage> findAllByBattleIdAndIsDelAndStageIndexIn(String battleId, Integer isDel , List<Integer> stageIndexArray) {
		return battleStageRepository.findAllByBattleIdAndIsDelAndStageIndexIn(battleId,isDel,stageIndexArray);
	}
	
	public Long countByBattleId(String battleId){
		
		return battleStageRepository.countByBattleId(battleId);
	}

	public List<BattleStage> findAllByBattleIdAndIsDel(String battleId, int isDel) {
		return battleStageRepository.findAllByBattleIdAndIsDel(battleId,isDel);
	}

	public void add(BattleStage battleStage) {
		battleStage.setId(UUID.randomUUID().toString());
		battleStage.setUpdateAt(new DateTime());
		battleStage.setCreateAt(new DateTime());
		
		battleStageRepository.save(battleStage);
		
	}
	
	
}

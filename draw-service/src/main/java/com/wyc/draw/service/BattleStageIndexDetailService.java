package com.wyc.draw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.BattleStageIndexDetail;
import com.wyc.draw.repositories.BattleStageIndexDetailRepository;

@Service
public class BattleStageIndexDetailService {

	@Autowired
	private BattleStageIndexDetailRepository battleStageIndexDetailRepository;

	public BattleStageIndexDetail findOneByBattleIdAndStageIndex(String battleId, Integer stageIndex) {
		return battleStageIndexDetailRepository.findOneByBattleIdAndStageIndex(battleId,stageIndex);
	}
}

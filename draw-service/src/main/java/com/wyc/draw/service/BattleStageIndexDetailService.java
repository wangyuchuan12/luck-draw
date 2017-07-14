package com.wyc.draw.service;

import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.BattleStageIndexDetail;
import com.wyc.draw.repositories.BattleStageIndexDetailRepository;

@Service
public class BattleStageIndexDetailService {

	@Autowired
	private BattleStageIndexDetailRepository battleStageIndexDetailRepository;


	public List<BattleStageIndexDetail> findAllByBattleIdAndIsDelAndStageIndexIn(String battleId, int isDel,
			List<Integer> stageIndexes) {
		
		return battleStageIndexDetailRepository.findAllByBattleIdAndIsDelAndStageindexIn(battleId,isDel,stageIndexes);
	}

	public void add(BattleStageIndexDetail battleStageIndexDetail) {
		
		battleStageIndexDetail.setCreateAt(new DateTime());
		battleStageIndexDetail.setUpdateAt(new DateTime());
		battleStageIndexDetail.setId(UUID.randomUUID().toString());
		battleStageIndexDetailRepository.save(battleStageIndexDetail);
		
	}

	public List<BattleStageIndexDetail> findAllByBattleIdOrderByIndexAsc(String battleId) {
		return battleStageIndexDetailRepository.findAllByBattleIdOrderByIndexAsc(battleId);
	}
}

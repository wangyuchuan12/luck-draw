package com.wyc.draw.service;

import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.BattleMemberStage;
import com.wyc.draw.repositories.BattleMemberStageRepository;

@Service
public class BattleMemberStageService {

	@Autowired
	private BattleMemberStageRepository battleMemberStageRepository;

	public BattleMemberStage findOneByMemberIdAndBattleIdAndStageIndexAndStatusAndIsDel(String memberId,String battleId, Integer stageIndex,
			int status,int isDel) {
		return battleMemberStageRepository.findOneByMemberIdAndBattleIdAndStageIndexAndStatusAndIsDel(memberId,battleId,stageIndex,status,isDel);
	}
	
	public List<BattleMemberStage> findAllByBattleIdAndStageIndexIn(String battleId, String[] stageIndexArray) {
		return battleMemberStageRepository.findAllByBattleIdAndStageIndexIn(battleId,stageIndexArray);
	}

	public List<BattleMemberStage> findAllByBattleIdAndIsDelAndStageIndexIn(String battleId, int isDel,
			List<Integer> stageIndexArray) {
		return battleMemberStageRepository.findAllByBattleIdAndIsDelAndStageIndexIn(battleId,isDel,stageIndexArray);
	}

	public void update(BattleMemberStage battleMemberStage) {
		
		battleMemberStage.setUpdateAt(new DateTime());
		battleMemberStageRepository.save(battleMemberStage);
		
	}

	public void add(BattleMemberStage battleMemberStage) {
		battleMemberStage.setCreateAt(new DateTime());
		battleMemberStage.setUpdateAt(new DateTime());
		battleMemberStage.setId(UUID.randomUUID().toString());
		battleMemberStageRepository.save(battleMemberStage);
	}
	
	public Long countByBattleId(String battleId){
		return battleMemberStageRepository.countByBattleId(battleId);
	}

	public List<BattleMemberStage> findAllByMemberIdOrderByStageIndexAsc(String memberId) {
		return battleMemberStageRepository.findAllByMemberIdOrderByStageIndexAsc(memberId);
	}

	public BattleMemberStage findOneByMemberIdAndBattleIdAndStageIndexAndIsDel(String memberId, String battleId, Integer stage,Integer isDel) {
		return battleMemberStageRepository.findOneByMemberIdAndBattleIdAndStageIndexAndIsDel(memberId,battleId,stage,isDel);
	}
}

package com.wyc.draw.service;

import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.BattleRank;
import com.wyc.draw.repositories.BattleRankRepository;

@Service
public class BattleRankService {

	@Autowired
	private BattleRankRepository battleRankRespository;

	public BattleRank findOne(String battleRankId) {
		return battleRankRespository.findOne(battleRankId);
	}

	public BattleRank findOneByBattleId(String battleId) {
		return battleRankRespository.findOneByBattleId(battleId);
	}

	public void add(BattleRank battleRank) {
		battleRank.setId(UUID.randomUUID().toString());
		battleRank.setUpdateAt(new DateTime());
		battleRank.setCreateAt(new DateTime());
		
		battleRankRespository.save(battleRank);
	}
}

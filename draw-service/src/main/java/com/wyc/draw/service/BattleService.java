package com.wyc.draw.service;

import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.Battle;
import com.wyc.draw.repositories.BattleRepository;

@Service
public class BattleService {

	@Autowired
	private BattleRepository battleRepository;

	public Battle findOneByPaperId(String paperId) {
		return battleRepository.findOneByPaperId(paperId);
	}

	public List<Battle> findAllBySubjectId(String subjectId) {
		return battleRepository.findAllBySubjectId(subjectId);
	}

	public Battle findOne(String id) {
		return battleRepository.findOne(id);
	}

	public void add(Battle battle) {
		
		System.out.println("addd.........");
		battle.setId(UUID.randomUUID().toString());
		battle.setUpdateAt(new DateTime());
		battle.setCreateAt(new DateTime());
		
		battleRepository.save(battle);
		
		
	}

	public void update(Battle battle) {
		System.out.println("update.........");
		battle.setUpdateAt(new DateTime());
		
		battleRepository.save(battle);
		
	}
}

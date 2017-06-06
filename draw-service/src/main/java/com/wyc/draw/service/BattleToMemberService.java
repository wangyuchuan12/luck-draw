package com.wyc.draw.service;

import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.BattleToMember;
import com.wyc.draw.repositories.BattleToMemberRepository;

@Service
public class BattleToMemberService {

	@Autowired
	private BattleToMemberRepository battleToMemberRepository;

	public BattleToMember findOneByDrawUserIdAndBattleId(String drawUserId, String battleId) {
		return battleToMemberRepository.findOneByDrawUserIdAndBattleId(drawUserId,battleId);
	}

	public BattleToMember add(BattleToMember battleToMember) {
		battleToMember.setId(UUID.randomUUID().toString());
		battleToMember.setUpdateAt(new DateTime());
		battleToMember.setCreateAt(new DateTime());
		battleToMemberRepository.save(battleToMember);
		return battleToMember;
	}

	public void update(BattleToMember battleToMember) {
		battleToMember.setUpdateAt(new DateTime());
		
		battleToMemberRepository.save(battleToMember);
		
	}
}

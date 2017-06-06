package com.wyc.draw.service;

import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.BattleMember;
import com.wyc.draw.repositories.BattleMemberRepository;

@Service
public class BattleMemberService {

	@Autowired
	private BattleMemberRepository battleMemberRepository;

	public List<BattleMember> findAllByBattleId(String battleId, Pageable pageable) {
		return battleMemberRepository.findAllByBattleId(battleId,pageable);
	}

	public BattleMember add(BattleMember battleMember) {
		battleMember.setId(UUID.randomUUID().toString());
		battleMember.setCreateAt(new DateTime());
		battleMember.setUpdateAt(new DateTime());
		battleMemberRepository.save(battleMember);
		return battleMember;
	}

	public BattleMember findOne(String id) {
		return battleMemberRepository.findOne(id);
	}

	public void update(BattleMember battleMember) {
		battleMember.setUpdateAt(new DateTime());
		
		battleMemberRepository.save(battleMember);
		
	}

	public Long rank(BattleMember battleMember) {
		return battleMemberRepository.rank(battleMember.getScore());
	}
}

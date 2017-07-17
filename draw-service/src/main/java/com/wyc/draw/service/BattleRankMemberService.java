package com.wyc.draw.service;

import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.BattleRankMember;
import com.wyc.draw.repositories.BattleRankMemberRepository;

@Service
public class BattleRankMemberService {

	@Autowired
	private BattleRankMemberRepository battleRankMemberRepository;

	public List<BattleRankMember> findAllByBattleRankId(String battleRankId) {
		
		return battleRankMemberRepository.findAllByBattleRankId(battleRankId);
	}

	public BattleRankMember findOneByBattleRankIdAndMemberId(String rankId, String memberId) {
		return battleRankMemberRepository.findOneByBattleRankIdAndMemberId(rankId,memberId);
	}

	public void add(BattleRankMember battleRankMember) {
		battleRankMember.setUpdateAt(new DateTime());
		battleRankMember.setCreateAt(new DateTime());
		battleRankMember.setId(UUID.randomUUID().toString());
		battleRankMemberRepository.save(battleRankMember);
	}

	public List<BattleRankMember> findAllByBattleIdAndStatusIn(String battleId, List<Integer> statuses,
			Pageable pageable) {
		return battleRankMemberRepository.findAllByBattleIdAndStatusIn(battleId,statuses,pageable);
	}

	public void update(BattleRankMember battleRankMember) {
		
		battleRankMember.setUpdateAt(new DateTime());
		battleRankMemberRepository.save(battleRankMember);
		
	}
}

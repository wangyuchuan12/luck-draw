package com.wyc.draw.service;

import java.util.List;

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
}

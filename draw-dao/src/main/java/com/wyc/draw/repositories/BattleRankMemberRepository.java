package com.wyc.draw.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.BattleRankMember;

public interface BattleRankMemberRepository extends CrudRepository<BattleRankMember, String>{

	List<BattleRankMember> findAllByBattleRankId(String battleRankId);

	BattleRankMember findOneByBattleRankIdAndMemberId(String rankId, String memberId);

	List<BattleRankMember> findAllByBattleIdAndStatusIn(String battleId, List<Integer> statuses, Pageable pageable);

}

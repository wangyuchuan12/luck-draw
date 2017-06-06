package com.wyc.draw.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.BattleToMember;

public interface BattleToMemberRepository extends CrudRepository<BattleToMember, String>{

	BattleToMember findOneByDrawUserIdAndBattleId(String drawUserId, String battleId);

}

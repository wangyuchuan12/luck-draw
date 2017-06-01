package com.wyc.draw.repositories;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.BattleMember;

public interface BattleMemberRepository extends CrudRepository<BattleMember, String>{

	List<BattleMember> findAllByBattleId(String battleId, Pageable pageable);

}

package com.wyc.draw.repositories;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.wyc.draw.domain.BattleMember;

public interface BattleMemberRepository extends CrudRepository<BattleMember, String>{

	List<BattleMember> findAllByBattleId(String battleId, Pageable pageable);

	@Query(value="select count(*)+1 from com.wyc.draw.domain.BattleMember bm where bm.score>:score")
	Long rank(@Param("score")Integer score);

}

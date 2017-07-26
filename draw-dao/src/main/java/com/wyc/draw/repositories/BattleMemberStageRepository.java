package com.wyc.draw.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.wyc.draw.domain.BattleMemberStage;

public interface BattleMemberStageRepository extends CrudRepository<BattleMemberStage, String>{

	BattleMemberStage findOneByMemberIdAndBattleIdAndStageIndexAndStatusAndIsDel(String memberId,String battleId, Integer stageIndex, int status,int isDel);

	@Query(value="from com.wyc.draw.domain.BattleMemberStage bmg where bmg.battleId=:battleId and bmg.stageIndex in (:stageIndexs)")
	List<BattleMemberStage> findAllByBattleIdAndStageIndexIn(@Param("battleId")String battleId,@Param("stageIndexs")String[] stageIndexArray);

	@Query(value="from com.wyc.draw.domain.BattleMemberStage bmg where bmg.battleId=:battleId and bmg.isDel=:isDel and bmg.stageIndex in (:stageIndexs)")
	List<BattleMemberStage> findAllByBattleIdAndIsDelAndStageIndexIn(@Param("battleId")String battleId, @Param("isDel")int isDel,
			@Param("stageIndexs")List<Integer> stageIndexArray);

	@Query(value="select count(*) from com.wyc.draw.domain.BattleMemberStage bmg where bmg.battleId=:battleId and bmg.isDel=0")
	Long countByBattleId(@Param("battleId")String battleId);

	List<BattleMemberStage> findAllByMemberIdOrderByStageIndexAsc(String memberId);


	BattleMemberStage findOneByMemberIdAndBattleIdAndStageIndexAndIsDel(String memberId, String battleId, Integer stage,Integer isDel);

}

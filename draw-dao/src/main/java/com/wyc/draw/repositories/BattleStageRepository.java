package com.wyc.draw.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.wyc.draw.domain.BattleStage;

public interface BattleStageRepository extends CrudRepository<BattleStage, String>{

	BattleStage findOneByBattleIdAndStageIndex(String battleId, Integer stageIndex);

	@Query(value="from com.wyc.draw.domain.BattleStage bs where bs.battleId=:battleId and bs.isDel=:isDel and bs.stageIndex in (:stageIndexs)")
	List<BattleStage> findAllByBattleIdAndIsDelAndStageIndexIn(@Param("battleId")String battleId,@Param("isDel")Integer isDel ,@Param("stageIndexs")List<Integer> stageIndexArray);

	@Query(value="select count(*) from com.wyc.draw.domain.BattleStage bs where bs.battleId=:battleId and bs.isDel=0")
	Long countByBattleId(@Param("battleId")String battleId);

	List<BattleStage> findAllByBattleIdAndIsDel(String battleId, int isDel);
}

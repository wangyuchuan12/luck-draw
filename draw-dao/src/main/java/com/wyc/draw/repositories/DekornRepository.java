package com.wyc.draw.repositories;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.wyc.draw.domain.Dekorn;

public interface DekornRepository extends CrudRepository<Dekorn, String>{

	
	@Query(value="select count(*) from com.wyc.draw.domain.Dekorn dekorn where "
			+ "dekorn.gameId=:gameId and dekorn.passScore>=:passScore and dekorn.status=:status")
	Long countByGameIdAndBiggerThanPassScoreAndStatus(@Param("gameId")String gameId,
													  @Param("passScore")Long passScore,
													  @Param("status")int status);
	
	
	@Query(value="from com.wyc.draw.domain.Dekorn dekorn where "
			+ "dekorn.gameId=:gameId and dekorn.passScore>=:passScore and dekorn.status=:status")
	List<Dekorn> findAllByGameIdAndBiggerThanPassScoreAndStatus(@Param("gameId")String gameId,
																@Param("passScore")Long passScore,
																@Param("status")int status,Pageable pageable);

}

package com.wyc.draw.repositories;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.wyc.draw.domain.DekornTakepartMember;

public interface DekornTakepartMemberRepository extends CrudRepository<DekornTakepartMember, String>{

	
//	@Query(value="select dtm.score as score,dtm.nickname as nickname ,dtm.headImg as headImg,dtm.id as id from com.wyc.draw.domain.DekornTakepartMember dtm where dtm.dekornId=:dekornId")
	List<DekornTakepartMember> findAllByDekornId(@Param("dekornId")String dekornId, Pageable pageable);

	
	@Query(nativeQuery=true,value="select count(*)+1 from v_dekorn_takepart_member m where m.score>(select score from v_dekorn_takepart_member m2 where m2.id=:id)")
	Long rankOfTakepartMember(@Param("id")String id);


	@Query(nativeQuery=true,value="select count(*) from v_dekorn_takepart_member m where m.dekorn_id=:dekornId")
	Long countByDekornId(@Param("dekornId")String dekornId);

}

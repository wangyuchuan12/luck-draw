package com.wyc.draw.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.wyc.draw.domain.VieRedPacketProblem;

public interface VieRedPacketProblemRepository extends CrudRepository<VieRedPacketProblem, String>{

	@Query(value="select count(*) from com.wyc.draw.domain.VieRedPacketProblem vrp where vrp.redPacketId=:redPacketId")
	Long coutByRedPacketId(@Param("redPacketId")String redPacketId);

	VieRedPacketProblem findOneByPreviousProblemId(String previousProblemId);

}

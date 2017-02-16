package com.wyc.draw.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.wyc.draw.domain.VieRedPacketProblem;

public interface VieRedPacketProblemRepository extends CrudRepository<VieRedPacketProblem, String>{

	@Query(value="select count(*) from com.wyc.draw.domain.VieRedPacketProblem vrp where vrp.redPacketId=:redPacketId")
	Long coutByRedPacketId(@Param("redPacketId")String redPacketId);

	VieRedPacketProblem findOneByPreviousProblemId(String previousProblemId);

	@Query(value="from com.wyc.draw.domain.VieRedPacketProblem vrp where vrp.redPacketId=:redPacketId and"
			+ " vrp.seq=(select min(seq) from com.wyc.draw.domain.VieRedPacketProblem vrp2 where vrp2.redPacketId=:redPacketId)")
	List<VieRedPacketProblem> findFirstByRedPacketId(@Param("redPacketId")String redPacketId);

	List<VieRedPacketProblem> findAllByRedPacketIdOrderBySeqAsc(String redPacketId);

	@Query(value="from com.wyc.draw.domain.VieRedPacketProblem vrp where vrp.redPacketId=:redPacketId and vrp.seq = (select min(seq) from com.wyc.draw.domain.VieRedPacketProblem vrp2 where vrp2.redPacketId=:redPacketId)")
	VieRedPacketProblem getFirstByRedPacketId(@Param("redPacketId")String redPacketId);
	
	@Query(value="from com.wyc.draw.domain.VieRedPacketProblem vrp where vrp.redPacketId=:redPacketId and vrp.seq = (select max(seq) from com.wyc.draw.domain.VieRedPacketProblem vrp2 where vrp2.redPacketId=:redPacketId)")
	VieRedPacketProblem getLastByRedPacketId(@Param("redPacketId")String redPacketId);

	VieRedPacketProblem findOneByRedPacketIdAndSeq(String redPacketId, int currentSeq);

}

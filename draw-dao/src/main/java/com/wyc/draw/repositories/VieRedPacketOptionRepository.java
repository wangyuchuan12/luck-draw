package com.wyc.draw.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.VieRedPacketOption;

public interface VieRedPacketOptionRepository extends CrudRepository<VieRedPacketOption, String>{

	List<VieRedPacketOption> findAllByRedPacketProblemIdAndIsDelOrderBySeqAsc(String problemId,int isDel);

}

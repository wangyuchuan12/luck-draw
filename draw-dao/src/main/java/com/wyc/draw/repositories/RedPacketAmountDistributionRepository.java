package com.wyc.draw.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.RedPacketAmountDistribution;

public interface RedPacketAmountDistributionRepository extends CrudRepository<RedPacketAmountDistribution, String>{

	List<RedPacketAmountDistribution> findAllByRedPacketIdOrderBySeqAsc(String redPacketId);

	List<RedPacketAmountDistribution> findAllByRedPacketIdOrderBySeqAsc(String redPacketId, Pageable pageable);

}

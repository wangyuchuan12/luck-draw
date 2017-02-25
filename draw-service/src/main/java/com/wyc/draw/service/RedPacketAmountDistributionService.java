package com.wyc.draw.service;

import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.RedPacketAmountDistribution;
import com.wyc.draw.repositories.RedPacketAmountDistributionRepository;

@Service
public class RedPacketAmountDistributionService {

	@Autowired
	private RedPacketAmountDistributionRepository redPacketAmountDistributionRepository;
	
	public RedPacketAmountDistribution add(RedPacketAmountDistribution redPacketAmountDistribution) {
		
		redPacketAmountDistribution.setId(UUID.randomUUID().toString());
		redPacketAmountDistribution.setUpdateAt(new DateTime());
		redPacketAmountDistribution.setCreateAt(new DateTime());
		
		return redPacketAmountDistributionRepository.save(redPacketAmountDistribution);
		
	}

	public List<RedPacketAmountDistribution> findAllByRedPacketIdOrderBySeqAsc(String redPacketId) {
		return redPacketAmountDistributionRepository.findAllByRedPacketIdOrderBySeqAsc(redPacketId);
	}

}

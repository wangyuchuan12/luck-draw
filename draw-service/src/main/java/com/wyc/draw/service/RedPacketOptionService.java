package com.wyc.draw.service;

import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.RedPacketOption;
import com.wyc.draw.repositories.RedPacketOptionRepository;

@Service
public class RedPacketOptionService {
	
	@Autowired
	private RedPacketOptionRepository redPacketOptionRepository;

	public RedPacketOption add(RedPacketOption redPacketOption) {
		redPacketOption.setCreateAt(new DateTime());
		
		redPacketOption.setUpdateAt(new DateTime());
		
		redPacketOption.setId(UUID.randomUUID().toString());
		
		return redPacketOptionRepository.save(redPacketOption);
		
	}

	public RedPacketOption findOne(String delOptionId) {
		return redPacketOptionRepository.findOne(delOptionId);
	}

	public RedPacketOption update(RedPacketOption redPacketOption) {
		
		redPacketOption.setCreateAt(new DateTime());
		redPacketOption.setUpdateAt(new DateTime());
		redPacketOption = redPacketOptionRepository.save(redPacketOption);
		return redPacketOption;
	}

	public List<RedPacketOption> findAllByRedPacketIdAndIsDelOrderBySeqAsc(String redPacketId,int isDel) {
		
		return redPacketOptionRepository.findAllByRedPacketIdAndIsDelOrderBySeqAsc(redPacketId,isDel);
	}
}

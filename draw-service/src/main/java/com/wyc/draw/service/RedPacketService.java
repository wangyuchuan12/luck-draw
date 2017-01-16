package com.wyc.draw.service;

import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.repositories.RedPackageRepository;

@Service
public class RedPacketService {
	
	@Autowired
	private RedPackageRepository redPackageRepository;

	public RedPacket add(RedPacket redPacket) {
		redPacket.setId(UUID.randomUUID().toString());
		redPacket.setCreateAt(new DateTime());
		redPacket.setUpdateAt(new DateTime());
		return redPackageRepository.save(redPacket);
	}

	public RedPacket findOne(String id) {
		return redPackageRepository.findOne(id);
	}

	public RedPacket update(RedPacket redPacket) {
		redPacket.setUpdateAt(new DateTime());
		redPackageRepository.save(redPacket);
		return redPacket;
		
	}
}

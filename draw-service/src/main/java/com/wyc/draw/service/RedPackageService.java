package com.wyc.draw.service;

import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.RedPacket;
import com.wyc.draw.repositories.RedPackageRepository;

@Service
public class RedPackageService {
	
	@Autowired
	private RedPackageRepository redPackageRepository;

	public RedPacket add(RedPacket redPacket) {
		redPacket.setId(UUID.randomUUID().toString());
		redPacket.setCreateAt(new DateTime());
		redPacket.setUpdateAt(new DateTime());
		return redPackageRepository.save(redPacket);
	}
}

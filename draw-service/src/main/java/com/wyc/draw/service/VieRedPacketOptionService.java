package com.wyc.draw.service;

import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.VieRedPacketOption;
import com.wyc.draw.repositories.VieRedPacketOptionRepository;

@Service
public class VieRedPacketOptionService {

	@Autowired
	private VieRedPacketOptionRepository vieRedPacketOptionRepository;

	public VieRedPacketOption add(VieRedPacketOption vieRedPacketOption) {
		vieRedPacketOption.setId(UUID.randomUUID().toString());
		vieRedPacketOption.setUpdateAt(new DateTime());
		vieRedPacketOption.setCreateAt(new DateTime());
		
		return vieRedPacketOptionRepository.save(vieRedPacketOption);
		
	}
}

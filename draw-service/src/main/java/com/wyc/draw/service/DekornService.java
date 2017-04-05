package com.wyc.draw.service;

import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.Dekorn;
import com.wyc.draw.repositories.DekornRepository;

@Service
public class DekornService {
	@Autowired
	private DekornRepository dekornRepository;

	public Dekorn findOne(String id) {
		return dekornRepository.findOne(id);
	}

	public Dekorn add(Dekorn dekorn) {
		dekorn.setId(UUID.randomUUID().toString());
		dekorn.setUpdateAt(new DateTime());
		dekorn.setCreateAt(new DateTime());
		
		return dekornRepository.save(dekorn);
		
		
		
	}
}

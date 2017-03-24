package com.wyc.draw.service;

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
}

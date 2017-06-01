package com.wyc.draw.service;

import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.PropRandom;
import com.wyc.draw.repositories.PropRandomRepository;

@Service
public class PropRandomService {

	@Autowired
	private PropRandomRepository propRandomRepository;
	public PropRandom findOneByPropId(String propId) {
		return propRandomRepository.findOneByPropId(propId);
	}
	public PropRandom add(PropRandom propRandom) {
		propRandom.setId(UUID.randomUUID().toString());
		propRandom.setCreateAt(new DateTime());
		propRandom.setUpdateAt(new DateTime());
		return propRandomRepository.save(propRandom);
	}
	public void update(PropRandom propRandom) {
		propRandom.setUpdateAt(new DateTime());
		propRandomRepository.save(propRandom);
		
	}

}

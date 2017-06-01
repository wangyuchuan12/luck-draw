package com.wyc.draw.service;

import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.PropLove;
import com.wyc.draw.repositories.PropLoveRepository;

@Service
public class PropLoveService {

	@Autowired
	private PropLoveRepository propLoveRepository;
	public PropLove findOneByPropId(String propId) {
		return propLoveRepository.findOneByPropId(propId);
	}
	public PropLove add(PropLove propLove) {
		propLove.setId(UUID.randomUUID().toString());
		propLove.setCreateAt(new DateTime());
		propLove.setUpdateAt(new DateTime());
		
		propLoveRepository.save(propLove);
		return propLove;
	}
	public void update(PropLove propLove) {
		propLove.setUpdateAt(new DateTime());
		
		propLoveRepository.save(propLove);
		
	}

}

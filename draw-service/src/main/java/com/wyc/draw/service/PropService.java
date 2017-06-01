package com.wyc.draw.service;

import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.Prop;
import com.wyc.draw.repositories.PropRepository;

@Service
public class PropService {

	@Autowired
	private PropRepository propRepository;
	
	public Prop findOne(String propId) {
		return propRepository.findOne(propId);
	}

	public Prop add(Prop prop) {
		prop.setId(UUID.randomUUID().toString());
		prop.setUpdateAt(new DateTime());
		prop.setCreateAt(new DateTime());
		
		return propRepository.save(prop);
		
	}

	public Prop findOneByDrawUserId(String drawUserId) {
		
		return propRepository.findOneByDrawUserId(drawUserId);
	}

	public void update(Prop prop) {
		prop.setUpdateAt(new DateTime());
		propRepository.save(prop);
		
	}

}

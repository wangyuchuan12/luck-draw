package com.wyc.draw.service;

import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.PropPhy;
import com.wyc.draw.repositories.PropPhyRepository;

@Service
public class PropPhyService {

	@Autowired
	private PropPhyRepository propPhyRepository;
	public PropPhy findOneByPropId(String propId) {
		
		return propPhyRepository.findOneByPropId(propId);
	}
	public PropPhy add(PropPhy propPhy) {
		propPhy.setId(UUID.randomUUID().toString());
		propPhy.setCreateAt(new DateTime());
		propPhy.setUpdateAt(new DateTime());
		propPhyRepository.save(propPhy);
		return propPhy;
	}

}

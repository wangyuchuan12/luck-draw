package com.wyc.draw.service;

import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.PropBean;

import com.wyc.draw.repositories.PropBeanRepository;

@Service
public class PropBeanService {

	@Autowired
	private PropBeanRepository propBeanRepository;
	
	public PropBean findOneByPropId(String propId) {
		return propBeanRepository.findOneByPropId(propId);
	}
	
	public PropBean add(PropBean propBean) {	
		propBean.setId(UUID.randomUUID().toString());
		propBean.setCreateAt(new DateTime());
		propBean.setUpdateAt(new DateTime());
		
		return propBeanRepository.save(propBean);
	}

	public void update(PropBean propBean) {
		
		propBean.setUpdateAt(new DateTime());
		propBeanRepository.save(propBean);
		
	}

}

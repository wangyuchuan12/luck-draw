package com.wyc.draw.service;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.Good;
import com.wyc.draw.repositories.GoodRepository;

@Service
public class GoodService {

	@Autowired
	private GoodRepository goodRepository;

	public void update(Good good) {
		
		good.setUpdateAt(new DateTime());
		
		goodRepository.save(good);
		
	}

	public Good findOne(String id) {
		return goodRepository.findOne(id);
	}
}

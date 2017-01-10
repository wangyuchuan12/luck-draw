package com.wyc.draw.service;

import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.DrawUser;
import com.wyc.draw.repositories.DrawUserRepository;

@Service
public class DrawUserService {

	@Autowired
	private DrawUserRepository drawUserRepository;

	public DrawUser findByUserId(String userId) {
		return drawUserRepository.findByUserId(userId);
	}

	public DrawUser add(DrawUser drawUser) {
		drawUser.setId(UUID.randomUUID().toString());
		drawUser.setCreateAt(new DateTime());
		drawUser.setUpdateAt(new DateTime());
		
		return drawUserRepository.save(drawUser);
		
	}

	public DrawUser update(DrawUser drawUser) {
		drawUser.setUpdateAt(new DateTime());
		return drawUserRepository.save(drawUser);
		
	}
	
	public DrawUser findByUserIdWithLuck(String userId){
		return drawUserRepository.findByUserIdWithLock(userId);
	}
}

package com.wyc.draw.service;

import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.GameToDrawUser;
import com.wyc.draw.repositories.GameToDrawUserRepository;

@Service
public class GameToDrawUserService {

	@Autowired
	private GameToDrawUserRepository gameToDrawUserRepository;

	public GameToDrawUser findOneByGameIdAndDrawUserId(String gameId, String drawUserId) {
		return gameToDrawUserRepository.findOneByGameIdAndDrawUserId(gameId,drawUserId);
	}

	public GameToDrawUser add(GameToDrawUser gameToDrawUser) {
		gameToDrawUser.setUpdateAt(new DateTime());
		gameToDrawUser.setCreateAt(new DateTime());
		gameToDrawUser.setId(UUID.randomUUID().toString());
		return gameToDrawUserRepository.save(gameToDrawUser);
	}
}

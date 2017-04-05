package com.wyc.draw.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.GameToDrawUser;

public interface GameToDrawUserRepository extends CrudRepository<GameToDrawUser, String>{

	GameToDrawUser findOneByGameIdAndDrawUserId(String gameId, String drawUserId);

}

package com.wyc.draw.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.Game;

public interface GameRepository extends CrudRepository<Game, String>{

}

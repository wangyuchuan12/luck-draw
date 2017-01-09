package com.wyc.draw.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.DrawUser;

public interface DrawUserRepository extends CrudRepository<DrawUser, String>{

	DrawUser findByUserId(String userId);

}

package com.wyc.draw.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.PropRandom;

public interface PropRandomRepository extends CrudRepository<PropRandom, String>{

	PropRandom findOneByPropId(String propId);

}

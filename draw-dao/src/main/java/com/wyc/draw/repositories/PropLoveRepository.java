package com.wyc.draw.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.PropLove;

public interface PropLoveRepository extends CrudRepository<PropLove, String>{

	PropLove findOneByPropId(String propId);

}

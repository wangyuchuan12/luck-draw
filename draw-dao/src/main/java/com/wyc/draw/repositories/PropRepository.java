package com.wyc.draw.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.Prop;

public interface PropRepository extends CrudRepository<Prop, String>{

	Prop findOneByDrawUserId(String drawUserId);

}

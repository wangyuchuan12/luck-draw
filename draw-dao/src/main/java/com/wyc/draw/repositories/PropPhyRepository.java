package com.wyc.draw.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.PropPhy;

public interface PropPhyRepository extends CrudRepository<PropPhy, String>{

	PropPhy findOneByPropId(String propId);

}

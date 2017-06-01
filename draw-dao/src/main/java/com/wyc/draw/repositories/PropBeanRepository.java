package com.wyc.draw.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.PropBean;

public interface PropBeanRepository extends CrudRepository<PropBean, String>{

	PropBean findOneByPropId(String propId);

}

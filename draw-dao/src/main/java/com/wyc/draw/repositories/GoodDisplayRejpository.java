package com.wyc.draw.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.GoodDisplay;

public interface GoodDisplayRejpository extends CrudRepository<GoodDisplay, String>{

	List<GoodDisplay> findAllByClazzAndIsDisplayOrderByIndexAsc(int clazz, int isDisplay);

}

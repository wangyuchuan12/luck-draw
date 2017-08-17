package com.wyc.draw.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.BattleContext;

public interface BattleContextRepository extends CrudRepository<BattleContext, String>{

	BattleContext findOneByCode(String code);

	List<BattleContext> findAllByCodeIn(List<String> codes);

}

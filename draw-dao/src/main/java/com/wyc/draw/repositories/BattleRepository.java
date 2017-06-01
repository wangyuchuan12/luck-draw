package com.wyc.draw.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.Battle;

public interface BattleRepository extends CrudRepository<Battle, String>{

	Battle findOneByPaperId(String paperId);

	List<Battle> findAllBySubjectId(String subjectId);

}

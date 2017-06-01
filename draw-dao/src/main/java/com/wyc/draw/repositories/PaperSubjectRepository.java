package com.wyc.draw.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.PaperSubject;

public interface PaperSubjectRepository extends CrudRepository<PaperSubject, String>{

	public List<PaperSubject> findAll();

	public List<PaperSubject> findAllByPatternId(String patternId);
}

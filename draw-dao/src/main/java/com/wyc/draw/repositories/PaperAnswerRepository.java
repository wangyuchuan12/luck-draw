package com.wyc.draw.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.PaperAnswer;

public interface PaperAnswerRepository extends CrudRepository<PaperAnswer, String>{

	PaperAnswer findOneByKeyIdAndPaperId(String keyId, String paperId);

}

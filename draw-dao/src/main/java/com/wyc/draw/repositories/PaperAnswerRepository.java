package com.wyc.draw.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.PaperAnswer;

public interface PaperAnswerRepository extends CrudRepository<PaperAnswer, String>{

	PaperAnswer findOneByKeyIdAndPaperIdAndTypeAndIsDel(String keyId, String paperId, Integer type,Integer isDel);

	PaperAnswer findOneByKeyIdAndPaperIdAndIsDel(String keyId, String paperId, Integer isDel);

}

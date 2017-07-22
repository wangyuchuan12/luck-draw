package com.wyc.draw.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.QuestionOption;

public interface QuestionOptionRepository extends CrudRepository<QuestionOption, String>{

	List<QuestionOption> findAllByQuestionId(String id);

	List<QuestionOption> findAllByPaperIdOrderBySeqAsc(String paperId);

}

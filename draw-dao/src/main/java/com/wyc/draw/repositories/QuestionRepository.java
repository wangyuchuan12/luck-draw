package com.wyc.draw.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.Question;

public interface QuestionRepository extends CrudRepository<Question, String>{

	List<Question> findAllByPaperId(String paperId);

}

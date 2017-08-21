package com.wyc.draw.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.QuestionBank;

public interface QuestionBankRepository extends CrudRepository<QuestionBank, String>{

	List<QuestionBank> findAllByThemeCode(String themeCode);

}

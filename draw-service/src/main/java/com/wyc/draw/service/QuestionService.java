package com.wyc.draw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.Question;
import com.wyc.draw.repositories.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	public Question findOne(String id) {
		return questionRepository.findOne(id);
	}

	public List<Question> findAllByPaperId(String paperId) {
		return questionRepository.findAllByPaperId(paperId);
	}
}

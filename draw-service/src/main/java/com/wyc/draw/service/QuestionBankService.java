package com.wyc.draw.service;

import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.QuestionBank;
import com.wyc.draw.repositories.QuestionBankRepository;

@Service
public class QuestionBankService {

	@Autowired
	private QuestionBankRepository questionBankRepository;

	public void add(QuestionBank questionBank) {
		questionBank.setId(UUID.randomUUID().toString());
		questionBank.setUpdateAt(new DateTime());
		questionBank.setCreateAt(new DateTime());
		
		questionBankRepository.save(questionBank);
	}

	public QuestionBank findOne(String id) {
		return questionBankRepository.findOne(id);
	}

	public void update(QuestionBank questionBank) {
		questionBank.setUpdateAt(new DateTime());
		
		questionBankRepository.save(questionBank);
		
	}
}

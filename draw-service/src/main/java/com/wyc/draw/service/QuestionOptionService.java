package com.wyc.draw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.QuestionOption;
import com.wyc.draw.repositories.QuestionOptionRepository;




@Service
public class QuestionOptionService {

	@Autowired
	private QuestionOptionRepository questionOptionRepository;

	public List<QuestionOption> findAllByQuestionId(String id) {
		return questionOptionRepository.findAllByQuestionId(id);
	}

	public QuestionOption findOne(String optinId) {
		return questionOptionRepository.findOne(optinId);
	}

	public List<QuestionOption> findAllByPaperIdOrderBySeqAsc(String paperId) {
		return questionOptionRepository.findAllByPaperIdOrderBySeqAsc(paperId);
	}
}

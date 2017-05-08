package com.wyc.draw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
	
	public Long countAllByPaperIdAndByIdNotInAndIsDel(String paperId,List<String> ids ,Integer isDel){
		return questionRepository.countAllByPaperIdAndByIdNotInAndIsDel(paperId,ids,isDel);
	}

	public List<Question> findAllByPaperIdAndIsDel(String paperId,Integer isDel) {
		return questionRepository.findAllByPaperIdAndIsDel(paperId,isDel);
	}
	
	public List<Question> findAllByPaperIdAndByIdNotInAndIsDel(String paperId,List<String> ids ,Integer isDel,Pageable pageable) {
		return questionRepository.findAllByPaperIdAndByIdNotInAndIsDel(paperId,ids,isDel,pageable);
	}
}

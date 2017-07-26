package com.wyc.draw.service;

import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.QuestionAnswer;
import com.wyc.draw.repositories.QuestionAnswerRepository;

@Service
public class QuestionAnswerService {

	@Autowired
	private QuestionAnswerRepository questionAnswerRepository;

	public QuestionAnswer add(QuestionAnswer questionAnswer) {
		
		questionAnswer.setId(UUID.randomUUID().toString());
		
		questionAnswer.setCreateAt(new DateTime());
		
		questionAnswer.setUpdateAt(new DateTime());
		
		questionAnswerRepository.save(questionAnswer);
		return questionAnswer;
	}

	public List<QuestionAnswer> findAllByKeyIdAndPaperIdAndTypeAndIsDel(String keyId, String paperId, int type,Integer isDel) {
		return questionAnswerRepository.findAllByKeyIdAndPaperIdAndTypeAndIsDel(keyId,paperId,type,isDel);
	}


	public List<QuestionAnswer> findAllByPaperIdAndKeyIdAndIsDel(String paperId, String keyId,int isDel) {
		return questionAnswerRepository.findAllByPaperIdAndKeyIdAndIsDel(paperId,keyId,isDel);
	}

	public List<QuestionAnswer> findAllByPaperIdAndDrawUserIdAndIsDel(String paperId,String drawUserId,Integer isDel) {
		return questionAnswerRepository.findAllByPaperIdAndDrawUserIdAndIsDel(paperId,drawUserId,isDel);
	}

	public void update(QuestionAnswer questionAnswer) {
		questionAnswer.setUpdateAt(new DateTime());
		
		questionAnswerRepository.save(questionAnswer);
		
	}
}

package com.wyc.draw.service;

import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.PaperAnswer;
import com.wyc.draw.repositories.PaperAnswerRepository;

@Service
public class PaperAnswerService {

	@Autowired
	private PaperAnswerRepository paperAnswerRepository;

	public PaperAnswer findOneByKeyIdAndPaperIdAndType(String keyId, String paperId,Integer type) {
		return paperAnswerRepository.findOneByKeyIdAndPaperIdAndType(keyId,paperId,type);
	}

	public PaperAnswer add(PaperAnswer paperAnswer) {
		paperAnswer.setId(UUID.randomUUID().toString());
		paperAnswer.setUpdateAt(new DateTime());
		paperAnswer.setCreateAt(new DateTime());
		return paperAnswerRepository.save(paperAnswer);
	}

	public PaperAnswer update(PaperAnswer paperAnswer) {
		paperAnswer.setUpdateAt(new DateTime());
		return paperAnswerRepository.save(paperAnswer);
	}
}

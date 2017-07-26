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

	public PaperAnswer findOneByKeyIdAndPaperIdAndTypeAndIsDel(String keyId, String paperId,Integer type,Integer isDel) {
		return paperAnswerRepository.findOneByKeyIdAndPaperIdAndTypeAndIsDel(keyId,paperId,type,isDel);
	}
	
	public PaperAnswer findOneByKeyIdAndPaperIdAndIsDel(String keyId, String paperId,Integer isDel) {
		return paperAnswerRepository.findOneByKeyIdAndPaperIdAndIsDel(keyId,paperId,isDel);
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

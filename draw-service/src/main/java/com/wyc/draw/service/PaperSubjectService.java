package com.wyc.draw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.PaperSubject;
import com.wyc.draw.repositories.PaperSubjectRepository;

@Service
public class PaperSubjectService {

	@Autowired
	private PaperSubjectRepository paperSubjectRepository;

	public List<PaperSubject> findAll() {
		return paperSubjectRepository.findAll();
	}

	public List<PaperSubject> findAllByPatternId(String patternId) {
		return paperSubjectRepository.findAllByPatternId(patternId);
	}
}

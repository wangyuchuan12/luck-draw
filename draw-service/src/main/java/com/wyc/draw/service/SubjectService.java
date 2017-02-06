package com.wyc.draw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.Subject;
import com.wyc.draw.repositories.SubjectRepository;

@Service
public class SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;

	public List<Subject> findAllByIsMainAndIsDisplayOrderBySeqAsc(int isMain, int isDisplay) {
		return subjectRepository.findAllByIsMainAndIsDisplayOrderBySeqAsc(isMain,isDisplay);
	}

	public List<Subject> findAllByParentIdOrderBySeqAsc(String parentId) {
		
		return subjectRepository.findAllByParentIdOrderBySeqAsc(parentId);
	}
}

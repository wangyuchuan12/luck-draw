package com.wyc.draw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.Paper;
import com.wyc.draw.repositories.PaperRepository;

@Service
public class PaperService {

	@Autowired
	private PaperRepository paperRepository;

	public Paper findOne(String id) {
		return paperRepository.findOne(id);
	}
}

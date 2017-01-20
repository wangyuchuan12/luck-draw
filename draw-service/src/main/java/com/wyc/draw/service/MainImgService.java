package com.wyc.draw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.view.MainImg;
import com.wyc.draw.repositories.MainImgRepository;

@Service
public class MainImgService {

	@Autowired
	private MainImgRepository mainImgRepository;

	public List<MainImg> findAllByPeriodId(String periodId) {
		
		return mainImgRepository.findAllByPeriodId(periodId);
	}
}

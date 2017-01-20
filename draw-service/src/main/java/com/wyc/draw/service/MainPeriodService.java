package com.wyc.draw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.view.MainPeriod;
import com.wyc.draw.repositories.MainPeriodRepository;

@Service
public class MainPeriodService {

	@Autowired
	private MainPeriodRepository mainPeriodRepository;
	public List<MainPeriod> findAllByIsDefault(int isDefault) {
		
		return mainPeriodRepository.findAllByIsDefault(isDefault);
	}

}

package com.wyc.draw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.repositories.BattleStageRepository;

@Service
public class BattleStageService {

	@Autowired
	private BattleStageRepository battleStageRepository;
}
package com.wyc.draw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.repositories.BattleStageIndexDetailRepository;

@Service
public class BattleStageIndexDetailService {

	@Autowired
	private BattleStageIndexDetailRepository battleStageIndexDetailRepository;
}

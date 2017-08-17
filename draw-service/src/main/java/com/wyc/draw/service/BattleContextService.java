package com.wyc.draw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.BattleContext;
import com.wyc.draw.repositories.BattleContextRepository;

@Service
public class BattleContextService {

	@Autowired
	private BattleContextRepository battleContextRepository;
	
	public BattleContext findOneByCode(String code){
		
		return battleContextRepository.findOneByCode(code);
		
	}

	public List<BattleContext> findAllByCodeIn(List<String> codes) {
		return battleContextRepository.findAllByCodeIn(codes);
	}
}

package com.wyc.draw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wyc.draw.repositories.BattleMemberStageRepository;

@Service
public class BattleMemberStageService {

	@Autowired
	private BattleMemberStageRepository battleMemberStageRepository;
}

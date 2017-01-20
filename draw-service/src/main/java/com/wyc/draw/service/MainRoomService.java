package com.wyc.draw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.view.MainRoom;
import com.wyc.draw.repositories.MainRoomRepository;

@Service
public class MainRoomService {

	@Autowired
	private MainRoomRepository mainRoomRepository;

	public List<MainRoom> findAllByPeriodIdAndIsDisplay(String periodId, Integer isDisplay) {
		
		
		return mainRoomRepository.findAllByPeriodIdAndIsDisplay(periodId,isDisplay);
	}
}

package com.wyc.draw.service;
import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.DrawRoom;
import com.wyc.draw.repositories.DrawRoomRepository;

@Service
public class DrawRoomService {
	@Autowired
	private DrawRoomRepository drawRoomRepository;

	public DrawRoom add(DrawRoom drawRoom) {
		drawRoom.setUpdateAt(new DateTime());
		drawRoom.setCreateAt(new DateTime());
		drawRoom.setId(UUID.randomUUID().toString());
		
		return drawRoomRepository.save(drawRoom);
	}

	public DrawRoom findOne(String id) {
		return drawRoomRepository.findOne(id);
	}

	public List<DrawRoom> findAllByDrawUserId(String drawUserId) {
		return drawRoomRepository.findAllByDrawUserId(drawUserId);
	}

	public Page<DrawRoom> findAllByDrawUserId(String drawUserId, Pageable pageable) {
		return drawRoomRepository.findAllByDrawUserId(drawUserId,pageable);
	}

	public DrawRoom update(DrawRoom drawRoom) {
		
		drawRoom.setUpdateAt(new DateTime());	
		return drawRoomRepository.save(drawRoom);
		
	}

	public List<DrawRoom> findAllOfMainByPeriodId(String periodId) {
		return drawRoomRepository.findAllOfMainByPeriodId(periodId);
	}


}

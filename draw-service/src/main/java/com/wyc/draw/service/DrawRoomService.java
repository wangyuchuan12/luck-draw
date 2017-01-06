package com.wyc.draw.service;

import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
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
}

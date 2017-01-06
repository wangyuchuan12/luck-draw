package com.wyc.draw.service;

import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.DrawRoomMember;
import com.wyc.draw.repositories.DrawRoomMemberRepository;

@Service
public class DrawRoomMemberService {

	@Autowired
	private DrawRoomMemberRepository drawRoomMemberRepository;
	public DrawRoomMember add(DrawRoomMember drawRoomMember) {
		drawRoomMember.setId(UUID.randomUUID().toString());
		drawRoomMember.setUpdateAt(new DateTime());
		drawRoomMember.setCreateAt(new DateTime());
		return drawRoomMemberRepository.save(drawRoomMember);
	}

}

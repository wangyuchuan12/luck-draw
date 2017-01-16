package com.wyc.draw.service;

import java.util.List;
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
	public List<DrawRoomMember> findAllByDrawRoomIdAndStatusOrderByTakepartTimeAsc(String roomId,int status) {
		List<DrawRoomMember> drawRoomMembers = drawRoomMemberRepository.findAllByDrawRoomIdAndStatusOrderByTakepartTimeAsc(roomId,status);
		return drawRoomMembers;
	}
	public DrawRoomMember findByDrawUserIdAndDrawRoomId(String drawUserId,String drawRoomId) {
		return drawRoomMemberRepository.findByDrawUserIdAndDrawRoomId(drawUserId,drawRoomId);
	}
	public DrawRoomMember findOne(String id) {
		return drawRoomMemberRepository.findOne(id);
	}

}

package com.wyc.draw.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.DrawRoomMember;

public interface DrawRoomMemberRepository extends CrudRepository<DrawRoomMember, String>{

	List<DrawRoomMember> findAllByDrawRoomId(String roomId);

	List<DrawRoomMember> findAllByDrawRoomIdAndStatusOrderByTakepartTimeAsc(String roomId, int status);

	DrawRoomMember findByDrawUserIdAndDrawRoomId(String drawUserId, String drawRoomId);

}

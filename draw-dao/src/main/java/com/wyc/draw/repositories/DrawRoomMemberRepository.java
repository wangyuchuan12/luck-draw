package com.wyc.draw.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.wyc.draw.domain.DrawRoomMember;

public interface DrawRoomMemberRepository extends CrudRepository<DrawRoomMember, String>{

	List<DrawRoomMember> findAllByDrawRoomId(String roomId);

	List<DrawRoomMember> findAllByDrawRoomIdAndStatusOrderByTakepartTimeAsc(String roomId, int status);

	DrawRoomMember findByDrawUserIdAndDrawRoomId(String drawUserId, String drawRoomId);

	@Query("select count(*) from com.wyc.draw.domain.DrawRoomMember drm where drm.drawRoomId=:drawRoomId and drm.drawUserId=:drawUserId")
	int countByDrawRoomIdAndDrawUserId(@Param("drawRoomId")String drawRoomId, @Param("drawUserId")String drawUserId);

	DrawRoomMember findByDrawRoomIdAndDrawUserId(String roomId, String createDrawUserId);

}

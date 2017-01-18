package com.wyc.draw.repositories;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.wyc.draw.domain.DrawRoom;
import com.wyc.draw.domain.DrawRoomMember;

public interface DrawRoomRepository extends CrudRepository<DrawRoom, String>{

	@Query(value="from com.wyc.draw.domain.DrawRoom dr where dr.id in (select drawRoomId from com.wyc.draw.domain.DrawRoomMember drm where drm.drawUserId=:drawUserId and drm.status=1)")
	List<DrawRoom> findAllByDrawUserId(@Param("drawUserId")String drawUserId);

	@Query(value="from com.wyc.draw.domain.DrawRoom dr where dr.id in (select drawRoomId from com.wyc.draw.domain.DrawRoomMember drm where drm.drawUserId=:drawUserId and drm.status=1)")
	Page<DrawRoom> findAllByDrawUserId(@Param("drawUserId")String drawUserId, Pageable pageable);



}

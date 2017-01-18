package com.wyc.draw.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.RedPacket;

public interface RedPackageRepository extends CrudRepository<RedPacket, String>{

	Page<RedPacket> findAllByDrawRoomId(String roomId, Pageable pageable);

}

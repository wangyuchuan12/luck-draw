package com.wyc.draw.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.RedPacketToComent;

public interface RedPacketToComentRepository extends CrudRepository<RedPacketToComent, String>{

	RedPacketToComent findByRedPacketId(String redPacketId);

}

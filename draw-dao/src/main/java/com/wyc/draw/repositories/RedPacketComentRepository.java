package com.wyc.draw.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.RedPacketComent;

public interface RedPacketComentRepository extends CrudRepository<RedPacketComent, String>{

	List<RedPacketComent> findAllByComentDrawUserIdAndRedPacketId(String drawUserId, String redPacketId);

}

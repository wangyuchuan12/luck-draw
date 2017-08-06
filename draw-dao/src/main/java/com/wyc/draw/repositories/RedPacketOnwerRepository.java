package com.wyc.draw.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.RedPacketOwner;

public interface RedPacketOnwerRepository extends CrudRepository<RedPacketOwner, String>{

	public List<RedPacketOwner> findAll();

	public List<RedPacketOwner> findAllByDrawUserIdAndIsDel(String drawUserId, int isDel);
}

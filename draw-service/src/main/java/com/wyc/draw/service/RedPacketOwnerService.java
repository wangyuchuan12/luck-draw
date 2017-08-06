package com.wyc.draw.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.RedPacketOwner;
import com.wyc.draw.repositories.RedPacketOnwerRepository;

@Service
public class RedPacketOwnerService {

	@Autowired
	private RedPacketOnwerRepository redPacketOnwerRepository;

	public List<RedPacketOwner> findAllByDrawUserIdAndIsDel(String drawUserId, int isDel) {
		
		return redPacketOnwerRepository.findAllByDrawUserIdAndIsDel(drawUserId,isDel);
	}
}

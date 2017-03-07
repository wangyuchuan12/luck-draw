package com.wyc.draw.service;

import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.RedPacketComent;
import com.wyc.draw.repositories.RedPacketComentRepository;

@Service
public class RedPacketComentService {

	@Autowired
	private RedPacketComentRepository redPacketComentRepository;

	public RedPacketComent add(RedPacketComent redPacketComent) {
		redPacketComent.setId(UUID.randomUUID().toString());
		redPacketComent.setUpdateAt(new DateTime());
		redPacketComent.setCreateAt(new DateTime());
		return redPacketComentRepository.save(redPacketComent);
	}

	public List<RedPacketComent> findAllByComentDrawUserIdAndRedPacketId(String drawUserId, String redPacketId) {
		return redPacketComentRepository.findAllByComentDrawUserIdAndRedPacketId(drawUserId,redPacketId);
	}
}

package com.wyc.draw.service;

import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.RedPacketPrompt;
import com.wyc.draw.repositories.RedPacketPromptRepository;

@Service
public class RedPacketPromptService {
	
	@Autowired
	private RedPacketPromptRepository redPacketPromptRepository;

	public RedPacketPrompt add(RedPacketPrompt redPacketPrompt) {
		redPacketPrompt.setId(UUID.randomUUID().toString());
		redPacketPrompt.setUpdateAt(new DateTime());
		redPacketPrompt.setCreateAt(new DateTime());
		return redPacketPromptRepository.save(redPacketPrompt);
	}

	public List<RedPacketPrompt> findAllByRedPacketIdOrderByCreateAtAsc(String redPacketId) {
		return redPacketPromptRepository.findAllByRedPacketIdAndIsDelOrderByCreateAtAsc(redPacketId,0);
	}

	public RedPacketPrompt findOne(String id) {
		return redPacketPromptRepository.findOne(id);
	}

	public RedPacketPrompt update(RedPacketPrompt redPacketPrompt) {
		
		redPacketPrompt.setUpdateAt(new DateTime());
		return redPacketPromptRepository.save(redPacketPrompt);
		
	}
}

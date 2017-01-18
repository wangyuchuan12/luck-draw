package com.wyc.draw.service;

import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.RedPacketTakepartMember;
import com.wyc.draw.repositories.RedPacketTakepartMemberRepository;

@Service
public class RedPacketTakepartMemberService {

	@Autowired
	private RedPacketTakepartMemberRepository redPacketTakepartMemberRepository;
	public RedPacketTakepartMember add(RedPacketTakepartMember redPacketTakepartMember) {
		redPacketTakepartMember.setUpdateAt(new DateTime());
		redPacketTakepartMember.setCreateAt(new DateTime());
		redPacketTakepartMember.setId(UUID.randomUUID().toString());
		
		return redPacketTakepartMemberRepository.save(redPacketTakepartMember);
		
	}
	public int countByRedPacketIdAndDrawUserId(String redPacketId, String drawUserId) {
		
		return redPacketTakepartMemberRepository.countByRedPacketIdAndDrawUserId(redPacketId,drawUserId);
	}

}

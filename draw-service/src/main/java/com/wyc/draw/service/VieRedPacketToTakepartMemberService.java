package com.wyc.draw.service;

import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.RedPacketToTakepartMember;
import com.wyc.draw.repositories.VieRedPacketToTakepartMemberRepository;

@Service
public class VieRedPacketToTakepartMemberService {

	@Autowired
	private VieRedPacketToTakepartMemberRepository vieRedPacketToTakepartMemberRepository;

	public RedPacketToTakepartMember findByDrawUserIdAndRedPacketId(String drawUserId, String redPacketId) {
		return vieRedPacketToTakepartMemberRepository.findByDrawUserIdAndRedPacketId(drawUserId,redPacketId);
	}

	public void add(RedPacketToTakepartMember vieRedPacketToTakepartMember) {
		vieRedPacketToTakepartMember.setId(UUID.randomUUID().toString());
		vieRedPacketToTakepartMember.setUpdateAt(new DateTime());
		vieRedPacketToTakepartMember.setCreateAt(new DateTime());
		vieRedPacketToTakepartMemberRepository.save(vieRedPacketToTakepartMember);
		
	}

	public void update(RedPacketToTakepartMember vieRedPacketToTakepartMember) {
		vieRedPacketToTakepartMember.setUpdateAt(new DateTime());
		vieRedPacketToTakepartMemberRepository.save(vieRedPacketToTakepartMember);
		
	}
}

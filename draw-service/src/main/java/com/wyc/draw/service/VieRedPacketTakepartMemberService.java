package com.wyc.draw.service;

import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.VieRedPacketProblem;
import com.wyc.draw.domain.VieRedPacketTakepartMember;
import com.wyc.draw.repositories.VieRedPacketTakepartMemberRepository;

@Service
public class VieRedPacketTakepartMemberService {
	@Autowired
	private VieRedPacketTakepartMemberRepository vieRedPacketTakepartMemberRepository;

	public VieRedPacketTakepartMember findOne(String memberId) {
		return vieRedPacketTakepartMemberRepository.findOne(memberId);
	}

	public VieRedPacketTakepartMember add(VieRedPacketTakepartMember vieRedPacketTakepartMember) {
		
		vieRedPacketTakepartMember.setUpdateAt(new DateTime());
		vieRedPacketTakepartMember.setCreateAt(new DateTime());
		vieRedPacketTakepartMember.setId(UUID.randomUUID().toString());
		return vieRedPacketTakepartMemberRepository.save(vieRedPacketTakepartMember);
	}

	public VieRedPacketTakepartMember update(VieRedPacketTakepartMember vieRedPacketTakepartMember) {
		vieRedPacketTakepartMember.setUpdateAt(new DateTime());
		return vieRedPacketTakepartMemberRepository.save(vieRedPacketTakepartMember);
	}

	public List<VieRedPacketTakepartMember> findAllByRedPacketIdAndIsComplete(String redPacketId, int isComplete) {
		return vieRedPacketTakepartMemberRepository.findAllByRedPacketIdAndIsComplete(redPacketId,isComplete);
	}
}

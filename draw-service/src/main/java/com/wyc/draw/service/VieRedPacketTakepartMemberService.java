package com.wyc.draw.service;

import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.RedPacketTakepartMember;
import com.wyc.draw.repositories.RedPacketTakepartMemberRepository;


@Service
public class VieRedPacketTakepartMemberService {
	@Autowired
	private RedPacketTakepartMemberRepository redPacketTakepartMemberRepository;

	public RedPacketTakepartMember findOne(String memberId) {
		return redPacketTakepartMemberRepository.findOne(memberId);
	}

	public RedPacketTakepartMember add(RedPacketTakepartMember redPacketTakepartMember) {
		
		redPacketTakepartMember.setUpdateAt(new DateTime());
		redPacketTakepartMember.setCreateAt(new DateTime());
		redPacketTakepartMember.setId(UUID.randomUUID().toString());
		return redPacketTakepartMemberRepository.save(redPacketTakepartMember);
	}

	public RedPacketTakepartMember update(RedPacketTakepartMember redPacketTakepartMember) {
		redPacketTakepartMember.setUpdateAt(new DateTime());
		return redPacketTakepartMemberRepository.save(redPacketTakepartMember);
	}

	public List<RedPacketTakepartMember> findAllByRedPacketIdAndIsComplete(String redPacketId, int isComplete) {
		return redPacketTakepartMemberRepository.findAllByRedPacketIdAndIsComplete(redPacketId,isComplete);
	}

	public List<RedPacketTakepartMember> findByRedPacketIdAndDrawUserId(String redPacketId, String drawUserId) {
		return redPacketTakepartMemberRepository.findByRedPacketIdAndDrawUserId(redPacketId,drawUserId);
	}

	public Page<RedPacketTakepartMember> findAllByRedPacketIdAndIsComplete(String redPacketId, int isComplete,
			Pageable pageable) {
		return redPacketTakepartMemberRepository.findAllByRedPacketIdAndIsComplete(redPacketId,isComplete,pageable);
	}
	
	public List<RedPacketTakepartMember> findAllByRedPacketIdAndIsBest(String redPacketId, int isBest) {
		return redPacketTakepartMemberRepository.findAllByRedPacketIdAndIsBest(redPacketId,isBest);
	}
}

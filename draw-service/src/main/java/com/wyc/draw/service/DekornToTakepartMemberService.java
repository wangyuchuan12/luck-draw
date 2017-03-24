package com.wyc.draw.service;

import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.DekornToTakepartMember;
import com.wyc.draw.repositories.DekornToTakepartMemberRepository;

@Service
public class DekornToTakepartMemberService{

	@Autowired
	private DekornToTakepartMemberRepository dekornToTakepartMemberRepository;

	public DekornToTakepartMember findOneByDekornIdAndDrawUserId(String dekornId, String drawUserId) {
		return dekornToTakepartMemberRepository.findOneByDekornIdAndDrawUserId(dekornId,drawUserId);
	}

	public void add(DekornToTakepartMember dekornToTakepartMember) {
		dekornToTakepartMember.setUpdateAt(new DateTime());
		dekornToTakepartMember.setCreateAt(new DateTime());
		dekornToTakepartMember.setId(UUID.randomUUID().toString());
		dekornToTakepartMemberRepository.save(dekornToTakepartMember);
		
	}
}

package com.wyc.draw.service;

import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.DekornTakepartMember;
import com.wyc.draw.repositories.DekornTakepartMemberRepository;

@Service
public class DekornTakepartMemberService {

	@Autowired
	private DekornTakepartMemberRepository dekornTakepartMemberRepository;

	public void add(DekornTakepartMember dekornTakepartMember) {
		dekornTakepartMember.setUpdateAt(new DateTime());
		dekornTakepartMember.setCreateAt(new DateTime());
		dekornTakepartMember.setId(UUID.randomUUID().toString());
		
		dekornTakepartMemberRepository.save(dekornTakepartMember);
	}

	public DekornTakepartMember update(DekornTakepartMember dekornTakepartMember) {
		dekornTakepartMember.setUpdateAt(new DateTime());
		return dekornTakepartMemberRepository.save(dekornTakepartMember);
	}
}

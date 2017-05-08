package com.wyc.draw.service;

import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wyc.draw.domain.DekornTakepartMember;
import com.wyc.draw.repositories.DekornTakepartMemberRepository;
import com.wyc.draw.vo.DekornTakepartMemberVo;

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
	
	public Long rankOfTakepartMember(String id){
		return dekornTakepartMemberRepository.rankOfTakepartMember(id);
	}

	public DekornTakepartMember update(DekornTakepartMember dekornTakepartMember) {
		dekornTakepartMember.setUpdateAt(new DateTime());
		return dekornTakepartMemberRepository.save(dekornTakepartMember);
	}

	public DekornTakepartMember findOne(String id) {
		return dekornTakepartMemberRepository.findOne(id);
	}
	
	public List<DekornTakepartMember> findAllByDekornId(String dekornId,Pageable pageable){
		return dekornTakepartMemberRepository.findAllByDekornId(dekornId,pageable);
	}
}

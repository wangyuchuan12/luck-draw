package com.wyc.draw.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.VieRedPacketTakepartMember;

public interface VieRedPacketTakepartMemberRepository extends CrudRepository<VieRedPacketTakepartMember, String>{

	List<VieRedPacketTakepartMember> findAllByRedPacketIdAndIsComplete(String redPacketId, int isComplete);

}

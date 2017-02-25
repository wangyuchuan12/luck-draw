package com.wyc.draw.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.VieRedPacketToTakepartMember;

public interface VieRedPacketToTakepartMemberRepository extends CrudRepository<VieRedPacketToTakepartMember, String>{

	VieRedPacketToTakepartMember findByDrawUserIdAndRedPacketId(String drawUserId, String redPacketId);

}

package com.wyc.draw.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wyc.draw.domain.RedPacketToTakepartMember;

public interface VieRedPacketToTakepartMemberRepository extends CrudRepository<RedPacketToTakepartMember, String>{

	RedPacketToTakepartMember findByDrawUserIdAndRedPacketId(String drawUserId, String redPacketId);

}

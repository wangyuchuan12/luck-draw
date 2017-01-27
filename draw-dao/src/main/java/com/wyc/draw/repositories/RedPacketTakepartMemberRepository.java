package com.wyc.draw.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.wyc.draw.domain.RedPacketTakepartMember;

public interface RedPacketTakepartMemberRepository extends CrudRepository<RedPacketTakepartMember, String>{

	@Query("select count(*) from com.wyc.draw.domain.RedPacketTakepartMember rtm where rtm.redPacketId = :redPacketId and rtm.drawUserId = :drawUserId")
	int countByRedPacketIdAndDrawUserId(@Param("redPacketId")String redPacketId, @Param("drawUserId")String drawUserId);

	Page<RedPacketTakepartMember> findAllByRedPacketId(String redpacketId, Pageable pageable);

	RedPacketTakepartMember findByRedPacketIdAndDrawUserId(String redPacketId, String drawUserId);

}

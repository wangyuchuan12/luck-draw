package com.wyc.draw.repositories;

import java.util.List;

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

	List<RedPacketTakepartMember> findByRedPacketIdAndDrawUserId(String redPacketId, String drawUserId);

	List<RedPacketTakepartMember> findAllByRedPacketIdAndIsComplete(String redPacketId, int isComplete);

	Page<RedPacketTakepartMember> findAllByRedPacketIdAndIsComplete(String redPacketId, int isComplete,
			Pageable pageable);

	RedPacketTakepartMember findByOutTradeNo(String outTradeNo);

	List<RedPacketTakepartMember> findAllByRedPacketIdAndIsBest(String redPacketId, int isBest);

}
